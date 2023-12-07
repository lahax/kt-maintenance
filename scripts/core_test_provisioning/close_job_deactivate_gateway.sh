#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm thingId jobId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
thingId=$3 #"eig-ep37-00"
jobId=$4
certs="./certs" # folder containing new certificates

CA="${certs}/${thingId}.pem"
CERT="${certs}/${thingId}.crt"
KEY="${certs}/${thingId}.key"

echo "setting job status to succeeded..."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -q 1 -p 8883 -t "\$aws/things/${environmentPrefix}_${thingId}/jobs/${jobId}/update" -i "${environmentPrefix}_${thingId}" -m "{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" , \"step\": \"deactivation succeeded\"  } }" -d                                                                                                                                                                             
