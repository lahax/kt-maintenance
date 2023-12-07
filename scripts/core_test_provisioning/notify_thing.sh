#!/usr/bin/env bash
set -xe
# Usage: ${SCRIPT_NAME} iotHost apm gatewayId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
gatewayId=$3 #"eig-ep37-00"
thingId=$4
certs="./certs" # folder containing new certificates

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}_${thingId}.crt"
KEY="${certs}/${gatewayId}_${thingId}.key"

echo ""

echo "Listening to topic '${environmentPrefix}/${gatewayId}_${thingId}/command/inbound' to receive command notify..."
echo ""
mosquitto_sub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -q 1 -p 8883 -t "${environmentPrefix}/${gatewayId}/${thingId}/command/inbound" -i "${environmentPrefix}_${gatewayId}_${thingId}" -d

