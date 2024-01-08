@Diagnostic_Test_10.24
Feature: Diagnostic

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user

    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 10.24
    Then I enter on "esol-ap29551-qa" project

    #----------------------------------Step 2
    #Access to DMC, open sidemenu then click on Diagnostic and click on Load Certificate submenu item.
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.diagnosticOption
    And I click SidebarPage.loadCertificateSubOption

    #Step 3 - Verify that on the middle of the page, there is a panel where you can upload or drop new certificates (extension has to be: .crt, .key or .pem)
    Then I check the presence of LoadCertificatePage.loadCertificateLandingPageTitle
    Then I check the presence of LoadCertificatePage.dragAndDropBox

    #Step 4 - Upload a correct certificate and verify the file is saved on S3 on the bucket esol-noprod-<apm>-iotmvp/<env>/private/<deviceId>/
    #Then I click LoadCertificatePage.uploadBox
    #Then I Upload archive tar gz file into Drag'n'Drop box
    #Then I wait 60 seconds
    Then I input archive tar gz file into LoadCertificatePage.uploadBox
    Then I check the presence of LoadCertificatePage.uploadButton Element and then i click it
    And I wait that the upload of the file is completed
    And I check that on Amazon S3 there is a file correctly uploaded into bucket "enel-noprod-esol-ap29551-iotmvp" in the path "qa/private/"

    #Step 5 - Upload a file with wrong file extension and verify an error message is returned

    Then I input rightZip.zip file into LoadCertificatePage.uploadBox
    And I check the presence of LoadCertificatePage.errorMessageWrongTypeOfFile

    #Step 6 -Upload a file with correct file extension and verify the upload folder path of AWS is shown
    Then I input archive tar gz file into LoadCertificatePage.uploadBox
    And I check that the box of File to be uploaded is correctly showed

