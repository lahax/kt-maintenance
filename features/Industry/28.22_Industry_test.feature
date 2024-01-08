@Industry_Test_28.22
Feature: Industry
#GOAL: By clicking on Step Function detail, check in the payload the presence of the new strings and input/output commands.
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.22
    #1b. Click on Step Function.
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption

    #PREREQUISITO: Create and Run Activity (= 09.11)
    #Create Activity
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    Then I input "TestConcept9" in ActivitiesPage.searchBox
    Then If Element ActivitiesPage.deleteActivityTestConcept9 is present I click it
    Then If Element ActivitiesPage.confirmDeleteButton is present I click it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept9" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "Test_Concept-01",
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
    "maker": "EPISENSOR",
    "thing_alias": "testAlias"
    }
    }
    """
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose

    #Run the activity
    Then I clear ActivitiesPage.searchBox
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.runActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmRunActivityButton Element and then i click it
    Then I click ActivitiesPage.toastMessageClose

    Then I save the job ID from the job document received
    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-01 thing1" in the project "esol_ap29551_qa"

    #Chek Step Function
    And I wait 4 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionActivateThingConcept01 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #-----------------PREREQUISITO------------------#

    #3. Check in the payload the presence of the new strings.
    #The user can see in the payload of a step function the following new strings: Activity ID; Device_ID; Device_serial_number; Thing_ID; Thing_serial_number; Thing_alias.
    And I check the presence of StepFunctionPage.deviceID
    And I check the presence of StepFunctionPage.deviceSerialNumber
    And I check the presence of StepFunctionPage.thingID
    And I check the presence of StepFunctionPage.thingSerialNumber
    And I check the presence of StepFunctionPage.thingAlias
    And I check the presence of StepFunctionPage.actvityID

    #4a. Click on the detail of a Step Function with payload received in input and check the correct view of "command_input":
    #4b. Click on the detail of a Step Function with payload received in output and check the correct view of "command_output":
    #"command_input" and "command_output" are correctly viewed
    And I check the presence of StepFunctionPage.commandInput
    And I check the presence of StepFunctionPage.commandOutput

    #Default to clean dmc
    Then I kill the notify_job command still opened
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption
    Then I input "TestConcept9" in ActivitiesPage.searchBox
    And I check the presence of ActivitiesPage.deleteActivityTestConcept9 Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

    #Final step
    #And I click on the user icon and log out.
    #todo close pop up logout