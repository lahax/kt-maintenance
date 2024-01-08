@29.15_DeploymentHistory_test
Feature: Deployment History

  #FE

  #https://jira.springlab.enel.com/browse/EXEGIP2-1267

  #GOAL: The info icon (tooltip) should explain to the user what labels and values mean

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

  Scenario: Deployment History 29.15

    # STEP 2
    #2a. Click on Sidebar and then on Software Manager -> Deployment History
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.softwareManagerOption
    Then I click SidebarPage.deploymentsHistoryOption

    # STEP 3
    # 3a. Verify for each column the presence of the Info Icon (tooltip)
    # 3b. Also verify the description of each tooltip
    #Software type tooltip
    Then I click DeploymentsHistoryPage.softwareTypeTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.softwareTypeTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.softwareTypeTooltipText
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Software type tooltip
    Then I click DeploymentsHistoryPage.deployTypeTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGatewaySoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGreengrassSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGreengrassDeployment
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextDirectThingSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeTooltipTextGatewayThingSoftware
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Start tooltip
    Then I click DeploymentsHistoryPage.startTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.startTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.startTooltipText
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Duration tooltip
    Then I click DeploymentsHistoryPage.durationTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.durationTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.durationTooltipText
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Software version tooltip
    Then I click DeploymentsHistoryPage.softwareVersionTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.softwareVersionTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.softwareVersionTooltipText
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Latest tooltip
    Then I click DeploymentsHistoryPage.latestTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.latestTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.latestTooltipText
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Status tooltip
    Then I click DeploymentsHistoryPage.statusTooltipIcon
    Then I check the presence of DeploymentsHistoryPage.statusTooltipTitle
    Then I check the presence of DeploymentsHistoryPage.statusDeployTypeListTitle
    Then I check the presence of DeploymentsHistoryPage.deployTypeGreengrassSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeGreengrassDeployment
    Then I check the presence of DeploymentsHistoryPage.deployTypeGatewaySoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeDirectThingSoftware
    Then I check the presence of DeploymentsHistoryPage.deployTypeGatewayThingSoftware
    Then I check the presence of DeploymentsHistoryPage.statusStatusListTitle
    Then I check the presence of DeploymentsHistoryPage.statusTimeout
    Then I check the presence of DeploymentsHistoryPage.statusCompleted
    Then I check the presence of DeploymentsHistoryPage.statusInProgress
    Then I check the presence of DeploymentsHistoryPage.statusFailed
    Then I check the presence of DeploymentsHistoryPage.statusPartial
    Then I click DeploymentsHistoryPage.closeTooltipButton

    #Logout Step
    Then I click on the user icon and log out.