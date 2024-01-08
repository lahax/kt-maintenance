@Alarms_Test_12.10
Feature: Alarms

  Background:

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.10

    ## STEP 1
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle

    ## STEP 2
    Then I check the presence of AlarmsPage.filtersBox
    Then I check the presence of AlarmsPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.typeFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfTypeFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownTypeFilterBox using Javascript

    Then I check the presence of AlarmsPage.messageFilterBox Element and then i click it
    Then I check the presence of AlarmsPage.firstOptionOfMessageFilter Element and then i click it
    Then I click Element AlarmsPage.dropdownMessageFilterBox using Javascript

    Then I check the presence of AlarmsPage.confirmButtonFilterSection Element and then i click it

    ## STEP 3
    Then I check the presence of AlarmsPage.exportIcon Element and then i click it
    Then I check the number of total rows on popUp