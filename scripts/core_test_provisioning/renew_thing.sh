#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm gatewayId thingId


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
gatewayId=$3 #"eig-ep37-00"
thingId=$4
certs="./certs" # folder containing new certificate


CA="${certs}/${gatewayId}.pem"
GTCERT="${certs}/${gatewayId}.crt"
GTKEY="${certs}/${gatewayId}.key"
NEWCERT="${certs}/${gatewayId}_${thingId}.crt" 
NEWKEY="${certs}/${gatewayId}_${thingId}.key"


############################################
########## REPROVISIONING ##################
############################################

NEWFINGERPRINT="$(openssl x509 -noout -in ${NEWCERT} -fingerprint -sha256)"
NEWFINGERPRINT="$(echo ${NEWFINGERPRINT//:} | awk -F'=' '{print tolower($2)}')"

CONTENT="${NEWFINGERPRINT}"

echo -n "New Fingerprint: "
echo -n "$CONTENT" | tee content

SIGNATURE="$(openssl base64 -in sha)"
SIGNATURE="$(echo ${SIGNATURE} | sed 's/ //g')"
echo ""
echo "Signature: $SIGNATURE"

echo "registering thing certificate..."
mosquitto_pub --cafile ${CA} --cert ${NEWCERT} --key ${NEWKEY} -h ${iotHost} -p 8883 -t "devices/reprovisioning" -m "{\"command\":\"thing-reprovisioning\",\"parameters\":{\"${gatewayId}_${thingId}\":\"${CONTENT}\"}}" -d

echo "wait 5s.."
sleep 5s
echo "publish on topic devices/reprovisioning..."

mosquitto_pub --cafile ${CA} --cert ${GTCERT} --key ${GTKEY} -h ${iotHost} -p 8883 -t "devices/reprovisioning" -m "{\"command\":\"thing-reprovisioning\",\"parameters\":{\"${gatewayId}_${thingId}\":\"${CONTENT}\"}}" -d

############################################
########## END REPROVISIONING ##############
############################################