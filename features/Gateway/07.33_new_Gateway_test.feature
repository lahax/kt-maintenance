@Gateway_Test_7.33
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

      #GOAL
      #Perform a Greengrass reset of the gateway

    #STEP 1 - Access to DMC, open the sidemenu and click on Devices
  Scenario: Test 7.33_new

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #STEP 3 - Go to the detail page of a gateway and click on "Greengrass reset" and confirm.

    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I wait the progress bar
    Then I click DevicesPage.iconDetailsFirstRow

    Then I check the presence of DevicesDetailsPage.otaUpdateBTN Element and then i click it
    Then I check the presence of OtaUpdatePage.otaUpdatePageTitle

    Then I check the presence of OtaUpdatePage.dropdownName Element and then i click it
    And I set the "ota_agent" option from "Name" dropdown menu
    Then I check the presence of OtaUpdatePage.dropdownArchitecture Element and then i click it
    And I set the "x86_64" option from "Architecture" dropdown menu
    Then I check the presence of OtaUpdatePage.dropdownOperatingSystem Element and then i click it
    And I set the "ubuntu" option from "Operating System" dropdown menu

    Then I check the presence of OtaUpdatePage.buttonUpdate Element and then i click it
    Then I wait the progress bar

    Then I click on the user icon and log out.