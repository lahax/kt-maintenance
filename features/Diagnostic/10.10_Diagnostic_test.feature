@Diagnostic_Test_10.10
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.10
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #Check that in the action column are shown delete button and details button (delete button should be clickable only when the job is IN PROGRESS):
    And I display 100 rows per page
    Then I verify that each row contains details buttons and delete buttons

    #Step 4
    #Open the step function execution detail clicking on details button and verify information showed are as expected
    And I click StepFunctionPage.lastStepFunctionSucceeded
    #And I click StepFunctionPage.detailsButton
    And I verify the details displayed