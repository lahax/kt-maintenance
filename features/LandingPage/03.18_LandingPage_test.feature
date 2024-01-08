@LandingPage_Test_3.18
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

  Scenario: Test 3.18
    #GOAL
    #Check export the data in excel format.

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the values are correctly displayed.
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    Then If present I delete export project page file in the downloaded folder
    And I check the presence of ProjectPage.downloadExportIcon Element and then i click it

    #Step 3
    #Click on the EXPORT DATA button on the upper right side of the page, then after selected the destination folder for the download, check if the file is an excel type.
   # Then I read the homepage exported file and check the row and columns are as expected

    Then I read the homepage exported file csv and check the row and columns are as expected
    #Then I read the homepage exported file csv and check the row and columns are as expected test click

    #Logout Step
    Then I click on the user icon and log out.