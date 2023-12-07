package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class OtaUpdatePage {
    @Element(xpath = "//h2[contains(text(), 'Ota Update')]", desc = "Ota Update title ")
    private static PageElement otaUpdatePageTitle;

    @Element(xpath = "//div[@class='-input' and contains(.,'Name')]/following-sibling::i[@dmcicon='chevron-down']", desc = "dropdown Name")
    private static PageElement dropdownName;

    @Element(xpath = "//div[@class='-input' and contains(.,'Architecture')]/following-sibling::i[@dmcicon='chevron-down']", desc = "dropdown architecture ")
    private static PageElement dropdownArchitecture;

    @Element(xpath = "//div[@class='-input' and contains(.,'Operating System')]/following-sibling::i[@dmcicon='chevron-down']", desc = "dropdown operating system ")
    private static PageElement dropdownOperatingSystem;

    @Element(xpath = "//button[@type='submit' and contains(., 'Update')]", desc = "button update ")
    private static PageElement buttonUpdate;

    public String getOption() {
        return option;
    }

    public void setOption(String type) {
        this.option = String.format(option, type );
    }

    private String option =  "//div[contains(@class, 'option-label') and contains(.,'%s')]";

    public static String getOptionFromDropdown() {
        return optionFromDropdown;
    }

    public static void setOptionFromDropdown(String choice, String dropdown) {
        String optionFromDropdownTemplate = "//div[@class='-input' and contains(., '%s')]/../following-sibling::div//div[@class='-option-label' and contains(.,'%s')]";
        optionFromDropdown = String.format(optionFromDropdownTemplate, dropdown, choice);
    }

    private static String optionFromDropdown = "";
}
