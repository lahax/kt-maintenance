@Gateway_Test_7.2
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
    #Check that on the gateway page there is a button that allows the opening of a detail page for the related info in the register.

  Scenario: Test 7.2
    #PROCEDURE
    #Step 1
    #Access to DMC and then open the sidemenu:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #2a. Open the Gateway detail view (with coordinates):
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I click DevicesDetailsPage.backBTN

    #2b. Gateway without coordinates:
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "EIG_ARM_AtonTest02" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.eigAtonGatewayNoCoordinatesDetailsIcon Element and then i click it
    Then I click DevicesDetailsPage.backBTN

    #Note: I return to Test_Concept-01 because has complete information
    Then I cancel text from the input box element DevicesPage.searchBox
    Then I input "Test_Concept-01" in DevicesPage.searchBox
    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    #Step 3
    #If we click on the "i" button highlighted in the previous picture we open a modal with payload information:
    Then I check the presence of DevicesDetailsPage.infoIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.detailsPage

  #---------------------------------------------------------------------------------------------------------------------
    #  TODO AWS Access
    #  Compare data with information showed on AWS - IoT Core
  #---------------------------------------------------------------------------------------------------------------------

    # Step 4
    # Check also for mobile:
    #Then I set chrome "iPhone" mode
    #Then I check the presence of DevicesDetailsPage.detailsPage

    #and tablet:
    #Then I set chrome "ipad Pro" mode
    #Then I check the presence of DevicesDetailsPage.detailsPage