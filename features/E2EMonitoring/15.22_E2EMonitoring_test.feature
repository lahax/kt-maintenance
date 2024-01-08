@E2EMonitoring_Test_15.22
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

  Scenario: Test_15.22

    ## ---------- GOAL ---------- ##
    ## In Custom groups table, the actions column is correctly shown. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Custom Groups page page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.customGroupsSubOption

    # STEP 3
    # Check that actions columns has 3 buttons:
    #         More info (page button)
    #         Edit (pencil button)
    #         Copy(paper button)
    #         Delete (bin button)
    Then I check the presence of CustomGroupsPage.iconDocumentFirstRow
    Then I check the presence of CustomGroupsPage.iconPencilFirstRow
    Then I check the presence of CustomGroupsPage.iconCopyFirstRow
    Then I check the presence of CustomGroupsPage.iconTrashFirstRow

    And I click CustomGroupsPage.iconDocumentFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconPencilFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconCopyFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconTrashFirstRow action icon and check the landing page or pop up

    # STEP 4
    # Also check in tablet mode the correct view of all details pages.
    Then I set chrome "iPad pro" mode
    And I click CustomGroupsPage.iconDocumentFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconPencilFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconCopyFirstRow action icon and check the landing page or pop up
    And I click CustomGroupsPage.iconTrashFirstRow action icon and check the landing page or pop up

    And I click on the user icon and log out.
