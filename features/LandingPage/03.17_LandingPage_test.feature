@LandingPage_Test_3.17
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

  Scenario: Test 3.17
    #GOAL
    #Check export the data in excel format.

    #PROCEDURE
    #Step 2
    #Within the Landing Page check if the values are correctly displayed.
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar
    Then I save number of csv file in directory
    And I check the presence of ProjectPage.downloadExportIcon Element and then i click it
    Then I wait 3 seconds
    And I confirm file download

    #Step 3
    #Click on the EXPORT DATA button on the upper right side of the page, then after selected the destination folder for the download, check if the file is an excel type.
    Then I check if export file with csv format is downloaded successfully and I delete it

    #Logout Step
    Then I click on the user icon and log out.