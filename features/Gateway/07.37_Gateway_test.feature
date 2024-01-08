@Gateway_Test_7.37
Feature: Gateway

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 7.37

    Then I enter on "esol-ap29551-qa" project
    #Step 2 - optional
    #If the device is simulated through script
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    Then I kill the notify_job command still opened
    Then I run the notify_job script on "Test_Concept-04", in the project "esol_ap29551_qa"
    #Step 3
    #Access to Devices  Section then select a connected Gateway, enter the detail section then click on the + on thing section and select Activate thing
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    Then I click SidebarPage.stepFunctionSubOption
    Then I input with enter "Test_Concept-04" in DevicesPage.searchBox
    Then I close all the step functions in progress
    And I check the presence of StepFunctionPage.refreshBtn Element and then i click it
    And I check the absence of StepFunctionPage.deleteButtonEnabled
    Then I click HomePage.hamburgerMenuIcon
    And I check the presence of SidebarPage.diagnosticDropDownOption Element and then i click it
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    Then I input "Test_Concept-04" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept04Details Element and then i click it
    And I click DevicesDetailsPage.enterToThingsList
    And If the thing "Test_Concept-04_thing4" in the project "esol_ap29551_qa" is present I remove it through "job"
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.otherOption
    And I input the payload into DevicesDetailsPage.firstRowIntTextarea for apm "esol_ap29551_qa"
    """
      {
      "outbound_communication_modes": ["topic"],
      "inbound_communication_mode": ["topic"],
      "interaction_mode": "gateway",
      "environment_prefix": "%s",
      "radio_type": "eth",
      "device_type": "mqtts",
      "serial_number": "12345",
      "model": "emulate_modbus",
      "maker": "Fibaro",
      "filter_tag": [{
      "id": 1,
      "period": 10,
      "tag": "topic/test"
      }]
      }
    """


    Then I check the presence of ActivateThingPage.activateThingBTN Element and then i click it
    Then I save the job ID from the job document received
    #Step 4
    #Wait for the job notify
    #Run registration script : ./register.sh <host endpoint> <apm> <device_id> <thing_id><payload file path> (see Script Preparation)
    Then I launch command "bash ./register_thing.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_qa Test_Concept-04 thing4 ./payload_register_thing.txt" on shell
    #Step 5
    #Check the thing is correctly showed on thing section
    Then I wait 2 minutes after script
    And I click DevicesDetailsPage.enterToThingsList
    Then I click DevicesPage.refreshBTN
    Then I check the presence of DevicesDetailsPage.thing4TestConcept04

    #Step 6
    #Wait for thing activation then execute the close job:
    #Close Job Script : ./close_job.sh <host> <apm> <device_id> <thing_id> <job_id>

    And I run the script "close_job", with the job Id retrieved, on "Test_Concept-04 thing4" in the project "esol_ap29551_qa"
    And I wait 2 minutes after script

    #Step 7
    #Open Diagnostic - Step function
    #Check the Step function status is "SUCCEEDED"
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionActivateThingConcept04 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    ##Default to clean dmc
#    Then I click HomePage.hamburgerMenuIcon
#    Then I click SidebarPage.devicesOption
#    Then I wait the progress bar
#    Then I kill the notify_job command still opened
#    Then I run the notify_job script on "Test_Concept-04", in the project "esol_ap29551_qa"
#    Then I input "Test_Concept-04_thing4" in DevicesPage.searchBox
#    Then I check the presence of DevicesPage.testConcept04thing4Details Element and then i click it
#    Then I check the presence of DevicesDetailsPage.showDetailsConcept04Thing4BTN Element and then i click it
#    Then I check the presence of DevicesDetailsPage.deactivateThingsBTN Element and then i click it
#    Then I check the presence of DevicesDetailsPage.deleteCertificate Element and then i click it
#    Then I check the presence of DevicesDetailsPage.deleteConfirm Element and then i click it
#    Then I save the job ID from the job document received
#    And I run the script "close_job_deactivate_thing", with the job Id retrieved, on "Test_Concept-04" in the project "esol_ap29551_qa"

    Then I click on the user icon and log out.