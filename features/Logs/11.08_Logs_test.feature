@Logs_Test_11.8
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.8

    #STEP 1 - Login on DMC

   Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Check if on the top right of the page there is a search bar. Search for a non-existing source and verify that nothing will be displayed:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    Then I check the presence of LogPage.searchInputBox Element and then i click it
    Then I type "TESTCONCEPT" into the element LogPage.searchInputBox
    Then I wait the progress bar
    Then I check that the table do not contains any rows

