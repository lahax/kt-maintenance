@ActivitiesSection_Test_9.7
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
    #The DMC should block a wrong configurated new activity creation

  Scenario: Test 9.7
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

                ##############CANCEL ACTIVITY CREATED#############
    And If the activity "TestConcept9" is present I delete it
    #Step 3
    #Try to create a new activity with a wrong configuration (for example empty body). Verify that is not possible to click on confirm.
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    And I cancel the text from the text area ActivitiesPage.activityDescriptionInput
    Then I check that the ActivitiesPage.confirmNewActivityButton element is disabled

    # Logout Step
    Then I click on the user icon and log out.
