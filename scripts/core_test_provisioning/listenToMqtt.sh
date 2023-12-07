#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm thingId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
thingId=$3 #"eig-ep37-00"
certs="./certs" # folder containing new certificates

CA="${certs}/${thingId}.pem"
CERT="${certs}/${thingId}.crt"
KEY="${certs}/${thingId}.key"

echo ""
echo "Listening to topic '${environmentPrefix}/${thingId}/mqtts/#' to receive message notification..."
echo ""
mosquitto_sub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t "${environmentPrefix}/${thingId}/mqtts/#" -i "${environmentPrefix}_${thingId}_MQTT" -d