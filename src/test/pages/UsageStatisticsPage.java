package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class UsageStatisticsPage {


    @Element(xpath = "//h2[contains(text(), 'UAM')]", desc = "UAM lending page title ")
    private static PageElement usageStatisticsLandingPageTitle;

    public static PageElement getUsageStatisticsLandingPageTitle() {return usageStatisticsLandingPageTitle;}

    @Element(xpath = "//div[contains(@class,'highcharts-container')]/*[name()='svg']", desc = "usage statistics graph")
    private static PageElement usageStatisticsGraph;

    @Element(xpath = "//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='g' and contains(., 'Equivalent Usage')]", desc = "usage statistics graph equivalent section")
    private static PageElement graphEquivalentUsageSection;

    @Element(xpath = "//div[contains(@class,'highcharts-container')]/*[name()='svg']/*[name()='g' and contains(., 'Impact')]", desc = "usage statistics graph impact section")
    private static PageElement graphImpactSection;

    @Element(xpath = "//p[contains(text(), 'Tocca una colonna per visualizzare i dati di ciascuna barra')]", desc = "usage statistics graph description text it")
    private static PageElement graphDescriptionTextIT;

    @Element(xpath = "//div[@class='dmc-facade-label' and contains(text(), 'Seleziona opzioni')]", desc = "usage statistics select options")
    private static PageElement usageStatisticsSelectOptionsIT;

    @Element(xpath = "//div[@class='mat-button-toggle-label-content' and contains(text(), '6 Mesi')]", desc = "usage statistics 6 months options")
    private static PageElement usageStatisticsSixMonthsOptionsIT;

    @Element(xpath = "//div[@class='mat-button-toggle-label-content' and contains(text(), '3 Mesi')]", desc = "usage statistics 3 months options")
    private static PageElement usageStatisticsThreeMonthsOptionsIT;

    public static PageElement getGraphDescriptionTextIT() {
        return graphDescriptionTextIT;
    }

    public static PageElement getUsageStatisticsSelectOptionsIT() {
        return usageStatisticsSelectOptionsIT;
    }

    public static PageElement getUsageStatisticsSixMonthsOptionsIT() {
        return usageStatisticsSixMonthsOptionsIT;
    }

    public static PageElement getUsageStatisticsThreeMonthsOptionsIT() {
        return usageStatisticsThreeMonthsOptionsIT;
    }

    @Element(xpath = "//div[@class='mat-button-toggle-label-content' and contains(.,'6 Month')]", desc = "button 6 month")
    private static PageElement buttonSixMonth;

    @Element(xpath = "//div[@class='mat-button-toggle-label-content' and contains(.,'3 Month')]", desc = "button 3 month")
    private static PageElement buttonThreeMonth;

    public static PageElement getNumberOfabscissa() {
        return numberOfabscissa;
    }

    @Element(xpath = "//*[name()='g' and contains(@class, 'highcharts-xaxis-labels')]/*[name()='text']", desc = "number of month showed in the graph")
    private static PageElement numberOfabscissa;
}
