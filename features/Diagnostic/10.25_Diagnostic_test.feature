@Diagnostic_Test_10.25
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.25
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open side menu then click on Diagnostic and click on Api Invocation submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.apiInvocationSubOption
    Then I check the presence of APIInvocationPage.apiInvocationLandingPageTitle

    #Step 3
#Select the base url of the project and write the relative url. Select the method,  click to invoke and wait for the results:
    Then select base, method "GET" and fill URL with "/v2/gateways"

    Then I check the presence of APIInvocationPage.invokeButtonEnabled Element and then i click it
    And I wait that the progress bar into the button invoke disappear
    Then I check the presence of APIInvocationPage.resultOfLandingPageTitle

    #Step 4
    #At this point you should see the response payload of the API:
    And I verify the response displayed

