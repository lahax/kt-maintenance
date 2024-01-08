@Diagnostic_Test_10.27
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.27
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open side menu then click on Diagnostic and click on Api Invocation submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.apiInvocationSubOption

    #Step 3
#Select the base url of the project and enter an invalid relative path. Then submit the form:
    Then select base, method "GET" and fill URL with "some"
    And I click APIInvocationPage.invokeButtonEnabled
    And I verify that APIInvocationPage.alertUnknownError contains failure
    And I verify that APIInvocationPage.alertUnknownError contains Error
