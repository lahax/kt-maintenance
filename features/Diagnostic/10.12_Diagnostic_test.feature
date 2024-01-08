@Diagnostic_Test_10.12
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.12
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #In the Step Function list table, search an item with IN_PROGRESS Status and click on the Delete Button then confirm the command. (continue test 10.11)

    And I display 100 rows per page
    Then if needed I create a step function on "Test_Concept-01"

    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.stepFunctionSubOption
    Then I wait 20 seconds
    And I reload the page
    And I input "Test_Concept-01" in DevicesPage.searchBox
    And I retrieve the date of the In Progress step for Gateway "Test_Concept-01"
    And I check the presence of StepFunctionPage.deleteButtonProgressTestConcept01 Element and then i click it
    #And I click StepFunctionPage.deleteButtonEnabled
    And I check the presence of StepFunctionPage.confirmButton Element and then i click it
    #And I click StepFunctionPage.confirmButton
    And StepFunctionPage.successAlert should be displayed

   #Step 4
   #When the DMC notify the success result reload the view and check that the step function is passed in the FAILED status and also the delete icon isn't shown anymore.

   And I reload the page
   Then I wait 120 seconds
   And I reload the page
   Then I verify that the In progress step is updated for the gateway for the Gateway "Test_Concept-01"

   #Step 5
   #Open AWS Console, Step function and verify the step function execution deleted has status FAILED

   And I check if AWS step function for the gateway "Test_Concept-01" and apm "esol_ap29551_qa" is set to "failed"
