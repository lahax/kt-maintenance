#!/usr/bin/env bash
# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId payloadPath
iotHost=$1
environmentPrefix=$2
gatewayId=$3
topic="${environmentPrefix}/${gatewayId}/gw-firmwareupdatecompletion"
payloadPath=$4
certs="./certs"
FWCompletionPayload=`cat $payloadPath`
echo "$FWCompletionPayload"

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"

echo "setting job status to succeeded..."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t ${topic} -m "$FWCompletionPayload" -d