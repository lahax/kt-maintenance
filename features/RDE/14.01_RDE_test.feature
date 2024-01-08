@RDE_Test_14.1
Feature: RDE

  Background:

    # STEP 1
    # Login on DMC and go in RDE page "Part I"
    # - The first step to access the DMC is logging in using the Enel email account or service number and password
    # - After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail
    #   or service number in the format shown in the imag
    # - After this step, you are redirected to sts.enel.com to login into the system
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 14.1

    ## ---------- GOAL ---------- ##
    ## Login on DMC and go in RDE page ##
    ## ----------      ---------- ##

    # STEP 1
    # Login on DMC and go in RDE page "Part II"
    # - Enter in a project
    # - Go to RDE page from Sidebar Menu
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption

    #Step 2
    # Check that the table has the following columns:
    # Filter ID;
    # Rule ID;
    # And Conditions;
    # Actions Detail;
    # Occurrences;
    # Actions

    # ----------- Desktop ---------- #

    Then I check that all columns are present
      |Filter ID            |
      |Rule ID              |
      |And Conditions       |
      |Actions Detail       |
      |Occurrences          |
      |                     |

    # ----------- Tablet ---------- #

    #Then I set chrome "iPad pro" mode
    #Then I check that all columns are present
    #  |Filter ID            |
    #  |Rule ID              |
    #  |And Conditions       |
    #  |Actions Detail       |
    #  |Occurrences          |
    #  |                     |

    And I click on the user icon and log out.