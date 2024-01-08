@User_Profiling_Test_2.6
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

  Scenario: Test case 2.6
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Click the Devicespage, devices items are clickable
      # and the user can navigate to the device details page.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.devicesOption Element and then i click it
    And I check the presence of DevicesPage.devicesLandingPageTitle
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    # In the device details page are disabled all the links
      # and buttons
    Then I check that the element DevicesDetailsPage.remoteControlBTN is not active.
    Then I check that the element DevicesDetailsPage.rebootBTN is not active.
    Then I check that the element DevicesDetailsPage.firmwareUpdateBTN is not active.
    Then I check that the element DevicesDetailsPage.deactivateBTN is not active.
    Then I check that the element DevicesDetailsPage.updateGatewayBTN is not active.
    Then I check that the element DevicesDetailsPage.renewCertificatesBTN is not active.
    Then I check that the element DevicesDetailsPage.showLogsBTN is not active.
    Then I check that the element DevicesDetailsPage.getHistoryLogsBTN is not active.
    Then I check that the element DevicesDetailsPage.enableCollectLogsBTN is not active.
    Then I check that the element DevicesDetailsPage.greenGrassDeployBTN is not active.
    Then I check that the element DevicesDetailsPage.greenGrassResetBTN is not active.
    Then I check that the element DevicesDetailsPage.otaUpdateBTN is not active.