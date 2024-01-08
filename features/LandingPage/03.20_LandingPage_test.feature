@LandingPage_Test_3.20
Feature: LandingPage
#https://confluence.springlab.enel.com/display/EXEGIPL/DMC+NRT+Test+case+3.20
  #GOAL: The Profile page is correctly viewed.
  Background:

    # STEP 1 - Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 3.20
    # Step 2 - Click on User Section, on the top right of the page, near the notification bell
    Then I enter on "esol-ap29551-qa" project
    Then I wait the progress bar for a maximum of "180" seconds
    And I click HomePage.infoUserLoggedIn
    # Step 3
    #3a. Click on "Profile".
    And I click HomePage.profileSubOption
    #3b. Check the correct view of the Profile page.
    And I check the presence of HomePage.profileTitle
    And I check the presence of HomePage.profileAccess
    And I check the presence of HomePage.profileTableHeaderAuthorization
    And I check the presence of HomePage.profileTableHeaderFeature
    # Step 4 - clicks on User Guide, the user guide will be downloaded.

    Then I save number of "pdf" files in directory

    And I click HomePage.infoUserLoggedIn
    And I click HomePage.userGuideSubOption

    Then I confirm file download
    And I wait 15 seconds

    And I check if export file with "pdf" format is downloaded successfully and I delete it

    And I click on the user icon and log out.