eval $(LC_ALL=C ifconfig|grep "inet addr:"|grep -v "127.0.0.1"|cut -d: -f2|awk '{printf("var=%s;"),$1}')
tail -f /opt/logs/deviceserver/device-server-$var.log
