@Diagnostic_Test_10.32
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.32
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Step Function submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption

    #Then I verify that StepFunctionPage.filters contains Filters
    #And I verify that the table contains these columns
     # | DEVICE ID     |
      #| COMMAND TYPE  |
      #| CREATION DATE |
      #| STATUS        |
      #| STATUS DATE   |

    #Step 3
    #On the top right of the page, near the notification bell:
    #Go with the pointer on "Language" and choose a language:
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonItalianoSubOption

    #Step 4
    #Check that the page is translated in the language chosed

  And I check that the StepFunction page is correctly translated in italian

    #Then I verify that StepFunctionPage.filters contains Filtri
    #And I verify that the table contains these columns
    #  | ID DISPOSITIVO |
    #  | TIPO COMANDO   |
    #  | DATA CREAZIONE |
    #  | STATO          |
    #  | DATA STATO     |

      #logout STEP

    Then I click on the user icon and log out.