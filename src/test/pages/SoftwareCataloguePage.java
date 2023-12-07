package test.pages;

import cucumber.api.java.an.E;
import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class SoftwareCataloguePage {


    @Element(xpath = "//h2[contains(text(), 'Software Catalogue')]", desc = "Software Catalogue lending page title ")
    private static PageElement softwareCatalogueLandingPageTitle;
    @Element(xpath = "//div[@class='-info ng-star-inserted']/h2", desc = "App name")
    private static PageElement softwareCatalogueAppName;
    public static PageElement getSoftwareCatalogueAppName(){return softwareCatalogueAppName;}

    @Element(xpath = "//input[@type=\"search\"]", desc = "SearchBar")
    private static PageElement searchBar;


    @Element(xpath = "//i[@dmcicon=\"refresh\"]", desc = "Refresh Button")
    private static PageElement refreshBtn;
    @Element(xpath = "//mat-spinner", desc = "Loader animation container")
    private static PageElement loaderAnimationContainer;
    @Element(xpath = "//dmc-dummy-input[@class=\"-facade --size-full --disabled\"]", desc = "Software Extension input voice disabled")
    private static PageElement softwareExtensionDisabled;
    @Element(xpath = "//i/ancestor::button[@class=\"-back --outline-primary --size-regular --with-icon-left ng-star-inserted\"]", desc = "Back Button")
    private static PageElement backBtn;
    public static PageElement getBackBtn(){return backBtn;}
    @Element(xpath = "//button[contains(text(), 'Save')]", desc = "Save button")
    private static PageElement saveBtn;
    @Element(xpath = "//i[@class=\"dmc-icon__upload dmc-icon-size-large dmc-icon ng-star-inserted\"]/ancestor::button", desc = "Upload Button on Software Catalogue Page")
    private static PageElement uploadBtn;
    //filter
    @Element(xpath = "//i[@class='dmc-icon__chevron-down dmc-icon-size-large dmc-icon']", desc = "expand filter box")
    private static PageElement fliterExpand;
    @Element(xpath = "//dmc-form-field-label[contains(.,'Device Type')]/following-sibling::dmc-select//i", desc = "device type select box")
    private static PageElement deviceTypeBox;
    @Element(xpath = "//div[contains(.,'Direct Thing ')]/following-sibling::div[contains(.,' Thing ')]", desc = "device type thing")
    private static PageElement deviceTypeThing;
    @Element(xpath = "//button[@type='submit' and contains(.,' Confirm ')]", desc = "confirm filter button")
    private static PageElement confirmButton;



    public static PageElement getSoftwareCatalogueLandingPageTitle() {return softwareCatalogueLandingPageTitle;}

    @Element(xpath = "(//div[@class='-handle-icon'])[1]", desc = "Functions icon that is present on the first software card")
    private static PageElement iconFunctionsSoftware;
    @Element(xpath = "//dmc-software-card-action[contains(text(), 'Detail')]", desc = "Detail voice present on functions icon of software card")
    private static PageElement detailFunctionOnSoftwareCard;
    public static PageElement getDetailFunctionOnSoftwareCard(){return detailFunctionOnSoftwareCard;}
    @Element(xpath = "//dmc-software-card-action[contains(text(), 'Edit')]", desc = "Edit voice oice present on functions icon of software card")
    private static PageElement editFunctionOnSoftwareCard;
    @Element(xpath = "//dmc-software-card-action[contains(text(), 'Download')]", desc = "Download Voice present on functions icon of software card")
    private static PageElement downloadFunctionOnSoftwareCard;
    @Element(xpath = "//dmc-software-card-action[contains(text(), 'Delete')]", desc = "Delete voice present on functions icon of software card")
    private static PageElement deleteFunctionOnSoftwareCard;

    @Element(xpath = "//h2[contains(text(), ' Delete software catalogue ')]/ancestor::aside", desc = "Popup Download Software Catalogue")
    private static PageElement popupDownloadSoftwareCatalogue;
    @Element(xpath = "//h2[contains(text(), ' Delete software catalogue ')]/ancestor::aside", desc = "Popup Download Software Catalogue")
    private static PageElement popupDeleteSoftwareCatalogue;

    @Element(xpath = "//h2[@class=\"-title\" and contains(text(), \"New software catalogue\")]", desc = "New Software Catalogue page title")
    private static PageElement titleNewSoftwareCataloguePage;
    @Element(xpath = "//dmc-software-card", desc = "software number for counting method")
    private static PageElement softwareNumber;

    public static PageElement getSoftwareNumber() {
        return softwareNumber;
    }

    @Element(xpath = "//span[contains(text(), 'ENELINT')]", desc = "info user logged in")
    private static PageElement infoUserLoggedIn;
    @Element(xpath = "//span[contains(text(), 'Language') or contains(text(), 'Lingua')]", desc = "Language sub option into info user button")
    private static PageElement languageSubOption;
    @Element(xpath = "//button[contains(text(), 'English')]", desc = "Button English sub option")
    private static PageElement buttonEnglishSubOption;
    @Element(xpath = "//button[contains(text(), 'Italiano')]", desc = "Button Italiano sub option")
    private static PageElement buttonItalianoSubOption;
    @Element(xpath = "//*[contains(text(), 'New software package')]", desc = "New software package title")
    private static PageElement newSoftwarePackage;
    @Element(xpath = "//*[contains(text(),'Device Type')]/following-sibling::*//i", desc = "New software package title")
    private static PageElement deviceTypeDropdown;
    @Element(xpath = "//*[@class='-option-label' and contains(text(),'Gateway')]", desc = "Gateway Option")
    private static PageElement gatewayOption;
    @Element(xpath = "//*[contains(text(),'Software Type')]/following-sibling::*//input", desc = "Software Type Input")
    private static PageElement softwareTypeInput;
    @Element(xpath = "//div[@class='-option-label' and text()=' testConcept ']", desc = "Software Type Input option")
    private static PageElement testConceptOption;
    @Element(xpath = "//*[contains(text(),'Appname')]/following-sibling::*//input", desc = "Appname Input")
    private static PageElement appnameInput;
    @Element(xpath = "//span[contains(@class,'mat-option-text')]", desc = "First Dropdown Input")
    private static PageElement genericDropdownInput;
    @Element(xpath = "//*[contains(text(),'Version')]/following-sibling::*//input", desc = "Version Input")
    private static PageElement versionInput;
    @Element(xpath = "//*[contains(text(),'Software extension')]/following-sibling::*//i", desc = "Software extension accordion")
    private static PageElement softwareExtensionAccordion;
    @Element(xpath = "//*[contains(text(),'.zip')]", desc = ".zip option")
    private static PageElement zipOption;
    @Element(xpath = "//*[contains(text(),'.rar')]", desc = ".rar option")
    private static PageElement rarOption;
    @Element(xpath = "//*[contains(text(),'Architecture')]/following-sibling::input", desc = "Architecture input")
    private static PageElement architectureInput;
    @Element(xpath = "//*[contains(text(),'Description')]/following-sibling::input", desc = "Description input")
    private static PageElement descriptionInput;
    @Element(xpath = "//input[@type='file']", desc = "File input")
    private static PageElement fileInput;
    @Element(xpath = "//button[contains(text(),'Save')]", desc = "Save button")
    private static PageElement saveButton;
    @Element(xpath = "//*[contains(text(),'Software catalogue successfully uploaded')]/following-sibling::button", desc = "Software catalogue successfully uploaded close button")
    private static PageElement softwareCatalogueSuccessfullyUploaded;
    @Element(xpath = "//*[contains(text(),'The software extension and the file extension are not the same')]", desc = "Wrong type message")
    private static PageElement wrongTypeMessage;

    public static PageElement getRefreshBtn() {
        return refreshBtn;
    }

    @Element(xpath = "//div[contains(.,'test_2913')]//div[@class='-handle']", desc = "test_2913 handle")
    private static PageElement test_2913Handle;
    @Element(xpath = "//dmc-software-card-action[contains(.,'Delete')]", desc = "software delete btt")
    private static PageElement softwareDeleteBtt;
    public static PageElement getSoftwareDeleteBtt(){ return softwareDeleteBtt;}
    @Element(xpath = "//aside//button[contains(.,'Confirm')]", desc = "software delete confirm")
    private static PageElement softwareDeleteConfirm;
    public static PageElement getSoftwareDeleteConfirm(){ return softwareDeleteConfirm;}
    @Element(xpath = "//button[@class='-dismiss']", desc = "Remove confirmation Delete button")
    private static PageElement toastMessageClose;
    public static PageElement getToastMessageClose(){ return toastMessageClose;}

}
