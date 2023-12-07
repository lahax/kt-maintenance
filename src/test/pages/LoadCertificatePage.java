package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class LoadCertificatePage {


    @Element(xpath = "//h2[contains(text(), 'Load Certificate')]", desc = "Load Certificate lending page title ")
    private static PageElement loadCertificateLandingPageTitle;

    @Element(xpath = "//button[@class='btn dmc-button-upload']", desc = "Load Certificate Drag and drop box")
    private static PageElement dragAndDropBox;
    @Element(xpath = "//input[@class='dropzone-input']", desc = "Load Certificate Drag and drop box")
    private static PageElement uploadBox;

    @Element(xpath = "//button[@type='submit']", desc = "upload button")
    private static PageElement uploadButton;

    @Element(xpath = "//span[contains(@class, 'text-danger')]", desc = "error message")
    private static PageElement errorMessageWrongTypeOfFile;


    public static String getBoxFileToBeUploaded() {
        return boxFileToBeUploaded;
    }

    public static void setBoxFileToBeUploaded(String text) {
        String boxFileToBeUploaded = "//section//div//strong[contains(.,'%s')]//ancestor::section";
        LoadCertificatePage.boxFileToBeUploaded = String.format(boxFileToBeUploaded, text);
    }

    private static String boxFileToBeUploaded = "";
    public static PageElement getLoadCertificateLandingPageTitle() {return loadCertificateLandingPageTitle;}
}
