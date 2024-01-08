@E2EMonitoring_Test_15.25
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

  Scenario: Test case 15.25

    ## ---------- GOAL ---------- ##
    ## Custom groups page is correctly translated. ##
    ## ----------      ---------- ##

    # STEP 2
    # Access to DMC, open side menu then click on E2E Monitoring and then select Custom Groups page
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon
    And I click HomePage.hamburgerMenuIcon
    Then I check the presence of SidebarPage.e2eMonitoringOption Element and then i click it
    Then I check the presence of SidebarPage.customGroupsSubOption Element and then i click it

    # STEP 3
    # On the top right of the page, near the notification bell:
    And I click HomePage.infoUserLoggedIn

    # STEP 4
    # Go with the pointer on "Language" and choose a language:
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    And I check that the Custom Group page is correctly translated