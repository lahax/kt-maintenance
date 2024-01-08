@ActivitiesSection_Test_9.1
Feature: ActivitiesSection

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #Verify that the Activities table has the correct fields

  Scenario: Test 9.1
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

    #step 3
    # Check that there is a table with 2 colums: ID and Creation Date

    Then I check the presence of ActivitiesPage.labelActivityIdColumn
    Then I check the presence of ActivitiesPage.labelCreationDateColumn

     #Logout Step
    Then I click on the user icon and log out.