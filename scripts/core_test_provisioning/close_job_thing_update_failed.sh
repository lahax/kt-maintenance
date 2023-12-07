#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm thingId jobId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
gatewayId=$3
thingId=$4 #"eig-ep37-00"
jobId=$5
certs="./certs" # folder containing new certificates

CA="${certs}/$gatewayId.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"

echo "setting job status to succeeded..."

mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -q 1 -p 8883 -t "\$aws/things/${environmentPrefix}_${gatewayId}/jobs/${jobId}/update" -i "${environmentPrefix}_${gatewayId}" -m "{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" , \"step\": \"command succeeded\", \"install_status\": \"failed_install\",\"thing_sw\": \"firmware-upgrade-ocpp:1.0\" } }" -d