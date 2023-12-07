package test.steps;


import Util.UtilFunctions;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.formatters.ReportFormatter;
import ta.steps.UISteps;
import test.pages.DevicesPage;
import test.pages.HomePage;
import test.pages.SoftwareCataloguePage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SoftwareCatalogueSteps {

    @Then("I check that the page Software Catalogue page is correctly translated in italiano")
    public static void checkTranslationSoftwareCataloguePage() throws IOException {

       String tree[] = new String[]{"controlRoom"};
        PageElement pe = UtilFunctions.createNewPageElement("title of the Page Sotware Catalogue", "//h2[contains(@class, 'dmc-header-title')]");
        CommonSteps.jsonReader(tree, "softwareCatalogue",pe.getText().trim(), null);

        tree = new String[]{"controlRoom","swManager"};
        pe = UtilFunctions.createNewPageElement("Search box at the top right", "//input[@type='search']");
        //CommonSteps.jsonReader(tree,"searchSoftwareCatalogue", pe.getAttribute("placeholder").trim(), null );

        tree = new String[]{"controlRoom"};
        pe = UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div");
        Assert.assertTrue(pe.tryClick(false, false), "Unable to click on Filter box ");
        UtilFunctions.addScreenshot("Apertura Box Filtri");
        CommonSteps.jsonReader(tree, "filters", pe.getText(),null);

        tree = new String[]{"controlRoom","swManager", "filters"};

        pe = UtilFunctions.createNewPageElement("Label Tipo Dispositivo", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Dispositivo')]");
        CommonSteps.jsonReader(tree, "deviceType", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Label Tipo Software", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Software')]");
        CommonSteps.jsonReader(tree, "softwareType", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Label Nome", "//*[@class='dmc-multiselect-label' and contains(.,'Nome')]");
        CommonSteps.jsonReader(tree, "appname", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Label Versione", "//*[@class='dmc-multiselect-label' and contains(.,'Versione')]");
        CommonSteps.jsonReader(tree, "version", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Label Estensione", "//*[@class='dmc-multiselect-label' and contains(.,'Estensione')]");
        CommonSteps.jsonReader(tree, "software_extension", pe.getText(),null);
        pe = UtilFunctions.createNewPageElement("Label Architettura", "//*[@class='dmc-multiselect-label' and contains(.,'Architettura')]");
        CommonSteps.jsonReader(tree, "architecture", pe.getText(),null);


//        tree = new String[]{"components", "select"};
//        pe = UtilFunctions.createNewPageElement("dropdown tipo dispositivo", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Dispositivo')]//following-sibling::dmc-select//div[@class='-input']");
//        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
//        pe = UtilFunctions.createNewPageElement("dropdown tipo software", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Software')]//following-sibling::dmc-select//div[@class='-input']");
//        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
//        pe = UtilFunctions.createNewPageElement("dropdown nome", "//*[@class='dmc-multiselect-label' and contains(.,'Nome')]//following-sibling::dmc-select//div[@class='-input']");
//        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);
//        pe = UtilFunctions.createNewPageElement("dropdown nome", "//*[@class='dmc-multiselect-label' and contains(.,'Versione')]//following-sibling::dmc-select//div[@class='-input']");
//        CommonSteps.jsonReader(tree, "defaultLabel", pe.getText(),null);


        tree = new String[]{"controlRoom","swManager", "filters"};
        String locator = String.format("//input[@type='text' and @placeholder='%s']", "Architettura");
        pe = UtilFunctions.createNewPageElement("Placeholder Architettura", locator);
        CommonSteps.jsonReader(tree, "architecture", pe.getAttribute("placeholder").trim(),null);
        locator = String.format("//input[@type='text' and @placeholder='%s']", "Estensione");
        pe = UtilFunctions.createNewPageElement("Placeholder Estensione", locator);
        CommonSteps.jsonReader(tree, "software_extension", pe.getAttribute("placeholder").trim(),null);

        locator = String.format("//form//button[contains(text(), '%s')]", "Pulisci");
        pe = UtilFunctions.createNewPageElement("Placeholder Estensione", locator);
        CommonSteps.jsonReader(null, "Reset", pe.getText().trim(),null);
        locator = String.format("//form//button[contains(text(), '%s')]", "Conferma");
        pe = UtilFunctions.createNewPageElement("Placeholder Estensione", locator);
        CommonSteps.jsonReader(null, "Confirm", pe.getText().trim(),null);

        List<WebElement> listOfDmcCards = CommonPage.getDriver().findElements(By.xpath("//dmc-software-card"));
        if(listOfDmcCards != null || !listOfDmcCards.isEmpty()){
//            pe = UtilFunctions.createNewPageElement("label card SW/GW Type", "(//dmc-software-card/div[@class='-meta']//*[contains(@class, '-item')]/strong[contains(@class, '-label')])[1]");
//            Assert.assertTrue(pe.getText().contains("Tipo"), "Retrieved Text -> "+pe.getText()+ "- The Text dosen't contains the word Tipo.");
//            pe = UtilFunctions.createNewPageElement("label card SW/GW Type", "(//dmc-software-card/div[@class='-meta']//*[contains(@class, '-item')]/strong[contains(@class, '-label')])[2]");
//            Assert.assertTrue(pe.getText().contains("Est"), "Retrieved Text -> "+pe.getText()+ "- The Text dosen't contains the word Est.");

            pe = UtilFunctions.createNewPageElement("more button cards", "(//div[contains(@class, '-actions')]//div[@class='-handle'])[1]");
            Assert.assertTrue(pe.tryClick(), "Unable to click on more button present in the card");
            tree  = new String[]{"controlRoom"};

            pe = UtilFunctions.createNewPageElement("first option more button", "//dmc-software-card-action[1]");
            CommonSteps.jsonReader(tree,"Details", pe.getText().trim(), null );
            pe = UtilFunctions.createNewPageElement("second option more button", "//dmc-software-card-action[2]");
            CommonSteps.jsonReader(tree,"edit", pe.getText().trim(), null );
            tree  = new String[]{"controlRoom", "swManager"};
            pe = UtilFunctions.createNewPageElement("third option more button", "//dmc-software-card-action[3]");
            CommonSteps.jsonReader(tree,"download", pe.getText().trim(), null );
            pe = UtilFunctions.createNewPageElement("4th option more button", "//dmc-software-card-action[4]");
            CommonSteps.jsonReader(tree,"delete", pe.getText().trim(), null );

        }

    }

    @And("I delete the update just created")
    public void iDeleteTheUpdateJustCreated() throws InterruptedException {
        Thread.sleep(2000);
        ReportFormatter.addInfo("Deleting update containing in the text "+CommonSteps.timestamped);
        String search = "//input[@type='search']";
        PageElement el = UtilFunctions.createNewPageElement("Search Input",search);
        Assert.assertTrue(el.isPresent(50), "The element identified by description "+el.getDescription()+" is not present in the page");
        Assert.assertTrue(el.fillText("test_"+CommonSteps.timestamped), "Cannot input text test_"+CommonSteps.timestamped+" into element identified by "+el.getDescription());

        String xpath = "//div[@class='-handle-icon']";
        el = UtilFunctions.createNewPageElement("Menu update just created",xpath);
        Assert.assertTrue(el.isPresent(50), "The element identified by description "+el.getDescription()+" is not present in the page");
        Assert.assertTrue(el.scrollTo(), "Unable to scroll to element in order to shown");
        Assert.assertTrue(el.tryClick(true,false), "The element identified by description "+el.getDescription()+" is not clickable");

        String delete = "//dmc-software-card-action[contains(text(),'Delete')]";
        el = UtilFunctions.createNewPageElement("Delete option un update menu just created",delete);
        Assert.assertTrue(el.isPresent(50), "The element identified by description "+el.getDescription()+" is not present in the page");
        Assert.assertTrue(el.scrollTo(), "Unable to scroll to element in order to shown");
        Assert.assertTrue(el.tryClick(true,false), "The element identified by description "+el.getDescription()+" is not clickable");


        String confirm = "//*[contains(text(),'Do you really want to delete the software catalogue?')]/../following-sibling::footer//button[contains(text(),'Confirm')]";
        el = UtilFunctions.createNewPageElement("Confirm Button",confirm);
        Assert.assertTrue(el.isPresent(50), "The element identified by description "+el.getDescription()+" is not present in the page");
        Assert.assertTrue(el.scrollTo(), "Unable to scroll to element in order to shown");
        Assert.assertTrue(el.tryClick(true,false), "The element identified by description "+el.getDescription()+" is not clickable");

        String confirmMessage = "//*[contains(text(),'Software Catalogue deleted successfully')]/following-sibling::button";
        el = UtilFunctions.createNewPageElement("Deleting message close",confirmMessage);
        Assert.assertTrue(el.isPresent(50), "The element identified by description "+el.getDescription()+" is not present in the page");
        Assert.assertTrue(el.scrollTo(), "Unable to scroll to element in order to shown");
        Assert.assertTrue(el.tryClick(true,false), "The element identified by description "+el.getDescription()+" is not clickable");

    }

    @Then("I check that the refresh button work properly for Software Catalogue Page")
    public static void checkRefreshButtonSoftwareCatalogue() throws InterruptedException {
        CommonSteps.waitProgressBar();
        String locator = "//div[contains(@class, '-sw-card')]//h2";
        PageElement pe =  UtilFunctions.createNewPageElement("title box", locator);
        List<WebElement> listOfBox = CommonPage.getDriver().findElements(By.xpath(locator));
        List<String> originalTitle = new ArrayList<>();
        List<String> updatedTilte = new ArrayList<>();
         if (listOfBox.size() == 0 ){
            Assert.fail("The Table do not present any row!");
        }
        for (WebElement we : listOfBox) {
            originalTitle.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        Util.UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='CONCEPT TEST'";
        for (WebElement webElement : listOfBox) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }
        Util.UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(10000);
        Assert.assertTrue(SoftwareCataloguePage.getRefreshBtn().tryClick(), "Unable to click on refresh button");
        CommonSteps.waitProgressBar();
        listOfBox = CommonPage.getDriver().findElements(By.xpath(locator));
        for (WebElement we : listOfBox) {
            if(we.getText().toLowerCase().trim().contains("concept test")){
                Assert.fail("Update non riuscito");
            }
            updatedTilte.add(we.getText().toLowerCase());
        }

        Assert.assertEquals(originalTitle.size(), updatedTilte.size(), "Le due liste sono diverse");
    }


    public static String getPathS3() {
        return pathS3;
    }

    public static void setPathS3(String path) {
        SoftwareCatalogueSteps.pathS3 = pathS3.concat(path);
    }

    private static String pathS3 = "";

    public static String getFileUploaded() {
        return fileUploaded;
    }

    public static void setFileUploaded(String fileUploaded) {
        SoftwareCatalogueSteps.fileUploaded = fileUploaded;
    }

    private static String fileUploaded = "";

    @Then("I check that on Amazon S3 there is the file correctly uploaded")
    public static void checkFileOnS3(){
        List<String> listOfPackagesUploaded = new ArrayList<>();
        String pathFileOnS3 = SoftwareCatalogueSteps.getPathS3();
        System.out.println(pathFileOnS3);
        System.out.format("Objects in S3 bucket %s:\n", "enel-noprod-esol-ap2955103-qa-sm-artifacts");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
        ListObjectsV2Result result = s3.listObjectsV2("enel-noprod-esol-ap2955103-qa-sm-artifacts");
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        String fileCaricato = "";
        for (S3ObjectSummary os : objects) {
            if(os.getKey().contains("packages/")){
                listOfPackagesUploaded.add(os.getKey());
            }

        }

        System.out.println("Start check");
        if(!listOfPackagesUploaded.contains("packages/"+pathFileOnS3+getFileUploaded())){
            Assert.fail("The file: "+getFileUploaded()+ "din't was uploaded on S3" );
            fileCaricato = "packages/"+pathFileOnS3+getFileUploaded();
        } else {
            System.out.println(getFileUploaded()+ " present as expected");
        }

    }

    @Then("I check that on Amazon S3 there is a file correctly uploaded into bucket \"(.+)\" in the path \"(.+)\"")
    public static void checkFileOnS3SpecificPath(String bucket, String path) throws IOException, InterruptedException {
        List<String> listOfPackagesUploaded = new ArrayList<>();
        String[] file =  getFileUploaded().split(Pattern.quote("."));
        String fileName = file[0];
        System.out.println(fileName);
        String [] percorso = path.split("/");
        System.out.format("Objects in S3 bucket %s:\n", bucket);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
        ObjectListing obj = s3.listObjects(bucket, path+"esol_ap29551_qa_archive");

        do {
            for (S3ObjectSummary objectSummary : obj.getObjectSummaries()) {
                String key = objectSummary.getKey();
                System.out.println(key);
                if(key.contains("qa/private/esol_ap29551_qa_archive")){
                     listOfPackagesUploaded.add(objectSummary.getKey());
                }
            }
            obj = s3.listNextBatchOfObjects(obj);
            System.out.println("#size of the list: "+listOfPackagesUploaded.size());
        } while (obj.isTruncated());

        System.out.println("####");
        for(String s :listOfPackagesUploaded){
            System.out.println(s);
        }

        System.out.println("Start check");
        if(!listOfPackagesUploaded.contains("qa/private/esol_ap29551_qa_"+fileName+"/"+getFileUploaded())){
            Assert.fail("The file: "+getFileUploaded()+ " din't was uploaded on S3" );
        } else {
            System.out.println(getFileUploaded()+ " present as expected");
        }

    }

    @Then("I wait that the upload of the file is completed")
    public static void waitUploadFile(){
//        PageElement pe = UtilFunctions.createNewPageElement("progress bar upload file", "//i[contains(@class,'fa-circle-o-notch')]");
//        Assert.assertTrue(pe.isPresent(), "The Progress bar do not appear in 10 sec.");
//        Assert.assertTrue(pe.isInvisible(20), "The progress bar is still present after 20 sec");
        PageElement pe = UtilFunctions.createNewPageElement("toast message upload file", "//div[contains(@class, '-toaster')]");
        Assert.assertTrue(pe.isPresent(), "The toast message do not appear in 10 sec.");
        UtilFunctions.addScreenshot("check the presence of the Toast message");
        pe = UtilFunctions.createNewPageElement("x button toast message", "//button[contains(@class='-dismiss')]");
        pe.tryClick();
    }

    @Then("I check that the Software Catalogue is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage21() throws IOException {
        String [] tree = new String[]{"controlRoom"};

        String [] tree_swManager = new String[]{"controlRoom","swManager"};

        String [] tree_swManager_filters = new String[]{"controlRoom","swManager", "filters"};

        CommonSteps.jsonReader(tree_swManager,"searchSoftwareCatalogue", UtilFunctions.createNewPageElement("Search box at the top right", "//input[@type='search' and @placeholder='Ricerca per appname esatto']").getAttribute("placeholder").trim(), null );

        CommonSteps.jsonReader(tree, "softwareCatalogue",UtilFunctions.createNewPageElement("title of the Page Sotware Catalogue", "//h2[contains(@class, '-title')]").getText().trim(), null);

        //clicking on filter box
        Assert.assertTrue(UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div").tryClick(false, false), "Unable to click on Filter box ");
        UtilFunctions.addScreenshot("Apertura Box Filtri");
        CommonSteps.jsonReader(tree, "filters", UtilFunctions.createNewPageElement("filter box", "//div[@class='dmc-card-header']/h2[.='Filtri']/parent::div").getText(),null);

        CommonSteps.jsonReader(tree_swManager_filters, "deviceType", UtilFunctions.createNewPageElement("Label Tipo Dispositivo", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Dispositivo')]").getText(),null);
        CommonSteps.jsonReader(tree_swManager_filters, "softwareType", UtilFunctions.createNewPageElement("Label Tipo Software", "//*[@class='dmc-multiselect-label' and contains(.,'Tipo Software')]").getText(),null);
        CommonSteps.jsonReader(tree_swManager_filters, "appname", UtilFunctions.createNewPageElement("Label Nome", "//*[@class='dmc-multiselect-label' and contains(.,'Nome')]").getText(),null);
        CommonSteps.jsonReader(tree_swManager_filters, "version", UtilFunctions.createNewPageElement("Label Versione", "//*[@class='dmc-multiselect-label' and contains(.,'Versione')]").getText(),null);
        CommonSteps.jsonReader(tree_swManager_filters, "software_extension", UtilFunctions.createNewPageElement("Label Estensione", "//*[@class='dmc-multiselect-label' and contains(.,'Estensione')]").getText(),null);
        CommonSteps.jsonReader(tree_swManager_filters, "architecture", UtilFunctions.createNewPageElement("Label Architettura", "//*[@class='dmc-multiselect-label' and contains(.,'Architettura')]").getText(),null);
        CommonSteps.jsonReader(null, "Reset", UtilFunctions.createNewPageElement("Placeholder Estensione", "//form//button[contains(text(), 'Pulisci')]").getText(),null);
        CommonSteps.jsonReader(null, "Confirm", UtilFunctions.createNewPageElement("Placeholder Estensione", "//form//button[contains(text(), 'Conferma')]").getText(),null);

        Assert.assertTrue(UtilFunctions.createNewPageElement("more button cards", "(//div[contains(@class, '-actions')]//div[@class='-handle'])[1]").tryClick(), "Unable to click on more button present in the card");

        CommonSteps.jsonReader(tree,"Details", UtilFunctions.createNewPageElement("first option more button", "//dmc-software-card-action[1]").getText().trim(), null );
        CommonSteps.jsonReader(tree,"edit", UtilFunctions.createNewPageElement("second option more button", "//dmc-software-card-action[2]").getText().trim(), null );

        CommonSteps.jsonReader(tree,"download", UtilFunctions.createNewPageElement("third option more button", "//dmc-software-card-action[3]").getText().trim(), null );
        CommonSteps.jsonReader(tree,"delete", UtilFunctions.createNewPageElement("4th option more button", "//dmc-software-card-action[4]").getText().trim(), null );
 }
    @And("The {string} software should not present. If Present Then I remove it.")
    public static void theSoftwareShouldNotPresentIfPresentThenIRemoveIt(String arg0) throws InterruptedException {

        String locator = "//div[contains(.,'" + arg0 + "')]//div[@class='-handle']";
        //div[contains(.,'" + arg0 + "')]//div[@class='-handle']
        PageElement pe = UtilFunctions.createNewPageElement("Software to delete",locator);
        Thread.sleep(1000);
        if(pe.isPresent()){

                pe.click();
                Thread.sleep(1000);
                SoftwareCataloguePage.getSoftwareDeleteBtt().click();
                Thread.sleep(1000);
                SoftwareCataloguePage.getSoftwareDeleteConfirm().click();
                Thread.sleep(1000);
                SoftwareCataloguePage.getToastMessageClose().click();
                Thread.sleep(1000);
        }
    }

}
