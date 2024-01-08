@E2EMonitoring_Test_15.9
Feature: E2EMonitoring

  Background:

    # STEP 1 "Login To DMC"
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

  Scenario: Test_15.9

    ## ---------- GOAL ---------- ##
    ## Notifications Configurations action column is correctly shown. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Notification configuration page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.e2eMonitoringOption
    Then I click SidebarPage.notificationsConfigurationSubOption
    And I wait the progress bar
    # Check I'm on the correct page:
    And I check the presence of NotificationsConfigurationsPage.notificationsConfigurationsPageTitle

    # ------------------------------------ Notification creation  --------------------------------------- #
    Then If there is not at least one notification I create one
    # ------------------------------------ Alarm Creation End --------------------------------------- #
    # STEP 3
    # Check that actions columns has 3 buttons:
    #   More info (page button)
    #   Edit (pencil button)
    #   Subscribe (bell button)
    #   Delete (bin button)
    Then I check the presence of NotificationsConfigurationsPage.iconDocumentFirstRow
    Then I check the presence of NotificationsConfigurationsPage.iconPencilFirstRow
    Then I check the presence of NotificationsConfigurationsPage.iconBellFirstRow
    Then I check the presence of NotificationsConfigurationsPage.iconTrashFirstRow
    # Check the correct view of all details pages:
    And I click on NotificationsConfigurationsPage.iconDocumentFirstRow action icon and check the landing page or pop up - Notification Page
    And I click on NotificationsConfigurationsPage.iconPencilFirstRow action icon and check the landing page or pop up - Notification Page
    And I click on NotificationsConfigurationsPage.iconBellFirstRow action icon and check the landing page or pop up - Notification Page
    And I click on NotificationsConfigurationsPage.iconTrashFirstRow action icon and check the landing page or pop up - Notification Page

      # Delete If notification created
    Then If I created a notification I delete it
    # Step 4
    # Also check in tablet mode the correct view of all details pages.
    #Then I set chrome "iPad pro" mode
    #And I click on NotificationsConfigurationsPage.iconDocumentFirstRow action icon and check the landing page or pop up - Notification Page
    #And I click on NotificationsConfigurationsPage.iconPencilFirstRow action icon and check the landing page or pop up - Notification Page
    #And I click on NotificationsConfigurationsPage.iconBellFirstRow action icon and check the landing page or pop up - Notification Page
    #And I click on NotificationsConfigurationsPage.iconTrashFirstRow action icon and check the landing page or pop up - Notification Page
