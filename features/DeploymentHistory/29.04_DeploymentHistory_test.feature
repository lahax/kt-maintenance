@29.04_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1255

  #GOAL: Click on "Detail window" button of a Gateway, Direct Thing and Thing and verify the presence of the new informative: Installed Software.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.4

    Then I enter on "esol-ap29551-qa" project
    And I wait the progress bar

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #3a. Choose a Gateway, a Direct Thing and a Thing and click on detail button

    #Gateway:
    Then I input "eig-e2e-uat-00" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar
    Then I click on details icon of the device "eig-e2e-uat-00"

    #2a. Click on "Detail Window":
    Then I check the presence of DevicesDetailsPage.infoIconDetails Element and then i click it

    #2b. verify the presence of the new informative: Installed Packages:
    Then I check the presence of DevicesDetailsPage.packageDetails



    #Direct Thing:
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I clear the search Box in the Device Page
    Then I input "DirectthingTest02" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "DirectthingTest02"

    #3a. Click on "Detail Window":
    Then I check the presence of DevicesDetailsPage.infoIconDetails Element and then i click it

    #3b. verify the presence of the new informative: Installed Packages:
    Then I check the presence of DevicesDetailsPage.packageDetails
    #Thing
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I clear the search Box in the Device Page
    Then I input "eig-e2e-uat-00" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "eig-e2e-uat-00"
    Then I check the presence of DevicesDetailsPage.tabThings Element and then i click it
    Then I check the presence of DevicesDetailsPage.selectedThingMoreInfo Element and then i click it
    Then I check the presence of ThingsPage.moreInfo Element and then i click it
    Then I check the presence of DevicesDetailsPage.packageDetails
    #4a. In the Things tab, choose a Thing and click on "More Info" button:
    #4b. verify the presence of the new informative: Installed Packages:

    Then I click on the user icon and log out.