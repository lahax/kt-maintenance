package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class HomePage {

    public static PageElement getFormLogin() {
        return formLogin;
    }

    public static PageElement getUsernameInput() {
        return usernameInput;
    }

    public static PageElement getPswInput() {
        return pswInput;
    }

    public static PageElement getProgressBar() {
        return progressBar;
    }

    public static PageElement getEnterBTN() {
        return enterBTN;
    }

    public static PageElement getInfoUserLoggedIn() {
        return infoUserLoggedIn;
    }

    public static PageElement getYesBTN() {
        return yesBTN;
    }

    public static PageElement getSignInBTN() {
        return signInBTN;
    }

    public static PageElement getKeepMeSignInBTN() {
        return keepMeSignInBTN;
    }

    public static PageElement getCardProject() {
        return cardProject;
    }

    /*Xpath*/
    @Element(xpath = "//div[@class='lightbox-cover']", desc = "form login")
    private static PageElement formLogin;
    @Element(xpath = "//input[@type='email']", desc = "username input box")
    private static PageElement usernameInput;
    @Element(xpath = "//input[@id='passwordInput']", desc = "password input box")
    private static PageElement pswInput;
    @Element(xpath = "//mat-spinner[@role='progressbar']", desc = "progress bar")
    private static PageElement progressBar;
    @Element(xpath = "//div[contains(@class, 'footer-container')]/div/button/parent::div[contains(@class, 'justify-content-center')]", desc = "white selection bar")
    private static PageElement whiteSelectBar;
    @Element(xpath = "//div[contains(@class, 'show')]//button[@type='button' and contains(text(), 'Clear')]", desc = "clear button")
    private static PageElement clearBTN ;
    @Element(xpath = "//div[contains(@class, 'show')]//button[@type='button' and contains(text(), 'Confirm')]", desc = "enter button visible")
    private static PageElement enterBTN ;
    @Element(xpath = "//span[contains(text(), 'ENELINT')]", desc = "info user logged in")
    private static PageElement infoUserLoggedIn;
    @Element(xpath = "//input[@type='submit']", desc = "yes button")
    private static PageElement yesBTN;
    @Element(xpath = "//span[@id='submitButton']", desc = "sign in  button")
    private static PageElement signInBTN;
    @Element(xpath = "//input[@type='checkbox']", desc = "keep me sign in Button")
    private static PageElement keepMeSignInBTN;
    @Element(xpath = "//div[@class='card-top']", desc = "all card project  max 30")
    private static PageElement cardProject;
    @Element(xpath = "(//div[@class='card-top'])[position() =2]", desc = "Second Project in the row")
    private static PageElement secondProject;
    @Element(xpath = "(//div[@class='card-top'])[position() =10]", desc = "Last Project in the row")
    private static PageElement lastProject;
    @Element(xpath = "(//div[@class='card-top'])[position() >= 1 and position() < 10]", desc = "First 10 Card Projects")
    private static PageElement firstTenCardProject;
    @Element(xpath = "(//div[@class='card-top'])[position()= 1]", desc = "Card project on position 1")
    private static PageElement firstCardProject;
    //@Element(xpath = "//dmc-input-container[contains(@class, 'dmc-search')]", desc = "search projects bar")
    @Element(xpath = "//input[@type = 'search']", desc = "search projects bar")
    private static PageElement searchProjectsBarElements;
    @Element(css = "dmc-input-container.dmc-search", desc = "search projects bar")
    private static PageElement searchProjectsBar;
    @Element(xpath = "//div[@class='divider mb-3 d-md-flex align-items-center justify-content-center']/following-sibling::node()/child::node()/child::node()[@class='dmc-card']/child::node()[@class='dmc-card-header']", desc = "filter box below selected projects")
    private static PageElement filterBoxBelowSelectedProjects;
    public static PageElement getHamburgerMenuIcon() {
        return hamburgerMenuIcon;
    }

    @Element(xpath = "//button/i[@dmcicon='menu']", desc = "hamburger menu icon")
    private static PageElement hamburgerMenuIcon;
    @Element(xpath = "//span[contains(text(), 'Language') or contains(text(), 'Lingua')]", desc = "Language sub option into info user button")
    private static PageElement languageSubOption;
    @Element(xpath = "//button[contains(text(), 'English')]", desc = "Button English sub option")
    private static PageElement buttonEnglishSubOption;
    @Element(xpath = "//button[contains(text(), 'Italiano')]", desc = "Button Italiano sub option")
    private static PageElement buttonItalianoSubOption;
    @Element(xpath = "//button[@withicon='left']", desc = "Back button")
    private static PageElement backBTN;
    @Element(xpath = "//div[@class='col card-project-id']", desc = "Name project on card")
    private static PageElement nameProjectCart;
    @Element(xpath = "//span[@class='chip ng-star-inserted']", desc = "Name  project on -Selected Projects:- bar")
    private static PageElement selectedProjectBar;
    @Element(xpath = "//div/i[@dmcicon='check-circle-filled']", desc = "Check icon on selected project card")
    private static PageElement checkIconSelectedProject;
    @Element(xpath = "//div[@class='card dmc-project-card card-selected']", desc = "Card selected")
    private static PageElement cardSelected;

    public static PageElement getWhiteSelectBar() {
        return whiteSelectBar;
    }

    public static PageElement getSearchProjectsBar() {
        return searchProjectsBar;
    }
    public static PageElement getNameProjectCart() {
        return nameProjectCart;
    }
    public static PageElement getSelectedProjectBar() {
        return selectedProjectBar;
    }

    public static PageElement getClearBTN() {
        return clearBTN;
    }

    public static PageElement getBackBTN() {
        return backBTN;
    }

    public static PageElement getFilterBoxBelowSelectedProjects() {
        return filterBoxBelowSelectedProjects;
    }

    @Element(xpath = "//span[@class='mat-button-wrapper']", desc = "Icon of user logged in")
    private static PageElement userIcon;

    public static PageElement getUserIcon() {
        return userIcon;
    }

    @Element(xpath = "//i[@dmcicon='logout']", desc = "logout icon")
    private static PageElement logoutIcon;

    public static PageElement getLogoutIcon() {
        return logoutIcon;
    }

    @Element(xpath = "(//div[@class='table-cell text-left content'])[1]", desc = "form of the user to make login/logout")
    private static PageElement userInTheFormLoginLogout;

    public static PageElement getUserInTheFormLoginLogout() {
        return userInTheFormLoginLogout;
    }


    public static PageElement getCheckIconSelectedProject() {
        return checkIconSelectedProject;
    }

    public static PageElement getCardSelected() {
        return cardSelected;
    }

    //*Elementi per controllo traduzione*//
    @Element(xpath = "//input[@type='search' and @placeholder='Cerca i progetti']", desc = "project research text IT")
    private static PageElement projectResearchTextIT;
    @Element(xpath = "//h2[contains(text(), 'Progetti Selezionati')]", desc = "selected projects text IT")
    private static PageElement selectedProjectsTextIT;
    @Element(xpath = "//h2[contains(text(), 'Filtri')]", desc = "filter text IT")
    private static PageElement filterTextIT;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Nome')]", desc = "field name in filter text IT")
    private static PageElement nameFilterTextIT;
    @Element(xpath = "//dmc-form-field-label[contains(text(), ' Regione')]", desc = "field region in filter text IT")
    private static PageElement regionFilterTextIT;
    @Element(xpath = "//button[contains(text(), 'Pulisci')]", desc = "clear button text IT")
    private static PageElement clearBTNTextIT;
    @Element(xpath = "//button[contains(text(), 'Cancella')]", desc = "cancel button text IT")
    private static PageElement cancelBTNTextIT;
    @Element(xpath = "//button[contains(text(), 'Entra')]", desc = "enter button text IT")
    private static PageElement enterBTNTextIT;
    @Element(xpath = "//button[contains(text(), 'Conferma')]", desc = "confirm button text IT")
    private static PageElement confirmBTNTextIT;
    //*Getter*//
    public static PageElement getProjectResearchTextIT() { return projectResearchTextIT; }
    public static PageElement getSelectedProjectsTextIT() { return selectedProjectsTextIT; }
    public static PageElement getFilterTextIT() { return filterTextIT; }
    public static PageElement getNameFilterTextIT() { return nameFilterTextIT; }
    public static PageElement getRegionFilterTextIT() { return regionFilterTextIT; }
    public static PageElement getClearBTNTextIT() { return clearBTNTextIT; }
    public static PageElement getCancelBTNTextIT() { return cancelBTNTextIT; }
    public static PageElement getEnterBTNTextIT() { return enterBTNTextIT; }
    public static PageElement getConfirmBTNTextIT() { return confirmBTNTextIT; }

    //*Icon Star and elements for favourite selection test*//
    @Element(xpath = "//div[@class='card-top']//div[contains(text(), ' esol-ap29551-qa ')]//ancestor::div[@class='card-top']//following-sibling::i[@dmcicon='star']", desc="Favourite star")
    private static PageElement favouriteStar;
    @Element(xpath = "//div[@class='card-top']//div[contains(text(), ' esol-ap29551-qa ')]//ancestor::div[@class='card-top']//following-sibling::i[@dmcicon='star' and contains(@class, '--active')]", desc="Favourite star active")
    private static PageElement favouriteStarActive;
    @Element(xpath = "//div[contains(@class,'dmc-project-cards')]/preceding-sibling::div//div[@class='card-top']//div[contains(text(), 'esol-ap29551-qa')]", desc="project card favourite")
    private static PageElement cardAboveTheBlackLine;
    @Element(xpath = "//div/following-sibling::div//div[@class='card-top']//div[contains(text(), 'esol-ap29551-qa')]", desc="project card not favourite")
    private static PageElement cardUnderTheBlackLine;
    public static PageElement getFavouriteStar() { return favouriteStar; }
    public static PageElement getFavouriteStarActive() { return favouriteStarActive; }
    public static PageElement getCardAboveTheBlackLine() { return cardAboveTheBlackLine; }
    public static PageElement getCardUnderTheBlackLine() { return cardUnderTheBlackLine; }

    @Element(xpath = "//div[contains(@class,'dmc-project-cards')]/preceding-sibling::div//div[@class='card-top']", desc="project cards favourite")
    private static PageElement cardsAboveTheBlackLine;
    @Element(xpath = "//div/following-sibling::div//div[@class='card-top']/parent::div[contains(@class, 'card-container')]", desc="project cards not favourite")
    private static PageElement cardsUnderTheBlackLine;

    public static PageElement getCardsAboveTheBlackLine() { return cardsAboveTheBlackLine; }
    public static PageElement getCardsUnderTheBlackLine() { return cardsUnderTheBlackLine; }

    @Element(xpath = "//div[@class='card dmc-project-card']", desc = "card project box")
    private static PageElement cardProjectBox;

    public static PageElement getCardProjectBox() {
        return cardProjectBox;
    }

    public static PageElement getSecondProject() {
        return secondProject;
    }

    public static PageElement getFirstCardProject() {
        return firstCardProject;
    }

    public static PageElement getCardProjectsSelected() {
        return cardProjectsSelected;
    }

    @Element(xpath = "//div[@class='card dmc-project-card card-selected']", desc = "card project selected")
    private static PageElement cardProjectsSelected;

    @Element(xpath = "//div[@class='card-top']//div[contains(text(), 'esol-ap29551-qa')]", desc="project card esol - qa")
    private static PageElement projectEsolQa;
    @Element(xpath = "//div[@class='card-top']//div[contains(text(), 'esol-ap29551-perf')]", desc="project card esol - perf")
    private static PageElement projectEsolPerf;
    @Element(xpath = "//div[@class='card-top']//div[contains(text(), 'esol-ap29551-test')]", desc="project card esol - test")
    private static PageElement projectEsolTest;
    @Element(xpath = "//span[contains(text(), ' If multiple projects are selected, not all features will be available. ')]", desc="white selection  multiple bar")
    private static PageElement multipleWhiteBar;


    public static PageElement getProjectEsolQa() {return projectEsolQa;}
    public static PageElement getProjectEsolPerf() {return projectEsolPerf;}


    @Element(xpath = "//div[@class='card dmc-project-card card-selected']//div[@class='col card-project-id']", desc="car selected name")
    private static PageElement cardSelectedName;

    public static PageElement getCardSelectedName() {
        return cardSelectedName;
    }
    @Element(xpath = "//dmc-form-field-label[contains(text(), 'ID')]/following-sibling::dmc-chips-autocomplete//input[@role='combobox']", desc="box for id in filter")
    private static PageElement boxForIdInFilter;

    @Element(xpath = "//dmc-form-field-label[contains(text(), 'Name')]/following-sibling::dmc-chips-autocomplete//input[@role='combobox']", desc="box for name in filter")
    private static PageElement boxForNameInFilter;

    @Element(xpath = "//dmc-form-field-label[contains(text(), 'Region')]/following-sibling::dmc-multi-select//dmc-multi-select-facade", desc="box for region in filter")
    private static PageElement boxForRegionInFilter;

    //@Element(xpath = "//dmc-form-field-label[contains(text(), 'Region')]/following-sibling::dmc-multi-select//dmc-multi-select-facade[@class='--open']", desc="open box for region in filter")
    //private static PageElement boxForRegionInFilterOpen;

    @Element(xpath = "//div[@id='dmc-affix-safenet']", desc="out box after region selection")
    private static PageElement outAfterRegionSelection;

    public static PageElement getBoxForIdInFilter() {
        return boxForIdInFilter;
    }

    public static PageElement getBoxForNameInFilter() {
        return boxForNameInFilter;
    }

    public static PageElement getBoxForRegionInFilter() {
        return boxForRegionInFilter;
    }

    @Element(xpath = "//div[@role='listbox']//span[contains(text(), 'esol-ap29551-perf')]", desc="button for select perf in box for id")
    private static PageElement selectPerfInIdFilterBox;

    public static PageElement getSelectPerfInIdFilterBox() {
        return selectPerfInIdFilterBox;
    }

    @Element(xpath = "//div[@role='listbox']//span[contains(text(), 'EGIP - PERF')]", desc="button for select perf in box for name")
    private static PageElement selectPerfInNameFilterBox;

    public static PageElement getSelectPerfInNameFilterBox() {
        return selectPerfInNameFilterBox;
    }

    @Element(xpath = "//dmc-multi-select-option//div[contains(text(), 'eu-central-1')]", desc="button for select EU Central 1 in box for region")
    private static PageElement selectEuCentral1InFilterBox;

    public static PageElement getSelectEuCentral1InFilterBox() {
        return selectEuCentral1InFilterBox;
    }

    @Element(xpath = "//button[contains(text(), 'Confirm')]", desc = "confirm button in filter")
    private static PageElement confirmFilterBTN;

    public static PageElement getConfirmFilterBTN() {
        return confirmFilterBTN;
    }

    @Element(xpath = "//form//button[contains(text(), 'Clear')]", desc = "clear button of filter")
    private static PageElement clearFilterBTN;

    public static PageElement getClearFilterBTN() {
        return clearFilterBTN;
    }

    @Element(xpath =  "//div[@class='card-bottom']//div[@class='col card-project-region']", desc = "card bottom with region")
    private static PageElement cardBottomWithRegion;

    public static PageElement getCardBottomWithRegion() {
        return cardBottomWithRegion;
    }

    public static PageElement getProjectEsolTest() {return projectEsolTest;}
    public static PageElement getMultipleWhiteBar() {return multipleWhiteBar;}
    public static PageElement getFirstTenCardProject() {return firstTenCardProject;}

    public static PageElement getProjectEsolChoiced() {
        return projectEsolChoiced;
    }

    @Element(xpath = "//div[@class='card-top']//div[contains(text(), '%s')]", desc="project card choiced at run time")
    private static PageElement projectEsolChoiced;


    public static PageElement getIconArrowFilterBoxHomePage() {
        return iconArrowFilterBoxHomePage;
    }

    @Element(xpath="//h2//following-sibling::i[@dmcicon='chevron-down']", desc="icon arrow FilterBox")
    private static PageElement iconArrowFilterBoxHomePage;

    public static PageElement getDropDownMenuRegion() {
        return dropDownMenuRegion;
    }

    @Element(xpath="//dmc-multi-select-facade", desc="dropdown menu Region into filter box")
    private static PageElement dropDownMenuRegion;

    @Element(xpath = "//span[contains(text(), 'Profile')]", desc = "profile sub option into info user button")
    private static PageElement profileSubOption;
    @Element(xpath = "//h1[contains(text(), 'rdmcntest003')]", desc = "basic user compac flag false profile landing page")
    private static PageElement basicUserCompacFlagFalseProfile;
    @Element(xpath = "//h1[contains(text(), 'rdmcntest002')]", desc = "basic user profile landing page")
    private static PageElement basicUserProfile;
    @Element(xpath = "//h1[contains(text(), 'rdmcntest001')]", desc = "admin user   profile landing page")
    private static PageElement adminUserProfile;

    public static PageElement getUserLoggedIn() {
        return userLoggedIn;
    }

    @Element(xpath = "//span[contains(@class, 'dmc-username-label') and contains(.,'ENELINT\\')]", desc = "user logged in")
    private static PageElement userLoggedIn;
    @Element(xpath = "(//div[@class='col card-project-id'])[1]", desc = "First project title")
    private static PageElement firstProjectTitle;
    @Element(xpath = "(//div[@class='col card-project-id'])[2]", desc = "Second project title")
    private static PageElement secondProjectTitle;

    public static PageElement getFirstProjectTitle() {
        return firstProjectTitle;
    }

    public static PageElement getSecondProjectTitle() {
        return secondProjectTitle;
    }
}
