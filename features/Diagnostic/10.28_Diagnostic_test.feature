@Diagnostic_Test_10.28
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.28
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open side menu then click on Diagnostic and click on Api Invocation submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.apiInvocationSubOption

    #Step 3
#Click on the Base search bar and verify if a list with all the endpoints from the IoT project appears:
    And I click APIInvocationPage.baseInput
    And base options DDM should contains these elements
      | https://w1eccuxit6.execute-api.eu-central-1.amazonaws.com/qa |
      | https://7sgq6ev652.execute-api.eu-central-1.amazonaws.com/qa_ap29551  |
