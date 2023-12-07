package Util;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class SmssReceiver {

    @Element(xpath = "//h4[contains(., '+34')]", desc= "All numbers with starter +34")
    private static PageElement spainNumberList;

    @Element(xpath = "//div[@id='dismiss-button']", desc= "Close ad button")
    private static PageElement closeAd;

    @Element(xpath = "(//td[contains(.,'EnelE2E')])[1]", desc= "last TD with sender EnelE2E")
    private static PageElement senderSMSEnelE2E;

    @Element(xpath = "(//a[@class='btn-random adfixes2 sref'])", desc= "update messages button ")
    private static PageElement updateMessageBTN;

    @Element(xpath = "//td[contains(., '1 devices sent less messages than expected')]", desc= "disservice notification email")
    private static PageElement textOfDisserviceNotificationInSMS;

    @Element(xpath = "//td[contains(., 'The device sent no messages for 5 minutes')]", desc= "telemetry notification email")
    private static PageElement textOfTelemetryNotificationInSMS;

    @Element(xpath = "//td[contains(., 'commandto')]", desc= "cloud component notification email")
    private static PageElement textOfCloudComponentInSMS;

    @Element(xpath = "//td[contains(., 'The device is disconnected for more than 1 minutes')]", desc= "business notification email")
    private static PageElement textOfBusinessNotificationInSMS;

    @Element(xpath = "//td[contains(., 'esol-ap29551-qa')]", desc= "esol-ap29551-qa in body sms message")
    private static PageElement targetApmSMSBody;

    @Element(xpath = "//td[contains(., 'E2E_Monitoring')]", desc= "E2E_Monitoring in body message")
    private static PageElement E2E_MonitoringInSMSBody;

    @Element(xpath = "((//td[contains(.,'EnelE2E')])[1])/following-sibling::td[contains(.,'E2E_Monitoring')]", desc= "All body message")
    private static PageElement bodyMessage;


    //GETTERS
    public static PageElement getTextOfDisserviceNotificationInSMS() {return textOfDisserviceNotificationInSMS;}
    public static PageElement getTextOfTelemetryNotificationInSMS() {return textOfTelemetryNotificationInSMS;}
    public static PageElement getTextOfCloudComponentInSMS() {return textOfCloudComponentInSMS;}
    public static PageElement getTextOfBusinessNotificationInSMS() {return textOfBusinessNotificationInSMS;}
    public static PageElement getTargetApmSMSBody() {return targetApmSMSBody;}
    public static PageElement getE2E_MonitoringInSMSBody() {return E2E_MonitoringInSMSBody;}
    public static PageElement getSenderSMSEnelE2E() {return senderSMSEnelE2E;}
    public static PageElement getSpainNumberList() {return spainNumberList;}
    public static PageElement getCloseAd() {return closeAd;}
    public static PageElement getUpdateMessageBTN() {return updateMessageBTN;}
    public static PageElement getBodyMessage() {return bodyMessage;}
}
