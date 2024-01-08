@DirectThing_Test_8.13
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.13
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Go to device page and select a direct thing
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.directConcept2Details Element and then i click it
    And I check the presence of DevicesDetailsPage.directThingPageTitle
    #----------------------------------Step 3
    #Click on  Show More:
    Then I check the presence of DevicesDetailsPage.infoIcon Element and then i click it
    #----------------------------------Step 4
    #At this point you should see a new window with all the information:
    And I check the presence of DevicesDetailsPage.moreInformationTitle
    And I check the presence of DevicesDetailsPage.moreInformationTableDirectThing
    And I check the presence of DevicesDetailsPage.maker
    And I check the presence of DevicesDetailsPage.environmentPrefix
    And I check the presence of DevicesDetailsPage.serialNumber
    And I check the presence of DevicesDetailsPage.geolocalizationLabelValue
    And I check the presence of DevicesDetailsPage.type
    And I check the presence of DevicesDetailsPage.thingID

    #Tablet
    #Then I set chrome "iPad pro" mode
    #And I check the presence of DevicesDetailsPage.moreInformationTitle
    #And I check the presence of DevicesDetailsPage.moreInformationTableDirectThing
    #And I check the presence of DevicesDetailsPage.maker
    #And I check the presence of DevicesDetailsPage.environmentPrefix
    #And I check the presence of DevicesDetailsPage.serialNumber
    #And I check the presence of DevicesDetailsPage.geolocalizationLabelValue
    #And I check the presence of DevicesDetailsPage.type
    #And I check the presence of DevicesDetailsPage.thingID

    And I click on the user icon and log out.