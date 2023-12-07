#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId payloadPath

iotHost=$1
environmentPrefix=$2 #"esol_ap29551_qa"
gatewayId=$3 #"eig-ep37-00"
payloadPath=$4 #./payload_jobs.txt
certs="./certs" # folder containing new certificates

CA="${certs}/${gatewayId}.pem"
CERT="${certs}/${gatewayId}.crt"
KEY="${certs}/${gatewayId}.key"

# Prepare Registration Payload
registrationPayload=`cat $payloadPath`
registrationPayload=${registrationPayload/\$gatewayId/$gatewayId}
registrationPayload=${registrationPayload/\$environmentPrefix/$environmentPrefix}


echo "Registration Payload: $registrationPayload"
echo ""

echo "Register certificate.."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d

echo "Register device.."
sleep 5s
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d