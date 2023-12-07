package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class NotificationsConfigurationsPage {

    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__pencil')]", desc= "icon pencil first row")
    private static PageElement iconPencilFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__document')]", desc= "icon document first row")
    private static PageElement iconDocumentFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__trash')]", desc= "icon trash first row")
    private static PageElement iconTrashFirstRow;
    @Element(xpath = "//button[text()=' Confirm ']", desc = "confirm button into delete pop up")
    private static PageElement confirmDeleteButton;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__bell')]", desc= "icon bell first row")
    private static PageElement iconBellFirstRow;
    @Element(xpath = "//div[contains(text(), 'ALARM SOURCE')]", desc = "column alarm source")
    private static PageElement alarmSourceCol;
    @Element(xpath = "//div[contains(text(), 'SCOPE TARGET')]", desc = "column scope target")
    private static PageElement scopeTargetCol;
    @Element(xpath = "//div[contains(text(), 'SCOPE TYPE')]", desc = "column scope type")
    private static PageElement scopeTypetCol;
    @Element(xpath = "//div[contains(text(), 'NOTIFICATIONS')]", desc = "column notifications")
    private static PageElement notificationsCol;
    @Element(xpath = "//div[contains(text(), 'SUBSCRIPTIONS')]", desc = "column subscriptions")
    private static PageElement subscriptionstCol;
    @Element(xpath = "//h2[contains(text(), 'Notifications Configurations')]", desc = "notifications configurations title")
    private static PageElement notificationsConfigurationsPageTitleENG;
    @Element(xpath = "//h2[@class='-title']", desc = "notifications configurations title")
    private static PageElement notificationsConfigurationsPageTitle;
    @Element(xpath = "//button/i[@dmcicon='wizard']", desc = "wizard button")
    private static PageElement wizardBTN;
    @Element(xpath = "//div[contains(@class,'info')]", desc = "Title notifications configurations WIZARD ")
    private static PageElement notificationsConfigurationsWizardPageTitle;

    @Element(xpath = "//tbody//tr", desc= "all Notifications present into the table of Device Configuration Page")
    private static PageElement allNotifications;
    @Element(xpath = "//tr[1]/td[contains(@class,'--align-left')]", desc = "all cell of first row in the table")
    private static PageElement allCellOfFirstRow;

    @Element(xpath = "//td[contains(., 'Test_15.26')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_26;

    /*Getters*/

    public static PageElement getIconPencilFirstRow() { return iconPencilFirstRow;  }
    public static PageElement getIconDocumentFirstRow() { return iconDocumentFirstRow;  }
    public static PageElement getIconTrashFirstRow() { return iconTrashFirstRow; }
    public static PageElement getIconBellFirstRow() { return iconBellFirstRow; }
    public static PageElement getAlarmSourceCol() { return alarmSourceCol; }
    public static PageElement getScopeTargetCol() { return scopeTargetCol; }
    public static PageElement getScopeTypetCol() { return scopeTypetCol; }
    public static PageElement getNotificationsCol() { return notificationsCol; }
    public static PageElement getSubscriptionstCol() { return subscriptionstCol;  }
    public static PageElement getNotificationsConfigurationsPageTitleENG() { return notificationsConfigurationsPageTitleENG;}
    public static PageElement getNotificationsConfigurationsPageTitle() { return notificationsConfigurationsPageTitle; }
    public static PageElement getWizardBTN() {return wizardBTN;}
    public static PageElement getBackBTN() {return backBTN;}
    public static PageElement getNotificationsConfigurationsWizardPageTitle() {return notificationsConfigurationsWizardPageTitle;}

    /*Buttons and titles of pop ups and pages from icons*/

    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button Notifications configurations page")
    private static PageElement backBTN;

    @Element(xpath = "//button[text()=' Cancel ']", desc = "cancel button into delete pop up")
    private static PageElement cancelButton;

    public static PageElement getCancelButton() {
        return cancelButton;
    }

    @Element(xpath = "//h2[contains(text(), 'Notification Configuration Detail')]", desc = "Title Notifications configuration details page")
    private static PageElement titleNotificationsConfigurationDetailPage;
    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Update Configuration - Notification')]", desc = "Title Notifications Configuration update (Edit process) Page")
    private static PageElement titleNotificationsConfigurationEditPage;

    @Element(xpath = "//button[@class='-dismiss']", desc = "Remove confirmation Delete button")
    private static PageElement toastMessageClose;

    public static PageElement getTitleNotificationsConfigurationDetailPage() {
        return titleNotificationsConfigurationDetailPage;
    }

    public static PageElement getTitleNotificationsConfigurationEditPage() {
        return titleNotificationsConfigurationEditPage;
    }

    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Subscriptions')]", desc = "Title Notifications Configuration subscriptions Page")
    private static PageElement titleNotificationsConfigurationSubscriptionsPage;

    public static PageElement getTitleNotificationsConfigurationSubscriptionsPage() {
        return titleNotificationsConfigurationSubscriptionsPage;
    }

    @Element(xpath = "//h4[contains(text(), 'Remove Confirmation')]", desc = "pop up remove item from table")
    private static PageElement titlePopUpRemoveItem;

    public static PageElement getTitlePopUpRemoveItem() {
        return titlePopUpRemoveItem;

    }

    public static PageElement getAllNotifications(){
        return allNotifications;
    }

    @Element(xpath = "(//i[contains(@class, 'dmc-icon__trash')])[last()]", desc = "delete last notification")
    private static PageElement deleteLastNotification;

    @Element(xpath = "//td[contains(., 'Test_Concept-01')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteTestConcept01Notification;

    @Element(xpath = "//td[contains(., 'Test_Concept-02')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteTestConcept02Notification;

    @Element(xpath = "//td[contains(., 'Test_Concept-03')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteTestConcept03Notification;

    @Element(xpath = "//td[contains(., 'Test_Concept-04')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteTestConcept04Notification;

    @Element(xpath = "//td[contains(., 'all')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete all type notification")
    private static PageElement deleteAllNotification;

    @Element(xpath = "//td[contains(., 'Test_15.26')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteCustomGroup15_26Notification;

    @Element(xpath = "//td[contains(., 'all')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteScopeAllNotification;

    @Element(xpath = "//td[contains(., ' commandto ')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteCommandtoNotification;

    @Element(xpath = "//td[contains(., 'Test_15.30')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteCustomGroup15_30Notification;

    @Element(xpath = "//td[contains(., 'Cloud')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last notification")
    private static PageElement deleteCloudNotification;

    public static PageElement getAllCellOfFirstRow() {return allCellOfFirstRow;}

    public static PageElement getDeleteCommandtoNotification() {return deleteCommandtoNotification;}

    public static PageElement getConfirmDeleteButton() {return confirmDeleteButton;}
}
