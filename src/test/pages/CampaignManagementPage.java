package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class CampaignManagementPage {


    @Element(xpath = "//h2[contains(text(), 'Gateways Campaign Management')]", desc = "Activities lending page title ")
    private static PageElement campaignManagementLandingPageTitle;

    @Element(xpath = "//h2[@class=\"-title\" and contains(text(), \"Deployment Detail\")]", desc = "Deployment Detail Page Title")
    private static PageElement deploymentDetailPageTitle;


    @Element(xpath = "//i[@dmcicon=\"refresh\"]", desc = "Refresh Button")
    public static PageElement refreshBtn;

    public static PageElement getCampaignManagementLandingPageTitle() {
        return campaignManagementLandingPageTitle;
    }

    /*----------------------------------------- Table Header --------------------------------------------*/
    @Element(xpath = "//th[@class='--selectable-column ng-star-inserted']", desc = "All Selector column header")
    public static PageElement allSelectorColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Device ID')]", desc = "DEVICE ID column header")
    public static PageElement deviceIdColumnHeader;
    @Element(xpath = "//th//div[contains(@class, 'ng-star-inserted') and contains(., 'Device Software Type')]", desc = "DeVICE TYPE column header")
    public static PageElement deviceTypeColumnHeader;
    @Element(xpath = "(//i[@class=\"dmc-icon__document dmc-icon\"])[1]", desc = "First detail buttons")
    public static PageElement detailBtn;

    /*----------------------------------------- Deployment Detail Page --------------------------------------------*/
    @Element(xpath = "//label[contains(text(), \"Latest\")]/ancestor::div[@class=\"col-md-4 col-xl-4 mt-1 ng-star-inserted\"]", desc = "Latest Voice in Deployment Detail Page")
    public static PageElement latestVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Deploy Type\")]", desc = "Deploy Type voice in Deployment Detail Page")
    public static PageElement deployTypeVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Software Type\")]", desc = "Software Type voice in Deployment Detail Page")
    public static PageElement softwareTypeVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Device ID\")]", desc = "Device Id voice in Deployment Detail page")
    public static PageElement deviceIdVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Duration\")]", desc = "Duration voice in Deployment Detail Page")
    public static PageElement durationVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Environment Prefix\")]", desc = "Environment Prefix voice in Deployment Detail Page")
    public static PageElement environmentPrefixVoiceDeploymentDetailPage;
    @Element(xpath = "//label[contains(text(), \"Installed Packages\")]/ancestor::div[@class=\"col-md-4 col-xl-4 mt-1 ng-star-inserted\"]", desc = "Installed Package voice in Deployment Detail Page")
    public static PageElement installedPackagesVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Current Stack\")]", desc = "Current Stack voice in Deployment Detail page")
    public static PageElement currentStackVoiceDeploymentDetailPage;
    @Element(xpath = "//div[contains(text(), \"Packages Installations Outcome\")]", desc = "Packages To Installation in Deployment Detail page")
    public static PageElement packagesInstallOutcomeVoiceOnDetailPage;

    /*----------------------------------------- Direct Thing Direct Things Campaign Management Page --------------------------------------------*/
    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(., 'Direct Things Campaign Management')]", desc = "Direct Things Campaign Management switch btn")
    public static PageElement directThingsCampaignManagementSwitchBtn;
    @Element(xpath = "//h2[contains(text(), \"Direct Things Campaign Management\")]", desc = "Direct Things Campaign Management Title page")
    public static PageElement directThingsCampaignManagementTitlePage;

    @Element(xpath = "//h2[contains(text(), 'Campagne Gateways')]", desc = "Campagne Gateways title ")
    private static PageElement campaignManagementLandingPageTitleIT;

    @Element(xpath = "//h2[contains(., 'Filters')]/following-sibling::i[contains(@class, 'chevron-down')]", desc = "chevron icon Filters box ")
    private static PageElement chevronDownFilterBox;

    @Element(xpath = "//div[@class='-input']", desc = "Gateway Software Type Dropdown")
    private static PageElement gatewaySoftwareTypeDropDown;

    public static String getOptionGatewaySoftwareType() {
        return optionGatewaySoftwareType;
    }

    public static void setOptionGatewaySoftwareType(String field) {
        CampaignManagementPage.optionGatewaySoftwareType = String.format(optionGatewaySoftwareType, field);
    }

    private static String optionGatewaySoftwareType = "//div[@class='-option-label' and contains(.,'%s')]";

    @Element(xpath = "//form//button[@type='button' and contains(., 'Clear')]", desc = "Button Clear Gateway Campaign Management ")
    private static PageElement buttonClear;

    @Element(xpath = "//form//button[@type='submit' and contains(., 'Confirm')]", desc = "Button Confirm Gateway Campaign Management ")
    private static PageElement buttonConfirm;

    public static PageElement getPackageButton() {
        return packageButton;
    }

    @Element(xpath = "//button[contains(@class, 'dmc-fab')]/i[contains(@class, 'package')]", desc = "fab button package at the bottom right of the page")
    private static PageElement packageButton;

    public static PageElement getPopUpDeploySoftware() {
        return popUpDeploySoftware;
    }

    @Element(xpath = "//h3[contains(.,'Deploy Software')]", desc = "title of the popup after clcik on the package button")
    private static PageElement popUpDeploySoftware;

    public static String getOptionDeploySoftwarePopUp() {
        return optionDeploySoftwarePopUp;
    }

    public static void setOptionDeploySoftwarePopUp(String type) {
        String optionDeploySoftwarePopUp = "//button[@type='button' and contains(., '%s')]";
        CampaignManagementPage.optionDeploySoftwarePopUp = String.format(optionDeploySoftwarePopUp, type);
    }

    private static String optionDeploySoftwarePopUp = "";

    @Element(xpath = "//button[@type='button' and contains(., 'Ota Update')]", desc = "button Ota Update")
    private static PageElement optionOtaUpdateDeploySoftwarePopUp;

    public static PageElement getRefreshBtn() {
        return refreshBtn;
    }

    @Element(xpath = "//div[@class='dmc-card-header' and contains(.,'Filters')]", desc = "filters box")
    public static PageElement filterBox;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(., 'Gateways Campaign Management')]", desc = "Gateways Campaign Management switch btn")
    public static PageElement gatewayCampaignManagementSwitchBtn;

    @Element(xpath = "//h2[@class='-title' and contains(.,'Greengrass deploy')]" , desc= "greengrass deploy title")
    public static PageElement greengrassDeployPageTitle;

    @Element(xpath = "//h2[@class='-title' and contains(.,'Greengrass reset')]" , desc= "greengrass reset title")
    public static PageElement greengrassResetPageTitle;

    @Element(xpath = "//button[@type='submit' and contains(.,'Update')]" , desc= "update button gg deploy e reset")
    public static PageElement greengrassUpdateBTN;

    @Element(xpath = "//button[contains(.,'Greengrass deploy')]" , desc= "Greengrass deploy otpion")
    public static PageElement greengrassDeployOption;

    @Element(xpath = "//button[contains(.,'Greengrass reset')]" , desc= "Greengrass reset otpion")
    public static PageElement greengrassResetOption;

    @Element(xpath = "//button[contains(.,'Ota Update')]" , desc= "Ota Update otpion")
    public static PageElement otaUpdateOption;

    @Element(xpath = "//button[contains(.,'Deploy')]" , desc= "Deploy button")
    public static PageElement deployButton;

    @Element(xpath = "//button[contains(.,'Reset')]" , desc= "Reset button")
    public static PageElement resetButton;

    @Element(xpath = "//div/span[contains(.,' Righe per pagina ')]", desc = "Rows per page at the end of the page in Italian")
    private static PageElement rowsPerPageIT ;
    public static PageElement getRowsPerPageIT(){return rowsPerPageIT;}

    @Element(xpath = "//dmc-table-page-selector", desc = "page number indicator in Italian")
    private static PageElement pageCountersIT ;
    public static PageElement getPageCountersIT(){return pageCountersIT;}

}