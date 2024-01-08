@29.03_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1252

  #GOAL: The new informative present on the Device Info panel over the map, is correctly reported.

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.3

    Then I enter on "esol-ap29551-qa" project
    And I wait the progress bar

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #3a. Click on the detail of a Gateway
    Then I input "eig-e2e-uat-00" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar

    #4 Verify the presence of the new informative in the Device Info panel over the map: Installed Software:
    Then I click on details icon of the device "eig-e2e-uat-00"
    Then I check the presence of DevicesDetailsPage.gatewayPackageList


    #5 If the Installed Packages are more than 4, it will possible to click on "See more packages..." for view the missing packages on the card:
    Then I hover over package name

    #Then I check the presence of DevicesPage.pgButton
    And If Element DevicesDetailsPage.pgButton is present I click it

    #6 Also, if the name/version of the package has a long name, it's possibile to see the complete name by passing with mouse:

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #3a. Click on the detail of a Direct Thing
    Then I clear the search Box in the Device Page
    Then I input "DirectthingTest02" in DevicesPage.searchBox
    Then I wait the progress bar

    #4 Verify the presence of the new informative in the Device Info panel over the map: Installed Software:
    Then I click on details icon of the device "DirectthingTest02"
    Then I check the presence of DevicesDetailsPage.directThingPackageList


    #5 If the Installed Packages are more than 4, it will possible to click on "See more packages..." for view the missing packages on the card:
    #Then I check the presence of DevicesPage.pgButton
    And If Element DevicesDetailsPage.pgButton is present I click it


    Then I click on the user icon and log out.