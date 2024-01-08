@RDE_Test_14.3
Feature: RDE

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 14.3

    #STEP 1 - Login on DMC and go in RDE page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption

    #Step 2
    #Check that the Refresh button is present at the top right of the page:

    Then I check the presence of RDEPage.refreshBTN
     #Step 3
     #Click the refresh button

    #Per controllare il funzionamento del refresh button devo avere almeno una entry, quindi
    And Info "I create an RDE rule to check if refresh button reloads information properly"

    # New rule wizard button
    # Bug Action option, do not scroll down
    Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Filter Type --->  Thing_group
    Then  I click RDEPage.filterTypeOptions
    Then  I click RDEPage.thingGroupOptionAddRUle
    # filter ID: the test gateway
    Then  I click RDEPage.filterIdInsertBox
    Then I input "Test_Concept-01" in RDEPage.filterIdBox
    #Then  I click RDEPage.testConcept01Device
    # And Condition:
    Then  I click RDEPage.plusConditionAddRuleOption
    Then  I click RDEPage.attributeNameAddRuleOption
    Then  I click RDEPage.metadataDataTypeAddRuleOption
    # Value: E2E_MONITORING_CONFIGURATION
    Then  I click RDEPage.dropDownValueAndConditions
    Then  I click RDEPage.e2eMonitoringNotificationAddRuleOption
    # Actions:
    Then I click RDEPage.actionsDropDown
    Then I check the presence of RDEPage.mqttAwsTypeAddRuleOption Element and then i click it
    # formatter: None
    Then I check the presence of RDEPage.formatterAddRuleOption Element and then i click it
    Then I check the presence of RDEPage.noneFormatterAddRuleOption Element and then i click it
    And I type "eu-central-1" into the element RDEPage.regionAddRuleOption
    And I type "rde_test_topic" into the element RDEPage.topicActionsAddRuleOption
    Then I check the presence of RDEPage.saveRuleBTN Element and then i click it
    Then I check the presence of RDEPage.refreshBTN Element and then i click it
    Then I wait 10 seconds
    #Check refresh button
    Then I check that the refresh button works properly on RDE page

    # remove rde rule
    Then I check the presence of RDEPage.testConcept01ruleDeleteIcon Element and then i click it
    Then I check the presence of RDEPage.deleteConfirmBtn Element and then i click it
