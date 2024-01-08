@29.01_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1248

  #GOAL: Verify the presence of the new filter in the Devices Page

  Background:
    #1a: Login on the DMC
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

  Scenario: Deployment History 29.1

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    #3 Open the filter bar and check the presence of the new Software Version filter:
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.filterBox Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput

    #Logout Step
    Then I click on the user icon and log out.