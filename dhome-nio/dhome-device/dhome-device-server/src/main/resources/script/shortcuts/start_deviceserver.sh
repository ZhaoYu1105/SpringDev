set -m
cd device-run/bin
echo "Device Server Starting..."
nohup ./device-server.sh start > device-server.out 2>&1 &
../../log_deviceserver.sh

