@29.05_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1256

  #GOAL: Verify columns SOFTWARE TYPE and DEPLOY TYPE are added. Also "END" column is deleted.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.5

    Then I enter on "esol-ap29551-qa" project
    And I wait the progress bar

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
    #2b. Verify columns SOFTWARE TYPE and DEPLOY TYPE are added:
    Then I check the presence of DevicesDetailsPage.softwareTypeColumn
    Then I check the presence of DevicesDetailsPage.deployTypeColumn
    #2c. Also "END" column is deleted:
    Then I check the presence of DevicesPage.manageColumn Element and then i click it
    Then I check the absence of DevicesDetailsPage.endColumn
    Then I click DevicesPage.ManageColumnCLose

    #Direct Thing:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #3a. Go on Deployment History tab
    Then I clear the search Box in the Device Page
    Then I input "DirectthingTest02" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "DirectthingTest02"
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    #3b. Verify columns SOFTWARE TYPE and DEPLOY TYPE are added:
    Then I check the presence of DevicesDetailsPage.softwareTypeColumn
    Then I check the presence of DevicesDetailsPage.deployTypeColumn
    #3c. Also "END" column is deleted as shown per Gateway picture
    Then I check the presence of DevicesPage.manageColumn Element and then i click it
    Then I check the absence of DevicesDetailsPage.endColumn
    Then I click DevicesPage.ManageColumnCLose


    #Logout
    Then I click on the user icon and log out.