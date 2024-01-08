@E2EMonitoring_Test_15.42
Feature: E2EMonitoring

  Background:

    # STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.42

    Then I enter on "esol-ap29551-qa" project
    #-------------------------------------------------------------------------------------------------------------------
    #BACKGROUND 0: Custom group of 15.26
#    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
#    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
#    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
#    # Click on the + Button to create an custom group
#    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
#    # Insert a group name,
#    And I type "Test_15.26" into the element CustomGroupsPage.addGroupName
#    # then add:
#    # A thing
#    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
#    Then I cancel a letter from the input box element CustomGroupsPage.addGateway
#    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
#    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
#    #Then I input "Test_Concept" in CustomGroupsPage.addThingBox
#    Then I check the presence of CustomGroupsPage.testConcept01thing1 Element and then i click it
#    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
#    # A direct thing
#    Then I type "DirectXX" into the element CustomGroupsPage.addDirectThingBox
#    Then I cancel a letter from the input box element CustomGroupsPage.addDirectThingBox
#    #Then I check the presence of CustomGroupsPage.addDirectThingBox Element and then i click it
#    And I check the presence of CustomGroupsPage.directThingXX Element and then i click it
#    And I check the presence of CustomGroupsPage.addDirectThingBTN Element and then i click it
#    # A gateway with all it things (you should be able to simulate this gateway)
#    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
#    Then I type "Test_Concept-01" into the element CustomGroupsPage.addGateway
#    Then I cancel a letter from the input box element CustomGroupsPage.addGateway
#    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
#    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
#    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
#    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
#    # A gateway without things
#    Then I type "Test_Concept-02" into the element CustomGroupsPage.addGateway
#    Then I cancel a letter from the input box element CustomGroupsPage.addGateway
#    #Then I check the presence of CustomGroupsPage.addGateway Element and then i click it
#    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
#    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
#    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
#    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
#    # Save
#    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it

    #BACKGROUND1: ALARM OF THE TEST 15.36
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    And I check the presence of SidebarPage.deviceAlarmsConfigurationSubOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.deviceAlarmsConfigurationPageTitle
   # - Click on the Wizard Button to create an alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardBTN Element and then i click it
   #Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Business
    Then I check the presence of DeviceAlarmsConfigurationPage.widespreadDisserviceAlarmRadioBTN Element and then i click it
     #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    Then I type "Test_Concept-01" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    # Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    # And If Element DeviceAlarmsConfigurationPage.testConcept04Device is present I click it
    And If Element DeviceAlarmsConfigurationPage.testConcept01Device is present I click it
    #And I check the presence of DeviceAlarmsConfigurationPage.testConcept01Device Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #Insert 3 as number of alarms
    And I type "3" into the element DeviceAlarmsConfigurationPage.numberOfAlarmsLabelInput
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    #Insert 2 mins in Short time window and 4 mins in Long time window
    And I type "2" into the element DeviceAlarmsConfigurationPage.shortTimeWindowInput
    And I type "4" into the element DeviceAlarmsConfigurationPage.longTimeWindowInput
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    #Review the configuration and save
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab4 Element and then i click it
    #Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    # Review and click Save to continue
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Insert a Channel for each type then click on Save
    #Insert a Channel for each type then click on Save
    #Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    Then I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
   #Cellphone
   #Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
   #Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
   #Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
   #Then I save telephone number
   #Then I type the telephone number saved into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
         #Topic
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelTopicOptionToSelect Element and then i click it
    And I type "testtest" into the element DeviceAlarmsConfigurationPage.topicToInsertBox
   #RDE ALARM
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelRdeAlarmOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    #Controll Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it
    #Complete subscription for the email
    Then I check the mail boxes

#-------------------------------------------------------------------------------------------------------------------
     #Listen to MQTT Topic
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for "Test_Concept-01", in the project "esol_ap29551_qa"
    #Step 1
    #Connect three devices which belong both the the gateway of Test 15.36 and the custom group of 15.39
    #Step 2
    #Disconnect a device every 3 minutes
    Then I connect the "thing1" of "Test_Concept-01", in the project "esol_ap29551_qa"
    Then I connect the "thing2" of "Test_Concept-01", in the project "esol_ap29551_qa"
    Then I connect the "thing3" of "Test_Concept-01", in the project "esol_ap29551_qa"
    And I wait 180 seconds after script
    #And I disconnect the last device connected
    And I disconnect "thing1"
    And I wait 180 seconds after script
    And I disconnect "thing2"
    And I wait 180 seconds after script
    And I disconnect "thing3"

    #Step 3
    #Verify the long Disservice alarm is not created
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption
    Then I input "Test_Concept-01 " in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I wait 5 seconds
    And I check the absence of AlarmsPage.lastAlarmWithTestConcept01InAlarmIconDetail
#    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
#    And I save alarm timestamp to check next alarm not created
#    Then I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
#    Then I input "Test_Concept-01" in AlarmsPage.searchBox
#    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
#    And I wait the progress bar
#    And I check the absence of AlarmsPage.lastAlarmWithTestConcept01IconDetail
#    Then I check that alarm was not created

#------------------------------------Remove configuration to restore changes---------------------------------------
   # remove Device Alarms Configurations
    Then I click HomePage.hamburgerMenuIcon
    Then If SidebarPage.deviceAlarmsConfigurationSubOption Element is not visible I click on E2E Monitoring option
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept1 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.toastMessageClose Element and then i click it

    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept01Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.toastMessageClose Element and then i click it

      #---------------------------------- Delete Custom Group ---------------------------------- #
#    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
#    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
#    And I check the presence of CustomGroupsPage.deleteTest15_26 Element and then i click it
#    And I check the presence of CustomGroupsPage.confirmDelete Element and then i click it

#------------------------------------Remove configuration to restore changes end---------------------------------------