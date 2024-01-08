@RDE_Test_14.2
Feature: RDE

  Background:

    # STEP 1
    # Login on DMC and go in RDE page "Part I"
    # - The first step to access the DMC is logging in using the Enel email account or service number and password
    # - After the click on login, you are redirected to a Enel Microsoft Login page, you can insert your Enel mail
    #   or service number in the format shown in the imag
    # - After this step, you are redirected to sts.enel.com to login into the system
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test 14.2

    ## ---------- GOAL ---------- ##
    ## Check the presence and functionality of the Add Rule button ##
    ## ----------      ---------- ##

    # ----------- Desktop ---------- #

    # STEP 1
    # Login on DMC and go in RDE page "Part II"
    # - Enter in a project
    # - Go to RDE page from Sidebar Menu
    Then I enter on "esol-ap29551-qa" project
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.rdeOption

    # Step 2
    # Check that the (più) button is present at the bottom right of the page:
    Then I check the presence of RDEPage.plusButtonNewRule

    # Step 3
    # Click on (più) button and create a new rule:
    # Verify that:
    # Filter type has 4 possible values: Thing_ID, Thing_group, Organization, Site
    Then I click RDEPage.plusButtonNewRule

    Then  I click RDEPage.filterTypeOptions
    Then  I check the presence of RDEPage.thingIdOptionAddRUle
    Then  I check the presence of RDEPage.thingGroupOptionAddRUle
    Then  I check the presence of RDEPage.organizationOptionAddRUle
    Then  I check the presence of RDEPage.siteOptionAddRUle
    Then  I click RDEPage.thingIdOptionAddRUle
    Then  I check the presence of RDEPage.filterIdInsertBox

    # NOTE -----> To close the drop down and check other elements, you need to click and select an option
    # A new Condition has the following fields: attibute name, value, type, operators, value
    And I click RDEPage.plusConditionAddRuleOption
    Then  I check the presence of RDEPage.attributeNameAddRuleOption
    Then  I check the presence of RDEPage.valueTypeAddRuleOption
    Then  I check the presence of RDEPage.operatorsAddRuleOption
    Then  I check the presence of RDEPage.valueAddRule
    # Attribute name has the following possible values: metadata. , metadata.datatype, metadata.sourcetype, Payload. , payload.trendiId
    Then  I click RDEPage.attributeNameAddRuleOption
    Then  I check the presence of RDEPage.metadataDataAddRuleOption
    Then  I check the presence of RDEPage.metadataDataTypeAddRuleOption
    Then  I check the presence of RDEPage.metadataDataSourceTypeAddRuleOption
    Then  I check the presence of RDEPage.payloadAddRuleOption
    Then  I check the presence of RDEPage.payloadTrendIDAddRuleOption
    Then  I check the presence of RDEPage.enrichmentAddRuleOption
    # Value type has the following possible values: STRING INTEGER FLOAT BOOLEAN
    Then  I click RDEPage.valueTypeAddRuleOption
    Then  I check the presence of RDEPage.stringValueType
    Then  I check the presence of RDEPage.integerValueType
    Then  I check the presence of RDEPage.floatValueType
    Then  I check the presence of RDEPage.booleanValueType
    Then  I click RDEPage.stringValueType
    # NOTE -----> To close the drop down and check other elements, you need to click and select an option
    # Operators has the following possible values: EQUAL LESS_EQUAL LESS GREATER GREATER_EQUAL DIFFERENT REGEX
    Then  I click RDEPage.operatorsAddRuleOption
    Then  I check the presence of RDEPage.equalOperator
    Then  I check the presence of RDEPage.lessEqualOperator
    Then  I check the presence of RDEPage.lessOperator
    Then  I check the presence of RDEPage.greaterOperator
    Then  I check the presence of RDEPage.greaterEqualOperator
    Then  I check the presence of RDEPage.differentOperator
    Then  I check the presence of RDEPage.regexOperator
    Then  I click RDEPage.equalOperator
    Then  I check the presence of RDEPage.valueAddRule
    # Occurence has mode and number fields. Mode can be Total or Row
    Then  I click RDEPage.plusOccurrencesAddRuleOption
    Then  I click RDEPage.modeOccurences
    Then  I check the presence of RDEPage.totalMode
    Then  I check the presence of RDEPage.rowMode
    Then  I click RDEPage.rowMode
    Then  I check the presence of RDEPage.numberInput
    # Action type can be:
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    # API: requires Formatter, Endpoint, Method, Authorization method (username and password or token)
    Then I check the presence of RDEPage.apiActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.endpointAddRuleOption
    Then I check the presence of RDEPage.methodAddRuleOption
    Then I check the presence of RDEPage.authTokenRadioBTN Element and then i click it
    Then I check the presence of RDEPage.authTokenLabelInput
    Then I check the presence of RDEPage.userPasswRadioBTN Element and then i click it
    Then I check the presence of RDEPage.usernameAddRuleOption
    Then I check the presence of RDEPage.passwordAddRuleOption
    # KDS: requires formatter, region, resource name and role arn
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.kdsActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.regionLabelInput
    Then I check the presence of RDEPage.resourcesNameInputLabel
    Then I check the presence of RDEPage.roleArnAddRuleOptionSNS
    # SNS: requires formatter, region, role arn and topic
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.snsActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.regionLabelInput
    Then I check the presence of RDEPage.roleArnAddRuleOption
    Then I check the presence of RDEPage.topicLabelInput
    # MQTT: requires Formatter, Endpoint, username, password, topic, CA Cert
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.mqttActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.endpointAddRuleOption
    Then I check the presence of RDEPage.usernameAddRuleOption
    Then I check the presence of RDEPage.passwordAddRuleOption
    Then I check the presence of RDEPage.topicLabelInput
    Then I check the presence of RDEPage.caCertsInputLabel
    # MQTT_AWS: requires formatter, region, role arn and topic
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.mqttAWSActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.regionLabelInput
    Then I check the presence of RDEPage.roleArnAddRuleOptionSNS
    Then I check the presence of RDEPage.topicLabelInput
    # LAMBDA: requires formatter, region, resource name and role arn
    Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    Then I check the presence of RDEPage.lambdaActionsOption Element and then i click it
    Then I check the presence of RDEPage.formatterAddRuleOption
    Then I check the presence of RDEPage.regionLabelInput
    Then I check the presence of RDEPage.resourcesNameInputLabel
    Then I check the presence of RDEPage.roleArnAddRuleOptionSNS

    Then I check the presence of RDEPage.backBTN Element and then i click it

    Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Filter Type --->  Thing_group
    Then  I click RDEPage.filterTypeOptions
    Then  I click RDEPage.thingGroupOptionAddRUle
    # Filter ID: the test gateway
    Then  I click RDEPage.filterIdInsertBox
    Then I input "Test_Concept-04" in RDEPage.filterIdBox
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

    And I wait 10 seconds
    Then I check the presence of RDEPage.TestConcept04ruleDetailIcon Element and then i click it

    # The new rule is present in the DynamoDB table esol_ap2955101_<env>_table_rule_store

    Then I check the rule "Test_Concept-04" in "esol_ap2955101_qa_ddb_rulestore" DynamoDD table for the "esol-ap29551-qa" apm

    # remove rde rule
    Then I click HomePage.hamburgerMenuIcon
    Then  I click SidebarPage.rdeOption
    Then I check the presence of RDEPage.testConcept04ruleDeleteIcon Element and then i click it
    Then I check the presence of RDEPage.deleteConfirmBtn Element and then i click it
    Then I check the presence of RDEPage.toastMessageClose Element and then i click it

    And I click on the user icon and log out.

    # ----------- Tablet ---------- #
    #Then I set chrome "iPad pro" mode
    #Then I check the presence of RDEPage.plusButtonNewRule Element and then i click it
    # Verify that:
    # Filter type has 4 possible values: Thing_ID, Thing_group, Organization, Site
    #Then  I click RDEPage.filterTypeOptions
    #Then  I check the presence of RDEPage.thingIdOptionAddRUle
    #Then  I check the presence of RDEPage.thingGroupOptionAddRUle
    #Then  I check the presence of RDEPage.organizationOptionAddRUle
    #Then  I check the presence of RDEPage.siteOptionAddRUle
    #Then  I click RDEPage.thingIdOptionAddRUle
    #Then  I check the presence of RDEPage.filterIdInsertBox
    #N.B -----> Per chiudere il drop down e controllare altri elementi devo per forza cliccare e selezionare un'opzione
     # A new Condition has the following fields: attibute name, value, type, operators, value
    #And I click RDEPage.plusConditionAddRuleOption
    #Then  I check the presence of RDEPage.attributeNameAddRuleOption
    #Then  I check the presence of RDEPage.valueTypeAddRuleOption
    #Then  I check the presence of RDEPage.operatorsAddRuleOption
    #Then  I check the presence of RDEPage.valueAddRule
     # Attribute name has the following possible values: metadata. , metadata.datatype, metadata.sourcetype, Payload. , payload.trendiId
    #Then  I click RDEPage.attributeNameAddRuleOption
    #Then  I check the presence of RDEPage.metadataDataAddRuleOption
    #Then  I check the presence of RDEPage.metadataDataTypeAddRuleOption
    #Then  I check the presence of RDEPage.metadataDataSourceTypeAddRuleOption
    #Then  I check the presence of RDEPage.payloadAddRuleOption
    #Then  I check the presence of RDEPage.payloadTrendIDAddRuleOption
    #Then  I check the presence of RDEPage.enrichmentAddRuleOption
     # Value type has the following possible values: STRING INTEGER FLOAT BOOLEAN
    #Then  I click RDEPage.valueTypeAddRuleOption
    #Then  I check the presence of RDEPage.stringValueType
    #Then  I check the presence of RDEPage.integerValueType
    #Then  I check the presence of RDEPage.floatValueType
    #Then  I check the presence of RDEPage.booleanValueType
    #Then  I click RDEPage.stringValueType
    #N.B -----> Per chiudere il drop down e controllare altri elementi devo per forza cliccare e selezionare un'opzione
     # Operators has the following possible values: EQUAL LESS_EQUAL LESS GREATER GREATER_EQUAL DIFFERENT REGEX
    #Then  I click RDEPage.operatorsAddRuleOption
    #Then  I check the presence of RDEPage.equalOperator
    #Then  I check the presence of RDEPage.lessEqualOperator
    #Then  I check the presence of RDEPage.lessOperator
    #Then  I check the presence of RDEPage.greaterOperator
    #Then  I check the presence of RDEPage.greaterEqualOperator
    #Then  I check the presence of RDEPage.differentOperator
    #Then  I check the presence of RDEPage.regexOperator
    #Then  I click RDEPage.equalOperator
    #Then  I check the presence of RDEPage.valueAddRule
     # Occurence has mode and number fields. Mode can be Total or Row
    #Then  I click RDEPage.plusOccurrencesAddRuleOption
    #Then  I click RDEPage.modeOccurences
    #Then  I check the presence of RDEPage.totalMode
    #Then  I check the presence of RDEPage.rowMode
    #Then  I click RDEPage.rowMode
    #Then  I check the presence of RDEPage.numberInput
     # Action type can be:
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
     # API: requires Formatter, Endpoint, Method, Authorization method (username and password or token)
    #Then I check the presence of RDEPage.apiActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.endpointAddRuleOption
    #Then I check the presence of RDEPage.methodAddRuleOption
    #Then I check the presence of RDEPage.authTokenRadioBTN Element and then i click it
    #Then I check the presence of RDEPage.authTokenLabelInput
    #Then I check the presence of RDEPage.userPasswRadioBTN Element and then i click it
    #Then I check the presence of RDEPage.usernameAddRuleOption
    #Then I check the presence of RDEPage.passwordAddRuleOption
     # KDS: requires formatter, region, resource name and role arn
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    #Then I check the presence of RDEPage.kdsActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.regionLabelInput
    #Then I check the presence of RDEPage.resourcesNameInputLabel
    #Then I check the presence of RDEPage.roleArnAddRuleOptionSNS
     # SNS: requires formatter, region, role arn and topic
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    #Then I check the presence of RDEPage.snsActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.regionLabelInput
    #Then I check the presence of RDEPage.roleArnAddRuleOption
    #Then I check the presence of RDEPage.topicLabelInput
     # MQTT: requires Formatter, Endpoint, username, password, topic, CA Cert
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    #Then I check the presence of RDEPage.mqttActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.endpointAddRuleOption
    #Then I check the presence of RDEPage.usernameAddRuleOption
    #Then I check the presence of RDEPage.passwordAddRuleOption
    #Then I check the presence of RDEPage.topicLabelInput
    #Then I check the presence of RDEPage.caCertsInputLabel
     # MQTT_AWS: requires formatter, region, role arn and topic
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    #Then I check the presence of RDEPage.mqttAWSActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.regionLabelInput
    #Then I check the presence of RDEPage.roleArnAddRuleOptionSNS
    #Then I check the presence of RDEPage.topicLabelInput
     # LAMBDA: requires formatter, region, resource name and role arn
    #Then I check the presence of RDEPage.actionsDropDown Element and then i click it
    #Then I check the presence of RDEPage.lambdaActionsOption Element and then i click it
    #Then I check the presence of RDEPage.formatterAddRuleOption
    #Then I check the presence of RDEPage.regionLabelInput
    #Then I check the presence of RDEPage.resourcesNameInputLabel
    #Then I check the presence of RDEPage.roleArnAddRuleOptionSNS