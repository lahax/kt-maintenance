@Devices_Test_5.12
Feature: Devices

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 5.12

    Then I enter on "esol-ap29551-qa" project

    #Step 2
    #Go on Devices page and check the presence of the Export Data button:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I wait the progress bar
    #I input in the search bar to have a ligher file
    Then I input "Test_Concept" in DevicesPage.searchBox
    And I check the presence of DevicesPage.downloadExportIcon Element and then i click it

    #Step 3
    #Click the button and check the file downloaded. The file must have these the components:
    And I check the presence of DevicesPage.confirmExportButton Element and then i click it
    #Then I read the devices exported file and check the row and columns are as expected
    Then I read the devices exported csv file and check the row and columns are as expected

    #Logout Step
    Then I click on the user icon and log out.