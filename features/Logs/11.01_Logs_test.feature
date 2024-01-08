@Logs_Test_11.1
Feature: Logs

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 11.1

    #STEP 1 - Login on DMC

    Then I enter on "esol-ap29551-qa" project

    #STEP 2 - Check that the table is composed by 6 columns: Timestamp, Project, Source, Message, Status and Actions
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.logOption
    And I check the presence of LogPage.logsLandingPageTitle

    And I check the presence of LogPage.timestampColumnHeader
    And I check the presence of LogPage.projectColumnHeader
    And I check the presence of LogPage.sourceColumnHeader
    And I check the presence of LogPage.typeColumnHeader
    And I check the presence of LogPage.messageColumnHeader
    And I check the presence of LogPage.statusColumnHeader
    And I check the presence of LogPage.actionColumnHeader

    #Check also in tablet mode
    #Then I set chrome "IPad pro" mode

    #And I check the presence of LogPage.timestampColumnHeader
    #And I check the presence of LogPage.projectColumnHeader
    #And I check the presence of LogPage.sourceColumnHeader
    #And I check the presence of LogPage.typeColumnHeader
    #And I check the presence of LogPage.messageColumnHeader
    #And I check the presence of LogPage.statusColumnHeader
    #And I check the presence of LogPage.actionColumnHeader