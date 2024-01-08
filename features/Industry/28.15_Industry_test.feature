@Industry_Test_28.15
Feature: Industry
#GOAL: Verify the presence of the new column Note in the Activities page
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.15
    #and go on Activities page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption

    #2.Verify the presence of the new column Note:
    Then I check the presence of ActivitiesPage.labelActivityIdColumn
    Then I check the presence of ActivitiesPage.labelCreationDateColumn
    Then I check the presence of ActivitiesPage.labelNotesColumn
    Then I check the presence of ActivitiesPage.manageColumn

    And I click on the user icon and log out.