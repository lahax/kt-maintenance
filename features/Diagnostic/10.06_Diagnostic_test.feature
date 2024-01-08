@Diagnostic_Test_10.6
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.6
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #You should see a table like this:
    Then I check the presence of StepFunctionPage.stepFunctionPageTitle
    Then I check the presence of StepFunctionPage.filtersDDM
    Then I check the presence of StepFunctionPage.inputFieldStepFunction
    Then I check the presence of StepFunctionPage.tableStepFunction