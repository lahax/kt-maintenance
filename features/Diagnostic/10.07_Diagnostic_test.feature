@Diagnostic_Test_10.7
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.7
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Step 3
    #Verify that the table is composed by 6 colums:
      # Device ID, Command Type, Creation Date, Status, Status Date and Actions (it has no title, only the image of the actions):
    And I verify that the table contains these columns
      | DEVICE ID     |
      | DEVICE SN     |
      | ACTIVITY ID   |
      | THING ID      |
      | THING SN      |
      | THING ALIAS   |
      | COMMAND TYPE  |
      | CREATION DATE |
      | STATUS        |
      | STATUS DATE   |

    Then StepFunctionPage.actionColumn should be displayed

    #Then I set chrome "iPad pro" mode
    #And I verify that the table contains these columns
    #  | DEVICE ID     |
    #  | DEVICE SN     |
    #  | ACTIVITY ID   |
    #  | THING ID      |
    #  | THING SN      |
    #  | THING ALIAS   |
    #  | COMMAND TYPE  |
    #  | CREATION DATE |
    #  | STATUS        |
    #  | STATUS DATE   |

    #Then StepFunctionPage.actionColumn should be displayed