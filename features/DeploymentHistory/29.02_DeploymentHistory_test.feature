@29.02_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1249

  #GOAL: Verify the correct functionality of the new filter:
      #A single dropdown list is shown;
      #The dropdown will show packages with the syntax APPNAME@VERSION;
      #Typing in the autocomplete filters packages in the dropdown
      #Clicking on a name/version item in the autocomplete automatically adds it as a filter
      #Selected name/version filters can be removed by clicking on them

  Background:
    #1a: Login on the DMC
    # STEP 1 "Login To DMC"

    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Deployment History 29.2

    Then I enter on "esol-ap29551-qa" project
    And I wait the progress bar

    # STEP 2
    #2a Click on Sidebar and then on "Devices" section
    #2a. Open the filter bar
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.filterBox Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput

    #2b. Click on Software Version bar and verify that a single dropdown list is shown:
    Then I check the presence of DevicesPage.softwareVersionInput Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionAC

    #3 The dropdown will show softwares with the syntax APPNAME@VERSION:
    Then The dropdown will show softwares with the syntax APPNAME@VERSION


    #4 Typing in the autocomplete filters software in the dropdown:
    Then I input "sw_eiidg" in DevicesPage.softwareVersionInput

    #5 Clicking on a name/version item in the autocomplete automatically adds it as a filter:
    Then I check the presence of DevicesPage.testSoftware Element and then i click it
    Then I check the presence of DevicesPage.softwareVersionInput Element and then i click it
    Then I check the presence of DevicesPage.testSoftware1 Element and then i click it
    Then I wait 5 seconds

    #6 Selected name/version filters can be removed by clicking on them:
    Then I Check for presence of Software Version filters and close it

    # Logout from DMC
    Then I click on the user icon and log out.


