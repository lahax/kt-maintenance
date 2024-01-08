@Gateway_Test_7.31
Feature: Gateway

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

      #GOAL
      #Perform a Greengrass reset of the gateway

    #STEP 1 - Access to DMC, open the sidemenu and click on Devices
  Scenario: Test 7.31

    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption

    #STEP 2 - If the device is simulated through script
    #
    #Run Job notify Script : ./notify_job.sh <host> <apm> <device_id>
    #
    #     es: ./notify_job.sh  ax3v62h9b8tp2.iot.eu-central-1.amazonaws.com esol_ap29551_dev gateway-test
    #
    #     It will subscribe to topic $aws/things/<apm>_<device_id>/jobs/notify-next

#    Then I kill the notify_job command still opened
#    Then I run the notify_job script on "Test_Concept-01", in the project "esol_ap29551_qa"

    #STEP 3 - Go to the detail page of a gateway and click on "Greengrass reset" and confirm.

    Then I input "Test_Concept-01" in DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    Then I click DevicesPage.iconDetailsFirstRow
    Then I check the presence of DevicesDetailsPage.greenGrassDeployBTN Element and then i click it
    Then I check the presence of DevicesDetailsPage.confirmDeployBTN

    Then I check the presence of DevicesDetailsPage.cancelBTNpanel Element and then i click it

    Then I click on the user icon and log out.
