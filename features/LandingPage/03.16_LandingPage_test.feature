@LandingPage_Test_3.16
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

  Scenario: Test 3.16
    #GOAL
    #The "export data" button is present on DMC.

    #PROCEDURE
    #Step 2
    #On top right of the Landing page, near the user section, there is the Export button:
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.downloadExportIcon


      #Logout Step
    Then I click on the user icon and log out.