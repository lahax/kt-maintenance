package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class RDEPage {


    @Element(xpath = "//h2[contains(text(), 'Rule and Dispatch Engine')]", desc = "Rule and Dispatch Engine lending page title ")
    private static PageElement rdeLandingPageTitle;
    @Element(xpath = "//button/i[@dmcicon='plus']", desc = "plus button new rule ")
    private static PageElement plusButtonNewRule;
    @Element(xpath = "//tr[1]/td[contains(@class,'--align-left')]", desc = "all cell of first row in the table")
    private static PageElement allCellOfFirstRow;
    @Element(xpath = "//i[@dmcicon='refresh']" , desc = "refresh button")
    private static PageElement refreshBTN;

    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button RDE page")
    private static PageElement backBTN;

//--------------------------------------------Filter Type Options--------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[contains(text(),' Filter Type ')])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']"
            , desc = "Filter Type drop down option")
    private static PageElement filterTypeOptions;
    @Element(xpath = "(//dmc-dummy-input/i[@dmcicon='chevron-down'])[position()=1]", desc = "Drop Down Arrow --> position1 , can be used in many pages ")
    private static PageElement dropDownFilterType;
    @Element(xpath = "//div[contains(text(), ' THING_ID ')]", desc = "Add rule filter type  THING_ID")
    private static PageElement thingIdOptionAddRUle;
    @Element(xpath = "//div[contains(text(), ' THING_GROUP ')]", desc = "Add rule filter type  THING_GROUP")
    private static PageElement thingGroupOptionAddRUle;
    @Element(xpath = "//div[contains(text(), ' ORGANIZATION ')]", desc = "Add rule filter type  ORGANIZATION")
    private static PageElement organizationOptionAddRUle;
    @Element(xpath = "//div[contains(text(), ' SITE ')]", desc = "Add rule filter type  SITE")
    private static PageElement siteOptionAddRUle;
//---------------------------------------------------------------------------------------------------------------

    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Filter ID ')]//following-sibling::*",
            desc = "Filter ID label input")
    private static PageElement filterIdInsertBox;
    @Element(xpath = "//input[@role='combobox']",
            desc = "Filter ID label input")
    private static PageElement filterIdBox;
    @Element(xpath ="(//span[@class = 'mat-option-text'])[1]", desc = "first device selection")
    private static PageElement firstDeviceGateway;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-01')]", desc = "first device group selection in wizard")
            private static PageElement testConcept01Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-04')]", desc = "first device group selection in wizard")
    private static PageElement testConcept04Device;
    @Element(xpath = "(//i[@dmcicon='plus'])[3]", desc = "Add Actions add rule plus option")
    private static PageElement plusActionsAddRuleOption;

//----------------------------------------------------AND CONDITIONS---------------------------------------------------------------------
    @Element(xpath = "(//i[@dmcicon='plus'])[1]", desc = "Add Conditions add rule plus option")
    private static PageElement plusConditionAddRuleOption;
    //--------------------------------------------Attribute Name Options--------------------------------------------------
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Attribute Name ')]//following-sibling::dmc-autocomplete",
            desc = "And Conditions Attribute Name Label input")
    private static PageElement attributeNameAddRuleOption;
    @Element(xpath = "//span[(text() = ' METADATA. ')]", desc = "Add Conditions Attribute METADATA. option")
    private static PageElement metadataDataAddRuleOption;
    @Element(xpath = "//span[(text() = ' METADATA.dataType ')]", desc = "Add Conditions Attribute METADATA.dataType option")
    private static PageElement metadataDataTypeAddRuleOption;
    @Element(xpath = "//span[(text() = ' METADATA.SourceType ')]", desc = "Add Conditions Attribute  METADATA.SourceType  option")
    private static PageElement metadataDataSourceTypeAddRuleOption;
    @Element(xpath = "//span[(text() = ' PAYLOAD. ')]", desc = "Add Conditions Attribute PAYLOAD. option")
    private static PageElement payloadAddRuleOption;
    @Element(xpath = "//span[(text() = ' PAYLOAD.trendId ')]", desc = "Add Conditions Attribute  PAYLOAD.trendId . option")
    private static PageElement payloadTrendIDAddRuleOption;
    @Element(xpath = "//span[(text() = ' ENRICHMENT. ')]", desc = "Add Conditions Attribute  ENRICHMENT. option")
    private static PageElement enrichmentAddRuleOption;
    //----------------------------------------------------------------------------------------------------------------

    //--------------------------------------------Value Type Options--------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[contains(text(),' Value Type ')])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']",
            desc = "And Conditions Value Type drop down")
    private static PageElement valueTypeAddRuleOption;
    @Element(xpath = "//div[(text() = ' STRING ')]", desc = "STRING Value Type")
    private static PageElement stringValueType;
    @Element(xpath = "//div[(text() = ' INTEGER ')]", desc = "INTEGER Value Type")
    private static PageElement integerValueType;
    @Element(xpath = "//div[(text() = ' FLOAT ')]", desc = "FLOAT Value Type")
    private static PageElement floatValueType;
    @Element(xpath = "//div[(text() = ' BOOLEAN ')]", desc = "BOOLEAN Value Type")
    private static PageElement booleanValueType;
    //----------------------------------------------------------------------------------------------------------------

    //--------------------------------------------Operators Options--------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[contains(text(),' Operators ')])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']",
            desc = "And Conditions Operators drop down")
    private static PageElement operatorsAddRuleOption;
    @Element(xpath = "//div[(text() = ' EQUAL ')]", desc = "equal operator option")
    private static PageElement equalOperator;
    @Element(xpath = "//div[(text() = ' LESS_EQUAL ')]", desc = "less equal operator option")
    private static PageElement lessEqualOperator;
    @Element(xpath = "//div[(text() = ' LESS ')]", desc = "less operator option")
    private static PageElement lessOperator;
    @Element(xpath = "//div[(text() = ' GREATER ')]", desc = "greater operator option")
    private static PageElement greaterOperator;
    @Element(xpath = "//div[(text() = ' GREATER_EQUAL ')]", desc = "greater equal operator option")
    private static PageElement greaterEqualOperator;
    @Element(xpath = "//div[(text() = ' DIFFERENT ')]", desc = "different operator option")
    private static PageElement differentOperator;
    @Element(xpath = "//div[(text() = ' REGEX ')]", desc = "regex operator option")
    private static PageElement regexOperator;
    //----------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------VALUE--------------------------------------------------------
    //It changes with attribute name
    @Element(xpath = "(//dmc-form-field-label[text()= ' Value * '])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']"
            , desc = "value drop down And Conditions option")
    private static PageElement dropDownValueAndConditions;
    @Element(xpath = "//input[@placeholder='Value']", desc = "And Conditions Operators drop down")
    private static PageElement valueAddRule;
    @Element(xpath = "//div[contains(text(),'E2E_MONITORING_NOTIFICATION')]", desc = "And Conditions Value E2E_MONITORING_NOTIFICATION")
    private static PageElement e2eMonitoringNotificationAddRuleOption;
    //-----------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

//---------------------------------------------------Occurences--------------------------------------------------------
    @Element(xpath = "(//i[@dmcicon='plus'])[2]", desc = "Add Occurrences add rule plus option")
    private static PageElement plusOccurrencesAddRuleOption;
    //---------------------------------------------------Mode--------------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[contains(text(),' Mode ')])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']",
            desc = "Occurences Mode drop down")
    private static PageElement modeOccurences;
    @Element(xpath = "//div[(text() = ' TOTAL ')]", desc = "total mode option")
    private static PageElement totalMode;
    @Element(xpath = "//div[(text() = ' ROW ')]", desc = "row mode option")
    private static PageElement rowMode;
    //-----------------------------------------------------------------------------------------------------------
    //----------------------------------------------Number-------------------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[contains(text(),' Number ')])/following-sibling::dmc-input-container/input",
            desc = "Numeber input occurences")
    private static PageElement numberInput;
    //-----------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------

//---------------------------------------------------Actions--------------------------------------------------------
    @Element(xpath = "(//dmc-form-field-label[text() = ' Type '])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']",
           desc = "Actions drop down")
     private static PageElement actionsDropDown;
    //---------------------------------------------------API--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' API ')]", desc = "API actions type select option")
    private static PageElement apiActionsOption;
    @Element(xpath =  "//dmc-form-field-label[contains(text(), ' Formatter ')]//following-sibling::dmc-autocomplete",
            desc = "Formatter Name Label input")
    private static PageElement formatterAddRuleOption;
    @Element(xpath =  "//dmc-form-field-label[contains(text(), ' Endpoint ')]//following-sibling::dmc-input-container",
            desc = "Endpoint Name Label input")
    private static PageElement endpointAddRuleOption;
    @Element(xpath =  "(//dmc-form-field-label[text() = ' Method '])/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']",
            desc = "Method Name Label input")
    private static PageElement methodAddRuleOption;
    @Element(xpath =  "//dmc-radio-group-option[(text() = 'Authorization Token ')]",
            desc = " Authorization Token Radio Button")
    private static PageElement authTokenRadioBTN;
    @Element(xpath =  "//dmc-radio-group-option[(text() = 'Username and password ')]",
                desc = " Username and password Radio Button")
    private static PageElement userPasswRadioBTN;
    @Element(xpath =  "//dmc-form-field-label[contains(text(), ' Auth Token ')]//following-sibling::dmc-input-container",
            desc = "auth Token Label input")
    private static PageElement authTokenLabelInput;
    @Element(xpath =  "//dmc-form-field-label[contains(text(), ' Username ')]//following-sibling::dmc-input-container",
            desc = "Usernmame Label input")
    private static PageElement usernameAddRuleOption;
    @Element(xpath =  "//dmc-form-field-label[contains(text(), ' Password ')]//following-sibling::dmc-input-container",
            desc = "password Label input")
    private static PageElement passwordAddRuleOption;

    //---------------------------------------------------KDS--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' KDS ')]", desc = "API actions type select option")
    private static PageElement kdsActionsOption;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Resource Name ')]//following-sibling::dmc-input-container",
            desc = "Resource Name add rule input box")
    private static PageElement resourcesNameInputLabel;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Region ')]//following-sibling::dmc-input-container", desc = "region actions add rule input box")
    private static PageElement regionLabelInput;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Topic ')]//following-sibling::dmc-input-container", desc = "topic actions add rule input box")
    private static PageElement topicLabelInput;

    //---------------------------------------------------SNS--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' SNS ')]", desc = "SNS actions type select option")
    private static PageElement snsActionsOption;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Role Arn ')]//following-sibling::dmc-input-container", desc = "role Arn actions add rule input box")
    private static PageElement roleArnAddRuleOptionSNS;

    //---------------------------------------------------MQTT--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' MQTT ')]", desc = "MQTT actions type select option")
    private static PageElement mqttActionsOption;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' CA Cert ')]//following-sibling::dmc-input-container",
            desc = "CA Cert add rule input box")
    private static PageElement caCertsInputLabel;

    //---------------------------------------------------MQTT AWS--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' MQTT_AWS ')]", desc = "MQTT_AWS actions type select option")
    private static PageElement mqttAWSActionsOption;

    //---------------------------------------------------LAMBDA--------------------------------------------------------
    @Element(xpath = "//div[(text() = ' LAMBDA ')]", desc = "LAMBDA actions type select option")
    private static PageElement lambdaActionsOption;

    @Element(xpath = "//div[contains(text(),' MQTT_AWS ')]", desc = "MQTT_AWS actions type select option")
    private static PageElement mqttAwsTypeAddRuleOption;

    @Element(xpath = "//span[contains(text(),'NONE')]", desc = "The optione NONE in actions formatter add rule")
    private static PageElement noneFormatterAddRuleOption;
    @Element(xpath = "//dmc-form-field[contains(., 'Region')]//following-sibling::dmc-input-container//input", desc = "region actions add rule input box")
    private static PageElement regionAddRuleOption;
    @Element(xpath = "//dmc-form-field[contains(., 'Role Arn')]//following-sibling::dmc-input-container//input", desc = "role Arn actions add rule input box")
    private static PageElement roleArnAddRuleOption;
    @Element(xpath = "//dmc-form-field[contains(., 'Topic')]//following-sibling::dmc-input-container//input", desc = "topic actions add rule input box")
    private static PageElement topicActionsAddRuleOption;
    @Element(xpath = "//button[contains(text(),'Save')]", desc = "Save rule button")
    private static PageElement saveRuleBTN;
    @Element(xpath = "//i[@class='dmc-icon__trash dmc-icon']", desc = "Rule and dispatch trash icon")
    private static PageElement rdeTrashIcon;
    @Element(xpath = "//button[contains(text(),'Delete')]", desc = "Remove confirmation Delete button")
    private static PageElement deleteConfirmBtn;

    @Element(xpath = "//button[@class='-dismiss']", desc = "button x - close pop up")
    private static PageElement toastMessageClose;

    @Element(xpath= "//td[contains(., 'Test_Concept-01')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = " RDE rule for Test concept 01")
    private static PageElement testConcept01ruleDeleteIcon;

    @Element(xpath= "//td[contains(., 'Test_Concept-02')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = " RDE rule for Test concept 01")
    private static PageElement testConcept02ruleDeleteIcon;

    @Element(xpath= "//td[contains(., 'Test_Concept-04')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = " RDE rule for Test concept 04")
    private static PageElement testConcept04ruleDeleteIcon;

    @Element(xpath = "//td[contains(., 'Test_Concept-04')]//following-sibling::td//i[contains(@class, 'dmc-icon__pencil')]", desc = "RDE rule for Test concept 04")
    private static PageElement TestConcept04ruleEditIcon;

    @Element(xpath = "//td[contains(., 'Test_Concept-04')]//following-sibling::td//i[contains(@class, 'dmc-icon__document')]", desc = "RDE rule for Test concept 04")
    private static PageElement TestConcept04ruleDetailIcon;

    @Element(xpath = "//dmc-form-field-label[contains(., \"Topic\")]/following-sibling::dmc-input-container/input", desc = "RDE topic field")
    private static PageElement topicInputField;

    @Element(xpath = "//td[contains(., 'Test_Concept-04')]/ancestor::tr", desc = "Row that contains Test_Concept-04")
    private static PageElement rowRDETestConcept04;

    // ALL GETTERS NEEDED
    public static PageElement getrdeLandingPageTitle() {return rdeLandingPageTitle;}
    public static PageElement getAllCellOfFirstRow() {return allCellOfFirstRow;}
    public static PageElement getRefreshBTN() {return refreshBTN;}

    //Elements for translation//
    @Element(xpath = "//i[@dmcicon='table-columns']", desc = "select column icon")
    private static PageElement selectColumnsIcon;

    public static PageElement getSelectColumnsIcon() {
        return selectColumnsIcon;
    }

    @Element(xpath = "//li/button[contains(., 'Reimposta larghezza colonne')]", desc = "resize columns option")
    private static PageElement resizeColumnsIT;

    public static PageElement getResizeColumnsIT() {
        return resizeColumnsIT;
    }

    @Element(xpath = "//li/button/span", desc = "close button columns")
    private static PageElement closeColumnsBTN;

    public static PageElement getCloseColumnsBTN() {
        return closeColumnsBTN;
    }

    @Element(xpath = "//li/div[contains(., 'OCCORRENZE')]", desc = "OCCORRENZE")
    private static PageElement selectOccurrenceIT;

    @Element(xpath = "//li/div[contains(., 'DETTAGLIO AZIONI')]", desc = "DETTAGLIO AZIONI")
    private static PageElement selectActionsDetailIT;

    @Element(xpath = "//li/div[contains(., 'CONDIZIONI')]", desc = "CONDIZIONI")
    private static PageElement selectConditionsIT;

    @Element(xpath = "//li/div[contains(., 'ID REGOLA')]", desc = "ID REGOLA")
    private static PageElement selectRuleIdIT;

    @Element(xpath = "//li/div[contains(., 'ID FILTRO')]", desc = "ID FILTRO")
    private static PageElement selectFilterIdIT;


    public static PageElement getSelectOccurrenceIT() {
        return selectOccurrenceIT;
    }

    public static PageElement getSelectActionsDetailIT() {
        return selectActionsDetailIT;
    }

    public static PageElement getSelectConditionsIT() {
        return selectConditionsIT;
    }

    public static PageElement getSelectRuleIdIT() {
        return selectRuleIdIT;
    }

    public static PageElement getSelectFilterIdIT() {
        return selectFilterIdIT;
    }

    @Element(xpath = "//h2[contains(text(), 'Motore di Regole e Invio')]", desc = "Rule and Dispatch Engine lending page title it")
    private static PageElement rdeLandingPageTitleIT;

    public static PageElement getRdeLandingPageTitleIT() {
        return rdeLandingPageTitleIT;
    }

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Occorrenze') and @class='-header']", desc = "occorrenze column ")
    private static PageElement occurrenceColumnIT;
    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Dettaglio Azioni') and @class='-header']", desc = "dettaglio azioni column ")
    private static PageElement actionsDetailsColumnIT;
    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Condizioni') and @class='-header']", desc = "condizioni column")
    private static PageElement conditionsColumnIT;
    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'ID Regola') and @class='-header']", desc = "id regola column ")
    private static PageElement ruleIdColumnIT;
    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'ID Filtro') and @class='-header']", desc = "id filtro column ")
    private static PageElement filterIdColumnIT;

    public static PageElement getFilterIdColumnIT() {
        return filterIdColumnIT;
    }

    public static PageElement getRuleIdColumnIT() {
        return ruleIdColumnIT;
    }

    public static PageElement getOccurrenceColumnIT() {
        return occurrenceColumnIT;
    }

    public static PageElement getActionsDetailsColumnIT() {
        return actionsDetailsColumnIT;
    }

    public static PageElement getConditionsColumnIT() {
        return conditionsColumnIT;
    }

    @Element(xpath = "//div[contains(text(),'COMMAND_COMPLETION_GATEWAY')]", desc = "And Conditions Value COMMAND_COMPLETION_GATEWAY ")
    private static PageElement commandCompletionGatewayAddRuleOption;

    @Element(xpath = "//div[contains(text(),'JOB_UPDATE')]", desc = "And Conditions Value JOB_UPDATE ")
    private static PageElement jobUpdateAddRuleOption;

    @Element(xpath= "//td[contains(., 'Test_Concept-40')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = " RDE rule for Test concept 04")
    private static PageElement testConcept40ruleDeleteIcon;

    @Element(xpath = "//div[contains(text(),'TELEMETRY')]", desc = "And Conditions Value TELEMETRY")
    private static PageElement telemetryAddRuleOption;

    @Element(xpath = "//td[contains(., 'Test_Concept-40')]//following-sibling::td//i[contains(@class, 'dmc-icon__pencil')]", desc = "RDE rule for Test concept 40")
    private static PageElement TestConcept40ruleEditIcon;

    @Element(xpath = "//td[contains(., 'Test_Concept-40')]/ancestor::tr", desc = "Row that contains Test_Concept-40")
    private static PageElement rowRDETestConcept40;

    @Element(xpath = "//td[contains(., 'Test_Concept-40')]//following-sibling::td//i[contains(@class, 'dmc-icon__document')]", desc = "RDE rule for Test concept 04")
    private static PageElement TestConcept40ruleDetailIcon;

    public static PageElement getDeleteConfirmBtn() {
        return deleteConfirmBtn;
    }

    public static PageElement getToastMessageClose() {
        return toastMessageClose;
    }
}
