@Industry_Test_28.21
Feature: Industry
#GOAL: Verify the functionality of the search bar. The user will be able to search by Device/Thing ID, Device/Thing Serial Number and Alias.
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.21
    #1b.Go on click on Step Functions
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    #2a.Verify the functionality of the search bar:
    #2b.The user will be able to search by Device/Thing ID:
    #by GW
    Then I type "Test_Concept-04" to search by "gatewayID"
    Then I check that all rows contains the source searched previously on StepFunctionPage
    #by thing
    And I clear the search Box in the Device Page
    Then I type "thing4" to search by "thingID"
    Then I check that all rows contains the source searched previously on StepFunctionPage
    #2c.by Device/Thing Serial Number:
    And I clear the search Box in the Device Page
    Then I type "12345" to search by "thingSN"
    And I wait 5 seconds
    Then I check that all rows contains the source searched previously on StepFunctionPage

    And I click on the user icon and log out.