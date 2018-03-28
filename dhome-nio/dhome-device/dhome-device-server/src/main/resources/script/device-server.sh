#!/bin/sh
# ------------------------------------------------------------------------
# CONFIGURATION

SMART_HOME=/dhome/device-run
# Set default classpath
SMART_CLASSPATH="${SMART_HOME}/lib"
SMART_MAINCLASS="com.cmcc.dhome.device.server.run.DeviceServerRun"
SMART_USER=""
SMART_NAME="Device-Server"
SMART_PIDFILE="$SMART_HOME/$SMART_NAME.pid"
SMART_STOP_PIDFILE="$SMART_HOME/$SMART_NAME-stop.pid"
# 使用G1收集器时，不要明确设置年轻代大小 ，因为固定年轻代的大小会覆盖暂停时间目标(默认-XX:MaxGCPauseMillis=200)
SMART_OPTS_MEMORY="-server -Xms4096m -Xmx4096m -XX:PermSize=128M -XX:MaxPermSize=128m -Xss1m -XX:+AggressiveOpts -XX:MaxTenuringThreshold=30 -XX:+DisableExplicitGC -XX:+UseG1GC -XX:MaxGCPauseMillis=500 -XX:G1ReservePercent=20 -XX:ConcGCThreads=2 -Ddruid.registerToSysProperty=true"

# Backup invocation parameters
COMMANDLINE_ARGS="$@"


setCurrentUser(){
   CUSER=`whoami 2>/dev/null`

   # Solaris fix
   if [ ! $? -eq 0 ]; then
      CUSER=`/usr/ucb/whoami 2>/dev/null`
   fi
}

# Location of the java installation
# Specify the location of your java installation using JAVA_HOME, or specify the
# path to the "java" binary using JAVACMD
# (set JAVACMD to "auto" for automatic detection)
#JAVA_HOME=""
JAVACMD="auto"


# Set jvm jmx configuration
# This enables jmx access over a configured jmx-tcp-port.
# You have to configure the first four settings if you run a ibm jvm, caused by the
# fact that IBM's jvm does not support VirtualMachine.attach(PID).
# JMX access is needed for quering a running smart instance to gain data or to
# trigger management operations.
#
# Example for ${SMART_CONF}/jmx.access:
# ---
# # The "monitorRole" role has readonly access.
# # The "controlRole" role has readwrite access.
# monitorRole readonly
# controlRole readwrite
# ---
#
# Example for ${SMART_CONF}/jmx.password:
# ---
# # The "monitorRole" role has password "abc123".
# # # The "controlRole" role has password "abcd1234".
# monitorRole abc123
# controlRole abcd1234
# ---
#
# SMART_SUNJMX_START="-Dcom.sun.management.jmxremote.port=11099 "
# SMART_SUNJMX_START="$SMART_SUNJMX_START -Dcom.sun.management.jmxremote.password.file=${SMART_CONF}/jmx.password"
# SMART_SUNJMX_START="$SMART_SUNJMX_START -Dcom.sun.management.jmxremote.access.file=${SMART_CONF}/jmx.access"
# SMART_SUNJMX_START="$SMART_SUNJMX_START -Dcom.sun.management.jmxremote.ssl=false"
SMART_SUNJMX_START="$SMART_SUNJMX_START -Dcom.sun.management.jmxremote"

# Set jvm jmx configuration for controlling the broker process
# You only have to configure the first four settings if you run a ibm jvm, caused by the
# fact that IBM's jvm does not support VirtualMachine.attach(PID)
# (see also com.sun.management.jmxremote.port, .jmx.password.file and .jmx.access.file )
#SMART_SUNJMX_CONTROL="--jmxurl service:jmx:rmi:///jndi/rmi://127.0.0.1:1099/jmxrmi --jmxuser controlRole --jmxpassword abcd1234"
SMART_SUNJMX_CONTROL=""

# Set additional JSE arguments
SMART_SSL_OPTS="$SSL_OPTS"

# SMART tries to shutdown the broker by jmx,
# after a specified number of seconds send SIGKILL
if [ -z "$SMART_KILL_MAXSECONDS" ]; then
    SMART_KILL_MAXSECONDS=3
fi

## END:DEFAULTCONFIG

# ------------------------------------------------------------------------
# LOAD CONFIGURATION

if [ -z "$SMART_OPTS" ] ; then
    SMART_OPTS="$SMART_OPTS_MEMORY"
fi

if [ -e "$SMART_TINGYUN_LIB" ] ; then
    SMART_OPTS="$SMART_OPTS -javaagent:$SMART_TINGYUN_LIB"
fi

SMART_OPTS="$SMART_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:+AggressiveOpts -XX:+UseBiasedLocking"
SMART_OPTS="$SMART_OPTS -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:FlightRecorderOptions=defaultrecording=true"

# ------------------------------------------------------------------------
# OS SPECIFIC SUPPORT

OSTYPE="unknown"

case "`uname`" in
  CYGWIN*) OSTYPE="cygwin" ;;
  Darwin*) OSTYPE="darwin" ;;
esac

# didn't support Cygwin
if [ "$OSTYPE" = "cygwin" ] || [ "$OSTYPE" = "darwin" ] ; then
  echo "ERROR: Unsupport OS!"
  exit 1
fi

# Detect the location of the java binary
if [ -z "$JAVACMD" ] || [ "$JAVACMD" = "auto" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  fi
fi

# Hm, we still do not know the location of the java binary
if [ ! -x "$JAVACMD" ] ; then
    JAVACMD=`which java 2> /dev/null `
    if [ -z "$JAVACMD" ] ; then
        JAVACMD=java
    fi
fi
# Stop here if no java installation is defined/found
if [ ! -x "$JAVACMD" ] ; then
  echo "ERROR: Configuration variable JAVA_HOME or JAVACMD is not defined correctly."
  echo "       (JAVA_HOME='$JAVAHOME', JAVACMD='$JAVACMD')"
  exit 1
fi

echo "INFO: Using java '$JAVACMD'"


# Start the SMART JAR
#
#
# @ARG1 : the name of the PID-file
#         If specified, this function starts the java process in background as a daemon
#         and stores the pid of the created process in the file.
#         Output on stdout/stderr will be supressed if this parameter is specified
# @RET  : If unless 0 something went wrong
#
# Note: This function uses a lot of globally defined variables
# - if $SMART_USER is set, the function tries starts the java process whith the specified
#   user
invokeJar(){
   PIDFILE="$1"
   RET="1"

   if [ ! -f "${SMART_HOME}/bin/startup.jar" ];then
    echo "ERROR: '${SMART_HOME}/bin/startup.jar' does not exist"
    exit 1
   fi

   setCurrentUser

   if ( [ -z "$SMART_USER" ] || [ "$SMART_USER" = "$CUSER" ] );then
      DOIT_PREFIX="sh -c "
      DOIT_POSTFIX=";"
   elif [ "`id -u`" = "0" ];then
      DOIT_PREFIX="su -c "
      DOIT_POSTFIX=" - $SMART_USER"
      echo "INFO: changing to user '$SMART_USER' to invoke java"
   fi

   # Execute java binary
   if [ -n "$PIDFILE" ] && [ "$PIDFILE" != "stop" ];then
      $DOIT_PREFIX "$JAVACMD $SMART_OPTS \
              -Dsmart.classpath=\"${SMART_CLASSPATH}\" \
              -Dsmart.home=\"${SMART_HOME}\" \
              -jar \"${SMART_HOME}/bin/startup.jar\" $COMMANDLINE_ARGS &
              RET=\"\$?\"; APID=\"\$!\";
              echo \$APID > $PIDFILE;
              echo \"INFO: pidfile created : '$PIDFILE' (pid '\$APID')\";exit \$RET" $DOIT_POSTFIX
      RET="$?"
   elif [ -n "$PIDFILE" ] && [ "$PIDFILE" = "stop" ];then
      PID=`cat $SMART_PIDFILE`
#      $DOIT_PREFIX "$JAVACMD $SMART_OPTS \
#              -Dsmart.classpath=\"${SMART_CLASSPATH}\" \
#              -Dsmart.home=\"${SMART_HOME}\" \
#              -jar \"${SMART_HOME}/bin/startup.jar\" $COMMANDLINE_ARGS --pid $PID &
#              RET=\"\$?\"; APID=\"\$!\";
#              echo \$APID > $$SMART_STOP_PIDFILE; exit \$RET" $DOIT_POSTFIX
      RET="$?"
   else
      $DOIT_PREFIX "$JAVACMD $SMART_OPTS \
              -Dsmart.classpath=\"${SMART_CLASSPATH}\" \
              -Dsmart.home=\"${SMART_HOME}\" \
              -jar \"${SMART_HOME}/bin/startup.jar\" $COMMANDLINE_ARGS" $DOIT_POSTFIX
      RET="$?"
   fi
   return $RET
}

# Check if SMART is running
#
# @RET  : 0 => the smart process is running
#         1 => process id in $SMART_PIDFILE does not exist anymore
#         2 => something is wrong with the pid file
#
# Note: This function uses globally defined variables
# - $SMART_PIDFILE : the name of the pid file

checkRunning(){
    if [ -f "$SMART_PIDFILE" ]; then
       if  [ -z "`cat $SMART_PIDFILE`" ];then
        echo "ERROR: Pidfile '$SMART_PIDFILE' exists but contains no pid"
        return 2
       fi
       PID=`cat $SMART_PIDFILE`
       RET=`ps -p $PID|grep java`
       if [ -n "$RET" ];then
         return 0;
       else
         return 1;
       fi
    else
         return 1;
    fi
}

checkStopRunning(){
    PID=$SMART_STOP_PIDFILE
    if [ -f "$PID" ]; then
       if  [ -z "`cat $PID`" ];then
        echo "ERROR: Pidfile '$PID' exists but contains no pid"
        return 2
       fi
       THEPID=`cat $PID`
       RET=`ps -p $THEPID|grep java`
       if [ -n "$RET" ];then
         return 0;
       else
         return 1;
       fi
    else
         return 1;
    fi
}

# Check if SMART is running
#
# @RET  : 0 => the smart process is running
#         1 => the smart process is not running
#
# Note: This function uses globally defined variables
# - $SMART_PIDFILE : the name of the pid file

invoke_status(){
    if ( checkRunning );then
         PID=`cat $SMART_PIDFILE`
         echo "SMART is running (pid '$PID')"
         exit 0
    fi
    echo "SMART not running"
    exit 1
}

# Start SMART if not already running
#
# @RET  : 0 => is now started, is already started
#         !0 => something went wrong
#
# Note: This function uses globally defined variables
# - $SMART_PIDFILE      : the name of the pid file
# - $SMART_OPTS         : Additional options
# - $SMART_SUNJMX_START : options for JMX settings
# - $SMART_SSL_OPTS     : options for SSL encryption

invoke_start(){
    if ( checkRunning );then
      PID=`cat $SMART_PIDFILE`
      echo "INFO: Process with pid '$PID' is already running"
      exit 0
    fi

    SMART_OPTS="$SMART_OPTS $SMART_SUNJMX_START $SMART_SSL_OPTS -Djava.awt.headless=true"
    COMMANDLINE_ARGS="$SMART_MAINCLASS $COMMANDLINE_ARGS"
    invokeJar $SMART_PIDFILE
    exit "$?"
}

# Start SMART in foreground (for debugging)
#
# @RET  : 0 => is now started, is already started
#         !0 => something went wrong
#
# Note: This function uses globally defined variables
# - $SMART_PIDFILE      : the name of the pid file
# - $SMART_OPTS         : Additional options
# - $SMART_SUNJMX_START : options for JMX settings
# - $SMART_SSL_OPTS     : options for SSL encryption

invoke_console(){
    if ( checkRunning );then
      echo "ERROR: SMART is already running"
      exit 1
    fi

    SMART_OPTS="$SMART_OPTS $SMART_SUNJMX_START $SMART_SSL_OPTS -Djava.awt.headless=true"

    COMMANDLINE_ARGS="start `echo $COMMANDLINE_ARGS|sed 's,^console,,'`"
    echo "INFO: Starting in foreground, this is just for debugging purposes (stop process by pressing CTRL+C)"
    invokeJar
    exit "$?"
}

# Stop SMART
#
# @RET  : 0 => stop was successful
#         !0 => something went wrong
#
# Note: This function uses globally defined variables
# - $SMART_PIDFILE         : the name of the pid file
# - $SMART_KILL_MAXSECONDS : the number of seconds to wait for termination of broker after sending
#                              shutdown signal by jmx interface

invoke_stop(){
    RET="1"
    if ( checkRunning );then
       SMART_OPTS="$SMART_OPTS $SMART_SSL_OPTS"
       COMMANDLINE_ARGS="$SMART_MAINCLASS $COMMANDLINE_ARGS"
       invokeJar "stop"
       RET="$?"
       PID=`cat $SMART_PIDFILE`
       echo "INFO: Waiting at least $SMART_KILL_MAXSECONDS seconds for regular process termination of pid '$PID' : "
       FOUND="0"
       i=1
       while [ $i != $SMART_KILL_MAXSECONDS ]; do

         if [ ! checkStopRunning ];then
            if [ ! checkRunning ]; then
               echo " FINISHED"
               FOUND="1"
            fi
            break
         fi

         if (checkRunning);then
            sleep 1
            printf  "."
         else
            echo " FINISHED"
            FOUND="1"
            break
         fi
         i=`expr $i + 1`
       done
       if [ "$FOUND" -ne "1" ];then
         echo
         echo "INFO: Regular shutdown not successful,  sending SIGKILL to process with pid '$PID'"
         kill -KILL $PID
         RET="1"
       fi
    elif [ -f "$SMART_PIDFILE" ];then
       echo "ERROR: No or outdated process id in '$SMART_PIDFILE'"
       echo
       echo "INFO: Removing $SMART_PIDFILE"
    else
       echo "SMART not running"
       exit 0
    fi
    rm -f $SMART_PIDFILE >/dev/null 2>&1
    rm -f $SMART_STOP_PIDFILE >/dev/null 2>&1
    exit $RET
}

# Invoke a task on a running SMART instance
#
# @RET  : 0 => successful
#         !0 => something went wrong
#
# Note: This function uses globally defined variables
# - $SMART_OPTS            : Additional options
# - $SMART_SUNJMX_START    : options for JMX settings
# - $SMART_SSL_OPTS        : options for SSL encryption
invoke_task(){
    # call task in java binary
    if ( checkRunning );then
      if [ "$1" = "browse" ] ;then
         SMART_OPTS="$SMART_OPTS $SMART_SSL_OPTS"
         COMMANDLINE_ARGS="$1 `echo $COMMANDLINE_ARGS|sed 's,^browse,,'`"
      elif [ "$1" = "query" ] ;then
         SMART_OPTS="$SMART_OPTS $SMART_SSL_OPTS"
         COMMANDLINE_ARGS="$1 $SMART_SUNJMX_CONTROL `echo $COMMANDLINE_ARGS|sed 's,^query,,'`"
      else
         SMART_OPTS="$SMART_OPTS $SMART_SSL_OPTS"
         COMMANDLINE_ARGS="$COMMANDLINE_ARGS $SMART_SUNJMX_CONTROL"
      fi
      invokeJar
      exit $?
    else
      invokeJar
      exit 1
    fi
}

show_help() {
  invokeJar
  RET="$?"
  cat << EOF
Tasks provided by the sysv init script:
    restart         - stop running instance (if there is one), start new instance
    console         - start broker in foreground, useful for debugging purposes
    status          - check if smart process is running
    setup           - create the specified configuration file for this init script
                      (see next usage section)

Configuration of this script:
    The configuration of this script can be placed on /etc/default/smart or $HOME/.smartrc.
    To use additional configurations for running multiple instances on the same operating system
    rename or symlink script to a name matching to smart-instance-<INSTANCENAME>.
    This changes the configuration location to /etc/default/smart-instance-<INSTANCENAME> and
    \$HOME/.smartrc-instance-<INSTANCENAME>. Configuration files in /etc have higher precedence.
EOF
  exit $RET
}

# ------------------------------------------------------------------------
# MAIN

# show help
if [ -z "$1" ];then
 show_help
fi

case "$1" in
  status)
      invoke_status
    ;;
#  restart)
#    if ( checkRunning );then
#      $0 stop
#    fi
#    $0 status
#    $0 start
#    $0 status
#    ;;
  start)
    invoke_start
    ;;
#  console)
#    invoke_console
#    ;;
  stop)
    invoke_stop
#    ;;
#  *)
#    invoke_task
esac
