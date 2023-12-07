package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class AlarmsDetailsPage {
    @Element(xpath = "//h2[contains(text(), 'Alarms')]", desc = "Alarms lending page title ")
    private static PageElement alarmsDetailsLandingPageTitle;

    @Element(xpath = "//span[text()='check']/following-sibling::span[contains(.,'lower_threshold')]", desc="field - check : lower throshold")
    private static PageElement lowerThresholdField;

    @Element(xpath = "//span[contains(text(), 'check')]//parent::section//span[contains(text(), 'lower_threshold')]", desc= "alarm detail low threshold")
    public static PageElement lowerThresholdInDetails;

    @Element(xpath = "//span[contains(text(), 'original_message')]//parent::section//span[contains(text(), 'zero_messages')]", desc= "alarm detail zero threshold")
    public static PageElement zeroThresholdInDetails;

    @Element(xpath = "//span[contains(text(), 'check')]//parent::section//span[contains(text(), 'higher_threshold')]", desc= "alarm detail high threshold")
    public static PageElement higherThresholdInDetails;

    @Element(xpath = "//span[contains(text(), 'status')]//parent::section//span[contains(text(), 'alarm-cleared')]", desc= "alarm cleared detail")
    public static PageElement alarmClearedInDetails;

    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button Alarms Details Page")
    private static PageElement backBTN;

    @Element(xpath = "//span[contains(text(), 'check')]//parent::section//span[contains(text(), 'business_alarm')]", desc= "alarm detail business")
    public static PageElement businessInDetails;

    @Element(xpath = "(//span[(text() = 'timestamp')])/following-sibling::span[@class= 'segment-value ng-star-inserted']", desc= "alarm timestamp in alarm detail")
    public static PageElement alarmTimestamp;


    public static PageElement getAlarmTimestamp() {return alarmTimestamp;}

    @Element(xpath = "//span[contains(text(), 'check')]//parent::section//span[contains(text(), 'disservice_alarm')]", desc= "alarm detail disservice")
    public static PageElement disserviceAlarmInDetails;

    @Element(xpath = "//span[contains(text(), 'original_message')]//parent::section//span[contains(text(), 'number') and contains(text(), '240')]", desc= "alarm detail disservice long time")
    public static PageElement disserviceAlarmFourMinutes;

    @Element(xpath = "//span[contains(text(), 'original_message')]//parent::section//span[contains(text(), 'number') and contains(text(), '120')]", desc= "alarm detail short time")
    public static PageElement disserviceAlarmTwoMinutes;
}
