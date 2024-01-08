@LandingPage_Test_3.15
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

  Scenario: Test 3.15
    #GOAL
    #Notification bell: After 4 characters, there are "..."

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the notification bell is correctly shown.
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.bellIcon


        #Logout Step
    Then I click on the user icon and log out.