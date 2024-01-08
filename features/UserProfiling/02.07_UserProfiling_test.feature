@User_Profiling_Test_2.7
Feature: User Profiling

  Background:

    #Step 1
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    #Open DMC login page, login with a user that has CompAC groups for at least two projects.
    Then I click LoginPage.loginBtn
    Then I perform login as "basic" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 2.7
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    # NOTA: implicito che alla things list si accede dalla Device Details Page, non chiaro dalla test list
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I wait the progress bar
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    And I wait the progress bar
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #In the things list, check that the Basic role does not have access to the Activate Thing button,

    Then I check the presence of DevicesDetailsPage.enterToThingsList Element and then i click it
    And I check the presence of DevicesDetailsPage.moreInfoThingsBTN Element and then i click it
    Then I check that the element DevicesDetailsPage.activateThingsBTN is not active.
    And I check the presence of DevicesDetailsPage.closeFloatingBTN Element and then i click it

    # moreover in the thing action window only the More Info button is clickable.
    And I check the presence of DevicesDetailsPage.concept01Thing1moreInfo Element and then i click it
    Then I check that the element DevicesDetailsPage.deactivateThingsBTN is not active.
    Then I check that the element DevicesDetailsPage.showLogsThing is not active.
    Then I check that the element DevicesDetailsPage.updateThingBTN is not active.
    Then I check that the element DevicesDetailsPage.telemetryThingBTN is not active.
    Then I check that the element DevicesDetailsPage.tailLogsBTN is not active.
    Then I check that the element DevicesDetailsPage.connHistoryBTN is not active.
    Then I check that the element DevicesDetailsPage.firmwareUpdateThingBTN is not active.

    Then I check that the element DevicesDetailsPage.moreInfoThingBTN is active.
