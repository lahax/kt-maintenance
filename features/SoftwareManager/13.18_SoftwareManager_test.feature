@Software_manager_Test_13.18
Feature: Software Manager
#GOAL: Verify the OTA Update Campaign is correctly executed on the gateway devices listed
  Background:
    # Step 1: Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.18
    # Step2: Access to DMC, open sidemenu then click on Software Manager and click on Gateways Campaign Management submenu item.
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it

    #Step 3: Select more than one gateway with Greengrass, then click on the button on the right down of the page
    Then I check the presence of CampaignManagementPage.chevronDownFilterBox Element and then i click it
    Then I check the presence of CampaignManagementPage.gatewaySoftwareTypeDropDown Element and then i click it
    And I set the "regression-eig" as Gateway Software Type
    #And I set the "GENERIC" as Gateway Software Type
    Then I check the presence of CampaignManagementPage.buttonConfirm Element and then i click it
    Then I check the presence of CampaignManagementView.gatewayConcept1 Element and then i click it
    Then I check the presence of CampaignManagementView.gatewayConcept2 Element and then i click it

    #Step 4: Select Ota update
#    Then I kill the notify_job command still opened
#    Then I run the notify_job_script on "Gateway-April", in the project "esol_ap29551_qa"
#    Then I run the notify_job_script on "Gateway-April2", in the project "esol_ap29551_qa"

    Then I check the presence of CampaignManagementPage.packageButton Element and then i click it
    Then I check the presence of CampaignManagementPage.popUpDeploySoftware

    Then I verify the presence of the option "Greengrass deploy"
    Then I verify the presence of the option "Greengrass reset"
    Then I verify the presence of the option "Ota Update"
    Then I verify the presence of the option "Firmware Update"

    Then I check the presence of DeploymentsHistoryPage.otaUpdateButton Element and then i click it

    #Step 5: Fill data required
      #Name: it's possible to update the core and the ota_agent. The core is the GreenGrass Daemon, it follows the AWS versioning, while the ota_agent is the ota responsible of the update process;
      #Architecture: the hardware architecture of the gateway (arm, x86...);
      #Operating system: the operating system installed on the gateway
    Then I check the presence of OtaUpdatePage.otaUpdatePageTitle
    Then I check the presence of OtaUpdatePage.dropdownName Element and then i click it
    And I set the "ota_agent" option from "Name" dropdown menu
    Then I check the presence of OtaUpdatePage.dropdownArchitecture Element and then i click it
    And I set the "x86_64" option from "Architecture" dropdown menu
    Then I check the presence of OtaUpdatePage.dropdownOperatingSystem Element and then i click it
    And I set the "amazon_linux" option from "Operating System" dropdown menu

    #Step 6: Click on "Update" to start the updating process
    Then I check the presence of OtaUpdatePage.buttonUpdate Element and then i click it

    Then I check the presence of OtaUpdatePage.otaUpdatePageTitle
    Then I check the presence of OtaUpdatePage.buttonUpdate Element and then i click it
    #Then I save the job ID from the job document received from the gateway "Gateway-April"
    #Then I save the job ID from the job document received from the gateway "Gateway-April2"
    #And I run the script: "close_job_software_failed", with the job Id retrieved, on "Gateway-April" in the project "esol_ap29551_qa"
    #And I run the script: "close_job_software_failed", with the job Id retrieved, on "Gateway-April2" in the project "esol_ap29551_qa"

    #Step 7: TODO Login on AWS
    #On AWS Management Console select IoT Core Service → Manage → Jobs → last jobs (if you are looking live)

    #Step 8: Open Diagnostic - Step function | Check the Step function status is "FAILED"
#    Then I click HomePage.hamburgerMenuIcon
#    Then I click SidebarPage.diagnosticOption
#    And I click SidebarPage.stepFunctionSubOption
#    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
#    And I check and click the last icon document of the entry named "GatewayApril2"
#    And I check the presence of StepFunctionPage.failedInDetailsStepFunction

    #Step 9: Open Software Manager - Deployments History and search for the deployment status
#    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
#    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
#    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
#    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
#    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
#    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
#    Then I check the presence of DeploymentsHistoryPage.gatewayOptionFilter Element and then i click it
#    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
#    Then I select the details icon of the entry "Gateway-April2"
#    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
#    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusFailed

    #Step 10: Open Deployment History section on Gateway's detailed page and check the deployment is present on

    Then I wait the progress bar
    And I wait 60 seconds
    Then I click on the user icon and log out.