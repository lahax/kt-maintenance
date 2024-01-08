@E2EMonitoring_Test_15.31
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login on DMC and go in E2E - Device Configuration page"
    # - The first step to access the DMC is logging in using the Enel email account or service number and password
    # - After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail
    #   or service number in the format shown in the imag
    # - After this step, you are redirected to sts.enel.com to login into the system
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: E2E Monitoring Test 15.31

    ## ---------- GOAL ---------- ##
    ## Create E2E rule with:
    #    - perimeter: GW
    #    - Rule: Business
    #    - Continuos
    #    - Notifications: all
    ## ----------      ---------- ##

    # STEP 1
    # Login on DMC and go in E2E - Device Configuration page
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I click SidebarPage.e2eMonitoringDropDownOption
    And I check the presence of SidebarPage.deviceAlarmsConfigurationSubOption Element and then i click it

    Then I check and clear if alarm all type is present

    # STEP 2
    # Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN

    # STEP 3
    # Create an alarm on scope ALL, following the same configuration as DMC NRT Test Case 15.30
    # Use a different channel endpoint, for at least one channel type. This will help you verify the alarms are segregated according to the scope
    # Choose Devices
    Then I check the presence of DeviceAlarmsConfigurationPage.monitorDevicesRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Configure a new alarm
    Then I check the presence of DeviceAlarmsConfigurationPage.configureNewAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Business
    Then I check the presence of DeviceAlarmsConfigurationPage.businessAlarmRadioBTN Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Group and insert in Devices Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.allDeviceOptionToSelect Element and then i click it
    Then I wait 1 seconds
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    # Insert 5 min as time window
    And I type "5" minutes into the element DeviceAlarmsConfigurationPage.timeWindow
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.alarmConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab3 Element and then i click it
    # Click Yes to proceed with the configuration
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Select Continuous
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.continuousOption Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextNotification Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.notificationConfigurationSummaryTitle
    And I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Click Yes to continue
    And I check the presence of DeviceAlarmsConfigurationPage.wizardYesRadioBTN Element and then i click it
    And I check the presence of DeviceAlarmsConfigurationPage.wizardNextBTN Element and then i click it
    # Insert a Channel for each type then click on Save
    # Email
    And I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelEmailOptionToSelect Element and then i click it
    And I type the random mail into the element DeviceAlarmsConfigurationPage.emailToInsertBox
    # Cellphone
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelSmsOptionToSelect Element and then i click it
    And I type "+393333333333" into the element DeviceAlarmsConfigurationPage.phoneNumberToInsertBox
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

    # STEP 4
    # Access AWS Console with role IoTSupport or DMC role (according to the test environment)
    # Open DynamoDB table esol_ap27611_<env>_ddb_device_monitoring
    # Click on Filer and add the filter project_id equal to the APM selected
    # Open the notification related to the test's scope
    # check the business_alarm parameter is present with the following information:
    #   - "disconnection_window_threshold" : it should be equal to the period set on the configuration, with seconds as measure unit
    #   - "rde_rule_id"
    Then I check the scope of alarm of DynamoDB 'esol_ap27611_test_ddb_devices_monitoring' in the project 'esol-ap29551-qa'
    Then I check the disconnection window threshold in DynamoDB 'esol_ap27611_test_ddb_devices_monitoring' in the project 'esol-ap29551-qa'

    # ----------------------------------- Remove Alarm ----------------------------------- #
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmAll Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.toastMessageClose Element and then i click it

    # ----------------------------------- Remove Alarm Notification Configuration ----------------------------------- #
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.iconTrashFirstRow Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it