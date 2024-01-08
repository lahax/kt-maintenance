@E2EMonitoring_Test_15.32
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
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

    # ------------------------------------------------------------------------------
    # ------------------------------------------------------------------------------
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    # Additional background for the Test Case: repeat operation for the custom group created on DMC NRT Test Case 15.26
    Then If "1532" is present I delete it
    # STEP 2 2 (Test Case 15.26)
    # Click on the + Button to create an custom group
    Then I check the presence of CustomGroupsPage.addGroupBTN Element and then i click it
#    # STEP 3 (Test Case 15.26)
#    # Insert a group name
    And I type "1532" into the element CustomGroupsPage.addGroupName
    # then add:
    # A thing
    Then I type "Test_Concept-01 " into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept01Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    #Then I input "Test_Concept" in CustomGroupsPage.addThingBox
    Then I check the presence of CustomGroupsPage.testConcept01thing1 Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A direct thing
    Then I type "DirectXX" into the element CustomGroupsPage.addDirectThingBox
    Then I cancel a letter from the input box element CustomGroupsPage.addDirectThingBox
    And I check the presence of CustomGroupsPage.directThingXX Element and then i click it
    And I check the presence of CustomGroupsPage.addDirectThingBTN Element and then i click it
    # A gateway with all it things (you should be able to simulate this gateway)
    Then I type "Test_Concept-02 " into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    Then I check the presence of CustomGroupsPage.testConcept02Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.allThingsOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
    # A gateway without things
    Then I type "Test_Concept-03 " into the element CustomGroupsPage.addGateway
    Then I type " " into the element CustomGroupsPage.addGateway
    #Then I click Element DeviceAlarmsConfigurationPage.outsideDiv using Javascript
    Then I check the presence of CustomGroupsPage.testConcept03Device Element and then i click it
    Then I check the presence of CustomGroupsPage.addThingBox Element and then i click it
    Then I check the presence of CustomGroupsPage.onlyGatewayOption Element and then i click it
    And I check the presence of CustomGroupsPage.addThingBTN Element and then i click it
#    # Save
    Then I check the presence of CustomGroupsPage.saveAddingGroupBTN Element and then i click it
    And I check the presence of CustomGroupsPage.toastMessageClose Element and then i click it
  Scenario: Test 15.32

    ## ---------- GOAL ---------- ##
    ## Create E2E rule with:
    #    - perimeter: custom group
    #    - Rule: Business
    #    - Continuos
    #    - Notifications: all
    ## ----------      ---------- ##

    # STEP 1 Login on DMC and go in E2E - Device Configuration page
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.deviceAlarmsConfigurationSubOption
    Then I wait the progress bar
    # STEP 2
    # Click on the Wizard Button to create an alarm
    Then I click DeviceAlarmsConfigurationPage.wizardBTN

    # STEP 3
    # Create an alarm with scope the custom group created on DMC NRT Test Case 15.26 ,
    # following the same configuration as DMC NRT Test Case 15.30
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
    # Group and insert in Custom Group the test gateway for the E2E test
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowTAB Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.customGroupDeviceOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup Element and then i click it
    And I type "1532" into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I type " " into the element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    Then I cancel a letter from the input box element DeviceAlarmsConfigurationPage.selectionBoxDevicesGroup
    And I check the presence of DeviceAlarmsConfigurationPage.groupTest1532 Element and then i click it

    #Then I click Element DeviceAlarmsConfigurationPage.groupTestConcept1532 using Javascript

    #Then I wait 10 seconds
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab Element and then i click it
    # Insert 5 min as time window
    And I clear DeviceAlarmsConfigurationPage.timeWindow
    And I type "5" into the element DeviceAlarmsConfigurationPage.timeWindow
    Then I check the presence of DeviceAlarmsConfigurationPage.timeWindowUnitDropDown Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.minUnitSelection Element and then i click it
    # Click on next
    And I check the presence of DeviceAlarmsConfigurationPage.buttonNextStepsTab2 Element and then i click it
    # Review the summary of the configuration and click Next to proceed
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
    # Use a different channel endpoint, for at least one channel type. This will help you verify the alarms are segregated according to the scope
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
    And I type "test15.32" into the element DeviceAlarmsConfigurationPage.topicToInsertBox
    # RDE ALARM
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardAddChannelsBTN Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.dropDownArrowSelectOptionChannel Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.channelRdeAlarmOptionToSelect Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardSaveBTN Element and then i click it
    # Controll Wizard Completed and Exit
    Then I check the presence of DeviceAlarmsConfigurationPage.wizardCompleted
    Then I check the presence of DeviceAlarmsConfigurationPage.finalExitButton Element and then i click it
    And I wait 60 seconds after script

    # ------------------------------------ Remove configuration to restore changes --------------------------------------- #

    # remove Device Alarms Configurations
    And I check the presence of DeviceAlarmsConfigurationPage.iconTrashAlarmCustomGroup1532 Element and then i click it
    Then I check the presence of DeviceAlarmsConfigurationPage.deleteButton Element and then i click it
    And I check the presence of NotificationsConfigurationsPage.toastMessageClose Element and then i click it

    # remove Notifications Configurations
    Then I click HomePage.hamburgerMenuIcon
    And I click SidebarPage.notificationsConfigurationSubOption
    And I check the presence of NotificationsConfigurationsPage.deleteCustomGroup1532Notification Element and then i click it
    Then I check the presence of NotificationsConfigurationsPage.confirmDeleteButton Element and then i click it
    And I check the presence of NotificationsConfigurationsPage.toastMessageClose Element and then i click it

    # remove Custom Group
    Then I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it
    Then If "1532" is present I delete it
    # ------------------------------------ Remove configuration to restore changes --------------------------------------- #