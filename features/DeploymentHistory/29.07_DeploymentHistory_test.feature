@29.07_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1258

  #GOAL: In the Deployment History detail page it's been added the status and the info icon (tooltip) for each column.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.7

    Then I enter on "esol-ap29551-qa" project

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #3a. Choose a Gateway and a Direct Thing, and click on the detail button
    #Gateway
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar
    Then I click on details icon of the device "Test_Concept-01"
    #2a. Go on Deployment History tab
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    And I wait the progress bar
    #2b. Click on Detail button of a single Deployment record and verify the new UI.
    Then I check the presence of DevicesDetailsPage.historyDetailsBtt Element and then i click it
    #It's been added the status of the DH;
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusBar
    #It's been added info icon (tooltip) for each column;
    #2c. Also verify the description of each tootlip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.customStatusTP Element and then i click it
    Then I check information in Deployment Details tab "Custom Status" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.packageInOutcomeTP Element and then i click it
    Then I check information in Deployment Details tab "Packages Installations Outcome" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.currentStackTP Element and then i click it
    Then I check information in Deployment Details tab "Current Stack" tooltip
    #It's been added the custom status;
    #Also it's been added all details fields.
    Then I check for presence of all details fields

    #Direct Thing
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I clear the search Box in the Device Page
    Then I input "DirectThingConcept2" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "DirectThingConcept2"
    #2a. Go on Deployment History tab
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    And I wait the progress bar
    #2b. Click on Detail button of a single Deployment record and verify the new UI.
    Then I check the presence of DevicesDetailsPage.historyDetailsBtt Element and then i click it
    #It's been added the status of the DH;
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusBar
    #It's been added info icon (tooltip) for each column;
    #2c. Also verify the description of each tootlip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.customStatusTP Element and then i click it
    Then I check information in Deployment Details tab "Custom Status" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.packageInOutcomeTP Element and then i click it
    Then I check information in Deployment Details tab "Packages Installations Outcome" tooltip
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.currentStackTP Element and then i click it
    Then I check information in Deployment Details tab "Current Stack" tooltip
    #It's been added the custom status;
    #Also it's been added all details fields.
    Then I check for presence of all details fields

    #Logout
    Then I click on the user icon and log out.
