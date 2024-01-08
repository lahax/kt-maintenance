@Diagnostic_Test_10.20
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.20
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, select at least one project, open the sidemenu, click on Diagnostic and then select MQTT Client
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.mqttSubOption

    #Step 3
  #Click on the section where you can write the topic. In the first suggest click on enviroment prefix, in the second suggest click on a gtw like "EVO20"
    Then I click MqttClientPage.inputField
    Then I click MqttClientPage.DDMOptionsEsolAp29551
    Then I type "Test_Concept-01" into the element MqttClientPage.inputField
    Then I click MqttClientPage.DDMOptionsGtw

    #Step 4
    # Verify that you see:
    #
    #/#
    #/+
    #/+/<thing>/data
    Then I verify that DDM contains these options
      | +           |
      | #           |
      | Test_Concept-01_thing1/data |

    #Then I set chrome "iPad pro" mode
    #Then I verify that DDM contains these options
    #  | +           |
    #  | #           |
    #  | Test_Concept-01_thing1/data |

    #Then I set chrome "iPhone" mode
    #Then I verify that DDM contains these options
    #  | +           |
    #  | #           |
    #  | Test_Concept-01_thing1/data |