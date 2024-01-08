package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class CampaignManagementView {

    @Element(xpath = "(//tr[contains(@class,'inserted')])[1]/td[2]", desc = "First Name Row")
    public static PageElement firstRowName;
    @Element(xpath = "//input[contains(@placeholder,'Gateway Id')]", desc = "Gateway ID Input")
    public static PageElement gatewayIdInput;
//    @Element(xpath = "//input[contains(@placeholder,'Gateway Id')]/ancestor::form//button[contains(text(), 'Confirm')]", desc = "Confirm Button")
//    public static PageElement confirmButton;
//    @Element(xpath = "//input[contains(@placeholder,'Gateway Id')]/ancestor::form//button[contains(text(), 'Clear')]", desc = "Clear Button")
//    public static PageElement clearButton;
    @Element(xpath = "//div[contains(text(),'Select option')]/following-sibling::i", desc = "Gateway Software Type Chevron")
    public static PageElement gatewaySoftwareType;
    @Element(xpath = "//div[contains(@class,'inserted')]/div[contains(@class,'option')]", desc = "Gateway Software Type Options")
    public static PageElement listOptionGatewaySoftware;
    @Element(xpath = "//*[contains(text(),'Custom query')]", desc = "Custom Query")
    public static PageElement customQuery;
    @Element(xpath = "//*[contains(text(),'Custom query')]/../following-sibling::i", desc = "Custom Query")
    public static PageElement customQueryChevron;
    @Element(xpath = "//div[contains(@class,'ace_line')]", desc = "Textarea Custom Query")
    public static PageElement firstRowIntTextarea;
    @Element(xpath = "//dmc-collapsable-card-action//button[contains(text(),'Confirm')]", desc = "Custom Query Button Confirm")
    public static PageElement customQueryConfirm;

    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'eig-cu')]", desc = "eig-cu option")
    public static PageElement eigCuOption;
    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'DIRECT_GENERIC')]", desc = "Generic direct option")
    public static PageElement genericDirectOption;
    @Element(xpath = "//div[contains(text(),'Select option')]/following-sibling::i", desc = "Thing Software Type Chevron")
    public static PageElement ThingSoftwareType;
    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'eig-cu')]/ancestor::form//button[contains(@type,'submit')]", desc = "Thing Software Type Confirm Button")
    public static PageElement thingSoftwareTypeConfirmButton;
    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'APP1')]", desc = "Firmware Update Button")
    public static PageElement app1;
    @Element(xpath = "//div[contains(@class,'input') and contains(text(),'App Name')]", desc = "Firmware Update Button")
    public static PageElement appNameDropdown;
    @Element(xpath = "//div[contains(@class,'input') and contains(text(),'Version')]", desc = "Version Dropdown")
    public static PageElement versionDropdown;
    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'1.0')]", desc = "1.0 Version")
    public static PageElement version1;
    @Element(xpath = "//button[contains(text(),'Update')]", desc = "Update Button")
    public static PageElement updateButton;


    public static String getAppOptionDropdown() {
        return appOptionDropdown;
    }

    public static void setAppOptionDropdown(String app) {
        String appOptionDropdown ="//div[contains(@class,'-option-label') and contains(text(),'%s')]";
        CampaignManagementView.appOptionDropdown = String.format(appOptionDropdown, app );
    }

    private static String appOptionDropdown = "";

    public static String getAppVersionDropdown() {
        return appVersionDropdown;
    }

    public static void setAppVersionDropdown(String version) {
        String appVersionDropdown = "//div[contains(@class,'-option-label') and contains(text(),'%s')]";
        CampaignManagementView.appVersionDropdown = String.format(appVersionDropdown, version);
    }

    private static String appVersionDropdown = "";

    public static PageElement getVersionDropdown() {
        return versionDropdown;
    }

    public static PageElement getAppNameDropdown() {
        return appNameDropdown;
    }


    public static PageElement getButtonAddNewPackage() {
        return buttonAddNewPackage;
    }

    @Element(xpath = "//button[contains(., 'Add New Package')]", desc = "button ADD NEW PACKAGE")
    public static PageElement buttonAddNewPackage;

    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),'regression-eig')]", desc = "eig-cu option")
    public static PageElement regressionEigCuOption;
    @Element(xpath = "//input[@placeholder='Thing Id']", desc = "Thing Id input box")
    public static PageElement thingIDInputBox;

    @Element(xpath = "//div[contains(@class, 'dmc-form-footer')]/button[@type='submit' and contains(.,'Confirm')]", desc = "Confirm button generic")
    public static PageElement confirmButton;

    @Element(xpath = "//div[contains(@class, 'dmc-form-footer') or contains(@class,'-card-footer')]//button[contains(.,'Clear')]", desc = "Clear Button")
    public static PageElement clearButton;

    @Element(xpath = "(//tr[contains(@class,'inserted')])[1]/td[3]", desc = "First Type Row")
    public static PageElement firstRowType;


    public static String getOptionDropdownMenu() {
        return optionDropdownMenu;
    }

    public static void setOptionDropdownMenu(String text) {
        String optionDropdownMenu = "//div[@class='-option-label' and contains(.,'%s')]";
        CampaignManagementView.optionDropdownMenu = String.format(optionDropdownMenu, text);
    }

    public static String optionDropdownMenu = "";

    @Element(xpath = "//*[contains(text(),'Searching Filters')]", desc = "Searching Filters")
    public static PageElement searchingFilter;

    @Element(xpath = "//div[contains(@class,'-option-label') and contains(text(),' GENERIC ')]", desc = "generic option")
    public static PageElement genericOption;

    @Element(xpath = "(//td[contains(.,'GatewayConceptGG')]//preceding-sibling::td)[1]", desc = "generic option")
    public static PageElement gatewayConceptGG;
    @Element(xpath = "(//td[contains(.,'GatewayConceptGG')]//preceding-sibling::td)[2]", desc = "generic option")
    public static PageElement gatewayConceptGG2;
    @Element(xpath = "(//td[contains(.,'DirectConceptDec')]//preceding-sibling::td)[3]", desc = "generic option")
    public static PageElement DirectConceptDec;
    @Element(xpath = "(//td[contains(.,'DirectConceptDec')]//preceding-sibling::td)[2]", desc = "generic option")
    public static PageElement DirectConceptDec2;
    @Element(xpath = "//td[normalize-space(text())='DirectMX']//preceding-sibling::td", desc = "generic option")
    public static PageElement directMX;
    @Element(xpath = "//td[contains(.,'DirectMX2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directMX2;
    @Element(xpath = "//td[contains(.,'DirectMX3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directMX3;
    @Element(xpath = "//td[normalize-space(text())='DirectCoreApril1']//preceding-sibling::td", desc = "generic option")
    public static PageElement directCoreApril;
    @Element(xpath = "//td[contains(.,'DirectCoreApril2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directCoreApril2;
    @Element(xpath = "//td[contains(.,'DirectCoreApril3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directCoreApril3;
    @Element(xpath = "//td[contains(.,'DirectCoreApril4')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directCoreApril4;
    @Element(xpath = "//td[contains(.,'DirectThingConcept191')]//preceding-sibling::td", desc = "generic option")
    public static PageElement direct1;
    @Element(xpath = "//td[contains(.,'DirectThingConcept192')]//preceding-sibling::td", desc = "generic option")
    public static PageElement direct2;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gateway3;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-4')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gateway4;
    @Element(xpath = "(//td[contains(.,'GatewayConceptCM')]//preceding-sibling::td)[2]", desc = "generic option")
    public static PageElement gatewayConceptCM;
    @Element(xpath = "(//td[contains(.,'GatewayConceptCM')]//preceding-sibling::td)[1]", desc = "generic option")
    public static PageElement gatewayConceptCM2;
    @Element(xpath = "//td[normalize-space(text())='Gateway-April']//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayApril;
    @Element(xpath = "//td[contains(.,'Gateway-April2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayApril2;
    @Element(xpath = "//td[contains(.,'Gateway-April3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayApril3;
    @Element(xpath = "//td[contains(.,'Gateway-April4')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayApril4;
    @Element(xpath = "//td[contains(.,'Gateway29-Concept2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gateway29Concept2;
    @Element(xpath = "//td[contains(.,'Gateway29-Concept3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gateway29Concept3;
    @Element(xpath = "//td[contains(.,'Gateway29-Concept4')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gateway29Concept4;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-1')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayConcept1;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayConcept2;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-3')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayConcept3;
    @Element(xpath = "//td[contains(.,'Gateway-Concept-4')]//preceding-sibling::td", desc = "generic option")
    public static PageElement gatewayConcept4;
    @Element(xpath = "//td[contains(.,'Direct-Concept-1')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directConcept1;
    @Element(xpath = "//td[contains(.,'Direct-Concept-2')]//preceding-sibling::td", desc = "generic option")
    public static PageElement directConcept2;
    @Element(xpath = "//mat-option/span[contains(.,100)]", desc = "100 rows per page ")
    private static PageElement hundredRowsPerPage ;
    @Element(xpath = "//mat-select" , desc= "Select rows per page")
    public static PageElement paginationTableButton;
}
