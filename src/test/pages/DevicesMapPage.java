package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class DevicesMapPage {

    @Element(xpath = "//div[@role='tab' and contains(., 'Country')]", desc = "tab Country")
    public static PageElement tabCountry;

    @Element(xpath = "//div[@role='tab' and contains(., 'List')]", desc = "tab List")
    public static PageElement tabList;

    @Element(xpath = "//button[@aria-label='Toggle fullscreen view']", desc = "full screen button")
    public static PageElement fullscreenButton;

    @Element(xpath = "//button[@aria-label='Center map']", desc = "center map button")
    public static PageElement fitBoundsButton;

    public static PageElement getTabCountry() {
        return tabCountry;
    }

    public static PageElement getTabList() {
        return tabList;
    }

    public static PageElement getFullscreenButton() {
        return fullscreenButton;
    }

    public static PageElement getFitBoundsButton() {
        return fitBoundsButton;
    }

    public static PageElement getZoomInButton() {
        return zoomInButton;
    }

    public static PageElement getZoomOutButton() {
        return zoomOutButton;
    }

    public static PageElement getRefreshButton() {
        return refreshButton;
    }

    public static PageElement getOnlineDevicesButton() {
        return onlineDevicesButton;
    }

    public static PageElement getOfflineDevicesButton() {
        return offlineDevicesButton;
    }

    public static PageElement getGatewayViewButton() {
        return gatewayViewButton;
    }

    public static PageElement getThingsViewButton() {
        return thingsViewButton;
    }

    public static PageElement getDirectThingViewButton() {
        return directThingViewButton;
    }

    public static PageElement getZoomLabelMap() {
        return zoomLabelMap;
    }

    public static PageElement getMapSizeDiv() {
        return MapSizeDiv;
    }

    @Element(xpath = "//div[@class='info-panel-title']/i[contains(@class, 'down')]", desc = "close panel button")
    public static PageElement closePanelButton;
    @Element(xpath = "//div[@class='info-panel-title']/i[contains(@class, 'up')]", desc = "close panel button")
    public static PageElement openPanelButton;
    @Element(xpath = "//button[@aria-label='Zoom in']", desc = "zoom in button")
    public static PageElement zoomInButton;

    @Element(xpath = "//button[@aria-label='Zoom out']", desc = "zoom out button")
    public static PageElement zoomOutButton;

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh button")
    public static PageElement refreshButton;

    @Element(xpath = "//button[contains(@class, 'dmc-button-toogle-online')]", desc = "Online devices button")
    public static PageElement onlineDevicesButton;

    @Element(xpath = "//button[contains(@class, 'dmc-button-toogle-offline')]", desc = "Offline devices button")
    public static PageElement offlineDevicesButton;

    @Element(xpath = "//button[contains(@class, 'dmc-button-toogle')]/span[contains(., 'Gateway')]/parent::button", desc = "Button View Gateway")
    public static PageElement gatewayViewButton;

    @Element(xpath = "//button[contains(@class, 'dmc-button-toogle')]/span[contains(., 'Thing')]/parent::button", desc = "Button View Thing")
    public static PageElement thingsViewButton;

    @Element(xpath = "//button[contains(@class, 'dmc-button-toogle')]/span[contains(., 'Direct Thing')]/parent::button", desc = "Button View Direct Thing")
    public static PageElement directThingViewButton;

    @Element(xpath = "//div[@aria-roledescription='map']//following-sibling::div/div[@class='dmc-map-aux-controllers-box']//div[contains(.,'Zoom:')]", desc= "label zoom: into the map")
    public static PageElement zoomLabelMap;

    @Element(xpath = "//div[@class='agm-map-container-inner sebm-google-map-container-inner']/div", desc= "Map div container")
    public static PageElement MapSizeDiv;

    @Element(xpath = "//div[@class='info-panel-title']/i[contains(@class, 'chevron')]", desc= "chevron icon info panel")
    public static PageElement chevronIconInfoPanel;

    @Element(xpath = "//span[@class[contains(.,'dmc-ball-online')]]", desc= "online device icon")
    public static PageElement onlineDevicesIcon;
    @Element(xpath = "//span[@class[contains(.,'dmc-ball-offline')]]", desc= "offline device icon")
    public static PageElement offlineDevicesIcon;
    @Element(xpath = "//span[@class[contains(.,'button-label')] and text()='Gateway']", desc= "gateway icon")
    public static PageElement gatewayViewIcon;
    @Element(xpath = "//span[@class[contains(.,'button-label')] and text()='Thing']", desc= "thing icon")
    public static PageElement thingsViewIcon;
    @Element(xpath = "//span[@class[contains(.,'button-label')] and text()='Direct Thing']", desc= "direct thing icon")
    public static PageElement directThingViewIcon;

}