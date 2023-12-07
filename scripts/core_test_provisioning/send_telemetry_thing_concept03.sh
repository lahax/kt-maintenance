#!/usr/bin/env bash

repetition=${1:-1}
for (( i=0; i<${repetition}; i++ ))
do
    echo "publish " ${i}

IOT_HOST=ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com
PRJ_ID=esol_ap29551_qa
DEVICE_TYPE=GENERIC
THING_ID=Test_Concept-03_thing1
CA=./certs/Test_Concept-03.pem
CERT=./certs/Test_Concept-03.crt
KEY=./certs/Test_Concept-03.key

#mosquitto_pub -h $IOT_HOST -p 8883 -t $PRJ_ID/eigcu/mqtt/$THING_ID/data --cert $CERT --cafile $CA --key $KEY  -d -i 'esol_ap29551_dev_ep47_direct_thing1' -q 1 -f ./payload_telemetry.json
mosquitto_pub  -h $IOT_HOST -p 8883 -t esol_ap29551_qa/Test_Concept-03/mqtts/Test_Concept-03_thing1/data --cert $CERT --cafile $CA --key $KEY  -d -i 'esol_ap29551_qa_Test_Concept-03_thing1' -q 1 -f ./payload_telemetry_concept03.json
sleep 1
done



