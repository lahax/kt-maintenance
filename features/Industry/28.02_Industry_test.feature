@Industry_Test_28.2
Feature: Industry
#GOAL: In the Thing detail is been added the new Serial number string
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.2
    #Click on "Show Detail" and then on "More Info". The User is able to see the new added Serial Number string.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it

    Then I check the presence of ThingsPage.titleSectionThings

    And I type "Test_Concept-01_thing1" into the element ThingsPage.searchbox
    And I wait the progress bar
    Then I check the presence of ThingsPage.thingDetails Element and then i click it
    Then I check the presence of ThingsPage.moreInfo Element and then i click it
    Then I check the presence of ThingsPage.detailThingTitle
    Then I check the presence of ThingsPage.labelStatus
    Then I check the presence of ThingsPage.labelMaker
    Then I check the presence of ThingsPage.labelType
    Then I check the presence of ThingsPage.labelThingID
    Then I check the presence of ThingsPage.labelModel
    Then I check the presence of ThingsPage.labelSerialNumber
    Then I check the presence of ThingsPage.labelThingAlias
    Then I check the presence of ThingsPage.labelCertificateExpiration
    Then I check the presence of ThingsPage.labelCertificateAuthority
    Then I check the presence of ThingsPage.labelGeolocalization
    Then I check the presence of ThingsPage.labelSoftwareThingType

    And I click on the user icon and log out.