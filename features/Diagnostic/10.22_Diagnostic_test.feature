@Diagnostic_Test_10.22
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "basic_CompacF_false" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.22
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Load Certificate submenu item.
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    Then I check the presence of SidebarPage.mqttSubOption Element and then i click it

    #Step 3
    #Click on the section where you can write the topic. In the first suggest click on enviroment prefix, in the second suggest click on "#" and click on play button
    Then I check the presence of MqttClientPage.inputField Element and then i click it
    Then I check the presence of MqttClientPage.DDMOptionsEsolAp29551 Element and then i click it
    Then I check the presence of MqttClientPage.DDMOptionsTag Element and then i click it
    Then I check the presence of MqttClientPage.playButton Element and then i click it
    And I wait 30 seconds
    Then I launch command "bash ./send_telemetry_thing_concept04.sh 1" on shell
    And I wait 30 seconds

    #Step 4
    # When receive you receive one or more payload, copy the topic
    Then MqttClientPage.topic should be displayed
    Then I enter the telemetry topic in the input field

    #Step 5
    #
    #Stop the client, paste the new topic and run again the client to receive payload in the specific topic copied in the previus step
    Then I check the presence of MqttClientPage.playButton Element and then i click it
    And I wait 30 seconds
    Then I launch command "bash ./send_telemetry_thing_concept04.sh 1" on shell
    And I wait 30 seconds
    #And I should see only the provided topic
    And I verify that each occurrence contains the provided topic