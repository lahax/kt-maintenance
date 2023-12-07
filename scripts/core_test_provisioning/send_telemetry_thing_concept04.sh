#!/usr/bin/env bash

repetition=${1:-1}
for (( i=0; i<${repetition}; i++ ))
do
    echo "publish " ${i}

IOT_HOST=ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com #insert the AWS IoT endpoint, according to the test environment
PRJ_ID=esol_ap29551_qa #insert the APM used for tests
DEVICE_TYPE=GENERIC
THING_ID=Test_Concept-04_thing2 # insert the thing ID used for tests
CA=./certs/Test_Concept-04.pem #update the path according to the certificates position
CERT=./certs/Test_Concept-04.crt #update the path according to the certificates position
KEY=./certs/Test_Concept-04.key #update the path according to the certificates position
mosquitto_pub  -h $IOT_HOST -p 8883 -t esol_ap29551_qa/Test_Concept-04/mqtts/Test_Concept-04_thing2/data --cert $CERT --cafile $CA --key $KEY  -d -i 'esol_ap29551_qa_Test_Concept-04_thing2' -q 1 -f ./payload_telemetry_test_concept_04.txt
sleep 1
done