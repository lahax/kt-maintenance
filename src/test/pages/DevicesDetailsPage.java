package test.pages;

import org.openqa.selenium.WebElement;
import ta.annotations.elements.Element;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DevicesDetailsPage {

    @Element(xpath = "//h2[@class='-title' and contains(., 'Update gateway')]", desc = "Update Gateway title section")
    private static PageElement updateGatewayTitleSection;

    //buttons//
    @Element(xpath = "//span[contains(., 'Reboot')]//ancestor::dmc-command-button", desc = "reboot button")
    private static PageElement rebootBTN;
    @Element(xpath = "//dmc-command-button//span[contains(., 'Riavvia')]", desc = "reboot button")
    private static PageElement rebootBTNit;

    @Element(xpath = "//span[contains(., 'Firmware')]//ancestor::dmc-command-button", desc = "firmware update button")
    private static PageElement firmwareUpdateBTN;

    @Element(xpath = "//span[contains(., 'Aggiorna Firmware')]", desc = "firmware update button")
    private static PageElement firmwareUpdateBTNit;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Firmware')]//parent::button", desc = "firmware update button")
    private static PageElement firmwareUpdateToClick;

    @Element(xpath =  "//h2[contains(text(), 'More Information')]", desc = "More Information Title")
    private static PageElement moreInformationTitle;

    @Element(xpath =  "//dmc-details-grid//preceding-sibling::div[contains(@class, 'border')]", desc = "More Information Table")
    private static PageElement moreInformationTableDirectThing;

    @Element(xpath = "//span[contains(., 'Remote control')]//ancestor::dmc-command-button", desc = "remote control")
    private static PageElement remoteControlBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Controllo')]", desc = "remote control")
    private static PageElement remoteControlBTNit;

    @Element(xpath = "//span[contains(., 'Deactivate')]//ancestor::dmc-command-button", desc = "deactivate button")
    private static PageElement deactivateBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Disattiva')]", desc = "deactivate button")
    private static PageElement deactivateBTNit;

    @Element(xpath = "//span[contains(., 'Update gateway')]//ancestor::dmc-command-button", desc = "update gateway button")
    private static PageElement updateGatewayBTN;

    @Element(xpath = "//span[contains(., 'Aggiorna gateway')]//ancestor::dmc-command-button", desc = "update gateway button")
    private static PageElement updateGatewayBTNit;

    public static PageElement getUpdateGatewayBTNit() {
        return updateGatewayBTNit;
    }

    @Element(xpath = "//dmc-command-button//span[contains(., 'Update gateway')]//parent::button", desc = "update gateway button")
    private static PageElement updateGatewayBTNToClick;

    @Element(xpath = "//span[contains(., 'Update')]//ancestor::dmc-command-button", desc = "update button")
    private static PageElement updateBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Modifica')]", desc = "update button it")
    private static PageElement updateBTNit;

    @Element(xpath = "//span[contains(., 'Renew Certificates')]//ancestor::dmc-command-button", desc = "renew certificates button")
    private static PageElement renewCertificatesBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Rinnova')]", desc = "renew certificates button")
    private static PageElement renewCertificatesBTNit;

    @Element(xpath = "//span[contains(., 'Show Logs')]//ancestor::dmc-command-button", desc = "show logs button")
    private static PageElement showLogsBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Show Logs')]//parent::button", desc = "show logs button")
    private static PageElement showLogsBTNToClick;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Mostra Logs')]", desc = "show logs button")
    private static PageElement showLogsBTNit;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Show Logs')]//parent::button", desc = "show logs button")
    private static PageElement showLogsToClick;

    @Element(xpath = "//span[contains(., 'Get History Logs')]//ancestor::dmc-command-button", desc = "get history logs button")
    private static PageElement getHistoryLogsBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Mostra Storico')]", desc = "get history logs button")
    private static PageElement getHistoryLogsBTNit;

    @Element(xpath = "//span[contains(., 'Enable Collect Logs')]//ancestor::dmc-command-button", desc = "enable collect logs button")
    private static PageElement enableCollectLogsBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Abilita')]", desc = "enable collect logs button")
    private static PageElement enableCollectLogsBTNit;

    @Element(xpath = "//span[contains(., 'Greengrass Deploy')]//ancestor::dmc-command-button", desc = "greengrass deploy button")
    private static PageElement greenGrassDeployBTN;

    @Element(xpath = "//span[contains(., 'Rilascio Greengrass')]//ancestor::dmc-command-button", desc = "greengrass deploy button")
    private static PageElement greenGrassDeployBTNit;

    public static PageElement getGreenGrassDeployBTNit() {
        return greenGrassDeployBTNit;
    }

    @Element(xpath = "//span[contains(., 'Greengrass reset')]//ancestor::dmc-command-button", desc = "greengrass reset button")
    private static PageElement greenGrassResetBTN;

    @Element(xpath = "//span[contains(., 'Resetta Greengrass')]//ancestor::dmc-command-button", desc = "greengrass reset button")
    private static PageElement greenGrassResetBTNit;

    public static PageElement getGreenGrassResetBTNit() {
        return greenGrassResetBTNit;
    }

    @Element(xpath = "//span[contains(., 'Ota Update')]//ancestor::dmc-command-button", desc = "ota update button")
    private static PageElement otaUpdateBTN;

    @Element(xpath = "//span[contains(., 'Aggiorna Ota')]//ancestor::dmc-command-button", desc = "ota update button")
    private static PageElement otaUpdateBTNit;

    public static PageElement getOtaUpdateBTNit() {
        return otaUpdateBTNit;
    }

    @Element(xpath = "//span[contains(., 'Upload File')]//ancestor::dmc-command-button", desc = "upload file button")
    private static PageElement uploadFileBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Carica')]", desc = "upload file button")
    private static PageElement uploadFileBTNit;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Scarica')]", desc = "upload file button")
    private static PageElement downloadFileBTNit;

    @Element(xpath = "//span[contains(., 'Download File')]//ancestor::dmc-command-button", desc = "download file button")
    private static PageElement downloadFileBTN;

    @Element(xpath = "//span[contains(., 'Telemetry')]//ancestor::dmc-command-button", desc = "firmware update button")
    private static PageElement TelemetryBTN;

    @Element(xpath = "//dmc-command-button//span[contains(., 'Telemetria')]", desc = "firmware update button")
    private static PageElement TelemetryBTNit;

    public static PageElement getRebootBTN() {
        return rebootBTN;
    }

    public static PageElement getRebootBTNit() {
        return rebootBTNit;
    }

    public static PageElement getDeactivateBTN() {
        return deactivateBTN;
    }

    public static PageElement getDeactivateBTNit() {
        return deactivateBTNit;
    }

    public static PageElement getRenewCertificatesBTN() {
        return renewCertificatesBTN;
    }

    public static PageElement getRenewCertificatesBTNit() {
        return renewCertificatesBTNit;
    }

    public static PageElement getUpdateBTN() {
        return updateBTN;
    }

    public static PageElement getUpdateBTNit() {
        return updateBTNit;
    }

    public static PageElement getFirmwareUpdateBTN() {
        return firmwareUpdateBTN;
    }

    public static PageElement getFirmwareUpdateBTNit() {
        return firmwareUpdateBTNit;
    }

    public static PageElement getRemoteControlBTN() {
        return remoteControlBTN;
    }

    public static PageElement getRemoteControlBTNit() {
        return remoteControlBTNit;
    }

    public static PageElement getShowLogsBTN() {
        return showLogsBTN;
    }

    public static PageElement getShowLogsBTNit() {
        return showLogsBTNit;
    }

    public static PageElement getUploadFileBTN() {
        return uploadFileBTN;
    }

    public static PageElement getUploadFileBTNit() {
        return uploadFileBTNit;
    }

    public static PageElement getEnableCollectLogsBTN() {
        return enableCollectLogsBTN;
    }

    public static PageElement getEnableCollectLogsBTNit() {
        return enableCollectLogsBTNit;
    }

    public static PageElement getGetHistoryLogsBTN() {
        return getHistoryLogsBTN;
    }

    public static PageElement getGetHistoryLogsBTNit() {
        return getHistoryLogsBTNit;
    }

    public static PageElement getDownloadFileBTN() {
        return downloadFileBTN;
    }

    public static PageElement getDownloadFileBTNit() {
        return downloadFileBTNit;
    }

    public static PageElement getTelemetryBTN() {
        return TelemetryBTN;
    }

    public static PageElement getTelemetryBTNit() {
        return TelemetryBTNit;
    }

    //things//
    @Element(xpath = "//div[contains(text(), 'Things')]/ancestor::div[@role='tab']", desc = "button for enter in things list")
    private static PageElement enterToThingsList;

    @Element(xpath = "//button//i[contains(@class, 'vertical')]", desc = "more info things button")
    private static PageElement moreInfoThingsBTN;

    @Element(xpath = "//i[contains(@class, 'power')]//parent::button", desc = "deactivate things button")
    private static PageElement deactivateThingsBTN;

    @Element(xpath = "(//dmc-fab-menu-item/button)[position()=3]", desc = "refresh things button")
    private static PageElement refreshThingsBTN;
    @Element(xpath = "(//dmc-fab-menu-item/button)[position()=3]", desc = "update things button")
    private static PageElement firmwareUpdate;
    @Element(xpath = "//ul//i[contains(@class, 'pencil')]//parent::button", desc = "edit things button")
    private static PageElement editThingsBTN;

    @Element(xpath = "//ul//i[contains(@class, 'plus')]//parent::button", desc = "activate things button")
    private static PageElement activateThingsBTN;


   @Element(xpath = "//dmc-table-selector", desc = "selector things button")
   private static PageElement selectorThingBTN;

   @Element(xpath = "//strong[contains(text(), 'Certificate')]/parent::div//following-sibling::div//div[@class ='-icon']", desc = "delete certificate")
   private static PageElement deleteCertificate;

   @Element(xpath = "//strong[contains(text(), 'Force')]/parent::div//following-sibling::div//div[@class ='-icon']", desc = "delete force")
   private static PageElement forceDelete;

   @Element(xpath = "//h5//parent::div//div//button[contains(text(), 'Confirm')]", desc = "delete confirm")
   private static PageElement deleteConfirm;

    @Element(xpath = "//td[contains(., 'Test_Concept-04_thing1')]//parent::tr//div/i[contains(@class, 'vertical')]", desc = "concept94 thing1 more info button")
    private static PageElement concept04Thing1moreInfo;

    @Element(xpath = "//div/i[contains(@class, 'vertical')]", desc = "selected thing more info button")
    private static PageElement selectedThingMoreInfo;

    @Element(xpath = "//i[@dmcicon='power']", desc = "deactivate thing button")
    private static PageElement deactivateSelectedThing;

    @Element(xpath = "//span[@class='-breadcrumb' and contains(text(), 'Things')]", desc = "thing list landing page")
    private static PageElement thingListLandingPage;

    //PAGE ACTIVATE THING//

   @Element(xpath = "//dmc-dummy-input", desc = "select template option")
   private static PageElement selectTemplateOption;

   @Element(xpath = "//div[contains(@class, 'last')]", desc = "others template option")
   private static PageElement othersTemplateOption;

   @Element(xpath = "//textarea", desc = "template form")
   private static PageElement templateForm;

   @Element(xpath = "//button[contains(text(), 'Activate')]", desc = "confirm activate thing button")
   private static PageElement confirmActivateThingBTN;

   //DIRECT_THING PAGE//
   @Element(xpath = "//div[@class='dmc-card']//div[@class='border-alert']", desc = "direct thing status alert")
   private static PageElement directThingStatusAlert;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[@class='border-alert']", desc = "gateway status alert")
    private static PageElement gatewayStatusAlert;

    public static PageElement getGatewayStatusAlert() {
        return gatewayStatusAlert;
    }

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(@class,'border-danger')]", desc = "device status logs")
    private static PageElement deviceLastLogsText;

    public static PageElement getDirectThingStatusAlert() {
        return directThingStatusAlert;
    }

    public static PageElement getDeviceLastLogsText() {
        return deviceLastLogsText;
    }

    @Element(xpath = "//h2[@class='-title']", desc = "Direct Thing Page Title")
    private static PageElement directThingPageTitle;

    @Element(xpath = "//span[@class='-breadcrumb']", desc = "Direct Thing above Title")
    private static PageElement aboveTitleDirectThing;

    @Element(xpath = "//h4[contains(text(), 'System Commands')]", desc = "system commands header")
    private static PageElement systemCommandsHeader;

    @Element(xpath = "//h4[contains(text(), 'Comandi di Sistema')]", desc = "system commands header it")
    private static PageElement systemCommandsHeaderIT;

    public static PageElement getSystemCommandsHeader() {
        return systemCommandsHeader;
    }

    public static PageElement getSystemCommandsHeaderIT() {
        return systemCommandsHeaderIT;
    }

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Produttore')]", desc = "maker it")
    private static PageElement makerIT;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Prefisso Ambientale')]", desc = "maker it")
    private static PageElement environmentPrefixIT;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Numero Seriale')]", desc = "serial number it")
    private static PageElement serialNumberIT;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Geolocalizzazione')]", desc = "geolocalization it")
    private static PageElement geolocalizationIT;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Tipo')]", desc = "type it")
    private static PageElement typeIT;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Tipo di Gateway')]", desc = "type gateway it")
    private static PageElement typeGatewayIT;

    public static PageElement getTypeGatewayIT() {
        return typeGatewayIT;
    }

    @Element(xpath = "//i[@dmcicon='history']", desc = "history icon")
    private static PageElement historyIcon;

    @Element(xpath = "//i[@dmcicon='info']", desc = "info icon")
    private static PageElement infoIcon;

    @Element(xpath = "//button[contains(@class, 'back')]", desc = "back BTN")
    private static PageElement backBTN;

    @Element(xpath = "//div[@aria-label='Map']", desc = "map")
    private static PageElement deviceLocalizationMap;

    public static PageElement getMakerIT() {
        return makerIT;
    }

    public static PageElement getEnvironmentPrefixIT() {
        return environmentPrefixIT;
    }

    public static PageElement getSerialNumberIT() {
        return serialNumberIT;
    }

    public static PageElement getGeolocalizationIT() {
        return geolocalizationIT;
    }

    public static PageElement getBackBTN() {
        return backBTN;
    }

    public static PageElement getTypeIT() {
        return typeIT;
    }

    //Firmware update//

    @Element(xpath = "//button[contains(text(), 'Add New Package')]", desc = "add new package")
    private static PageElement addNewPackage;

    @Element(xpath = "//i[@dmcicon='trash']", desc = "trash icon")
    private static PageElement trashIcon;

    @Element(xpath = "//dmc-form-field-label[contains(text(), 'Version')]//parent::dmc-form-field//dmc-select", desc = "version box")
    private static PageElement versionBox;

    @Element(xpath = "(//dmc-form-field-label[contains(text(), 'Version')]//parent::dmc-form-field//dmc-select)[2]", desc = "version box")
    private static PageElement versionBox2;

    @Element(xpath = "//dmc-form-field-label[contains(text(), 'App Name')]//parent::dmc-form-field//dmc-select", desc = "app name box")
    private static PageElement appNameBox;

    @Element(xpath = "(//dmc-form-field-label[contains(text(), 'App Name')]//parent::dmc-form-field//dmc-select)[2]", desc = "app name box")
    private static PageElement appNameBox2;

    @Element(xpath = "//div[contains(text(), 'APP1') and @class='-option-label']", desc = "app1 option to select")
    private static PageElement app1OptionToSelect;
    @Element(xpath = "//div[contains(text(), 'test_2913') and @class='-option-label']", desc = "app1 option to select")
    private static PageElement test_2913ptionToSelect;

    @Element(xpath = "//div[contains(text(), '1.0') and @class='-option-label']", desc = "version1 option to select")
    private static PageElement version1OptionToSelect;

    @Element(xpath = "//div[contains(text(), '3.2') and @class='-option-label']", desc = "version3.2 option to select")
    private static PageElement version32OptionToSelect;

    @Element(xpath = "//div[contains(text(), '4.0') and @class='-option-label']", desc = "version4 option to select")
    private static PageElement version4OptionToSelect;

    @Element(xpath = "//div[contains(text(), '5.0') and @class='-option-label']", desc = "version5 option to select")
    private static PageElement version5OptionToSelect;

    @Element(xpath = "//div[contains(text(), '6.0') and @class='-option-label']", desc = "version5 option to select")
    private static PageElement version6OptionToSelect;

    @Element(xpath = "//button[contains(text(), ' Add New Package ')]", desc = "Add new package firmware update parameters ")
    private static PageElement addNewPackageBTN;

    @Element(xpath = "//dmc-form-field-label[text() = ' Version ']//parent::dmc-form-field", desc = " Version package install form ")
    private static PageElement versionForm;

    @Element(xpath = "//dmc-form-field-label[text() = ' App Name ']//parent::dmc-form-field", desc = "app Name package install form ")
    private static PageElement appNameForm;

    @Element(xpath = "//dmc-dummy-input//div[contains(., ' Select datetimes... ')]", desc = "Select daytimes btn in Connectivity History")
    private static PageElement selectDaytimeBTN;

    @Element(xpath = "//button[contains(text(), ' Now ')]", desc = "Now btn date in Connectivity History")
    private static PageElement nowBTN;

    @Element(xpath = "//div[text()=' To ']", desc = "To range date time tab in Connectivity History ")
    private static PageElement toRangeTime;

    @Element(xpath = "(//div[@class='-picker-date']//div[@class='-prev']/i[@dmcicon='chevron-left'])[1]", desc = "Left btn on month selection date in Connectivity History ")
    private static PageElement leftMonthBTNFrom;

    @Element(xpath = "(//div[@class='-picker-date']//div[@class='-prev']/i[@dmcicon='chevron-left'])[2]", desc = "Left btn on month selection date in Connectivity History ")
    private static PageElement leftMonthBTNTo;

    @Element(xpath = "(//div[@class='-days']//div[contains(text(), ' 15 ')])[1]", desc = "Pick the day 15 of the previous month in Connectivity History ")
    private static PageElement fifteenDayPreviousMonthFrom;

    @Element(xpath = "(//div[@class='-days']//div[contains(text(), ' 15 ')])[2]", desc = "Pick the day 15 of the previous month in Connectivity History ")
    private static PageElement fifteenDayPreviousMonthTo;

    @Element(xpath = "//button[contains(text(), ' Confirm ')]", desc = "Confirm selection in Connectivity History ")
    private static PageElement confirmBTN;

    @Element(xpath = "//div[@class='col-3']", desc = "Pie chart in  Connectivity History ")
    private static PageElement pieChart;

    @Element(xpath = "//div[@class='col-7 mt-2 mt-lg-0']", desc = "bar chart in Connectivity History ")
    private static PageElement barGraph;

    @Element(xpath = "//div[@class='col-2 mt-2 mt-lg-0']", desc = "Graph details in Connectivity History ")
    private static PageElement graphDetails;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(.,'Things')]", desc = "Things Tab")
    private static PageElement tabThings;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(.,'General')]", desc = "General Tab")
    private static PageElement tabGeneral;
    @Element(xpath = "//input[@placeholder='Search by ID, SERIAL, ALIAS']", desc = "Search input box in thing list")
    private static PageElement searchThingLabel;

    @Element(xpath = "//tr/td[contains(., '')][2]" , desc= "button Confirm into calendar")
    public static PageElement allSourcesInTheTableFirstPage;
    public static String rowFilteredBySource = "//tbody/tr/td[contains(., '%s')]/parent::tr";

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(.,'Activities')]", desc = "Activities Tab")
    private static PageElement tabActivities;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(.,'Deployments History')]", desc = "Deployments History Tab")
    private static PageElement tabDeploymentsHistory;
    public static String getRandomSource(){
        List<WebElement> listSources = CommonPage.getDriver().findElements(allSourcesInTheTableFirstPage.getBy());
        List<String> sources = new ArrayList<>();
        if(listSources!= null && !listSources.isEmpty()){
            for(WebElement we: listSources){
                if(!sources.contains(we.getText())){
                    sources.add(we.getText());
                }
            }

            Random r = new Random();
            int n = r.nextInt(sources.size());
            return sources.get(n);
        }
        return "";
    }

    public static PageElement getSearchThingLabel() {
        return searchThingLabel;
    }

    @Element(xpath = "//input[@type='search']", desc = "search box")
    private static PageElement searchBox;

    @Element(xpath = "//strong[contains(., ' disconnected ')]", desc = "device details disconnected status")
    private static PageElement deviceDisconnectedStatus;
    @Element(xpath = "//strong[contains(., ' connected ')]", desc = "device details connected status")
    private static PageElement deviceConnectedStatus;

    @Element(xpath = "//td[contains(., 'Test_Concept-01_thing1')]//parent::tr//div/i[contains(@class, 'vertical')]", desc = "concept94 thing1 more info button")
    private static PageElement concept01Thing1moreInfo;

    @Element(xpath = "//button[contains(text(), 'Reboot')]", desc = "reboot confirm button")
    private static PageElement rebootConfirmBTN;

    @Element(xpath = "//input[@placeholder='custom_communication_enabled']", desc = "communication enabled box")
    private static PageElement customCommunicationEnabledBox;

    public static PageElement getCustomCommunicationEnabledBox() {
        return customCommunicationEnabledBox;
    }

    @Element(xpath = "//button[contains(text(), 'Update')]", desc = "update button")
    private static PageElement confirmUpdateBTN;

    @Element(xpath = "//button[contains(text(), 'Show more')]", desc = "show more button")
    private static PageElement showMoreDirectBTN;

    //TO CHANGE (FALSE OR TRUE) IN CUSTOM COMMUNICATION AFTER BUG FIX//
    @Element(xpath = "//dmc-details-grid-item//div[contains(., 'false') or contains(., 'true')]", desc = "communication enabled in more info")
    private static PageElement customCommunicationInMoreInfo;


    public static PageElement getCustomCommunicationInMoreInfo() {
        return customCommunicationInMoreInfo;
    }

    @Element(xpath = "//dmc-details-window//button[contains(@class, 'back')]", desc = "back BTN in details")
    private static PageElement backBTNInDetails;

    @Element(xpath = "//dmc-direct-thing-more-info-dialog//button[contains(@class, 'back')]", desc = "back BTN info direct")
    private static PageElement backBTNMoreInfoDirect;
    @Element(xpath = "//button[contains(text(), ' Reboot ')]", desc = "Confirm reboot button")
    private static PageElement confirmRebootBTN;

    @Element(xpath = "//i[@dmcicon='link']", desc = "Align status link icon")
    private static PageElement alignStatusIcon;

    @Element(xpath = "//button[contains(text(), ' Align ')]", desc = "Confirm align status button")
    private static PageElement confirmAlignBTN;

    @Element(xpath = "(//span[contains(., ' Monitoring ')])//preceding-sibling::div", desc = "Monitornig flag button")
    private static PageElement monitoringFlag;

    @Element(xpath = "//input[@placeholder='Model']", desc = "Update thing input model")
    private static PageElement updateModel;

    @Element(xpath = "//input[@placeholder='Alias']", desc = "Update thing input alias")
    private static PageElement updateAlias;

    @Element(xpath = "//tr[@class='ng-star-inserted']//dmc-table-selector", desc = "selector first thing id in concept02")
    private static PageElement firstIdButtonConcept02Thing01;

    @Element(xpath = "//i[@class='dmc-icon__more-vertical dmc-icon']", desc = "show details Test_Concept-02_thing1")
    private static PageElement showDetailsConcept02Thing01BTN;

    @Element(xpath = "//i[@dmcicon='info']", desc = "info thing Icon ")
    private static PageElement infoThingIcon;

    @Element(xpath = "//button[@class='--primary --size-regular --width-large']", desc = "start update button ")
    private static PageElement startUpdateBTN;

    @Element(xpath = "//button[contains(.,'Back')]/following-sibling::div[contains(.,'Update Things')]/preceding-sibling::button", desc = "back update BTN")
    private static PageElement backUpdateBTN;

    @Element(xpath = "//div[contains(text(), 'Model')]/following-sibling::div", desc = "Model")
    private static PageElement modelDetail;

    @Element(xpath = "//div[contains(text(), 'Thing Alias')]/following-sibling::div", desc = "Alias")
    private static PageElement aliasDetail;

    @Element(xpath = "//span[contains(., 'Telemetry')]//ancestor::button", desc = "Telemetry button in thing list datails")
    private static PageElement telemetryThingBTN;

    @Element(xpath = "//button[@type= 'submit']", desc = "Firmaware update parameters update button")
    private static PageElement updateFirmwareConfirmBTN;

    @Element(xpath = "(//dmc-table-action[@icon='document'])[1]", desc = "last row of software deployed ")
    private static PageElement lastDeployedSoftwareDetailedIcon;

    @Element(xpath = "(//span[contains(., 'APP1')])", desc = "APP1 in deployment detail payload ")
    private static PageElement app1Deployment;

    @Element(xpath = "(//label[contains(.,' Options ')])//div[@class='-icon']", desc = "flag options in deployment ")
    private static PageElement optionsFlag;
    @Element(xpath = "//div[contains(@class,'ace_line')]", desc = "Options payload text insert ")
    private static PageElement firstRowIntTextarea;
    @Element(xpath = "//dmc-radio-group-option[contains(.,' Global ')]", desc = "Global flag on software update ")
    private static PageElement globalFlag;
    @Element(xpath = "//div[contains(text(), '1.1') and @class='-option-label']", desc = "version1.1 option to select")
    private static PageElement version11OptionToSelect;
    @Element(xpath = "//div[contains(text(), '1.2') and @class='-option-label']", desc = "version1.2 option to select")
    private static PageElement version12OptionToSelect;

    @Element(xpath = "//dmc-dummy-input//div[contains(text(), ' App Name... ')]", desc = "app name box")
    private static PageElement appNameBoxSelection;

    @Element(xpath = "//dmc-dummy-input//div[contains(text(), ' Version... ')]", desc = "Version box")
    private static PageElement versionBoxSelection;

    @Element(xpath = "(//div[contains(text(), 'APP2') and @class='-option-label'])[2]", desc = "app2 option to select")
    private static PageElement app2OptionToSelect;

    @Element(xpath = "(//div[contains(text(), '1.0') and @class='-option-label'])[2]", desc = "version1 option to select")
    private static PageElement version1OptionToSelectSecondRow;

    @Element(xpath = "//button[contains(., 'Reset')]", desc = "reset Button")
    private static PageElement resetBTN;

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh Deployment History Button")
    private static PageElement refreshDeploymentHistoryBTN;

    @Element(xpath = "//i[@dmcicon='search']", desc = "search Deployment Hisotory Button")
    private static PageElement searchDeploymentHistoryBTN;


    @Element(xpath = "//h2[contains(., 'Searching Filters')]", desc = "Searching Filters Title")
    private static PageElement searchingFiltersTitle;

    @Element(xpath = "//h4[contains(., 'Packages To Install')]//ancestor::div[@class='row mt-5 ng-star-inserted']/following-sibling::mat-list[1]/div//i[@class = 'dmc-icon-circle -remove-icon dmc-icon__trash dmc-icon']", desc = "Delete icon packages to install search filter ")
    private static PageElement deleteFilterPackagesIcon;

    @Element(xpath = "//h4[contains(., 'Packages To Install')]//ancestor::div[@class='row mt-5 ng-star-inserted']/following-sibling::mat-list[2]/div//i[@class = 'dmc-icon-circle -remove-icon dmc-icon__trash dmc-icon']", desc = "Delete icon current stak search filter")
    private static PageElement deleteFilterCurrentStackIcon;

    @Element(xpath = "//dmc-form-field-label[contains(.,'Status')]/following-sibling::dmc-select", desc = "Status filter dropdown")
    private static PageElement statusFilterDropdown;

    @Element(xpath = "//div[contains(text(),'Completed')]", desc = "completeStatus")
    private static PageElement completeStatusValue;

    @Element(xpath = "//i[@class='dmc-icon__search dmc-icon']", desc = "search buttoon Deployment with filter")
    private static PageElement searchFilterBTN;

    @Element(xpath = "//table[@id='dmc-table-gateway-deployment-history']", desc = "history table of deployment")
    private static PageElement deploymentHistoryTable;

    @Element(xpath = "//h2[contains(.,'Deployment Details')]", desc = "title Deployment Details")
    private static PageElement deploymentDetailsTitle;

    @Element(xpath = "//div[@class='--complete -status-banner' and contains(., 'Deployment Status: Completed')]", desc = "banner complete install")
    private static PageElement bannerCompleteInstall;

    @Element(xpath = "//button[contains(., 'Back')]", desc = "back Button")
    private static PageElement backButton;

    @Element(xpath = "//span[contains(text(),'Renew gateway certificate')]/preceding-sibling::div", desc = "checkbox to flag renew gateway option")
    private static PageElement checkboxRenewGateway;

    @Element(xpath = "//button[contains(text(),'Renew')]", desc = "renew button")
    private static PageElement renewBTN;

    @Element(xpath = "//button[@class='mat-tooltip-trigger dmc-fab']", desc = "three dots button")
    private static PageElement threeDotsButton;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(@class,'border-success') and contains(., 'Last Collect Logs invocation') and contains(., 'Enabled')]", desc = "last collect logs enabled")
    private static PageElement lastCollectLogsEnabled;

    @Element(xpath = "(//span[contains(., 'APP2')])", desc = "APP2 in deployment detail payload ")
    private static PageElement app2Deployment;

    @Element(xpath = "//td[contains(., ' Test_Concept-01_thing1')]//following-sibling::td//i[@class='dmc-icon__more-vertical dmc-icon']", desc = "show details Test_Concept-01_thing1")
    private static PageElement showDetailsConcept01Thing1BTN;

    @Element(xpath = "//td[contains(., ' Test_Concept-04_thing4')]//following-sibling::td//i[@class='dmc-icon__more-vertical dmc-icon']", desc = "show details Test_Concept-04_thing4")
    private static PageElement showDetailsConcept04Thing4BTN;

    @Element(xpath = "//td[contains(., 'Test_Concept-04_thing4')]", desc = "Test_Concept-04_thing4 row in thing list")
    private static PageElement thing4TestConcept04;

    @Element(xpath = "//button[contains(.,'Deploy') and @type = 'button']", desc = "confirm deploy button")
    private static PageElement confirmDeployBTN;

    @Element(xpath = "//h2[contains(.,'Details')]", desc = "Details in gateway info icon")
    private static PageElement detailsPage;

    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])", desc = "check the presence of the activity")
    private static PageElement activityTestConcept9;

    @Element(xpath = "//input[@placeholder='Maker']", desc = "input box maker")
    private static PageElement inputBoxMaker;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Latitude')]/parent::dmc-form-field//input", desc = "input box latitude")
    private static PageElement inputBoxLatitude;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Longitude')]/parent::dmc-form-field//input", desc = "input box longitude")
    private static PageElement inputBoxLongitude;

    @Element(xpath =  "(//input[@placeholder='Minutes'])[1]", desc = "From minutes input box in calendar selection")
    private static PageElement minutesInputBoxFrom;

    @Element(xpath =  "(//input[@placeholder='Minutes'])[2]", desc = "From minutes input box in calendar selection")
    private static PageElement minutesInputBoxTo;

    @Element(xpath =  "(//input[@placeholder='Hours'])[1]", desc = "From minutes input box in calendar selection")
    private static PageElement hoursInputBoxFrom;

    @Element(xpath =  "(//input[@placeholder='Hours'])[2]", desc = "From minutes input box in calendar selection")
    private static PageElement hoursInputBoxTo;

    @Element(xpath = "(//div[@class='-datetime-range-picker'])[1]", desc="deployment start range")
    private static PageElement deploymentStartRange;

    @Element(xpath = "(//div[@class='-datetime-range-picker'])[2]", desc="deployment end range")
    private static PageElement deploymentEndRange;

    @Element(xpath = "(//div[@class='-days']//div[contains(text(), ' 15 ')])[1]", desc = "fifteenth day on previous month selection date  ")
    private static PageElement fifteenthDayPreviousMonthFrom;

    @Element(xpath = "//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'To')]", desc = "previous day from today in FROM tab active")
    private static PageElement toTabsIntoCalendar;

    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Now')]" , desc= "button Now into calendar")
    public static PageElement buttonNowIntoCalendar;

    @Element(xpath = "(//div[@class='-controls']//button[contains(text(), 'Confirm')])[1]" , desc= "button Confirm into calendar start")
    public static PageElement buttonConfirmIntoCalendarStart;

    @Element(xpath = "(//div[@class='-controls']//button[contains(text(), 'Confirm')])[2]" , desc= "button Confirm into calendar end")
    public static PageElement buttonConfirmIntoCalendarEnd;

    @Element(xpath = "(//div[@class='-picker-date']//div[@class='-prev']/i[@dmcicon='chevron-left'])[3]", desc = "Left btn on month selection date in Connectivity History ")
    private static PageElement leftMonthBTNFromEnd;

    @Element(xpath = "(//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'To')])[2]", desc = "previous day from today in FROM tab active")
    private static PageElement toTabsIntoCalendarEnd;

    @Element(xpath = "(//div[@class='-controls']//button[contains(text(), 'Now')])[2]" , desc= "button Now into calendar")
    public static PageElement buttonNowIntoCalendarEnd;

    @Element(xpath = "(//div[@class='-days']//div[contains(text(), ' 15 ')])[3]", desc = "fifteenth day on previous month selection date  ")
    private static PageElement fifteenthDayPreviousMonthFromEnd;

    @Element(xpath = "//table[@id='dmc-table-direct-thing-deployment-history']", desc = "history table of deployment")
    private static PageElement deploymentHistoryTableDirectThings;

    @Element(xpath =  "//span[contains(.,'Things')]", desc = "Landing page of things typed devices")
    private static PageElement thingTypedDeviceLandingPage;

    @Element(xpath = "//div[contains(@class, 'panel-default')]//button[contains(.,'Cancel')]", desc = "cancel button panel")
    private static PageElement cancelBTNpanel;
    @Element(xpath =  "//td[contains(.,' Test_Concept-01_thing1')]/preceding-sibling::td", desc = "Radio button Test_Concept-01_thing1 in renew certificate")
    private static PageElement renewThing1RadioBTN;
    @Element(xpath =  "//td[contains(.,' Test_Concept-01_thing2')]/preceding-sibling::td", desc = "Radio button Test_Concept-01_thing2 in renew certificate")
    private static PageElement renewThing2RadioBTN;
    @Element(xpath =  "//td[contains(.,' Test_Concept-01_thing3')]/preceding-sibling::td", desc = "Radio button Test_Concept-01_thing3 in renew certificate")
    private static PageElement renewThing3RadioBTN;
    @Element(xpath =  "//th[contains(.,' Device ID ')]/preceding-sibling::th", desc = "Radio button devices in renew certificate")
    private static PageElement renewDevicesRadioBTN;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Maker')]", desc = "maker it")
    private static PageElement maker;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Environment Prefix')]", desc = "enviroment prefix")
    private static PageElement environmentPrefix;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Serial Number')]", desc = "serial number")
    private static PageElement serialNumber;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), ' Geo-Coordinates (lon, lat)')]", desc = "geolocalization")
    private static PageElement geolocalization;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Type')]", desc = "type")
    private static PageElement type;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Thing ID')]", desc = "thing id")
    private static PageElement thingID;

    @Element(xpath = "//span[contains(., ' Deactivate ')]//parent::button", desc = "deactivate a thing button")
    private static PageElement deactivateAthingBTN;

    @Element(xpath = "//dmc-form-field-label[text()=' Log Severity ']/following-sibling::dmc-multi-select//dmc-multi-select-facade/div[@class='dmc-facade-toggle']", desc = "Log severity field")
    private static PageElement logSeverityField;

    @Element(xpath = "//dmc-form-field-label[text()=' Log Category ']/following-sibling::dmc-multi-select//dmc-multi-select-facade/div[@class='dmc-facade-toggle']/i", desc = "Log category field")
    private static PageElement logCategoryField;

    @Element(xpath = "//dmc-form-field-label[contains(.,'Period')]/following-sibling::input", desc = "Log period field")
    private static PageElement logPeriodField;

    @Element(xpath = "//dmc-form-field-label[contains(.,' Timeout ')]/following-sibling::input", desc = "Log timeout field")
    private static PageElement logTimeOutField;

    @Element(xpath = "//button[contains(.,'Send')]", desc = "send BTN")
    private static PageElement sendBTN;

    @Element(xpath = "//dmc-multi-select-option/div[contains(.,'INFO')]", desc = "info selectable in log severity field")
    private static PageElement infoOption;

    @Element(xpath = "//dmc-multi-select-option/div[contains(.,' APPLICATION')]", desc = "application selectable in log category field")
    private static PageElement applicationOption;

    @Element(xpath = "//div[@class='-right']/i[@dmcicon='info']", desc = "info BTN of a specific device below the landing page title after device details BTN is clicked")
    private static PageElement infoBTN;

    @Element(xpath = "//div[contains(.,' management_mode')]/following-sibling::div[text()=' jobs ']", desc = "job typed management mode")
    private static PageElement jobTypedManagementMode;

    @Element(xpath = "//div[@id='dmc-affix-safenet']", desc = "Log severity field")
    private static PageElement logSafenet;

    @Element(xpath = "//div[contains(@class,'cdk-overlay-backdrop cdk-overlay-dark-backdrop cdk-overlay-backdrop-showing')]", desc = "background")
    private static PageElement deviceDetailsBackground;

    public static PageElement getBackBTNInDetails() {
        return backBTNInDetails;
    }

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), ' Geo-Coordinates (lon, lat)')]//following-sibling::div", desc = "geolocalization")
    private static PageElement coordinatesValues;

    public static PageElement getExpirationDate() {
        return expirationDate;
    }

    @Element(xpath = "//div[contains(@class, '-label') and contains(.,'Cert. Expiration Date')]/following-sibling::div", desc = "expiration Date of the device")
    private static PageElement expirationDate;

    @Element(xpath = "//i[@dmcicon='info']", desc = "info icon detail")
    private static PageElement infoIconDetails;

    @Element(xpath = "//h2[@class='-title' and contains(.,'Details')]", desc = "title details page")
    private static PageElement detailsTitle;

    public static PageElement getDeviceTypeLabelValue() {
        return deviceTypeLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,'Device Type')]/following-sibling::div[contains(@class, '-content')]", desc = "Device type value")
    private static PageElement deviceTypeLabelValue;

    public static PageElement getGeoCoordinatesLabelValue() {
        return geoCoordinatesLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,'Geo-Coordinates')]/following-sibling::div[contains(@class, '-content')]", desc = "Geo coordinates value")
    private static PageElement geoCoordinatesLabelValue;
    @Element(xpath = "//td[contains(., 'Test_Concept-02_thing2')]", desc = "Test_Concept-02_thing2 row in thing list")
    private static PageElement thing2TestConcept02;

    @Element(xpath = "//td[contains(., ' Test_Concept-02_thing2')]//following-sibling::td//i[@class='dmc-icon__more-vertical dmc-icon']", desc = "show details Test_Concept-02_thing2")
    private static PageElement showDetailsConcept02Thing2BTN;
    public static PageElement getManagementModeLabelValue() {
        return managementModeLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,' management_mode')]/following-sibling::div[contains(@class, '-content')]", desc = "management mode value")
    private static PageElement managementModeLabelValue;

    public static PageElement getMakerLabelValue() {
        return makerLabelValue;
    }

    @Element(xpath = "(//div[contains(@class,'-label') and contains(.,' Maker')]/following-sibling::div[contains(@class, '-content')])[2]", desc = "maker value")
    private static PageElement makerLabelValue;

    public static PageElement getSerialNumberLabelValue() {
        return serialNumberLabelValue;
    }

    @Element(xpath = "(//div[contains(@class,'-label') and contains(.,'Serial Number')]/following-sibling::div[contains(@class, '-content')])[2]", desc = "Serial number value")
    private static PageElement serialNumberLabelValue;

    public static PageElement getPkiEnabledLabelValue() {
        return pkiEnabledLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,' pki_enabled')]/following-sibling::div[contains(@class, '-content')]", desc = "pki enabled value")
    private static PageElement pkiEnabledLabelValue;

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,'sw_is_gg_installed')]/following-sibling::div[contains(@class, '-content')]", desc = "pki enabled value")
    private static PageElement swGGInstalledLabelValue;

    @Element(xpath = "//button[text()=' Update ']", desc = "pki enabled value")
    private static PageElement updateBTNforFormwareUpdate;

    @Element(xpath = "//div[contains(text(), '2.0') and @class='-option-label']", desc = "version2 option to select")
    private static PageElement version2OptionToSelect;

    @Element(xpath = "//div[contains(text(), '1.2') and @class='-option-label']", desc = "version2 option to select")
    private static PageElement version1_2OptionToSelect;

    @Element(xpath = "//div[contains(text(), '3.0') and @class='-option-label']", desc = "version3 option to select")
    private static PageElement version3OptionToSelect;

    @Element(xpath = "//span[contains(text(), 'name')]//following-sibling::span[contains(text(), 'APP1')]", desc = "app1AsTheValueForNameParameter")
    private static PageElement app1AsTheValueForNameParameter;

    @Element(xpath = "//span[contains(text(), 'version')]//following-sibling::span[contains(text(), '1.0')]", desc = "versionIs 1.0")
    private static PageElement versionIs1_0;

    @Element(xpath = "//span[contains(text(), 'version')]//following-sibling::span[contains(text(), '2.0')]", desc = "versionIs 2.0")
    private static PageElement versionIs2_0;

    @Element(xpath = "//span[contains(text(), 'version')]//following-sibling::span[contains(text(), '3.0')]", desc = "versionIs3.0")
    private static PageElement versionIs3_0;

    @Element(xpath = "(//i[@class='dmc-icon__document dmc-icon'])[1]", desc = "latestDeploymentDetail.0")
    private static PageElement latestDeploymentDetail;

    public static PageElement getDeleteCertificate() {
        return deleteCertificate;
    }

    public static PageElement getForceDelete() {
        return forceDelete;
    }


    public static PageElement getDeleteConfirm() {
        return deleteConfirm;
    }

    @Element(xpath = "(//button[@withicon='left'])[2]", desc = "Back button")
    private static PageElement backBTNdetailsView;

    public static PageElement getSwGGInstalledLabelValue() {
        return swGGInstalledLabelValue;
    }
    public static PageElement getSwAppVersionLabelValue() {
        return swAppVersionLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,' sw_APP1')]/following-sibling::div[contains(@class, '-content')]", desc = "App version value")
    private static PageElement swAppVersionLabelValue;

    public static PageElement getGwTypeLabelValue() {
        return gwTypeLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,'Gateway Type')]/following-sibling::div[contains(@class, '-content')]", desc = "Gw type value")
    private static PageElement gwTypeLabelValue;

    public static PageElement getTypeLabelValue() {
        return typeLabelValue;
    }

    @Element(xpath = "(//div[contains(@class,'-label') and normalize-space()='Type']/following-sibling::div[contains(@class, '-content')])[1]", desc = "(DirectThing page) type value")
    private static PageElement typeLabelValue;

    public static PageElement getGeolocalizationLabelValue() {
        return geolocalizationLabelValue;
    }

    @Element(xpath = "(//div[contains(@class,'-label') and contains(.,'Geolocalization')]/following-sibling::div[contains(@class, '-content')])[1]", desc = "Geo coordinates value")
    private static PageElement geolocalizationLabelValue;

    public static PageElement getSwThingTypeLabelValue() {
        return swThingTypeLabelValue;
    }

    @Element(xpath = "//div[contains(@class,'-label') and contains(.,' Sw Thing Type')]/following-sibling::div[contains(@class, '-content')]", desc = "Sw Thing type value")
    private static PageElement swThingTypeLabelValue;

    public static PageElement getMonitoringFlag() {
        return monitoringFlag;
    }

    @Element(xpath = "//i[@class='dmc-icon ng-star-inserted dmc-icon__plus']", desc = "close floating buttonn in things page")
    private static PageElement closeFloatingBTN;

    @Element(xpath = "//span[contains(., 'Show Logs')]//ancestor::button", desc = "show logs in thing details")
    private static PageElement showLogsThing;
    @Element(xpath = "//span[contains(., 'Update')]//ancestor::button", desc = "Update button in thing details")
    private static PageElement updateThingBTN;
    @Element(xpath = "//span[contains(., 'Tail Logs')]//ancestor::button", desc = "Tail Logs button in thing details")
    private static PageElement tailLogsBTN;
    @Element(xpath = "//span[contains(., 'Connectivity History')]//ancestor::button", desc = "Connectivity History button in thing details")
    private static PageElement connHistoryBTN;
    @Element(xpath = "//span[contains(., 'Firmware Update')]//ancestor::button", desc = "Firmware update button in thing details")
    private static PageElement firmwareUpdateThingBTN;
    @Element(xpath = "//span[contains(., 'More info')]//ancestor::button", desc = "More info button in thing details")
    private static PageElement moreInfoThingBTN;


    /*-----------Activities Tab-----------*/
    @Element(xpath = "//h2[contains(.,'Activities')]", desc = "Tab Activities Title")
    private static PageElement tabActivitiesTitle;

    @Element(xpath = "//i[@class='dmc-icon__document dmc-icon']", desc = "Show Details Activity")
    private static PageElement showDetailsActivity;

    @Element(xpath = "//i[@class='dmc-icon__play dmc-icon']", desc = "Play Activity")
    private static PageElement playActivity;

    @Element(xpath = "//i[@class='dmc-icon__copy dmc-icon']", desc = "Copy Activity")
    private static PageElement copyActivity;

    @Element(xpath = "//i[@class='dmc-icon__pencil dmc-icon']", desc = "Edit Activity")
    private static PageElement editActivity;

    @Element(xpath = "//i[@class='dmc-icon__trash dmc-icon']", desc = "Delete Activity")
    private static PageElement deleteActivity;

    @Element(xpath = "//i[@class='dmc-icon__plus dmc-icon ng-star-inserted']", desc = "New Activity")
    private static PageElement newActivityButton;

    @Element(xpath = "//i[@class='dmc-icon__plus dmc-icon ng-star-inserted']", desc = "New Activity")
    private static PageElement activity2805;

    @Element(xpath = "//dmc-details-grid-item[9]", desc = "Installed software for Gateway")
    private static PageElement gatewayPackageList;

    @Element(xpath = "//dmc-details-grid-item[10]", desc = "Installed software for Direct Thing")
    private static PageElement directThingPackageList;

    @Element(xpath = "//a[@class='--more-packages ng-star-inserted']", desc = "more packages button")
    private static PageElement pgButton;

    @Element(xpath = "//h4['Installed Packages']", desc = "Installed Packages Details")
    private static PageElement packageDetails;

    @Element(xpath = "//div[@class='-header']//div[contains(.,'Software Type')]", desc = "Software Type Column")
    private static PageElement softwareTypeColumn;

    @Element(xpath = "//div[@class='-header']//div[contains(.,'Deploy Type')]" , desc = "Deploy Type Column")
    private static PageElement deployTypeColumn;

    @Element(xpath = "//div[@class='-item-name']/text()[contains(.,'END')]", desc = "END column")
    private static PageElement endColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Software Type ')]/i", desc = "Software Type tooltip")
    private static PageElement SoftwareTypeTP;
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Deploy Type')]/i", desc = "Software Type tooltip")
    private static PageElement DeployTypeTP;
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Start')]/i", desc = "Software Type tooltip")
    private static PageElement StartTP;
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Duration')]/i", desc = "Software Type tooltip")
    private static PageElement DurationTP;
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Latest')]/i", desc = "Software Type tooltip")
    private static PageElement LatestTP;
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(.,' Status')]/i", desc = "Software Type tooltip")
    private static PageElement StatusTP;
    @Element(xpath = "//button[@class='--accent --size-regular --width-large'][contains(.,'Close')]", desc = "Tooltip Close button")
    private static PageElement closeTPBtt;
    public static PageElement getCloseTPbtt(){return closeTPBtt;}
    @Element(xpath = "(//table//tr[1]//td[7])//i[@class='dmc-icon__document dmc-icon']", desc = "Deployment History Details")
    private static PageElement historyDetailsBtt;

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
}
