package Util;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class Mailinator {

    public static PageElement getInputInbox() {
        return inputInbox;
    }

    @Element(xpath = "//input[@aria-label='Enter public inbox' and @id='search']", desc= "input box public inbox")
    private static PageElement inputInbox;

    public static PageElement getNewEmailReceived() {
        return newEmailReceived;
    }

    @Element(xpath = "(//tbody/tr[1]//td[contains(.,'AWS Notification')])[1]", desc= "new email of DMC")
    private static PageElement newEmailReceived;

    public static PageElement getLinkConfirmSubscription() {
        return linkConfirmSubscription;
    }

    @Element(xpath = "//a[contains(text(), 'Confirm subscription')]", desc= "link Confirm subscription")
    private static PageElement linkConfirmSubscription;

    @Element(xpath = "//html//body[contains(., 'notified the following')]", desc= "message notification email")
    private static PageElement textOfMessageNotificationInEmail;

    @Element(xpath = "//html//body[contains(., 'notified the following Business Alarm')]", desc= "business notification email")
    private static PageElement textOfBusinessNotificationInEmail;


    public static PageElement getTextOfMessageNotificationInEmail() {
        return textOfMessageNotificationInEmail;
    }

    public static PageElement getSubscriptionConfirmedTitle() {
        return subscriptionConfirmedTitle;
    }

    @Element(xpath = "//h1[contains(text(), 'Subscription confirmed')]", desc= "subscription confirmed Title")
    private static PageElement subscriptionConfirmedTitle;

    public static PageElement getUnsubcribeLink() {
        return unsubcribeLink;
    }

    @Element(xpath = "//a[contains(text(), 'click here to unsubscribe')]", desc= "unsubcribe link ")
    private static PageElement unsubcribeLink;

    @Element(xpath = "//a[contains(@href, 'unsubscribe')]", desc= "unsubcribe link ")
    private static PageElement unsubcribeLinkAfterNotification;

    public static PageElement getUnsubcribeLinkAfterNotification() {
        return unsubcribeLinkAfterNotification;
    }

    public static PageElement getSubscriptionRemovedTitle() {
        return subscriptionRemovedTitle;
    }

    @Element(xpath = "//h2[contains(text(), 'Subscription removed!')]", desc= "subscription confirmed Title")
    private static PageElement subscriptionRemovedTitle;

    //@Element(xpath = "(//tbody/tr[1]//td[contains(.,'ERROR notification')])[1]", desc= "new email of DMC")
    //private static PageElement newEmailErrorReceived;

    @Element(xpath = "(//tbody/tr[1]//td[contains(.,'notification')])[1]", desc= "new email of DMC")
    private static PageElement newEmailErrorReceived;

    @Element(xpath = "(//tbody/tr//td[contains(.,'LOWER_THRESHOLD')])[1]", desc= "Lower threshold email")
    private static PageElement lowerThresholdReceived;

    public static PageElement getLowerThresholdReceived(){
        return lowerThresholdReceived;
    }
    @Element(xpath = "(//tbody/tr//td[contains(.,'TELEMETRY_MONITORING')])[1]", desc= "Telemetry monitoring email")
    private static PageElement telemetryMonitoringReceived;

    public static PageElement getTelemetryReceived(){
        return telemetryMonitoringReceived;
    }

    @Element(xpath = "(//tbody/tr//td[contains(.,'alarm cleared')])[1]", desc= "Alarm cleared email")
    private static PageElement alarmClearedReceived;

    public static PageElement getAlarmClearedReceived(){
        return alarmClearedReceived;
    }

    @Element(xpath = "(//tbody/tr//td[contains(.,'HIGHER_THRESHOLD')])[1]", desc= "Higher threshold email")
    private static PageElement higherThresholdReceived;
    public static PageElement getHigherThresholdReceived(){
        return higherThresholdReceived;
    }
    @Element(xpath = "(//tbody/tr//td[contains(.,'AGGREGATED')])[1]", desc= "Higher aggregated email")
    private static PageElement aggregatedNotificationReceived;
    public static PageElement getAggregatedNotificationReceived(){
        return aggregatedNotificationReceived;
    }
    @Element(xpath = "(//tbody/tr//td[contains(.,'BUSINESS_ALARM')])[1]", desc= "Business alarm email")
    private static PageElement businessAlarmReceived;
    public static PageElement getBusinessAlarmReceived(){
        return businessAlarmReceived;
    }
    @Element(xpath = "(//tbody/tr//td[contains(.,'DISSERVICE_ALARM')])[1]", desc= "Widspread disservice email")
    private static PageElement widspreadDisserviceReceived;
    public static PageElement getWidspreadDisserviceReceived(){
        return widspreadDisserviceReceived;
    }
    @Element(xpath = "//tr[@class='ng-scope']", desc= "new email of DMC")
    private static PageElement allEmailReceived;
    public static PageElement getNewEmailErrorReceived() {
        return newEmailErrorReceived;
    }
    public static PageElement getAllEmailReceived() {
        return allEmailReceived;
    }
    @Element(xpath = "(//tbody/tr//td[contains(.,'LIFECYCLE')])[1]", desc= "Lifecycle notification email")
    private static PageElement lifecycleNotificationReceived;
    public static PageElement getlifecycleNotificationReceived(){
        return lifecycleNotificationReceived;
    }
    @Element(xpath = "//html//body[contains(., 'notified the following Disservice Alarm')]", desc= "disservice notification email")
    private static PageElement textOfDisserviceNotificationInEmail;
    //nota: i messaggi di telemetria sono cambiati per deploy. Reso più generico per evitare errori
    @Element(xpath = "//html//body[contains(., 'sent less than the expected number of messages') or contains(., 'The device sent no messages for 5 min') or contains(., 'notified the following message')]", desc= "telemetry low threshold notification email")
    private static PageElement textOfLowTelemetryNotificationInEmail;

    @Element(xpath = "//html//body[contains(., 'connector commandto notified the following message')]", desc= "cloud component notification email")
    private static PageElement textOfCloudComponentInEmail;

    public static PageElement getTextOfDisserviceNotificationInEmail() {
        return textOfDisserviceNotificationInEmail;
    }

    public static PageElement getTextOfLowTelemetryNotificationInEmail() {
        return textOfLowTelemetryNotificationInEmail;
    }

    public static PageElement getTextOfBusinessNotificationInEmail() {
        return textOfBusinessNotificationInEmail;
    }

    public static PageElement getTextOfCloudComponentInEmail() {
        return textOfCloudComponentInEmail;
    }

    @Element(xpath = "//html//body[contains(., 'rapid disconnections in short time window')]", desc= "disservice notification email long short time")
    private static PageElement shortTimeDisserviceNotificationInEmail;

    @Element(xpath = "//html//body[contains(., 'widespread disconnections in long time window')]", desc= "disservice notification email long time")
    private static PageElement longTimeDisserviceNotificationInEmail;

    public static PageElement getShortTimeDisserviceNotificationInEmail() {
        return shortTimeDisserviceNotificationInEmail;
    }

    public static PageElement getLongTimeDisserviceNotificationInEmail() {
        return longTimeDisserviceNotificationInEmail;
    }

    public static String getDeviceAndProjectInEmail() {
        return deviceAndProjectInEmail;
    }

    public static void setDeviceAndProjectInEmail(String device, String project) {
        String locator = "//html//body[contains(., '%s') and contains(., '%s')]";
        deviceAndProjectInEmail = String.format(locator, device, project);
    }

    private static String deviceAndProjectInEmail="";


    @Element(xpath = "//html//body[contains(., 'msg instead of at most 5 in 5 min')]", desc= "telemetry higher threshold notification email")
    private static PageElement higherTelemetryNotificationInEmail;
    @Element(xpath = "//html//body[contains(., 'msg instead of at least 3 in 5 min')]", desc= "telemetry lower threshold notification email")
    private static PageElement lowerTelemetryNotificationInEmail;

    public static PageElement getLowerTelemetryNotificationInEmail() {
        return lowerTelemetryNotificationInEmail;
    }

    public static PageElement getHigherTelemetryNotificationInEmail() {
        return higherTelemetryNotificationInEmail;
    }

    @Element(xpath = "(//tbody/tr[2]//td[contains(.,'ERROR notification')])", desc= "new email of DMC")
    private static PageElement secondEmailErrorReceived;

    public static PageElement getSecondEmailErrorReceived() {
        return secondEmailErrorReceived;
    }

    @Element(xpath = "//html//body[contains(., 'The device is sending messages as expected') or contains(., 'sent the expected number of messages')]", desc= "telemetry alarm cleared notification email")
    private static PageElement alarmClearedTelemetryNotificationInEmail;

    public static PageElement getAlarmClearedTelemetryNotificationInEmail() {
        return alarmClearedTelemetryNotificationInEmail;

    }
    @Element(xpath = "//html//body[contains(., 'sent more than the expected number of messages in intervals of 5 minutes')]", desc= "telemetry higher threshold notification email")
    private static PageElement higherAggregatedTelemetryNotificationInEmail;

    public static PageElement getHigherAggregatedTelemetryNotificationInEmail() {
        return higherAggregatedTelemetryNotificationInEmail;
    }
}