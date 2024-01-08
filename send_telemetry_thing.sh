#!/usr/bin/env bash

repetition=${1:-1}
for (( i=0; i<${repetition}; i++ ))
do
    echo "publish " ${i}

IOT_HOST=ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com #insert the AWS IoT endpoint, according to the test environment
PRJ_ID=esol_ap29551_qa #insert the APM used for tests
DEVICE_TYPE=GENERIC
THING_ID=GatewayDMC9_thing1 # insert the thing ID used for tests
CA=./certs/GatewayDMC4.pem #update the path according to the certificates position
CERT=./certs/GatewayDMC4.crt #update the path according to the certificates position
KEY=./certs/GatewayDMC4.key #update the path according to the certificates position


mosquitto_pub  -h $IOT_HOST -p 8883 -t esol_ap29551_qa/GatewayDMC9/mqtts/GatewayDMC9_thing1/data --cert $CERT --cafile $CA --key $KEY  -d -i 'esol_ap29551_qa_GatewayDMC9_thing1' -q 1 -f ./payload_telemetry.json
sleep 1
done