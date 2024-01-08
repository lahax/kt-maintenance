@E2EMonitoring_Test_15.27
Feature: E2EMonitoring

  Background:

    #-----------------------------------Step 1
    #Login on DMC and go in E2E - Custom Group page
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project

  Scenario: Test case 15.27

    #BACKGROUND FOR THE TEST CASE: CREATE a GATEWAY AND CREATE A CUSTOM GROUP WITH THIS gateway and "All thing"
    #Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_perf Test_Concept-03 ./payload_gateway_greengrass.txt" on shell

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    And I wait the progress bar
    Then If present, I deactivate the "thing3" on "Test_Concept-02", in the project "esol_ap29551_qa"


    #Then I close all the step functions in progress of device "Test_Concept-02"

    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    #Click on the + Button to create an custom group
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    #Insert a group name,
    And I type "Test_15.27" into the element CustomGroupsPage.addGroupName
    # then add the gateway with all things:
    Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    #Then I cancel a letter from the input box element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    #Then If Element CustomGroupsPage.backBTNCustom is present I click it
    #Then I check the presence of CustomGroupsPage.backBTNCustom Element and then i click it

    #The following step will execute:
    #-Step 2 (If the device is simulated through script NOTIFY_JOB ...   It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next):
    #-Step 3: Access to Devices  Section then select a connected Gateway, enter the detail section then click on the + on thing section and select Activate thing,
    # Select Other and paste the correct payload
    #-Step 4: Wait for the job notify and Run registration script
        #Enter into Concept 03 gateway details
    #TO DO add a refresh if the gateway has been just created
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I clear DevicesPage.searchBox
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it
    And I wait 20 seconds
    And I check the presence of DevicesDetailsPage.thingListLandingPage
    And I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
    And I wait 20 seconds
    Then I check the presence of DevicesDetailsPage.activateThingsBTN Element and then i click it
    And I kill the notify_job command still opened
    Then I activate the "thing3" on "Test_Concept-02", in the project "esol_ap29551_qa".
    #Step 5: Check the thing is correctly showed on thing section
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    Then I wait 3 minutes after script
    And I reload the page
    Then I input "Test_Concept-02_thing3" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Thing3Row
    #The GOAL is to Verify an activated thing for a gateway with "All thing" is automatically added to the custom group, so:
    #Step 6: Open the group group detail to verify the thing is present
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    And I check the presence of CustomGroupsPage.detailsTest15_27 Element and then i click it
    And I check the presence of CustomGroupsPage.concept02Thing3box

     #-----------------------------------Delete group
    Then I check the presence of CustomGroupsPage.backBTNCustom Element and then i click it
    And I check the presence of CustomGroupsPage.deleteTest15_27 Element and then i click it
    #And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    And I check the presence of CustomGroupsPage.confirmDelete Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
    #Check that the first command is completed
    Then I wait 1 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction


    #--------------RESET PART FOR THE TEST CASE: DELETE THE THING
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Thing3Details Element and then i click it
    And I kill the notify_job command still opened
    Then I deactivate the "thing3" on "Test_Concept-02", in the project "esol_ap29551_qa".

    #Check that the second command is completed
    Then I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    Then I click StepFunctionPage.refreshBtn
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #-------------- DELETE THE GATEWAY