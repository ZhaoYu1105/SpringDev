@echo off

if "%OS%" == "Windows_NT" @setlocal

title ====deviceclient====

set DEFAULT_SMART_HOME=%~dp0..
rem echo %DEFAULT_SMART_HOME%

if "%SMART_HOME%" == "" set SMART_HOME=%DEFAULT_SMART_HOME%
set DEFAULT_SMART_HOME=
goto checkJava

:checkJava
set _JAVACMD=%JAVACMD%

if "%JAVA_HOME%" == ""  goto noJavaHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
if "%_JAVACMD%" == "" set _JAVACMD=%JAVA_HOME%\bin\java.exe
goto runAnt

:noJavaHome
echo %JAVA_HOME%
echo not found java home.

:runAnt
if "%SMART_BASE%" == "" set SMART_BASE=%SMART_HOME%
if "%SMART_CLASSPATH%" == "" set SMART_CLASSPATH=%SMART_HOME%\lib

if "%DEFAULT_OPTS%" == "" set DEFAULT_OPTS=-server -Xms1024m -Xmx1024m -XX:NewSize=600m -XX:MaxNewSize=600m -XX:PermSize=128M -XX:MaxPermSize=128m -XX:+UseG1GC -Ddruid.registerToSysProperty=true 
set DEFAULT_OPTS=%DEFAULT_OPTS% -XX:+HeapDumpOnOutOfMemoryError -XX:+AggressiveOpts -XX:+UseBiasedLocking
set DEFAULT_OPTS=%DEFAULT_OPTS% -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:FlightRecorderOptions=defaultrecording=true

set DEFAULT_STARTUP_CLASS="com.cmcc.dhome.device.server.run.DeviceClientRun"
set DEFAULT_ARGS=%DEFAULT_STARTUP_CLASS% start
"%_JAVACMD%" %DEFAULT_OPTS% -Dsmart.home="%SMART_HOME%" -Dsmart.classpath="%SMART_CLASSPATH%" -jar "%SMART_HOME%/bin/startup.jar" %DEFAULT_ARGS% %*

goto end

:end
if "%OS%"=="Windows_NT" @endlocal