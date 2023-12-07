package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DeploymentHistoryDeviceDetailsPage {



    public static PageElement getAllCellOfTheFirstRow() {
        return allCellOfTheFirstRow;
    }

    @Element(xpath = "//tbody/tr[1]/td", desc = "all cell of the first row")
    private static PageElement allCellOfTheFirstRow;

    public static PageElement getRefreshButton() {
        return refreshButton;
    }

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh button" )
    private static PageElement refreshButton;
    @Element(xpath = "//i[contains(@class, 'dmc-icon__search')]", desc = "search icon button" )
    private static PageElement searchButton;

    @Element(xpath = "//div[contains(text(),'Deployment Status: Completed')]", desc = "Deployment history Complete status" )
    private static PageElement deploymentStatusComplete;

    @Element(xpath = "(//i[contains(@class, 'dmc-icon__document')])[1]", desc = "first details icon iin the table")
    private static PageElement firstDetailsiconInTheTable;

    @Element(xpath = "//span[contains(text(),'APP1 v3.2')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2909;
    @Element(xpath = "//span[contains(text(),'APP1 v4.0')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2910;
    @Element(xpath = "//span[contains(text(),'APP1 v5.0')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2911;

    @Element(xpath = "//span[contains(text(),'APP2 v1.0')]", desc = "name of the package installed")
    private static PageElement package2InstallationOutcome2911;

    @Element(xpath = "//span[contains(text(),'APP1 v1.1')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2912;

    @Element(xpath = "//span[contains(text(),'APP1 v6.0')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2913;
    @Element(xpath = "//span[contains(text(),'test_2913 v1.0')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2921;
    @Element(xpath = "//span[contains(text(),'test_2913 v2.0')]", desc = "name of the package installed")
    private static PageElement packageInstallationOutcome2923;

    @Element(xpath = "//div[contains(text(),'Deployment Status: Failed')]", desc = "Deployment history failed status" )
    private static PageElement deploymentStatusFailed;

    @Element(xpath = "//div[contains(text(),'Deployment Status: Partial')]", desc = "Deployment history Partially status" )
    private static PageElement deploymentStatusPartiallyComplete;
    @Element(xpath = "//div[contains(text(),'Deployment Status: In Progress')]", desc = "Deployment history in progress status" )
    private static PageElement deploymentStatusInProgress;

    @Element(xpath = "//div[contains(text(),'Deployment Status: Timeout')]", desc = "Deployment history timeout status" )
    private static PageElement deploymentStatusTimeout;
    @Element(xpath = "//div[@class='--complete -status-banner']", desc = "Deployment Details status bar")
    private static PageElement deploymentStatusBar;

    @Element(xpath = "//div[@class='-info-item__label' and contains(.,'Custom Status')]/i", desc = "Custom Status tooltip")
    private static PageElement customStatusTP;
    @Element(xpath = "//div[@class='-info-item__label d-flex align-items-center' and contains(.,' Packages Installations Outcome ')]/i", desc = "Package Installations Outcome tooltip")
    private static PageElement packageInOutcomeTP;
    @Element(xpath = "//div[@class='-info-item__label d-flex align-items-center' and contains(.,' Current Stack ')]/i", desc = "Current Stack tooltip")
    private static PageElement currentStackTP;

}
