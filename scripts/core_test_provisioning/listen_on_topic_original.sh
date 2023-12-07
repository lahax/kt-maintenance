#!/usr/bin/env bash

mosquitto_sub -h $1 -p 8883 -v -t $2 --cert $3 --cafile $4 --key $5 $6 $7 >> $8

