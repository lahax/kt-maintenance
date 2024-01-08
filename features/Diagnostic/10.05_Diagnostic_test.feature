@Diagnostic_Test_10.5
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.5
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Lambdas submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.lambdasSubOption

    #Step 3
    #In the execution section select a lambda by clicking on the dropdown menu:

    Then I click LambdasPage.executionTab
    Then I click LambdasPage.inputFieldLambda
    Then I click LambdasPage.ddmOption

    #Step 4
  #Check that the table is composed by 3 colums: Date, Memory, Duration
    And I verify that the table contains these columns
      | DATE     |
      | MEMORY   |
      | DURATION |

    #Then I set chrome "iPad pro" mode
    #And I verify that the table contains these columns
    #  | DATE     |
    #  | MEMORY   |
    #  | DURATION |