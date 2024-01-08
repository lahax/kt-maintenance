@ThingFirmwareUpdate_Test_25.24
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.24
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

  Scenario: ThingFirmwareUpdate_Test_25.24
    #Then I enter on "esol-ap29551-qa" project

    #Then I click HomePage.hamburgerMenuIcon
    #Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    #Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    #And I wait the progress bar
    #Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    #Then I check the presence of SoftwareCataloguePage.fliterExpand Element and then i click it
    #Then I check the presence of SoftwareCataloguePage.deviceTypeBox Element and then i click it
    #Then I check the presence of SoftwareCataloguePage.deviceTypeThing Element and then i click it
    #Then I check the presence of SoftwareCataloguePage.confirmButton Element and then i click it
    #And I wait the progress bar
    Then I check if dynamoDB Software catalogue contains "thing" same as DMC FE

