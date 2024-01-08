@ActivitiesSection_Test_9.4
Feature: ActivitiesSection

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    #GOAL
    #It is possible to create a new activity

  Scenario: Test 9.4
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

            ##############CANCEL ACTIVITY CREATED#############
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And If the activity "TestConcept9" is present I delete it

    #step 3
    # Press the "+" button at the bottom right of the page
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel

    #step 4
    #At this point you should see a new window where you can create the new activity and click confirm
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    #Step5
    #Verify that the new activity is in the table
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the presence of ActivitiesPage.activityTestConcept9
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

     #Logout Step
    Then I click on the user icon and log out.
