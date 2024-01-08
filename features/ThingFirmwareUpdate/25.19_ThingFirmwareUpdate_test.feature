@ThingFirmwareUpdate_Test_25.19
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.19
   # GOAL: The firmware update command is disabled since the Things have different sw thing type.
   # Step 1
    #Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: ThingFirmwareUpdate_Test_25.19
    #1a. choose a project and click on Devices section.
    Then I enter on "esol-ap29551-qa" project
    #1b. Choose a Gateway with Things associated and click on Detail button.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-51" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept51Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList
    #2a. Click on Thing section and select more than one thing with different Software Thing Type:
    Then I check the presence of ThingsPage.titleSectionThings
    Then I wait the progress bar
    Then I click ThingsPage.testConcept01thing1Select
    Then I click ThingsPage.testConcept01thing2Select
    #2b. Click on expandable FAB button and check that the Firmware Update Thing button is disabled:
    Then I click DevicesDetailsPage.moreInfoThingsBTN

    Then I check that DevicesDetailsPage.firmwareUpdate element is not clickable



