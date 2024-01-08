@Industry_Test_28.17
Feature: Industry
#GOAL: Check the presence and functionality of the search bar
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.17
    #and go on Activities page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption

    #Prerequisite: activity is present
    Then I input "test2817" in ActivitiesPage.searchBox
    And I wait the progress bar
    And If the activity "test2817" for device "Test_Concept-01" is not present I create it with note "testing"

    #2.Check that the user is able ONLY to search by Activity ID:
     #search by ID
    And I clear the search Box in the Device Page
    Then I input "test2817" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the presence of ActivitiesPage.test2817Activity

    #search by Date
    And I clear the search Box in the Device Page
    Then I input "2023" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the absence of ActivitiesPage.test2817Activity

    #search by Note
    And I clear the search Box in the Device Page
    Then I input "testing" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the absence of ActivitiesPage.test2817Activity

    And I click on the user icon and log out.