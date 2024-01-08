@LandingPage_Test_3.1
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

  Scenario: Test 3.1
    #GOAL
    #The Aggregated Data section is correctly shown.

    #PROCEDURE
    #Step 2
    #Select more than one project and check the Aggregated Data section on the top left of the page:
    Then If present i click Clear Button
    Then I enter first two projects
    Then I wait the progress bar for a maximum of "180" seconds
    Then I check the presence of ProjectPage.aggregatedDataLabel

    #Step 3
    Then I check the presence of ProjectPage.logoEnel Element and then i click it
    Then I wait the progress bar
    Then If present i click Clear Button
    Then I select top 5 projects
    Then If present i click on Enter Button

    Then I wait the progress bar for a maximum of "180" seconds
    #to complete because the DMC do not load the page: DMC BUG
    Then I check the presence of ProjectPage.aggregatedDataLabel