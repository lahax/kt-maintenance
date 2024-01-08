@Diagnostic_Test_10.26
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.26
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open side menu then click on Diagnostic and click on Api Invocation submenu item.

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    Then I check the presence of SidebarPage.apiInvocationSubOption Element and then i click it

    #Step 3
#Select the base url of the project and write the relative url. Select the method POST,  write an invalid format in the payload field and submit the form:
    Then select base, method "POST" and fill URL with "/v2/gateways"

    And I input "prova errore" into the text area APIInvocationPage.payloadTextArea
    #Then I check the presence of APIInvocationPage.invokeButtonEnabled Element and then i click it
    #And I wait that the progress bar into the button invoke disappear
    #Then I check the presence of APIInvocationPage.resultOfLandingPageTitle
    #And I verify that APIInvocationPage.JSONError contains "Unexpected token 'p', " prova errore" is not valid JSON"
    #And I verify that APIInvocationPage.JSONError contains "in JSON at position"
    Then I check the presence of APIInvocationPage.unexpectedPError
    And I check that APIInvocationPage.invokeButtonEnabled element is not clickable

    Then I click on the user icon and log out.