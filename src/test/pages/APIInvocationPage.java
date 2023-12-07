package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class APIInvocationPage {


    @Element(xpath = "//h2[contains(text(), 'API Invocation')]", desc = "API Invocation lending page title ")
    private static PageElement apiInvocationLandingPageTitle;

    @Element(xpath = "//h6", desc = "Section header")
    private static PageElement apiInvocationHeader;

    @Element(xpath = "(//dmc-form-field-label)[3]", desc = "Method label")
    private static PageElement methodLabel;

    @Element(xpath = "//dmc-form-field-error", desc = "Error label")
    private static PageElement errorLabel;

    @Element(xpath = "//button[contains(@class,'--disabled')]", desc = "Invoke button")
    private static PageElement invokeButton;

    @Element(xpath = "(//dmc-dummy-input)[1]", desc = "Bese input")
    private static PageElement baseInput;

    @Element(xpath = "(//dmc-dummy-input)[2]", desc = "Method input")
    private static PageElement methodInput;

    @Element(xpath = "//div[@class='ng-star-inserted']//button", desc = "Invoke Button Enabled")
    private static PageElement invokeButtonEnabled;

    @Element(xpath = "//input", desc = "URL input")
    private static PageElement URLInput;

    @Element(xpath = "//div[@class='-option-label']", desc = "Method option")
    private static PageElement methodOption;

    @Element(xpath = "//div[@class='ng-star-inserted']//div[@class='-option-label']", desc = "Bese option")
    private static PageElement baseOption;

    @Element(xpath = "//div[@class='ng-star-inserted']//div[@class='-option-label' or @class='-option-label disabled']", desc = "Bese options")
    private static PageElement baseOptions;

    @Element(xpath = "//div[@class='alert alert-warning ng-star-inserted']", desc = "Alert Unknown error")
    private static PageElement alertUnknownError;

    @Element(xpath = "//ace-editor//div[@class='ace_line']", desc = "Payload text area")
    private static PageElement payloadTextArea;

    @Element(xpath = "//ace-editor//div[@class='ace_content']", desc = "Payload text area")
    private static PageElement payloadTextAreaContent;

    @Element(xpath = "//span[@class='segment-value ng-star-inserted']", desc = "JSON error")
    private static PageElement JSONError;

    public static PageElement getApiInvocationLandingPageTitle() {return apiInvocationLandingPageTitle;}

    public static PageElement getBaseInput() {
        return baseInput;
    }

    public static PageElement getBaseOption() {
        return baseOption;
    }

    public static PageElement getMethodInput() {
        return methodInput;
    }

    public static PageElement getMethodOption() {
        return methodOption;
    }

    public static PageElement getURLInput() {
        return URLInput;
    }

    public static PageElement getInvokeButtonEnabled() {
        return invokeButtonEnabled;
    }

    public static PageElement getBaseOptions() {
        return baseOptions;
    }

    @Element(xpath = "//h2[contains(., 'Result of')]", desc = "API Invocation lending page title ")
    private static PageElement resultOfLandingPageTitle;

    @Element(xpath = "//div/button[contains (.,' Invoca ')]", desc = "API Invocation lending page title ")
    private static PageElement invocaBTNitaliano;
    public static PageElement getInvocaBTNitaliano() {
        return invocaBTNitaliano;
    }
    @Element(xpath = "(//section[contains(@class, 'dmc-card')])", desc = "JSON result of the API invocation")
    private static PageElement JSONResult;
    public static PageElement getJSONResult() {
        return JSONResult;
    }

    public static void setJSONResult(PageElement JSONResult) {
        APIInvocationPage.JSONResult = JSONResult;
    }

}
