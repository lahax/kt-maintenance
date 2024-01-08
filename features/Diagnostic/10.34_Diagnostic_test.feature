@Diagnostic_Test_10.34
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.34
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Api Invocation submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.apiInvocationSubOption

    #Then I verify that APIInvocationPage.apiInvocationHeader contains Diagnostic
    #Then I verify that APIInvocationPage.methodLabel contains Method
    #Then I verify that APIInvocationPage.errorLabel contains required
    #Then I verify that APIInvocationPage.invokeButton contains Invoke

    #Step 3
    # On the top right of the page, near the notification bell:
    #Go with the pointer on "Language" and choose a language:
    #Check that the page is translated in the language chosed
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    And I check that the API Invocation page is correctly translated in italian

          #LOGOUT
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption
    Then I click on the user icon and log out.
    Then I check the presence of LoginPage.loginBtn


    #Then I verify that APIInvocationPage.apiInvocationHeader contains Diagnostica
    #Then I verify that APIInvocationPage.methodLabel contains Metodo
    #Then I verify that APIInvocationPage.errorLabel contains richiesto
    #Then I verify that APIInvocationPage.invokeButton contains Invoca