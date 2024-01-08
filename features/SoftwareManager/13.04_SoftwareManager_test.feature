@Software_manager_Test_13.4
Feature: Software Manager

  # Step 1
   # Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.4

    Then I enter on "esol-ap29551-qa" project

    # STEP 2 Access to DMC, open sidemenu then click on Software Manager
      # and click on Software Catalogue submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle

    # STEP 3 Verify that in top right of the page,
      # next to the search bar there is a refresh button and it works:
    #Then I check the presence of SoftwareCataloguePage.refreshBtn Element and then i click it
    Then I check that the refresh button work properly for Software Catalogue Page