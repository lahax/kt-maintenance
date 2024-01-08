@Alarms_Test_12.6
Feature: Alarms
#TODO, non aggiornato
  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.6

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle
    Then I check the presence of AlarmsPage.searchInputBox Element and then i click it
    Then I check for at least one row into the table on AlarmsPage
    Then I type random source in Source SearchBox on AlarmsPage
    Then I check that all row contains the source searched previously on AlarmsPage

    #Then I set chrome "Ipad pro" mode
    #Then I check that all row contains the source searched previously on AlarmsPage