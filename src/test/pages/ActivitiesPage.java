package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class ActivitiesPage {
    @Element(xpath = "//h2[contains(text(), 'Activities')]", desc = "Activities lending page title ")
    private static PageElement activitiesLandingPageTitle;
    @Element(xpath = "//i[@dmcicon='plus']", desc = "Add new activity button ")
    private static PageElement newActivityPlusBTN;
    @Element(xpath = "//input[@name = 'activityId']", desc = "ActivityID add activity input label ")
    private static PageElement activityIdInputLabel;
    @Element(xpath = "//input[@name = 'notes']", desc = "Notes add activity input label ")
    private static PageElement notesInputLabel;
    @Element(xpath = "//button[text()=' Confirm ']", desc = "Confirm add new activity button")
    private static PageElement confirmNewActivityButton;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__play')]", desc= "icon run first row")
    private static PageElement iconPlayFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__copy')]", desc= "icon copy first row")
    private static PageElement iconCopyFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__pencil')]", desc= "icon pencil first row")
    private static PageElement iconPencilFirstRow;
    @Element(xpath = "//tr[1]//i[contains(@class, 'dmc-icon__trash')]", desc= "icon trash first row")
    private static PageElement iconTrashFirstRow;
    @Element(xpath = "//button[text()=' Confirm ']", desc = "Confirm play activity button ")
    private static PageElement confirmRunActivityButton;
    @Element(xpath = "//button[@class='-dismiss']", desc = "Remove confirmation Delete button")
    private static PageElement toastMessageClose;
    @Element(xpath = "//button[text()=' Confirm ']", desc = "confirm button into delete pop up")
    private static PageElement confirmDeleteButton;
    @Element(xpath = "(//td[contains(., ' TestConcept ')])//following-sibling::td//i[@class='dmc-icon__play dmc-icon']", desc= "run activities btn of testConcept")
    public static PageElement activityTestConceptPlayIcon;
    @Element(xpath = "(//td[contains(., ' TestConcept ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "run activities btn of testConcept")
    public static PageElement activityTestConceptDeleteIcon;
    @Element(xpath = "(//td[contains(., ' TestConceptNoGateway ')])//following-sibling::td//i[@class='dmc-icon__play dmc-icon']", desc= "run activities btn of testConcept")
    public static PageElement activityTestConceptNoGatewayPlayIcon;
   @Element(xpath = "(//td[contains(., ' TestConceptNoGateway ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "run activities btn of testConcept")
    public static PageElement activityTestConceptNoGatewayDeleteIcon;

    public static PageElement getActivitiesLandingPageTitle() {return activitiesLandingPageTitle;}

    @Element(xpath = "//th//div[contains(@class, '-header')]/div[contains(.,'Activity id')]", desc= "label of the activity id column")
    public static PageElement labelActivityIdColumn;
    @Element(xpath = "//th//div[contains(@class, '-header')]/div[contains(.,' Creation date ')]", desc= "label of the creation date column")
    public static PageElement labelCreationDateColumn;
    @Element(xpath = "//th//div[contains(@class, '-header')]/div[contains(.,'Notes')]", desc= "label of the notes column")
    public static PageElement labelNotesColumn;
    @Element(xpath = "//div[@class='mat-tooltip-trigger -handle mt-1']", desc = "Manage Column")
    private static PageElement manageColumn;
    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "delete btn of testConcept9 activity")
    public static PageElement deleteActivityTestConcept9;
    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])//following-sibling::td//i[@class='dmc-icon__copy dmc-icon']" , desc= "copy btn of testConcept9 activity")
    public static PageElement copyActivityTestConcept9;
    @Element(xpath = "(//td[contains(., ' TestConcept9Copy ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "delete btn of testConcept9Copy activity")
    public static PageElement deleteActivityTestConcept9Copy;
    @Element(xpath = "//div[@class = 'ace_layer ace_text-layer']", desc = " activity description input ")
    private static PageElement activityDescriptionInput;
    @Element(xpath = "//button[text()=' Save Changes ']", desc = "Confirm add new activity button ")
    private static PageElement confirmSaveEditButton;
    @Element(xpath = "(//td[contains(., ' TestConcept9Copy ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit btn of the testConcept9Copy")
    private static PageElement editActivityTestConcept9Copy;
    @Element(xpath = "(//td[contains(., ' test2806B ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit btn of the test2806B")
    private static PageElement editActivitytest2806B;
    @Element(xpath = "(//td[contains(., ' test2811B ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit btn of the test2811B")
    private static PageElement editActivitytest2811B;
    @Element(xpath = "(//td[contains(., ' test2812 ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit btn of the test2812")
    private static PageElement editActivitytest2812;
    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc= "edit activities btn of TestConcept9")
    public static PageElement activityTestConcept9EditIcon;
    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])", desc= " testConcept activity")
    public static PageElement activityTestConcept9;
    @Element(xpath = "(//td[contains(., ' TestConcept9 ')])//following-sibling::td//i[@class='dmc-icon__play dmc-icon']", desc = "run btn of the testConcept9Copy")
    private static PageElement runActivityTestConcept9;
    @Element(xpath = "//table[@id = 'dmc-table-activities']", desc = "activities table")
    private static PageElement activitiesTable;
    @Element(xpath = "(//td[contains(., ' Test_Concept-04 ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "delete btn of testConcept9 activity")
    public static PageElement deleteActivityTest_Concept_04;
    @Element(xpath = "//td[contains(., ' test2805 ')]", desc= " test2805 activity")
    public static PageElement test2805Activity;
    @Element(xpath = "(//td[contains(., ' test2805 ')])//following-sibling::td//i[@class='dmc-icon__trash dmc-icon']", desc= "delete btn of test2805 activity")
    public static PageElement deleteActivityTest2805;
    @Element(xpath = "//td[contains(., ' test2806A ')]", desc= " test2806A activity")
    public static PageElement test2806AActivity;
    @Element(xpath = "//td[contains(., ' test2806B ')]", desc= " test2806B activity")
    public static PageElement test2806BActivity;
    @Element(xpath = "//td[contains(., ' test2807 ')]", desc= " test2807 activity")
    public static PageElement test2807Activity;
    @Element(xpath = "//td[contains(., ' test2812 ')]", desc= " test2812 activity")
    public static PageElement test2812Activity;
    @Element(xpath = "//td[contains(., ' concep01 ')]", desc= " concep01 activity")
    public static PageElement concep01Activity;
    @Element(xpath = "(//td[contains(., ' concep01 ')])//following-sibling::td//i[@class='dmc-icon__pencil dmc-icon']", desc = "edit btn of the concep01")
    private static PageElement editActivityconcep01;
    @Element(xpath = "//tr[contains(., 'concep01')]/td[3][contains(.,'prova')]", desc = "note field of concep01")
    private static PageElement concep01NoteField;
    @Element(xpath = "//tr[contains(., 'concep01')]/td[3][contains(.,'NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjj')]", desc = "note field of concep01")
    private static PageElement concep01NoteFieldEdited;
    @Element(xpath = "//tr[contains(., 'test2812')]/td[3][contains(.,'prova')]", desc = "note field of concep01")
    private static PageElement test2812NoteField;
    @Element(xpath = "//tr[contains(., 'test2812')]/td[3][contains(.,'NhFh5ZcLWf2K0I0HJznHyj9gJ61zmCQnYwVPcEO4Bxk8pTaUtSvDsRuX7e3bqioAlyrGtMdfE4sNvxu2jL1kRiPqoZaBhQ9eKcT6g3oVbW6eUI5wJmrxKPZdDOLRf8zXh9yN10nlYCaBt7pSiEqkFsu2TAHcMjQ4NyEvG1afGl9SjPz0YJb8EC1yIkdp4tHwQiKo5vZBunWU6aXx7VcO3AmRq2TrsMhLNDeFk1zw3RxqIPnaG0JmXjfdpCcUB76OyT84VluEgsLDclTVEfGHuyi3qgZnF9bkKjzBr81M2mxQJY7tN4hpwO5I0aeo6vPASRXWUD9XVmbhZugwoaKTp7jyCNHx58MlERcQrtv2O6W1i0ILBf3UqYsSkzPnAeJF46p6UekjmRGKvV8Wqt9HY5gbnyzr7MfFhOZiCsxuNLEPc10wQ2DXlJaBdTA3ISo4BNm6i3YKaWopHfUxG5gzy9XZcjJ0FtQ4e1lwqk7RSu2v8dVbOsrLPEhTADnCvIx8N7unywOZakPCV1G5djvESJc4RtKmeYlHgohiXqFz0Q2b3psI9MTB6UfLrAqToDWuV7iYJGL9XkZc8HNjIbn1M6exsK0gPfTRzmyhQ32aEpB5vASrFtUq4OwCdoxnhoqusjblcnsajocbnsajocnakncvdiojlvbndjikvnjoxzlnvskjcsijdhiuhjcnuijshdicashjdxicsaojdajncuodajhcjioadskjdouasjjhjjsjchihfshjfshjjjsjwjadoshfoidsdjisjdiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwbhsbsoacbsicnqswecvbhqiwjojdudfbcnjoidugfhbnjsiueyfghdjskaiuwehydtszxfcvghbjiuhygtfrgyftdrcfvgbhnjhugyftrdcfvgbhjnbhubusmwonqdbjefoqhwfjdwdojqwdjwqdioqwjjjwdjj')]", desc = "note field of concep01")
    private static PageElement test2812NoteFieldEdited;
    @Element(xpath = "//td[contains(., ' test2808 ')]", desc= " test2808 activity")
    public static PageElement test2808Activity;
    @Element(xpath = "//td[contains(., ' test2809 ')]", desc= " test2809 activity")
    public static PageElement test2809Activity;
    @Element(xpath = "//td[contains(., ' test2810 ')]", desc= " test2810 activity")
    public static PageElement test2810Activity;
    @Element(xpath = "//td[contains(., ' test2811B ')]", desc= " test2811B activity")
    public static PageElement test2811BActivity;
    @Element(xpath = "//td[contains(., ' test2814 ')]", desc= " test2811B activity")
    public static PageElement test2814Activity;
    @Element(xpath = "//td[contains(., ' test2816 ')]", desc= " test2811B activity")
    public static PageElement test2816Activity;
    @Element(xpath = "//td[contains(., ' test2817 ')]", desc= " test2811B activity")
    public static PageElement test2817Activity;

    //Elements for translation//
    @Element(xpath = "//h2[contains(text(), 'Attività')]", desc = "Activities lending page title it")
    private static PageElement activitiesLandingPageTitleIT;

    public static PageElement getActivitiesLandingPageTitleIT() {
        return activitiesLandingPageTitleIT;
    }

    @Element(xpath = "//i[@dmcicon='table-columns']", desc = "select column icon")
    private static PageElement selectColumnsIcon;

    public static PageElement getSelectColumnsIcon() {
        return selectColumnsIcon;
    }

    @Element(xpath = "//li/button[contains(., 'Reimposta larghezza colonne')]", desc = "resize columns option")
    private static PageElement resizeColumnsIT;

    public static PageElement getResizeColumnsIT() {
        return resizeColumnsIT;
    }

    @Element(xpath = "//li/button/span", desc = "close button columns")
    private static PageElement closeColumnsBTN;

    public static PageElement getCloseColumnsBTN() {
        return closeColumnsBTN;
    }

    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Id attivazione') and @class='-header']", desc = "id attivazione column ")
    private static PageElement activityIdColumnIT;
    @Element(xpath = "//th[contains(@class,'column')]//div[contains(., 'Data creazione') and @class='-header']", desc = "data creazione column ")
    private static PageElement creationDateColumnIT;

    public static PageElement getActivityIdColumnIT() {
        return activityIdColumnIT;
    }

    public static PageElement getCreationDateColumnIT() {
        return creationDateColumnIT;
    }

    @Element(xpath = "//li/div[contains(., 'ID ATTIVAZIONE')]", desc = "ID ATTIVAZIONE")
    private static PageElement selectActivityIdIT;

    @Element(xpath = "//li/div[contains(., 'DATA CREAZIONE')]", desc = "DATA CREAZIONE")
    private static PageElement selectCreationDateIT;

    public static PageElement getSelectActivityIdIT() {
        return selectActivityIdIT;
    }

    public static PageElement getSelectCreationDateIT() {return selectCreationDateIT;}

    @Element(xpath = "//i[contains(@class, 'dmc-icon__play')]", desc = "play icon")
    private static PageElement playIcon;
    public static PageElement getPlayIcon() {return playIcon;}
    @Element(xpath = "//input[@type='search']", desc = "search box")
    private static PageElement searchBox;

    @Element(xpath = "//input[@placeholder='Search for Activity ID']", desc = "Search input box")
    private static PageElement searchInputBox;

    @Element(xpath = "//i[@class='-header-icon dmc-icon__refresh dmc-icon-size-large dmc-icon']", desc = "Refresh search")
    private static PageElement refresh;
    @Element(xpath = "//span[text()='tag']/following-sibling::span[contains(.,'Test2')]", desc = "Tag Activity")
    private static PageElement tagActivityUpdated;
    @Element(xpath = "(//button[contains(.,'Back')])[2]", desc = "Back Button")
    private static PageElement backButton;
    @Element(xpath = "(//button[contains(.,'Back')])", desc = "Activity Back Button")
    private static PageElement activityBackButton;

    @Element(xpath = "//dmc-table-sequential-paginator", desc = "Paginator")
    private static PageElement paginator;

    @Element(xpath = "//mat-select", desc = "Rows selector")
    private static PageElement paginatorSelectRows;

    @Element(xpath = "//span[@class='mat-option-text' and contains(., '5')]", desc = "Rows selector")
    private static PageElement paginator5Rows;

    @Element(xpath = "//span[@class='mat-option-text' and contains(., '100')]", desc = "Rows selector")
    private static PageElement paginator100Rows;

    @Element(xpath = "//i[@class='-navigation-arrow --next dmc-icon__chevron-right dmc-icon-size-small dmc-icon']", desc = "Next page")
    private static PageElement nextPage;

    @Element(xpath = "//i[@class='dmc-icon__document dmc-icon']", desc = "Show Details Activity")
    private static PageElement showDetailsActivity;

    @Element(xpath = "//i[@class='dmc-icon__trash dmc-icon']", desc = "Delete Activity")
    private static PageElement deleteActivity;

    @Element(xpath = "//i[@class='dmc-icon__play dmc-icon']", desc = "Play Activity")
    private static PageElement playActivity;

    @Element(xpath = "//i[@class='dmc-icon__copy dmc-icon']", desc = "Copy Activity")
    private static PageElement copyActivity;

    @Element(xpath = "//i[@class='dmc-icon__pencil dmc-icon']", desc = "Edit Activity")
    private static PageElement editActivity;

    @Element(xpath = "//i[@class='dmc-icon__plus dmc-icon ng-star-inserted']", desc = "New Activity")
    private static PageElement newActivityButton;

    @Element(xpath = "//dmc-form-field-label[contains(., 'Notes')]/following-sibling::p[contains(., 'testing note')]", desc = "Notes field")
    private static PageElement notes;
}
