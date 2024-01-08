@29.08_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1259

  #GOAL: Verify the new status icons:
    #Successfully installed (green icon )
    #Failed installed (red icon )
    #In progress (orange icon )
    #Timeout (black icon )

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.8

    Then I enter on "esol-ap29551-qa" project

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #3a. Choose a Gateway and a Direct Thing, and click on the detail button

    #Gateway
    #2a. Go on Deployment History tab and verify the new status icons:
    Then I input "GW-June23" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I wait the progress bar
    Then I click on details icon of the device "GW-June23"
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    And I wait the progress bar
      # Successfully installed (green icon )
    Then I check the presence of DevicesDetailsPage.iconComplete
      # Failed installed (red icon )
    Then I check the presence of DevicesDetailsPage.iconFailed
      # In progress (orange icon )
    Then I check the presence of DevicesDetailsPage.iconPending
      # Timeout (black icon)
    Then I check the presence of DevicesDetailsPage.iconTimeout
      # Partial installed (purple icon)
    Then I check the presence of DevicesDetailsPage.iconPartial

    #Direct Thing
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I clear the search Box in the Device Page
    #2a. Go on Deployment History tab and verify the new status icons:
    Then I input "DT-June" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click on details icon of the device "DT-June"
    Then I check the presence of DevicesPage.deploymentHistoryTab Element and then i click it
    And I wait the progress bar
      # Successfully installed (green icon )
    Then I check the presence of DevicesDetailsPage.iconComplete
      # Failed installed (red icon )
    Then I check the presence of DevicesDetailsPage.iconFailed
      # In progress (orange icon )
    Then I check the presence of DevicesDetailsPage.iconPending
      # Timeout (black icon)
    Then I check the presence of DevicesDetailsPage.iconTimeout
      # Partial installed (purple icon)
    Then I check the presence of DevicesDetailsPage.iconPartial

    #logout
    Then I click on the user icon and log out.