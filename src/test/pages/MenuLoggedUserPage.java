package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class MenuLoggedUserPage {

    @Element(xpath = "//button//span[contains(text(), 'Profile')]", desc = "Profilo Option")
    private static PageElement profileOption;
    @Element(xpath = "//button//span[contains(text(), 'Groups')]", desc = "Gruppi Option")
    private static PageElement groupsOption;
    @Element(xpath = "//button//span[contains(text(), 'Language')]", desc = "Language Option")
    private static PageElement LanguageOption;
    @Element(xpath = "//button//span[contains(text(), 'Logout')]", desc = "Logout Option")
    private static PageElement logoutOption;

    @Element(xpath = "//button//span[contains(text(), 'Profilo')]", desc = "Profilo Option")
    private static PageElement profileOptionIT;
    @Element(xpath = "//button//span[contains(text(), 'Gruppi')]", desc = "Gruppi Option")
    private static PageElement groupsOptionIT;
    @Element(xpath = "//button//span[contains(text(), 'Lingua')]", desc = "Lingua Option")
    private static PageElement LanguageOptionIT;
    @Element(xpath = "//button//span[contains(text(), 'Esci')]", desc = "Esci Option")
    private static PageElement logoutOptionIT;

    public static PageElement getProfileOption() {
        return profileOption;
    }

    public static PageElement getGroupsOption() {
        return groupsOption;
    }

    public static PageElement getLanguageOption() {
        return LanguageOption;
    }

    public static PageElement getLogoutOption() {
        return logoutOption;
    }

    public static PageElement getProfileOptionIT() {
        return profileOptionIT;
    }

    public static PageElement getGroupsOptionIT() {
        return groupsOptionIT;
    }

    public static PageElement getLanguageOptionIT() {
        return LanguageOptionIT;
    }

    public static PageElement getLogoutOptionIT() {
        return logoutOptionIT;
    }

}
