package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class UpdateGatewayDeviceDetailsPage {

    @Element(xpath = "//dmc-form-field-label[text() = ' Latitude ']/following-sibling::dmc-input-container//input", desc = "latitude field")
    private static PageElement latitudeInputField;

    @Element(xpath = "//dmc-form-field-label[text() = ' Longitude ']/following-sibling::dmc-input-container//input",desc = "longitude field")
    private static PageElement longitudeInputField;

    @Element(xpath = "//button[contains(., \"Send\")]", desc = "Send button")
    private static PageElement sendBtn;
}
