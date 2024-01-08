@Tickets_Management_Test_17.5
Feature: Devices

  Background:

    #STEP 1 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 17.5

    Then I enter on "esol-ap29551-perf" project
    #Step 2
    #Access to DMC, open sidemenu then click on Tickets Management
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.ticketsManagementOption Element and then i click it
    And I check the presence of TicketsManagementPage.ticketsManagementLandingPageTitle

    #Step 3
    #Go with the pointer on "Language" and choose a language:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    #Step 4
    #Check that the page is translated in the language chosen
    Then I check that the page Tickets Management is correctly translated in italian

    And I click on the user icon and log out.