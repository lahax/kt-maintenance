@Gateway_Test_7.13
Feature: Gateway

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Connectivity history graph has no data in the selected range, or no data at all

  Scenario: Test 7.13

    #Step 2
    #Access to Device Section
    #Access to Device Section then click on a Gateway,
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #SStep 3
    #click on a Gateway of the device list and go to things list:
    Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it
    Then I check the presence of DevicesDetailsPage.concept01Thing1moreInfo Element and then i click it
    #Step 4
    #then click on a Thing List row then click on telemetry button:
    Then I check the presence of DevicesDetailsPage.telemetryThingBTN Element and then i click it

    #Step 5
    #Verify that the connection is established and check the start connection time
    Then I check the presence of MqttClientPage.playButton Element and then i click it
    Then I check the presence of MqttClientPage.connectionSuccessful
    Then I check the presence of MqttClientPage.startTime

   #Default to clean dmc
    Then I click on the user icon and log out.