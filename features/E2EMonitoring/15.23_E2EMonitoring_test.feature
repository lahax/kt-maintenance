@E2EMonitoring_Test_15.23
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login on DMC"
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

  Scenario: Test_15.23

    ## ---------- GOAL ---------- ##
    ## Custom groups page presents the add groups button. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Custom Groups page page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.customGroupsSubOption

    # STEP 3
    # Verify that in the bottom right of the page there is a "+" button where you can add new groups:
    Then I check the presence of CustomGroupsPage.plusCustomGroupButton
    Then I click CustomGroupsPage.plusCustomGroupButton
    Then I check the presence of CustomGroupsPage.groupNameCustomGroupsAddLabel
    Then I check the presence of CustomGroupsPage.gatewayCustomGroupsAddLabel
    Then I check the presence of CustomGroupsPage.thingCustomGroupsAddLabel
    Then I check the presence of CustomGroupsPage.addGatewayThingPlusButton
    Then I check the presence of CustomGroupsPage.directThingCustomGroupsAddLabel
    Then I check the presence of CustomGroupsPage.addDirectThingPlusButton
    Then I check the presence of CustomGroupsPage.selectedDevicesCustomGroupsAddLabel
    Then I check the presence of CustomGroupsPage.saveNewCustomGroupButton
