@LandingPage_Test_3.8
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

  Scenario: Test 3.8
    #GOAL
    #Check that a single graph including:
    #a bargraph showing the number of registered devices for each months
    #a line showing the number of activations for each months

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the values displayed are correct:
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.devicesLegend
    Then I check the presence of ProjectPage.activationsLegend
    #Logout Step
    Then I click on the user icon and log out.