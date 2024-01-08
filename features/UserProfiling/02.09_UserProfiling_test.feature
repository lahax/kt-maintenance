@User_Profiling_Test_2.9
Feature: User Profiling

  Background:


  Scenario: Test case 2.9
      # After login, select one project.
    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project
    # Choose the project with the Admin role, access a functionality that the user could not access through the Basic role, e.g. navigate to the Logs & Alarms section.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.logOption is active.
    Then I check that the element SidebarPage.alarmsOption is active.
    Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    Then I click on the user icon and log out.
    # Choose the project with the Basic role, Verify that the web application redirected to the Landing Page,
      # since the user with the Basic role cannot access the Logs & Alarms section..

    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    #Then I check the presence of SidebarPage.leftArrowOnSidebar Element and then i click it
    #And  I check the presence of ProjectPage.buttonToReturnHomePage Element and then i click it
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check that the element SidebarPage.logOption is not active.
    Then I check that the element SidebarPage.alarmsOption is not active.