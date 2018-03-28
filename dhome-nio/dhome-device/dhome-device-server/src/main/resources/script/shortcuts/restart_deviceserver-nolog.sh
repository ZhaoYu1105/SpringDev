set -m
./stop_deviceserver.sh
echo "sleep 5s"
sleep 5
./start_deviceserver-nolog.sh
