#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId payloadPath

iotHost=$1
environmentPrefix=$2
gatewayId=$3
thingId=$4
topic="${environmentPrefix}/${gatewayId}/gw-firmwareupdatecompletion"
jobId=$5
payloadPath=$6
certs="./certs"

FWCompletionPayload=`cat $payloadPath`

echo "$FWCompletionPayload"

echo "{\"status\":\"SUCCEEDED\",\"commandId\":\"$jobId\",\"statusDetails\":{\"environment_prefix\":\"$environmentPrefix\",\"thing_id\":\"$gatewayId_$thingId\",\"install_status\":\"complete_install\",\"thing_sw\":\"ocpp_app:1.0\",\"custom_status\":\"Installed\"}}"

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"

echo "setting job status to succeeded..."
#mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t ${topic} -m "$FWCompletionPayload" -d

mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t ${topic} -m "{\"status\":\"SUCCEEDED\",\"commandId\":\"$jobId\",\"statusDetails\":{\"environment_prefix\":\"$environmentPrefix\",\"thing_id\":\"$gatewayId_$thingId\",\"install_status\":\"complete_install\",\"thing_sw\":\"firmware-upgrade-ocpp:1.0\",\"custom_status\":\"Installed\"}}" -d