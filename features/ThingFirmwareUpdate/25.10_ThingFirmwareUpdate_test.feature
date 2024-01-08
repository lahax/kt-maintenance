@ThingFirmwareUpdate_Test_25.10
Feature: Thing Firmware Update
    # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.10
    # https://jira.springlab.enel.com/browse/EXEGIP2-1617

    # GOAL: Execute successfully a "Firmware-update-thing" command related to single OCPP thing with sw_thing_type NOT Generic.

   # Step 1
    #Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: ThingFirmwareUpdate_Test_25.10
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I input "GatewayConceptTest59" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "GatewayConceptTest59"

    #ACTIVATE THING
    And I click DevicesDetailsPage.enterToThingsList
    And If the thing "GatewayConceptTest59_thing1" in the project "esol_ap29551_qa" is present I remove it through "job"
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "GatewayConceptTest59", in the project "esol_ap29551_qa"
    And I wait 30 seconds

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    And I clear the search Box in the Device Page
    Then I input "GatewayConceptTest59" in DevicesPage.searchBox
    Then I click on details icon of the device "GatewayConceptTest59"

    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN
    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.otherOption

    And I input the payload into DevicesDetailsPage.firstRowIntTextarea for apm "esol_ap29551_qa"
    """
{
"model": "MODEL",
    "maker": "MARKER",
    "alias": "ALIAS",
    "radio_type": "RADIO_TYPE",
    "interaction_mode": "gateway",
    "ipaddress": "10.0.0.41",
    "port_num": "8020",
    "serial_number": "01020304",
    "device_type": "DEVICE_TYPE",
    "filter_tag":[{"FILTER_TAG":"text"}],
    "environment_prefix": "esol_ap29551_qa",
    "sw_thing_type": "test"
}
    """


    Then I check the presence of ActivateThingPage.activateThingBTN Element and then i click it
    Then I save the job ID from the job document and I verify the format for command: "activate-thing"
    #When I Set the subscription on the topics below using the certificate "GatewayConceptTest57"
    #  |core/esol_ap29551_qa/registration/#|

    Then I launch command "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa GatewayConceptTest59 thing1 ./payload_activation_thing_25_10.txt" on shell
    And I print "payload_activation_thing_25_10" used in script
    And I run the script "close_job", with the job Id retrieved, on "GatewayConceptTest59 thing1" in the project "esol_ap29551_qa"
    Then I wait 2 minutes after script

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I clear the search Box in the Device Page
    Then I input "GatewayConceptTest59" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "GatewayConceptTest59"
    And I click DevicesDetailsPage.enterToThingsList
    Then The table should contains the "GatewayConceptTest59_thing1" row

    Given I Set the subscription on the topics below using the certificate "GatewayConceptTest59"
      |esol_ap29551_qa/GatewayConceptTest59/gw-firmwareupdatecompletion|
    And I wait 20 seconds

    Then I click ThingsPage.gatewayConceptTest59thing1Select
    Then I click DevicesDetailsPage.moreInfoThingsBTN
    Then I click DevicesDetailsPage.firmwareUpdate

    Then I check the presence of ThingsPage.titleSectionThings
    Then I check the presence of ThingsPage.appInput Element and then i click it
    Then I check the presence of ThingsPage.appFirmUpgOCPP Element and then i click it
    Then I check the presence of ThingsPage.versionInput Element and then i click it
    Then I check the presence of ThingsPage.version1Fuocpp Element and then i click it
    Then I check the presence of ThingsPage.updateButton Element and then i click it

    Then I save the job ID from the job document received

    And I run the script "close_job", with the job Id retrieved, on "GatewayConceptTest59 thing1" in the project "esol_ap29551_qa"

    And I wait 2 minutes after script

    #TODO CHECK STEP FUNCTION AND DEPLOY HISTORY

    #5b. Open DMC, Diagnostic → Step Function page and check the step function is closed with success

    #5c. Open Deployment History and checks the firmware update task is still in progress


    #And I run the script "firmware_update_25_10", with the job Id retrieved, on "GatewayConceptTest59 thing1" in the project "esol_ap29551_qa"
    And I run the script "firmware_update_25_10", with the job Id retrieved and the payload "payload_25_10" on "GatewayConceptTest59" "thing1" in the project "esol_ap29551_qa"


    #7a. Check on AWS Console, <SC><APMCODE><ENV>/<gw_id>/gw-firmwareupdatecompletion MQTT topic, that OCPP sends thing SUCCESS completion message; the payload should be like the following:
    And I check the IoT Core response contains expected values and is received in 120 seconds. Gateway "GatewayConceptTest59"
    |{"status":"SUCCEEDED", "commandId": $jobId, "statusDetails": { "environment_prefix":"esol_29551_qa","thing_id": GatewayConceptTest59_thing1,"install_status":"complete_install","thing_sw":"ocpp_app:1.0","custom_status":"Installed"}}|

    #4a. Access AWS Account, Cloudwatch service, <apm>_lambda_swmanagercompletion log group
    #TODO
    #4b. check the following error message is present:
    #TODO

    #5a. Open Deployment History on DMC and checks that there is NOT a new item for the test thing, indicating the sw app
    #TODO
    #5b. Open Devices page on DMC and check the thing software is NOT updated
    #TODO