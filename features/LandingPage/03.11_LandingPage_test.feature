@LandingPage_Test_3.11
Feature: LandingPage
# GOAL: Check that the graph correcly shows: a bargraph with the number of alarms for each month; a line with the percentage of alarms/devices for each month
  Background:
# STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 3.11
# STEP 2 - Within the Landing Page check if the values displayed are correct:
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.labelAlarms
    Then I wait 30 seconds
    Then I check the presence of ProjectPage.alarmsDevicesLegend
    Then I check the presence of ProjectPage.alarmsLegend
# EXTRA STEP to verify: Step 2 https://jira.springlab.enel.com/browse/EXEGIP2-1828 #TODO update confluence
    #The legend of alarm graph contains: Gateway alarms; Thing alarms; Direct Thing alarms; Custom Group alarms; All devices alarms; Alarms/Devices
    Then I check the presence of ProjectPage.gatewayAlarmsLegend
    Then I check the presence of ProjectPage.thingAlarmsLegend
    Then I check the presence of ProjectPage.directThingAlarmsLegend
    Then I check the presence of ProjectPage.customGroupAlarmsLegend
    Then I check the presence of ProjectPage.targetAllAlarmsLegend
    Then I check the presence of ProjectPage.alarmDevicesAlarmsLegend

    #Logout Step
    Then I click on the user icon and log out.