@Software_manager_Test_13.16
Feature: Software Manager
#GOAL: Verify the Campaign is correctly executed on the devices listed
  Background:
    #STEP 1: Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.16

    #STEP 2: Access to DMC, open sidemenu then click on Software Manager and click on Gateways Campaign Management submenu item.
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle

    #Select Direct Thing Campaign Management on the top:
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementSwitchBtn Element and then i click it
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementTitlePage

    #STEP 3: Select Custom query filter
    Then I check the presence of CampaignManagementView.customQuery Element and then i click it
    Then I check the presence of CampaignManagementView.customQueryChevron Element and then i click it
    # and paste the following payload specifying the "sw_thing_type" (e.g. "eig-cu") to execute a query,
    And I input the payload into CampaignManagementView.firstRowIntTextarea
    """
    [ { "query": { "bool": { "must": [
{"match": {"latest": true}},
{"match": {"sw_thing_type.keyword": "eig-cu"}}
]}}}, {"devices_types": "not_supported"}]
    """
    # then click on the button on the right down of the page
    Then I check the presence of CampaignManagementView.customQueryConfirm Element and then i click it
    And I wait the progress bar

    #STEP 4: If the devices are simulated through script #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id> es: ./notify_job.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next
    Then I kill the notify_job command still opened
    Then I run the notify_job_script on "DirectThingConcept191", in the project "esol_ap29551_qa"
    Then I run the notify_job_script on "DirectThingConcept192", in the project "esol_ap29551_qa"

    Then I choice two device ID: "DirectThingConcept191" and "DirectThingConcept192"
  #STEP 5: Select firmware update (the only option) and fill data required
    Then I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    Then I check if the elements are disabled except for firmwareUpdateButton
    Then I check the presence of DeploymentsHistoryPage.firmwareUpdateButton Element and then i click it
    Then I check the presence of CampaignManagementView.appNameDropdown Element and then i click it
    Then I check the presence of CampaignManagementView.app1 Element and then i click it
    Then I check the presence of CampaignManagementView.versionDropdown Element and then i click it
    Then I check the presence of CampaignManagementView.version1 Element and then i click it
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it

  #STEP 6: If devices are simulated through script: Execute the close_job.sh script to close the step function with success close_job.sh ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com <env> <gw_id> <job_id> Es: ./close_job.sh   ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com  esol_ap29551_qa  GwTest  esol_ap29551_qa-2201260931-167b41d0-a7cb-40e4-a6eb-addd67bc7125 (the job_id can be retrieved by the MQTT message received by notify_job script)
    Then I save the job ID from the job document received from the gateway "DirectThingConcept191"
    Then I save the job ID from the job document received from the gateway "DirectThingConcept192"
    And I run the script: "close_job_software", with the job Id retrieved, on "DirectThingConcept191" in the project "esol_ap29551_qa"
    And I run the script: "close_job_software", with the job Id retrieved, on "DirectThingConcept192" in the project "esol_ap29551_qa"
    Then I wait 2 minutes after script

  #STEP 7: Open Diagnostic - Step function Check the Step function status is "SUCCEEDED"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check and click the last icon document of the entry named "DirectThingConcept191"
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

  #STEP 8: Open Software Manager - Deployments History and search for the deployment status
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it

    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirect1 Element and then i click it

    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DevicesDetailsPage.bannerCompleteInstall
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it

    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirect2 Element and then i click it
    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DevicesDetailsPage.bannerCompleteInstall

    #STEP 9: Open Direct Thing's detailed page on Devices section and check the deployment is present on Deployment History section
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I input "DirectThingConcept191" in DevicesPage.searchBox
    Then I click on details icon of the device "DirectThingConcept191"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    Then I check the presence of package to install with the name "APP1" and version "1.0"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I clear DevicesPage.searchBox

    Then I input "DirectThingConcept192" in DevicesPage.searchBox
    Then I click on details icon of the device "DirectThingConcept192"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    Then I check the presence of package to install with the name "APP1" and version "1.0"

    # STEP 10:Repeat step 3 - 8, where:
       #on step 5 more than 1 APP is selected and rollback is individual
      #the job closure message on the script is:
      #{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" , \"step\": \"command succeeded\", \"install_status\": \"partial_install\",\"thing_sw\": \"<app correctly installed>\" } }"
    #Verify on the Deployments History details that only the apps indicated on the message are showed as installed
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementSwitchBtn Element and then i click it
    Then I wait 10 seconds
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementTitlePage
    Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of CampaignManagementView.ThingSoftwareType Element and then i click it
    Then I check the presence of CampaignManagementView.eigCuOption Element and then i click it
    Then I check the presence of CampaignManagementView.thingSoftwareTypeConfirmButton Element and then i click it
    And I wait 10 seconds
    Then I check the presence of CampaignManagementView.paginationTableButton Element and then i click it
    Then I check the presence of CampaignManagementView.hundredRowsPerPage Element and then i click it
    And I wait the progress bar
    Then I check the presence of CampaignManagementView.direct1 Element and then i click it
    And I wait 3 seconds
    Then I check the presence of CampaignManagementView.direct2 Element and then i click it
    And I wait 10 seconds
    Then I kill the notify_job command still opened

    Then I run the notify_job_script on "DirectThingConcept191", in the project "esol_ap29551_qa"
    Then I run the notify_job_script on "DirectThingConcept192", in the project "esol_ap29551_qa"

    Then I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    Then I check if the elements are disabled except for firmwareUpdateButton
    Then I check the presence of DeploymentsHistoryPage.firmwareUpdateButton Element and then i click it
    Then I set two package to install. App name: "APP1" with version "1.0" and App name: "APP2" with version "1.0"
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it
    Then I save the job ID from the job document received from the gateway "DirectThingConcept191"
    Then I save the job ID from the job document received from the gateway "DirectThingConcept192"
    And I run the script: "close_job_software_partial", with the job Id retrieved, on "DirectThingConcept191" in the project "esol_ap29551_qa"
    And I run the script: "close_job_software_partial", with the job Id retrieved, on "DirectThingConcept192" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened
    Then I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check and click the last icon document of the entry named "DirectThingConcept191"
    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    Then I select the details icon of the entry "DirectThingConcept191"
    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.clearButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    Then I select the details icon of the entry "DirectThingConcept192"
    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusPartiallyComplete
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I clear DevicesPage.searchBox
    Then I input "DirectThingConcept191" in DevicesPage.searchBox
    Then I click on details icon of the device "DirectThingConcept191"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    Then I check the presence of package to install with the name "APP1" and version "1.0"
    Then I check the presence of package to install with the name "APP2" and version "1.0"
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I check the presence of DevicesPage.searchBox Element and then i click it
    Then I clear DevicesPage.searchBox
    Then I input "DirectThingConcept192" in DevicesPage.searchBox
    Then I click on details icon of the device "DirectThingConcept192"
    Then I check the presence of DevicesDetailsPage.tabDeploymentsHistory Element and then i click it
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.firstDetailsiconInTheTable Element and then i click it
    Then I check the presence of package to install with the name "APP1" and version "1.0"
    Then I check the presence of package to install with the name "APP2" and version "1.0"

    #STEP 11: Repeat step 3 - 8, where:
      #on step 5 more than 1 APP is selected and rollback is global
      #the job closure message on the script is:
      #{ \"status\":\"SUCCEEDED\",\"statusDetails\": {\"environment_prefix\": \"$environmentPrefix\" , \"step\": \"command succeeded\", \"install_status\": \"failed_install\",\"thing_sw\": \"\" } }"
    #Verify on the Deployments History details that the deployment is completely failed
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it
    Then I check the presence of CampaignManagementPage.campaignManagementLandingPageTitle
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementSwitchBtn Element and then i click it
    Then I wait 10 seconds
    Then I check the presence of CampaignManagementPage.directThingsCampaignManagementTitlePage
    Then I check the presence of DeploymentsHistoryPage.dropdownIconFilterBox Element and then i click it
    Then I check the presence of CampaignManagementView.ThingSoftwareType Element and then i click it
    Then I check the presence of CampaignManagementView.eigCuOption Element and then i click it
    Then I check the presence of CampaignManagementView.thingSoftwareTypeConfirmButton Element and then i click it
    And I wait 10 seconds
    Then I check the presence of CampaignManagementView.paginationTableButton Element and then i click it
    Then I check the presence of CampaignManagementView.hundredRowsPerPage Element and then i click it
    And I wait the progress bar
    Then I check the presence of CampaignManagementView.direct1 Element and then i click it
    And I wait 3 seconds
    Then I check the presence of CampaignManagementView.direct2 Element and then i click it
    And I wait 10 seconds
    Then I kill the notify_job command still opened
    Then I run the notify_job_script on "DirectThingConcept191", in the project "esol_ap29551_qa"
    Then I run the notify_job_script on "DirectThingConcept192", in the project "esol_ap29551_qa"
    Then I check the presence of DeploymentsHistoryPage.releaseButton Element and then i click it
    Then I check if the elements are disabled except for firmwareUpdateButton
    Then I check the presence of DeploymentsHistoryPage.firmwareUpdateButton Element and then i click it
    Then I set two package to install. App name: "APP1" with version "1.0" and App name: "APP2" with version "1.0"
    Then I check the presence of DevicesDetailsPage.globalFlag Element and then i click it
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it
    Then I check the presence of CampaignManagementView.updateButton Element and then i click it
    Then I save the job ID from the job document received from the gateway "DirectThingConcept191"
    Then I save the job ID from the job document received from the gateway "DirectThingConcept192"
    And I run the script: "close_job_software_failed", with the job Id retrieved, on "DirectThingConcept191" in the project "esol_ap29551_qa"
    And I run the script: "close_job_software_failed", with the job Id retrieved, on "DirectThingConcept192" in the project "esol_ap29551_qa"
    Then I kill the notify_job command still opened
    Then I wait 2 minutes after script
    Then If present i click on Enter Button
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.stepFunctionSubOption
    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
    And I check and click the last icon document of the entry named "DirectThingConcept191"
    And I check the presence of StepFunctionPage.failedInDetailsStepFunction
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.deploymentsHistoryOption Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deploymentsHistoryLandingPageTitle
    Then I check the presence of DeploymentsHistoryPage.filtersBox Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.deviceTypeFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.directThingOptionFilter Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.confirmFilterOptionBtn Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirect1 Element and then i click it
    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusFailed
    Then I check the presence of DevicesDetailsPage.backButton Element and then i click it
    Then I check the presence of DeploymentsHistoryPage.lastDeployWithDirect2 Element and then i click it
    And I check the presence of DevicesDetailsPage.deploymentDetailsTitle
    Then I check the presence of DeploymentHistoryDeviceDetailsPage.deploymentStatusFailed
    Then I click on the user icon and log out.