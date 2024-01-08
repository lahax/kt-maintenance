@Industry_Test_28.20
Feature: Industry
#GOAL: Verify the presence of the new columns on the Step Function table
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.20
    #1b.Go on click on Step Functions
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I check the presence of StepFunctionPage.stepFunctionLandingPageTitle

    #2.Verify the columns Activity ID, Device SN, Thing ID, Thing SN and Thing Alias are present
    Then I check the presence of StepFunctionPage.deviceIDColumn

    Then I check the presence of StepFunctionPage.deviceSNColumn
    Then I check the presence of StepFunctionPage.activityIDColumn
    Then I check the presence of StepFunctionPage.thingIDColumn
    Then I check the presence of StepFunctionPage.thingSNColumn
    Then I check the presence of StepFunctionPage.thingAliasColumn

    Then I check the presence of StepFunctionPage.commandTypeColumn
    Then I check the presence of StepFunctionPage.creationDateColumn
    Then I check the presence of StepFunctionPage.statusColumn
    Then I check the presence of StepFunctionPage.statusDateColumn
    Then I check the presence of StepFunctionPage.manageColumns

    And I click on the user icon and log out.