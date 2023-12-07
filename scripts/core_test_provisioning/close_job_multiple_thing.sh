#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId jobId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
gatewayId=$3 #"eig-ep37-00"
#thingId=$4
jobId=$4
certs="./certs" # folder containing new certificates

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"


echo "setting job status to succeeded..."
#echo "{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" ,\"step\": \"log manager activated\",\"core-status\": \"success\", \"thing-success\": \"${gatewayId}_${thingId}\" } }"                                                                                                                                                                                                                                                    
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -q 1 -p 8883 -t "\$aws/things/${environmentPrefix}_${gatewayId}/jobs/${jobId}/update" -i "${environmentPrefix}_${gatewayId}" -m "{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" ,\"step\": \"log manager activated\",\"core-status\": \"success\", \"thing-success\": \"${gatewayId}_thing1,${gatewayId}_thing2,${gatewayId}_thing3\" } }" -d                                                                                                                                                                             
