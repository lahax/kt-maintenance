@Projects_menu_test_1.1
Feature: Projects Menu
#GOAL: Projects are correctly shown in the initial projects menu.
  Background:
    # STEP 1 "Login To DMC"
      # The first step to access the DMC is logging in using the Enel email account or service number and password
      # After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail or service number in the format shown in the image
      # After this step, you are redirected to sts.enel.com to login into the system
      # in this section you can insert login by insert your data in the right format:sername: Enelint\AF00000 and your password; or username: name.surname@enel.com and your password
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Projects Menu 1.1

    # Once the user is logged into the DMC, it's possible to select one or more desired projects from a list of the available projects. Click on project and click "Confirm" to select it and to access the DMC.

    # STEP 2
    # 1. After the login will be displayed a selection of projects (5 cards for row)
    Then I enter on "esol-ap29551-qa" project
    And I click ProjectPage.iconChooseProject
      # and check that:
        # in the top left of the page there is a back button;
        # in the top right of the page there is a search bar;
        # just below the selected projects, there is a filters box;
        # the favorite projects are above the other and divided by a purple line;
        # in the bottom of the page there are the clear and enter buttons;
        # every project card has the same size.
        # the favorite button on the top left of each selection (⭐) is present.
    Then I check HomePage elements: BackBTN, SearchBar, FilterBox, Cards fav, Cards noFav, ClearBtn, EnterBtn