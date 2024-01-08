@Diagnostic_Test_10.15
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.15
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    Then I click MqttClientPage.inputField
    Then I click MqttClientPage.DDMOptionsEsolAp29551
    Then I click MqttClientPage.DDMOptionsTag
    Then I click MqttClientPage.playButton
    And I wait 70 seconds

#    Then I launch command "bash ./send_telemetry_thing_concept04.sh 1" on shell

    #Step 3
    #Check the search bar on the top. The platform will help you on the compilation:
    And I check the presence of MqttClientPage.searchBox
    And I type "veig-ha-automation-00" into the element MqttClientPage.searchBox

    Then I click MqttClientPage.powerButton

  #Step4
  #Verify that you are able to write every type of payload
  And I verify that each topic contains at least one occurence of the keyword "veig-ha-automation-00"
