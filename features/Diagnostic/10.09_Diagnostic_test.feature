@Diagnostic_Test_10.9
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.9
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #3a. Verify that on the top of the table, is possible to filter for command, Creation date and Status:
    Then I check the presence of StepFunctionPage.tableRows
    Then I click StepFunctionPage.filtersExpandArrow
    And I set filters

    #3b. Verify also the functionality of Clear Button:
    #Then I click StepFunctionPage.filtersExpandArrow
    And I click StepFunctionPage.clearButton
    And I should see filters reset

    #Then I set chrome "iPad pro" mode
    #And I should see filters reset