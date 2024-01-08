@E2EMonitoring_Test_15.28
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

  Scenario: Test case 15.28

    #BACKGROUND FOR THE TEST CASE: CREATE a GATEWAY (3) AND CREATE A CUSTOM GROUP WITH THIS gateway and "All thing", then add a thing
    #Then I launch command "bash ./register.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_perf Test_Concept-03 ./payload_gateway_greengrass.txt" on shell
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    Then I input "Test_Concept-02" in DevicesPage.searchBox
    Then If present, I deactivate the "thing2" on "Test_Concept-02", in the project "esol_ap29551_qa"
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    #Click on the + Button to create an custom group
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
    #Insert a group name,
    And I type "Test_15.28" into the element CustomGroupsPage.addGroupName
    # then add the gateway with all things:
    Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
    Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    #Then I check the presence of CustomGroupsPage.backBTNCustom Element and then i click it
   Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
   Then I check the presence of SidebarPage.devicesOption Element and then i click it
   And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I clear DevicesPage.searchBox
   Then I input "Test_Concept-02" in DevicesPage.searchBox
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait the progress bar
   Then I check the presence of DevicesPage.testConcept02Details Element and then i click it
   Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it
    And I check the presence of DevicesDetailsPage.thingListLandingPage
   And I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
   Then I check the presence of DevicesDetailsPage.activateThingsBTN Element and then i click it
    And I kill the notify_job command still opened
    Then I activate the "thing2" on "Test_Concept-02", in the project "esol_ap29551_qa".

    #Check that the first command is completed
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #------Step 2: Access to Devices  Section then select a connected Gateway, enter the detail section then click on a row in the Things List section,
     #  will be displayed the thing command selection

    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I reload the page

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I input "Test_Concept-02_thing2" in DevicesPage.searchBox
    And I check the presence of DevicesPage.refreshBTN Element and then i click it
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept02Thing2Details Element and then i click it

    #------Step 3: Go to AWS to see in IoT Core the thing and the certificate connected to the thing

    #The following step will execute:
    #-Step 4 (If the device is simulated through script NOTIFY_JOB ...   It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next):
    #-Step 5: Come back to DMC and click on deactivate then confirm.
    And I kill the notify_job command still opened
    Then I deactivate the "thing2" on "Test_Concept-02", in the project "esol_ap29551_qa".

    #Check that the second command is completed
    And I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check the presence of StepFunctionPage.lastStepFunctionWithConcept02 Element and then i click it
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

    #Step 6: Open the group group detail to verify the thing is not present anymore
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
#    And I check the presence of CustomGroupsPage.refreeshBTN Element and then i click it
#    And I wait the progress bar
    And I check the presence of CustomGroupsPage.detailsTest15_28 Element and then i click it
    And I check the absence of CustomGroupsPage.concept02Thing2box

     #-----------------------------------Delete group

    Then I check the presence of CustomGroupsPage.backBTNCustom Element and then i click it
    And I check the presence of CustomGroupsPage.deleteTest15_28 Element and then i click it
    And I check the presence of CustomGroupsPage.confirmDelete Element and then i click it

    #--------------RESET PART FOR THE TEST CASE: DELETE THE GATEWAY