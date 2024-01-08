@Diagnostic_Test_10.11
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.11
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #Looking for a one Step Function with the IN_PROGRESS status, if there isn't one, open the sidemenu and click on Devices item, then select one devices and
      # go to System Commands window in the detail page. Run one command like as Reboot, so you can see in the step fuction list a new item with the status IN_PROGRESS.
      #Click on its Delete button, then confirm the command.
    And I display 100 rows per page
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    Then if needed I create a step function on "Test_Concept-02"
    And I click StepFunctionPage.refreshBtn

    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.stepFunctionSubOption
    Then I wait 30 seconds
    And I check the presence of StepFunctionPage.deleteButtonEnabled Element and then i click it
    And I check the presence of StepFunctionPage.confirmButton Element and then i click it
    And StepFunctionPage.successAlert should be displayed