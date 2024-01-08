@Gateway_Test_7.8
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

  Scenario: Test 7.8
    #PROCEDURE
    #Step 1
    #Access to DMC and then open the sidemenu:

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #Step 2
    #Use the same gateway of Use Case 7.7 and select an invalid rage
    Then I input "Test_Concept-01" in DevicesPage.searchBox

    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it

    Then I check the presence of DevicesPage.testConcept01Details Element and then i click it
    Then I check the presence of DevicesDetailsPage.historyIcon Element and then i click it
    Then I check the presence of DevicesDetailsPage.selectDaytimeBTN Element and then i click it
       #I select from now
       Then I check the presence of DevicesDetailsPage.nowBTN Element and then i click it
       #To the fifteenth day of the previous month to avoid every activation
       Then I check the presence of DevicesDetailsPage.toRangeTime Element and then i click it
       Then I check the presence of DevicesDetailsPage.leftMonthBTNTo Element and then i click it
       Then I check the presence of DevicesDetailsPage.fifteenDayPreviousMonthTo Element and then i click it
    #Step 3
    #Verify that you are not able to filter
    And I check that the DevicesDetailsPage.confirmBTN element is disabled


