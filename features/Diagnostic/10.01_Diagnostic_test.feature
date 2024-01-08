@Diagnostic_Test_10.1
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.1
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Lambdas submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.lambdasSubOption

    #Step 3
    #User lands on Lambdas landing page
    Then I check the presence of LambdasPage.lambdaLandingPageTitle
    Then I check the presence of LambdasPage.lambdaHeaderPage
    Then I check the presence of LambdasPage.inputFieldLambda

    #Tablet
    #Then I set chrome "iPad pro" mode
    #Then I check the presence of LambdasPage.lambdaLandingPageTitle
    #Then I check the presence of LambdasPage.lambdaHeaderPage
    #Then I check the presence of LambdasPage.inputFieldLambda








