@Software_manager_Test_13.18_19_20
Feature: Software Manager

  # Step 1
  # Login on DMC
  Background:
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    Then I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    Then I click HomePage.buttonEnglishSubOption

  Scenario: Software_manager_Test_13.18_19_20

    #Step2
    Then I enter on "esol-ap29551-qa" project
    Then I check the presence of HomePage.hamburgerMenuIcon Element and then i click it
    Then I check the presence of SidebarPage.softwareManagerDropDownOption Element and then i click it
    Then I check the presence of SidebarPage.campaignManagementOption Element and then i click it

    #Step 3
    Then I check the presence of CampaignManagementPage.chevronDownFilterBox Element and then i click it
    Then I check the presence of CampaignManagementPage.gatewaySoftwareTypeDropDown Element and then i click it
    And I set the "regression-eig" as Gateway Software Type
    Then I check the presence of CampaignManagementPage.buttonConfirm Element and then i click it
    Then I choice two device ID: "NRTGateway" and "NRTGatewayGG"

    #Step 4
#    Then I kill the notify_job command still opened
#    Then I run the notify_job_script on "Test_Concept-03", in the project "esol_ap29551_qa"
#    Then I run the notify_job_script on "Test_Concept-04", in the project "esol_ap29551_qa"

    #Step 5
    Then I check the presence of CampaignManagementPage.packageButton Element and then i click it
    Then I check the presence of CampaignManagementPage.popUpDeploySoftware

    Then I verify the presence of the option "Greengrass deploy"
    Then I verify the presence of the option "Greengrass reset"
    Then I verify the presence of the option "Ota Update"
    Then I verify the presence of the option "Firmware Update"


#    Then I check the presence of OtaUpdatePage.otaUpdatePageTitle
#    Then I check the presence of OtaUpdatePage.dropdownName Element and then i click it
#    And I set the "ota_agent" option from "Name" dropdown menu
#
#    Then I check the presence of OtaUpdatePage.dropdownArchitecture Element and then i click it
#    And I set the "x86_64" option from "Architecture" dropdown menu
#
#    Then I check the presence of OtaUpdatePage.dropdownOperatingSystem Element and then i click it
#    And I set the "amazon_linux" option from "Operating System" dropdown menu
#
#    Then I check the presence of OtaUpdatePage.buttonUpdate Element and then i click it
#    Then I check the presence of OtaUpdatePage.otaUpdatePageTitle
#    Then I check the presence of OtaUpdatePage.buttonUpdate Element and then i click it
#
#
#    #Step Intermedio dopo parte UI per recupero JobID
#    #TestConcept03
#    #Then I save the job ID from the job document received
#    Then I save the job ID from the job document received from the gateway "Test_Concept-03"
#    #TestConcept04
#    Then I save the job ID from the job document received from the gateway "Test_Concept-04"
#
#
#    #And I run the script "close_job", with the job Id retrieved, on "Test_Concept-04" in the project "esol_ap29551_qa"
#    And I run the script: "close_job_remote", with the job Id retrieved, on "Test_Concept-03" in the project "esol_ap29551_qa"
#    And I run the script: "close_job_remote", with the job Id retrieved, on "Test_Concept-04" in the project "esol_ap29551_qa"
#
#    #Il close job viene chiuso con il corretto JobID recuperato in precedenza
#
#    #Kill del notifyJob aperto in precenza utilizzando
#    Then I kill the notify_job command still opened
#    Then I wait 5 minutes after script
#    Then I click HomePage.hamburgerMenuIcon
#    Then I click SidebarPage.diagnosticOption
#    And I click SidebarPage.stepFunctionSubOption
#    And I check the presence of StepFunctionPage.stepFunctionLandingPageTitle
#    And I check the presence of StepFunctionPage.lastWithTestConcept03AndTestConcept04 Element and then i click it
#    And I check the presence of StepFunctionPage.succeededInDetailsStepFunction

