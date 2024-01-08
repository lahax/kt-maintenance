@ThingFirmwareUpdate_Test_25.26
Feature: Thing Firmware Update

   # https://confluence.springlab.enel.com/display/EXEGIPL/%5BEGIP+2021%5D+%5BEXEGIP2-35%5D+OCPP+Software+Update+-+Test+Guide+-+25.26
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
    Then I enter on "esol-ap29551-qa" project
  #Create Software package to preform test
    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.softwareManagerOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    And I wait the progress bar
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    And I input "test_2526" in SoftwareCataloguePage.searchBar
    And I wait the progress bar
    And The "test_2526" software should not present. If Present Then I remove it.


    Then I check the presence of SoftwareCataloguePage.uploadBtn Element and then i click it
    Then I check the presence of SoftwareCataloguePage.newSoftwarePackage

    Then I check the presence of SoftwareCataloguePage.deviceTypeDropdown Element and then i click it
    Then I check the presence of SoftwareCataloguePage.thingOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareTypeInput Element and then i click it
    And I input "ocpp-software-type" in SoftwareCataloguePage.softwareTypeInput

    Then I check the presence of SoftwareCataloguePage.appnameInput Element and then i click it
    And I input "test_2526" in SoftwareCataloguePage.appnameInput
    Then I check the presence of SoftwareCataloguePage.versionInput Element and then i click it
    And I input "1.0" in SoftwareCataloguePage.versionInput
    Then I check the presence of SoftwareCataloguePage.softwareExtensionAccordion Element and then i click it
    Then I check the presence of SoftwareCataloguePage.zipOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.architectureInput
    And I input timestamp after the word test_ into SoftwareCataloguePage.descriptionInput
    And I input rightZip.zip file into SoftwareCataloguePage.fileInput
    Then I check the presence of SoftwareCataloguePage.saveButton Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueSuccessfullyUploaded Element and then i click it

  Scenario: ThingFirmwareUpdate_Test_25.26

    And I wait the progress bar
    Then I wait 30 seconds
    And I check the presence of SoftwareCataloguePage.refreshBtn Element and then i click it
    And The "test_2526" software should not present. If Present Then I remove it.