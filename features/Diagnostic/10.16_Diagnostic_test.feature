@Diagnostic_Test_10.16
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.16
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    #Step 3
  #Verify that you are able to write every type of payload
    Then I type "devices/registration" into the element MqttClientPage.inputField
    And I check that the string "devices/registration" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "devices/monitoring" into the element MqttClientPage.inputField
    And I check that the string "devices/monitoring" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "life_cycle_events/" into the element MqttClientPage.inputField
    Then I type "esol_ap29551_qa" into the element MqttClientPage.inputField
    And I check that the string "life_cycle_events/esol_ap29551_qa" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "+" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/+" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "#" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/#" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "GatewayC/" into the element MqttClientPage.inputField
    Then I type "+" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/GatewayC/+" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "GatewayC/" into the element MqttClientPage.inputField
    Then I type "#" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/GatewayC/#" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "u16-cyb01/" into the element MqttClientPage.inputField
    Then I type "+" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/u16-cyb01/+" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "u16-cyb01/" into the element MqttClientPage.inputField
    Then I type "#" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/u16-cyb01/#" is correctly showed as hint
    Then I clear MqttClientPage.inputField


    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "u18-cyb02/" into the element MqttClientPage.inputField
    Then I type "+" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/u18-cyb02/+" is correctly showed as hint
    Then I clear MqttClientPage.inputField

    Then I type "esol_ap29551_qa/" into the element MqttClientPage.inputField
    Then I type "u18-cyb02/" into the element MqttClientPage.inputField
    Then I type "#" into the element MqttClientPage.inputField
    And I check that the string "esol_ap29551_qa/u18-cyb02/#" is correctly showed as hint







