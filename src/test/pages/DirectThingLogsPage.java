package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DirectThingLogsPage {

    @Element(xpath = "//button[contains(text(), 'Send')]", desc = "save logs operation")
    private static PageElement saveLogsOperationBTN;

    @Element(xpath = "//small/following-sibling::strong", desc = "collect logs enabled or disabled")
    private static PageElement collectLogsStatus;

    @Element(xpath = "//div[contains(@class,'datetime')]//dmc-dummy-input/div[contains(@class,'input')]", desc = "history range button")
    private static PageElement historyRangeBox;

    @Element(xpath = "//div[@class='-dropdown']" , desc = "Calendar")
    private static PageElement calendar;
    @Element(xpath = "//div[@class='-tabs']/div[contains(@class, '-tab') and contains(.,'To')]", desc = "previous day from today in FROM tab active")
    private static PageElement toTabsIntoCalendar;
    @Element(xpath = "(//dmc-calendar//div[@class='-days']/div[contains(@class, '--today')]//preceding-sibling::div[1])[1]", desc = "previous day from today in FROM tab active")
    private static PageElement previousDayInTheFROMCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Now')]" , desc= "button Now into calendar")
    public static PageElement buttonNowIntoCalendar;
    @Element(xpath = "//div[@class='-controls']//button[contains(text(), 'Confirm')]" , desc= "button Confirm into calendar")
    public static PageElement buttonConfirmIntoCalendar;


    public static PageElement getCollectLogsStatus() {
        return collectLogsStatus;
    }
}
