#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId payloadPath

iotHost=$1
environmentPrefix=$2 #"esol_ap29551_qa"
# env=${environmentPrefix##*_}
# iotHost=${HOST[$env]}
#echo "env:${env},iotHost: ${iotHost}"
gatewayId=$3 #"eig-ep37-00"
thingId=$4
payloadPath=$5 #./payload_jobs.txt
certs="./certs" # folder containing new certificates

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}_${thingId}.crt"
KEY="${certs}/${gatewayId}_${thingId}.key"

echo $CERT

# Prepare Registration Payload
registrationPayload=`cat $payloadPath`
registrationPayload=${registrationPayload//\$gatewayId/$gatewayId}
registrationPayload=${registrationPayload/\$thingId/$thingId}
registrationPayload=${registrationPayload/\$environmentPrefix/$environmentPrefix}


echo "Registration Payload: $registrationPayload"
echo ""

echo "Register certificate.."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d

echo "Register thing.."
sleep 5s
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d
echo "End Registration"