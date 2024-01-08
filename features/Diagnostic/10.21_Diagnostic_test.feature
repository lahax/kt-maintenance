@Diagnostic_Test_10.21
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.21
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    #Step 3
  #Click on the section where you can write the topic. In the first suggest click on enviroment prefix, in the second suggest click on "#" and click on play button
    Then I click MqttClientPage.inputField
    Then I click MqttClientPage.DDMOptionsEsolAp29551
    Then I click MqttClientPage.DDMOptionsTag
    Then I click MqttClientPage.playButton
    And I wait 60 seconds
#    Then I launch command "bash ./send_telemetry_thing_concept04.sh 1" on shell

    #Step 4
    # VWhen receive you receive one or more payload, try to use the search in the page by click in the section "find in payload" (in the screen an example):
    And I check the presence of MqttClientPage.searchBox
    And I type "Test_Concept-04" into the element MqttClientPage.searchBox
    And I verify that each topic contains at least one occurence of the keyword "veig-ha-test-01"

    #Then I set chrome "ipad Pro" mode
    #And I verify that each topic contains at least one occurence of the keyword "veig-ha-test-01"