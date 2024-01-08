@Diagnostic_Test_10.14
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.14
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.diagnosticOption Element and then i click it
    Then I check the presence of SidebarPage.mqttSubOption Element and then i click it

    #Step 3
    #Write a topic 1) and then push play 2) to run the search:
    Then I type "devices/registration" into the element MqttClientPage.inputField
    Then I check the presence of MqttClientPage.DDMOption Element and then i click it
    Then I check the presence of MqttClientPage.playButton Element and then i click it
    And I wait 60 seconds
    Then I check the presence of MqttClientPage.powerButton Element and then i click it
    Then I check the presence of MqttClientPage.inputField Element and then i click it

    And I cancel text from the input box element MqttClientPage.inputField

    #Then I set chrome "iPad pro" mode
    #Then I type "devices/registration" into the element MqttClientPage.inputField
    #Then I check the presence of MqttClientPage.DDMOption Element and then i click it
    #Then I check the presence of MqttClientPage.playButton Element and then i click it
    #Then I check the presence of MqttClientPage.pauseButton Element and then i click it

    #And I cancel text from the input box element MqttClientPage.inputField

    #Then I set chrome "iPhone" mode
    #Then I type "devices/registration" into the element MqttClientPage.inputField
    #And I check the presence of MqttClientPage.DDMOption Element and then i click it
    #And I check the presence of MqttClientPage.searchBox Element and then i click it
    #And I check the presence of MqttClientPage.playButton Element and then i click it
    #And I check the presence of MqttClientPage.pauseButton Element and then i click it

    #And I cancel text from the input box element MqttClientPage.inputField