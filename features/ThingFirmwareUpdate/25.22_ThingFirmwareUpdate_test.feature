@ThingFirmwareUpdate_Test_25.22
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.22
   # GOAL: Align-sw-version containing a list of Thing IDs for which "sw_version" needs to be retrieved by the EGIP SW Manager
   # Step 1
    #Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: ThingFirmwareUpdate_Test_25.22
    Then I enter on "esol-ap29551-qa" project

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-54", in the project "esol_ap29551_qa"

    Then I check the presence of DevicesPage.searchBox Element and then i click it
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-54" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept54Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList

    Then I check the presence of ThingsPage.alignButton Element and then i click it
    Then I check the presence of ThingsPage.confirmButton Element and then i click it



    Given I Set the subscription on the topics below using the certificate "Test_Concept-54"
      |esol_ap29551_qa/Test_Concept-54/sw-update|
    Then I launch command "bash ./align_sw.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-54 thing1" on shell.
    And I check the response is equal to the expected. Gateway "Test_Concept-54"
      |{"statusDetails": {"environment_prefix": "esol_ap29551_qa","thing_id": "Test_Concept-54_thing1,"thing_sw": "test-bia-app:1.0"}}|


    Then I save the job ID from the job document received
    And I run the script "close_job_thing_25_22", with the job Id retrieved, on "Test_Concept-54 thing1" in the project "esol_ap29551_qa"
    Then I wait 2 minutes after script

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    #Then I wait last step function to be succeeded in 120 seconds for device "Test_Concept-54"
    
