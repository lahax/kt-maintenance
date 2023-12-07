#!/usr/bin/env bash

# Usage: ${SCRIPT_NAME} iotHost apm thingId jobId [final_job_status]


iotHost=$1 #"ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com"
environmentPrefix=$2 #"esol_ap29551_qa"
thingId=$3 #"eig-ep37-00"
#jobId=$4
final_job_status=$5 #default=succeeded
certs="./certs" # folder containing new certificate
old_certs="./old_certs"


CA="${old_certs}/${thingId}.pem"
CERT="${old_certs}/${thingId}.crt"
KEY="${old_certs}/${thingId}.key"
NEWCERT="${certs}/${thingId}.crt"
NEWKEY="${certs}/${thingId}.key"


# if [ ${final_job_status} == "failed" ];
# then
#     echo "setting job status to failed..."
#     mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 - t "\$aws/things/${environmentPrefix}_${thingId}/jobs/${jobId}/update" -m "{ \"status\":\"FAILED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" ,\"step\": \"command failed\"} }" -d
#     exit 0
# fi

############################################
########## REPROVISIONING ##################
############################################

echo ""
echo "start reprovisioning"

OLDFINGERPRINT="$(openssl x509 -noout -in ${CERT} -fingerprint -sha256)"
OLDFINGERPRINT="$(echo ${OLDFINGERPRINT//:} | awk -F'=' '{print tolower($2)}')"

NEWFINGERPRINT="$(openssl x509 -noout -in ${NEWCERT} -fingerprint -sha256)"
NEWFINGERPRINT="$(echo ${NEWFINGERPRINT//:} | awk -F'=' '{print tolower($2)}')"

CONTENT="${OLDFINGERPRINT}-${NEWFINGERPRINT}"

echo -n "FROM-TO: "
echo -n "$CONTENT" | tee content

SHA="$(openssl dgst -sha256 -sign "${KEY}"  -out sha content)"
SIGNATURE="$(openssl base64 -in sha)"
SIGNATURE="$(echo ${SIGNATURE} | sed 's/ //g')"
echo ""
echo "Signature: $SIGNATURE"

echo "registering thing certificate..."
mosquitto_pub --cafile ${CA} --cert ${NEWCERT} --key ${NEWKEY} -h ${iotHost} -p 8883 -t "devices/reprovisioning" -m "{\"command\":\"core-reprovisioning\",\"parameters\":{\"from-to\":\"${CONTENT}\",\"signature\":\"${SIGNATURE}\"}}" -d

echo "wait 5s.."
sleep 5s
echo "publish on topic devices/reprovisioning..."

mosquitto_pub --cafile ${CA} --cert ${NEWCERT} --key ${NEWKEY} -h ${iotHost} -p 8883 -t "devices/reprovisioning" -m "{\"command\":\"core-reprovisioning\",\"parameters\":{\"from-to\":\"${CONTENT}\",\"signature\":\"${SIGNATURE}\"}}" -d

############################################
########## END REPROVISIONING ##############
############################################


echo ""
echo "setting job status to succeeded..."
#mosquitto_pub --cafile ${CA} --cert ${CERT} --key ${KEY} -h ${iotHost} -p 8883 -t "\$aws/things/${environmentPrefix}_${thingId}/jobs/${jobId}/update" -m "{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" ,\"step\": \"command succeeded\",\"core-status\": \"success\"} }" -d