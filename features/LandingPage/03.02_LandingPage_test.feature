@LandingPage_Test_3.2
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

  Scenario: Test 3.2
    #GOAL
    #The Project Cards on the landing page are correctly shown.

    #PROCEDURE
    #Step 2
    #Select more than one project and check that the project cards are correctly show:
    Then If present i click Clear Button
    #Then I check the presence of the project "esol-ap2955110-perf" and then i click it
    #Then I check the presence of the project "esol-ap2955110-dev" and then i click it
    Then I enter first two projects and save titles
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the apm title are the same as saved
    Then I check the presence of ProjectPage.cardsContainer
    Then I check the Element ProjectPage.cardTitle has text
    Then I check the Element ProjectPage.projectID has text
    Then I check the Element ProjectPage.onlineNumber has text
    Then I check the Element ProjectPage.projectRegion has text