@29.06_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1257

  #GOAL: The info icon (tooltip) explain to the user what labels and values mean.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.6

    Then I enter on "esol-ap29551-qa" project

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #3a. Choose a Gateway and a Direct Thing, and click on the detail button

    #Gateway:
    Then I input "eig-e2e-uat-00" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar
    Then I click on details icon of the device "eig-e2e-uat-00"
    #2a. Go on Deployment History tab
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    #2b. Verify for each column the presence of the Info Icon (tootlip):
    #2c. 2c. Also verify the description of each tootlip
    Then I check the presence of DevicesDetailsPage.SoftwareTypeTP Element and then i click it
    Then I check information in Deployment History tab "Software Type" tooltip
    Then I check the presence of DevicesDetailsPage.DeployTypeTP Element and then i click it
    Then I check information in Deployment History tab "Deploy Type" tooltip
    Then I check the presence of DevicesDetailsPage.StartTP Element and then i click it
    Then I check information in Deployment History tab "Start" tooltip
    Then I check the presence of DevicesDetailsPage.DurationTP Element and then i click it
    Then I check information in Deployment History tab "Duration" tooltip
    Then I check the presence of DevicesDetailsPage.LatestTP Element and then i click it
    Then I check information in Deployment History tab "Latest" tooltip
    Then I check the presence of DevicesDetailsPage.StatusTP Element and then i click it
    Then I check information in Deployment History tab "Status" tooltip

    #Direct Thing:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I clear the search Box in the Device Page
    Then I input "DirectthingTest02" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "DirectthingTest02"
    #3a. Go on Deployment History tab
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    #3b. Verify for each column the presence of the Info Icon (tootlip):
    #3c. Also verify the description of each tootlip
    Then I check the presence of DevicesDetailsPage.SoftwareTypeTP Element and then i click it
    Then I check information in Deployment History tab "Software Type" tooltip
    Then I check the presence of DevicesDetailsPage.DeployTypeTP Element and then i click it
    Then I check information in Deployment History tab "Deploy Type" tooltip
    Then I check the presence of DevicesDetailsPage.StartTP Element and then i click it
    Then I check information in Deployment History tab "Start" tooltip
    Then I check the presence of DevicesDetailsPage.DurationTP Element and then i click it
    Then I check information in Deployment History tab "Duration" tooltip
    Then I check the presence of DevicesDetailsPage.LatestTP Element and then i click it
    Then I check information in Deployment History tab "Latest" tooltip
    Then I check the presence of DevicesDetailsPage.StatusTP Element and then i click it
    Then I check information in Deployment History tab "Status" tooltip

    #Logout
    Then I click on the user icon and log out.