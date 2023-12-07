package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class ActivateThingPage {
    @Element(xpath = "//dmc-dummy-input", desc = "Input field")
    private static PageElement inputField;

    @Element(xpath = "//div[@class='-option ng-star-inserted']//div[@class='-option-label']", desc = "option")
    private static PageElement DDMOption;

    @Element(xpath = "//input[@placeholder='Model']", desc = "Model input field")
    private static PageElement modelInputField;

    @Element(xpath = "//input[@placeholder='Maker']", desc = "Maker input field")
    private static PageElement makerInputField;

    @Element(xpath = "//input[@placeholder='Alias']", desc = "Alias input field")
    private static PageElement aliasInputField;

    @Element(xpath = "//input[@placeholder='Radio Type']", desc = "Radio Type input field")
    private static PageElement radioTypeInputField;

    @Element(xpath = "(//dmc-dummy-input)[2]", desc = "Interaction Mode field")
    private static PageElement interactionModeField;

    @Element(xpath = "//div[@id='dmc-affix-safenet']", desc = "Exit Interaction Mode field")
    private static PageElement exitInteractionModeField;

    @Element(xpath = "//div[@class='-select --open']//div[contains(@class,'ng-star-inserted')]//div[@class='-option-label']", desc = "option")
    private static PageElement interactionModeOption;

    @Element(xpath = "//input[@placeholder='IP Address']", desc = "IP Address input field")
    private static PageElement IPAddressInputField;

    @Element(xpath = "//input[@placeholder='Port number']", desc = "Port number input field")
    private static PageElement portNumberInputField;

    @Element(xpath = "//input[@placeholder='Serial number']", desc = "Serial number input field")
    private static PageElement serialNumberInputField;

    @Element(xpath = "//input[@placeholder='Device Type']", desc = "Device Type input field")
    private static PageElement deviceTypeInputField;

    @Element(xpath = "//input[@placeholder='External ID']", desc = "Device Type input field")
    private static PageElement externalIDInputField;

    @Element(xpath = "//input[@placeholder='Port name']", desc = "Port name input field")
    private static PageElement portNameInputField;

    @Element(xpath = "//input[@placeholder='Baud Rate']", desc = "Baud Rate input field")
    private static PageElement baudRateInputField;

    @Element(xpath = "//input[@placeholder='Data Bits']", desc = "Data Bits input field")
    private static PageElement dataBitsInputField;

    @Element(xpath = "//input[@placeholder='Parity']", desc = "Parity input field")
    private static PageElement parityInputField;

    @Element(xpath = "//input[@placeholder='Stop Bits']", desc = "Stop Bits input field")
    private static PageElement stopBitsInputField;

    @Element(xpath = "//input[@placeholder='Clsid']", desc = "CLSID input field")
    private static PageElement CLSIDInputField;

    @Element(xpath = "//input[@placeholder='Username']", desc = "Username input field")
    private static PageElement usernameInputField;

    @Element(xpath = "//input[@placeholder='Password']", desc = "Password input field")
    private static PageElement passwordInputField;

    @Element(xpath = "//input[@placeholder='Domain name']", desc = "Domain name input field")
    private static PageElement domainNameInputField;

    @Element(xpath = "//input[@placeholder='Interrogation Address']", desc = "Interrogation Address input field")
    private static PageElement interrogationAddressInputField;

    @Element(xpath = "//input[@type='checkbox']", desc = "Interrogation period input field")
    private static PageElement interrogationPeriodInputField;

    @Element(xpath = "//mat-slide-toggle[@id = 'mat-slide-toggle-1']//span[@class='mat-slide-toggle-bar mat-slide-toggle-bar-no-side-margin']", desc = "Interrogation period switcher")
    private static PageElement interrogationPeriodSwitcher;

    public static PageElement getInteractionModeOption() {
        return interactionModeOption;
    }

//div[text()='Special characters (eg. $, %, &, *, è) are not valid.']/../preceding-sibling::dmc-input-container//input[@placeholder='Model']

    @Element(xpath = "//div[contains(text(),' lora_ns ')]//parent::div//following-sibling::div//div", desc = "'other' option in activate thing")
    private static PageElement otherOption;

    @Element(xpath = "//button[contains(., ' Activate ')]", desc = "'other' option in activate thing")
    private static PageElement activateThingBTN;

}
