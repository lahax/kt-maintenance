@Gateway_Test_7.1
Feature: Gateway
#GOAL:Clicking on details button, it will show the gateway detail.
  Background:
    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption
  Scenario: Intall test
    #PROCEDURE
    #Step 1
    #Access to DMC, open the sidemenu and click on Devices:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #Step 2
    #Choose a Gateway record and click on "gateway detail" in actions column:
    Then I install mosquitto
    #Logout step?