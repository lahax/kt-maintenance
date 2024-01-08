@ActivitiesSection_Test_9.6
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
    #Is it possible to delete an activity

  Scenario: Test 9.6
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

    #step 3
    #Create an activity to delete.
    #Choose an activity and press the trash button. Verify that the activity is removed from the list.
   ##############CANCEL ACTIVITY CREATED#############
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And If the activity "TestConcept9" is present I delete it

    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it

    #Step4
    #Check the pop up of confirm come out
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

    #Step5
    #Verify that the activity is removed from the list
    And I check the absence of ActivitiesPage.activityTestConcept9

    #Step6
    #Repeat the test in Tablet Mode and Smartphone mode
    #Then I click ActivitiesPage.newActivityPlusBTN
    #And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    #Then I click ActivitiesPage.confirmNewActivityButton
    #Then I click ActivitiesPage.toastMessageClose
    #Then I cancel text from the input box element DevicesPage.searchBox
    #Then I input "TestConcept9" in ActivitiesPage.searchBox
    #And I wait the progress bar
    #And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    #And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    #And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it
    #And I check the absence of ActivitiesPage.activityTestConcept9

    #Then I set chrome "iPhone" mode
    #Then I click ActivitiesPage.newActivityPlusBTN
    #And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    #Then I click ActivitiesPage.confirmNewActivityButton
    #Then I click ActivitiesPage.toastMessageClose
    #Then I cancel text from the input box element DevicesPage.searchBox
    #Then I input "TestConcept9" in ActivitiesPage.searchBox
    #And I wait the progress bar
    #And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    #And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    #And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it
    #And I check the absence of ActivitiesPage.activityTestConcept9

    # Logout Step
    Then I click on the user icon and log out.