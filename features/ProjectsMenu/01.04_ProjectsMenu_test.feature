@Projects_menu_test_1.4
Feature: Projects Menu
#GOAL: User is able to login in the DMC with one or more projects selected.
  Background:
    #STEP 1 - Login to DMC
      # and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 1.4

    #Desktop Control scrolling
    #-----------START--------------
    # STEP 2
    #After the login verify that you can choose more than a project
    Then If present i click Clear Button
    Then I check the presence of the project "esol-ap29551-perf" and then i click it
    Then I check the presence of the project "esol-ap29551-test" and then i click it
    Then I check the presence of the project "esol-ap11311-dev" and then i click it
    Then I check the presence of the project "esol-ap27811-dev" and then i click it
    Then I check the presence of the project "esol-ap07614-dev" and then i click it
    Then I check the presence of the project "esol-ap07614-qa" and then i click it
    Then I check the presence of the project "esol-ap29551-qa" and then i click it
    Then I check the presence of the project "esol-ap07615-dev" and then i click it
    Then I check the presence of the project "esol-ap07615-qa" and then i click it
    Then I check the presence of the project "esol-ap3241101-dev" and then i click it
    Then I check the presence of the project "esol-ap3241101-test" and then i click it
    #Check if you are able to move on the bar selected above.
    Then I check presence of projects selected at the top of the page
    And I try to swipe through the projects
    Then I check the presence of HomePage.multipleWhiteBar
    #STEP 3
    #verify that you are able to access in DMC only if you have selected one (or more) project.
    #Check the landing page simply controlling the Devices title
    And I enter first two projects
    And I check the presence of ProjectPage.devicePreviewTitleSection
    # I return to all projects and repeat test on other devices
    #Then I come back to HomePage from the project page
    Then I check the presence of ProjectPage.logoEnel Element and then i click it


    #Desktop Control  ------------END-------------

    #iPad Pro Control  -----------START--------------
    #Ipad Pro Control scrolling
    #Then I set chrome "iPad pro" mode
    #Then If present i click Clear Button
    #Then I check the presence of the project "esol-ap29551-perf" and then i click it
    #Then I check the presence of the project "esol-ap29551-test" and then i click it
    #Then I check the presence of the project "esol-ap11311-dev" and then i click it
    #Then I check the presence of the project "esol-ap27811-dev" and then i click it
    #Then I check the presence of the project "esol-ap07614-dev" and then i click it
    #Then I check the presence of the project "esol-ap07614-qa" and then i click it
    #Then I check the presence of the project "esol-ap29551-qa" and then i click it
    #Then I check the presence of the project "esol-ap07615-dev" and then i click it
    #Then I check the presence of the project "esol-ap07615-qa" and then i click it
    #Then I check the presence of the project "esol-ap3241101-dev" and then i click it
    #Then I check the presence of the project "esol-ap3241101-test" and then i click it

    #Then I check presence of projects selected at the top of the page
    #And I try to swipe through the projects
    #Then I check the presence of HomePage.multipleWhiteBar
    #And I enter first two projects
    # Check the landing page simply controlling the Devices title
    #And I check the presence of ProjectPage.devicePreviewTitleSection
    # I return to all projects and repeat test on other devices
    #Then I come back to HomePage from the project page
    #iPad  Pro Control  -----------END--------------

    #Iphone X Control  -----------Start--------------

    #Iphone X Control scrolling
    #Then I set chrome "iPhone" mode
    #Then If present i click Clear Button
    #Then I check the presence of the project "esol-ap29551-perf" and then i click it
    #Then I check the presence of the project "esol-ap29551-test" and then i click it
    #Then I check the presence of the project "esol-ap11311-dev" and then i click it
    #Then I check the presence of the project "esol-ap27811-dev" and then i click it
    #Then I check the presence of the project "esol-ap07614-dev" and then i click it
    #Then I check the presence of the project "esol-ap07614-qa" and then i click it
    #Then I check the presence of the project "esol-ap29551-qa" and then i click it
    #Then I check the presence of the project "esol-ap07615-dev" and then i click it
    #Then I check the presence of the project "esol-ap07615-qa" and then i click it
    #Then I check the presence of the project "esol-ap3241101-dev" and then i click it
    #Then I check the presence of the project "esol-ap3241101-test" and then i click it

    #Then I check presence of projects selected at the top of the page
    #And I try to swipe through the projects
    #Then I check the presence of HomePage.multipleWhiteBar
    #And I enter first two projects
    # Check the landing page simply controlling the Devices title
    #And I check the presence of ProjectPage.devicePreviewTitleSection
    # I return to all projects and repeat test on other devices
    #Then I come back to HomePage from the project page
    #Iphone X Control  -----------END--------------