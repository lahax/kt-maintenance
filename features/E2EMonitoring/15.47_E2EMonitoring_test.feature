@E2EMonitoring_Test_15.47
Feature: E2EMonitoring

  Background:

    #STEP 0 - Login and set Language english as default
   Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
   Then I click LoginPage.loginBtn
   Then I perform login as "basic_CompacF_false" user
   And I click HomePage.infoUserLoggedIn
   Then I click HomePage.languageSubOption
   When I click HomePage.buttonEnglishSubOption

  Scenario: Test 15.47

  #Step 1
  #Login on DMC and go in E2E - Device Configuration page
  #Click on the wizard
  #Choose Devices

 Then I enter on "esol-ap29551-qa" project

    #Requisiti: Choose the alarm created on DMC NRT Test Case 15.44
   #--------------------------------------------Test Case 15.44-------------------------------------------------------------------
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.notificationsConfigurationSubOption

   #If present I delete the cloud component alarm
    Then If Element NotificationsConfigurationsPage.deleteCloudNotification is present I click it
    Then If Element NotificationsConfigurationsPage.confirmDeleteButton is present I click it
    Then If Element NotificationsConfigurationsPage.toastMessageClose is present I click it

   # STEP 2
   # Click on the Wizard Button to create an alarm
    Then I click NotificationsConfigurationsPage.wizardBTN
   # Choose Cloud Component
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorCloudComponentRadioBTN Element and then i click it
   # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   # Select "commandto"
    And I check the presence of DeviceAlarmsConfigurationPage.microserviceDropDownBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.commandtoOption Element and then i click it
   # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro1 Element and then i click it
   # Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro2 Element and then i click it
   # Skip Max Frequency
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
   # Review and click Save to continue
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   # Insert a Channel for each type then click on Save
   # Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    Then I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
   # Cellphone
  #Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
  #Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
  #Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
  #Then I save telephone number
  #Then I type the telephone number saved into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
   # Topic
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelTopicOptionToSelect Element and then i click it
    And I type "testtest" into the element DeviceAlarmsConfigurationPage.topicToInsertBox
   # RDE ALARM
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelRdeAlarmOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
   # Controll Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it
    Then I check the mail boxes
 #------------------------------------------------------------------------------------------------------------------------------

   #Add notification for existing alarm
   #Choose the alarm created on DMC NRT Test Case 15.44
   #Set scheduled as Notification window. The time period chosen should let you have just a subset of alarms created during this period of time
#-------------------------------------15.46 Start------------------------------------------------------------------------
   #Step 1
   #Login on DMC and go in E2E - Device Configuration page
   #Click on the wizard
   #Choose Devices
    Then I click DeviceAlarmsConfigurationPage.wizardBTN
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorCloudComponentRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
   # Select "commandto"
    And I check the presence of DeviceAlarmsConfigurationPage.microserviceDropDownBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.commandtoOption Element and then i click it
   # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro1 Element and then i click it
   # Select Scheduled
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB2 Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.scheduledOption Element and then i click it
     #WEEKDAY FROM:
    Then I click on the current day
    Then I select the current hour window plus "10" minutes
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextMicro2 Element and then i click it
    #Remove the max frequency set, if present.
    #FAILED
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification3 Element and then i click it
    # Click on Save BTN
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.exitBTN Element and then i click it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
 #----------------------------Repeat DMC NRT Test Case 15.45 -----------
   #STEP 2
   # - AWS Control
   Then I check the trigger data and the trigger type configuration in DynamoDB 'esol_ap27611_test_ddb_notification_configuration' in the project 'esol-ap29551-perf'
  #---------------------------------------------------Create activity NO GATEWAY and test alarm-----------------------------------------------------------
   Then I click HomePage.hamburgerMenuIcon
    #Step 2
    #Access to DMC, open sidemenu then click on Activities.
   Then I click SidebarPage.activitiesOption
    #If a previous test got failed and didnt deleted the activity
    Then I input "TestConceptNoGateway" in ActivitiesPage.searchInputBox
   Then If Element ActivitiesPage.activityTestConceptNoGatewayDeleteIcon is present I click it
   Then If Element ActivitiesPage.confirmDeleteButton is present I click it
   Then If Element ActivitiesPage.toastMessageClose is present I click it
    #Create a new activity, using the pre-defined payload.
   Then I click ActivitiesPage.newActivityPlusBTN
   And I type "TestConceptNoGateway" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "NotExistingGateway",
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
   Then I click ActivitiesPage.confirmNewActivityButton
   Then I click ActivitiesPage.toastMessageClose
   Then I wait 10 seconds
   # Step 3
   #Listen to MQTT Topic
    Then I kill the notify_job command still opened
    Then I listen to MQTT topic given for Cloud Component, in the project "esol_ap29551_qa"
   # Execute the activity created without adding gateway ID or other info
    Then I reload the page
    Then I input "TestConceptNoGateway" in ActivitiesPage.searchInputBox
   Then I check the presence of ActivitiesPage.activityTestConceptNoGatewayPlayIcon Element and then i click it

   Then I click ActivitiesPage.confirmRunActivityButton
   #To check if a new alarm was produce by this process i have to save the current timestamp and condition that the one on the alarm is bigger than this
   Then I save current timestamp to check alarm
    #---------------------------------------------------Check Alarm  -----------------------------------------------------------
    #Step 4
    #Verify the Cloud alarm is created:
    #check on Log page on DMC
   Then I click HomePage.hamburgerMenuIcon
   Then I click SidebarPage.logOption
   Then I input "commandto" in LogPage.searchInputBox
    #I wait the alarm to be created
   Then I wait 80 seconds
   And I check the presence of LogPage.refreshBTN Element and then i click it
   And I wait the progress bar
   And I check the presence of LogPage.lastLogwithCommandDtoDetailIcon Element and then i click it
   Then I check the presence of LogPage.logsDetailsLandingPageTitle
   Then I check the presence of LogPage.commandDtoInDetails
   #I use the timestamp saved to check if timestamp alarm on DMC is greater than the saved one
   Then I check the alarm was created successfully
     #if they are the same alarm was not created, if different alarm created
   And I save alarm timestamp to check next alarm not created

   And I check the presence of LogPage.backBTN Element and then i click it

    #check the alarm is received on email and phone number indicated
   Then I wait 60 seconds
    Then I check message of "cloud component" notification in mail boxes, from device "commandto" in the project "esol-ap29551-qa"
    #Then I check text "commandto" is in sms boxes body

#   #Check MQTT
    And I check that MQTT is receiving a notification message with fields: "\"message\": \"[Project: esol-ap29551-qa] connector commandto notified the following message" and "cloud"
    And I kill the notify_job command still opened
    #------------------------------------------------------------------------------------------------------------------------------

    #---------------------------------------------------Create activity WITH GATEWAY and test alarm-----------------------------------------------------------
   Then I click HomePage.hamburgerMenuIcon
    #Step 2
    #Access to DMC, open sidemenu then click on Activities.
   Then I click SidebarPage.activitiesOption
    #If a previous test got failed and didnt deleted the activity
    Then I reload the page
    Then I input "TestConcept" in ActivitiesPage.searchInputBox
    Then If Element ActivitiesPage.activityTestConceptDeleteIcon is present I click it
    Then If Element ActivitiesPage.confirmDeleteButton is present I click it
    Then If Element ActivitiesPage.toastMessageClose is present I click it
    #Create a new activity, using the pre-defined payload.
    Then I click ActivitiesPage.newActivityPlusBTN
    And I type "TestConcept" into the element ActivitiesPage.activityIdInputLabel
    And I input the payload into ActivitiesPage.activityDescriptionInput
    """
    {
    "version": "1.0",
    "gateway_id": "Test_Concept-04",
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
    Then I click ActivitiesPage.confirmNewActivityButton
    Then I click ActivitiesPage.toastMessageClose
    Then I reload the page
    Then I input "TestConcept" in ActivitiesPage.searchInputBox
    And I check the presence of ActivitiesPage.activityTestConceptPlayIcon Element and then i click it
    Then I click ActivitiesPage.confirmRunActivityButton


    #Step 4
    #Verify the Cloud alarm is created:
    #check on Log page on DMC
   Then I click HomePage.hamburgerMenuIcon
   Then I click SidebarPage.logOption
   Then I reload the page
   Then I input "commandto" in LogPage.searchInputBox
   Then I wait 60 seconds
   And I check the presence of LogPage.refreshBTN Element and then i click it
   And I wait the progress bar
   And I check the presence of LogPage.lastLogwithCommandDtoDetailIcon Element and then i click it
   Then I check the presence of LogPage.logsDetailsLandingPageTitle
   Then I check that alarm was not created
   And I check the presence of LogPage.backBTN Element and then i click it
    #TODO
    #check the message is published on MQTT topic

    #check the alarm is not received
     #email
   Then I check the number of emails received and expect 2 notification

#------------------------------------------------OUTSIDE THE NOTIFICATION WINDOW----------------------------------------
   Then I wait 11 minutes to be outside the notification window
#------------------------------------------------OUTSIDE THE NOTIFICATION WINDOW----------------------------------------

     #---------------------------------------------------Run activity no gateway-----------------------------------------------------------
   Then I click HomePage.hamburgerMenuIcon
   #Step 2
   #Access to DMC, open sidemenu then click on Activities.
   Then I click SidebarPage.activitiesOption
    Then I reload the page
    Then I input "TestConceptNoGateway" in ActivitiesPage.searchInputBox
   Then I check the presence of ActivitiesPage.activityTestConceptNoGatewayPlayIcon Element and then i click it
   Then I click ActivitiesPage.confirmRunActivityButton
   #To check if a new alarm was produce by this process i have to save the current timestamp and condition that the one on the alarm is bigger than this
   Then I save current timestamp to check alarm

    #---------------------------------------------------Check Alarm  -----------------------------------------------------------
    #Step 4
    #Verify the Cloud alarm is created:
    #check on Log page on DMC
   Then I click HomePage.hamburgerMenuIcon
   Then I click SidebarPage.logOption
    Then I reload the page
   Then I input "commandto" in LogPage.searchInputBox
    #I wait the alarm to be created
   Then I wait 60 seconds
   And I check the presence of LogPage.refreshBTN Element and then i click it
   And I wait the progress bar
   And I check the presence of LogPage.lastLogwithCommandDtoDetailIcon Element and then i click it
   Then I check the presence of LogPage.logsDetailsLandingPageTitle
   Then I check the presence of LogPage.commandDtoInDetails
   #I use the timestamp saved to check if timestamp alarm on DMC is greater than the saved one
   Then I check the alarm was created successfully
     #if they are the same alarm was not created, if different alarm created
   And I save alarm timestamp to check next alarm not created

   And I check the presence of LogPage.backBTN Element and then i click it
    #TODO
    #check the message is published on MQTT topic

    #check that outside the notification window no email is received
   Then I check the number of emails received and expect 2 notification

    #------------------------------------------------------------------------------------------------------------------------------


   #------------------------------------------------------------------------------------------------------------------------------
  # remove Activity no gateway
   Then I click HomePage.hamburgerMenuIcon
   Then I click SidebarPage.activitiesOption
    Then I reload the page
    Then I input "TestConcept" in ActivitiesPage.searchInputBox
   And I check the presence of ActivitiesPage.activityTestConceptNoGatewayDeleteIcon Element and then i click it
   And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
   And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it

   # remove Activity with gateway
    And I check the presence of ActivitiesPage.activityTestConceptDeleteIcon Element and then i click it
    And I check the presence of ActivitiesPage.confirmDeleteButton Element and then i click it
    And I check the presence of ActivitiesPage.toastMessageClose Element and then i click it


  # remove Notifications Configurations
   Then I click HomePage.hamburgerMenuIcon
   Then If Element SidebarPage.e2eMonitoringOption is present I click it
   And I click SidebarPage.notificationsConfigurationSubOption
   And I check the presence of NotificationsConfigurationsPage.deleteCloudNotification Element and then i click it
   Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it