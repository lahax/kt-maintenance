package test.pages;

import cucumber.api.java.zh_cn.而且;
import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DevicesPage {


    @Element(xpath = "//h2[contains(text(), 'Devices')]", desc = "Devices lending page title ")
    private static PageElement devicesLandingPageTitle;

    @Element(xpath = "(//table//tr//td)[10]//i[@class='dmc-icon__document dmc-icon']", desc = "Details button")
    private static PageElement detailsButton;

    public static PageElement getDevicesLandingPageTitle() {return devicesLandingPageTitle;}

    @Element(xpath = "//i[@dmcicon='plus']/ancestor::dmc-fab", desc = "icon activate direct")
    private static PageElement iconActivateDirect;

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh devices")
    private static PageElement refreshDevicesBTN;

    @Element(xpath = "//dmc-table", desc = "devices table")
    private static PageElement tableDevicesPage;

    @Element(xpath = "//div[contains(text(), 'Country')]/ancestor::div[@role='tab']", desc = "country button")
    private static PageElement countryDevicesBTN;

    @Element(xpath = "//div[contains(text(), 'List')]/ancestor::div[@role='tab']", desc = "list button")
    private static PageElement listDevicesBTN;

    @Element(xpath = "//div[@aria-label='Map']", desc = "country map in devices")
    private static PageElement countryMapDevices;

    @Element(xpath = "(//dmc-table-action[@icon='document'])[position()=1]", desc = "first row device detail icon")
    private static PageElement firstRowDeviceDetailsIcon;

    @Element(xpath = "(//dmc-command-button)[position()=1]", desc = "reboot button")
    private static PageElement rebootBTN;

    @Element(xpath = "//dmc-table-columns-selector", desc = "Customize table voice button")
    private static PageElement tableColumnsSelectorBtn;

    @Element(xpath = "//button[contains(text(),'Reboot')]", desc = "Confirm reboot button")
    private static PageElement confirmRebootBtn;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-01')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 device detail icon")
    private static PageElement testConcept01Details;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-02')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept02 device detail icon")
    private static PageElement testConcept02Details;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-03')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept03 device detail icon")
    private static PageElement testConcept03Details;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-04')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept04 device detail icon")
    private static PageElement testConcept04Details;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-61')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 device detail icon")
    private static PageElement testConcept61Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-03_thing1')]", desc = "test concept03 thing1 row")
    private static PageElement testConcept03Thing1Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-03_thing1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept03 thing1 device detail icon")
    private static PageElement testConcept03Thing1Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-03_thing2')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept03 thing1 device detail icon")
    private static PageElement testConcept03Thing2Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 thing3 device detail icon")
    private static PageElement testConcept01Thing3Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-04_thing2')]", desc = "test concept04 thing2 row")
    private static PageElement testConcept04Thing2Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-03_thing2')]", desc = "test concept03 thing2 row")
    private static PageElement testConcept03Thing2Row;

    //Test_Concept-51
    @Element(xpath = "//strong[contains(text(), 'Test_Concept-51')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept51 device detail icon")
    private static PageElement testConcept51Details;
    @Element(xpath = "//strong[contains(text(), 'Test_Concept-55')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept51 device detail icon")
    private static PageElement testConcept55Details;
    @Element(xpath = "//strong[contains(text(), 'Test_Concept-54')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept54 device detail icon")
    private static PageElement testConcept54Details;


    @Element(xpath = "//em[contains(text(), 'Test_Concept-51_thing1')]", desc = "test concept51 thing1 row")
    private static PageElement testConcept51Thing1Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-51_thing1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept51 thing1 device detail icon")
    private static PageElement testConcept51Thing1Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-51_thing2')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept51 thing1 device detail icon")
    private static PageElement testConcept51Thing2Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-51_thing3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept51 thing3 device detail icon")
    private static PageElement testConcept51Thing3Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-51_thing2')]", desc = "test concept51 thing2 row")
    private static PageElement testConcept51Thing2Row;


    @Element(xpath = "//em[contains(text(), 'Test_Concept-02_thing1')]", desc = "test concept02 thing1 row")
    private static PageElement testConcept02Thing1Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-02_thing2')]", desc = "test concept02 thing2 row")
    private static PageElement testConcept02Thing2Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing1')]", desc = "test concept01 thing3 row")
    private static PageElement testConcept01Thing1Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing2')]", desc = "test concept01 thing3 row")
    private static PageElement testConcept01Thing2Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing3')]", desc = "test concept01 thing3 row")
    private static PageElement testConcept01Thing3Row;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-02_thing1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept02 thing1 device detail icon")
    private static PageElement testConcept02Thing1Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-02_thing2')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept02 thing2 device detail icon")
    private static PageElement testConcept02Thing2Details;

    @Element(xpath = "//span[contains(text(), 'DirectThing_Test15_26')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing device detail icon")
    private static PageElement directThingDetails;

    @Element(xpath = "//span[contains(text(), 'DirectXX')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing device detail icon")
    private static PageElement directXXDetails;

    @Element(xpath = "//span[contains(text(), 'DirectMI')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing device detail icon")
    private static PageElement directMIDetails;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(., 'Deployments History')]", desc = "deployments history tab in the device details page")
    private static PageElement deploymentHistoryTab;

    //ACTIVATE DIRECT THING PAGE//
    @Element(xpath = "//input[@placeholder='ID Direct Thing']", desc = "id direct thing box")
    private static PageElement idDirectThingBox;
    @Element(xpath = "//input[@placeholder='Maker']", desc = "Maker box")
    private static PageElement makerBox;
    @Element(xpath = "//input[@placeholder='Radio Type']", desc = "radio type box")
    private static PageElement radioTypeBox;
    @Element(xpath = "//input[@placeholder='Serial Number']", desc = "serial number box")
    private static PageElement serialNumberBox;
    @Element(xpath = "//input[@placeholder='Device Type']", desc = "device type box")
    private static PageElement deviceTypeBox;
    @Element(xpath = "//input[@placeholder='Model']", desc = "model box")
    private static PageElement modelBox;

    @Element(xpath = "//dmc-form-field-label[contains(., ' Device type')]/following-sibling::dmc-multi-select", desc = "Device Type filter box")
    private static PageElement multiSelectDeviceTypeOption;
    @Element(xpath = "//dmc-multi-select-option/div[contains(., 'direct thing')]/following-sibling::i", desc = "Direct thing option in Device Type filter box")
    private static PageElement directThingDeviceTypeOption;

    @Element(xpath = "//dmc-form-field-label[contains(., ' Status')]/following-sibling::dmc-multi-select", desc = "Status filter box")
    private static PageElement multiSelectStatusOption;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Certificate expiration')]/following-sibling::dmc-multi-select", desc = "Device Type filter box")
    private static PageElement multiSelectCertificateExpirationOption;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Model')]/following-sibling::dmc-chips-autocomplete/descendant::input", desc = "Model input filter box")
    private static PageElement inputModelBox;
    @Element(xpath = "//dmc-form-field-label[contains(., ' Maker')]/following-sibling::dmc-chips-autocomplete/descendant::input", desc = "Model input filter box")
    private static PageElement inputMakerBox;

    @Element(xpath = "//span[contains(text(), 'Close')]", desc = "Close dropdown button")
    private static PageElement closeDropdownBTN;
    @Element(xpath = "//td//div[contains(@class, '--align-left --ellipsis ng-star-inserted') and contains(., ' Serial number ')]", desc = "Serial Number Columm mobile view")
    private static PageElement serialNumberColumnMobile;
    @Element(xpath = "//li/div[contains(., 'RULE ID')]", desc = "Rule ID Column")
    private static PageElement ruleidColumn;
    @Element(xpath = "(//dmc-dummy-input/i[@dmcicon='chevron-down'])[position()=1]", desc = "Drop Down Arrow --> position1 , can be used in many pages ")
    private static PageElement dropDownArrow;
    @Element(xpath = "//button[contains(., 'Activate')]", desc = "confirm activation direct thing")
    private static PageElement confirmActivationDirectThing;
    @Element(xpath = "(//tbody/tr/td//i[contains(@class, 'dmc-icon__document')])[1]", desc = "Icon details first row")
    private static PageElement iconDetailsFirstRow;
    @Element(xpath = "//span[contains(text(), 'Devices')]", desc = "title device details page")
    private static PageElement titleDeviceDetailsPage;
    @Element(xpath = "//div[@aria-label='Map']", desc = "Map device details page")
    private static PageElement mapDeviceDetailsPage;
    @Element(xpath = "//h4[contains(text(), 'System Commands')]", desc = "Label System Cmmands device details page")
    private static PageElement labelSystemCommandsDeviceDetailsPage;
    @Element(xpath = "//input[@type='search']", desc = "search box")
    private static PageElement searchBox;

    @Element(xpath = "//dmc-filters-section/div[@class='dmc-card']", desc = "Filter box on the page")
    private static PageElement filterBox;

    @Element(xpath = "(//div[@class=\"-resize-bar\"])[1]", desc = "Resize bar first column (ID)")
    private static PageElement resizeBarColumnID;

    public static PageElement getResizeBarColumnID() { return resizeBarColumnID; }

    public static PageElement getTableDevicesPage() {
        return tableDevicesPage;
    }

    public static PageElement getRebootButton() {
        return rebootBTN;
    }

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh button")
    private static PageElement refreshBTN;

    public static PageElement getConfirmRebootBtn() {
        return confirmRebootBtn;
    }

    public static PageElement getIconActivateDirect() {
        return iconActivateDirect;
    }

    public static PageElement getSearchBox() { return searchBox;
    }

    public static PageElement getDetailsButton() {return detailsButton;
    }

    @Element(xpath = "//strong[contains(text(), 'EVO21')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']",
            desc = "A gateway without data suggested by test case 7.10")
    private static PageElement evo21GatewayWithoutDataDetailsIcon;

    @Element(xpath = "//strong[contains(text(), 'EIG_ARM_AtonTest02')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']",
            desc = "A gateway without coordinates suggested by test case 7.2")
    private static PageElement eigAtonGatewayNoCoordinatesDetailsIcon;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-01')]/ancestor::td//following-sibling::td//dmc-badge[contains(.,' disconnected ')]",
            desc = "test concept01 disconneted status")
    private static PageElement testConcept01DisconnectedStatus;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-01')]/ancestor::td//following-sibling::td//dmc-badge[contains(.,' connected ')]",
            desc = "test concept01 disconneted status")
    private static PageElement testConcept01ConnectedStatus;
    //It seem redundant but this one point the first row details with a gateway not a random row
    @Element(xpath = "((//td[contains(., ' gateway ')])//following-sibling::td//dmc-table-action[@icon='document'])[1]", desc = "First gateway details icon button")
    private static PageElement firstGatewayIconBtn;

    @Element(xpath = "//i[@dmcicon='link']", desc = "Align status link icon")
    private static PageElement alignStatusIcon;

    @Element(xpath = "//span[contains(text(), 'DirectThingConcept4')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing 4 device detail icon")
    private static PageElement directConcept4Details;

    @Element(xpath = "//span[contains(text(), 'DirectThingConcept3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing 3 device detail icon")
    private static PageElement directConcept3Details;

    @Element(xpath = "//span[contains(text(), 'DirectConceptDec3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing 3 device detail icon")
    private static PageElement directConceptDec3Details;

    @Element(xpath = "//span[contains(text(), 'DirectMX')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing mx 3 device detail icon")
    private static PageElement directMXDetails;

    @Element(xpath = "//span[contains(text(), 'DirectCoreApril3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct core april 3 device detail icon")
    private static PageElement directCoreApril3Details;

    @Element(xpath = "//span[contains(text(), 'DirectCoreApril4')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct core april 4 device detail icon")
    private static PageElement directCoreApril4Details;

    @Element(xpath = "//span[contains(text(), 'Direct-Concept-1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct concept 1 device detail icon")
    private static PageElement directConcept1Det;

    @Element(xpath = "//span[contains(text(), 'Direct-Concept-2')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct concept 1 device detail icon")
    private static PageElement directConcept2Det;

    @Element(xpath = "//span[contains(text(), 'Direct-Concept-3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct concept 1 device detail icon")
    private static PageElement directConcept3Det;

    @Element(xpath = "//span[contains(text(), 'Direct-Concept-4')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct concept 1 device detail icon")
    private static PageElement directConcept4Det;

    @Element(xpath = "//span[contains(text(), 'DirectMX3')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing mx 3 device detail icon")
    private static PageElement directMX3Details;

    @Element(xpath = "//span[contains(text(), 'DirectConceptDec')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing concept dec device detail icon")
    private static PageElement directConceptDecDetails;

    @Element(xpath = "//span[contains(text(), 'DirectThingConcept2')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing 2 device detail icon")
    private static PageElement directConcept2Details;

    @Element(xpath = "//span[contains(text(), 'DirectThingConcept1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "direct thing 1 device detail icon")
    private static PageElement directConcept1Details;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-02')]/ancestor::td//following-sibling::td//dmc-badge[contains(.,' disconnected ')]",
            desc = "test concept01 disconneted status")
    private static PageElement testConcept02DisconnectedStatus;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-02')]/ancestor::td//following-sibling::td//dmc-badge[contains(.,' connected ')]",
            desc = "test concept01 disconneted status")
    private static PageElement testConcept02ConnectedStatus;

    @Element(xpath = "//i[@dmcicon='table-columns']", desc = "select column icon")
    private static PageElement selectColumnsIcon;

    @Element(xpath = "//ul[@class='-dropdown']", desc = "dropdown voices table ")
    private static PageElement dropdownVoicesTableDevice;

    @Element(xpath = "//ul[@class='-dropdown']/li/div[contains(text(), ' SERIAL NUMBER ')]", desc = "dropdown 'SERIAL NUMBER' voice")
    private static PageElement dropdownSerialNumberVoice;

    public static PageElement getPaginationTableButton() {
        return paginationTableButton;
    }

    public static PageElement getPagesCounter() {
        return pagesCounter;
    }

    @Element(xpath = "//div[@class='-pages-counters ng-star-inserted']", desc = "Counter number of pages")
    private static PageElement pagesCounter;

    @Element(xpath = "//div[@class='mat-select-arrow ng-tns-c139-17']", desc = "Menu counter page btn")
    private static PageElement menuCounterPageBtn;

    @Element(xpath = "//*[@id='mat-select-value-1']/span/span" , desc= "button Confirm into calendar")
    public static PageElement paginationTableButton;

    @Element(xpath = "//div[@id='mat-select-0-panel']", desc = "menu to select page number on the table")
    private static PageElement menuPagesNumberOnTheTable;

    @Element(xpath = "//div[@class='col-6 text-center']/descendant::button[contains(., 'Confirm')]",
            desc = "confirm button align")
    private static PageElement confirmAlignBTN;

    @Element(xpath = "//dmc-devices-filters/descendant::button[contains(., 'Confirm')]", desc = "Confirm Button in Filter box")
    private static PageElement confirmFilterBtn;

    @Element(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c139-17']", desc ="")
    private static PageElement dropdownRowForPage;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 thing1 device detail icon")
    private static PageElement testConcept01thing1Details;

    public static String getIconDetailSpeficDeviceId() {
        return iconDetailSpeficDeviceId;
    }

    public static void setIconDetailSpeficDeviceId(String deviceID) {
        String iconDetailSpeficDeviceId = "(//td[contains(., '%s')]/following-sibling::td//div/i[contains(@class, 'dmc-icon__document')])[1]";
        DevicesPage.iconDetailSpeficDeviceId = String.format(iconDetailSpeficDeviceId, deviceID);
    }

    private static String iconDetailSpeficDeviceId = "";

    @Element(xpath = "//strong[contains(text(), 'TestConcept1')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 device detail icon")
    private static PageElement testConcept1NoThingDetails;

    public static PageElement getTestConcept1NoThingDetails() {
        return testConcept1NoThingDetails;
    }

    public static PageElement getRefreshBTN() {
        return refreshBTN;
    }

    public static PageElement getFirstRowDeviceDetailsIcon() {
        return firstRowDeviceDetailsIcon;
    }

    @Element(xpath = "//em[contains(text(), 'Test_Concept-01_thing4')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept01 thing4 device detail icon")
    private static PageElement testConcept01thing4Details;

    @Element(xpath = "//em[contains(text(), 'Test_Concept-04_thing4')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "test concept04 thing4 device detail icon")
    private static PageElement testConcept04thing4Details;

    @Element(xpath = "//strong[contains(text(), 'EP44_VEIG_PKI_')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']", desc = "ep44 device detail icon")
    private static PageElement realDeviceEP44Details;

    @Element(xpath = "//i[@dmcicon='download']/ancestor::button", desc = "export icon")
    private static PageElement downloadExportIcon;

    @Element(xpath = "(//h6[contains(., ' Devices Export ')])//following-sibling::div//button[contains(., 'Confirm')]", desc = "Confirm Export button")
    private static PageElement confirmExportButton;

    public static String getDeviceDetailIcon() {
        return deviceDetailIcon;
    }

    public static void setDeviceDetailIcon(String device) {
        String deviceDetailIcon = "//span[contains(text(), '%s')]/ancestor::td//following-sibling::td//dmc-table-action[@icon='document']";
        DevicesPage.deviceDetailIcon = String.format(deviceDetailIcon, device);
    }

    private static String deviceDetailIcon = "";


    @Element(xpath = "(//tr[contains(., ' testConcept5 ')])", desc = "check test concept5 presence")
    private static PageElement testConcept5;

    @Element(xpath = "(//tr[contains(., ' DirectThingConcept91 ')])", desc = "check test concept5 presence")
    private static PageElement directThingConcept91;

    @Element(xpath = "//button[@class='dmc-fab --floating --fixed ng-star-inserted']", desc = "new device btn")
    private static PageElement newDevice;

    @Element(xpath = "(//div[contains(., ' direct ')])//div[@class='-option --last ng-star-inserted']", desc = "select direct interaction mode")
    private static PageElement interactionMode;

    @Element(xpath = "(//td[contains(., 111)])//following-sibling::td//i[@class='dmc-icon__ticket-rotated dmc-icon']", desc = "select ticket management of device 111")
    private static PageElement ticketManagement111;

    @Element(xpath = "(//h2[contains(., ' Tickets Management ')]", desc = "Tickets Management landing page")
    private static PageElement ticketsManagementLandingPage;

    @Element(xpath = "//td[contains(., 'TestConcept5')]/following-sibling::td//div/i[contains(@class, 'dmc-icon__document')]", desc = "testConcept5 device detail icon")
    private static PageElement testConcept5Details;

    @Element(xpath = "//td[contains(., 'DirectThingConcept91')]/following-sibling::td//div/i[contains(@class, 'dmc-icon__document')]", desc = "testConcept5 device detail icon")
    private static PageElement directThingConcept91Details;

    public static PageElement getToastMessageClose() {
        return toastMessageClose;
    }

    @Element(xpath = "//button[@class='-dismiss']", desc = "pop up confirmation button")
    private static PageElement toastMessageClose;

    @Element(xpath = "//strong[contains(.,'Test_Concept-03')]/parent::td/following-sibling::td/dmc-badge[contains(.,' disconnected ')]", desc = "status of test_concept_03 is disconnected ")
    private static PageElement testConcept03StatusDisconnected ;
    @Element(xpath = "//strong[contains(.,'Test_Concept-01')]/parent::td/following-sibling::td/dmc-badge[contains(.,' disconnected ')]", desc = "status of test_concept_03 is disconnected ")
    private static PageElement testConcept01StatusDisconnected ;

    @Element(xpath = "//strong[contains(.,'Test_Concept-03')]/parent::td/following-sibling::td/dmc-badge[contains(.,' connected ')]", desc = "status of test_concept_03 is connected ")
    private static PageElement testConcept03StatusConnected ;

    @Element(xpath = "//strong[contains(.,'Test_Concept-01')]/parent::td/following-sibling::td/dmc-badge[contains(.,' connected ')]", desc = "status of test_concept_03 is connected ")
    private static PageElement testConcept01StatusConnected ;

    @Element(xpath = "//dmc-multi-select-option[contains(.,' gateway')]", desc = "selectable gateway option in the device type filed of the filter box ")
    private static PageElement selectGatewayDeviceType ;

    @Element(xpath = "//dmc-multi-select-option[contains(.,' connected')]", desc = "selectable connected option in the status filed of the filter box ")
    private static PageElement selectConnectedDeviceType ;

    @Element(xpath = "//div[@class='col-12 mt-3 dmc-form-footer d-flex justify-content-end']/button[contains(.,' Confirm ')]", desc = "confirm applied filters ")
    private static PageElement confirmFilters ;

    @Element(xpath = "(//mat-option/span[contains(.,5)])[1]", desc = "5 rows per page ")
    private static PageElement fiveRowsPerPage ;

    @Element(xpath = "(//mat-option/span[contains(.,10)])[1]", desc = "10 rows per page ")
    private static PageElement tenRowsPerPage ;

    @Element(xpath = "//mat-option/span[contains(.,20)]", desc = "20 rows per page")
    private static PageElement twentyRowsPerPage ;

    @Element(xpath = "//mat-option/span[contains(.,50)]", desc = "50 rows per page")
    private static PageElement fiftyRowsPerPage ;

    @Element(xpath = "//mat-option/span[contains(.,100)]", desc = "100 rows per page ")
    private static PageElement hundredRowsPerPage ;

    @Element(xpath = "//h2[contains(text(), ' Dispositivi')]", desc = "Devices lending page title it")
    private static PageElement devicesLandingPageTitleIT ;
    public static PageElement getDevicesLandingPageTitleIT() {
        return devicesLandingPageTitleIT;
    }

    @Element(xpath = "//div[@role='tab']/div[contains(.,'Nazione')]", desc = "Devices lending page country view it")
    private static PageElement devicesLandingPageCountryViewIT ;
    public static PageElement getDevicesLandingPageCountryViewIT(){
        return devicesLandingPageCountryViewIT;
    }

    @Element(xpath = "//div[@role='tab']/div[contains(.,'Lista')]", desc = "Devices lending page list view it")
    private static PageElement devicesLandingPageListViewIT ;

    public static PageElement getDevicesLandingPageListViewIT(){
        return devicesLandingPageListViewIT;
    }

    @Element(xpath = "//h2[contains(.,'Filtri')]", desc = "filter box in italian")
    private static PageElement filterBoxIT ;
    public static PageElement getFilterBoxIT(){
        return filterBoxIT;
    }

    @Element(xpath = "//dmc-form-field-label[contains(.,' Tipo dispositivo')]", desc = "device type field in Italian")
    private static PageElement deviceTypeIT ;
    public static PageElement getDeviceTypeIT(){
        return deviceTypeIT;
    }

    @Element(xpath = "//dmc-form-field-label[contains(.,' Modello')]", desc = "device model in Italian")
    private static PageElement deviceModelIT ;
    public static PageElement getDeviceModelIT(){
        return deviceModelIT;
    }

    @Element(xpath = "//dmc-form-field-label[contains(.,' Stato')]", desc = "device status field in Italian")
    private static PageElement deviceStatusIT ;
    public static PageElement getStatusModelIT(){
        return deviceStatusIT;
    }

    @Element(xpath = "//dmc-form-field-label[contains(.,' Scad. certificato')]", desc = "Certificate expiration field in Italian")
    private static PageElement certificateExpirationIT ;
    public static PageElement getCertificateExpirationIT(){
        return certificateExpirationIT;
    }

    @Element(xpath = "//dmc-form-field-label[contains(.,' Produttore')]", desc = "maker field in Italian")
    private static PageElement makerIT ;
    public static PageElement getMakerIT(){
        return makerIT;
    }

    @Element(xpath = "//button[contains(.,' Pulisci ')]", desc = "clear BTN in Italian")
    private static PageElement clearBTNIT ;
    public static PageElement getClearBTNIT(){
        return clearBTNIT;
    }

    @Element(xpath = "//div/button[contains(.,' Conferma ')]", desc = "confirm BTN in Italian")
    private static PageElement confirmBTNIT ;
    public static PageElement getConfirmBTNIT(){
        return confirmBTNIT;
    }

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Numero Seriale ')]", desc = "serial number header in Italian")
    private static PageElement serialNumberHeaderIT ;
    public static PageElement getSerialNumberHeaderIT(){return serialNumberHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Progetto ')]", desc = "project header in Italian")
    private static PageElement projectHeaderIT ;
    public static PageElement getProjectHeaderIT(){return projectHeaderIT;}


    @Element(xpath = "//div[@class='-header']/div[contains(.,'Tipo dispositivo')]", desc = "device type header in Italian")
    private static PageElement deviceTypeHeaderIT ;
    public static PageElement getDeviceTypeHeaderIT(){return deviceTypeHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Produttore ')]", desc = "maker header in Italian")
    private static PageElement makerHeaderIT ;
    public static PageElement getMakerHeaderIT(){return makerHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Scad. certificato ')]", desc = "certificateExpiration header in Italian")
    private static PageElement certificateExpirationHeaderIT ;
    public static PageElement getCertificateExpirationHeaderIT(){return certificateExpirationHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Dispositivo ')]", desc = "device header in Italian")
    private static PageElement deviceHeaderIT ;
    public static PageElement getDeviceHeaderIT(){return deviceHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Modello ')]", desc = "model header in Italian")
    private static PageElement modelHeaderIT ;
    public static PageElement getModelHeaderIT(){return modelHeaderIT;}

    @Element(xpath = "//div[@class='-header']/div[contains(.,' Stato ')]", desc = "status header in Italian")
    private static PageElement statusHeaderIT ;
    public static PageElement getStatusHeaderIT(){return statusHeaderIT;}

    public static PageElement getSelectColumnsIcon() {
        return selectColumnsIcon;
    }

    @Element(xpath = "//li/div[contains(.,' NUMERO SERIALE ')]", desc = "serial number in column actions in Italian")
    private static PageElement serialNumberColumnActionsIT ;
    public static PageElement getSerialNumberColumnActionsIT(){return serialNumberColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,' PROGETTO ')]", desc = "project in column actions in Italian")
    private static PageElement projectColumnActionsIT ;
    public static PageElement getProjectColumnActionsIT(){return projectColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,' TIPO DISPOSITIVO ')]", desc = "device type in column actions in Italian")
    private static PageElement deviceTypeColumnActionsIT ;
    public static PageElement getDeviceTypeColumnActionsIT(){return deviceTypeColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,'PRODUTTORE ')]", desc = "make in column actions in Italian")
    private static PageElement makerColumnActionsIT ;
    public static PageElement getMakerColumnActionsIT(){return makerColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,' SCAD. CERTIFICATO ')]", desc = "certificateExpiration in column actions in Italian")
    private static PageElement certificateExpirationColumnActionsIT ;
    public static PageElement getCertificateExpirationColumnActionsIT(){return certificateExpirationColumnActionsIT;}

    @Element(xpath = "(//li/div[contains(.,' DISPOSITIVO ')])[2]", desc = "device in column actions in Italian")
    private static PageElement deviceColumnActionsIT ;
    public static PageElement getDeviceColumnActionsIT(){return deviceColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,' MODELLO ')]", desc = "model in column actions in Italian")
    private static PageElement modelColumnActionsIT ;
    public static PageElement getModelColumnActionsIT(){return modelColumnActionsIT;}

    @Element(xpath = "//li/div[contains(.,' STATO ')]", desc = "status in column actions in Italian")
    private static PageElement statusColumnActionsIT ;
    public static PageElement getStatusColumnActionsIT(){return statusColumnActionsIT;}

    @Element(xpath = "//li/button[contains(.,' Reimposta larghezza colonne ')]", desc = "resize columns in column actions in Italian")
    private static PageElement resizeColumnsIT ;
    public static PageElement getResizeColumnsIT(){return resizeColumnsIT;}

    @Element(xpath = "//span[contains(.,' Chiudi ')]", desc = "close column actions in Italian")
    private static PageElement closeColumnsBTN ;
    public static PageElement getCloseColumnsBTN(){return closeColumnsBTN;}

    @Element(xpath = "//div/span[contains(.,' Righe per pagina ')]", desc = "Rows per page at the end of the page in Italian")
    private static PageElement rowsPerPageIT ;
    public static PageElement getRowsPerPageIT(){return rowsPerPageIT;}

    @Element(xpath = "//dmc-table-page-selector", desc = "page number indicator in Italian")
    private static PageElement pageCountersIT ;
    public static PageElement getPageCountersIT(){return pageCountersIT;}


    @Element(xpath = "(//td[contains(., 'DirectThingConcept3')]//following-sibling::td)[7]", desc = "model field in device row")
    private static PageElement modelFieldInDeviceRow;

    @Element(xpath = "//span[contains(., 'Exclude never connected devices or disconnected since')]", desc = "Checkbox filter never connected device")
    private static PageElement checkboxNeverConnected;

    public static PageElement getFilterBox() {
        return filterBox;
    }

    public static void setFilterBox(PageElement filterBox) {
        DevicesPage.filterBox = filterBox;
    }

    public static PageElement getCheckboxNeverConnected() {
        return checkboxNeverConnected;
    }

    public static void setCheckboxNeverConnected(PageElement checkboxNeverConnected) {
        DevicesPage.checkboxNeverConnected = checkboxNeverConnected;
    }

    public static PageElement getConfirmFilters() {
        return confirmFilters;
    }

    public static void setConfirmFilters(PageElement confirmFilters) {
        DevicesPage.confirmFilters = confirmFilters;
    }

    //Device table headers:
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'ID')]", desc = "Device ID Columm")
    private static PageElement deviceIDColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Serial number ')]", desc = "Serial Number Columm")
    private static PageElement serialNumberColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Project ')]", desc = "Project Columm")
    private static PageElement projectColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Device type ')]", desc = "Device Type Columm")
    private static PageElement deviceTypeColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Maker ')]", desc = "Maker Columm")
    private static PageElement makerColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Certificate ')]", desc = "Certificate Columm")
    private static PageElement certificateColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and text()= ' Device ']", desc = "Device Columm")
    private static PageElement deviceColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Model ')]", desc = "Model Columm")
    private static PageElement modelColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Software Version ')]", desc = "Software Version Columm")
    private static PageElement softwareVersionColumn;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Status ')]", desc = "Model Columm")
    private static PageElement statusColumn;
    @Element(xpath = "//div[@class='mat-tooltip-trigger -handle mt-1']", desc = "Manage Column")
    private static PageElement manageColumn;
    @Element(xpath = "//button[contains(.,'Close')]", desc = "Close Manage Column")
    private static PageElement ManageColumnCLose;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., ' Software Version ')]/i", desc = "Software Version Tooltip Icon")
    private static PageElement softwareVersionTooltipIcon;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Software version']", desc = "Software Version Tooltip Title")
    private static PageElement softwareVersionTooltipTitle;
    @Element(xpath = "//dmc-column-descriptor/p[text()='The current software version installed on the device']", desc = "Software Version Tooltip Text")
    private static PageElement softwareVersionTooltipText;
    @Element(xpath = "//dmc-column-descriptor/footer/button[text()=' Close ']", desc = "Software Version Tooltip Text")
    private static PageElement closeTooltipButton;

    @Element(xpath = "//input[@placeholder='Software Version']", desc = "Software Version Input")
    private static PageElement softwareVersionInput;

    @Element(xpath = "//div[@id='mat-autocomplete-11']", desc = "Software Version autocomplete field")
    private static PageElement softwareVersionAC;

    @Element(xpath = "//mat-option[contains(.,'sw_eiidg-agent@2.0-test')]", desc = " sw_eiidg-agent@2.0-test ")
    private static PageElement testSoftware;
    @Element(xpath = "//mat-option[contains(.,'sw_APP1@1.0 ')]", desc = " sw_APP1@1.0  ")
    private static PageElement testSoftware1;
    @Element(xpath = "//mat-option[contains(.,'sw_test_2913@1.0 ')]", desc = " sw_test_2913@1.0  ")
    private static PageElement testSoftware21;
    @Element(xpath = "//mat-option[contains(.,'sw_test_2913@2.0 ')]", desc = " sw_test_2913@1.0  ")
    private static PageElement testSoftware23;


    @Element(xpath = "//mat-optgroup[contains(.,'esol_ap29551_test')]", desc = "esol_ap29551_test software")
    private static PageElement esol_ap29551_testSoftware;
    @Element(xpath = "//mat-optgroup[contains(.,'esol_ap29551_qa')]", desc = "esol_ap29551_qa software")
    private static PageElement esol_ap29551_qaSoftware;


}

