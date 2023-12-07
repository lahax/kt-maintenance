package test.pages;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

import java.util.List;

public class ConnectivityHistoryPage {

    @Element(xpath = "//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='text' and contains(., 'Connectivity History')]/parent::*[name()='svg']/parent::div", desc = "Connectivity History graph")
    private static PageElement connectivityHistoryGraph;
    @Element(xpath = "//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='text' and contains(., 'Mean Connection')]/parent::*[name()='svg']/parent::div", desc = "Mean Connection Graph")
    private static PageElement meanConnectionGraph;

    @Element(xpath = "//h2[@class='-title' and contains(.,'Connectivity History')]", desc = "title of the page Connectivity History")
    private static PageElement titlePageConnectivityHistory;

    @Element(xpath = "//dmc-dummy-input//div[contains(.,'Select datetimes')]", desc = "div calendar date time")
    private static PageElement dateTimesCalendar;
    @Element(xpath = "//i[@dmcicon='download']", desc = "download icon")
    private static PageElement downloadIcon;

    public static String labelInfo = "//p[contains(.,'%s')]";

    @Element(xpath = "//*[contains(.,'0')]//*[contains(.,'Connections: ')]", desc = "zero connection data")
    private static PageElement zeroConnection;
    @Element(xpath = "//*[contains(.,'0')]//*[contains(.,'Disconnections: ')]", desc = "zero connection data")
    private static PageElement zeroDisconnection;
    @Element(xpath = "//*[contains(.,'Not Available')]/preceding-sibling::*[contains(., 'Last Connection:')]", desc = "Not available data last connection")
    private static PageElement notAvailableLastConnection;
    @Element(xpath = "//*[contains(.,'Not Available')]/preceding-sibling::*[contains(., 'Last Disconnection:')]", desc = "Not available data last disconnection")
    private static PageElement notAvailableLastDisconnection;
    @Element(xpath = "(//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='text' and contains(., 'Mean Connection')])//following-sibling::*[name()='text' and contains(., 'Not Available Data')]",
           desc = "Not available data last disconnection")
    private static PageElement notAvailableDataMeanConnection;
    @Element(xpath = "(//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='text' and contains(., 'Connectivity History')])//following-sibling::*[name()='text' and contains(., 'Not Available Data')]",
           desc = "Not available data last disconnection")
    private static PageElement notAvailableDataConnectivityHistory;

    @Element(xpath = "//*[name()='tspan' and contains(.,'Mean Connection')]", desc = "Mean Connection label")
    private static PageElement meanConnectionLabel;
    @Element(xpath = "//*[contains(., 'Mean Connection')]/following-sibling::*[name()='text']/*[contains(., 'Not Available Data')]", desc = "Not avaliable data under Mean connection")
    private static PageElement underNotAvailableDataMeanConnectionVoice;

    @Element(xpath = "//*[name()='tspan' and contains(.,'Connectivity History')]", desc = "Connectivity History")
    private static PageElement connectivityHistoryLabel;
    @Element(xpath = "//*[contains(., 'Connectivity History')]/following-sibling::*[name()='text']/*[contains(., 'Not Available Data')]", desc = "Not avaliable data under Connectivity History")
    private static PageElement underNotAvailableDataConnectivityHistory;

}
