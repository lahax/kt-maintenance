@Diagnostic_Test_10.3
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.3
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Lambdas submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.lambdasSubOption

    #Step 3
    #In the logs section select a lambda by clicking on the dropdown menu:

    Then I click LambdasPage.inputFieldLambda
    Then I click LambdasPage.taskcommandcompletation

    #Step 4
  #Verify that is possible to filter logs by All, Notification, Error, Timeout:

    And I display 100 rows per page

    And I click LambdasPage.errorsFilter
    And I wait 5 seconds
    Then I verify that Type column contains LambdasPage.errorsIcon icon

    And I click LambdasPage.notificationsFilter
    And I wait 5 seconds
    Then I verify that Type column contains LambdasPage.notificationsIcon icon

    And I click LambdasPage.timeoutsFilter
    And I wait 5 seconds
    Then I verify that Type column contains LambdasPage.timeoutIcon icon

    And I click LambdasPage.all

      #Step 5
  #Click on Log Stream link and verify it opens the AWS CloudWatch log page
    And I click LambdasPage.logStream
    And I wait 15 seconds
    Then I check the presence of LambdasPage.dateColumn
    Then I check the presence of LambdasPage.messageColumn
    Then I wait the progress bar
    And that the table is not empty