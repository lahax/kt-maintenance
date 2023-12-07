package test.steps;

import Util.UtilFunctions;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClient;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.amazonaws.services.iot.model.ListThingsRequest;
import com.mongodb.diagnostics.logging.Logger;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.IClassListener;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.steps.UISteps;
import ta.utilities.Configuration;
import ta.utilities.ReflectionUtils;
import test.pages.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class DevicesSteps {

    @And("I Check that the table contains the following filter {string}")
    public void iCheckThatTheTableContainsTheFollowingFilter(String wordFilter) {
        PageElement pe = UtilFunctions.createNewPageElement("first row", "//tbody/tr/td[1]");
        Assert.assertTrue(pe.isPresent(), "Unable to find row in the table");
        List<WebElement> rows = CommonPage.getDriver().findElements(pe.getBy());
        if(rows != null && !rows.isEmpty()){
           for(WebElement we : rows){
               Assert.assertTrue(we.getText().toLowerCase().contains(wordFilter.toLowerCase()), "The list do not contains the device searched before");
           }
        }
    }

    @Then("I check that the refresh button works properly in the device page")
    public static void checkRefreshButtonWorkProperly() throws InterruptedException {
        CommonSteps.waitProgressBar();
        PageElement pe = UtilFunctions.createNewPageElement("first row" , "//tbody/tr[1]");
        Assert.assertTrue(pe.isPresent(), "Unable to find any row in the table");
        List<WebElement> els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        List<String> origin = new ArrayList<>();
        List<String> updated = new ArrayList<>();

        if (els.size() == 0 ){
            Assert.fail("The Table do not present any row!");
        }
        for (WebElement we : els) {
            origin.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        UtilFunctions.addScreenshot("Valori tabella attuali");
        String script = "arguments[0].innerHTML='TEST'";
        for (WebElement webElement : els) {
            ((JavascriptExecutor) CommonPage.getDriver()).executeScript(script, webElement);
        }
        UtilFunctions.addScreenshot("Aggiorno valori in tabella");
        Thread.sleep(5000);
        DeploymentHistoryDeviceDetailsPage.getRefreshButton().click();
        CommonSteps.waitProgressBar(30);
        Thread.sleep(5000);
        Assert.assertTrue(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().isPresent(), "La lista non compare in 10 sec");
        /*ricatturo la lista perché altrimenti va in eccezione per Stale element reference in quanto la lista precedentemente catturata non esiste piu dopo il refresh*/
        els = CommonPage.getDriver().findElements(DeploymentHistoryDeviceDetailsPage.getAllCellOfTheFirstRow().getBy());
        for (WebElement we : els) {
            updated.add(we.getText().toLowerCase());
        }
        for (WebElement webElement : els) {
            Assert.assertFalse(webElement.getText().equalsIgnoreCase("TEST"), "the refresh button do not work properly");
        }
        Assert.assertEquals(origin, updated, "The values retrieved after refresh are different from the expected");
    }

    @And("I check the content of type column")
    public void iCheckTheContentOfTypeColumn() {

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        List<WebElement> typeCells = new ArrayList<>();
        String result_row = "";
        int cont_row = 0;

        for (int i = 1; i <= rows.size(); i++) {
            String text = CommonPage.getDriver().findElement(By.xpath("//tr[" + i + "]/td[4]")).getText();
            result_row+=text;

            if (result_row.contains("direct") || result_row.contains("gateway") || result_row.contains("thing")) {
                cont_row++;
            }
        }
        Assert.assertEquals(rows.size(), cont_row, "The values of Type column are correct");
    }

    @And("I remove the resize bar to coordinate {string} {string} of column number {string}")
    public void iRemoveTheResizeBarToCoordinateOfColumnNumber(String coordinateX, String coordinateY, String numCol) throws InterruptedException {
        int coordinatex = Integer.parseInt(coordinateX);
        int coordinatey = Integer.parseInt(coordinateY);
        int widthBeforeMove = 0;
        int widthAfterMove = 0;

        WebElement webElement = CommonPage.getDriver().findElement(By.xpath("(//div[@class=\"-resize-bar\"])["+numCol+"]"));
        UtilFunctions.addScreenshot("Larghezza colonna prima dello spostamento");

        Thread.sleep(5000);

        widthBeforeMove = CommonPage.getDriver().findElement(By.xpath("(//tr/td)[1]")).getRect().width;

        CommonSteps.moveToElementToCoordinate(webElement, coordinatex, coordinatey);
        UtilFunctions.addScreenshot("Larghezza colonna dopo lo spostamento");

        widthAfterMove = CommonPage.getDriver().findElement(By.xpath("(//tr/td)[1]")).getRect().width;

        Assert.assertTrue(widthBeforeMove > widthAfterMove, "The resize operation failed");
    }

    @And("I move the resize bar to coordinate {string} {string} of column number {string}")
    public void iMoveTheResizeBarToCoordinate(String coordinateX, String coordinateY, String numCol) throws InterruptedException {

        int coordinatex = Integer.parseInt(coordinateX);
        int coordinatey = Integer.parseInt(coordinateY);
        int widthBeforeMove = 0;
        int widthAfterMove = 0;

        WebElement webElement = CommonPage.getDriver().findElement(By.xpath("(//div[@class=\"-resize-bar\"])["+numCol+"]"));
        UtilFunctions.addScreenshot("Larghezza colonna prima dello spostamento");

        Thread.sleep(5000);

        widthBeforeMove = CommonPage.getDriver().findElement(By.xpath("(//tr/td)[1]")).getRect().width;

        CommonSteps.moveToElementToCoordinate(webElement, coordinatex, coordinatey);
        UtilFunctions.addScreenshot("Larghezza colonna dopo lo spostamento");

        widthAfterMove = CommonPage.getDriver().findElement(By.xpath("(//tr/td)[1]")).getRect().width;

        Assert.assertTrue(widthBeforeMove < widthAfterMove, "The resize operation failed");
    }

    public void prova() {
        AWSIotClient client = (AWSIotClient) AWSIotClientBuilder.standard().build();
        ListThingsRequest request = new ListThingsRequest();
        client.listThings(request);
    }

    @And("I check the alignment of things")
    public void iCheckTheAlignmentOfThings() {

        WebElement webElementThingTD = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'thing')])[2]/preceding-sibling::td[3]"));
        WebElement webElementGatewayTD = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'gateway')])[1]/preceding-sibling::td[3]"));

        String strThing = webElementThingTD.getText();
        String strGateway = webElementGatewayTD.getText();
        boolean flagStrGateway = false;
        boolean flagStrThing = false;

        for (int i = 0; i < 3 && !flagStrThing; i++) {
            if (Character.isWhitespace(strThing.charAt(i))) {
                flagStrThing = true;
            }
        }

        for (int i = 0; i < 3 && !flagStrGateway; i++) {
            if (!Character.isWhitespace(strGateway.charAt(i))) {
                flagStrGateway = true;
            }
        }

        Assert.assertTrue(flagStrThing && flagStrGateway, "The thing is indented correctly");
    }

    @And("I verify the correct value of the voices in the status column")
    public void iVerifyTheCorrectValueOfTheVoicesInTheStatusColumn() {

        List<WebElement> allRows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        List<String> valuesStatus = new ArrayList<>();

        int cont_flag = 0;

        for (WebElement rows : allRows) {
            List<WebElement> cells = rows.findElements(By.xpath("//tbody/tr/td[10]"));
            for (WebElement cell : cells) {
                valuesStatus.add(cell.getText());
            }
        }

        for (String status : valuesStatus) {
            if (status.contains("disconnected") || status.contains("connected")) {
                cont_flag++;
            }
        }

        Assert.assertEquals(valuesStatus.size(), cont_flag, "There's another value besides connected and disconnected");
    }

    @And("I check the alignment and the correct presence of thing and gateway with icon")
    public void iCheckTheAlignmentAndTheCorrectPresenceOfThingAndGatewayWithIcon() throws InterruptedException {
        // this sleep is for qa apm
        Thread.sleep(5000);
        // elements
        WebElement webElementThingTD = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'thing')])[2]/preceding-sibling::td[3]"));
        WebElement webElementGatewayTD = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'gateway')])[1]/preceding-sibling::td[3]"));
        // icons
        WebElement webElementThingIcon = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'thing')])[2]/preceding-sibling::td[3]/i"));
        WebElement webElementGatewayIcon = CommonPage.getDriver().findElement(By.xpath("(//td[contains(.,'gateway')])[1]/preceding-sibling::td[3]/i"));
        // flag for icons check
        boolean flagIcons = false;
        String classAttributeForIconThing = "";
        String classAttributeForIconGateway = "";

        classAttributeForIconThing = webElementThingIcon.getAttribute("class");
        classAttributeForIconGateway = webElementGatewayIcon.getAttribute("class");

        if (classAttributeForIconThing.contains("dmc-icon__device-thing") && (classAttributeForIconGateway.contains("dmc-icon__device-gateway"))) {
            flagIcons = true;
        }

        String strThing = webElementThingTD.getText();
        String strGateway = webElementGatewayTD.getText();
        boolean flagStrGateway = false;
        boolean flagStrThing = false;

        for (int i = 0; i < 3 && !flagStrThing; i++) {
            if (Character.isWhitespace(strThing.charAt(i))) {
                flagStrThing = true;
            }
        }

        for (int i = 0; i < 3 && !flagStrGateway; i++) {
            if (!Character.isWhitespace(strGateway.charAt(i))) {
                flagStrGateway = true;
            }
        }


        Assert.assertTrue(flagStrThing && flagStrGateway, "The thing is not indented correctly");
        Assert.assertTrue(flagIcons, "The icons are not correct");
    }

    @Then("I check if the number of rows present in the table is in accordion with the pagination number in DevicesPage")
    public void iCheckIfTheNumberOfRowsPresentInTheTableIsInAccordionWithThePaginationNumberInDevicesPage() {

        int numberOfPagination = Integer.parseInt(DevicesPage.getPaginationTableButton().getText());
        String counterPagesTable = DevicesPage.getPagesCounter().getText();

        boolean flag = false;

        try {
            PageElement pe = UtilFunctions.createNewPageElement("All rows present in the table", "//tbody/tr");
            pe.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No rows showed in 20 sec");
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));

        if (((rows.size() < numberOfPagination) && (counterPagesTable.equals("Page 1 of 1"))) || (rows.size() > numberOfPagination)) {
            Assert.fail("The rows present in the table do not correspond to the correct visualization");
        }

    }

    @Then("I select {string} in drop down menu in filter box on Device Page")
    public void iSelectInDropDownMenuInFilterBoxOnDevicePage(String voiceDropDown) {

        try {
            PageElement dropdown = UtilFunctions.createNewPageElement("Dropdown menu in filter box", "//dmc-multi-select-option");
            dropdown.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No dropdown menu showed in 20 sec");
        }

        try {
            PageElement dropDownVoice = UtilFunctions.createNewPageElement("Dropdown menu voice", "//dmc-multi-select-option/div[contains(., '" + voiceDropDown + "')]");
            dropDownVoice.isPresent(20);
            dropDownVoice.tryClick();

        } catch (Exception e) {
            Assert.fail("No dropdowm voice showed in 20 sec");
        }

        try {
            PageElement optionSelected = UtilFunctions.createNewPageElement("", "//dmc-multi-select-option/div[contains(., '" + voiceDropDown + "')]");
            optionSelected.isPresent(20);

        } catch (Exception e) {
            Assert.fail("No " + voiceDropDown + " option is set correctly");
        }

    }

    @Then("I select {string} in drop down menu in filter box on Device Page using Javascript")
    public void iSelectInDropDownMenuInFilterBoxOnDevicePageJS(String voiceDropDown) {

        try {
            PageElement dropdown = UtilFunctions.createNewPageElement("Dropdown menu in filter box", "//dmc-multi-select-option");
            dropdown.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No dropdown menu showed in 20 sec");
        }

        try {
            PageElement dropDownVoice = UtilFunctions.createNewPageElement("Dropdown menu voice", "//dmc-multi-select-option/div[contains(., '" + voiceDropDown + "')]");
            dropDownVoice.isPresent(20);
            dropDownVoice.tryClick();
            dropDownVoice.clickJS(true);

        } catch (Exception e) {
            Assert.fail("No dropdowm voice showed in 20 sec");
        }

        try {
            PageElement optionSelected = UtilFunctions.createNewPageElement("", "//dmc-multi-select-option/div[contains(., '" + voiceDropDown + "')]");
            optionSelected.isPresent(20);

        } catch (Exception e) {
            Assert.fail("No " + voiceDropDown + " option is set correctly");
        }

    }

    @Then("I click icon details of a device of type {string}")
    public void clickIconDetailsOfADeviceOfTypeDirect(String typeDevice) {

        try {
            PageElement detailIconDevice = UtilFunctions.createNewPageElement("Icon Detail of a " + typeDevice + " type", "(//td/following-sibling::td[contains(., '" + typeDevice + "' )]/following-sibling::td/descendant::i[@class='dmc-icon__document dmc-icon'])[1]");
            detailIconDevice.isPresent(20);

            detailIconDevice.tryClick();
        } catch (Exception e) {
            Assert.fail("No icon detail of " + typeDevice + " device showed in 20 sec");
        }
    }


    @And("I read the devices exported file and check the row and columns are as expected")
    public void iReadTheDownloadedFile() throws IOException, InterruptedException, ParseException {
        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("device_list_") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        /*
        double last = 0;
        String n = "";
        for(String s : listaFileLog){
            String[] elemento = s.split("list_");
            String numeroFile = elemento[1].substring(0,elemento[1].indexOf(".xls"));
            if(Double.parseDouble(numeroFile)>last){
                last=Double.parseDouble(numeroFile);
                n=numeroFile;
            }
        }


        String nameFileDaAprire = "device_list_"+n+".xlsx";
        */
        Assert.assertTrue(listaFileLog.size() > 0, "File has not been downloaded");
        String nameFileDaAprire = listaFileLog.get(listaFileLog.size() - 1);
        System.out.println(nameFileDaAprire);
        String pathFileDaAprire = pathUserHome+nameFileDaAprire;
        File fileExcelScaricato = new File(pathFileDaAprire);
        FileInputStream file = new FileInputStream(fileExcelScaricato);
        Workbook workbook = new XSSFWorkbook(file);
        //Device Tab
        Sheet sheet = workbook.getSheet("Devices");
        //Columns
        Assert.assertEquals(sheet.getRow(0).getCell(0).getStringCellValue(), "ID", "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(1).getStringCellValue(), "Serial N°", " Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(2).getStringCellValue(), "Project Name","Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(3).getStringCellValue(), "Type", "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(4).getStringCellValue(), "Maker" ,  "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(5).getStringCellValue(), "Certificate expiration" ,  "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(6).getStringCellValue(), "Status" ,  "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(7).getStringCellValue(), "Model" ,  "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(8).getStringCellValue(), "Device Type" ,  "Text column in xlsx file is different from test list description");

        fileExcelScaricato.delete();
    }

    @And("I read the devices exported csv file and check the row and columns are as expected")
    public void iReadTheDownloadedCsvFile() throws IOException, InterruptedException, ParseException {
        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("device_list_") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }

        Assert.assertTrue(listaFileLog.size() > 0, "File has not been downloaded");
        String nameFileDaAprire = listaFileLog.get(listaFileLog.size() - 1);
        System.out.println(nameFileDaAprire);
        String pathFileDaAprire = pathUserHome+nameFileDaAprire;
        File fileCsvScaricato = new File(pathFileDaAprire);
        //FileInputStream file = new FileInputStream(fileCsvScaricato);

        //Reading file
        BufferedReader br = null;
        String line;
        String delimiterRow = ";";
        String delimiterCol = ",";
        List<List<String>> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileCsvScaricato));
            while((line=br.readLine()) !=null){
                String[] valuesRow = line.split(delimiterRow);
                data.add(Arrays.asList(valuesRow));
            }
        } catch (IOException e){
            System.out.println(e);
        }
        br.close();
        //Device Tab Columns
        String devicesTableHeader = String.valueOf(data.get(0));
        String[]valueHeader=devicesTableHeader.split(delimiterCol);
        //ID;Serial Number;Project Name;Type;Maker;Certificate expiration;Status;Model;Device Type;Software version
        Assert.assertTrue(valueHeader[0].contains("ID"), "Text column ID in csv file is different from test list description");
        //Assert.assertEquals(valueHeader[0], "ID", "Text column ID in csv file is different from test list description");
        Assert.assertTrue(valueHeader[1].contains("Serial Number"), " Text column Serial Number in csv file is different from test list description");
        Assert.assertTrue(valueHeader[2].contains("Project Name"),"Text column Project Name in csv file is different from test list description");
        Assert.assertTrue(valueHeader[3].contains("Type"), "Text column Type in csv file is different from test list description");
        Assert.assertTrue(valueHeader[4].contains("Maker"), "Text column Maker in csv file is different from test list description");
        Assert.assertTrue(valueHeader[5].contains("Certificate expiration"),  "Text column Certificate expiration in csv file is different from test list description");
        Assert.assertTrue(valueHeader[6].contains("Status"),"Text column Status in csv file is different from test list description");
        Assert.assertTrue(valueHeader[7].contains("Model"),"Text column Model in csv file is different from test list description");
        Assert.assertTrue(valueHeader[8].contains("Device Type"),"Text column Device Type in csv file is different from test list description");
        Assert.assertTrue(valueHeader[9].contains("Software version"), "Text column Software version in csv file is different from test list description");

        fileCsvScaricato.delete();
    }
    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }
    @And("I check the content of Target Name column according to {string}")
    public void iCheckTheContentOfTargetNameColumn(String idDevice) {

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        int cont_row = 0;
        String text = "";
        for (int i = 1; i <= rows.size(); i++) {
            text = CommonPage.getDriver().findElement(By.xpath("//tr[" + i + "]/td[4]")).getText();
            if(text.contains(idDevice)){
                cont_row++;
            }
        }
        Assert.assertEquals(rows.size(), cont_row, "The values of Target column are not correct");
    }

    @Then("I check the presence of the ticket management icon for the device \"(.+)\" and I click it")
    public static void checkTheTicketManagementIconSpecifDevice(String device) throws InterruptedException {
        Thread.sleep(1000);
        String locator = String.format("//tbody/tr/td/strong[text()='%s']/parent::td//following-sibling::td//i[contains(@class, 'ticket-rotated')]", device);
        PageElement pe = UtilFunctions.createNewPageElement("ticket managment icon device: "+device, locator);
        Assert.assertTrue(pe.tryClick(), "Unable to click on "+pe);

    }

    private static String ticketNumber = "";
    @Then("I retrieve the number of the opened tickets so far")
    public static void retrieveticketNumber(){
        PageElement pe = UtilFunctions.createNewPageElement("ticket message created", "//span[@class='-message']");
        String textRetrieved = pe.getText();
        String[] ticketNumber = textRetrieved.split("number:");
        String number = ticketNumber[1];
        setTicketNumber(number);
    }

    public static String getTicketNumber() {
        return ticketNumber;
    }

    public static void setTicketNumber(String ticketNumber) {
        DevicesSteps.ticketNumber = ticketNumber;
    }

    @Then("I check the presence of ticket number in the list")
    public static void checkTicketNumber(){
        PageElement pe = UtilFunctions.createNewPageElement("ticket", "//tr/td[contains(.,'"+getTicketNumber()+"')]");
        Assert.assertTrue(pe.isPresent(),"Unable to find "+pe);
    }
    @And("I read the devices exported file and check the rows and device type columns are as expected")
    public void iReadTheDownloadedFile3() throws IOException, InterruptedException, ParseException {
        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("device_list_") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        /*
        double last = 0;
        String n = "";
        for(String s : listaFileLog){
            String[] elemento = s.split("list_");
            String numeroFile = elemento[1].substring(0,elemento[1].indexOf(".xls"));
            if(Double.parseDouble(numeroFile)>last){
                last=Double.parseDouble(numeroFile);
                n=numeroFile;
            }
        }


        String nameFileDaAprire = "device_list_"+n+".xlsx";
        */
        Assert.assertTrue(listaFileLog.size() > 0, "File has not been downloaded");
        String nameFileDaAprire = listaFileLog.get(listaFileLog.size() - 1);
        String pathFileDaAprire = pathUserHome+nameFileDaAprire;
        File fileExcelScaricato = new File(pathFileDaAprire);
        FileInputStream file = new FileInputStream(fileExcelScaricato);
        Workbook workbook = new XSSFWorkbook(file);
        //Device Tab
        Sheet sheet = workbook.getSheet("Devices");
        //Columns
        List<WebElement> allRows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
      //  List<String> values = new ArrayList<>();
        //int cont_flag = 0;

        for (int i = 1; i <= allRows.size(); i++) {
            Assert.assertEquals(sheet.getRow(i).getCell(3).getStringCellValue(), "gateway" ,  "Text column in xlsx file is different from device type gateway");
            Assert.assertEquals(sheet.getRow(i).getCell(6).getStringCellValue(), "connected" ,  "Text column in xlsx file is different from status connected");
        }

        fileExcelScaricato.delete();
    }

    @And("I read the devices exported csv file and check the rows and device type columns are as expected")
    public void iReadTheDownloadedCsvFile3() throws IOException, InterruptedException, ParseException {
        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("device_list_") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        Assert.assertTrue(listaFileLog.size() > 0, "File has not been downloaded");
        String nameFileDaAprire = listaFileLog.get(listaFileLog.size() - 1);
        System.out.println(nameFileDaAprire);
        String pathFileDaAprire = pathUserHome+nameFileDaAprire;
        File fileCsvScaricato = new File(pathFileDaAprire);
        //FileInputStream file = new FileInputStream(fileCsvScaricato);
        //Workbook workbook = new XSSFWorkbook(file);
        //Device Tab
        //Sheet sheet = workbook.getSheet("Devices");
        //Columns
        List<WebElement> allRows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));
        //  List<String> values = new ArrayList<>();
        //int cont_flag = 0;

        //Reading file
        BufferedReader br = null;
        String line;
        String delimiterRow = ";";
        String delimiterCol = ",";
        List<List<String>> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileCsvScaricato));
            while((line=br.readLine()) !=null){
                String[] valuesRow = line.split(delimiterRow);
                data.add(Arrays.asList(valuesRow));
            }
        } catch (IOException e){
            System.out.println(e);
        }
        br.close();

        for (int i = 1; i <= allRows.size(); i++) {
            System.out.println("Row n: "+i);
            String devicesTableRow = String.valueOf(data.get(i));
            System.out.println("devicesTableRow: "+devicesTableRow);
            String[]valueRow=devicesTableRow.split(delimiterCol);
            Assert.assertEquals(valueRow[3], " gateway" ,  "Text Type column in csv file is different from device type gateway");
            Assert.assertEquals(valueRow[6], " connected" ,  "Text Status column in csv file is different from status connected");
        }
        Thread.sleep(3000);
        fileCsvScaricato.delete();
        Thread.sleep(5000);
    }

    @Then("I check if the number of rows present in the table is in according with the pagination number in DevicesPage")
    public void iCheckIfTheNumberOfRowsPresentInTheTableIsInAccordionWithThePaginationNumberInDevicesPage1() {

        int numberOfPagination = Integer.parseInt(DevicesPage.getPaginationTableButton().getText());
        String counterPagesTable = DevicesPage.getPagesCounter().getText();

        boolean flag = false;

        try {
            PageElement pe = UtilFunctions.createNewPageElement("All rows present in the table", "//tbody/tr");
            pe.isPresent(20);
        } catch (Exception e) {
            Assert.fail("No rows showed in 20 sec");
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));

        Assert.assertEquals(numberOfPagination, rows.size(), "The rows present in the table do not correspond to the correct visualization");

        if (((rows.size() < numberOfPagination) && (counterPagesTable.equals("Page 1 of 1"))) || (rows.size() > numberOfPagination)) {
            Assert.fail("The rows present in the table do not correspond to the correct visualization");
        }
    }
    @Then("I check that the Devices page is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage1() throws IOException {
        String [] tree = new String[]{"controlRoom"};
        String [] tree_filters = new String[]{"filters"};
        String [] tree_fields = new String[]{"fields"};
        String [] tree_2 = new String[]{"controlRoom", "incidents"};
        String [] tree_reset = new String[]{"components", "table"};

        //Check table
        CommonSteps.jsonReader(tree_2, "country", DevicesPage.getDevicesLandingPageCountryViewIT().getText(),null);
        CommonSteps.jsonReader(tree, "list", DevicesPage.getDevicesLandingPageListViewIT().getText(),null);
        CommonSteps.jsonReader(tree, "filters", DevicesPage.getFilterBoxIT().getText(),null);
        CommonSteps.jsonReader(tree, "deviceType",  DevicesPage.getDeviceTypeIT().getText(),null);
        CommonSteps.jsonReader(tree, "model",  DevicesPage.getDeviceModelIT().getText(),null);
        CommonSteps.jsonReader(tree, "status",  DevicesPage.getStatusModelIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "certificateExpiration",  DevicesPage.getCertificateExpirationIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "maker",  DevicesPage.getMakerIT().getText(),null);
        CommonSteps.jsonReader(null, "Reset",  DevicesPage.getClearBTNIT().getText(),null);
        CommonSteps.jsonReader(null, "Confirm",  DevicesPage.getConfirmBTNIT().getText(),null);
        CommonSteps.jsonReader(tree, "serialNumber",  DevicesPage.getSerialNumberHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree_fields, "project",  DevicesPage.getProjectHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "deviceType",  DevicesPage.getDeviceTypeHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "maker",  DevicesPage.getMakerHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "certificateExpiration",  DevicesPage.getCertificateExpirationHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree, "device",  DevicesPage.getDeviceHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree, "model",  DevicesPage.getModelHeaderIT().getText(),null);
        CommonSteps.jsonReader(tree, "status",  DevicesPage.getStatusHeaderIT().getText(),null);

        //Open the column actions
        DevicesPage.getSelectColumnsIcon().click();
        CommonSteps.jsonReader(null, "Serial Number", DevicesPage.getSerialNumberColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree_fields, "project", DevicesPage.getProjectColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "deviceType", DevicesPage.getDeviceTypeColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "maker", DevicesPage.getMakerColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree_filters, "certificateExpiration", DevicesPage.getCertificateExpirationColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree, "device",  DevicesPage.getDeviceColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree, "model",  DevicesPage.getModelColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree, "status",  DevicesPage.getStatusColumnActionsIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "resetColumnsSize", DevicesPage.getResizeColumnsIT().getText(),null);
        CommonSteps.jsonReader(null, "Close", DevicesPage.getCloseColumnsBTN().getText(),null);
        //Close the column actions
        DevicesPage.getCloseColumnsBTN().click();
        //check the pagination
        CommonSteps.jsonReader(tree_reset, "rowsPerPage", DevicesPage.getRowsPerPageIT().getText(),null);
        CommonSteps.jsonReader(tree_reset, "pageCounters", DevicesPage.getPageCountersIT().getText().split(" ")[0]+" {{page}} "+DevicesPage.getPageCountersIT().getText().split(" ")[2]+" {{pages}} ",null);
    }

    @Then("I check if the all row contain {string} in {string} column")
    public void iCheckIfTheAllRowContainInColumn(String value, String typeColumn) {

        int indexColumn = 0;
        int flag = 0;

        switch (typeColumn) {
            case "Device Type":
                indexColumn = 4;
                break;
            case "Maker":
                indexColumn = 5;
                break;
            case "Certificate Expiration":
                indexColumn = 6;
                break;
            case "Model":
                indexColumn = 7;
                break;
            case "Status":
                indexColumn = 9;
                break;
            default:
                Assert.fail("The value of type column is not valid");
        }

        List<WebElement> rows = CommonPage.getDriver().findElements(By.xpath("//tbody/tr"));

        for (int i = 1; i < rows.size(); i++) {

            WebElement ele = CommonPage.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[" + indexColumn + "]"));
            System.out.println(ele.getText());
        }

        for (WebElement element : rows) {
            if (element.getText().contains(value)) {
                flag++;
            }
        }

        Assert.assertEquals(flag, rows.size(), "The value " + value + " is not present in " + typeColumn.toUpperCase() + " column for all rows");
    }

    @Then("I select {string} in input option box")
    public void iSelectInMatOptionBox(String value) {

        try {
            PageElement pe = UtilFunctions.createNewPageElement("option input box", "//span[@class='mat-option-text' and contains(., '" + value + "')]");
            pe.isPresent(20);

            pe.tryClick();
        } catch (Exception e) {
            Assert.fail("No option input box showed in 20 sec");
        }
    }

    @Then("I clear the search Box in the Device Page")
    public static void clearSearchBox(){
        CommonSteps.waitProgressBar();
        WebElement we = CommonPage.getDriver().findElement(DevicesPage.getSearchBox().getBy());
        we.sendKeys(Keys.CONTROL+"a");
        we.sendKeys(Keys.BACK_SPACE);
    }

    @Then("^I click the details icon for the \"(.+)\"")
    public static void clickDetailsIcon(String device){
        String locator = "//tbody/tr/td[contains(.,'%s')]/following-sibling::td//i[contains(@class, 'icon__document ')]";
        String iconToClick = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("icon detail device"+device, iconToClick);
        Assert.assertTrue(pe.tryClick(), "Unable to click the element");
    }

    @Then("If the thing {string} in the project {string} is present I remove it through {string}")
    public static void ifThingPresentRemoveJobOrCommand(String device, String project, String commandType) throws Exception {
        String locator = "//tbody/tr/td[contains(.,'"+device+"')]";
        String iconToCheck = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("icon detail device"+device, iconToCheck);
        String gateway = device.split("_t")[0];
        System.out.println(gateway);
        boolean present = pe.isPresent();
        if (present) {
            clickShowDetailsIcon(device);
            switch (commandType){
                case "job":
                    try {
                        CommandsUtilSteps.killNotifyJob();
                        CommandsUtilSteps.iDeactivateThing(gateway, project);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deactivateThingsBTN");
                    CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deleteCertificate");
                    CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "forceDelete");
                    CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "deleteConfirm");
                    CommandsUtilSteps.iGetTheJobId();
                    CommandsUtilSteps.iRunCloseJob("close_job_deactivate_thing", gateway, project);
                    break;

                default:
                    break;
            }
            CommonSteps.iWaitMinutesAfterScript(3);
            CommonSteps.checkAndClickElementPresent("DevicesDetailsPage", "enterToThingsList");
            Assert.assertFalse(pe.isPresent(), "The thing has not been deleted");
        }
    }

    public static void clickShowDetailsIcon(String device){
        String locator = "//tbody/tr/td[contains(.,'%s')]/following-sibling::td//i[contains(@class, 'dmc-icon__more-vertical')]";
        String iconToClick = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("icon detail device"+device, iconToClick);
        Assert.assertTrue(pe.tryClick(), "Unable to click the element");
    }
    @And("^The table should contains the \"(.+)\" row")
    public static void gatewayRowPresent(String device){
        String locator = "//tbody/tr/td[contains(., '%s')]/parent::tr";
        String row = String.format(locator, device);
        PageElement pe = UtilFunctions.createNewPageElement("row device "+device, row);
        Assert.assertTrue(pe.isPresent(), "The Element is not present");
    }

    @And("The {string} should be present in the table. If it's not present then I launch command {string} on shell")
    public static void theShouldBePresentInTheTableIfNotPresentThenLaunchCommand(String arg0, String command) throws InterruptedException, IOException {
        String locator = "//tbody/tr/td[1]";
        List<WebElement> list = CommonPage.getDriver().findElements(By.xpath(locator));
        List<String> devicesList = new ArrayList<>();
        if(list!=null){
            for(WebElement we:list){
                devicesList.add(we.getText().toLowerCase());
            }
            if(!devicesList.contains(arg0.toLowerCase())){
                UtilSteps.iLaunchCommandOnShell(command);
                Thread.sleep(60000);
            }
        }
    }

    /*@Then("I launch command {string} on shell.")
    public static void iLaunchCommandOnShell(String command) throws IOException {
        int count = 0;
        boolean isRetry = true;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("powershell.exe", command);
        processBuilder.directory(new File(Configuration.get("path.scripsBash")));

        while (isRetry) {
            try {
                Process process = processBuilder.start();
                isRetry = readBuffer(process, "sending DISCONNECT");
                if (count > 2) {
                    isRetry = false;
                }
                count++;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

    public static boolean readBuffer(Process process, String textToRetrieve) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        long mill = System.currentTimeMillis();
        while (((line = reader.readLine()) != null) || (System.currentTimeMillis() > mill+60000)) {
            System.out.println(line);
            assert line != null;
            if (line.contains(textToRetrieve)) {
                return false;
            }
        }
        return true;
    }

    @Then("The dropdown will show softwares with the syntax APPNAME@VERSION")
    public static void getACtext(){
        int line = 2100;
        for(int i = line; i < 2650; i++) {
            List<WebElement> list = CommonPage.getDriver().findElements(By.xpath("//mat-option[@id='mat-option-" + i + "']"));
            if(!list.isEmpty()){
                for(WebElement lne : list) {
                    String sver = lne.getText();
                    if (!sver.contains("@")) System.out.println("Wrong format: " + sver);
                    else {
                        System.out.println("Proper format: " + sver + "  " + i);
                    }
                }
            }

        }
    }

    @Then("I Check for presence of Software Version filters and close it")
    public static void sfFilter(){
        String[] app = {"sw_APP1@1.0", "sw_eiidg-agent@2.0-test"};
        for(String apps: app) {
            PageElement sf = UtilFunctions.createNewPageElement("", "//mat-chip[contains(.,'" + apps +"')]");
            if (sf.isPresent()) {
                PageElement close = UtilFunctions.createNewPageElement("close X", "//mat-chip[contains(.,'" + apps + "')]/span[@class='-icon ng-star-inserted']");
                close.click();
            }
        }
    }
    @And("The {string} should not present in the table. If Present Then I remove it.")
    public static void theShouldNotPresentInTheTableIfPresentThenIRemoveIt(String arg0) throws InterruptedException {

        String locator = "//strong[@class='ng-star-inserted' and text()='"+arg0+"']";
        PageElement pe = UtilFunctions.createNewPageElement("Device to delete",locator);
        Thread.sleep(1000);
        if(pe.isPresent()){
            if(pe.getText().equalsIgnoreCase(arg0)){
                System.out.println("# - found the device "+ arg0);
                UtilFunctions.addScreenshot("proceed to remove the device");
                System.out.println("1");
                clickDetailsIcon(arg0);
                System.out.println("2");
                DeactiveDevice();
                System.out.println("3");
                Thread.sleep(3000);
                System.out.println("4");
                if (HomePage.getEnterBTN().isPresent()) {
                    System.out.println("home page");
                    HomePage.getEnterBTN().click();
                    System.out.println("5");
                }
                System.out.println("home page");
                Thread.sleep(5000);
                System.out.println("6");
            }
        }
    }
    public static void DeactiveDevice() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getDeactivateBTN().tryClick(), "Unable to click on Deactivate Btn");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getDeleteCertificate().isPresent(), "Unable to locate Delete certificate");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getDeleteCertificate().tryClick(), "Unable to click on Delete certificate");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getForceDelete().isPresent(), "Unable to locate Force delete");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getForceDelete().tryClick(), "Unable to click on Force delete");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getDeleteConfirm().isPresent(), "Unable to locate button Confirm");
        Thread.sleep(2000);
        Assert.assertTrue(DevicesDetailsPage.getDeleteConfirm().tryClick(), "Unable to click on button Confirm");
        Thread.sleep(2000);
        PageElement pe = UtilFunctions.createNewPageElement("toast message succeeded", "//div[@class='-toaster']/span[contains(.,'SUCCEEDED')]");
        Assert.assertTrue(pe.isPresent(240), "The deactivation process do not works correctly in 120 sec");
        Assert.assertTrue(DevicesPage.getToastMessageClose().tryClick(), "Unable to close the toast message");
//       Thread.sleep(60000);
        UtilFunctions.addScreenshot("once clicked delete certificate and force delete, I proceed to confirm");


    }
    @Then("I remove the device {string}")
    public static void removeDevices(String arg0) throws InterruptedException {
        theShouldNotPresentInTheTableIfPresentThenIRemoveIt(arg0);
    }


    @Then("I confirm file download")
    public static void cnfAlert() throws InterruptedException, AWTException {
        Thread.sleep(10000);
        Robot robot = new Robot();
        for(int i = 0; i < 3; i++){
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Then("I download")
    public static void cnfAlert2() throws Exception {
        System.setProperty("webdriver.chrome.driver", ".\\webdrivers\\chromedriver_win32\\chromedriver.exe");

        String downloadPath = "System.getProperty(\"user.home\")+\"\\\\Downloads\\\\\";";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + downloadPath);
        options.addArguments("download.prompt_for_download=false");
        options.addArguments("download.directory_upgrade=true");
        options.addArguments("safebrowsing.enabled=true");

        WebDriver downloadDriver = new ChromeDriver(options);

        downloadDriver.get("https://dmc-iot-test.enel.com/#/projects/landing-page");
        UISteps.clickElement("LoginPage", "loginBtn");
        LoginSteps.performLogin("admin");
        UISteps.connectToUrl("https://dmc-iot-test.enel.com/#/projects/landing-page");

        // Encontre e clique no elemento para iniciar o download
        WebElement downloadLink = downloadDriver.findElement(By.xpath("//i[@dmcicon = 'download']\""));
        downloadLink.click();

    }
}
