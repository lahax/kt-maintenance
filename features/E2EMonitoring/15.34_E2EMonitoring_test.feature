@E2EMonitoring_Test_15.34
Feature: E2EMonitoring

  Background:

    #Login on DMC and go in E2E - Custom Group page
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    Then I enter on "esol-ap29551-qa" project

  Scenario: Test case 15.34

    #------------------------------------------------REPEAT TEST 15.30 start----------------------------------

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
   # - Click on the Wizard Button to create an alarm
    #Then I click DeviceAlarmsConfigurationPage.wizardBTN
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
    Then I check the presence of DeviceAlarmsConfigurationPage.businessAlarmRadioBTN Element and then i click it
     #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.groupDeviceOptionToSelect Element and then i click it
    #Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    Then I type "Test_Concept-01" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I cancel a letter from the input box element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And If Element DeviceAlarmsConfigurationPage.testConcept01Device is present I click it
    #And I check the presence of DeviceAlarmsConfigurationPage.testConcept01Device Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #Insert 5 min as time window
    And I type "5" into the element DeviceAlarmsConfigurationPage.timeWindow
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    #Review the summary of the configuration and click Next to proceed
    Then I check the presence of DeviceAlarmsConfigurationPage.alarmConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
   #Click Yes to proceed with the configuration
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    #Do not select Aggregation and click Next
    #And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #Do not select Max Frequency and click Next
    #And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
   #Review and click Save to continue
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   #Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   #Insert a Channel for each type then click on Save
   #Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    And I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
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


    #------------------------Step 1: Connect a device which belong both the the gateway of Test 15.30 and the custom group of 15.32 (Test_Concept-02)
    #Parametro di 100 secondi variabile, non esplicitato nella test case. Per sicurezza lo matengo connesso per più di un minuto
    Then I connect the device "Test_Concept-01", in the project "esol_ap29551_qa", for 100 seconds, then disconnect it.
    #Step 2: Maintain the device disconnected for 4 minutes,
    Then I wait 4 minutes after script
     #then reconnect it: (deve essere disconnesso di nuovo per non lasciare operazioni in pending)
    Then I connect the device "Test_Concept-01", in the project "esol_ap29551_qa", for 30 seconds, then disconnect it.

    #------------------------ Step 3 -----------------------------------
    #Verify the Business alarm is not created

      # check on Alarms page on DMC
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption
    #Then I check the presence of AlarmsPage...
    Then I input "Test_Concept-01 " in AlarmsPage.searchBox
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I wait 5 seconds
    And I check the presence of AlarmsPage.lastAlarmWithTestConcept01IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    #Check the absence of a business alarm, for sure the last alarm is a lifecycle alarm because gatewaay was connected
    Then I check the absence of AlarmsDetailsPage.businessInDetails
    And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it

      #------------------------------------Remove configuration to restore changes---------------------------------------

      # remove Device Alarms Configurations
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmTestConcept1 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it

    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteTestConcept01Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it