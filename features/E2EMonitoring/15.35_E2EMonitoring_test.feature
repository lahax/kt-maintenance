@E2EMonitoring_Test_15.35
Feature: E2EMonitoring

  Background:

    #Step 1
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: E2E Monitoring Test 15.35

    Then I enter on "esol-ap29551-qa" project

    #STEP 1 - Login on DMC, Access to DMC, open side menu then click on E2E Monitoring and then select Device alarms configuration page
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption

 #---------------------------------------------Alarm required Test 15.30 Start --------------------------------------
    # - Click on the Wizard Button to create an alarm
    Then I wait the progress bar
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
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
    And I input "Test_Concept-01" in DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    #Then I click Element DeviceAlarmsConfigurationPage.outsideDiv using Javascript
    #And I check the presence of DeviceAlarmsConfigurationPage.testConcept01Device Element and then i click it
    And If Element DeviceAlarmsConfigurationPage.testConcept01Device is present I click it
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
        #This is to subrscibe to AWS notification email:
    Then I check the mail boxes
    #---------------------------------------------Alarm required Test 15.30 END --------------------------------------

    #Step 1 -------------------------------------15.35 -----------------------------------------------------------
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
   # - Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
   #Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   # Add notification for existing alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.addNotificationForExistingAlarmRadioBTN Element and then i click it
   #Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Business
    Then I check the presence of DeviceAlarmsConfigurationPage.businessAlarmRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
     # Device Group dropdown
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    # Mappato existing device group
    Then I check the presence of DeviceAlarmsConfigurationPage.testConcept01ToSelect Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    #Set scheduled as Notification window. The time period chosen should let you have just a subset of alarms created during this period of time
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.scheduledOption Element and then i click it
    #WEEKDAY FROM:
    Then I click on the current day
    Then I select the current hour window plus "5" minutes
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro2 Element and then i click it
     #Click on Save BTN
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.exitBTN Element and then i click it

    #-----------------------------------------15.35 alarm completed --------------------------------------------------

    #------------------------------------------------Step2----------------------------------------------------------------
    #Access AWS Console with role IoTSupport or DMC role (according to the test environment)

    #Then I check the trigger data and the trigger type configuration in DynamoDB 'esol_ap27611_test_ddb_notification_configuration' in the project 'esol-ap29551-qa'

    #------------------------------------------------Step3----------------------------------------------------------------
    #Repeat DMC NRT Test Case 15.33  during the time window indicated
    #Verify alarms created during the time window indicated are received:

 #------------------------ Connect a device which belong both the the gateway of Test 15.30
    #Listen to MQTT Topic
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic, in the project "esol_ap29551_qa"


     #then reconnect it: (deve essere disconnesso di nuovo per non lasciare operazioni in pending)
    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"
    #And I wait 100 seconds
    And I wait 100 seconds after script
    And I disconnect the last device connected

    #Step 2: Maintain the device disconnected for 6 minutes,
    Then I wait 6 minutes after script
    Then If present i click on Enter Button
    #Verify the Business alarm is created:
      # check on Alarms page on DMC
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.alarmsOption
    #Then I check the presence of AlarmsPage...
    Then I input "Test_Concept-01 " in AlarmsPage.searchBox
    Then I wait 20 seconds
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I wait 5 seconds
    And I check the presence of AlarmsPage.lastAlarmWithTestConcept01IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    Then I check the presence of AlarmsDetailsPage.businessInDetails
    And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it
    #Check Email
    Then I check message of "business" notification in mail object, from device "Test_Concept-01" in the project "esol-ap29551-qa"
    #Check SMS
    #Then I check text "Test_Concept-01" is in sms boxes body
         #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "business_alarm" and "Test_Concept-01"
    #Disconnect the device at the end
    And I kill the notify_job command still opened

  #------------------------------------------------Step4----------------------------------------------------------------
    #Repeat DMC NRT Test Case 15.33 OUTSIDE the time window indicated
  #Verify alarms created during the time window indicated are received:
  #To be outside the window I have to wait at least 10 min

    Then I wait 6 minutes to be outside the notification window
#
 #------------------------ Connect a device which belong both the the gateway of Test 15.30
   Then I connect the device "Test_Concept-01", in the project "esol_ap29551_qa", for 100 seconds, then disconnect it.
   #Step 2: Maintain the device disconnected for 6 minutes,
   Then I wait 6 minutes after script
    #then reconnect it:
   #Then I connect the device "Test_Concept-01", in the project "esol_ap29551_qa", for 5 seconds, then disconnect it.
   #Verify the Business alarm is created:
     # check on Alarms page on DMC
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.alarmsOption Element and then i click it
    #Then I check the presence of AlarmsPage...
    Then I input "Test_Concept-01 " in AlarmsPage.searchBox
    Then I wait 10 seconds
    And I check the presence of AlarmsPage.refreshBTN Element and then i click it
    And I wait the progress bar
    And I wait 5 seconds
    And I check the presence of AlarmsPage.lastAlarmWithTestConcept01IconDetail Element and then i click it
    Then I check the presence of AlarmsDetailsPage.alarmsDetailsLandingPageTitle
    Then I check the presence of AlarmsDetailsPage.businessInDetails
    And I check the presence of AlarmsDetailsPage.backBTN Element and then i click it

    #email
    Then I check the number of emails received and expect 2 notification
  #Check MQTT
    And I check that MQTT is not receiving a notification message with field "business_alarm" from device "Test_Concept-01"

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