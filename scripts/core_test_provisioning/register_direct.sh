#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm thingId payloadPath

iotHost=$1
environmentPrefix=$2 #"esol_ap29551_qa"
thingId=$3 #"eig-ep37-00"
payloadPath=$4 #./payload_jobs.txt
certs="./certs" # folder containing new certificates

CA="${certs}/${thingId}.pem"
CERT="${certs}/${thingId}.crt"
KEY="${certs}/${thingId}.key"

# Prepare Registration Payload
registrationPayload=`cat $payloadPath`
registrationPayload=${registrationPayload/\$thingId/$thingId}
registrationPayload=${registrationPayload/\$environmentPrefix/$environmentPrefix}


echo "Registration Payload: $registrationPayload"
echo ""

echo "Register certificate.."
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d

echo "Register direct thing.."
sleep 5s
mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -q 1 -t "devices/registration" -m "$registrationPayload" -d