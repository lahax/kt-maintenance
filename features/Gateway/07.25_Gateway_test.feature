@Gateway_Test_7.25
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Clicking on details button, it will show the gateway detail.

  Scenario: Test 7.25

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I input with enter "Test_Concept-01" in DevicesPage.searchBox
    Then I close all the step functions in progress
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    And I check the absence of StepFunctionPage.deleteButtonEnabled
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.diagnosticDropDownOption Element and then i click it
    Then I click SidebarPage.devicesOption

    #Step 2
    Then I wait the progress bar
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateGatewayBTNToClick Element and then i click it
    Then I check the presence of DevicesDetailsPage.updateGatewayTitleSection

    Then I enter a random "latitude" in UpdateGatewayDeviceDetailsPage.latitudeInputField
    Then I enter a random "longitude" in UpdateGatewayDeviceDetailsPage.longitudeInputField
    Then I check the presence of UpdateGatewayDeviceDetailsPage.sendBtn Element and then i click it

    Then I wait 20 seconds
    #Then I enter on "esol-ap29551-qa" project
    And If present i click on Enter Button

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    Then I check the presence of SidebarPage.stepFunctionSubOption Element and then i click it

    Then I wait 40 seconds
    Then I check the presence of StepFunctionPage.refreshBtn Element and then i click it

    Then I check the row with succeeded status is present