@Industry_Test_28.24
Feature: Industry
#GOAL: Change the language in Italian and check that all section are correctly translated
  Background:
    #STEP 0 - Login and set Language english as default
    #1a User login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 28.24
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    And I click DevicesPage.filterBox
    #2 Click on User Section, on the top right of the page, near the notification bell:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    #3a. Go with the pointer on "Language" and choose "Italiano":
    When I click HomePage.buttonItalianoSubOption
    #3b. Check that all test of the Requirement are correctly translated in Italian.

    #Devices Page (#Things Page, #Activities Page)
    #TODO_ Things page, verificare le tabelle in tutte le pagine
    And I check that the Devices page is correctly translated in italian
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    #Things todo
    #Ativities
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.activitiesOption
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    And I check that the Activities page is correctly translated in italian
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
    #Step Function
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    And I click on the user icon and log out.