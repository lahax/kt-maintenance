package test.pages;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class SearchingFilterDeploymentHistoryDeviceDetailsPage {

    public static String label = "//dmc-form-field-label[contains(text(), '%s')]";
    public static String dropdown = "//div[@class='-select']";

    @Element(xpath = "//h2[@class='-title' and text()='Searching Filters']", desc="tilte of the Searching filters page (deployment history device details page)")
    private static PageElement titleSearchingFilters;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(., 'Filters')]", desc="tab filters")
    private static PageElement tabFilters;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(., 'Custom query')]", desc="tab filters")
    private static PageElement tabCustomQuery;

    @Element(xpath = "//label/span[contains(., 'Enable Latest?')]/parent::label", desc="button activate Latest")
    private static PageElement buttonActivateLatest;

    @Element(xpath = "(//div[@class='-input' and contains(., 'Select datetimes...')])[1]", desc="calendar From")
    private static PageElement calendarFrom;
    @Element(xpath = "(//div[@class='-input' and contains(., 'Select datetimes...')])[2]", desc="calendar To")
    private static PageElement calendarTo;

    @Element(xpath = "//button/span[contains(., 'Search')]/parent::button", desc="Button Search")
    private static PageElement buttonSearch;
    @Element(xpath = "//button/span[contains(., 'Clear')]/parent::button", desc="Button Clear")
    private static PageElement buttonClear;
    @Element(xpath = "//h4[contains(., 'Packages To Install')]//ancestor::div//following-sibling::mat-list//i[@dmcicon='trash']", desc="trash Icon Package To install")
    private static PageElement trashIconPackageToinstall;
    @Element(xpath = "//h4[contains(., 'Current Stack')]//ancestor::div//following-sibling::mat-list//i[@dmcicon='trash']", desc="trash Icon Current Stack")
    private static PageElement trashIconCurrentStack;
    @Element(xpath = "//h4[contains(., 'Packages To Install')]//following-sibling::i[contains(@class, 'dmc-icon__plus')]", desc="plus button Package to install")
    private static PageElement plusIconPackagesToInstall;
    @Element(xpath = "//h4[contains(., 'Current Stack')]//following-sibling::i[contains(@class, 'dmc-icon__plus')]", desc="plus button Current stack")
    private static PageElement plusIconCurrentStack;
    @Element(xpath = "//h4[contains(., 'Current Stack')]", desc="title Current stack")
    private static PageElement titleCurrentStack;
    @Element(xpath = "//h4[contains(., 'Packages To Install')]", desc="title Packages To Install")
    private static PageElement titlePackagesToInstall;
    @Element(xpath = "//h4[contains(., 'Deployment start')]", desc="Deployment start")
    private static PageElement titleDeploymentStart;
    @Element(xpath = "//h4[contains(., 'Deployment end')]", desc="title Deployment end")
    private static PageElement titleDeploymentEnd;

    @Element(xpath = "//div[contains(@class,'datetime')]//dmc-dummy-input/div[contains(@class,'input')]", desc = "history range button")
    private static PageElement historyRangeBoxStart;
    @Element(xpath = "//div[@class='-picker-date']" , desc = "Calendar date")
    private static PageElement calendarDateForm;
    @Element(xpath = "//div[@class='-picker-time']" , desc = "Calendar time")
    private static PageElement calendarTimeForm;



  }
