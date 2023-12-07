#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId payloadPath

iotHost=$1
environmentPrefix=$2
gatewayId=$3
topic="${environmentPrefix}/${gatewayId}/sw-update"
thingId=$4
payloadPath=$5
certs="./certs" # folder containing new certificates
 
alignSWPayload=`cat $payloadPath`
 
echo "Align Payload: $alignSWPayload"
echo ""

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"

echo "setting job status to succeeded..."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t ${topic} -m "$alignSWPayload" -d