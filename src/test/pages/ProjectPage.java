package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class ProjectPage {

    @Element(xpath = "//div[@class='project-switch']/i[@dmciconsize='large']", desc = "Button switch projects ")
    private static PageElement buttonToReturnHomePage;
    @Element(xpath = "//div[@class='mat-tab-label-content']", desc = "Icon of the project in the Project Page")
    private static PageElement slideBarOfTheProject;
    @Element(xpath = "//h2[text()= 'Devices']", desc = "Devices preview title section in the Project Page")
    private static PageElement devicePreviewTitleSection;
    @Element(xpath = "//i[@dmcicon='download']/ancestor::button", desc = "export icon")
    private static PageElement exportIcon;
    public static PageElement getLabelDevices() {
        return labelDevices;
    }
    public static PageElement getLabelAlarms() {
        return labelAlarms;
    }
    public static PageElement getLabelDeviceAndActivation() {
        return labelDeviceAndActivation;
    }
    @Element(xpath = "//header/h2[text()='Devices']", desc = "Label Devices")
    private static PageElement labelDevices;
    @Element(xpath = "//header/h2[contains(.,'Alarms')]", desc = "Label Alarms")
    private static PageElement labelAlarms;
    @Element(xpath = "//header/h2[contains(.,'Devices & Activation')]", desc = "Label Devices & Activation")
    private static PageElement labelDeviceAndActivation;
    public static PageElement getButtonToReturnHomePage() {
        return buttonToReturnHomePage;
    }
    public static PageElement getSlideBarOfTheProject() {
        return slideBarOfTheProject;
    }
    public static PageElement getDevicePreviewTitleSection() {return devicePreviewTitleSection;}
    @Element(xpath = "//header[contains(.,'Devices')]//following-sibling::div//h3[contains(.,'Gateway')]",
            desc = "H3 containing gateway title in device section")
    private static PageElement labelGatewayDeviceSection;

    @Element(xpath = "//header[contains(.,'Devices')]//following-sibling::div//h3[contains(.,'Direct Thing')]",
            desc = "H3 containing gateway title in device section")
    private static PageElement labelDirectThingDeviceSection;

    @Element(xpath = "//header[contains(.,'Devices')]//following-sibling::div//h3[contains(.,'Thing')]",
            desc = "H3 containing gateway title in device section")
    private static PageElement labelThingDeviceSection;

    @Element(xpath = "//header[contains(.,'Devices')]//following-sibling::div//h3[contains(.,'Totals')]",  desc = "H3 containing gateway title in device section")
    private static PageElement labelTotalsDeviceSection;

    @Element(xpath = "//div[@class= 'col-9 card-project-common-name']", desc = "Title of card")
    private static PageElement cardTitle;

    @Element(xpath = "//div[@class= 'col card-project-id']", desc = "project id in card")
    private static PageElement projectID;

    @Element(xpath = "//span[@class= 'ml-2 label-devices-count']", desc = "online number in card")
    private static PageElement onlineNumber;

    @Element(xpath = "//div[@class= 'col card-project-region']", desc = "project region in card")
    private static PageElement projectRegion;

    @Element(xpath = "//div[@class= 'container-cards custom-row-cards mb-3 py-3']", desc = "cards container")
    private static PageElement cardsContainer;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' 6 Months ')]", desc = "6 months button in alarms section")
    private static PageElement sixMonthsAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' 3 Months ')]", desc = "3 months button in alarm section")
    private static PageElement threeMonthsAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' GATEWAY ')]", desc = "Gateway Filter in alarm section")
    private static PageElement gatewayFilterAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' DIRECT THING ')]", desc = "DIRECT THING Filter in alarm section")
    private static PageElement directThingFilterAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle//span[text()=' THING ']", desc = "Thing Filter in alarm section")
    private static PageElement thingFilterAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' CUSTOM GROUP ')]", desc = "PLATFORM Filter in alarm section")
    private static PageElement customGroupFilterAlarm;

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//mat-button-toggle[contains(.,' TARGET ALL ')]", desc = "PLATFORM Filter in alarm section")
    private static PageElement targetAllFilterAlarm;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' 6 Months ')]", desc = "6 months button in Devices & Activations section")
    private static PageElement sixMonthsDevicesActivations;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' 3 Months ')]", desc = "3 months button in Devices & Activations section")
    private static PageElement threeMonthsDevicesActivations;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' GATEWAY ')]", desc = "Gateway Filter in Devices & Activations section")
    private static PageElement gatewayFilterDevicesActivations;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' DIRECT THING ')]", desc = "DIRECT THING Filter in Devices & Activations section")
    private static PageElement directThingFilterDevicesActivations;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle//span[text()=' THING ']", desc = "Thing Filter in Devices & Activations section")
    private static PageElement thingFilterDevicesActivations;

    @Element(xpath = "//h3[contains(.,'Totals')]//parent::div//following-sibling::span", desc = "Totals devices number")
    private static PageElement totalDevicesNumber;

    @Element(xpath = "//h3[contains(.,'Totals')]//parent::div//parent::div/following-sibling::div//div[@class='dmc-progress-label']", desc = "Totals devices number %")
    private static PageElement totalDevicesPercentage;

    @Element(xpath = "//h3[contains(.,'Totals')]//parent::div//parent::div/following-sibling::div[@class='dmc-summary-footer']", desc = "Totals devices online number")
    private static PageElement totalDevicesOnlineNumber;

    @Element(xpath = "//h3[contains(.,'Gateway')]//parent::div//following-sibling::span", desc = "Gateway devices number")
    private static PageElement gatewayDevicesNumber;

    @Element(xpath = "//h3[contains(.,'Gateway')]//parent::div//parent::div/following-sibling::div//div[@class='dmc-progress-label']", desc = "Gateway devices number %")
    private static PageElement gatewayDevicesPercentage;

    @Element(xpath = "//h3[contains(.,'Gateway')]//parent::div//parent::div/following-sibling::div[@class='dmc-summary-footer']", desc = "Gateway devices online number")
    private static PageElement gatewayDevicesOnlineNumber;

    @Element(xpath = "//h3[text()='Thing']//parent::div//following-sibling::span", desc = "thing devices number")
    private static PageElement thingDevicesNumber;

    @Element(xpath = "//h3[text()='Thing']//parent::div//parent::div/following-sibling::div//div[@class='dmc-progress-label']", desc = "thing devices number %")
    private static PageElement thingDevicesPercentage;

    @Element(xpath = "//h3[text()='Thing']//parent::div//parent::div/following-sibling::div[@class='dmc-summary-footer']", desc = "thing devices online number")
    private static PageElement thingDevicesOnlineNumber;

    @Element(xpath = "//h3[text()='Direct Thing']//parent::div//following-sibling::span", desc = "Direct Thing devices number")
    private static PageElement directThingDevicesNumber;

    @Element(xpath = "//h3[text()='Direct Thing']//parent::div//parent::div/following-sibling::div//div[@class='dmc-progress-label']", desc = "Direct Thing devices number %")
    private static PageElement directThingDevicesPercentage;

    @Element(xpath = "//h3[text()='Direct Thing']//parent::div//parent::div/following-sibling::div[@class='dmc-summary-footer']", desc = "Direct Thing devices online number")
    private static PageElement directThingDevicesOnlineNumber;

    @Element(xpath = "//i[@dmcicon = 'bell']", desc = "dmc icon bell")
    private static PageElement bellIcon;

    @Element(xpath = "//i[@dmcicon = 'download']", desc = "dmc icon download")
    private static PageElement downloadExportIcon;

    public static PageElement getTotalDevicesNumber() {
        return totalDevicesNumber;
    }

    public static PageElement getTotalDevicesPercentage() {
        return totalDevicesPercentage;
    }

    public static PageElement getTotalDevicesOnlineNumber() {
        return totalDevicesOnlineNumber;
    }

    public static PageElement getGatewayDevicesNumber() {
        return gatewayDevicesNumber;
    }

    public static PageElement getGatewayDevicesPercentage() {
        return gatewayDevicesPercentage;
    }

    public static PageElement getGatewayDevicesOnlineNumber() {
        return gatewayDevicesOnlineNumber;
    }

    public static PageElement getThingDevicesNumber() {
        return thingDevicesNumber;
    }

    public static PageElement getThingDevicesPercentage() {
        return thingDevicesPercentage;
    }

    public static PageElement getThingDevicesOnlineNumber() {
        return thingDevicesOnlineNumber;
    }

    public static PageElement getDirectThingDevicesNumber() {
        return directThingDevicesNumber;
    }

    public static PageElement getDirectThingDevicesPercentage() {
        return directThingDevicesPercentage;
    }

    public static PageElement getDirectThingDevicesOnlineNumber() {
        return directThingDevicesOnlineNumber;
    }
    //Elements for translation//
    @Element(xpath = "//header/h2[text()='Dispositivi']", desc = "Label Devices ita")
    private static PageElement labelDevicesIT;

    public static PageElement getLabelDevicesIT() {
        return labelDevicesIT;
    }

    @Element(xpath = "//header/h2[contains(.,'Allarmi')]", desc = "Label Alarms ita")
    private static PageElement labelAlarmsIT;

    public static PageElement getLabelAlarmsIT() {
        return labelAlarmsIT;
    }

    @Element(xpath = "//header/h2[contains(.,'Dispositivi e Attivazioni')]", desc = "Label Devices & Activation ita")
    private static PageElement labelDeviceAndActivationIT;

    public static PageElement getLabelDeviceAndActivationIT() {
        return labelDeviceAndActivationIT;
    }

    @Element(xpath = "//header[contains(.,'Dispositivi e Attivazioni')]/following-sibling::section/div//mat-button-toggle[contains(.,' 6 Mesi ')]", desc = "6 months button in Devices & Activations section ita")
    private static PageElement sixMonthsDevicesActivationsIT;

    public static PageElement getSixMonthsDevicesActivationsIT() {
        return sixMonthsDevicesActivationsIT;
    }

    @Element(xpath = "//header[contains(.,'Dispositivi e Attivazioni')]/following-sibling::section/div//mat-button-toggle[contains(.,' 3 Mesi ')]", desc = "3 months button in Devices & Activations section ita")
    private static PageElement threeMonthsDevicesActivationsIT;
    public static PageElement getThreeMonthsDevicesActivationsIT() {
        return threeMonthsDevicesActivationsIT;
    }

    @Element(xpath = "//header[contains(.,'Allarmi')]/following-sibling::section/div//mat-button-toggle[contains(.,' 6 Mesi ')]", desc = "6 months button in alarms section ita")
    private static PageElement sixMonthsAlarmIT;

    public static PageElement getSixMonthsAlarmIT() {
        return sixMonthsAlarmIT;
    }

    @Element(xpath = "//header[contains(.,'Allarmi')]/following-sibling::section/div//mat-button-toggle[contains(.,' 3 Mesi ')]", desc = "3 months button in alarm section ita")
    private static PageElement threeMonthsAlarmIT;

    public static PageElement getThreeMonthsAlarmIT() {
        return threeMonthsAlarmIT;
    }

    @Element(xpath = "//header[contains(.,'Dispositivi e Attivazioni')]/following-sibling::section/div//p", desc = "3 months button in alarm section ita")
    private static PageElement descriptionDevicesActivationsIT;

    public static PageElement getDescriptionDevicesActivationsIT() {
        return descriptionDevicesActivationsIT;
    }

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//p", desc = "3 months button in alarm section ita")
    private static PageElement descriptionDevicesActivations;

    @Element(xpath = "//header[contains(.,'Allarmi')]/following-sibling::section/div//p", desc = "3 months button in alarm section ita")
    private static PageElement descriptionAlarmsIT;

    public static PageElement getDescriptionAlarmsIT() {
        return descriptionAlarmsIT;
    }

    @Element(xpath = "//header[contains(.,'Alarms')]/following-sibling::section/div//p", desc = "3 months button in alarm section ita")
    private static PageElement descriptionAlarms;

    @Element(xpath = "//h3[contains(text(), 'Total')]", desc = "totals header")
    private static PageElement totalsHeaderInLandingPage;

    public static PageElement getTotalsHeaderInLandingPage() {
        return totalsHeaderInLandingPage;
    }

    @Element(xpath = "//div[@class='row' and contains(text(), 'Allarmi:')]", desc = "alarms legend it")
    private static PageElement alarmsLegendIT;

    public static PageElement getAlarmsLegendIT() {
        return alarmsLegendIT;
    }

    @Element(xpath = "//div[@class='row' and contains(text(), 'Attivazioni:')]", desc = "activations legend it")
    private static PageElement activationsLegendIT;

    public static PageElement getActivationsLegendIT() {
        return activationsLegendIT;
    }

    @Element(xpath = "(//div[text() = 'aggregated data'])", desc = "Aggregated data div")
    private static PageElement aggregatedDataLabel;

    @Element(xpath = "//*[name()='tspan' and text()= 'Activations']", desc = "activations legend of the table")
    private static PageElement activationsLegend;

    @Element(xpath = "//*[name()='tspan' and text()= 'Devices']", desc = "Devices legend of the table")
    private static PageElement devicesLegend;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' 6 Months ')]", desc = "6 months button in device section")
    private static PageElement sixMonthsDevice;

    @Element(xpath = "//header[contains(.,'Devices & Activations')]/following-sibling::section/div//mat-button-toggle[contains(.,' 3 Months ')]", desc = "3 months button in device section")
    private static PageElement threeMonthsDevice;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Gateway:')]/following-sibling::div", desc = "Device & Activations graph legend numbers: Gateway")
    private static PageElement gatewayLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and text()=' Thing: ']/following-sibling::div", desc = "ADevice & Activations graph legend numbers: Thing")
    private static PageElement thingLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Direct Thing:')]/following-sibling::div", desc = "Device & Activations graph legend numbers: Direct Thing")
    private static PageElement directThingLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Activations:')]/following-sibling::div", desc = "Device & Activations graph legend numbers: Total Activations")
    private static PageElement totalActivationsLegendNumber;

    @Element(xpath = "//*[name()='tspan' and text()= 'Alarms/Devices']", desc = "Alarms/Devices legend of the alarms table")
    private static PageElement alarmsDevicesLegend;

    @Element(xpath = "//*[name()='tspan' and text()= 'Alarms']", desc = "Alarms legend of the alarms table")
    private static PageElement alarmsLegend;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Gateway alarms:')]", desc = "Alarms graph legend: Gateway alarms")
    private static PageElement gatewayAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Gateway alarms:')]/following-sibling::div", desc = "Alarms graph legend: Gateway alarms")
    private static PageElement gatewayAlarmsLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and text()=' Thing alarms: ']", desc = "Alarms graph legend: Thing alarms")
    private static PageElement thingAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and text()=' Thing alarms: ']/following-sibling::div", desc = "Alarms graph legend: Thing alarms")
    private static PageElement thingAlarmsLegendNumber;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Direct Thing alarms:')]", desc = "Alarms graph legend: Direct Thing alarms")
    private static PageElement directThingAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Direct Thing alarms:')]/following-sibling::div", desc = "Alarms graph legend: Direct Thing alarms")
    private static PageElement directThingAlarmsLegendNumber;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Custom Group alarms:')]", desc = "Alarms graph legend: Custom Group alarms")
    private static PageElement customGroupAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Custom Group alarms:')]/following-sibling::div", desc = "Alarms graph legend: Custom Group alarms")
    private static PageElement customGroupAlarmsLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Alarm Target ALL:')]", desc = "Alarms graph legend: Alarm Target All")
    private static PageElement targetAllAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Alarm Target ALL:')]/following-sibling::div", desc = "Alarms graph legend: Alarm Target ALL alarms")
    private static PageElement targetAllAlarmsLegendNumber;

    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Alarms/Devices:')]", desc = "Alarms graph legend: Alarm Target All")
    private static PageElement alarmDevicesAlarmsLegend;
    @Element(xpath = "//div[@class='ml-3']/div[@class= 'row' and contains(.,'Alarms/Devices:')]/following-sibling::div", desc = "Alarms graph legend: Alarms/Devices alarms")
    private static PageElement alarmDevicesAlarmsLegendNumber;

    @Element(xpath = "//div[@class= 'col card-project-id']", desc = "id card title apm")
    private static PageElement idApmCardTitle;
    @Element(xpath = "//div[@class='card-top']/div[contains(.,' esol-ap29551-perf ')]", desc = "project esol-ap29551-perf")
    private static PageElement projectPERF;

    @Element(xpath = "//div[@class='card-top']/div[contains(.,' esol-ap29551-qa ')]", desc = "project esol-ap29551-qa")
    private static PageElement projectQA;

    @Element(xpath = "//button[contains(.,' Enter ')]", desc = "enter projects BTN")
    private static PageElement enterProject;

    @Element(xpath = "//div[@role='tab']/div[contains(.,'esol_ap29551_perf')]", desc = "projects perf tab")
    private static PageElement projectPerfTab;
    public static PageElement getProjectPerfTab() {return projectPerfTab;}

    @Element(xpath = "//div[@role='tab']/div[contains(.,'esol_ap29551_qa')]", desc = "projects qa tab")
    private static PageElement projectQaTab;
    public static PageElement getProjectQaTab() {return projectQaTab;}

    @Element(xpath = "//div[@role='tab']/div[contains(.,'aggregated data')]", desc = "projects qa tab")
    private static PageElement aggregatedProjectTab;
    public static PageElement getAggregatedProjectTab() {return aggregatedProjectTab;}

    public static PageElement getIdApmCardTitle() {return idApmCardTitle;}

    public static PageElement getLogoEnel() {
        return logoEnel;
    }

    @Element(xpath = "//a[@class='navbar-brand --desktop']", desc = "Enel X")
    private static PageElement logoEnel;

    @Element(xpath = "//i[@class='dmc-icon__grid dmc-icon-size-large dmc-icon']", desc = "Choose project icon")
    private static PageElement iconChooseProject;

    @Element(xpath = "//span[contains(., 'Exclude never connected devices or disconnected since')]", desc = "Checkbox filter never connected device")
    private static PageElement checkboxNeverConnected;
    /*-------------------Tooltip-------------------*/
    @Element(xpath = "//h2[contains(.,'Alarms')]/following-sibling::i", desc = "Alarms Tooltip Icon")
    private static PageElement alarmsTooltipIcon;
    @Element(xpath = "//alarms-bottom-sheet/h4[contains(.,'Alarms')]", desc = "Alarms Tooltip Pop-up Title")
    private static PageElement alarmsTooltipTitle;
    @Element(xpath = "//strong[contains(.,'Gateway alarms')]/ancestor::li[contains(.,'related to a  gateway and the things connected to it')]", desc = "Alarms Tooltip Pop-up Text Gateway alarms")
    private static PageElement alarmsTooltipTextGateway;
    @Element(xpath = "//strong[contains(.,'Thing alarms')]/ancestor::li[contains(.,'related to single things')]", desc = "Alarms Tooltip Pop-up Text Thing alarms")
    private static PageElement alarmsTooltipTextThing;
    @Element(xpath = "//strong[contains(.,'Direct Thing alarms')]/ancestor::li[contains(.,'related to single Direct things')]", desc = "Alarms Tooltip Pop-up Text Direct Thing alarms")
    private static PageElement alarmsTooltipTextDirectThing;
    @Element(xpath = "//strong[contains(.,'Custom Group alarms')]/ancestor::li[contains(.,'related to an heterogeneous set of devices')]", desc = "Alarms Tooltip Pop-up Text Custom Group alarm")
    private static PageElement alarmsTooltipTextCustomGroup;
    @Element(xpath = "//strong[contains(.,'Alarm Target ALL')]/ancestor::li[contains(.,'related to alarms of the selected projects with Alarm Target ALL DEVICES')]", desc = "Alarms Tooltip Pop-up Text Alarm Target All")
    private static PageElement alarmsTooltipTextTargetAll;
    @Element(xpath = "//strong[contains(.,'Alarms/Devices')]/ancestor::li[contains(.,'the ratio of the total number of alarms to the total number of devices for each month')]", desc = "Alarms Tooltip Pop-up Text Alarm/Devices")
    private static PageElement alarmsTooltipTextAlarmsDevices;
    @Element(xpath = "//footer/button[contains(.,'Close')]", desc = "Close Tooltip Button")
    private static PageElement closeTooltipButton;

    /*--------------Graph Alarms--------------*/
    //Labels:
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[1]", desc = "Alarms Graph Month 1")
    private static PageElement alarmsGraphMonth1;
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[2]", desc = "Alarms Graph Month 2")
    private static PageElement alarmsGraphMonth2;
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[3]", desc = "Alarms Graph Month 3")
    private static PageElement alarmsGraphMonth3;
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[4]", desc = "Alarms Graph Month 1")
    private static PageElement alarmsGraphMonth4;
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[5]", desc = "Alarms Graph Month 1")
    private static PageElement alarmsGraphMonth5;
    @Element(xpath = "(//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels']/*[name()='text']/*[name()='tspan'])[6]", desc = "Alarms Graph Month 1")
    private static PageElement alarmsGraphMonth6;
    public static PageElement getAlarmsGraphMonth1() { return alarmsGraphMonth1; }
    public static PageElement getAlarmsGraphMonth2() { return alarmsGraphMonth2; }
    public static PageElement getAlarmsGraphMonth3() { return alarmsGraphMonth3; }
    public static PageElement getAlarmsGraphMonth4() { return alarmsGraphMonth4; }
    public static PageElement getAlarmsGraphMonth5() { return alarmsGraphMonth5; }
    public static PageElement getAlarmsGraphMonth6() { return alarmsGraphMonth6; }


    /*--------------Graph Devices--------------*/
    //Labels:
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[1]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth1;
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[2]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth2;
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[3]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth3;
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[4]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth4;
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[5]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth5;
    @Element(xpath = "((//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-axis-labels highcharts-xaxis-labels'])[2]/*[name()='text']/*[name()='tspan'])[6]", desc = "Devices Graph Month 1")
    private static PageElement deviceGraphMonth6;
    public static PageElement getDeviceGraphMonth1() {
        return deviceGraphMonth1;
    }
    public static PageElement getDeviceGraphMonth2() { return deviceGraphMonth2; }
    public static PageElement getDeviceGraphMonth3() { return deviceGraphMonth3; }
    public static PageElement getDeviceGraphMonth4() { return deviceGraphMonth4; }
    public static PageElement getDeviceGraphMonth5() { return deviceGraphMonth5; }
    public static PageElement getDeviceGraphMonth6() { return deviceGraphMonth6; }

    //Legend numbers
    public static PageElement getGatewayLegendNumber() { return gatewayLegendNumber; }
    public static PageElement getThingLegendNumber() { return thingLegendNumber; }
    public static PageElement getDirectThingLegendNumber() { return directThingLegendNumber; }
    public static PageElement getTotalActivationsLegendNumber() { return totalActivationsLegendNumber; }

    public static PageElement getGatewayAlarmsLegend() { return gatewayAlarmsLegend; }
    public static PageElement getThingAlarmsLegend() { return thingAlarmsLegend; }
    public static PageElement getDirectThingAlarmsLegend() { return directThingAlarmsLegend; }
    public static PageElement getCustomGroupAlarmsLegend() { return customGroupAlarmsLegend; }
    public static PageElement getTargetAllAlarmsLegend() { return targetAllAlarmsLegend; }
    public static PageElement getAlarmDevicesAlarmsLegend() { return alarmDevicesAlarmsLegend; }
    public static PageElement getGatewayAlarmsLegendNumber() { return gatewayAlarmsLegendNumber;  }

    public static PageElement getThingAlarmsLegendNumber() {
        return thingAlarmsLegendNumber;
    }

    public static PageElement getDirectThingAlarmsLegendNumber() {
        return directThingAlarmsLegendNumber;
    }

    public static PageElement getCustomGroupAlarmsLegendNumber() {
        return customGroupAlarmsLegendNumber;
    }

    public static PageElement getTargetAllAlarmsLegendNumber() {
        return targetAllAlarmsLegendNumber;
    }

    public static PageElement getAlarmDevicesAlarmsLegendNumber() {
        return alarmDevicesAlarmsLegendNumber;
    }
}