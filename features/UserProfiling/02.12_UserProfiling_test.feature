@User_Profiling_Test_2.12
Feature: User Profiling

  Background:

    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 2.12
    #STEP 1
    Then I enter on "esol-ap29551-qa" project
    # Access to DMC, open sidemenu then click on Diagnostic
    #Verify that API Invocation section is disabled and is not possible to click on it:
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.apiInvocationSubOption is not active.