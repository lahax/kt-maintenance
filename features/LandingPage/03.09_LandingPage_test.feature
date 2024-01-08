@LandingPage_Test_3.9
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

  Scenario: Test 3.9
    #GOAL
    #The Activation trend should have a selectable time range of 3/6 months with month granularity.

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the values displayed are correct:
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    And I wait 10 seconds
    Then I check if the graph for the "Devices & Activations" section show "6" months as expected
    Then I check if the graph for the "Devices & Activations" section show "3" months as expected
    #Logout Step
    Then I click on the user icon and log out.