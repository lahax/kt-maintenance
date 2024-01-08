@ActivitiesSection_Test_9.2
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
    #The correct buttons are present in the table rows

  Scenario: Test 9.2
    #PROCEDURE
    #Step 1
    #Access to DMC
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon

    #Step 2
    #Access to Activity Section
    Then I click SidebarPage.activitiesOption

    ##############CANCEL ACTIVITY CREATED#############
    Then I input "TestConceptActivity" in ActivitiesPage.searchBox
    And If the activity "TestConceptActivity" is present I delete it

    ######PREDCONDITION: CREATE AN ACTIVITY#######
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConceptActivity" into the element ActivitiesPage.activityIdInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose
    ##############################################

    #step 3
    # Verify that for each row you can see 4 buttons: Run, Copy, Edit and Delete
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConceptActivity" in DevicesPage.searchBox
    And I wait the progress bar
    Then I check the presence of ActivitiesPage.iconPlayFirstRow
    Then I check the presence of ActivitiesPage.iconCopyFirstRow
    Then I check the presence of ActivitiesPage.iconPencilFirstRow
    Then I check the presence of ActivitiesPage.iconTrashFirstRow

     #Logout Step
    Then I click on the user icon and log out.