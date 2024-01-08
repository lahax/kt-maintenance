package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;


public class CustomGroupsPage {

    /*Xpath*/

    @Element(xpath = "//h2[contains(text(), 'Custom Groups')]", desc = "Custom Groups title page")
    private static PageElement customGroupsPageTitle;
    @Element(xpath = "//th[contains(text(), '')]", desc = "columns name")
    private static PageElement columnsName;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__pencil')]", desc= "icon pencil first row")
    private static PageElement iconPencilFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__document')]", desc= "icon document first row")
    private static PageElement iconDocumentFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__trash')]", desc= "icon trash first row")
    private static PageElement iconTrashFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__copy')]", desc= "icon cpy first row")
    private static PageElement iconCopyFirstRow;
    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Custom Group')]", desc = "Custom Group details page")
    private static PageElement customGroupDetailPage;
    @Element(xpath = "//button[contains(text(), 'Back')]", desc = "back button Custom Group configuration page")
    private static PageElement backBTN;
    @Element(xpath = "//h2[@class='-title' and contains(text(), 'Modify Custom Group')]", desc = "Title Modify Custom Group (Edit process) Page")
    private static PageElement titleCustomGroupEditPage;
    @Element(xpath = "//div[contains(text(), 'You are in duplicate mode, so you can create a new group with a different name and the same devices.')]",
            desc = "Duplicate mode warning title Custom Group Page")
    private static PageElement duplicateModeWarningCustomGroupPage;
    @Element(xpath = "//h4[contains(text(), ' Remove Confirmation ')]", desc = "pop up delete item from table")
    private static PageElement titlePopUpdeleteItem;
    @Element(xpath = "//button[text()=' Cancel ']", desc = "cancel button into delete pop up")
    private static PageElement cancelButton;
    @Element(xpath = "//button/i[@dmcicon='plus']", desc = "plus button custom group")
    private static PageElement plusCustomGroupButton;
    @Element(xpath = "//label[text()='Group Name']", desc = "add custom groups group name label")
    private static PageElement groupNameCustomGroupsAddLabel;
    @Element(xpath = "//label[text()='Gateway']", desc = "add custom groups gateway name label")
    private static PageElement gatewayCustomGroupsAddLabel;
    @Element(xpath = "//label[text()='Thing']", desc = "add custom groups thing name label")
    private static PageElement thingCustomGroupsAddLabel;
    @Element(xpath = "//label[text()='Direct Thing']", desc = "add custom groups direct thing name label")
    private static PageElement directThingCustomGroupsAddLabel;
    @Element(xpath = "//label[text()=' Selected devices ']", desc = "add custom groups direct thing name label")
    private static PageElement selectedDevicesCustomGroupsAddLabel;
    @Element(xpath ="//i[@class='dmc-icon__plus dmc-icon-size-large dmc-icon ng-star-inserted']", desc = "add gateway and thing plus button")
    private static PageElement addGatewayThingPlusButton;
    @Element(xpath ="//i[@class='dmc-icon__plus dmc-icon-size-large dmc-icon']", desc = "add direct thing plus button")
    private static PageElement addDirectThingPlusButton;
    @Element(xpath ="//button[@type= 'submit' ]", desc = "save new custom group button")
    private static PageElement saveNewCustomGroupButton;
    @Element(xpath = "//i[@dmcicon='refresh']" , desc = "refresh button")
    private static PageElement refreeshBTN;
    @Element(xpath = "//tr[1]/td[contains(@class,'--align-left')]" , desc = "all cell of first row in the table")
    private static PageElement allCellOfFirstRow;
    @Element(xpath = "//h2[contains(text(), 'Gruppi Personalizzati')]", desc = "Custom Groups title page IT")
    private static PageElement customGroupsPageTitleIT;
    @Element(xpath = "//div[@class='-header']/div[contains(., 'Nome Gruppo')]", desc = "Group name title column")
    private static PageElement groupsNameColumnTitleIT;
    @Element(xpath = "//div[@class='-header']/div[contains(., 'Nome Progetto')]", desc = "project name title column")
    private static PageElement projectsNameColumnTitleIT;
    @Element(xpath = "//i[@dmcicon='table-columns']", desc = "select column icon")
    private static PageElement selectColumnsIcon;
    @Element(xpath = "//li/div[contains(., 'NOME PROGETTO')]", desc = "project name 2")
    private static PageElement projectsNameColumnIT;
    @Element(xpath = "//li/div[contains(., 'NOME GRUPPO')]", desc = "group name 2")
    private static PageElement groupNameColumnIT;
    @Element(xpath = "//li/button[contains(., 'Reimposta larghezza colonne')]", desc = "resize columns option")
    private static PageElement resizeColumnsIT;
    @Element(xpath = "//li/button/span", desc = "close button columns")
    private static PageElement closeColumnsBTN;
    @Element(xpath = "//i[@dmcicon='plus']", desc = "add group button")
    private static PageElement addGroupBTN;
    @Element(xpath = "(//i[contains(@class, 'dmc-icon__trash')])[last()]", desc = "delete last group")
    private static PageElement deleteLastGroup;
    @Element(xpath = "(//i[contains(@class, 'dmc-icon__pencil')])[last()]", desc = "pencil last group")
    private static PageElement pencilLastGroup;

    //Add Group Page//
    @Element(xpath = "(//input)[position()=1]", desc = "add group name")
    private static PageElement addGroupName;
    @Element(xpath = "(//input)[position()=2]", desc = "add gateway")
    private static PageElement addGateway;
    @Element(xpath = "//input[@id='mat-input-1']", desc = "add gateway")
    private static PageElement addGatewaySvd;
    @Element(xpath = "(//input)[position()=3]", desc = "add thing box")
    private static PageElement addThingBox;
    @Element(xpath = "//input[@id='mat-input-2']", desc = "add thing box")
    private static PageElement addThingBoxSvd;
    @Element(xpath = "(//input)[position()=4]", desc = "add direct thing box")
    private static PageElement addDirectThingBox;
    @Element(xpath = "(//i[@dmcicon='plus'])[position()=1]", desc = "add thing button")
    private static PageElement addThingBTN;
    @Element(xpath = "(//i[@dmcicon='plus'])[position()=2]", desc = "add direct thing button")
    private static PageElement addDirectThingBTN;
    @Element(xpath = "//button[@type='submit']", desc = "add group save button")
    private static PageElement saveAddingGroupBTN;
    //aggiornare xpath
    @Element(xpath = "(//span[@class='mat-option-text'])[position()=1]", desc = "first gateway option")
    private static PageElement firstGatewayOption;
    //aggiornare xpath
    @Element(xpath = "(//span[@class='mat-option-text'])[position()=2]", desc = "second gateway option")
    private static PageElement secondGatewayOption;
    @Element(xpath = "//span[contains(text(), 'All things')]", desc = "all things option")
    private static PageElement allThingsOption;
    @Element(xpath = "//span[contains(text(), 'Only gateway')]", desc = "only gateway option")
    private static PageElement onlyGatewayOption;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-01_thing1')]", desc = "first thing option")
    private static PageElement firstThingOption;
    @Element(xpath = "//button[contains(@class, '-back')]", desc = "back btn custom group")
    private static PageElement backBTNCustom;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-01_thing1')]//mat-icon", desc = "cancel thing in group")
    private static PageElement cancelConcept01Thing1;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-01')]//mat-icon", desc = "cancel gateway in group")
    private static PageElement cancelGatewayConcept01;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-02')]//mat-icon", desc = "cancel gateway in group")
    private static PageElement cancelGatewayConcept02;
    @Element(xpath = "//div[@class ='mat-chip-list-wrapper']//*[contains(text(), 'Test_Concept-03')]", desc = " gateway in group")
    private static PageElement conceptGateway03box;
    @Element(xpath = "//div[@class ='mat-chip-list-wrapper']//*[contains(text(), 'Test_Concept-03_thing1')]", desc = "thing gateway in group")
    private static PageElement concept03Thing1box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-02')]", desc = " gateway in group")
    private static PageElement conceptGateway02box;
    @Element(xpath = "//div[@class ='mat-chip-list-wrapper']//*[contains(text(), 'Test_Concept-01_thing2')]", desc = "thing gateway in group")
    private static PageElement concept01Thing2box;
    @Element(xpath = "//mat-chip[contains(text(), 'DirectThing_Test15_26')]", desc = " direct thing in group")
    private static PageElement directThingBox;
    @Element(xpath = "//div[@class ='mat-chip-list-wrapper']//*[contains(text(), ' Test_Concept-01 ')]", desc = " gateway in group")
    private static PageElement conceptGateway01box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-04_thing2')]", desc = "thing gateway in group")
    private static PageElement concept04Thing2box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-03_thing2')]", desc = "thing gateway in group")
    private static PageElement concept03Thing2box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-02_thing1')]", desc = "thing gateway in group")
    private static PageElement concept02Thing1box;
    @Element(xpath = "//div[@class ='mat-chip-list-wrapper']//*[contains(text(), 'DirectXX')]", desc = " direct thing in group")
    private static PageElement directXXBox;

    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-02_thing2')]", desc = "thing gateway in group")
    private static PageElement concept02Thing2box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-02_thing3')]", desc = "thing gateway in group")
    private static PageElement concept02Thing3box;
    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-01_thing3')]", desc = "thing gateway in group")
    private static PageElement concept01Thing3box;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-01')]", desc = "first device group selection in wizard")
    private static PageElement testConcept01Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-02')]", desc = "second device group selection in wizard")
    private static PageElement testConcept02Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-03')]", desc = "third device group selection in wizard")
    private static PageElement testConcept03Device;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-04')]", desc = "4rth device group selection in wizard")
    private static PageElement testConcept04Device;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-01_thing1')]", desc = "first thing group selection in wizard")
    private static PageElement testConcept01thing1;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-01_thing2')]", desc = "second thing group selection in wizard")
    private static PageElement testConcept01thing2;
    @Element(xpath = "//span[contains(text(), 'Test_Concept-03_thing1')]", desc = "third gateway thing group selection in wizard")
    private static PageElement testConcept03thing1;

    @Element(xpath = "//span[contains(text(), 'Test_Concept-04_thing2')]", desc = "third gateway thing group selection in wizard")
    private static PageElement testConcept04thing2;

    @Element(xpath = "//span[contains(text(), 'DirectThing_Test15_26')]", desc = "direct thing group selection in wizard")
    private static PageElement directThing15_26;

    @Element(xpath = "//span[contains(text(), 'DirectXX')]", desc = "direct thing group selection in wizard")
    private static PageElement directThingXX;

    @Element(xpath = "//mat-option[1]", desc = "first device group selection in wizard")
    private static PageElement firstDirectThing;

    @Element(xpath = "//span[contains(text(), ' GatewayC ')]", desc = "first thing group selection in wizard")
    private static PageElement gatewayC01thing1;


    @Element(xpath = "//button[@class='-dismiss']", desc = "Remove confirmation Delete button")
    private static PageElement toastMessageClose;
    @Element(xpath = "//td[contains(., 'Test_15.24')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_24;
    @Element(xpath = "//td[contains(., 'Test_15.26')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_26;
    @Element(xpath = "//td[contains(., 'Test_15.30')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_30;

    @Element(xpath = "//button[contains(., 'Confirm')]", desc = "confirm delete")
    private static PageElement confirmDelete;

    @Element(xpath = "//div[text() = ' direct ']", desc = "direct interaction")
    private static PageElement directInteraction;

    @Element(xpath = "//td[contains(., 'Test_15.27')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_27;

    @Element(xpath = "//td[contains(., 'Test_15.28')]//following-sibling::td//i[contains(@class, 'dmc-icon__trash')]", desc = "delete last group")
    private static PageElement deleteTest15_28;

    @Element(xpath = "//td[contains(., 'Test_15.27')]//following-sibling::td//i[contains(@class, 'document')]", desc = "details last group")
    private static PageElement detailsTest15_27;

    @Element(xpath = "//td[contains(., 'Test_15.28')]//following-sibling::td//i[contains(@class, 'document')]", desc = "details last group")
    private static PageElement detailsTest15_28;

    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-03_thing1')]//mat-icon", desc = "thing gateway in group")
    private static PageElement concept03Thing1;

    @Element(xpath = "//mat-chip[contains(text(), 'Test_Concept-03_thing2')]//mat-icon", desc = "thing gateway in group")
    private static PageElement concept03Thing2;

    @Element(xpath = "//td[contains(., 'Test_15.26')]//following-sibling::td//i[contains(@class, 'dmc-icon__pencil')]", desc = "delete last group")
    private static PageElement pencilTest15_26;





    //Getters
    public static PageElement getCustomGroupsPageTitle() {return customGroupsPageTitle;}
    public static PageElement getColumnsName() {return columnsName;}
    public static PageElement getIconPencilFirstRow() {return iconPencilFirstRow;}
    public static PageElement getIconDocumentFirstRow() {return iconDocumentFirstRow;}
    public static PageElement getIconTrashFirstRow() {return iconTrashFirstRow;}
    public static PageElement getIconCopyFirstRow() {return iconCopyFirstRow;}
    public static PageElement getCustomGroupDetailPage() {return customGroupDetailPage;}
    public static PageElement getBackBTN() {return backBTN;}
    public static PageElement getTitleCustomGroupEditPage() {return titleCustomGroupEditPage;}
    public static PageElement getDuplicateModeWarningCustomGroupPage() {return duplicateModeWarningCustomGroupPage;}
    public static PageElement getTitlePopUpdeleteItem() {return titlePopUpdeleteItem;}
    public static PageElement getCancelButton() {return cancelButton;}
    public static PageElement getPlusCustomGroupButton() {return plusCustomGroupButton;}
    public static PageElement getGroupNameCustomGroupsAddLabel() {return groupNameCustomGroupsAddLabel;}
    public static PageElement getGatewayCustomGroupsAddLabel() {return gatewayCustomGroupsAddLabel;}
    public static PageElement getThingCustomGroupsAddLabel() {return thingCustomGroupsAddLabel;}
    public static PageElement getDirectThingCustomGroupsAddLabel() {return directThingCustomGroupsAddLabel;}
    public static PageElement getSelectedDevicesCustomGroupsAddLabel() {return selectedDevicesCustomGroupsAddLabel;}
    public static PageElement getAddGatewayThingPlusButton() {return addGatewayThingPlusButton;}
    public static PageElement getAddDirectThingPlusButton() {return addDirectThingPlusButton;}
    public static PageElement getSaveNewCustomGroupButton() {return saveNewCustomGroupButton;}
    public static PageElement getRefreeshBTN() {return refreeshBTN;}
    public static PageElement getAllCellOfFirstRow() {return allCellOfFirstRow;}

    public static PageElement getCustomGroupsPageTitleIT() {
        return customGroupsPageTitleIT;
    }

    public static PageElement getProjectsNameColumnTitle() {
        return projectsNameColumnTitleIT;
    }

    public static PageElement getGroupsNameColumnTitle() {
        return groupsNameColumnTitleIT;
    }

    public static PageElement getProjectsNameIT() {
        return projectsNameColumnIT;
    }

    public static PageElement getCloseColumnsBTN() {
        return closeColumnsBTN;
    }

    public static PageElement getGroupNameIT() {
        return groupNameColumnIT;
    }

    public static PageElement getResizeColumns() {
        return resizeColumnsIT;
    }

    public static PageElement getSelectColumnsIcon() {
        return selectColumnsIcon;
    }

    public static PageElement getAddDirectThingBox() {
        return addDirectThingBox;
    }

    public static PageElement getAddGateway() {
        return addGateway;
    }

    public static PageElement getAddGroupName() {
        return addGroupName;
    }

    public static PageElement getAddThingBox() {
        return addThingBox;
    }

    public static PageElement getSaveAddingGroupBTN() {
        return saveAddingGroupBTN;
    }

    public static PageElement getAddThingBTN() {
        return addThingBTN;
    }

    public static PageElement getAddDirectThingBTN() {
        return addDirectThingBTN;
    }

    public static PageElement getAddGroupBTN() {
        return addGroupBTN;
    }

    public static PageElement getConfirmDelete() {
        return confirmDelete;
    }

    public static PageElement getToastMessageClose() {
        return toastMessageClose;
    }
}

