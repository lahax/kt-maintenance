package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DeploymentsHistoryPage {

    @Element(xpath = "//h2[contains(text(), 'Deployments History')]", desc = "Deployments History\n lending page title ")
    private static PageElement deploymentsHistoryLandingPageTitle;
    @Element(xpath = "//h2[contains(text(), 'Cronologia Distribuzioni')]", desc = "Deployments History\n lending page title ")
    private static PageElement deploymentsHistoryLandingPageTitleIT;
    @Element(xpath = "//h2[@class=\"-title\" and contains(text(), \"Deployment Details\")]", desc = "Deployment Details page title")
    private static PageElement deploymentDetailsPageTitle;
    @Element(xpath = "//div[contains(@class,'-status-banner')]", desc = "Deployment Status Banner on Deployment Details page")
    private static PageElement deploymentStatusBannerOnDeploymentDetails;
    @Element(xpath = "//i[@dmcicon=\"refresh\"]", desc = "Refresh Button")
    private static PageElement refreshBtn;
    @Element(xpath = "//button[contains(.,'Back')]", desc = "Back Button Deployment Details Page")
    private static PageElement backBtn;
    @Element(xpath = "//div[@class=\"mat-tab-label-content\" and contains(text(), \"Custom query\")]", desc = "Custom Query voice option")
    private static PageElement customQueryOptionSwitch;

    public static PageElement getDeploymentsHistoryLandingPageTitle() {return deploymentsHistoryLandingPageTitle;}

    /*----------------------------------------- FilterBox Elements --------------------------------------------*/
    @Element(xpath = "//div[@class=\"-card-header\"]/div/h2[.=' Filters ']/parent::div", desc = "Filters box")
    private static PageElement filtersBox;
    @Element(xpath = "//div[@class='dmc-card-header']/h2[.='Filters']/following-sibling::i", desc = "dropdown icon of the filters box")
    private static PageElement dropdownIconFilterBox;
    @Element(xpath = "(//dmc-form-field-label[contains(., ' Device type ')])/following-sibling::dmc-select//i", desc = "dropdown device type filter")
    private static PageElement deviceTypeFilter;
    @Element(xpath = "//div[@class='-option --last ng-star-inserted']/div[contains(., ' Direct Thing ')]", desc = "Direct thing option in drop down filter device type")
    private static PageElement directThingOptionFilter;
    @Element(xpath = "//*[contains(text(),'Gateway Software Type')]/following-sibling::*//i", desc = "dropdown icon Status Filter box")
    private static PageElement dropdownGatewaySoftwareTypeFilterBox;
    @Element(xpath = "//*[@name='confirm']/button[contains(text(), 'Confirm')]", desc = "confirm btn filter option")
    private static PageElement confirmFilterOptionBtn;
    @Element(xpath = "//dmc-radio-group-option[contains(., 'Direct Thing')]", desc = "Direct Thing radio button")
    private static PageElement directThingRadioBtn;
    @Element(xpath = "//dmc-radio-group-option[contains(., 'Gateway Things')]", desc = "gateway Things radio button")
    private static PageElement gatewayThingRadioBtn;
    @Element(xpath = "//dmc-radio-group-option[contains(., 'Gateway')]", desc = "gateway Things radio button")
    private static PageElement gatewayRadioBtn;
    /*----------------------------------------- Custom Query Elements --------------------------------------------*/
    @Element(xpath = "//div[@class=\"-card-header\"]/div[@class=\"-card-title\"]/h2[text()=\"Custom query\"]", desc = "Custom Query box")
    private static PageElement customQueryBox;
    @Element(xpath = "//dmc-custom-query-filter/descendant::i", desc = "Dropdown arrow on Custom Query Filter")
    private static PageElement dropdownCustomQueryBox;
    @Element(xpath = "//textarea", desc = "template form")
    private static PageElement templateForm;
    /*----------------------------------------- Table Header --------------------------------------------*/
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Device ID')]", desc = "DEVICE ID column header")
    private static PageElement deviceIdColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Thing ID')]", desc = "THING ID column header")
    private static PageElement thingIdColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Device Type')]", desc = "DeVICE TYPE column header")
    private static PageElement deviceTypeColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Software Type')]", desc = "SOFTWARE TYPE column header")
    private static PageElement softwareTypeColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Deploy Type')]", desc = "DEPLOY TYPE column header")
    private static PageElement deployTypeColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Start')]", desc = "START column header")
    private static PageElement startColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Duration')]", desc = "DURATION column header")
    private static PageElement durationColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Software version')]", desc = "SOFTWARE VERSION column header")
    private static PageElement softwareVersionColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Latest')]", desc = "LATEST column header")
    private static PageElement latestColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Status')]", desc = "STATUS column header")
    private static PageElement statusColumnHeader;
    @Element(xpath = "//th[@class='--align-right ng-star-inserted']", desc = "Actions column header")
    private static PageElement actionColumnHeader;
    @Element(xpath = "(//i[@class=\"dmc-icon__document dmc-icon\"])[1]", desc = "First detail buttons")
    private static PageElement detailBtn;
    /*----------------------------------------- Tooltips on Table Header --------------------------------------------*/
    @Element(xpath = "//footer/button[contains(.,'Close')]", desc = "Close Tooltip Pop-up Button")
    private static PageElement closeTooltipButton;
    //Software type
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Software Type')]/i", desc = "Software Type Tooltip Icon")
    private static PageElement softwareTypeTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[contains(.,'Software Type')]", desc = "Software Type Tooltip Pop-up Title")
    private static PageElement softwareTypeTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[contains(.,'Software category of the packages inside the Software Catalogue')]", desc = "Software Type Tooltip Pop-up Text")
    private static PageElement softwareTypeTooltipText;
    //Deploy type
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Deploy Type')]/i", desc = "Deploy Type Tooltip Icon")
    private static PageElement deployTypeTooltipIcon;
    @Element(xpath = "//ng-component/h4[contains(.,'Deploy Type')]", desc = "Software Type Tooltip Pop-up Title")
    private static PageElement deployTypeTooltipTitle;
    @Element(xpath = "//h4[contains(.,'Deploy Type')]/following-sibling::ul/li[contains(.,'only for Gateway') and contains(.,'when the gateway is updated using the command') and contains(.,'Firmware Update')]/strong[text()='Gateway Software']", desc = "Software Type Tooltip Pop-up Text Gateway Software")
    private static PageElement deployTypeTooltipTextGatewaySoftware;
    @Element(xpath = "//h4[contains(.,'Deploy Type')]/following-sibling::ul/li[contains(.,'only for Gateway') and contains(.,'when the gateway is updated using the command') and contains(.,'Greengrass Reset')]/strong[text()='Greengrass Software']", desc = "Software Type Tooltip Pop-up Text Greengrass Software")
    private static PageElement deployTypeTooltipTextGreengrassSoftware;
    @Element(xpath = "//h4[contains(.,'Deploy Type')]/following-sibling::ul/li[contains(.,'only for Gateway') and contains(.,'when the gateway is updated using the command') and contains(.,'Greengrass Deploy')]/strong[text()='Greengrass Deployment']", desc = "Software Type Tooltip Pop-up Text Greengrass Deployment")
    private static PageElement deployTypeTooltipTextGreengrassDeployment;
    @Element(xpath = "//h4[contains(.,'Deploy Type')]/following-sibling::ul/li[contains(.,'only for Direct Thing') and contains(.,'when the direct thing is updated using the command') and contains(.,'Firmware Update')]/strong[text()='Direct Thing Software']", desc = "Software Type Tooltip Pop-up Text Direct Thing Software")
    private static PageElement deployTypeTooltipTextDirectThingSoftware;
    @Element(xpath = "//h4[contains(.,'Deploy Type')]/following-sibling::ul/li[contains(.,'only for Gateway') and contains(., 's Things') and contains(.,'when a thing of a gateway is updated using the command') and contains(.,'Firmware update')]/strong[text()='Gateway Thing Software']", desc = "Software Type Tooltip Pop-up Text Gateway Thing Software")
    private static PageElement deployTypeTooltipTextGatewayThingSoftware;
    //Start
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Start')]/i", desc = "Start Tooltip Icon")
    private static PageElement startTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[contains(.,'Start')]", desc = "Start Tooltip Pop-up Title")
    private static PageElement startTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[contains(.,'Date and time when the deployment has been launched')]", desc = "Start Tooltip Pop-up Text")
    private static PageElement startTooltipText;
    //Duration
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Duration')]/i", desc = "Duration Tooltip Icon")
    private static PageElement durationTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[contains(.,'Duration')]", desc = "Duration Tooltip Pop-up Title")
    private static PageElement durationTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[contains(.,'The time interval between the begin and the end of the Deployment')]", desc = "Duration Tooltip Pop-up Text")
    private static PageElement durationTooltipText;
    //Software Version
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Software version')]/i", desc = "Software Version Tooltip Icon")
    private static PageElement softwareVersionTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[contains(.,'Software version')]", desc = "Software Version Tooltip Pop-up Title")
    private static PageElement softwareVersionTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[contains(.,'The current software version installed on the device')]", desc = "Software Version Tooltip Pop-up Text")
    private static PageElement softwareVersionTooltipText;
    //Latest
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Latest')]/i", desc = "Latest Tooltip Icon")
    private static PageElement latestTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[contains(.,'Latest')]", desc = "Latest Tooltip Pop-up Title")
    private static PageElement latestTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[contains(.,'When flagged, define that is the last Deploy done on that device')]", desc = "Latest Toolptip Pop-up Text")
    private static PageElement latestTooltipText;
    //Status
    @Element(xpath = "//th/..//div[contains(@class, 'ng-star-inserted') and contains(.,'Status')]/i", desc = "Status Tooltip Icon")
    private static PageElement statusTooltipIcon;
    @Element(xpath = "//ng-component/h4[contains(.,'Status')]", desc = "Status Tooltip Pop-up Title")
    private static PageElement statusTooltipTitle;
    @Element(xpath = "//div/h5[contains(.,'Deploy Type')]", desc = "Deploy Type Icon List Title")
    private static PageElement statusDeployTypeListTitle;
    @Element(xpath = "//i[@dmcicon='greengrass-circle']/ancestor::li[contains(.,'Greengrass Software')]", desc = "Deploy Type Greengrass Software")
    private static PageElement deployTypeGreengrassSoftware;
    @Element(xpath = "//i[@dmcicon='greengrass']/ancestor::li[contains(.,'Greengrass Deployment')]", desc = "Deploy Type Greengrass Deployment")
    private static PageElement deployTypeGreengrassDeployment;
    @Element(xpath = "//i[@dmcicon='grid-3x3']/ancestor::li[contains(.,'Gateway Software')]", desc = "Deploy Type Gateway Software")
    private static PageElement deployTypeGatewaySoftware;
    @Element(xpath = "//i[@dmcicon='grid-3x3']/ancestor::li[contains(.,'Direct Thing Software')]", desc = "Deploy Type Diret Thing Software")
    private static PageElement deployTypeDirectThingSoftware;
    @Element(xpath = "//i[@dmcicon='grid-3x3']/ancestor::li[contains(.,'Gateway Thing Software')]", desc = "Deploy Type Gateway Thing Software")
    private static PageElement deployTypeGatewayThingSoftware;
    @Element(xpath = "//div/h5[contains(.,'Status')]", desc = "Status Color List Title")
    private static PageElement statusStatusListTitle;
    @Element(xpath = "//i[@class='--circle --timeout']/ancestor::li[contains(.,'Timeout')]", desc = "Status Deployment Timeout")
    private static PageElement statusTimeout;
    @Element(xpath = "//i[@class='--circle --complete']/ancestor::li[contains(.,'Completed')]", desc = "Status Deployment Completed")
    private static PageElement statusCompleted;
    @Element(xpath = "//i[@class='--circle --pending']/ancestor::li[contains(.,'In Progress')]", desc = "Status Deployment In Progress")
    private static PageElement statusInProgress;
    @Element(xpath = "//i[@class='--circle --failed']/ancestor::li[contains(.,'Failed')]", desc = "Status Deployment Failed")
    private static PageElement statusFailed;
    @Element(xpath = "//i[@class='--circle --partial']/ancestor::li[contains(.,'Partial')]", desc = "Status Deployment Partial")
    private static PageElement statusPartial;
    /*----------------------------------------- Voice on Deployment Details Page --------------------------------------------*/
    @Element(xpath = "//div[contains(text(), \" Latest \")]", desc = "Latest Voice in Deployment Detail Page")
    private static PageElement latestVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Deploy Type\")]", desc = "Deploy Type Voice in Deployment Detail Page")
    private static PageElement deployTypeVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Software Type\")]", desc = "Software Type Voice in Deployment Detail Page")
    private static PageElement softwareTypeVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Device ID\")]", desc = "Device ID Voice in Deployment Detail Page")
    private static PageElement deviceIdVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Duration\")]", desc = "Duration Voice in Deployment Detail Page")
    private static PageElement durationVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Environment Prefix\")]", desc = "Environment Prefix Voice in Deployment Detail Page")
    private static PageElement environmentPrefixVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Installed Packages\")]", desc = "Installed Packages Voice in Deployment Detail Page")
    private static PageElement installedPackagesVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Current Stack\")]", desc = "Current Stack Voice in Deployment Detail Page")
    private static PageElement currentStackVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Packages Installations Outcome\")]", desc = "Packages To Install Voice in Deployment Detail Page")
    private static PageElement packagesInstallOutcomeVoiceOnDetailPage;
    @Element(xpath = "//div[contains(text(), \"Custom Status\")]", desc = "Custom Status Voice in Deployment Detail Page")
    private static PageElement customStatusVoiceOnDetailPage;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'regression-eig')]", desc = "regression-eig option in Gateway Software Type")
    private static PageElement regressionEigOption;
    @Element(xpath = "//button[@color=\"accent\" and contains(text(), \"Confirm\")]/ancestor::dmc-collapsable-card-action/preceding-sibling::*//button[contains(text(),'Clear') and contains(@class,'size')]", desc = "Clear Button")
    private static PageElement clearButton;
    @Element(xpath = "//*[contains(text(),'Status')]/following-sibling::*//i", desc = "Completed option in Status")
    private static PageElement statusDropdown;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Completed')]", desc = "Completed option in Status")
    private static PageElement completedOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Failed')]", desc = "Failed option in Status")
    private static PageElement failedOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Timeout')]", desc = "Timeout option in Status")
    private static PageElement timeoutOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Partial')]", desc = "Partial option in Status")
    private static PageElement partialOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'In Progress')]", desc = "In Progress option in Status")
    private static PageElement inProgressOption;
    @Element(xpath = "//*[contains(text(),'Lates')]/following-sibling::*//i", desc = "Latest dropdown")
    private static PageElement latestDropdown;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Yes')]", desc = "Yes in Latest")
    private static PageElement YesOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'No')]", desc = "No in Latest")
    private static PageElement NoOption;
    @Element(xpath = "//td/i[contains(@dmcicon,'check')]", desc = "Yes Icon in Latest")
    public static PageElement YesIcon;
    @Element(xpath = "//*[contains(text(),'Deploy Type')]/following-sibling::*//i", desc = "Deploy Type dropdown")
    private static PageElement deployType;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Gateway Software')]", desc = "Gateway Software in Deploy Type")
    private static PageElement gatewaySoftwareOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Greengrass Software')]", desc = "Greengrass Software in Deploy Type")
    private static PageElement greengrassSoftwareOption;
    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Greengrass Deployment')]", desc = "Greengrass Deployment in Deploy Type")
    private static PageElement greengrassDeploymentOption;
    @Element(xpath = "//*[contains(@class,'-rows-counters')]", desc = "Completed option in Status")
    public static PageElement rowsDisplayed;
    @Element(xpath = "//td[contains(@class,'selectable-column')]", desc = "Checkable icon for row")
    public static PageElement checkableRow;
    @Element(xpath = "//button[contains(@class,'floating')]", desc = "Release button")
    public static PageElement releaseButton;
    @Element(xpath = "//*[contains(text(),'Deploy Software')]", desc = "Deploy Software Title Popup")
    public static PageElement deploySoftwareTitlePopup;
    @Element(xpath = "//*[contains(text(),'What do you want to do?')]", desc = "What do you want to do subtitle in Popup")
    public static PageElement subtitlePopup;
    @Element(xpath = "//*[contains(text(),'Greengrass deploy')]/preceding-sibling::i/parent::button", desc = "Greengrass deploy Button")
    public static PageElement greengrassDeployButton;
    @Element(xpath = "//*[contains(text(),'Greengrass reset')]/preceding-sibling::i/parent::button", desc = "Greengrass reset Button")
    public static PageElement greengrassResetButton;
    @Element(xpath = "//*[contains(text(),'Ota Update')]/preceding-sibling::i/parent::button", desc = "Ota Update Button")
    public static PageElement otaUpdateButton;
    @Element(xpath = "//*[contains(text(),'Firmware Update')]/preceding-sibling::i/parent::button", desc = "Firmware Update Button")
    public static PageElement firmwareUpdateButton;
    @Element(xpath = "(//td[contains(., 'Test_Concept-01')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Firmware Update Button")
    public static PageElement lastDeployWithConcept01;

    @Element(xpath = "(//td[contains(., 'Gateway29')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Firmware Update Button")
    public static PageElement lastDeployWithGateway29;
    @Element(xpath = "(//td[contains(., 'Gateway29-Concept1')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Firmware Update Button")
    public static PageElement lastDeployWithGateway29Concept1;
    @Element(xpath = "(//td[contains(., 'Test_Concept-17')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Firmware Update Button")
    public static PageElement lastDeployTestConcept17;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Firmware Update Button")
    public static PageElement lastDeployWithConcept02;
    @Element(xpath = "(//td[contains(., 'DirectMX')]//following-sibling::td//*[@icon='document'])[2]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectMX;
    @Element(xpath = "(//td[contains(., 'DirectMX2')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectMX2;

    @Element(xpath = "(//td[contains(., 'DirectCoreApril1')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectCoreApril;
    @Element(xpath = "(//td[contains(., 'DirectCoreApril2')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectCoreApril2;

    @Element(xpath = "(//td[contains(., 'DirectCoreApril3')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectCoreApril3;
    @Element(xpath = "(//td[contains(., 'DirectCoreApril4')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirectCoreApril4;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept191')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirect1;
    @Element(xpath = "(//td[contains(., 'DirectThingConcept192')]//following-sibling::td//*[@icon='document'])[1]", desc = "Firmware Update Button")
    public static PageElement lastDeployWithDirect2;
    @Element(xpath = "(//td[contains(., ' Test_Concept-51')]//following-sibling::td//*[contains(.,'N/A')])[1]", desc = "Last Deployment TestConcept51 Thing 1 SW N/A")
    public static PageElement lastDeployThingConcept51SWNA;
    @Element(xpath = "(//td[contains(., ' Test_Concept-51')]//following-sibling::td//*[contains(.,' test-bia-app@1.0 ')])[1]", desc = "Last Deployment TestConcept51 Thing 1 SW N/A")
    public static PageElement lastDeployThingConcept51App1;
    @Element(xpath = "(//td[contains(., ' Test_Concept-51')]//following-sibling::td[contains(.,' THING_GENERIC ')])[1]", desc = "Last Deployment TestConcept51 Thing 1 SW N/A")
    public static PageElement lastDeployThingConcept51Generic;
    @Element(xpath = "(//td[contains(., 'Test_Concept-51_thing2')]//following-sibling::td//*[@icon='document'])[1]", desc = "Last Deployment TestConcept55 Thing 1")
    public static PageElement lastDeployThingConcept51thing2;
    @Element(xpath = "(//td[contains(., 'Test_Concept-55_thing1')]//following-sibling::td//*[@icon='document'])[1]", desc = "Last Deployment TestConcept55 Thing 1")
    public static PageElement lastDeployThingConcept55thing1;

    @Element(xpath = "(//td[contains(., ' GatewayConceptTest57')]//following-sibling::td//*[contains(.,'N/A')])[1]", desc = "Last Deployment GatewayConceptTest57 Thing 1 SW N/A")
    public static PageElement lastDeployThingGatewayConceptTest57SWNA;


    @Element(xpath = "//span[contains(text(),'APP1 v3.2')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2909;

    @Element(xpath = "//*[contains(.,'Thing ID')]/following-sibling::input[@type='text']", desc = "thing ID input box")
    public static PageElement thingIDInputBox;
    @Element(xpath = "(//td[contains(., 'DirectThingConcept2')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last deploy direct")
    public static PageElement lastDeployWithDirectThingConcept2;
    @Element(xpath = "(//td[contains(., 'DirectThingConcept1')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last deploy direct")
    public static PageElement lastDeployWithDirectThingConcept1;
    public static String getFirstCheckboxSpecifEntryInTheTable() {
        return firstCheckboxSpecifEntryInTheTable;
    }

    public static void setFirstCheckboxSpecifEntryInTheTable(String deviceID) {
        String firstCheckboxSpecifEntryInTheTable = "(//td[contains(., '%s')]/preceding-sibling::td)[1]";
        DeploymentsHistoryPage.firstCheckboxSpecifEntryInTheTable = String.format(firstCheckboxSpecifEntryInTheTable, deviceID );
    }

    private static String firstCheckboxSpecifEntryInTheTable = "";

    public static String getFirstDetailIconSpecifEntryInTheTable() {
        return firstDetailIconSpecifEntryInTheTable;
    }

    public static void setFirstDetailIconSpecifEntryInTheTable(String deviceID) {
        String firstDetailIconSpecifEntryInTheTable = "(//td[contains(., '%s')]/following-sibling::td//div/i[contains(@class, 'dmc-icon__document')])[1]";
        DeploymentsHistoryPage.firstDetailIconSpecifEntryInTheTable = String.format(firstDetailIconSpecifEntryInTheTable, deviceID);
    }

    private static String firstDetailIconSpecifEntryInTheTable = "";


    @Element(xpath = "//*[contains(.,'Gateway ID')]/following-sibling::input[@type='text']", desc = "thing ID input box")
    public static PageElement gatewayIDInputBox;

    @Element(xpath = "//*[contains(text(),'Thing Software Type')]/following-sibling::*//i", desc = "dropdown Thing Software type")
    private static PageElement dropdownThingSoftwareTypeFilterBox;

    @Element(xpath = "//*[contains(@class,'option') and contains(text(),'Generic')]", desc = "generic device option in drop down button")
    private static PageElement genericDeviceOption;

    @Element(xpath = "//div/span[contains(.,' Righe per pagina ')]", desc = "Rows per page at the end of the page in Italian")
    private static PageElement rowsPerPageIT ;
    public static PageElement getRowsPerPageIT(){return rowsPerPageIT;}

    @Element(xpath = "//dmc-table-page-selector", desc = "page number indicator in Italian")
    private static PageElement pageCountersIT ;
    public static PageElement getPageCountersIT(){return pageCountersIT;}

    @Element(xpath = "//li/button[contains(.,' Reimposta larghezza colonne ')]", desc = "resize columns in column actions in Italian")
    private static PageElement resizeColumnsIT ;
    public static PageElement getResizeColumnsIT(){return resizeColumnsIT;}

    @Element(xpath = "//span[contains(.,' Chiudi ')]", desc = "close column actions in Italian")
    private static PageElement closeColumnsBTN ;
    public static PageElement getCloseColumnsBTN(){return closeColumnsBTN;}

    @Element(xpath = "(//dmc-form-field-label[contains(., ' Device type ')])/following-sibling::dmc-select//div//div//div//div[contains(., ' Gateway ')]"
            , desc = "Direct thing option in drop down filter device type")
    private static PageElement gatewayOptionFilter;

    @Element(xpath = "(//dmc-form-field-label[contains(., ' Device type ')])/following-sibling::dmc-select//div//div//div//div[contains(., ' Gateway Things ')]"
            , desc = "Direct thing option in drop down filter device type")
    private static PageElement thingsOptionFilter;

    @Element(xpath = "//i[@class='mat-tooltip-trigger --complete -status-icon dmc-icon__grid-3x3 dmc-icon-size-normal dmc-icon ng-star-inserted']", desc = "Icon complete")
    private static PageElement iconComplete;
    @Element(xpath = "//i[@class='mat-tooltip-trigger --pending -status-icon dmc-icon__grid-3x3 dmc-icon-size-normal dmc-icon ng-star-inserted']", desc = "Icon complete")
    private static PageElement iconPending;
    @Element(xpath = "//i[@class='mat-tooltip-trigger --partial -status-icon dmc-icon__grid-3x3 dmc-icon-size-normal dmc-icon ng-star-inserted']", desc = "Icon complete")
    private static PageElement iconPartial;
    @Element(xpath = "//i[@class='mat-tooltip-trigger --failed -status-icon dmc-icon__grid-3x3 dmc-icon-size-normal dmc-icon ng-star-inserted']", desc = "Icon complete")
    private static PageElement iconFailed;
    @Element(xpath = "//i[@class='mat-tooltip-trigger --timeout -status-icon dmc-icon__grid-3x3 dmc-icon-size-normal dmc-icon ng-star-inserted']", desc = "Icon complete")
    private static PageElement iconTimeout;
    @Element(xpath = "//td[contains(.,'Test_Concept-51_thing2')]/following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit icon Test_Concept-55 thing1 deployment")
    private static PageElement lastDeployTestConcept51Thing2edit;
    @Element(xpath = "//td[contains(.,'Test_Concept-55_thing2')]/following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit icon Test_Concept-55 thing1 deployment")
    private static PageElement lastDeployTestConcept55Thing1edit;

    //Deployment history edit page
    @Element(xpath = "//h2[contains(.,'Update deployment status')]", desc = "Deployment history edit page title")
    private static PageElement deploymentEditTitle;
    @Element(xpath = "//div[contains(.,' Select option... ')]/following-sibling::i[@dmcicon='chevron-down']", desc = "Deployment option dropdown")
    private static PageElement selectOptionDropdown;
    @Element(xpath = "//div[@class='-option ng-star-inserted' and contains(.,' Completed ')]", desc = "option Completed")
    private static PageElement optionCompleted;
    @Element(xpath = "//div[@class='-option ng-star-inserted' and contains(.,' Partial ')]", desc = "option partial")
    private static PageElement optionPartial;
    @Element(xpath = "//div[@class='-option ng-star-inserted' and contains(.,' Failed ')]", desc = "option failed")
    private static PageElement optionFailed;
    @Element(xpath = "//div[@class='-option --last ng-star-inserted' and contains(.,' Timeout ')]", desc = "option timeout")
    private static PageElement optionTimeout;
    @Element(xpath = "//button[contains(.,' Confirm ')]", desc = "option timeout")
    private static PageElement buttonConfirm;

}