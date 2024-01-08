@Diagnostic_Test_10.33
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.33
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on MQTT Client submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    #Then I verify that MqttClientPage.mqttClientHeader contains Client
    #Then I verify that MqttClientPage.inputFieldLabel contains Type

    #Step 3
    #On the top right of the page, near the notification bell:
    #Go with the pointer on "Language" and choose a language:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    #Then I verify that MqttClientPage.mqttClientHeader contains Interfaccia
    #Then I verify that MqttClientPage.inputFieldLabel contains Inserisci

  #Step 4
  #Check that the page is translated in the language chosed

  And I check that the MqttClient Page is correctly translated in italian

        #LOGOUT
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption
    Then I click on the user icon and log out.
    Then I check the presence of LoginPage.loginBtn
