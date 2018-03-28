set -m
./stop_deviceserver.sh
echo "sleep 5s"
sleep 5
./start_deviceserver.sh
./log_deviceserver.log