#!/usr/bin/env bash

echo $1
echo $2
echo $3
echo $4
echo $5
echo $6
echo $7
echo $8



#mosquitto_sub  -h $1 -p 8883 -t $2 --cert $3 --cafile $4 --key $5 $6 $7 -v >> listener_result.txt

mosquitto_pub -h $1 -p 8883 -t $2 --cert $3 --cafile $4 --key $5  -d $6 $7 -q 1 $8 $9 >> result.txt

#chiamando questo script bisogna avviarlo così

#bash listen_on_topic.sh
# ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com
# esol_ap29551_qa/Test_Concept-02/mqtts/Test_Concept-02_thing1/data
# ./certs/Test_Concept-02.crt
# ./certs/Test_Concept-02.pem
# ./certs/Test_Concept-02.key
# 546841616549687  <-- identificativo autogenerato da java
# ./payload_telemetry_test_concept_02.txt