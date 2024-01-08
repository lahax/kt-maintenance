@Software_manager_Test_13.1
  Feature: Software Manager

   # Step 1
    #Login on DMC
    Background:
      Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
      Then I click LoginPage.loginBtn
      Then I perform login as "admin" user
      Then I click HomePage.infoUserLoggedIn
      Then I click HomePage.languageSubOption
      Then I click HomePage.buttonEnglishSubOption

    Scenario: Software_manager_Test_13.1

      Then I enter on "esol-ap29551-qa" project

      # STEP 2 Access to DMC, open sidemenu then click on Software Manager
          # and click on Software Catalogue submenu item.
      Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
      Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
      Then I check the presence of SidebarPage.softwareCatalogueOption Element and then i click it
      Then I check the presence of SoftwareCataloguePage.softwareCatalogueLandingPageTitle
      Then I wait 5 seconds
      # Step 3 Verify that the page presents all the softwares (divided in cards):
      Then I count all the software presents

