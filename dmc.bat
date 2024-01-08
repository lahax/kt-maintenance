#!/bin/bash
# Usage: list the test name to execute them
echo "Starting Core Test Guides..."
@echo off
echo Encerrando todos os processos do Chrome...
taskkill /F /IM "chrome.exe" /T
echo Processos do Chrome encerrados.
powershell -executionpolicy bypass -file .\aws-adfs-rld.ps1
java -jar enel-dmc-automation-tests.jar chrome 13.01_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.02_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.03_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.04_SoftwareManager_test
@echo off
echo Encerrando todos os processos do Chrome...
taskkill /F /IM "chrome.exe" /T
echo Processos do Chrome encerrados.
powershell -executionpolicy bypass -file .\aws-adfs-rld.ps1
java -jar enel-dmc-automation-tests.jar chrome 13.05_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.06_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.07_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.08_SoftwareManager_test
@echo off
echo Encerrando todos os processos do Chrome...
taskkill /F /IM "chrome.exe" /T
echo Processos do Chrome encerrados.
java -jar enel-dmc-automation-tests.jar chrome 13.09_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.10_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.11_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.12_SoftwareManager_test
@echo off
echo Encerrando todos os processos do Chrome...
taskkill /F /IM "chrome.exe" /T
echo Processos do Chrome encerrados.
java -jar enel-dmc-automation-tests.jar chrome 13.13_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.14_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.15_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.16_SoftwareManager_test
@echo off
echo Encerrando todos os processos do Chrome...
taskkill /F /IM "chrome.exe" /T
echo Processos do Chrome encerrados.
java -jar enel-dmc-automation-tests.jar chrome 13.18_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.19_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.20_SoftwareManager_test
java -jar enel-dmc-automation-tests.jar chrome 13.21_SoftwareManager_test