@User_Profiling_Test_2.3
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

  Scenario: Test case 2.3
    Then I enter on "esol-ap29551-qa" project
    # Select one project and then in the landing page you can see the EXPORT DATA button disabled
    Then I check that the element ProjectPage.exportIcon is not active.
