@ThingFirmwareUpdate_Test_25.11
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.11
   # GOAL: ACTIVATE OCPP THING - new activation payload NOT containing  "sw_thing_type" and "sw_versions"
   # Step 1
    #Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: ThingFirmwareUpdate_Test_25.11
    Then I enter on "esol-ap29551-qa" project

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-51", in the project "esol_ap29551_qa"
    #And I run the notify_thing script on "Test_Concept-51", "thing2" in the project "esol_ap29551_qa"
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    And I clear the search Box in the Device Page
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList
    Then I check the presence of ThingsPage.titleSectionThings
    Then I wait the progress bar
    Then I click ThingsPage.testConcept01thing2Select
    Then I click DevicesDetailsPage.moreInfoThingsBTN
    Then I click DevicesDetailsPage.firmwareUpdate

    Then I check the presence of ThingsPage.titleSectionThings
    Then I check the presence of ThingsPage.appInput Element and then i click it
    Then I check the presence of ThingsPage.appFirmUpgOCPP Element and then i click it
    Then I check the presence of ThingsPage.versionInput Element and then i click it
    Then I check the presence of ThingsPage.version1Fuocpp Element and then i click it
    Then I check the presence of ThingsPage.updateButton Element and then i click it
    Then I save the job ID from the job document received

    And I run the script "close_job_thing_update_failed", with the job Id retrieved, on "Test_Concept-51 thing2" in the project "esol_ap29551_qa"