@Alarms_Test_12.1
Feature: Alarms
#GOAL: In the Alarms page the table has the correct columns
  Background:
  #STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 12.1
  #and go to the Alarms page
    Then I enter on "esol-ap29551-qa" project
    And I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    And I check the presence of SidebarPage.alarmsOption Element and then i click it
    And I check the presence of AlarmsPage.alarmsLandingPageTitle
  # STEP 2 - Check that the table is composed by 7 columns: Timestamp, Type, Project, Source, Message, Status and Actions (Actions colums has the figure not the name)
    And I check the presence of AlarmsPage.timestampColumnHeader
    And I check the presence of AlarmsPage.typeColumnHeader
    And I check the presence of AlarmsPage.projectColumnHeader
    And I check the presence of AlarmsPage.sourceColumnHeader
    And I check the presence of AlarmsPage.messageColumnHeader
    And I check the presence of AlarmsPage.statusColumnHeader
    And I check the presence of AlarmsPage.actionColumnHeader
  # STEP 3 - For each column with the information panel (Type, Message and Status) click on the "i" icon and verify that information is displayed as follows
  #Type
  And I check the presence of AlarmsPage.typeTooltipIcon Element and then i click it
  And I check the presence of AlarmsPage.typeTooltipTitle
  And I check the presence of AlarmsPage.typeTooltipTextThing
  And I check the presence of AlarmsPage.typeTooltipTextDevice
  And I check the presence of AlarmsPage.typeTooltipTextAggregated
  And I check the presence of AlarmsPage.closeTooltipButton Element and then i click it
  #Message
  And I check the presence of AlarmsPage.messageTooltipIcon Element and then i click it
  And I check the presence of AlarmsPage.messageTooltipTitle
  And I check the presence of AlarmsPage.messageTooltipTextLifecycle
  And I check the presence of AlarmsPage.messageTooltipTextBusiness
  And I check the presence of AlarmsPage.messageTooltipTextThreshold
  And I check the presence of AlarmsPage.messageTooltipTextDisservice
  And I check the presence of AlarmsPage.messageTooltipTextTelemetry
  And I check the presence of AlarmsPage.messageTooltipTextZero
  And I check the presence of AlarmsPage.messageTooltipTextAggregated
  And I check the presence of AlarmsPage.closeTooltipButton Element and then i click it
  #Status
  And I check the presence of AlarmsPage.statusTooltipIcon Element and then i click it
  And I check the presence of AlarmsPage.statusTooltipTitle
  And I check the presence of AlarmsPage.statusTooltipText
  And I check the presence of AlarmsPage.statusTooltipTextOnline
  And I check the presence of AlarmsPage.statusTooltipTextOffline
  And I check the presence of AlarmsPage.statusTooltipTextInAlarm
  And I check the presence of AlarmsPage.statusTooltipTextAlarmInvalidated
  And I check the presence of AlarmsPage.statusTooltipTextAlarmCleared
  And I check the presence of AlarmsPage.statusTooltipTextError
  And I check the presence of AlarmsPage.closeTooltipButton Element and then i click it