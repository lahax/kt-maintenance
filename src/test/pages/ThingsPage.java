package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class ThingsPage {

    public static String allthingPresent = "//tbody/tr";

    @Element(xpath = "//div[contains(@class, '-info')]/span[contains(.,'Things')]", desc = "title section Things")
    private static PageElement titleSectionThings;

    @Element(xpath = "//button//span[contains(.,'Connectivity History')]/parent::button", desc = "Connectivity Hidtory button ")
    private static PageElement connectivityHistoryButton;

    /*---------------------- All elements contain after click "show details" through THING --------------------------- */

    @Element(xpath = "//span[(text()='Update')]//parent::button", desc = "Button to update thing")
    private static PageElement updateThingButton;

    @Element(xpath = "//button[contains(., 'Start')]", desc = "Button to update thing")
    private static PageElement startButton;
    /*---------------------- All elements contain after click "show details" trough DIRECT THING --------------------------- */

    @Element(xpath = "//dmc-direct-thing-detail-general//span[text()=' Update ']//ancestor::dmc-command-button", desc = "Button to update thing")
    private static PageElement updateDirectThingButton;

    @Element(xpath = "//input[@type='search' and @placeholder='Search by ID, SERIAL, ALIAS']", desc = "Searchbox, search by ID, Serial,Alias")
    private static PageElement searchbox;

    @Element(xpath = "//td[contains(text(), 'Test_Concept-01_thing1')]", desc = "Test_Concept01_thing1")
    private static PageElement testConcept01thing1;

    @Element(xpath = "//td[contains(text(), 'Test_Concept-01_thing2')]", desc = "Test_Concept01_thing2")
    private static PageElement testConcept01thing2;
    @Element(xpath = "//td[contains(.,' Test_Concept-51_thing1')]//preceding-sibling::td/dmc-table-selector", desc = "Test_Concept01_thing2 Select")
    private static PageElement testConcept01thing1Select;
    @Element(xpath = "//td[contains(.,' Test_Concept-51_thing2')]//preceding-sibling::td/dmc-table-selector", desc = "Test_Concept01_thing2 Select")
    private static PageElement testConcept01thing2Select;
    @Element(xpath = "//td[contains(.,' Test_Concept-55_thing2')]//preceding-sibling::td/dmc-table-selector", desc = "Test_Concept01_thing2 Select")
    private static PageElement testConcept55thing2Select;
    @Element(xpath = "//td[contains(.,' Test_Concept-55_thing1')]//preceding-sibling::td/dmc-table-selector", desc = "Test_Concept01_thing2 Select")
    private static PageElement testConcept55thing1Select;
    @Element(xpath = "//td[contains(.,' GatewayConceptTest59_thing1')]//preceding-sibling::td/dmc-table-selector", desc = "GatewayConceptTest59_thing1 Select")
    private static PageElement gatewayConceptTest59thing1Select;


    @Element(xpath = "//td[@class='--selectable-column ng-star-inserted']", desc = "test concept01 thing2 device detail icon")
    private static PageElement things;
    @Element(xpath = "//td[contains(.,' Test_Concept-51_thing1')]", desc = "test concept51thing1 device")
    private static PageElement TestConcept51Thing1;

    @Element(xpath = "//td[contains(.,' GatewayConceptTest57_thing1')]", desc = "GatewayConceptTest57 thing1 device")
    private static PageElement gatewayConceptTest57Thing1;

    @Element(xpath = "//dmc-table-action[@icon='more-vertical']", desc = "test concept01 thing1 device detail icon")
    private static PageElement thingDetails;

    /*---------------------------Table things---------------------------*/
    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Thing ID ']", desc = "Thing ID Column")
    private static PageElement thingIDColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Software Thing Type ']", desc = "Software Type Column")
    private static PageElement softwareTypeColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Serial ']", desc = "Serial Column")
    private static PageElement serialColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Type ']", desc = "Type Column")
    private static PageElement typeColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Model ']", desc = "Model Column")
    private static PageElement modelColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(., 'Certificate expiration')]", desc = "Certificate Column")
    private static PageElement certificateColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and contains(., 'Alias')]", desc = "Alias Column")
    private static PageElement aliasColumn;

    @Element(xpath = "//div[@class='--align-left --ellipsis ng-star-inserted' and text()=' Status ']", desc = "Status Column")
    private static PageElement statusColumn;

    @Element(xpath = "//div[@class='mat-tooltip-trigger -handle mt-1']", desc = "Manage Column")
    private static PageElement manageColumn;

    /*---------------------------Show details menu---------------------------*/
    @Element(xpath = "//span[text()= 'More info']", desc = "More info button")
    private static PageElement moreInfo;

    @Element(xpath = "//span[text()= 'Update']", desc = "Update button")
    private static PageElement update;

    /*---------------------------Thing detail---------------------------*/
    @Element(xpath = "//h2[@class='-title' and contains(., 'Thing Detail')]", desc = "Detail Thing Title")
    private static PageElement detailThingTitle;

    @Element(xpath = "//h4[contains(., 'The thing is')]/dmc-badge", desc = "Label Status")
    private static PageElement labelStatus;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Maker')]", desc = "Label Maker")
    private static PageElement labelMaker;

    @Element(xpath = "//dmc-details-grid-item/div[contains(text(), 'mqtts')]/preceding-sibling::div[contains(text(), 'Type')]", desc = "Label Type")
    private static PageElement labelType;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Thing ID')]", desc = "Label Thing ID")
    private static PageElement labelThingID;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Model')]", desc = "Label Model")
    private static PageElement labelModel;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Serial Number')]", desc = "Label Serial Number")
    private static PageElement labelSerialNumber;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Thing Alias')]", desc = "Label Thing Alias")
    private static PageElement labelThingAlias;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Expiration Date')]", desc = "Label Certification Expiration Date")
    private static PageElement labelCertificateExpiration;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Certification Authority')]", desc = "Label Certification Authority")
    private static PageElement labelCertificateAuthority;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Geolocalization')]", desc = "Label Geolocalization")
    private static PageElement labelGeolocalization;

    @Element(xpath = "//div[contains(@class, 'dmc-card')]//div[contains(text(), 'Software Thing Type')]", desc = "Label Software Thing Type")
    private static PageElement labelSoftwareThingType;
    @Element(xpath = "//dmc-details-grid-item[contains(.,' sw_test-bia-app')]", desc = "Label Software App Type")
    private static PageElement labelSoftwareAppType;
    @Element(xpath = "//dmc-details-grid-item[contains(.,' THING_GENERIC ')]", desc = "Label Software App Type")
    private static PageElement labelSoftwareGenericType;

    /*---------------------------Update Thing detail---------------------------*/
    //TODO NON DOVREBBE ESSERE Update Thing ?
    @Element(xpath = "//h2[@class='-title' and contains(., 'Update thing')]", desc = "Update thing Title")
    private static PageElement updateThingTitle;

    @Element(xpath = "(//dmc-form-field-label[contains(., 'Model')])[2]", desc = "Model Form Title")
    private static PageElement modelFormTitle;

    @Element(xpath = "//input[@placeholder='Model']", desc = "Model Form Input")
    private static PageElement modelFormInput;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Maker')]", desc = "Maker Form Title")
    private static PageElement makerFormTitle;

    @Element(xpath = "//input[@placeholder='Maker']", desc = "Maker Form Input")
    private static PageElement makerFormInput;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Latitude')]", desc = "Latitude Form Title")
    private static PageElement latitudeFormTitle;

    @Element(xpath = "//input[@placeholder='Latitude']", desc = "Latitude Form Input")
    private static PageElement latitudeFormInput;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Longitude')]", desc = "Longitude Form Title")
    private static PageElement longitudeFormTitle;

    @Element(xpath = "//input[@placeholder='Longitude']", desc = "Longitude Form Input")
    private static PageElement longitudeFormInput;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Alias')]", desc = "Alias Form Title")
    private static PageElement aliasFormTitle;

    @Element(xpath = "//input[@placeholder='Alias']", desc = "Alias Form Title")
    private static PageElement aliasFormInput;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Serial Number')]", desc = "Update thing Title")
    private static PageElement serialNumberFormTitle;

    @Element(xpath = "//input[@placeholder='Serial Number']", desc = "Serial Number Form Input")
    private static PageElement serialNumberFormInput;

    @Element(xpath = "//div[contains(text(), 'Serial')]/following-sibling::div", desc = "Serial Number")
    private static PageElement serialNumberDetail;

    @Element(xpath = "//button[contains(.,'Update')]", desc = "Update button")
    private static PageElement updatedBTN;
    //Toaster messagess
    @Element(xpath = "//button[contains(.,'Update')]", desc = "Update button")
    private static PageElement toasterWait;
    @Element(xpath = "//span[contains(.,'Error while sending things activation command')]", desc = "Error things msg")
    private static PageElement toasterError;
    @Element(xpath = "//button[@class='-dismiss']", desc = "dismiss toaster")
    private static PageElement toasterDismiss;

    //Firmware Update
    @Element(xpath = "//h2[contains(.,'Firmware Update Parameters')]", desc = "Firmware update title")
    private static PageElement firmwareUpdateTitle;
    @Element(xpath = "//div[@class='-input' and contains(.,' App Name... ')]", desc = "app name input field")
    private static PageElement appInput;
    @Element(xpath = "//div[@class='-option-label' and contains(.,' firmware-upgrade-ocpp ')]", desc = "app name input field")
    private static PageElement appFirmUpgOCPP;
    @Element(xpath = "//div[@class='-input' and contains(.,' Version... ')]", desc = "app name input field")
    private static PageElement versionInput;
    @Element(xpath = "//div[@class='-option-label' and contains(.,'1.0')]", desc = "app name input field")
    private static PageElement version1Fuocpp;

    @Element(xpath = "//button[contains(.,' Update ')]", desc = "BUtton Update")
    private static PageElement updateButton;

    //align thing
    @Element(xpath = "//i[@class='dmc-icon__upload-file dmc-icon']", desc = "Align software button")
    private static PageElement alignButton;
    @Element(xpath = "//button[@type='button' and contains(.,' Confirm ')]", desc = "Button confirm")
    private static PageElement confirmButton;
}