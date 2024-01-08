@Software_manager_Test_13.3
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

  Scenario: Software_manager_Test_13.3

    Then I enter on "esol-ap29551-qa" project

    # STEP 2 Access to DMC, open sidemenu then click on Software Manager
      # and click on Software Catalogue submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
    Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
    Then I wait 5 seconds

    # STEP 3 Verify that at the top of the page there is a search bar and it works:
    Then I check the presence of SoftwareCataloguePage.searchBar
    Then I input "test" in SoftwareCataloguePage.searchBar with enter
    Then I check if searchbar work with the word "test"
