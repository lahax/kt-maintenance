@Software_manager_Test_13.19
Feature: Software Manager
#GOAL: Verify the GreenGrass Deploy Campaign is correctly executed on the Gateway devices listed
  Background:
    # Step 1: Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.19
    # Step 2: Access to DMC, open sidemenu then click on Software Manager and click on Gateways Campaign Management submenu item.
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it

    # Step 3: Select more than one gateway with Greengrass, then click on the button on the right down of the page
    Then I check the presence of CampaignManagementPage.chevronDownFilterBox Element and then i click it
    Then I check the presence of CampaignManagementPage.gatewaySoftwareTypeDropDown Element and then i click it
    And I set the "regression-eig" as Gateway Software Type
    #And I set the "GENERIC" as Gateway Software Type
    Then I check the presence of CampaignManagementPage.buttonConfirm Element and then i click it
    Then I check the presence of CampaignManagementView.gatewayConcept1 Element and then i click it
    Then I check the presence of CampaignManagementView.gatewayConcept2 Element and then i click it

#    Then I kill the notify_job command still opened
#    Then I run the notify_job_script on "Test_Concept-03", in the project "esol_ap29551_qa"
#    Then I run the notify_job_script on "Test_Concept-04", in the project "esol_ap29551_qa"

    # Step 4: Select Greengrass Deploy and click on Update
    Then I check the presence of CampaignManagementPage.packageButton Element and then i click it
    Then I check the presence of CampaignManagementPage.popUpDeploySoftware

    Then I verify the presence of the option "Greengrass deploy"
    Then I verify the presence of the option "Greengrass reset"
    Then I verify the presence of the option "Ota Update"
    Then I verify the presence of the option "Firmware Update"

    Then I check the presence of DeploymentsHistoryPage.greengrassDeployButton Element and then i click it
    Then I check the presence of CampaignManagementPage.deployButton Element and then i click it
    
    And I wait 60 seconds

    # Step 5: TODO Login on AWS | On AWS Management Console select IoT Core Service → GreenGrass → Classic (V1) → Groups → esol_ap29551_qa_ggg_NRTGatewayGG  → Group History Overview (For each Gateway) | See the last items sending by DMC

    # Step 6: Open Diagnostic - Step function | Check the Step function status is "FAILED"

    # Step 7: Open Software Manager - Deployments History and search for the deployment status

    # Step 8: Open Deployment History section on Gateway's detailed page and check the deployment is present on

    Then I click on the user icon and log out.