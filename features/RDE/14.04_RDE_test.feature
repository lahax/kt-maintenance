@RDE_Test_14.4
Feature: RDE

  Background:

    #STEP 0 - Login and set Language english as default
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 14.4

    # STEP 1 - Login on DMC and go in RDE page
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption
    And I wait the progress bar

    # STEP 2 - Check that actions columns has 3 buttons:
    #
    # More info (page button)
    # Edit (pencil button)
    # Delete (bin button)
    Then I check the presence of "More Info" "Edit" "Delete" buttons on the last column

    # STEP 3 - Click on More Info button:
    # Check data is coherent with DynamoDB table esol_ap2955101_test_table_rule_store

    Then If the rule for "Test_Concept-40" is present I delete it
    And I wait 30 seconds
    Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Filter Type --->  Thing_group
    Then  I click RDEPage.filterTypeOptions
    Then  I click RDEPage.thingGroupOptionAddRUle
    # Filter ID: the test gateway
    Then  I click RDEPage.filterIdInsertBox
    Then I input "Test_Concept-40" in RDEPage.filterIdBox
    Then  I click RDEPage.plusConditionAddRuleOption
    # Then  I click RDEPage.testConcept04Device
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

    Then I check the presence of RDEPage.TestConcept40ruleDetailIcon Element and then i click it

    # The new rule is present in the DynamoDB table esol_ap2955101_<env>_table_rule_store

    Then I check the rule "Test_Concept-40" in "esol_ap2955101_qa_ddb_rulestore" DynamoDD table for the "esol-ap29551-qa" apm

    Then I check the presence of RDEPage.backBTN Element and then i click it

    ## STEP4 - Click on Edit button:
    ## Check the change is saved on DMC page and on DynamoDB table esol_ap2955101_<env>_table_rule_store
    Then I check the presence of RDEPage.TestConcept40ruleEditIcon Element and then i click it
    Then I clear RDEPage.topicInputField
    And I type "testtest" into the element RDEPage.topicInputField
    Then I check the presence of RDEPage.saveRuleBTN Element and then i click it
    Then I check the presence of RDEPage.toastMessageClose Element and then i click it
    Then I check the rule "Test_Concept-40" in "esol_ap2955101_qa_ddb_rulestore" DynamoDD table for the "esol-ap29551-qa" apm

    # remove rde rule
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption
    Then I check the presence of RDEPage.testConcept40ruleDeleteIcon Element and then i click it
    Then I check the presence of RDEPage.deleteConfirmBtn Element and then i click it

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption
    Then I check the absence of RDEPage.rowRDETestConcept40

    Then I check the absence of rule "Test_Concept-40" in "esol_ap2955101_qa_ddb_rulestore" DynamoDD table for the "esol-ap29551-qa" apm