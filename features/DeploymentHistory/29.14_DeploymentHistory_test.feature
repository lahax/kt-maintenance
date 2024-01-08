@29.14_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1266

  #GOAL: The new Deploy Type column it's present on the table

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

  Scenario: Deployment History 29.14

    # STEP 2
    #2a. Click on Sidebar and then on Software Manager -> Deployment History
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerOption
    Then I click SidebarPage.deploymentsHistoryOption

    # STEP 3
    #3a. The new column Deploy Type is been added
    Then I check the presence of DeploymentsHistoryPage.deployTypeColumnHeader
    #as a TA improvement we can check if there are all columns (if it is not checked in another test case)

    #Logout Step
    Then I click on the user icon and log out.