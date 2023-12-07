package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class ShowLogsDeviceDetailPage {

    @Element(xpath = "//h2[@class=\"-title\" and contains(text(), \"Show Logs\")]", desc = "Title of Show Logs Page")
    private static PageElement titleShowLogsPage;
}
