package test.pages;

import ta.annotations.elements.Element;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;

public class LambdasPage extends CommonPage  {

    @Element(xpath = "//h2[@class='-title' and  contains(text(), 'Lambda')]", desc = "Lambda landing page title ")
    private static PageElement lambdaLandingPageTitle;

    @Element(xpath = "//h2[contains(text(), 'Select Lambda')]", desc = "Lambda header")
    private static PageElement lambdaHeaderPage;

    @Element(css = "dmc-dummy-input", desc = "input field")
    private static PageElement inputFieldLambda;

    @Element(xpath = "(//div[@class='-option ng-star-inserted'])[6]", desc = "select")
    private static PageElement ddmOption;

    @Element(css = "table th", desc = "Table headers")
    private static PageElement tableHeaders;

    @Element(xpath = "//div[@class='d-flex align-items-center justify-content-center' and contains(text(),'ERRORS')]/..", desc = "Errors filter")
    private static PageElement errorsFilter;

    @Element(xpath = "//i[@dmcicon='cross-circle']", desc = "errors icon")
    private static PageElement errorsIcon;

    @Element(xpath = "//div[@class='d-flex align-items-center justify-content-center' and contains(text(),'NOTIFICATIONS')]", desc = "Notifications filter")
    private static PageElement notificationsFilter;

    @Element(xpath = "//i[@dmcicon='alert']", desc = "notifications icon")
    private static PageElement notificationsIcon;

    @Element(xpath = "//div[@class='-input']", desc = "input field")
    private static PageElement inputField;

    @Element(xpath = "//h2[not(@class)]", desc = "header")
    private static PageElement header;

    @Element(xpath = "//div[@class='d-flex align-items-center justify-content-center' and contains(text(),'TIMEOUTS')]", desc = "Timeouts filter")
    private static PageElement timeoutsFilter;

    @Element(xpath = "//span[@class='mat-button-toggle-label-content' and contains(text(),'ALL')]", desc = "All")
    private static PageElement all;

    @Element(xpath = "//i[@dmcicon='clock-alert']", desc = "timeout icon")
    private static PageElement timeoutIcon;

    @Element(xpath = "((//table//tr[@class='ng-star-inserted'])[1]//td)[3]", desc = "logStream")
    private static PageElement logStream;

    @Element(css = "div.mat-select-arrow", desc = "pagination")
    private static PageElement pagination;

    @Element(xpath = "//span[@class='mat-option-text' and text()=' 100 ']", desc = "Hundred Rows Option")
    private static PageElement hundredRowsOption;

    @Element(xpath = "//i[@class='-navigation-arrow --next dmc-icon__chevron-right dmc-icon-size-small dmc-icon']", desc = "next page enabled")
    private static PageElement nextPageEnabled;

    @Element(xpath = "//i[@dmcicon='refresh']", desc = "refresh icon")
    private static PageElement refreshIcon;

    @Element(xpath = "//div[@class='mat-tab-label-content' and contains(text(), 'Execution')]", desc = "execution tab")
    private static PageElement executionTab;

    @Element(xpath = "(//i[@dmcicon='chevron-down'])[3]", desc = "Filter command expand arrow")
    private static PageElement filtersCommandExpandArrow;

    @Element(xpath = "//div[@class='-datetime-range-picker']", desc = "Filter creation date expand arrow")
    private static PageElement filtersCreationDateExpandArrow;

    @Element(xpath = "(//i[@dmcicon='chevron-down'])[4]", desc = "Filter status expand arrow")
    private static PageElement filtersStatusExpandArrow;

    @Element(xpath = "(//div[@class='mat-tab-label-content'])[2]", desc = "Execution tab")
    private static PageElement execution;

    @Element(xpath = "//button[@type='submit' and contains(text(),'Confirm')]", desc = "Confirm button")
    private static PageElement confirmButton;

    @Element(xpath = "//section[@class='ngx-json-viewer']/section//span[@class='segment-key']", desc = "Section keys")
    private static PageElement sectionSegmentKey;

    @Element(xpath = "//section[@class='ngx-json-viewer']/section//span[@class='segment-key']/following-sibling::span[@class='segment-value ng-star-inserted']", desc = "Section values")
    private static PageElement sectionSegmentValue;

    public static PageElement getLambdaLandingPageTitle() {return lambdaLandingPageTitle;}

    public static PageElement getFiltersCommandExpandArrow() {return filtersCommandExpandArrow;}
    public static PageElement getNextPageEnabled() {return nextPageEnabled;}
    public static PageElement getHundredRowsOption() {return hundredRowsOption;}
    public static PageElement getPagination() {return pagination;}
    public static PageElement getTimeoutIcon() {return timeoutIcon;}
    public static PageElement getTableHeaders() {return tableHeaders;}

    public static PageElement getFiltersCreationDateExpandArrow() { return filtersCreationDateExpandArrow;
    }

    public static PageElement getFiltersStatusExpandArrow() { return filtersStatusExpandArrow;
    }

    public static PageElement getConfirmButton() { return confirmButton;
    }

    public static PageElement getSectionSegmentKey() { return sectionSegmentKey;
    }

    public static PageElement getSectionSegmentValue() { return sectionSegmentValue;
    }

    @Element(xpath = "//mat-panel-title[contains(., 'DATE')]", desc = "date column label in LOG STREAM link ")
    private static PageElement dateColumn;

    @Element(xpath = "//mat-panel-description[contains(., 'MESSAGE')]", desc = "message column label in LOG STREAM link ")
    private static PageElement messageColumn;

    @Element(xpath = "(//div[@class='-option ng-star-inserted'])[5]", desc = "select")
    private static PageElement ddmOption4;

    @Element(xpath = "//div[@class='-option ng-star-inserted']/div[contains(.,'taskcommandcompletion')]", desc = "select")
    private static PageElement taskcommandcompletation;
}
