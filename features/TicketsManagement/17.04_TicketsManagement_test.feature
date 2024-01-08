@Tickets_Management_Test_17.4
Feature: Devices

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 17.4

    Then I enter on "esol-ap29551-qa" project
    #Step 2
    #Access to DMC, open sidemenu then click on Tickets Management
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.ticketsManagementOption Element and then i click it
    And I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle
    #Step 3
    #Check that on top of the page there is a filter toolbox
    Then I check the presence of TicketsManagementPage.filterBox Element and then i click it
    Then I check the presence of TicketsManagementPage.selectDateTimeInFilters Element and then i click it
    #Set a Date Range, Start time and a end time.
    Then I check the presence of TicketsManagementPage.calendar
    Then I check the presence of TicketsManagementPage.leftMonthBTNFrom Element and then i click it
    Then I check the presence of TicketsManagementPage.firstDayPreviousMonthFrom Element and then i click it
    And I check the presence of TicketsManagementPage.toTabsIntoCalendar Element and then i click it
    And I check the presence of TicketsManagementPage.buttonNowIntoCalendar Element and then i click it
    Then I check the presence of TicketsManagementPage.buttonConfirmIntoCalendar Element and then i click it
    And I check the presence of TicketsManagementPage.confirmInFilters Element and then i click it
    #Check that only the filtered values are reported:
    And I check if the DateTime filter works properly

    And I click on the user icon and log out.