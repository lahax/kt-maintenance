@LandingPage_Test_3.19
Feature: LandingPage

  Background:

    # STEP 1
    # Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 3.19
    #Step 2
    #Translation Landing Page check.
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption
    #Check translation
    #Then I check the presence of ProjectPage.labelAlarmsIT Element and then i click it
    #Then I check the presence of ProjectPage.labelDeviceAndActivationIT Element and then i click it
    Then I wait 30 seconds
    And I check that the Landing page is correctly translated in italian

    And I click on the user icon and log out.