@Industry_Test_28.18
Feature: Industry
#GOAL: It's introduced the paging for Activity section
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.18
    #and go on Activities page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption

    #2.Check the presence of the paginator
    Then I check the presence of ActivitiesPage.paginator

    #3.Verify if the paginator works properly
    Then I check the presence of ActivitiesPage.paginatorSelectRows Element and then i click it
    Then I check the presence of ActivitiesPage.paginator100Rows Element and then i click it

    #Prerequisite: at least 6 activities
    Then I check the number of rows present in the table
    Then I check the presence of ActivitiesPage.paginatorSelectRows Element and then i click it
    Then I check the presence of ActivitiesPage.paginator5Rows Element and then i click it
    Then I check the presence of ActivitiesPage.nextPage Element and then i click it
    Then I check the presence of ActivitiesPage.showDetailsActivity

    And I click on the user icon and log out.