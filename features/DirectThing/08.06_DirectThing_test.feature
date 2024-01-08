@DirectThing_Test_8.6
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.6
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Go to device page and select a direct thing
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "DirectCoreApril3" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.directCoreApril3Details Element and then i click it
    #---------------------------------Step 3
    #Click on Firmware Update:
    Then I check the presence of DevicesDetailsPage.firmwareUpdateToClick Element and then i click it
    #---------------------------------Step 4
    #Check the possibility to add/remove packages clicking on the "+" 1) and "trash" 2) buttons":
    Then I check the presence of DevicesDetailsPage.appNameBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.app1OptionToSelect Element and then i click it
    Then I check the presence of DevicesDetailsPage.versionBox Element and then i click it
    Then I check the presence of DevicesDetailsPage.version1OptionToSelect Element and then i click it
    Then I check that the element DevicesDetailsPage.addNewPackage is active.
    Then I check that the element DevicesDetailsPage.trashIcon is active.