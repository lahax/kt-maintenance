@ActivitiesSection_Test_9.3
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
    #Verify that the Activities table has the correct pagination

  Scenario: Test 9.3
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    #Verify the page is displaying the table of the activities (without pagination)
    #Verify it is present the column info (ACTIVITIES ID, CREATION DATE) and action button (Run, Copy, Edit, Delete) and the Add button in the right bottom corner
    Then I click SidebarPage.activitiesOption
    Then I check the presence of ActivitiesPage.activitiesTable
    Then I check the presence of ActivitiesPage.labelActivityIdColumn
    Then I check the presence of ActivitiesPage.labelCreationDateColumn

    Then I check the icon in the last column of the activity list table

    #Then I check the presence of ActivitiesPage.iconPlayFirstRow
    #Then I check the presence of ActivitiesPage.iconCopyFirstRow
    #Then I check the presence of ActivitiesPage.iconPencilFirstRow
    #Then I check the presence of ActivitiesPage.iconTrashFirstRow

    Then I check the presence of ActivitiesPage.newActivityPlusBTN

    #Step 3 (feature not yet deployed)
    #At the bottom of the table you should see the pagination button

     #Logout Step
    Then I click on the user icon and log out.