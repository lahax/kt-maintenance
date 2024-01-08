@Diagnostic_Test_10.23
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.23
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Load Certificate submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.loadCertificateSubOption

    #Step 3
  #Verify that the top of the page show the follow information:
  #
  #    ENVIRONMENT
  #    STAGE
  #    APM
  #    BUCKET S3

    Then I verify that following elements are displayed
      | Environment |
      | Stage       |
      | APM         |
      | Bucket S3   |