package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DeviceAlarmsConfigurationPage {

    /*Xpath*/

    @Element(xpath = "//h2[contains(@class, '-title') and contains(text(), 'Device Alarms Configuration')]", desc = "Device Alarms Configuration title page")
    private static PageElement deviceAlarmsConfigurationPageTitle;
    @Element(xpath = "//h2[contains(@class, '-title') and contains(text(), 'Configurazione Allarmi Dispositivi')]", desc = "Device Alarms Configuration title (IT) page")
    private static PageElement deviceAlarmsConfigurationPageTitleIT;
    @Element(xpath = "//th[contains(text(), '')]", desc = "columns name")
    private static PageElement columnsName;
    @Element(xpath = "//button/i[@dmcicon='wizard']", desc = "wizard button")
    private static PageElement wizardBTN;
    @Element(xpath = "//div[contains(@class,'info')]", desc = "Title Device Alarms Configuration WIZARD ")
    private static PageElement deviceAlarmsConfigurationWizardPageTitle;
    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button Device Alarm configuration page")
    private static PageElement backBTN;
    @Element(xpath = "//i[@dmcicon='refresh']" , desc = "refresh button")
    private static PageElement refreeshBTN;
    @Element(xpath = "//tr[1]/td[contains(@class,'--align-left')]", desc = "all cell of first row in the table")
    private static PageElement allCellOfFirstRow;
    @Element(xpath = "//i[@dmcicon='info']", desc = "all info icons close to columns name")
    private static  PageElement infoIcons;

    @Element(xpath = "//td[contains(., 'Test_15.26')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_26;

    /*Pop up info icon - ENG*/
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Alarm Target']", desc= "pop up Alarm target")
    private static PageElement popUpAlarmTarget;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Business Alarm Configuration']", desc= "pop up Business Alarm Configuration")
    private static PageElement popUpBusinessAlarmConfiguration;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Widespread Disservice Alarm Configuration']", desc= "pop up Widespread Disservice Alarm Configuration")
    private static PageElement popUpWidespreadDisserviceAlarmConfiguration;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Lower Message Rate Threshold Alarm Configuration']", desc= "pop up Lower Message Rate Threshold Alarm Configuration")
    private static PageElement popUpLowMsgRatesTHLD;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Higher Message Rate Threshold Alarm Configuration']", desc= "pop up Higher Message Rate Threshold Alarm Configuration")
    private static PageElement popUpHighMsgRatesTHLD ;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Telemetry Alarm Configuration']", desc= "pop up Telemetry Alarm Configuration")
    private static PageElement popUpTelemetryAlarmConfiguration;

    /*Pop up info icon - IT*/
    @Element(xpath = "//dmc-column-descriptor/h4", desc= "pop up title - infoDialog")
    private static PageElement popUpTitleInfoDialog;

    @Element(xpath = "//dmc-column-descriptor/h4[text()='Configurazione Allarme Business']", desc= "pop up Configurazione Allarme Business")
    private static PageElement popUpBusinessAlarmConfigurationIT;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Configurazione Allarme di Disservizio diffuso']", desc= "pop up Configurazione Allarme di Disservizio diffuso")
    private static PageElement popUpWidespreadDisserviceAlarmConfigurationIT;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Configurazione Allarme di Soglia Messaggi Minima']", desc= "pop up Configurazione Allarme di Soglia Messaggi Minima")
    private static PageElement popUpLowMsgRatesTHLDIT;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Configurazione Allarme di Soglia Messaggi Massima']", desc= "pop up Configurazione Allarme di Soglia Messaggi Massima")
    private static PageElement popUpHighMsgRatesTHLDIT ;
    @Element(xpath = "//dmc-column-descriptor/h4[text()='Configurazione Allarme di Telemetria']", desc= "pop up Configurazione Allarme di Telemetria")
    private static PageElement popUpTelemetryAlarmConfigurationIT;

    public static PageElement getTitleOfPopoUp() {
        return titleOfPopoUp;
    }

    @Element(xpath = "//dmc-column-descriptor/h4", desc= "title of pop up")
    private static PageElement titleOfPopoUp;

    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__pencil')]", desc= "icon pencil first row")
    private static PageElement iconPencilFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__document')]", desc= "icon document first row")
    private static PageElement iconDocumentFirstRow;
    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Device Configuration Detail')]", desc = "Title Device configuration details page")
    private static PageElement titleDeviceConfigurationDetailPage;
    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Update Configuration - Alarm')]", desc = "Title Device Configuration update (Edit process) Page")
    private static PageElement titleDeviceConfigurationEditPage;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__trash')]", desc= "icon trash first row")
    private static PageElement iconTrashFirstRow;
    @Element(xpath = "//button[contains(text(), 'Close')]" , desc = "close button pop up")
    private static PageElement closeBtnPopUp;
    @Element(xpath = "//button[contains(text(), 'Chiudi')]" , desc = "chiudi button pop up")
    private static PageElement closeBtnPopUpIT;
    @Element(xpath = "//h6[contains(text(), ' Delete selected element ')]", desc = "pop up delete item from table")
    private static PageElement titlePopUpdeleteItem;
    @Element(xpath = "//button[text()=' Delete ']", desc = "delete button into delete pop up")
    private static PageElement deleteButton;
    @Element(xpath = "//button[text()=' Cancel ']", desc = "cancel button into delete pop up")
    private static PageElement cancelButton;
    @Element(xpath = "//div[contains(text(), 'ORIGINE ALLARME')]", desc = "column alarm target IT")
    private static PageElement origineAllarmeCol;
    @Element(xpath = "//div[contains(text(), ' BUSINESS')]", desc = "column BUSINESS IT")
    private static PageElement businessCol;
    @Element(xpath = "//div[contains(text(), 'DISSERVIZIO DIFFUSO')]", desc = "column DISSERVIZIO DIFFUSO IT")
    private static PageElement disservizioDiffusoCol;
    @Element(xpath = "//div[contains(text(), 'SOGLIA MINIMA')]", desc = "column SOGLIA MINIMA IT")
    private static PageElement sogliaminimaCol;
    @Element(xpath = "//div[contains(text(), 'SOGLIA MASSIMA')]", desc = "column SOGLIA MASSIMA IT")
    private static PageElement sogliaMassimaCol;
    @Element(xpath = "//div[contains(text(), 'REGOLE TELEMETRICHE')]", desc = "column REGOLE TELEMETRICHE IT")
    private static PageElement regoleTelemetricheCol;
    @Element(xpath = "//button[contains(text(), 'Update')]" , desc = "update button")
    private static PageElement updateBTN;

    /*Getters*/

    public static PageElement getDeviceAlarmsConfigurationPageTitle() { return deviceAlarmsConfigurationPageTitle;  }
    public static PageElement getDeviceAlarmsConfigurationPageTitleIT() { return deviceAlarmsConfigurationPageTitleIT;  }
    public static PageElement getColumnsName() { return columnsName; }
    public static PageElement getBackBTN() { return backBTN; }
    public static PageElement getRefreeshBTN() { return refreeshBTN; }
    public static PageElement getAllCellOfFirstRow() { return allCellOfFirstRow; }
    public static PageElement getInfoIcons() { return infoIcons; }
    public static PageElement getTitleDeviceConfigurationDetailPage() { return titleDeviceConfigurationDetailPage; }
    public static PageElement getWizardBTN() { return wizardBTN;  }
    public static PageElement getTitleDeviceConfigurationEditPage() { return titleDeviceConfigurationEditPage; }
    public static PageElement getIconPencilFirstRow() { return iconPencilFirstRow; }
    public static PageElement getIconDocumentFirstRow() { return iconDocumentFirstRow; }
    public static PageElement getIconTrashFirstRow() { return iconTrashFirstRow; }

    /*Pop Up info icon - ENG*/
    public static PageElement getPopUpAlarmTarget() { return popUpAlarmTarget; }
    public static PageElement getPopUpBusinessAlarmConfiguration() { return popUpBusinessAlarmConfiguration;  }
    public static PageElement getPopUpWidespreadDisserviceAlarmConfiguration() { return popUpWidespreadDisserviceAlarmConfiguration; }
    public static PageElement getPopUpLowMsgRatesTHLD() { return popUpLowMsgRatesTHLD; }
    public static PageElement getPopUpHighMsgRatesTHLD() { return popUpHighMsgRatesTHLD; }
    public static PageElement getPopUpTelemetryAlarmConfiguration() { return popUpTelemetryAlarmConfiguration; }
    public static PageElement getCloseBtnPopUp() { return closeBtnPopUp; }

    /*Pop up info icon- IT*/
    public static PageElement getPopUpTitleInfoDialog() { return popUpTitleInfoDialog; }
    public static PageElement getPopUpBusinessAlarmConfigurationIT() { return popUpBusinessAlarmConfigurationIT;  }
    public static PageElement getPopUpWidespreadDisserviceAlarmConfigurationIT() { return popUpWidespreadDisserviceAlarmConfigurationIT; }
    public static PageElement getPopUpLowMsgRatesTHLDIT() { return popUpLowMsgRatesTHLDIT; }
    public static PageElement getPopUpHighMsgRatesTHLDIT() { return popUpHighMsgRatesTHLDIT; }
    public static PageElement getPopUpTelemetryAlarmConfigurationIT() { return popUpTelemetryAlarmConfigurationIT; }
    public static PageElement getCloseBtnPopUpIT() { return closeBtnPopUpIT; }

    public static PageElement getTitlePopUpdeleteItem() { return titlePopUpdeleteItem; }
    public static PageElement getDeviceAlarmsConfigurationWizardPageTitle() { return deviceAlarmsConfigurationWizardPageTitle; }
    public static PageElement getDeleteButton() { return deleteButton; }
    public static PageElement getCancelButton() { return cancelButton; }
    public static PageElement getOrigineAllarmeCol() { return origineAllarmeCol; }
    public static PageElement getBusinessCol() { return businessCol; }
    public static PageElement getDisservizioDiffusoCol() { return disservizioDiffusoCol; }
    public static PageElement getSogliaminimaCol() { return sogliaminimaCol; }
    public static PageElement getSogliaMassimaCol() { return sogliaMassimaCol; }
    public static PageElement getRegoleTelemetricheCol() { return regoleTelemetricheCol; }


    //*Wizard elements*//
    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'Devices')]", desc = "Devices radio button in wizard")
    private static PageElement monitorDevicesRadioBTN;
    @Element(xpath = "//button[contains(text(), 'Next')]", desc = "next button in wizard when is the only one")
    private static PageElement wizardNextBTN;
    @Element(xpath = "//div[@class='container-fluid p-0 d-flex justify-content-between']//button[contains(text(), 'Next')]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextStepsTab;
    @Element(xpath = "(//div[@class='container-fluid p-0 d-flex justify-content-between']//button[contains(text(), 'Next')])[2]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextStepsTab2;
    @Element(xpath = "(//div[@class='container-fluid p-0 d-flex justify-content-between']//button[contains(text(), 'Next')])[3]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextStepsTab3;
    @Element(xpath = "(//div[@class='container-fluid p-0 d-flex justify-content-between']//button[contains(text(), 'Next')])[4]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextStepsTab4;
    @Element(xpath = "(//div[@class='container-fluid p-0 d-flex justify-content-between']//button[contains(text(), 'Next')])[5]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextStepsTab5;
    @Element(xpath = "//button[@class='--primary --size-regular --width-large ng-star-inserted']", desc = "next button in wizard steps tab")
    private static PageElement buttonNextNotification;
    @Element(xpath = "//button[@class='--primary --size-regular --width-large']", desc = "next button in wizard steps tab")
    private static PageElement buttonNextNotification2;
    @Element(xpath = "//button[@class='mat-stepper-next --primary --size-regular --width-large']", desc = "next button in wizard steps tab")
    private static PageElement buttonNextNotification3;
    @Element(xpath = "(//button[@class='--primary --size-regular --width-large ng-star-inserted'])[1]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextMicro1;
    @Element(xpath = "(//button[@class='--primary --size-regular --width-large ng-star-inserted'])[2]", desc = "next button in wizard steps tab")
    private static PageElement buttonNextMicro2;
    @Element(xpath = "//div[@role='tabpanel' and @style='transform: none; visibility: visible;']//button[contains(text(), 'Next')]", desc = "visible next button")
    private static PageElement visibleNextBTN;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'new alarm')]", desc = "New alarm radio button in wizard")
    private static PageElement configureNewAlarmRadioBTN;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), ' Add notification for existing alarm ')]",
            desc = "Add notification for existing alarm radio button in wizard")
    private static PageElement addNotificationForExistingAlarmRadioBTN;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'Telemetry')]", desc = "Telemetry of Threshold radio button in wizard")
    private static PageElement telemetryOfThresholdAlarmRadioBTN;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'Business')]", desc = "Business radio button in wizard")
    private static PageElement businessAlarmRadioBTN;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), ' Widespread Disservice ')]", desc = " Widespread Disservice radio button in wizard")
    private static PageElement widespreadDisserviceAlarmRadioBTN;

    @Element(xpath = "//strong[contains(text(), 'all')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash alarm all")
    private static PageElement iconTrashAlarmAll;

    //Select Option eliminato: usiamo il il drop down arrow per aprire il menu
    @Element(xpath = "//div[contains(text(), 'GROUP') and @class='-option-label']", desc = "GROUP device option label in wizard Alarm Target")
    private static PageElement groupDeviceOptionToSelect;

    @Element(xpath = "//div[contains(text(), 'ALL') and @class='-option-label']", desc = "ALL device option label in wizard Alarm Target ")
    private static PageElement allDeviceOptionToSelect;
    @Element(xpath = "(//div[@class = '-option-label'])[2]", desc = "Device group associated with this alarm ")
    private static PageElement existingDeviceGroup;
    @Element(xpath = "//mat-option[1]", desc = "first device group selection in wizard")
    private static PageElement firstDeviceGroupOption;
    @Element(xpath = "//div[@class='row ng-star-inserted']//span[contains(text(), 'ADD THRESHOLD')]", desc = "ADD THRESHOLD button in wizard")
    private static PageElement addThresholdBTN;
    @Element(xpath = "//div[contains(text(), 'Time Window')]", desc = "time window selection button in wizard")
    private static PageElement timeWindowSelectionBTN;
    @Element(xpath = "//input[@placeholder='Number of Messages']", desc = "n. of messages to write in wizard")
    private static PageElement numberOfMessagesToWrite;
    @Element(xpath = "//div[@role='tabpanel' and @style='transform: none; visibility: visible;']//div[contains(text(), 'Time Window')]", desc = "time window selection button in wizard")
    private static PageElement visibleTimeWindowSelection;
    //@Element(xpath = "//div[@role='tabpanel' and @style='transform: none; visibility: visible;']//input[@placeholder='Number of Messages']", desc = "n. of messages to write in wizard")
    //private static PageElement visibleNumberOfMessage;
    @Element(xpath = "//input[@class='--width-1x --appearance-outlined ng-dirty ng-touched ng-invalid']", desc = "n. of messages to write in wizard")
    private static PageElement visibleNumberOfMessage;
    @Element(xpath = "(//input[@placeholder='Number of Messages'])[2]", desc = "n. of messages to write in wizard")
    private static PageElement numberOfMessagesToWrite2;
    @Element(xpath = "//div[contains(text(), '300 s')]", desc = "300 s time window in wizard")
    private static PageElement threeHundredsecondsTimeSelectionLowThreshold;
    @Element(xpath = "(//div[contains(text(), '300 s')])[position()=3]", desc = "300 s time window in wizard")
    private static PageElement threeHundredsecondsTimeSelectionHighThreshold;
    @Element(xpath = "//button[contains(text(), 'ADD RULE')]", desc = "ADD RULE button in wizard")
    private static PageElement addRuleBTN;
    @Element(xpath = "//h3[contains(text(), 'Alarm configuration summary')]", desc = "Alarm configuration summary title in wizard")
    private static PageElement alarmConfigurationSummaryTitle;
    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'Yes')]", desc = "Yes radio button in wizard")
    private static PageElement wizardYesRadioBTN;
    @Element(xpath = "//dmc-dummy-input", desc = "continuous option predefined")
    private static PageElement predefinedContinuousOption;
    @Element(xpath = "//strong[contains(text(), 'Notification configuration summary')]", desc = "Notification configuration summary title in wizard")
    private static PageElement notificationConfigurationSummaryTitle;
    @Element(xpath = "//button[contains(text(), 'Save')]", desc = "save button in wizard")
    private static PageElement wizardSaveBTN;
    @Element(xpath = "//button[contains(text(), 'Add')]", desc = "add button in wizard for channels")
    private static PageElement wizardAddChannelsBTN;
    @Element(xpath = "//div[contains(text(), 'Select option...')]//parent::dmc-dummy-input//following-sibling::div//div[contains(text(), 'EMAIL')]", desc = "EMAIL option channel in wizard")
    private static PageElement channelEmailOptionToSelect;
    @Element(xpath = "//div[contains(text(), 'Select option...')]//parent::dmc-dummy-input//following-sibling::div//div[contains(text(), 'SMS')]", desc = "SMS option channel in wizard")
    private static PageElement channelSmsOptionToSelect;
    @Element(xpath = "(//div[contains(text(), 'SMS') and @class='-option-label'])[last()]", desc = "SMS option channel in wizard")
    private static PageElement channelSmsOptionToSelectLast;
    @Element(xpath = "//div[contains(text(), 'Select option...')]//parent::dmc-dummy-input//following-sibling::div//div[contains(text(), 'TOPIC')]", desc = "TOPIC option channel in wizard")
    private static PageElement channelTopicOptionToSelect;
    @Element(xpath = "//div[contains(text(), 'Select option...')]//parent::dmc-dummy-input//following-sibling::div//div[contains(text(), 'RDE')]", desc = "RDE ALARM option channel in wizard")
    private static PageElement channelRdeAlarmOptionToSelect;
    @Element(xpath = "//input[@role='combobox']", desc = "selection box in wizard devices group")
    private static PageElement selectionBoxDevicesGroup;
    @Element(xpath = "//i[@dmcicon='trash']", desc = "reset option button")
    private static PageElement resetOptionsBTN;
    @Element(xpath = "//div[@role='tabpanel' and @style='transform: none; visibility: visible;']//i[@dmcicon='trash']", desc = "visible reset option button")
    private static PageElement visibleResetOptionsBTN;
    @Element(xpath = "//input[@placeholder='<user>@<domain>.com']", desc = "email to insert box")
    private static PageElement emailToInsertBox;
    @Element(xpath = "//input[@placeholder='+393333333333']", desc = "phone number to insert box")
    private static PageElement phoneNumberToInsertBox;
    @Element(xpath = "//label[contains(text(), 'Topic')]/following-sibling::dmc-input-container//input[@id='endpointLabel']", desc = "Topic to insert box")
    private static PageElement topicToInsertBox;
    @Element(xpath = "(//strong[contains(text(), 'Wizard Completed')])[position()=2]", desc = "Wizard completed")
    private static PageElement wizardCompleted;
    @Element(xpath = "(//button[@class='--primary --size-regular --width-large'])[2]", desc = "final exit button")
    private static PageElement finalExitButton;
    @Element(xpath = "(//button[@class='--primary --size-regular --width-large'])[3]", desc = "final exit button")
    private static PageElement finalExitButton2;
    @Element(xpath = "//div[@class='-select']//i[@dmcicon='chevron-down']", desc = "Drop down arrow which is visible in thi TAB ")
    private static PageElement dropDownArrowTAB;
    @Element(xpath = "(//div[@class='-select']//i[@dmcicon='chevron-down'])[2]", desc = "Drop down arrow which is visible in thi TAB")
    private static PageElement dropDownArrowTAB2;
    @Element(xpath = "(//div[@class='-select']//i[@dmcicon='chevron-down'])[3]", desc = "Drop down arrow which is visible in thi TAB")
    private static PageElement dropDownArrowTAB3;
    @Element(xpath = "//dmc-dummy-input[@class='-facade --size-1x']//i[@dmcicon='chevron-down']", desc = "Drop down for time window ")
    private static PageElement timeWindowDropDown;
    @Element(xpath = "(//dmc-dummy-input[@class='-facade --size-1x']//i[@dmcicon='chevron-down'])[2]", desc = "Drop down for time window ")
    private static PageElement timeWindowDropDown2;
    @Element(xpath = "(//i[@class='-facade-icon dmc-icon__chevron-down dmc-icon-size-normal dmc-icon'])[2]", desc = "Drop down unit for time window ")
    private static PageElement timeWindowUnitDropDown;

    //useful to notification page where there can be multiple dropdowns but after selection of channel the text Select option is not in thi element anymore
    //@Element(xpath = "//div[@role='tabpanel' and contains(@style, 'visible')]//parent::h6/following-sibling::dmc-select/div/dmc-dummy-input/div[contains(text(), ' Select option... ')]", desc = "Drop down arrow with text select option")
    //private static PageElement dropDownArrowSelectOptionChannel;
    @Element(xpath = "//div[@class='-input' and contains(text(), 'Select option...') ]/following-sibling::i[@class='-facade-icon dmc-icon__chevron-down dmc-icon-size-normal dmc-icon']", desc = "Drop down arrow with text select option")
    private static PageElement dropDownArrowSelectOptionChannel;

    @Element(xpath = "(//dmc-dummy-input/i[@dmcicon='chevron-down'])[position()=4]", desc = "Drop Down Arrow --> position4 , can be used in many pages ")
    private static PageElement dropDownArrowOperator;
    @Element(xpath = "//div[contains(text(), 'CONTINUOUS') and @class='-option-label']", desc = "Notification Window continuous option")
    private static PageElement continuousOption;
    @Element(xpath = "//div[contains(text(), 'SCHEDULED') and contains(@class,'option')]", desc = "Notification Window scheduled option")
    private static PageElement scheduledOption;
    @Element(xpath = "(//div[@class='-option-label' and contains(text(), 'ALL THINGS')])[last()]", desc = "Telemetry Rules target All things option")
    private static PageElement allThingsOptionTelemetryRule;
    @Element(xpath = "//div[@class = '-icon']", desc = "Notification AGGREGATION enabled icon radio btn")
    private static PageElement radioBtnEnableNotificationAggregation;
    @Element(xpath = "//input[@type = 'number']", desc = "Time interval notification aggregation label input")
    private static PageElement timeIntervalLabelInput;
    @Element(xpath = "//button[contains(text(), 'Exit')]", desc = "Button containing text Exit reusable")
    private static PageElement exitBTN;
    @Element(xpath = "//span[contains(text(), 'Add Rule')]", desc = "Add rule on telemetry section")
    private static PageElement addRuleTelemetryBTN;
    @Element(xpath = "(//input[contains(@placeholder, 'Trend ID')])[last()]", desc = "Trend ID telemetry rule section option")
    private static PageElement trendIdTelemetryLabel;
    @Element(xpath = "(//input[contains(@placeholder, 'Value')])[last()]", desc = "Value telemetry section")
    private static PageElement valueTelemetryLabel;
    @Element(xpath = "//div[@class='-input' and contains(text(), 'Target')]", desc = "Value telemetry section")
    private static PageElement targetTelemetryDropDown;
    @Element(xpath = "//div[@class='-input' and contains(text(), 'Type')]", desc = "Value telemetry section")
    private static PageElement typeTelemetryDropDown;
    @Element(xpath = "//div[@class='-input' and contains(text(), 'Operator')]", desc = "Value telemetry section")
    private static PageElement operatorTelemetryDropDown;
    @Element(xpath = "(//div[@class='-option-label' and contains(text(), 'number')])[last()]", desc = "number type option in telemetry section")
    private static PageElement numberTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and contains(text(), 'string')])[last()]", desc = "string type option in telemetry section")
    private static PageElement stringTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' = '])[last()]", desc = " EQUAL Operator in telemetry rules")
    private static PageElement equalOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' != '])[last()]", desc = " NOT EQUAL  Operator in telemetry rules")
    private static PageElement notEqualOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' < '])[last()]", desc = " MINOR  Operator in telemetry rules")
    private static PageElement minorOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' > '])[last()]", desc = " MAJOR Operator in telemetry rules")
    private static PageElement majorOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() = ' >= '])[last()]", desc = " MAJOR EQUAL  Operator in telemetry rules")
    private static PageElement majorEqualOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' <= '])[last()]", desc = " MINOR EQUAL  Operator in telemetry rules")
    private static PageElement minorEqualOperatorTelemetryOption;
    @Element(xpath = "(//div[@class='-option-label' and text() =' <> '])[last()]", desc = " EXCLUSION Operator in telemetry rules")
    private static PageElement exclusionOperatorTelemetryOption;
    @Element(xpath = "//div[contains(text(), ' 10 mins ') and @class='-option-label']", desc = " 10 mins Max Frequency on Notification Time Window")
    private static PageElement tenMinutesMaxFrequency;
    @Element(xpath = "(//div[@class='-option-label' and text() =' regex '])[last()]", desc = " regex Operator in telemetry rules")
    private static PageElement regexOperatorTelemetryOption;

    @Element(xpath = "(//label[contains(text(), 'From ')])/following-sibling::dmc-select//i", desc = " DropDown chose days From")
    private static PageElement dropDownFromDays;
    @Element(xpath = "(//label[contains(text(), 'To')])/following-sibling::dmc-select//i", desc = " MONDAY selection on FROM---Notification  Window")
    private static PageElement dropDownToDays;
    @Element(xpath = "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' MON ')]", desc = " MONDAY selection on FROM---Notification  Window")
    private static PageElement mondayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' MON ')]", desc = " MONDAY selection on TO---Notification  Window")
    private static PageElement mondayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' TUE ')]", desc = " TUESDAY selection on FROM---Notification  Window")
    private static PageElement tuesdayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' TUE ')]", desc = " TUESDAY selection on TO---Notification  Window")
    private static PageElement tuesdayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' WED ')]" , desc = " WEDNESDAY selection on FROM---Notification  Window")
    private static PageElement wednesdayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' WED ')]", desc = " WEDNESDAY selection on TO---Notification  Window")
    private static PageElement wednesdayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' THU ')]", desc = " THURSDAY selection on FROM---Notification  Window")
    private static PageElement thursdayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' THU ')]", desc = " THURSDAY selection on TO---Notification  Window")
    private static PageElement thursdayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' FRI ')]", desc = " FRIDAY selection on FROM---Notification  Window")
    private static PageElement fridayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' FRI ')]", desc = " FRIDAY selection on TO---Notification  Window")
    private static PageElement fridayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' SAT ')]", desc = " SATURDAY selection on FROM---Notification  Window")
    private static PageElement saturdayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' SAT ')]", desc = " SATURDAY selection on TO---Notification  Window")
    private static PageElement saturdayToNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'From ')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' SUN ')]", desc = " SUNDAY selection on FROM---Notification  Window")
    private static PageElement sundayFromNotificationWindow;
    @Element(xpath =  "(//label[contains(text(), 'To')])/following-sibling::dmc-select/div/div[@class = '-dropdown']/div[contains(.,' SUN ')]", desc = " SUNDAY selection on TO---Notification  Window")
    private static PageElement sundayToNotificationWindow;
    @Element(xpath = "(//input[@type = 'time'])[1]", desc = " Hour selection on FROM---Notification  Window")
    private static PageElement fromHourNotificationWindow;
    @Element(xpath = "(//input[@type = 'time'])[2]", desc = " Hour selection on TO---Notification  Window")
    private static PageElement toHourNotificationWindow;

    @Element(xpath = "//tbody//tr", desc= "all Alarms present into the table of Device Configuration Page")
    private static PageElement allAlarms;

    @Element(xpath = "//dmc-radio-group-option[contains(text(), 'Cloud Component')]", desc = "Cloud Component radio button in wizard")
    private static PageElement monitorCloudComponentRadioBTN;
    @Element(xpath = "//h6/strong[contains(text(), 'MICROSERVICE selection')]/parent::h6/following-sibling::dmc-select/div/dmc-dummy-input/div[@class = '-input']", desc = "Cloud Component radio button in wizard")
    private static PageElement microserviceDropDownBTN;
    @Element(xpath = "//div[(text() = ' commandto ')]", desc = "commandto Microservice selection option ")
    private static PageElement commandtoOption;

    @Element(xpath = "//button[@class='-dismiss']", desc = "Remove confirmation Delete button")
    private static PageElement toastMessageClose;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-01')]", desc = "first device group selection in wizard")
    private static PageElement testConcept01Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-02')]", desc = "second device group selection in wizard")
    private static PageElement testConcept02Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-03')]", desc = "third device group selection in wizard")
    private static PageElement testConcept03Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-04')]", desc = "4rth device group selection in wizard")
    private static PageElement testConcept04Device;
    @Element(xpath = "//span[contains(text(), 'Test_15.26')]", desc = "group test 15.26 selection in wizard")
    private static PageElement groupTest15_26;
    @Element(xpath = "//span[contains(text(), 'Test_15.30')]", desc = "group test 15.30 selection in wizard")
    private static PageElement groupTest15_30;
    @Element(xpath = "//span[contains(text(), 'TestConcept1532')]", desc = "group test 15.30 selection in wizard")
    private static PageElement groupTestConcept1532;
    @Element(xpath = "//span[contains(text(), '1532')]", desc = "group test 15.30 selection in wizard")
    private static PageElement groupTest1532;

    @Element(xpath = "//div[contains(text(), 'Test_Concept-04') and @class='-option-label']", desc = "option label in wizard Alarm Target")
    private static PageElement testConcept04ToSelect;
    @Element(xpath = "//div[contains(text(), 'Test_Concept-03') and @class='-option-label']", desc = "option label in wizard Alarm Target")
    private static PageElement testConcept03ToSelect;
    @Element(xpath = "//div[contains(text(), 'Test_Concept-02') and @class='-option-label']", desc = "option label in wizard Alarm Target")
    private static PageElement testConcept02ToSelect;
    @Element(xpath = "//div[contains(text(), 'Test_Concept-01') and @class='-option-label']", desc = "option label in wizard Alarm Target")
    private static PageElement testConcept01ToSelect;
    @Element(xpath = "//div[contains(text(), 'GW') and @class='-option-label']", desc = "option label in wizard Alarm Target")
    private static PageElement testGWToSelect;

    @Element(xpath = "//div[contains(text(), 'CUSTOM') and @class='-option-label']", desc = "CUSTOM GROUP device option label in wizard Alarm Target")
    private static PageElement customGroupDeviceOptionToSelect;
    @Element(xpath = "//a[@class='dmc-link-to-view']", desc = "link to custom group")
    private static PageElement linkToCustomGroup;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-01')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash alarm test concept 1")
    private static PageElement iconTrashAlarmTestConcept1;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-02')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash alarm test concept 2")
    private static PageElement iconTrashAlarmTestConcept2;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-04')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash alarm test concept 4")
    private static PageElement iconTrashAlarmTestConcept4;

    @Element(xpath = "(//i[contains(@class, 'dmc-icon__trash')])[last()]", desc = "delete last group")
    private static PageElement deleteLastAlarm;

    @Element(xpath = "//strong[contains(text(), 'Test_15.26')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash ")
    private static PageElement iconTrashAlarmCustomGroup15_26;

    @Element(xpath = "//strong[contains(text(), '1532')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash ")
    private static PageElement iconTrashAlarmCustomGroup1532;

    @Element(xpath = "//strong[contains(text(), 'all')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash")
    private static PageElement iconTrashAlarmScopeAll;

    @Element(xpath = "//strong[contains(text(), 'all')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__pencil')]", desc = "icon trash")
    private static PageElement editAlarmScopeAll;

    @Element(xpath = "//strong[contains(text(), 'Test_15.30')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash ")
    private static PageElement iconTrashAlarmCustomGroup15_30;

    @Element(xpath = "//strong[contains(text(), 'all')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__document')]", desc = "icon trash")
    private static PageElement detailsAlarmScopeAll;

    @Element(xpath = "//div[contains(text(), 'Test_Concept-01')]", desc = "min unit in wizard")
    private static PageElement testConcept01DeviceNotificationTarget;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-04')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__document')]", desc = "icon detail concept04 alarm")
    private static PageElement detailsAlarmConcept04;



    //Business alarms//
    @Element(xpath = "//input[@placeholder='Time Window']", desc = "n. of messages to write in wizard")
    private static PageElement timeWindow;
    @Element(xpath = "//div[contains(text(), 'min')]", desc = "min unit in wizard")
    private static PageElement minUnitSelection;

    //Widespread disservice alarms//
    @Element(xpath = "(//dmc-form-field-label[contains(text(), 'Number of Alarms')])/following-sibling::input", desc = "n. of alarms to write in wizard")
    private static PageElement numberOfAlarmsLabelInput;
 @Element(xpath = "(//dmc-form-field-label[contains(text(), 'Short Time Window')])/following-sibling::input", desc = "Short time window on disconnection time window")
    private static PageElement shortTimeWindowInput;
 @Element(xpath = "(//dmc-form-field-label[contains(text(), 'Long Time Window')])/following-sibling::input", desc = "Long Time Window on disconnection time window")
    private static PageElement longTimeWindowInput;

    //EDIT Alarm Page//
    @Element(xpath = "//i[@dmcicon='plus']", desc = "add telemetry rules")
    private static PageElement addTelemetryRules;

    @Element(xpath = "(//div[contains(text(), 'TOPIC') and @class='-option-label'])[last]", desc = "TOPIC option channel in wizard")
    private static PageElement channelTopicOptionToSelectLast;

    @Element(xpath = "(//div[contains(text(), 'RDE ALARM') and @class='-option-label'])[last]", desc = "RDE ALARM option channel in wizard")
    private static PageElement channelRdeAlarmOptionToSelectLast;

    public static PageElement getWizardCompleted() {return wizardCompleted;}
    public static PageElement getFinalExitButton() {
        return finalExitButton;
    }
    public static PageElement getPhoneNumberToInsertBox() {
        return phoneNumberToInsertBox;
    }
    public static PageElement getEmailToInsertBox() {
        return emailToInsertBox;
    }
    public static PageElement getVisibleResetOptionsBTN() {
        return visibleResetOptionsBTN;
    }
    public static PageElement getResetOptionsBTN() {
        return resetOptionsBTN;
    }
    public static PageElement getPredefinedContinuousOption() {
        return predefinedContinuousOption;
    }
    public static PageElement getMonitorDevicesRadioBTN() {
        return monitorDevicesRadioBTN;
    }
    public static PageElement getWizardNextBTN() {
        return wizardNextBTN;
    }
    public static PageElement getConfigureNewAlarmRadioBTN() {
        return configureNewAlarmRadioBTN;
    }
    public static PageElement getTelemetryOfThresholdAlarmRadioBTN() {
        return telemetryOfThresholdAlarmRadioBTN;
    }
    public static PageElement getFirstDeviceGroupOption() {
        return firstDeviceGroupOption;
    }
    public static PageElement getAddThresholdBTN() {
        return addThresholdBTN;
    }
    public static PageElement getTimeWindowSelectionBTN() {
        return timeWindowSelectionBTN;
    }
    public static PageElement getNumberOfMessagesToWrite() {
        return numberOfMessagesToWrite;
    }

    public static PageElement getAddRuleBTN() {
        return addRuleBTN;
    }
    public static PageElement getAlarmConfigurationSummaryTitle() {
        return alarmConfigurationSummaryTitle;
    }
    public static PageElement getWizardSaveBTN() {
        return wizardSaveBTN;
    }
    public static PageElement getWizardAddChannelsBTN() {
        return wizardAddChannelsBTN;
    }
    public static PageElement getChannelEmailOptionToSelect() {
        return channelEmailOptionToSelect;
    }
    public static PageElement getChannelRdeAlarmOptionToSelect() {
        return channelRdeAlarmOptionToSelect;}
    public static PageElement getChannelSmsOptionToSelect() {return channelSmsOptionToSelect;}
    public static PageElement getChannelTopicOptionToSelect() {return channelTopicOptionToSelect;}
    public static PageElement getWizardYesRadioBTN() {return wizardYesRadioBTN;}
    public static PageElement getNotificationConfigurationSummaryTitle() {return notificationConfigurationSummaryTitle;}
    public static PageElement getVisibleNextBTN() {return visibleNextBTN;}
    public static PageElement getVisibleNumberOfMessage() {return visibleNumberOfMessage;}

    public static PageElement getMondayFromNotificationWindow() {
        return mondayFromNotificationWindow;
    }

    public static PageElement getMondayToNotificationWindow() {
        return mondayToNotificationWindow;
    }

    public static PageElement getTuesdayFromNotificationWindow() {
        return tuesdayFromNotificationWindow;
    }

    public static PageElement getTuesdayToNotificationWindow() {
        return tuesdayToNotificationWindow;
    }

    public static PageElement getWednesdayFromNotificationWindow() {
        return wednesdayFromNotificationWindow;
    }

    public static PageElement getWednesdayToNotificationWindow() {
        return wednesdayToNotificationWindow;
    }

    public static PageElement getThursdayFromNotificationWindow() {
        return thursdayFromNotificationWindow;
    }

    public static PageElement getThursdayToNotificationWindow() {
        return thursdayToNotificationWindow;
    }

    public static PageElement getFridayFromNotificationWindow() {
        return fridayFromNotificationWindow;
    }

    public static PageElement getFridayToNotificationWindow() {
        return fridayToNotificationWindow;
    }

    public static PageElement getSaturdayFromNotificationWindow() {
        return saturdayFromNotificationWindow;
    }

    public static PageElement getSaturdayToNotificationWindow() {
        return saturdayToNotificationWindow;
    }

    public static PageElement getSundayFromNotificationWindow() {
        return sundayFromNotificationWindow;
    }

    public static PageElement getSundayToNotificationWindow() {
        return sundayToNotificationWindow;
    }

    public static PageElement getDropDownArrowTAB() {return dropDownArrowTAB;}

    public static PageElement getFromHourNotificationWindow() {return fromHourNotificationWindow;}

    public static PageElement getToHourNotificationWindow() {return toHourNotificationWindow;}

    public static PageElement getAllAlarms() { return allAlarms; }

    public static PageElement getButtonNextStepsTab() {return buttonNextStepsTab;}

    public static PageElement getGroupDeviceOptionToSelect() {return groupDeviceOptionToSelect;}

    public static PageElement getNumberOfMessagesToWrite2() {return numberOfMessagesToWrite2;}

    public static PageElement getThreeHundredsecondsTimeSelectionLowThreshold() {return threeHundredsecondsTimeSelectionLowThreshold;}

    public static PageElement getThreeHundredsecondsTimeSelectionHighThreshold() {return threeHundredsecondsTimeSelectionHighThreshold;}

    public static PageElement getSelectionBoxDevicesGroup() {return selectionBoxDevicesGroup;}

    public static PageElement getExitBTN() {return exitBTN;}

    public static PageElement getTestConcept01Device() {return testConcept01Device;}

    public static PageElement getIconTrashAlarmTestConcept1() {return iconTrashAlarmTestConcept1;}

    public static PageElement getMonitorCloudComponentRadioBTN() {return monitorCloudComponentRadioBTN;}

    public static PageElement getMicroserviceDropDownBTN() {return microserviceDropDownBTN;}

    public static PageElement getCommandtoOption() {return commandtoOption;}

    public static PageElement getContinuousOption() {return continuousOption;}

    public static PageElement getDropDownFromDays() {return dropDownFromDays;}
    public static PageElement getDropDownToDays() {return dropDownToDays;}

    @Element(xpath = "//span[contains(text(), 'Test_Concept-01') and @class='mat-option-text']", desc = "Device Test Concept into the list - wizard")
    private static PageElement testConcept01DeviceIntoList;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-02') and @class='mat-option-text']", desc = "Device Test Concept into the list - wizard")
    private static PageElement testConcept02DeviceIntoList;

    @Element(xpath = "//th[contains(text(), 'VALUE')]", desc = "value telemetry")
    private static PageElement valueTelemetryTable;

    @Element(xpath = "//th[contains(text(), 'OPERATOR')]", desc = "operator telemetry")
    private static PageElement operatorTelemetryTable;

    @Element(xpath = "//th[contains(text(), 'TYPE')]", desc = "type telemetry")
    private static PageElement typeTelemetryTable;

    @Element(xpath = "//th[contains(text(), 'TREND ID')]", desc = "id telemetry")
    private static PageElement trendIdTelemetryTable;

    @Element(xpath = "//th[contains(text(), 'THING ID')]", desc = "thing id telemetry")
    private static PageElement thingIdTelemetryTable;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-04') and @class='mat-option-text']", desc = "Device Test Concept into the list - wizard")
    private static PageElement testConcept04DeviceIntoList;

    @Element(xpath = "(//div)[1]", desc = "First div in the page, used to click otuside the boxes and clear them")
    private static PageElement outsideDiv;

    @Element(xpath = "//strong[contains(text(), 'Test_Concept-03')]/parent::td//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "icon trash alarm test concept 1")
    private static PageElement iconTrashAlarmTestConcept3;
}

