package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import main.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.Util;
import ta.entities.elements.PageElement;
import ta.utilities.Configuration;
import ta.utilities.ReflectionUtils;
import test.pages.HomePage;
import test.pages.LoginPage;
import test.pages.NotificationsConfigurationsPage;
import test.pages.ProjectPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomePageSteps {

    public static boolean isLogout() {
        return logout;
    }

    public static void setLogout(boolean logout) {
        HomePageSteps.logout = logout;
    }

    private static boolean logout = false;


    @Then("I enter the HomePage")
    public static void checkHomePage() {
        if (HomePage.getFormLogin().isPresent(10)) {
            if (HomePage.getUsernameInput().isPresent(10)) {
                CommonPage.getDriver().findElement(HomePage.getUsernameInput().getBy()).sendKeys(Configuration.get("dmc.username"));
                CommonPage.getDriver().findElement(HomePage.getUsernameInput().getBy()).sendKeys(Keys.ENTER);
                if (HomePage.getPswInput().isPresent(10)) {
                    CommonPage.getDriver().findElement(HomePage.getPswInput().getBy()).sendKeys(Configuration.get("dmc.password"));
                    CommonPage.getDriver().findElement(HomePage.getKeepMeSignInBTN().getBy()).click();
                    CommonPage.getDriver().findElement(HomePage.getSignInBTN().getBy()).click();
                }
            } else {
                HomePage.getUserInTheFormLoginLogout().click();
                if (HomePage.getPswInput().isPresent(10)) {
                    CommonPage.getDriver().findElement(HomePage.getPswInput().getBy()).sendKeys(Configuration.get("dmc.password"));
                    CommonPage.getDriver().findElement(HomePage.getKeepMeSignInBTN().getBy()).click();
                    CommonPage.getDriver().findElement(HomePage.getSignInBTN().getBy()).click();
                }
            }
            HomePage.getYesBTN().click();
            //check i'm on the homepage (with the icon)
            }

    }

    @Then("I check the presence of Enter button and then I click on it")
    public static void checkThePresenceOfButtonEnterAndThenIClick(){
        if(HomePage.getCardProject().isPresent(20)){
            if (!HomePage.getEnterBTN().isPresent(10)) {
                HomePage.getCardProject().click();
                Assert.assertTrue(HomePage.getEnterBTN().isVisible(10), "Button Enter not present!");
            }
            HomePage.getEnterBTN().click();
        }else{
            Assert.fail("No project found!");
        }
    }

    @Then("I enter into the project")
    public static void enterIntoTheProject() {
        if(HomePage.getClearBTN().isPresent(15)){
            HomePage.getClearBTN().click();
        }

        if (HomePage.getCardProject().isPresent(20)) {
            if (!HomePage.getWhiteSelectBar().isPresent(10)) {
                HomePage.getCardProject().click();
            }
            Assert.assertTrue(HomePage.getEnterBTN().isVisible(10), "Button Enter not present!");
            HomePage.getEnterBTN().click();
            if (!HomePage.getProgressBar().isInvisible(40)) {
                Assert.fail("progress bar ancora visibile dopo 40 secondi!");
            }
        } else {
            Assert.fail("No project found!");
        }
    }

    @Then("I enter into the project (Perf)")
    public static void enterIntoTheProjectPerf() {
        List<WebElement> selectedProjs = CommonPage.getDriver().findElements(HomePage.getCardSelected().getBy());
        /*precondizione*/
        /*pulisco eventuali progetti selezionati: si può fare anche con il Clear*/
        if (HomePage.getCardSelected().isPresent(20)) {
            for (WebElement selproj : selectedProjs) {
                selproj.click();
            }
        }

        if (HomePage.getProjectEsolPerf().isPresent(20)) {
            //if (!HomePage.getWhiteSelectBar().isPresent(10)) { //Da ottimizzare, lento: se ho deselezionato tutto non è necessario
            HomePage.getProjectEsolPerf().click();
            //}
            Assert.assertTrue(HomePage.getEnterBTN().isVisible(10), "Button Enter not present!");
            HomePage.getEnterBTN().click();
            if (!HomePage.getProgressBar().isInvisible(40)) {
                Assert.fail("progress bar ancora visibile dopo 40 secondi!");
            }
        } else {
            Assert.fail("No project found!");
        }
    }


    @Then("I check HomePage elements: BackBTN, SearchBar, FilterBox, Cards fav, Cards noFav, ClearBtn, EnterBtn")
    public static void checkHomePageElements() throws InterruptedException {
        Assert.assertTrue(HomePage.getBackBTN().isPresent(), "Back button not found");
        Assert.assertTrue(HomePage.getSearchProjectsBar().isPresent(), "Search projects bar not found");
        Assert.assertTrue(HomePage.getFilterBoxBelowSelectedProjects().isPresent(), "Filter box below selected projects not found");

        //*I check that the favourites option moves the Project card correctly.*//
        HomePageSteps.checkCardUnderLine();

        if (!HomePage.getWhiteSelectBar().isPresent()) {
            HomePage.getCardProject().click();
            Assert.assertTrue(HomePage.getWhiteSelectBar().isPresent(), "Clear and Enter bar when select the project not found");
        }
        Assert.assertTrue(HomePage.getClearBTN().isPresent(), "Clear button not found");
        Assert.assertTrue(HomePage.getEnterBTN().isPresent(), "Enter button not found");
        checkSizeCards();
    }

    @Then("I check HomePage elements: SearchBar, FilterBox, Cards fav, Cards noFav, ClearBtn, EnterBtn")
    public static void checkHomePageElementsNoBackButton() throws InterruptedException {
        //Assert.assertTrue(HomePage.getBackBTN().isPresent(), "Back button not found");
        Assert.assertTrue(HomePage.getSearchProjectsBar().isPresent(), "Search projects bar not found");
        Assert.assertTrue(HomePage.getFilterBoxBelowSelectedProjects().isPresent(), "Filter box below selected projects not found");

        //*I check that the favourites option moves the Project card correctly.*//
        HomePageSteps.checkCardUnderLine();

        if (!HomePage.getWhiteSelectBar().isPresent()) {
            HomePage.getCardProject().click();
            Assert.assertTrue(HomePage.getWhiteSelectBar().isPresent(), "Clear and Enter bar when select the project not found");
        }
        Assert.assertTrue(HomePage.getClearBTN().isPresent(), "Clear button not found");
        Assert.assertTrue(HomePage.getEnterBTN().isPresent(), "Enter button not found");

        checkSizeCards();

    }

    @Then("I come back to HomePage from the project page")
    public static void comeBackToHomePage() {
        if (ProjectPage.getButtonToReturnHomePage().isPresent(10)) {
            ProjectPage.getButtonToReturnHomePage().scrollTo();
            ProjectPage.getButtonToReturnHomePage().click();
            Assert.assertTrue(HomePage.getSearchProjectsBar().isPresent(20), "Unable to find the search input box in order to understand if the test is on HomePage");
        } else {
            Assert.fail("Impossible to come back to HomePage!");
        }
    }

    @Then("I check I'm on the Project Page again")
    public static void projectPageAgain() {
        if (!HomePage.getProgressBar().isInvisible(50)) {
            Assert.fail("progress bar ancora visibile dopo 50 secondi!");
        }
        Assert.assertTrue(ProjectPage.getSlideBarOfTheProject().isPresent(), "Can't check I'm on the Project Page again");

    }

    public static void handleAlert(){
        if(isAlertPresent()){
            Alert alert = CommonPage.getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }
    }
    public static boolean isAlertPresent(){
        try{
            CommonPage.getDriver().switchTo().alert();
            return true;
        }catch(NoAlertPresentException ex){
            return false;
        }
    }
    @Then("I click on the user icon and log out.")
    public static void logOut() throws InterruptedException {
        if (HomePage.getUserIcon().isPresent(20)) {
            HomePage.getUserIcon().click();

            if (HomePage.getLogoutIcon().isPresent(20)) {
                HomePage.getLogoutIcon().click();
                Thread.sleep(10000);
                if(isAlertPresent()){
                    Alert alert = CommonPage.getDriver().switchTo().alert();
                    System.out.println(alert.getText());
                    alert.accept();
                }
                Thread.sleep(10000);
                HomePage.getUserInTheFormLoginLogout().click();
                Assert.assertTrue(LoginPage.getLoginBtn().isPresent(60), "Logout not performed correctly!");
                UtilFunctions.addScreenshot("logout performed");
                setLogout(true);
            }else{
                    Assert.fail("Can't find logout button.");
                 }
            }else {
            Assert.fail("User logged in icon not present.");
        }
        CommonPage.getDriver().manage().deleteAllCookies();
    }
    @Then("I check bar is filled with project name")
    public void iCheckBarIsFilledWithProjectName() throws InterruptedException {
        /*precondizione*/
        /*pulisco eventuali progetti selezionati*/
        selectOrDeselectAllProjects("deselect");
        List<WebElement> selectedProject = CommonPage.getDriver().findElements(HomePage.getSelectedProjectBar().getBy());

        //Now no projects should be selected, so I click on each of them
        if (selectedProject.isEmpty()) {
             selectOrDeselectAllProjects("select");
        }else{
            Assert.fail("After deselection of all projects, the bar is still filled with names of the projects");
        }

        selectedProject = CommonPage.getDriver().findElements(HomePage.getSelectedProjectBar().getBy());
        List<WebElement> cards = CommonPage.getDriver().findElements(HomePage.getCardSelectedName().getBy());
        List<String> namesInBar = new ArrayList<>();

        for(WebElement project : selectedProject){
            namesInBar.add(project.getText().trim().toLowerCase(Locale.ROOT));
        }

        for (WebElement card: cards) {
            //I check that the name of the selected project card has the same name as the "Selected Projects:" in the title
            Assert.assertTrue(namesInBar.contains(card.getText().trim().toLowerCase(Locale.ROOT)), "String card name project different from the Selected Projects title!");

        }
        selectOrDeselectAllProjects("deselect");
    }


    @Then("I control Enter and if Clear Button works")
    public void iControlEnterAndClearButton() {
        //Control if project selected otherwise i click on it
        if (!HomePage.getWhiteSelectBar().isPresent()) {
            HomePage.getCardProject().click();
        }
        //Check if Clear and Enter are present
        Assert.assertTrue(HomePage.getClearBTN().isPresent(), "Clear button not found");
        Assert.assertTrue(HomePage.getEnterBTN().isPresent(), "Enter button not found");
        //Check if Clear works properly
        HomePage.getClearBTN().click();
        Assert.assertFalse(HomePage.getCardSelected().isPresent(), "Clear button not working properly");
    }


    @Then("I check if filter box is on top")
    public void iCheckIfFilterBoxIsOnTop() {
        Assert.assertTrue(HomePage.getFilterBoxBelowSelectedProjects().isPresent(), "Filter on top not found");
    }

    @Then("I check that the Project Menu correctly translated")
    public void checkTranslationProjectMenu() throws IOException {
        //*Open the filter bar to show all the element with text*//
        String [] tree  = new String[]{"projectList"};
        CommonSteps.jsonReader(tree, "selectProjects", HomePage.getSelectedProjectsTextIT().getText(),null);
        PageElement pe = UtilFunctions.createNewPageElement("search bar projects", "//input[@placeholder='Cerca i progetti']");
        CommonSteps.jsonReader(null, "SearchProjects", pe.getAttribute("placeholder"),null);


        HomePage.getIconArrowFilterBoxHomePage().click();
        tree  = new String[]{"controlRoom"};

        CommonSteps.jsonReader(tree, "filters", HomePage.getFilterTextIT().getText(),null);
        CommonSteps.jsonReader(tree, "confirm", HomePage.getConfirmBTNTextIT().getText(),null);
        CommonSteps.jsonReader(tree, "reset", HomePage.getClearBTNTextIT().getText(),null);

        tree  = new String[]{"filters"};
        CommonSteps.jsonReader(tree, "commonName", HomePage.getNameFilterTextIT().getText(),null);
        CommonSteps.jsonReader(tree, "region", HomePage.getRegionFilterTextIT().getText(),null);

        tree  = new String[]{"components", "multiSelect"};
        CommonSteps.jsonReader(tree, "defaultLabel", HomePage.getDropDownMenuRegion().getText(),null);

        HomePage.getIconArrowFilterBoxHomePage().click();

        tree  = new String[]{"projectList"};
        if (!HomePage.getWhiteSelectBar().isPresent()) {
            HomePage.getProjectEsolPerf().click();
        }
        CommonSteps.jsonReader(tree, "enter", HomePage.getEnterBTNTextIT().getText(),null);
        CommonSteps.jsonReader(tree, "clear", HomePage.getCancelBTNTextIT().getText(),null);
    }

    @Then("I check that the favourites option moves the Project card correctly.")
    public static void checkCardUnderLine() {
        Assert.assertTrue(HomePage.getFavouriteStar().isPresent(), "star for the favourite selection not found.");
        if (!HomePage.getFavouriteStarActive().isPresent()){
            //*If the star is not active, the card should be under the line*//
            Assert.assertTrue(HomePage.getCardUnderTheBlackLine().isPresent());
            HomePage.getFavouriteStar().click();
            //*If I select as favourite, the star should be active and the card should be above the line*//
            Assert.assertTrue(HomePage.getFavouriteStarActive().isPresent(5));
            Assert.assertTrue(HomePage.getCardAboveTheBlackLine().isPresent());
            //*Clear*//
            HomePage.getFavouriteStarActive().click();
        }else{
            Assert.assertTrue(HomePage.getCardAboveTheBlackLine().isPresent());
            HomePage.getFavouriteStar().click();
            //*If the star is cleared, the card should be under the line*//
            Assert.assertTrue(HomePage.getCardUnderTheBlackLine().isPresent());
            //*Se la card è tra i favoriti, la reinserisco?*//
            //HomePage.getFavouriteStar().click();
        }

    }

    @Then("I check that cards have the same size")
    public static void checkSizeCards() throws InterruptedException {
        List<WebElement> cardProjectSelected = CommonPage.getDriver().findElements(HomePage.getCardProjectsSelected().getBy());
        if(cardProjectSelected!= null && !cardProjectSelected.isEmpty()){
            for (WebElement we: cardProjectSelected) {
                we.click();
            }
        }
        Thread.sleep(3000);
        List<WebElement> wesFav = CommonPage.getDriver().findElements(HomePage.getCardsAboveTheBlackLine().getBy());
        int prev_height_fav = 0;
        int prev_width_fav = 0;

        for (WebElement we: wesFav) {
            int height = we.getRect().height;
            int width = we.getRect().width;
            if (prev_height_fav!=0 & prev_width_fav!=0) {
                Assert.assertEquals(prev_height_fav, height, "The height is different. Prev height fav: "+prev_height_fav+" - height new fav: "+height);
                Assert.assertEquals(prev_width_fav, width, "The width is different. Prev width fav: "+prev_width_fav+" - height new fav: "+width);
            }
            prev_height_fav = height;
            prev_width_fav = width;
        }

        Thread.sleep(1500);
        int prev_height_notFav = 0;
        int prev_width_notFav = 0;
        List<WebElement> wesNotFav = CommonPage.getDriver().findElements(HomePage.getCardsUnderTheBlackLine().getBy());
        if(wesNotFav!= null && !wesNotFav.isEmpty()){
            prev_height_notFav = wesNotFav.get(1).getRect().height;
            prev_width_notFav = wesNotFav.get(1).getRect().width;
        }

        assert wesNotFav != null;
        for (WebElement we: wesNotFav) {
            System.out.println("# - Card: "+we.getText());
            int height = we.getRect().height;
            int width = we.getRect().width;
            if (prev_height_notFav!=0 & prev_width_notFav!=0) {
                Assert.assertEquals(prev_height_notFav, height, "The height is different. Prev height not fav: "+prev_height_notFav+" - height next not fav: "+height);
                Assert.assertEquals(prev_width_notFav, width, "The width is different. Prev width  not fav:  "+prev_width_notFav+" - height next not fav: "+width);
            }
            prev_height_notFav = height;
            prev_width_notFav = width;
        }

    }


    @Then("I enter on esol - qa project")
    public static void enterOnQaProject() {
        //Control on white bar because the clear button is always present
        if (HomePage.getWhiteSelectBar().isPresent(20)){
            HomePage.getClearBTN().click();
        }
        if (HomePage.getProjectEsolQa().isPresent()) {
            HomePage.getProjectEsolQa().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("No project found!");
        }
    }
    @Then("I enter on esol - perf project")
    public static void enterOnPerfProject() {
        if (HomePage.getWhiteSelectBar().isPresent(20)){
            HomePage.getClearBTN().click();
        }
        if (HomePage.getProjectEsolPerf().isPresent()) {
            HomePage.getProjectEsolPerf().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("No project found!");
        }
    }


    @Then("I check that I properly apply the filter on ESOL-perf project.")
    public static void checkFilterOnPerf() {
        List<WebElement> filteredCard = CommonPage.getDriver().findElements(HomePage.getNameProjectCart().getBy());
        if (filteredCard.size() == 1) {
             //I check that the name of the filtered project card has the right name.
             Assert.assertEquals(filteredCard.get(0).getText().trim().toLowerCase(), "esol-ap29551-perf", "String card name project different from the Filtered Projects title!");
        } else {
            Assert.fail("More projects present after filter ID/Name application.");
        }
    }

    @Then("I check that I properly apply the EU Region 1 filter.")
    public static void checkRegionFilter() {
        List<WebElement> filteredCard = CommonPage.getDriver().findElements(HomePage.getCardBottomWithRegion().getBy());


            for (WebElement el : filteredCard) {
            //I check that the filtered projects have the right region.
            Assert.assertEquals(el.getText().trim().toLowerCase(), "eu-central-1", "String card region project different from the Filtered Projects region!");
            }
        }


    @Then("I enter on esol - test project")
    public static void enterOnTestProject() {
        if (HomePage.getClearBTN().isPresent(20)){
                HomePage.getClearBTN().click();
        }

        if (HomePage.getProjectEsolTest().isPresent()) {
            HomePage.getProjectEsolTest().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("No project found!");
        }
    }


    @Then("I select all the projects and then I check presence of these at the top of the page")
    public static void checkMultipleSelection() throws InterruptedException {
        //Clear se white bar presente - cosi non ho nessun progetto selezionato
        if (HomePage.getClearBTN().isPresent(20)) {
            HomePage.getClearBTN().click();
        }
        //Seleziono tutti i progetti
        selectOrDeselectAllProjects("select");
        List<WebElement> selectedProject = CommonPage.getDriver().findElements(HomePage.getCardSelected().getBy());
        List<WebElement> selectedProjectBar = CommonPage.getDriver().findElements(HomePage.getSelectedProjectBar().getBy());
        if(selectedProject!= null && selectedProjectBar!=null){
            Assert.assertEquals(selectedProject.size(), selectedProjectBar.size(), "The selected project are different from the expected ones");
        }else{
            Assert.fail("An Error occur during the retriving the number of selected projects");
        }
    }

    @Then("I check presence of projects selected at the top of the page")
    public static void checkMultipleSelectedProjects() throws InterruptedException {

        List<WebElement> selectedProject = CommonPage.getDriver().findElements(HomePage.getCardSelected().getBy());
        List<WebElement> selectedProjectBar = CommonPage.getDriver().findElements(HomePage.getSelectedProjectBar().getBy());
        if(selectedProject!= null && selectedProjectBar!=null){
            Assert.assertEquals(selectedProject.size(), selectedProjectBar.size(), "The selected project are different from the expected ones");
        }else{
            Assert.fail("An Error occur during the retriving the number of selected projects");
        }
    }

    @Then("I \"(.+)\" all the project")
    public static void selectOrDeselectAllProjects(String choice) throws InterruptedException {
        Thread.sleep(2000);
        if(HomePage.getCardProject().isPresent(15)){
            if(choice.equalsIgnoreCase("deselect")){
                List<WebElement> selectedProjs = CommonPage.getDriver().findElements(HomePage.getCardSelected().getBy());
                clickAllElementIntoTheList(selectedProjs);
            }else if(choice.equalsIgnoreCase("select")){
                List<WebElement> projs = CommonPage.getDriver().findElements(HomePage.getCardProject().getBy());
                clickAllElementIntoTheList(projs);
            }
        }else{
            Assert.fail("No projects found in 15 sec");
        }

    }

    @Then("I select top 5 projects")
    public static void selectTopFiveProjects() throws InterruptedException {
        Thread.sleep(2000);
        if(HomePage.getCardProject().isPresent(15)){
            List<WebElement> projs = CommonPage.getDriver().findElements(HomePage.getCardProject().getBy());
            clickTopFiveElements(projs);
        }else{
            Assert.fail("No projects found in 15 sec");
        }
    }

    public static void clickTopFiveElements(List<WebElement> list) throws InterruptedException {
        if(list!= null && !list.isEmpty()){
            for(int i = 0; i < 5; i++){
                list.get(i).click();
                Thread.sleep(500);
            }
        }
    }

    public static void clickAllElementIntoTheList(List<WebElement> list) throws InterruptedException {
        if(list!= null && !list.isEmpty()){
            for (WebElement el : list) {
                el.click();
                Thread.sleep(500);
            }
        }
    }

    @Then("I try to swipe through the projects")
    public static void tryToSwipeCardsOfSelectedProject() throws InterruptedException {
        Actions action = new Actions(CommonPage.getDriver());
        WebElement projectToCheck = CommonPage.getDriver().findElement(By.xpath("(//span[@class='chip ng-star-inserted'])[2]"));
        int pos = projectToCheck.getLocation().x;
        projectToCheck.click();
        for(int i = 0; i< 3 ;i++){
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(500);
        }
        projectToCheck = CommonPage.getDriver().findElement(By.xpath("(//span[@class='chip ng-star-inserted'])[2]"));
        int newPos = projectToCheck.getLocation().x;
        Assert.assertTrue(pos!=newPos, "Cards was not swiped ");
    }


    @Then("I enter on esol-ap29551-qa project and esol-ap29551-test project")
    public static void enterMultiProjectMode() {
        if (HomePage.getClearBTN().isPresent(20)){
            HomePage.getClearBTN().click();
        }
        if (HomePage.getProjectEsolQa().isPresent() && HomePage.getProjectEsolTest().isPresent()) {
            HomePage.getProjectEsolQa().click();
            HomePage.getProjectEsolTest().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("No project esol-ap29551-qa project and esol-ap29551-test found!");
        }
    }


    @Then("I enter first two projects")
    public static void enterFirstTwoProjects() {
        if (HomePage.getClearBTN().isPresent(20)){
            HomePage.getClearBTN().click();
        }
        if (HomePage.getCardProjectBox().isPresent() && HomePage.getSecondProject().isPresent()) {
            HomePage.getSecondProject().click();
            HomePage.getCardProjectBox().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("No project esol-ap29551-qa project and esol-ap29551-test found!");
        }
    }


    @Then("If present i click Clear Button")
    public void ifPresentIClickClearButton() {
        if (HomePage.getClearBTN().isVisible(20)){
            HomePage.getClearBTN().click();
        }
    }
    @Then("If enter or clear button not present i click on a project")
    public void iClickOnAProject() {
        if (!HomePage.getClearBTN().isVisible(20)){
            HomePage.getFirstCardProject().click();
        }
    }


    private static String titleProject;
    private static String titleProject2;

    public static String getTitleProject() {return titleProject;}
    public static void setTitleProject(String titleProject) {HomePageSteps.titleProject = titleProject;}
    public static String getTitleProject2() {return titleProject2;}
    public static void setTitleProject2(String titleProject2) {HomePageSteps.titleProject2 = titleProject2;}

    @Then("I enter first two projects and save titles")
    public static void enterFirstTwoProjectsAndSaveTitles() {
        if (HomePage.getClearBTN().isPresent(20)){
            HomePage.getClearBTN().click();
        }
        if (HomePage.getFirstProjectTitle().isPresent() && HomePage.getSecondProjectTitle().isPresent()) {
            setTitleProject(HomePage.getFirstProjectTitle().getText());
            setTitleProject2(HomePage.getSecondProjectTitle().getText());
            HomePage.getSecondProjectTitle().click();
            HomePage.getFirstProjectTitle().click();
            if (HomePage.getEnterBTN().isPresent()){
                HomePage.getEnterBTN().click();
            }else{
                Assert.fail("Button Enter not present!");
            }
        }else {
            Assert.fail("There are not 2 project in the page");
        }
    }


    @Then("^I check the apm title are the same as saved")
    public static void checkAndClickElementTextIsPresent() throws Exception {
        List<WebElement> els = CommonPage.getDriver().findElements(ProjectPage.getIdApmCardTitle().getBy());
        List<String> origin = new ArrayList<>();
        String titleSaved = getTitleProject();
        String titleSaved2 = getTitleProject2();
        for (WebElement we : els) {
            String title = we.getText().toLowerCase();
            boolean condition = title.equalsIgnoreCase(titleSaved) || title.equalsIgnoreCase(titleSaved2);
            Assert.assertTrue(condition,"The titles are not the same");
        }
    }

    @Then("If present i click on Enter Button")
    public void ifPresentIClickenterButton() {
        if (HomePage.getEnterBTN().isVisible(20)){
            HomePage.getEnterBTN().click();
        }
    }

}

