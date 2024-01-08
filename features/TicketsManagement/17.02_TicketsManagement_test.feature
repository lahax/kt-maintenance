@Tickets_Management_Test_17.2
Feature: Devices

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 17.2

    Then I enter on "esol-ap29551-qa" project
    #Step 2
    #Access to DMC, open sidemenu then click on Tickets Management
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.ticketsManagementOption Element and then i click it
    And I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle
    #Step 3
    #Click on detail button of a record:
    Then I check the presence of TicketsManagementPage.detailsIconOfTableFirstRow Element and then i click it
    #Step 4
    #Check that you are able to see more info about the record:
    Then I check the presence of TicketsManagementPage.ticketManagementDetailPageTitle
    Then I check the presence of TicketsManagementPage.ticketDetailSectionCard
    And I check there is at least one detail info for the selected ticket

    And I click on the user icon and log out.