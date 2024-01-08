@ActivitiesSection_Test_9.5
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
    #It is possible to edit an activity clicking on "edit" button

  Scenario: Test 9.5
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
    #Select an activity an click on "edit" button
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    And I wait 30 seconds after script
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose
    And I wait 30 seconds after script
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I wait the progress bar
    And I check the presence of ActivitiesPage.activityTestConcept9EditIcon Element and then i click it

    #Step4
    #Modify some parameters and click on save changes
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "test-editing",
    "command": "activate-thing",
    "parameters": {
    "device_type": "epiSensor",
    "interaction_mode": "gateway",
    "authentication_mode": "gateway",
    "radio_type": "Eth",
    "filter_tag": [
    {
    "tag": "Test",
    "id": 2000,
    "period": 60
    },
    {
    "tag": "CommunicationCode",
    "trendType": "CommCodeValue",
    "id": 2001,
    "period": 60
    }
    ],
    "inbound_communication_modes": [
    "shadow",
    "topic"
    ],
    "outbound_communication_modes": "shadow",
    "serial_number": "000D6F000D7EF1F8",
    "model": "ZDR",
    "maker": "EPISENSOR"
    }
    }
    """
    And I check the presence of ActivitiesPage.confirmSaveEditButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose
    #Step5
    #Verify that the changes were correctly saved
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.activityTestConcept9EditIcon Element and then i click it
    And I compare the payload ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "test-editing",
    "command": "activate-thing",
    "parameters": {
    "device_type": "epiSensor",
    "interaction_mode": "gateway",
    "authentication_mode": "gateway",
    "radio_type": "Eth",
    "filter_tag": [
    {
    "tag": "Test",
    "id": 2000,
    "period": 60
    },
    {
    "tag": "CommunicationCode",
    "trendType": "CommCodeValue",
    "id": 2001,
    "period": 60
    }
    ],
    "inbound_communication_modes": [
    "shadow",
    "topic"
    ],
    "outbound_communication_modes": "shadow",
    "serial_number": "000D6F000D7EF1F8",
    "model": "ZDR",
    "maker": "EPISENSOR"
    }
    }
    """
    And I check the presence of ActivitiesPage.confirmSaveEditButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

     #Logout Step
    Then I click on the user icon and log out.
