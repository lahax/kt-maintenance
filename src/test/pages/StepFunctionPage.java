package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;
import test.steps.AlarmsSteps;

public class StepFunctionPage {

    //Censisco i titoli h2 di ogni sezione momentaneamente nella SideBarPage

    @Element(xpath = "//h2[contains(text(), 'Step function')]", desc = "Step function lending page title ")
    private static PageElement stepFunctionLandingPageTitle;

    @Element(xpath = "(//dmc-table-action[@icon='document'])[position()=1]", desc = "first row device detail icon")
    private static PageElement firstRowDeviceDetailsIcon;

    @Element(xpath = "//span[@class='segment-key' and contains(text(), 'step_function_id')]/parent::section//span[contains(@class, 'segment-value')]", desc = "job id")
    private static PageElement jobID;

    public static PageElement getStepFunctionLandingPageTitle() {return stepFunctionLandingPageTitle;}

    @Element(xpath = "//i[@dmcicon=\"refresh\"]", desc = "Refresh button")
    private static PageElement refreshBtn;

    @Element(xpath = "//h2[contains(text(), 'Step function')]", desc = "Step function page title ")
    private static PageElement stepFunctionPageTitle;

    @Element(xpath = "//h2[text()='Filters']", desc = "Filters element ")
    private static PageElement filtersDDM;

    @Element(xpath = "//div[@class='dmc-card-header']/h2", desc = "Filters")
    private static PageElement filters;

    public static PageElement getInputFieldStepFunction() {
        return inputFieldStepFunction;
    }

    private static String sourceToBeCheck;

    @Element(xpath = "//input[@placeholder='Search by Device/Thing (ID,SN,Alias)']", desc = "input field")
    private static PageElement inputFieldStepFunction;

    @Element(css = "#dmc-table-step-functions", desc = "table")
    private static PageElement tableStepFunction;

    @Element(xpath = "(//th)[6]", desc = "Action column")
    private static PageElement actionColumn;

    @Element(xpath = "//div[@class='panel-body']//button[contains(text(),'Confirm')]", desc = "Confirm Button")
    private static PageElement confirmButton;

    @Element(xpath = "//div[@class='-toaster']", desc = "Success alert")
    private static PageElement successAlert;

    @Element(xpath = "//div[@class='-toaster']//span[contains(text(), 'Error while deleting step function')]", desc = "Error alert")
    private static PageElement errorAlert;

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh icon")
    private static PageElement refreshIconStepFunction;

    @Element(css = "dmc-table tr.ng-star-inserted", desc = "table rows")
    private static PageElement tableRows;

    @Element(xpath = "//div[@class='dmc-card-header']//i[@dmcicon='chevron-down']", desc = "Filters expand arrow")
    private static PageElement filtersExpandArrow;

    @Element(xpath = "//button[@class='mr-2 --outline-primary --size-regular' and contains(text(),'Clear')]", desc = "Clear button")
    private static PageElement clearButton;

    @Element(xpath = "//i[@class='dmc-icon__document dmc-icon']", desc = "Details button")
    private static PageElement detailsButton;

    @Element(xpath = "//tr//td//span[contains(text(),'PROGRESS')]/ancestor::tr//td//i[@class='dmc-icon__trash dmc-icon']", desc = "Delete button")
    private static PageElement deleteButtonEnabled;

    @Element(xpath = "(//tr//td//span[contains(text(),'PROGRESS')]/ancestor::tr//td)[3]", desc = "In progress date")
    private static PageElement inProgressDate;

    @Element(xpath = "(//tr//td//span[contains(text(),'FAILED')]/ancestor::tr//td)[3]", desc = "In progress date")
    private static PageElement failedDate;

    public static PageElement getFailedDate() {
        return failedDate;
    }

    public static PageElement getTableRows() {return tableRows;}

    public static PageElement getJobID() {
        return jobID;
    }

    public static PageElement getInProgressDate() {
        return inProgressDate;
    }

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept02 step function")
    private static PageElement lastStepFunctionWithConcept02;

    @Element(xpath = "(//td[contains(., 'Test_Concept-01')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept01 step function")
    private static PageElement lastStepFunctionWithConcept01;

    @Element(xpath = "//span[contains(text(), 'status')]//parent::section//span[contains(text(), 'SUCCEEDED')]", desc = "Succeeded in details step function")
    private static PageElement succeededInDetailsStepFunction;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept1')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept1 direct step function")
    private static PageElement lastStepFunctionWithDirectConcept1;

    @Element(xpath = "(//td[contains(., 'Direct-Concept-1')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept1 direct step function")
    private static PageElement lastStepFunctionWithDTConcept1;

    @Element(xpath = "(//td[contains(., 'Direct-Concept-3')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept1 direct step function")
    private static PageElement lastStepFunctionWithDTConcept3;
    @Element(xpath = "(//td[contains(., 'Direct-Concept-4')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept1 direct step function")
    private static PageElement lastStepFunctionWithDTConcept4;

    @Element(xpath = "(//td[contains(., 'Test_Concept-03,Test_Concept-04')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept1 direct step function")
    private static PageElement lastWithTestConcept03AndTestConcept04;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept3,DirectThingConcept4')]//following-sibling::td//*[@icon='document'])[1]", desc = "last DirectThingConcept3,DirectThingConcept4 step function")
    private static PageElement lastWithDirectThingConcept3DirectThingConcept4;

    @Element(xpath = "(//td[contains(., 'Test_Concept-01')]//following-sibling::td[contains(., 'firmware-update-gateway')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept01 step function with command type: firmware-update-gateway")
    private static PageElement lastStepFunctionUpdateWithConcept01;

    @Element(xpath = "(//td[contains(., 'Gateway29')]//following-sibling::td[contains(., 'firmware-update-gateway')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last Gateway29 step function with command type: firmware-update-gateway")
    private static PageElement lastStepFunctionUpdateWithGateway29;

    @Element(xpath = "(//td[contains(., 'Gateway29-Concept1')]//following-sibling::td[contains(., 'firmware-update-gateway')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last Gateway29 step function with command type: firmware-update-gateway")
    private static PageElement lastStepFunctionUpdateWithGateway29Concept1;

    @Element(xpath = "(//td[contains(., 'GatewayConceptTest57')]//following-sibling::td//*[@icon='document'])[1]", desc = "last GatewayConceptTest57 step function")
    private static PageElement lastStepFunctionWithGatewayConcept57;

    @Element(xpath = "//span[contains(text(), 'status')]//parent::section//span[contains(text(), 'FAILED')]", desc = "Failed in details step function")
    private static PageElement failedInDetailsStepFunction;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept2')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept2 direct step function")
    private static PageElement lastStepFunctionWithDirectConcept2;

    @Element(xpath = "(//td[contains(., 'TestConcept1')]//following-sibling::td[contains(., 'deactivate-gateway')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept01 step function with command type: firmware-update-gateway")
    private static PageElement deactivateGatewayTestConcept1Details;

    @Element(xpath = "(//td[contains(., 'DirectMX3')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept3 direct step function")
    private static PageElement lastStepFunctionWithDirectMX3;

    @Element(xpath = "(//td[contains(., 'DirectCoreApril3')]//following-sibling::td//*[@icon='document'])[1]", desc = "last direct core april 3 step function")
    private static PageElement lastStepFunctionWithDirectCoreApril3;

    @Element(xpath = "(//td[contains(., 'DirectCoreApril4')]//following-sibling::td//*[@icon='document'])[1]", desc = "last direct core april 3 step function")
    private static PageElement lastStepFunctionWithDirectCoreApril4;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept3')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept3 direct step function")
    private static PageElement lastStepFunctionWithDirectConcept3;

    @Element(xpath = "(//td[contains(., 'DirectConceptDec3')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept3 direct step function")
    private static PageElement lastStepFunctionWithDirectConceptDec3;

    @Element(xpath = "(//td[contains(., 'DirectConceptDec')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept direct step function")
    private static PageElement lastStepFunctionWithDirectConceptDec;

    @Element(xpath = "(//td[contains(., 'Test_Concept-01')]//following-sibling::td[contains(., 'deactivate-thing')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept01 step function with command type: deactivate thing")
    private static PageElement lastStepFunctionDeactivateThingConcept01;

    @Element(xpath = "(//td[contains(., 'Test_Concept-04')]//following-sibling::td[contains(., 'activate-thing')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept04 step function with command type: activate thing")
    private static PageElement lastStepFunctionActivateThingConcept04;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td[contains(., 'activate-thing')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept04 step function with command type: activate thing")
    private static PageElement lastStepFunctionActivateThingConcept02;

    @Element(xpath = "(//td[contains(., 'Test_Concept-01')]//following-sibling::td[contains(., 'activate-thing')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "last concept04 step function with command type: activate thing")
    private static PageElement lastStepFunctionActivateThingConcept01;
    @Element(xpath = "(//td[contains(., 'Test_Concept-51')]//following-sibling::td[contains(., 'activate-thing')]//following-sibling::td[contains(.,' SUCCEEDED ')])[1]",
            desc = "last concept04 step function with command type: activate thing")
    private static PageElement lastStepFunctionActivateThingConcept51;

    @Element(xpath = "(//td[contains(., 'TestConcept5')]//following-sibling::td[contains(., 'activate-thing')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Details btn of test concept5 device")
    private static PageElement lastStepFunctionTestConcept5;

    public static String getInProgressFailedDate() {
        return inProgressFailedDate;
    }

    public static void setInProgressFailedDate(String device, String date, String status) {
        String[] dateToCheck = date.split(" ");
        String inProgressFailedDate = "(//tr//td[contains(., '%s')]//following-sibling::td[contains(., '%s')]//following-sibling::td[contains(., '%s')])[1]";
        StepFunctionPage.inProgressFailedDate = String.format(inProgressFailedDate, device, dateToCheck[0], status);
    }

    private static String inProgressFailedDate = "";

    @Element(xpath = "//*[@class='-message' and contains(.,'Error while deleting step function')]", desc = "Error message deleting step function")
    public static PageElement errorMessageDeletingStepFunction;

    @Element(xpath = "//div[@class='-toaster']/button[@class='-dismiss' and contains(.,'')]", desc="dismiss button toaster")
    public static PageElement dismissBTN;

    @Element(xpath = "(//td[contains(., 'testConcept5')]//following-sibling::td[contains(., 'create-dummy')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Details btn of test concept5 device")
    private static PageElement lastStepFunctionTestConcept5_created;

    @Element(xpath = "(//td[contains(., 'DirectThingConcept91')]//following-sibling::td[contains(., 'create-dummy')]//following-sibling::td//*[@icon='document'])[1]",
            desc = "Details btn of test concept5 device")
    private static PageElement lastStepFunctionDirectThingConcept91_created;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td[contains(., 'collect-logs')]//following-sibling::td//dmc-table-action[contains(@icon, 'document')])[1]", desc = "test concept 02 collectlogs details BTN ")
    private static PageElement testConcept02CollectLogsDetails;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td[contains(.,' reboot')]//following-sibling::td//div/dmc-table-action[contains(@icon,'document')])[1]", desc = "test concept 02 reboot details ")
    private static PageElement testConcept02RebootDetails;

    @Element(xpath = "//dmc-form-field-label[contains(.,' Command')]/following-sibling::dmc-multi-select", desc = "command filed in the filter box")
    private static PageElement commandFieldInTheFilterbox;

    @Element(xpath = "//dmc-multi-select-option/div[contains(.,' reboot')]", desc = "reboot option in the command field")
    private static PageElement rebootOptionInTheCommandField;

    @Element(xpath = "//td[contains(.,'Test_Concept-02')]/following-sibling::td[contains(.,'reboot')]/following::td[contains(.,' IN_PROGRESS ')]/following-sibling::td//div//i[contains(@class,'dmc-icon__trash')]", desc = "delete icon of the test_concept-02 gateway with command reboot and status: in progress")
    private static PageElement deleteIconTestConcept02CommandRebootStatusInProgress;

    @Element(xpath = "//dmc-toaster/div/span[contains(text(), 'Step function deleted successfully')]", desc = "Step function deleted successfully toast message")
    private static PageElement successfullyDeletedStepFunctionToastMessage ;

    @Element(xpath = "//form/div/button[contains(.,' Confirm ')]", desc = "confirm BTN of the filter box")
    private static PageElement confirmBTNofTheFilterBox ;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td[contains(., 'collect-history-logs')]//following-sibling::td//dmc-table-action[contains(@icon, 'document')])[1]", desc = "test concept 02 collectlogs details BTN ")
    private static PageElement testConcept02HistoryLogsDetails;

    @Element(xpath = "(//td[contains(., 'Test_Concept-04')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept04 step function")
    private static PageElement lastStepFunctionWithConcept04;

    @Element(xpath = "(//td[contains(., 'Test_Concept-17')]//following-sibling::td//*[@icon='document'])[1]", desc = "last concept17 step function")
    private static PageElement lastStepFunctionWithConcept17;

    //We avoid Step function: IN_PROGRESS and firmware update because it has different structure seen in other tests
    @Element(xpath = "((//tr[not(contains(., 'firmware-update'))])//td[((contains(., 'SUCCEEDED') or contains(., 'FAILED')))]//following::td//*[@icon='document'])[1]",
            desc = "last step function with FAILED OR SUCCEEDED and not firmware update")
    private static PageElement lastStepFunctionSucceededOrFailed;

    //We avoid Step function: IN_PROGRESS and firmware update because it has different structure seen in other tests
    @Element(xpath = "((//tr[not(contains(., 'firmware-update'))])//td[((contains(., 'SUCCEEDED')))]//following::td//*[@icon='document'])[1]",
            desc = "last step function with FAILED OR SUCCEEDED and not firmware update")
    private static PageElement lastStepFunctionSucceeded;

    @Element(xpath = "(//span[(text() = 'status')]/following-sibling::span[(text() = ': ')]/following-sibling::span)[1]",
            desc = "status attribute in step function")
    private static PageElement statusStepFunction;

    @Element(xpath = "(//span[(text() = 'command')]/following-sibling::span[(text() = ': ')]/following-sibling::span)[1]",
            desc = "command attribute in step function")
    private static PageElement commandStepFunction;

    @Element(xpath = "//span[(text() = 'device_id')]/following-sibling::span[(text() = ': ')]/following-sibling::span",
            desc = "command attribute in step function")
    private static PageElement deviceIDStepFunction;

    public static PageElement getStatusStepFunction() {
        return statusStepFunction;
    }

    public static PageElement getDeviceIDStepFunction() {
        return deviceIDStepFunction;
    }

    public static PageElement getCommandStepFunction() {
        return commandStepFunction;
    }

    //We avoid Step function: IN_PROGRESS
    @Element(xpath = "(//tr//td[(contains(., 'FAILED'))]//following::td//*[@icon='document'])[1]",
            desc = "last step function with FAILED and not In progress")
    private static PageElement lastStepFunctionFailed;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Command')]//following-sibling::dmc-multi-select//div[@class='dmc-facade-toggle']//i[@dmcicon='chevron-down']",
            desc = "Arrow command option in filters")
    private static PageElement commandOption;

    @Element(xpath = "//dmc-multi-select-dropdown//div[contains(., ' align-datamodel')]",
            desc = " align datamodel in command option")
    private static PageElement alignDatamodelCommand;

    @Element(xpath = "//button[@type='submit']", desc = " confirm filter button")
    private static PageElement confirmFilters;

   @Element(xpath = "(//tr//td[contains(., ',')]//following::td[((contains(., 'SUCCEEDED') or contains(., 'FAILED')))]//following::td//*[@icon='document'])[1]",
           desc = " Last step function containing a comma so a fleet command, avoiding in progress command")
    private static PageElement lastFleetStepFunction;

   @Element(xpath = "(//tr//td[contains(., ',')]//following::td[contains(., 'FAILED')]//following::td//*[@icon='document'])[1]",
           desc = " Last step function containing a comma so a fleet command, avoiding in progress command")
   private static PageElement lastFleetFailedStepFunction;

    @Element(xpath = "(//td[contains(., 'Test_Concept-02')]//following-sibling::td//div/dmc-table-action[contains(@icon,'document')])[1]", desc = "test concept 02 reboot details ")
    private static PageElement testConcept02Details;

    @Element(xpath = "(//td[contains(., 'Test_Concept-40')]//following-sibling::td[contains(.,' reboot')]//following-sibling::td//div/dmc-table-action[contains(@icon,'document')])[1]", desc = "test concept 02 reboot details ")
    private static PageElement testConcept40RebootDetails;

    @Element(xpath = "//td[contains(., 'Test_Concept-01')]//following-sibling::td//span[contains(text(),'PROGRESS')]/ancestor::tr//td//i[@class='dmc-icon__trash dmc-icon']", desc = "Delete button")
    private static PageElement deleteButtonProgressTestConcept01;
    public static PageElement getDeleteButtonEnabled() {
        return deleteButtonEnabled;
    }

    /*--------------Step Function Table--------------*/
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Device ID')]", desc = "Device ID Column Header")
    private static PageElement deviceIDColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Device SN')]", desc = "Device SN Column Header")
    private static PageElement deviceSNColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Activity ID')]", desc = "Activity ID Column Header")
    private static PageElement activityIDColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Thing ID')]", desc = "Thing ID Column Header")
    private static PageElement thingIDColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Thing SN')]", desc = "Thing SN Column Header")
    private static PageElement thingSNColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Thing Alias')]", desc = "Device SN Column Header")
    private static PageElement thingAliasColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Command Type')]", desc = "Device SN Column Header")
    private static PageElement commandTypeColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Creation date')]", desc = "Device SN Column Header")
    private static PageElement creationDateColumn;
    @Element(xpath = "(//th/div/div[@class='-header']/div[contains(., 'Status')])[1]", desc = "Device SN Column Header")
    private static PageElement statusColumn;
    @Element(xpath = "//th/div/div[@class='-header']/div[contains(., 'Status Date')]", desc = "Device SN Column Header")
    private static PageElement statusDateColumn;
    @Element(xpath = "//i[@class='-icon dmc-icon__table-columns dmc-icon']", desc = "Manage Coluns Icon")
    private static PageElement manageColumns;

    public static PageElement getRefreshBtn() {
        return refreshBtn;
    }

    public static void setRefreshBtn(PageElement refreshBtn) {
        StepFunctionPage.refreshBtn = refreshBtn;
    }
    @Element(xpath = "//button[contains(., 'Back')]", desc = "Back button Step function detail")
    private static PageElement backBTN;

    /*--------------Step Function Detail--------------*/
    @Element(xpath = "//span[text()='activity_id']", desc = "Activity Id")
    private static PageElement actvityID;
    @Element(xpath = "//span[text()='device_id']", desc = "Device Id")
    private static PageElement deviceID;
    @Element(xpath = "//span[text()='device_serial_number']", desc = "Device Serial Number")
    private static PageElement deviceSerialNumber;
    @Element(xpath = "//section/span[text()='thing_id']", desc = "Thing Id")
    private static PageElement thingID;
    @Element(xpath = "//span[text()='thing_serial_number']", desc = "Thing Serial Number")
    private static PageElement thingSerialNumber;
    @Element(xpath = "//span[text()='thing_alias']", desc = "Thimg alias")
    private static PageElement thingAlias;
    @Element(xpath = "//span[text()='command_input']", desc = "Command input")
    private static PageElement commandInput;
    @Element(xpath = "//span[text()='command_output']", desc = "Command output")
    private static PageElement commandOutput;


}