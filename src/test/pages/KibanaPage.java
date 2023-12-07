package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class KibanaPage {

    public static PageElement getDevToolsOption() {
        return devToolsOption;
    }

    @Element(xpath = "//div[contains(@class, 'kbnGlobalNavLink__title') and contains(., 'Dev Tools')]", desc= "Dev tools option")
    private static PageElement devToolsOption;

    public static PageElement getEditor() {
        return editor;
    }


    @Element(xpath = "//div[@class='conApp__editor']//textarea", desc = "console editor")
    public static PageElement editor;

    public static PageElement getOutputConsole() {
        return outputConsole;
    }

    @Element(xpath = "//div[@class='conApp__output']//div[@class='ace_content']", desc = "console output")
    public static PageElement outputConsole;

    public static PageElement getKibanaLogo() {
        return kibanaLogo;
    }

    @Element(xpath = "//div[@class='kbnGlobalNav__logo']", desc = "kibana logo")
    private static PageElement kibanaLogo;

    @Element(xpath = "//i[@class='fa fa-play']", desc = "play button")
    private static PageElement playButton;

    public static PageElement getButtonGetToWork() {
        return buttonGetToWork;
    }

    @Element(xpath = "//button[contains(., 'Get to work')]", desc = "button get to work")
    private static PageElement buttonGetToWork;

}
