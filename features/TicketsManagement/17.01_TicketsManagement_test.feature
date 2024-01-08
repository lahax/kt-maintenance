@Tickets_Management_Test_17.1
Feature: Tickets Management

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 17.1

    Then I enter on "esol-ap29551-perf" project
    #Step 2
    #Access to DMC, open sidemenu then click on Tickets Management
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.ticketsManagementOption Element and then i click it
    And I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle

    #Step 3
    #Verify that the table presents these colums: Incident number, Timestamp Created, User ID and Target Name
    And I check the presence of TicketsManagementPage.ticketsManagementTable
    And I set a Breakpoint
    And I check the presence of TicketsManagementPage.ticketsManagementIncidentNumberColumn
    And I check the presence of TicketsManagementPage.ticketsManagementTimestampCreatedColumn
    And I check the presence of TicketsManagementPage.ticketsManagementUserIdColumn
    And I check the presence of TicketsManagementPage.ticketsManagementTargetNameColumn

    Then I click on the user icon and log out.