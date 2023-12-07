package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class MqttClientPage {

    //Censisco i titoli h2 di ogni sezione momentaneamente nella SideBarPage

    @Element(xpath = "//h2[contains(text(), 'Mqtt Client')]", desc = "Mqtt Client\n lending page title ")
    private static PageElement mqttClientLandingPageTitle;

    @Element(xpath = "//h2", desc = "Mqtt Client header ")
    private static PageElement mqttClientHeader;

    @Element(xpath = "//input[contains(@id,'mat-input')]", desc = "Input field")
    private static PageElement inputField;

    @Element(xpath = "//label[contains(@class, 'title')]", desc = "Input field label")
    private static PageElement inputFieldLabel;

    @Element(xpath = "(//button[@class='mat-focus-indicator mat-tooltip-trigger button-mqtt mat-button mat-icon-button mat-button-base mat-primary'])[1]", desc = "Play button")
    private static PageElement playButton;
    @Element(xpath = "//button[@class='mat-focus-indicator button-mqtt mat-button mat-icon-button mat-button-base mat-primary cdk-focused cdk-mouse-focused']", desc = "Pause button")
    private static PageElement pauseButton;

    @Element(xpath = "(//button[@class='mat-focus-indicator button-mqtt mat-button mat-icon-button mat-button-base mat-primary'])[2]", desc = "Pause button")
    private static PageElement pauseButtonEnabled;

    @Element(xpath = "//i[@class='button-mqtt-icon dmc-icon__power dmc-icon']", desc = "Power button")
    private static PageElement powerButton;

    @Element(xpath = "//span[@class='mat-option-text']/div", desc = "DDM option")
    private static PageElement DDMOption;

    @Element(css = "input#search-by", desc = "Search Box")
    private static PageElement searchBox;

    @Element(xpath = "//span[@class='mat-option-text']//div", desc = "DDM Options")
    private static PageElement DDMOptions;

    @Element(xpath = "//span[@class='mat-option-text']//div[text()=' devices/registration ']", desc = "DDM Options Devices Registration")
    private static PageElement DDMOptionsDevicesRegistration;

    @Element(xpath = "//span[@class='mat-option-text']//div[contains(text(),' esol_ap29551_')]", desc = "DDM Options esol_ap29551")
    private static PageElement DDMOptionsEsolAp29551;

    @Element(xpath = "//span[@class='mat-option-text']//div[contains(text(),'#')]", desc = "DDM Options GTW")
    private static PageElement DDMOptionsTag;

    @Element(xpath = "(//span[@class='mat-option-text']//div)[last()]", desc = "DDM Options GTW")
    private static PageElement DDMOptionsGtw;


    @Element(css = "mat-expansion-panel-header", desc = "Topic accordeon")
    private static PageElement topicAccordeon;

    @Element(css = "mat-panel-description.mat-expansion-panel-header-description", desc = "Topic")
    private static PageElement topic;

    public static PageElement getInputField() {
        return inputField;
    }

    public static PageElement getTopic() {
        return topic;
    }

    public static PageElement getMqttClientLandingPageTitle() {return mqttClientLandingPageTitle;}

    public static PageElement getDDMOptionsDevicesRegistration() {
        return DDMOptionsDevicesRegistration;
    }

    public static PageElement getDDMOptions() {
        return DDMOptions;
    }

    @Element(xpath = "//p[contains(., 'CONNECTION SUCCESSFUL' )]", desc = "Connection Successful in mqtt after play button")
    private static PageElement connectionSuccessful;
    @Element(xpath = "//p[contains(., ' Start time :' )]", desc = "start time in mqtt after play button")
    private static PageElement startTime;

    @Element(xpath = "//p[contains(., 'Client disconnected' )]", desc = "disconnection Successful in mqtt after play button")
    private static PageElement disconnectionSuccessful;

    public static PageElement getTopicAccordeon() {
        return topicAccordeon;
    }

    @Element(xpath = "//button//i[contains(@class, 'power')]", desc = "stop button to click")
    private static PageElement pauseBTN;

    @Element(xpath = "//mat-panel-description[contains(text(), 'thing2/data')]", desc = "telemetry topic thing2")
    private static PageElement telemetryTopic;

    @Element(xpath = "//mat-panel-description[contains(text(), 'veig-ha-automation-00_thing1/data')]", desc = "telemetry topic thing2")
    private static PageElement telemetryTopicVeigHA;

    public static PageElement getTelemetryTopic() {
        return telemetryTopic;
    }

    public static PageElement getTelemetryTopicVeigHA() {
        return telemetryTopicVeigHA;
    }

    @Element(xpath = "//span[@class='mat-option-text']//div[contains(., 'devices/monitoring')]", desc = "DDM Options Devices Monitoring")
    private static PageElement DDMOptionsDevicesMonitoring;
}
