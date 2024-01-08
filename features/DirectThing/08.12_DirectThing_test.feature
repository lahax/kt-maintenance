@DirectThing_Test_8.12
Feature: Direct Thing

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 8.12
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
    #Click on  Telemetry:
    And I check the presence of DevicesDetailsPage.TelemetryBTN Element and then i click it
    #----------------------------------Step 4
    #At this point you should be redirected to MQTT client page:
    And I check the presence of MqttClientPage.mqttClientLandingPageTitle
    #----------------------------------Step 5
    #Click Play to retrieve data published
    And I check the presence of MqttClientPage.playButton Element and then i click it
    And I check the presence of MqttClientPage.connectionSuccessful
    And I check the presence of MqttClientPage.startTime
    And I check the presence of MqttClientPage.pauseBTN Element and then i click it
    And I check the presence of MqttClientPage.disconnectionSuccessful Element and then i click it



