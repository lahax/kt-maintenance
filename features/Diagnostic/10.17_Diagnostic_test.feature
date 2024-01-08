@Diagnostic_Test_10.17
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.17
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    #Step 3
  #Click on the section where you can write the topic
    Then I click MqttClientPage.inputField

    #Step 4
    # Verify that there are 4 macro topic
  Then I verify the DDM contains these elements
    | DEVICES/REGISTRATION |
    | DEVICES/MONITORING   |
    | LIFE_CYCLE_EVENTS/   |
    | ESOL_AP29551_QA/   |

    #Then I set chrome "iPad pro" mode
    #Then I verify the DDM contains these elements
    #  | DEVICES/REGISTRATION |
    #  | DEVICES/MONITORING   |
    #  | LIFE_CYCLE_EVENTS/   |
    #  | ESOL_AP29551_QA/  |

    #Then I set chrome "iPhone" mode
    #Then I verify the DDM contains these elements
    #  | DEVICES/REGISTRATION |
    #  | DEVICES/MONITORING   |
    #  | LIFE_CYCLE_EVENTS/   |
    #  | ESOL_AP29551_QA/   |