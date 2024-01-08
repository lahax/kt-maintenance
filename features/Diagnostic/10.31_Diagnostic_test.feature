@Diagnostic_Test_10.31
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.31
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Lambdas submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.lambdasSubOptionIT

    #Then I verify that LambdasPage.execution contains Execution
    #Then I verify that LambdasPage.inputField contains Select
    #Then I verify that LambdasPage.header contains Select

    #Step 3
  #On the top right of the page, near the notification bell:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    Then I check the presence of LambdasPage.lambdaLandingPageTitle
    #Step 4
    #Check that the page is translated in the language chosed
    Then I check that the Lambda is correctly translated in italian

    #Then I verify that LambdasPage.execution contains Esecuzione
    #Then I verify that LambdasPage.inputField contains Seleziona
    #Then I verify that LambdasPage.header contains Seleziona

    #logout STEP

    Then I click on the user icon and log out.