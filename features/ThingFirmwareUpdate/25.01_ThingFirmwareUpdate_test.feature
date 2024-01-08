@ThingFirmwareUpdate_Test_25.01
Feature: ThingFirmwareUpdate
  # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.1
#GOAL:ACTIVATE OCPP THING - new activation payload containing only "sw_thing_type" and no "sw_versions"
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
  Scenario: Test 25.01
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList

    And If the thing "Test_Concept-51_thing1" in the project "esol_ap29551_qa" is present I remove it through "job"
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-51", in the project "esol_ap29551_qa"
    And I wait 30 seconds

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList
    #TODO working method of removing present thing before proceeding
    #And If the thing "Test_Concept-51_thing1" in the project "esol_ap29551_qa" is present I remove it through "job"
    Then I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.activateThingsBTN Element and then i click it
    Then I check the presence of ActivateThingPage.inputField Element and then i click it
    Then I check the presence of ActivateThingPage.otherOption Element and then i click it
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

    #9 – Open AWS enel console (https://sts.enel.com/adfs/ls/idpinitiatedsignon)
    #10 – Select IotSupport role and log in
    #11 – Go to Iot Core page
    #12b –Click on “Subscribe to a topic” and subscribe to other topic core/{env_previx}/registration/#
    When I Set the subscription on the topics below using the certificate "Test_Concept-51"
      |core/esol_ap29551_qa/registration/#|

    #13 -  Run registration script
    Then I launch command "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-51 thing1 ./payload_25_01.txt" on shell
    #14a – Wait for the registration message: the inbound message must match payload file.
    And I print "payload_25_01" used in script
    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-51 thing1" in the project "esol_ap29551_qa"
    Then I check the response is equal to the expected. Gateway "Test_Concept-51_thing1"
      """
{"status": "SUCCEEDED", "message": "end of registration command", "device_id": "%s"}
      """
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I check the presence of StepFunctionPage.lastStepFunctionActivateThingConcept51

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList
    Then I check the presence of ThingsPage.TestConcept51Thing1
    Then I check the presence of ThingsPage.thingDetails Element and then i click it
    Then I check the presence of ThingsPage.moreInfo Element and then i click it
    And I check the presence of ThingsPage.labelSoftwareThingType

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerDropDownOption
    And I click SidebarPage.deploymentsHistoryOption
    Then I check the presence of DeploymentsHistoryPage.lastDeployThingConcept51SWNA

    Then I click on the user icon and log out.



