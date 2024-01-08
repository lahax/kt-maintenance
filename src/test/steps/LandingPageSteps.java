package test.steps;


import Util.UtilFunctions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.utilities.ReflectionUtils;
import test.pages.ProjectPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;


public class LandingPageSteps {

    @Then("^I check the Element (\\w+).(\\w+) has text$")
    public static void checkAndClickElementTextIsPresent(String className, String fieldName) throws Exception {
               PageElement elem = ReflectionUtils.getPageElementByString(className, fieldName);
               String text = elem.getText();
               boolean isEmpty = text.isEmpty();
               System.out.println(text);
               Assert.assertNotNull(text, "The element is null");
               Assert.assertFalse(isEmpty, "The element is empty");
    }

    @And("I read the homepage exported file and check the row and columns are as expected")
    public void iReadTheDownloadedFile() throws IOException, InterruptedException, ParseException {
        List<WebElement> monthsAlarms = CommonPage.getDriver().findElements(By.xpath("//header[contains(.,'Alarms')]/following-sibling::section[2]//*[name()='g' and contains(@class, 'highcharts-xaxis-labels')]/*[name()='text']"));
        List<String> monthsAl = new ArrayList<>();
        List<WebElement> monthsDevicesActivation = CommonPage.getDriver().findElements(By.xpath("//header[contains(.,'Alarms')]/following-sibling::section[2]//*[name()='g' and contains(@class, 'highcharts-xaxis-labels')]/*[name()='text']"));
        List<String> monthsDA = new ArrayList<>();
        for (WebElement we : monthsAlarms){
            monthsAl.add(we.getText());
        }

        for (WebElement we :  monthsDevicesActivation){
            monthsDA.add(we.getText());
        }

        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("dmc_kpi") && s.contains(".xlsx")){
                listaFileLog.add(s);
            }
        }
        int last = 0;
        String n = "";
        for(String s : listaFileLog){
            //To esclude dmc_kpi from number control
            if (s.length()>12) {
                String numeroFile = s.split("[\\(\\)]")[1];
                //To control dmc_kpi(N) and get the latest downloaded file
                if (Integer.parseInt(numeroFile) > last) {
                    last = Integer.parseInt(numeroFile);
                    n = " "+"(" + numeroFile +")";
                }
            }
        }
        //Check the data
        String pathFileDaAprire = pathUserHome+"dmc_kpi"+n+".xlsx";
        File fileExcelScaricato = new File(pathFileDaAprire);
        FileInputStream file = new FileInputStream(fileExcelScaricato);
        Workbook workbook = new XSSFWorkbook(file);
        //Device Tab
        Sheet sheet = workbook.getSheet("Devices");
        //Columns
        Assert.assertEquals(sheet.getRow(0).getCell(1).getStringCellValue(), "Number", "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(2).getStringCellValue(), "Connected", " Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(3).getStringCellValue(), "Disconnected","Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(4).getStringCellValue(), "Connected %", "Text column in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(0).getCell(5).getStringCellValue(), "Disconnected %" ,  "Text column in xlsx file is different from test list description");
        //Rows
        Assert.assertEquals(sheet.getRow(1).getCell(0).getStringCellValue(), "Gateways", "Text row in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(2).getCell(0).getStringCellValue(), "Things", "Text row in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(3).getCell(0).getStringCellValue(), "Direct thing", "Text row in xlsx file is different from test list description");
        Assert.assertEquals(sheet.getRow(4).getCell(0).getStringCellValue(), "Total devices", "Text row in xlsx file is different from test list description");

        //Alarms Tab
        sheet = workbook.getSheet("Alarms");

        //Columns
        Assert.assertTrue(monthsAl.get(0).contains(sheet.getRow(0).getCell(1).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsAl.get(1).contains(sheet.getRow(0).getCell(2).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsAl.get(2).contains(sheet.getRow(0).getCell(3).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsAl.get(3).contains(sheet.getRow(0).getCell(4).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsAl.get(4).contains(sheet.getRow(0).getCell(5).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsAl.get(5).contains(sheet.getRow(0).getCell(6).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        //Rows
        Assert.assertEquals(sheet.getRow(1).getCell(0).getStringCellValue(), "Gateways alarms number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(2).getCell(0).getStringCellValue(), "Things alarms number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(3).getCell(0).getStringCellValue(), "Direct things alarms number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(4).getCell(0).getStringCellValue(), "Platform alarms number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(5).getCell(0).getStringCellValue(), "Total alarms number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(6).getCell(0).getStringCellValue(), "Gateways alarms number/Gateways number (%)", "Text row in xlsx file is different from test list description file" );
        Assert.assertEquals(sheet.getRow(7).getCell(0).getStringCellValue(), "Thing Alarms number/Things number (%)", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(8).getCell(0).getStringCellValue(), "Direct things Alarms number/Direct things number (%)", "Text row in xlsx file is different from test list description " );
        Assert.assertEquals(sheet.getRow(9).getCell(0).getStringCellValue(), "Platform alarms number/Total devices number (%)", "Text row in xlsx file is different from test list description" );

        //Activations Tab
        sheet = workbook.getSheet("Activations");

        //Columns
        Assert.assertTrue(monthsDA.get(0).contains(sheet.getRow(0).getCell(1).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsDA.get(1).contains(sheet.getRow(0).getCell(2).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsDA.get(2).contains(sheet.getRow(0).getCell(3).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsDA.get(3).contains(sheet.getRow(0).getCell(4).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsDA.get(4).contains(sheet.getRow(0).getCell(5).getStringCellValue()), "Text column in xlsx file is different from test list description" );
        Assert.assertTrue(monthsDA.get(5).contains(sheet.getRow(0).getCell(6).getStringCellValue()), "Text column in xlsx file is different from test list description" );

        Assert.assertEquals(sheet.getRow(1).getCell(0).getStringCellValue(), "Gateways number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(2).getCell(0).getStringCellValue(), "Things number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(3).getCell(0).getStringCellValue(), "Direct things number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(4).getCell(0).getStringCellValue(), "Total devices number", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(5).getCell(0).getStringCellValue(), "Gateways activations", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(6).getCell(0).getStringCellValue(), "Things activations", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(7).getCell(0).getStringCellValue(), "Direct things activations", "Text row in xlsx file is different from test list description" );
        Assert.assertEquals(sheet.getRow(8).getCell(0).getStringCellValue(), "Total activations", "Text row in xlsx file is different from test list description" );

        fileExcelScaricato.delete();
    }

    @And("I read the homepage exported file csv and check the row and columns are as expected")
    public void iReadTheDownloadedFileCsv() throws Exception {
        Actions action = new Actions(CommonPage.getDriver());

        //Get the file
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("dmc_kpi") && s.contains(".csv")){
                listaFileLog.add(s);
            }
        }
        int last = 0;
        String n = "";
        for(String s : listaFileLog){
            //To esclude dmc_kpi from number control
            if (s.length()>12) {
                String numeroFile = s.split("[\\(\\)]")[1];
                //To control dmc_kpi(N) and get the latest downloaded file
                if (Integer.parseInt(numeroFile) > last) {
                    last = Integer.parseInt(numeroFile);
                    n = " "+"(" + numeroFile +")";
                }
            }
        }
        //Check the data test 1
        String pathFileDaAprire = pathUserHome+"dmc_kpi"+n+".csv";
        File fileCsvScaricato = new File(pathFileDaAprire);

        //Reading file
        BufferedReader br = null;
        //String dataToRead= pathFileDaAprire;
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

        //Projects Table
            String projectsTableHeader = String.valueOf(data.get(0));

            String[]valueHeader=projectsTableHeader.split(delimiterCol);

            String projectsTableValues = String.valueOf(data.get(1));
            String[]valueCell=projectsTableValues.split(delimiterCol);

            //Header
            Assert.assertTrue(valueHeader[0].contains("Project ID"), "Text Header column in csv file is different from test list description" );
            Assert.assertTrue(valueHeader[1].contains("Project Name"), "Text Header column in csv file is different from test list description" );
            //Record
            Assert.assertTrue(valueCell[0].contains("esol-ap29551-qa"), "Text value column in csv file is different from test list description" );
            Assert.assertTrue(valueCell[1].contains("EGIP - QA"), "Text value column in csv file is different from test list description" );
        //Devices Table
            String devicesTableHeader = String.valueOf(data.get(3));
            String[]valueHeaderDevicesTable=devicesTableHeader.split(delimiterCol);

            //Header
            Assert.assertTrue(valueHeaderDevicesTable[1].contains("Number"), "Text Header 2 column in csv file is different from test list description" );
            Assert.assertTrue(valueHeaderDevicesTable[2].contains("Connected"), "Text Header 3 column in csv file is different from test list description" );
            Assert.assertTrue(valueHeaderDevicesTable[3].contains("Disconnected"), "Text Header 4 column in csv file is different from test list description" );
            Assert.assertTrue(valueHeaderDevicesTable[4].contains("Connected %"), "Text Header 5 column in csv file is different from test list description" );
            Assert.assertTrue(valueHeaderDevicesTable[5].contains("Disconnected %"), "Text Header 6 column in csv file is different from test list description" );

            //Record Gateway
            String projectsTableGatewayRow = String.valueOf(data.get(4));
            String[]gatewayRowDevicesTable=projectsTableGatewayRow.split(delimiterCol);
            String gatewayTotalDevices = ProjectPage.getGatewayDevicesNumber().getAttribute("innerHTML");
            String gatewayConnected = ProjectPage.getGatewayDevicesOnlineNumber().getText().replaceAll("Online", "").trim();
            int gatewayTotalDevicesNum = Integer.parseInt(gatewayTotalDevices);
            int gatewayConnectedNum = Integer.parseInt(gatewayConnected);

            int gatewayDisconnectedNum = gatewayTotalDevicesNum - gatewayConnectedNum;
            String gatewayDisconnected = Integer.toString(gatewayDisconnectedNum);
            String gatewayConnetedPerc = ProjectPage.getGatewayDevicesPercentage().getText().replace("%","");
            double gatewayConnetedPercN = Double.parseDouble(gatewayConnetedPerc);
            double gatewayDisconnectedPercN = 100.0 - gatewayConnetedPercN;
            String gatewayDisconnectedPerc = Double.toString(gatewayDisconnectedPercN);

            Assert.assertTrue(gatewayRowDevicesTable[0].contains("Gateway"),"Gateway Row is different");
            Assert.assertTrue(gatewayRowDevicesTable[1].contains(gatewayTotalDevices),"Gateway Row Total is different");
            Assert.assertTrue(gatewayRowDevicesTable[2].contains(gatewayConnected),"Gateway Row Connected is different");
            Assert.assertTrue(gatewayRowDevicesTable[3].contains(gatewayDisconnected),"Gateway Row Disconnected is different");
            Assert.assertTrue(gatewayRowDevicesTable[4].contains(gatewayConnetedPerc.replaceAll(".0","")),"Gateway Row Perc Connected is different");
            //Assert.assertTrue(gatewayRowDevicesTable[5].contains(gatewayDisconnectedPerc.replaceAll(".0","")),"Gateway Row Perc Disconnected is different");

            //Record Thing
            String projectsTableThingsRow = String.valueOf(data.get(5));
            String[]thingRowDevicesTable=projectsTableThingsRow.split(delimiterCol);

            String thingTotalDevices = ProjectPage.getThingDevicesNumber().getAttribute("innerHTML");
            String thingConnected = ProjectPage.getThingDevicesOnlineNumber().getText().replaceAll("Online", "").trim();

            int thingTotalDevicesNum = Integer.parseInt(thingTotalDevices);
            int thingConnectedNum = Integer.parseInt(thingConnected);

            int thingDisconnectedNum = thingTotalDevicesNum - thingConnectedNum;
            String thingDisconnected = Integer.toString(thingDisconnectedNum);

            String thingConnectedPerc = ProjectPage.getThingDevicesPercentage().getText().replace("%","");
            double thingConnectedPercN = Double.parseDouble(thingConnectedPerc);
            double thingDisconnectedPercN = 100.0 - thingConnectedPercN;
            String thingDisconnectedPerc = Double.toString(thingDisconnectedPercN);
            String thingDisconnectedPercP = thingDisconnectedPerc.substring(0,2);

            Assert.assertTrue(thingRowDevicesTable[0].contains("Thing"),"Thing Row is different");
            Assert.assertTrue(thingRowDevicesTable[1].contains(thingTotalDevices),"Thing Row Total is different");
            Assert.assertTrue(thingRowDevicesTable[2].contains(thingConnected),"Thing Row Connected is different");
            Assert.assertTrue(thingRowDevicesTable[3].contains(thingDisconnected),"Thing Row Disconnected is different");
            Assert.assertTrue(thingRowDevicesTable[4].contains(thingConnectedPerc.replaceAll(".0","")),"Thing Row Perc Connected is different");
            //Assert.assertTrue(thingRowDevicesTable[5].contains(thingDisconnectedPercP.replaceAll(".0","")),"Thing Row Perc Disconnected is different");

             //Record Direct Thing
            String projectsTableDirectThingRow = String.valueOf(data.get(6));
            String[]directThingRowDevicesTable=projectsTableDirectThingRow.split(delimiterCol);
            String directThingTotalDevices = ProjectPage.getDirectThingDevicesNumber().getAttribute("innerHTML");
            String directThingConnected = ProjectPage.getDirectThingDevicesOnlineNumber().getText().replaceAll("Online", "").trim();
            int directThingTotalDevicesNum = Integer.parseInt(directThingTotalDevices);
            int directThingConnectedNum = Integer.parseInt(directThingConnected);
            int directThingDisconnectedNum = directThingTotalDevicesNum - directThingConnectedNum;
            String directThingDisconnected = Integer.toString(directThingDisconnectedNum);
            String directThingConnetedPerc = ProjectPage.getDirectThingDevicesPercentage().getText().replace("%","");
            double directThingConnetedPercN = Double.parseDouble(directThingConnetedPerc);
            double directThingDisconnectedPercN = 100.0 - directThingConnetedPercN;
            String directThingDisconnectedPerc = Double.toString(directThingDisconnectedPercN);

            Assert.assertTrue(directThingRowDevicesTable[0].contains("Direct thing"),"Direct Thing Row is different");
            Assert.assertTrue(directThingRowDevicesTable[1].contains(directThingTotalDevices),"Direct Thing Row Total is different");
            Assert.assertTrue(directThingRowDevicesTable[2].contains(directThingConnected),"Direct Thing Row Connected is different");
            Assert.assertTrue(directThingRowDevicesTable[3].contains(directThingDisconnected),"Direct Thing Row Disconnected is different");
            Assert.assertTrue(directThingRowDevicesTable[4].contains(directThingConnetedPerc.replaceAll(".0","")),"Direct Thing Row Perc Connected is different");
            //Assert.assertTrue(directThingRowDevicesTable[5].contains(directThingDisconnectedPerc.replaceAll(".0","")),"Direct Thing Row Perc Disconnected is different");

            //Record Total
            String projectsTableTotalRow = String.valueOf(data.get(7));
            String[]totalRowDevicesTable=projectsTableTotalRow.split(delimiterCol);
            String totalDevices = ProjectPage.getTotalDevicesNumber().getAttribute("innerHTML");
            String totalDevicesConnected = ProjectPage.getTotalDevicesOnlineNumber().getText().replaceAll("Online", "").trim();
            int totalDevicesNum = Integer.parseInt(totalDevices);
            int totalDevicesConnectedNum = Integer.parseInt(totalDevicesConnected);
            int totalDevicesDisconnectedNum = totalDevicesNum - totalDevicesConnectedNum;
            String totalDevicesDisconnected = Integer.toString(totalDevicesDisconnectedNum);
            String totalDevicesConnetedPerc = ProjectPage.getTotalDevicesPercentage().getText().replace("%","");
            double totalDevicesConnetedPercN = Double.parseDouble(totalDevicesConnetedPerc);
            double totalDevicesDisconnectedPercN = 100.0 - totalDevicesConnetedPercN;
            String totalDevicesDisconnectedPerc = Double.toString(totalDevicesDisconnectedPercN);

            Assert.assertTrue(totalRowDevicesTable[0].contains("Total devices"),"Total devices Row is different");
            Assert.assertTrue(totalRowDevicesTable[1].contains(totalDevices),"Total devices Row Total is different");
            Assert.assertTrue(totalRowDevicesTable[2].contains(totalDevicesConnected),"Total devices Row Connected is different");
            Assert.assertTrue(totalRowDevicesTable[3].contains(totalDevicesDisconnected),"Total devices Row Disconnected is different");
            Assert.assertTrue(totalRowDevicesTable[4].contains(totalDevicesConnetedPerc.replaceAll(".0","")),"Total devices Row Perc Connected is different");
            //Assert.assertTrue(totalRowDevicesTable[5].contains(totalDevicesDisconnectedPerc.replaceAll(".0","")),"Total devices Row Perc Disconnected is different");

        //Alarms Table
        String alarmsTableHeader = String.valueOf(data.get(9));
        String[]valueHeaderAlarmsTable=alarmsTableHeader.split(delimiterCol);

        //HEADER
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth1().getText().contains((valueHeaderAlarmsTable[1]).trim()), "Header Alarms Table Month 1 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth2().getText().contains((valueHeaderAlarmsTable[2]).trim()), "Header Alarms Table Month 2 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth3().getText().contains((valueHeaderAlarmsTable[3]).trim()), "Header Alarms Table Month 3 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth4().getText().contains((valueHeaderAlarmsTable[4]).trim()), "Header Alarms Table Month 4 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth5().getText().contains((valueHeaderAlarmsTable[5]).trim()), "Header Alarms Table Month 5 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getAlarmsGraphMonth6().getText().contains((valueHeaderAlarmsTable[6]).trim().replace("]","")), "Header Alarms Table Month 6 column in csv file is different from DMC");

        //Gateways Alarms Num
        String alarmsTableGatewayNumberRecord = String.valueOf(data.get(10));
        String[] gatewaysRowAlarmsTable=alarmsTableGatewayNumberRecord.split(delimiterCol);
        //Things Alarms Num
        String alarmsTableThingsNumberRecord = String.valueOf(data.get(11));
        String[] thingsRowAlarmsTable=alarmsTableThingsNumberRecord.split(delimiterCol);
        //Direct Things Alarms Num
        String alarmsTableDirectThingsNumberRecord = String.valueOf(data.get(12));
        String[] directThingsRowAlarmsTable=alarmsTableDirectThingsNumberRecord.split(delimiterCol);
        //Custom Group Alarms Num
        String alarmsTableCustomGroupNumberRecord = String.valueOf(data.get(13));
        String[] customGroupRowAlarmsTable=alarmsTableCustomGroupNumberRecord.split(delimiterCol);
        //Alarm Target ALL
        String alarmsTableTargetAllNumberRecord = String.valueOf(data.get(14));
        String[] targetAllRowAlarmsTable=alarmsTableTargetAllNumberRecord.split(delimiterCol);
        //Total Alarms Num
        String alarmsTableTotalNumberRecord = String.valueOf(data.get(15));
        String[] totalRowAlarmsTable=alarmsTableTotalNumberRecord.split(delimiterCol);
        //Gateways Alarms Per
        String alarmsTableGatewayPerRecord = String.valueOf(data.get(16));
        String[] gatewaysPercRowAlarmsTable=alarmsTableGatewayPerRecord.split(delimiterCol);
        //Things Alarms Perc
        String alarmsTableThingsPercRecord = String.valueOf(data.get(17));
        String[] thingsPercRowAlarmsTable=alarmsTableThingsPercRecord.split(delimiterCol);
        //Direct Things Alarms Perc
        String alarmsTableDirectThingsPercRecord = String.valueOf(data.get(18));
        String[] directThingsPerRowAlarmsTable=alarmsTableDirectThingsPercRecord.split(delimiterCol);
        //ID column
        Assert.assertTrue(gatewaysRowAlarmsTable[0].contains("Gateways alarms number"),"Gateways alarms number Row ID is different");
        Assert.assertTrue(thingsRowAlarmsTable[0].contains("Things alarms number"),"Things alarms number Row ID is different");
        Assert.assertTrue(directThingsRowAlarmsTable[0].contains("Direct things alarms"),"Direct things alarms number Row ID is different");
        Assert.assertTrue(customGroupRowAlarmsTable[0].contains("Custom Group alarms number"),"Custom Group alarms number Row ID is different");
        Assert.assertTrue(targetAllRowAlarmsTable[0].contains("Alarm Target ALL"),"Alarm Target ALL Row ID is different");
        Assert.assertTrue(totalRowAlarmsTable[0].contains("Total alarms number"),"Total alarms number Row ID is different");
        Assert.assertTrue(gatewaysPercRowAlarmsTable[0].contains("Gateways alarms number/Gateways number (%)"),"Gateways alarms number Perc Row ID is different");
        Assert.assertTrue(thingsPercRowAlarmsTable[0].contains("Thing Alarms number/Things number (%)"),"Things alarms number Perc Row ID is different");
        Assert.assertTrue(directThingsPerRowAlarmsTable[0].contains("Direct things Alarms number/Direct things number (%)"),"Direct Things alarms number Perc Row ID is different");

        //Month 1:
        System.out.println("Month 1");
        WebElement alarmGraphMonth1 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[1]"));
        action.moveToElement(alarmGraphMonth1).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth1).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[1].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 1 is different");
        Assert.assertTrue(thingsRowAlarmsTable[1].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 1 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[1].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 1 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[1].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 1 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[1].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 1 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Month 2:
        System.out.println("Month 2");
        WebElement alarmGraphMonth2 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[2]"));
        action.moveToElement(alarmGraphMonth2).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth2).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[2].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 2 is different");
        Assert.assertTrue(thingsRowAlarmsTable[2].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 2 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[2].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 2 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[2].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 2 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[2].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 2 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Month 3:
        System.out.println("Month 3");
        WebElement alarmGraphMonth3 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[3]"));
        action.moveToElement(alarmGraphMonth3).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth3).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[3].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 3 is different");
        Assert.assertTrue(thingsRowAlarmsTable[3].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 3 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[3].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 3 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[3].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 3 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[3].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 3 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Month 4:
        System.out.println("Month 4");
        WebElement alarmGraphMonth4 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[4]"));
        action.moveToElement(alarmGraphMonth4).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth4).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[4].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 4 is different");
        Assert.assertTrue(thingsRowAlarmsTable[4].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 4 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[4].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 4 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[4].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 4 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[4].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 4 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Month 5:
        System.out.println("Month 5");
        WebElement alarmGraphMonth5 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[5]"));
        action.moveToElement(alarmGraphMonth5).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth5).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[5].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 5 is different");
        Assert.assertTrue(thingsRowAlarmsTable[5].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 5 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[5].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 5 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[5].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 5 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[5].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 5 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Month 6:
        System.out.println("Month 6");
        WebElement alarmGraphMonth6 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel pr-5']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[6]"));
        action.moveToElement(alarmGraphMonth6).build().perform();
        Thread.sleep(5000);
        action.click(alarmGraphMonth6).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysRowAlarmsTable[6].contains(ProjectPage.getGatewayAlarmsLegendNumber().getText()),"Gateways alarms number Month 6 is different");
        Assert.assertTrue(thingsRowAlarmsTable[6].contains(ProjectPage.getThingAlarmsLegendNumber().getText()),"Things alarms number Month 6 is different");
        Assert.assertTrue(directThingsRowAlarmsTable[6].contains(ProjectPage.getDirectThingAlarmsLegendNumber().getText()),"Direct things alarms number Month 6 is different");
        Assert.assertTrue(customGroupRowAlarmsTable[6].contains(ProjectPage.getCustomGroupAlarmsLegendNumber().getText()),"Custom group alarms number Month 6 is different");
        Assert.assertTrue(targetAllRowAlarmsTable[6].contains(ProjectPage.getTargetAllAlarmsLegendNumber().getText()),"Target All alarms number Month 6 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Activations Table
        //Header
        String activationsTableHeader = String.valueOf(data.get(20));
        String[]valueHeaderActivationsTable=activationsTableHeader.split(delimiterCol);
        System.out.println("ProjectPage.getDeviceGraphMonth1().getText(): "+ ProjectPage.getDeviceGraphMonth1().getText());
        System.out.println("valueHeaderActivationsTable[1].trim(): "+ valueHeaderActivationsTable[1].trim());
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth1().getText().contains(valueHeaderActivationsTable[1].trim()), "Header Month 1 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth2().getText().contains(valueHeaderActivationsTable[2].trim()), "Header Month 2 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth3().getText().contains(valueHeaderActivationsTable[3].trim()), "Header Month 3 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth4().getText().contains(valueHeaderActivationsTable[4].trim()), "Header Month 4 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth5().getText().contains(valueHeaderActivationsTable[5].trim()), "Header Month 5 column in csv file is different from DMC");
        Assert.assertTrue(ProjectPage.getDeviceGraphMonth6().getText().contains(valueHeaderActivationsTable[6].replace("]","").trim()), "Header Month 6 column in csv file is different from DMC");


        //Gateways Num
        String activationsTableGatewayNumberRecord = String.valueOf(data.get(21));
        String[] gatewaysNumberRowActivationsTable=activationsTableGatewayNumberRecord.split(delimiterCol);
        //Things Num
        String activationsTableThingsNumberRecord = String.valueOf(data.get(22));
        String[] thingsNumberRowActivationsTable=activationsTableThingsNumberRecord.split(delimiterCol);
        //Direct Things Num
        String activationsTableDirectThingsNumberRecord = String.valueOf(data.get(23));
        String[] directThingsNumberRowActivationsTable=activationsTableDirectThingsNumberRecord.split(delimiterCol);
        //Total devices Num
        String activationsTableTotalDevicesNumberRecord = String.valueOf(data.get(24));
        String[] totalDevicesNumberRowActivationsTable=activationsTableTotalDevicesNumberRecord.split(delimiterCol);
        //Gateways Activation
        String activationsTableGatewayActRecord = String.valueOf(data.get(25));
        String[] gatewaysActivationRowActivationsTable=activationsTableGatewayActRecord.split(delimiterCol);
        //Thing Activation
        String activationsTableThingActRecord = String.valueOf(data.get(26));
        String[] thingsActivationRowActivationsTable=activationsTableThingActRecord.split(delimiterCol);
        //Direct Thing Activation
        String activationsTableDirectThingActRecord = String.valueOf(data.get(27));
        String[] directThingsActivationRowActivationsTable=activationsTableDirectThingActRecord.split(delimiterCol);
        //Total Activations
        String activationsTableTotalNumberRecord = String.valueOf(data.get(28));
        String[] totalActivationsRowActivationsTable=activationsTableTotalNumberRecord.split(delimiterCol);
        //ID Column
        Assert.assertTrue(gatewaysNumberRowActivationsTable[0].contains("Gateways number"),"Type Gateway number Row is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[0].contains("Things number"),"Type Things number Row is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[0].contains("Direct things number"),"Type Direct Things number Row is different");
        Assert.assertTrue(totalDevicesNumberRowActivationsTable[0].contains("Total devices number"),"Type Total devices number Row is different");
        Assert.assertTrue(gatewaysActivationRowActivationsTable[0].contains("Gateways activations"),"Gateways activations Row is different");
        Assert.assertTrue(thingsActivationRowActivationsTable[0].contains("Things activations"),"Things activations Row is different");
        Assert.assertTrue(directThingsActivationRowActivationsTable[0].contains("Direct things activations"),"Direct Things activations Row is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[0].contains("Total activations"),"Total  activations Row is different");

        //Month 1:
        System.out.println("Devices Month 1");
        WebElement devicesGraphMonth1 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[1]"));
        action.moveToElement(devicesGraphMonth1).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth1).build().perform();
        Thread.sleep(5000);
        System.out.println("gatewaysNumberRowActivationsTable[1]: "+gatewaysNumberRowActivationsTable[1]+"ProjectPage.getGatewayLegendNumber().getText(): "+ProjectPage.getGatewayLegendNumber().getText());
        Assert.assertTrue(gatewaysNumberRowActivationsTable[1].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 1 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[1].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 1 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[1].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 1 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[1].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 1 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Devices Month 2:
        System.out.println("Devices Month 2");
        WebElement devicesGraphMonth2 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[2]"));
        action.moveToElement(devicesGraphMonth2).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth2).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysNumberRowActivationsTable[2].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 2 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[2].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 2 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[2].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 2 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[2].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 2 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Devices Month 3:
        System.out.println("Devices Month 3");
        WebElement devicesGraphMonth3 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[3]"));
        action.moveToElement(devicesGraphMonth3).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth3).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysNumberRowActivationsTable[3].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 3 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[3].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 3 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[3].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 3 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[3].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 3 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Devices Month 4:
        System.out.println("Devices Month 4");
        WebElement devicesGraphMonth4 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[4]"));
        action.moveToElement(devicesGraphMonth4).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth4).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysNumberRowActivationsTable[4].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 4 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[4].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 4 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[4].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 4 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[4].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 4 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Devices Month 5:
        System.out.println("Devices Month 5");
        WebElement devicesGraphMonth5 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[5]"));
        action.moveToElement(devicesGraphMonth5).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth5).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysNumberRowActivationsTable[5].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 5 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[5].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 5 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[5].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 5 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[5].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 5 is different");
        CommonPage.getDriver().navigate().refresh();
        Thread.sleep(5000);

        //Devices Month 6:
        System.out.println("Devices Month 6");
        WebElement devicesGraphMonth6 = CommonPage.getDriver().findElement(By.xpath("(//div[@class='dmc-chart-panel']/div[@class='highcharts-container ']//*[name()='svg'][@class='highcharts-root']//*[name()='g'][@class='highcharts-series-group']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']//*[name()='rect'][@class='highcharts-point'])[6]"));
        action.moveToElement(devicesGraphMonth6).build().perform();
        Thread.sleep(5000);
        action.click(devicesGraphMonth6).build().perform();
        Thread.sleep(5000);
        Assert.assertTrue(gatewaysNumberRowActivationsTable[6].contains(ProjectPage.getGatewayLegendNumber().getText()),"Gateway number Month 6 is different");
        Assert.assertTrue(thingsNumberRowActivationsTable[6].contains(ProjectPage.getThingLegendNumber().getText()),"Thing number Month 6 is different");
        Assert.assertTrue(directThingsNumberRowActivationsTable[6].contains(ProjectPage.getDirectThingLegendNumber().getText()),"Direct Thing number Month 6 is different");
        Assert.assertTrue(totalActivationsRowActivationsTable[6].contains(ProjectPage.getTotalActivationsLegendNumber().getText()),"Total activations Month 6 is different");

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

    @Then("I check that the Landing page is correctly translated in italian")
    public static void checkTranslationSoftwareCataloguePage() throws IOException {
        String [] tree  = new String[]{"controlRoom"};
        String [] tree_landing = new String[]{"controlRoom", "landingPage"};

        //DEVICES
        assertTrue(ProjectPage.getLabelDevicesIT().isPresent(), "The element " + ProjectPage.getLabelDevicesIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "chart_devicesLabel", ProjectPage.getLabelDevicesIT().getText(),null);

        assertTrue(ProjectPage.getTotalsHeaderInLandingPage().isPresent(), "The element " + ProjectPage.getTotalsHeaderInLandingPage() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "total", ProjectPage.getTotalsHeaderInLandingPage().getText(),null);

        //ACTIVATIONS
        assertTrue(ProjectPage.getLabelDeviceAndActivationIT().isPresent(), "The element " + ProjectPage.getLabelDeviceAndActivationIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "activationTimeseriesHeaderLabel", ProjectPage.getLabelDeviceAndActivationIT().getText(),null);

        assertTrue(ProjectPage.getSixMonthsDevicesActivationsIT().isPresent(), "The element " + ProjectPage.getSixMonthsDevicesActivationsIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths6", ProjectPage.getSixMonthsDevicesActivationsIT().getText(),null);

        assertTrue(ProjectPage.getThreeMonthsDevicesActivationsIT().isPresent(), "The element " + ProjectPage.getThreeMonthsDevicesActivationsIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths3", ProjectPage.getThreeMonthsDevicesActivationsIT().getText(),null);

        assertTrue(ProjectPage.getActivationsLegendIT().isPresent(), "The element " + ProjectPage.getActivationsLegendIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "chart_activationsLabel", ProjectPage.getActivationsLegendIT().getText().replace(":", ""),null);

        assertTrue(ProjectPage.getDescriptionDevicesActivationsIT().isPresent(), "The element " + ProjectPage.getDescriptionDevicesActivationsIT() + " is not present in the page ");
        CommonSteps.jsonReader(null, "tap a column", ProjectPage.getDescriptionDevicesActivationsIT().getText(),null);

        //ALARMS
        assertTrue(ProjectPage.getLabelAlarmsIT().isPresent(), "The element " + ProjectPage.getLabelAlarmsIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "alarmTimeseriesHeaderLabel", ProjectPage.getLabelAlarmsIT().getText(),null);

        assertTrue(ProjectPage.getSixMonthsAlarmIT().isPresent(), "The element " + ProjectPage.getSixMonthsAlarmIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths6", ProjectPage.getSixMonthsAlarmIT().getText(),null);

        assertTrue(ProjectPage.getThreeMonthsAlarmIT().isPresent(), "The element " + ProjectPage.getThreeMonthsAlarmIT() + " is not present in the page ");
        CommonSteps.jsonReader(tree_landing, "timeFilterMonths3", ProjectPage.getThreeMonthsAlarmIT().getText(),null);


        assertTrue(ProjectPage.getDescriptionAlarmsIT().isPresent(), "The element " + ProjectPage.getDescriptionAlarmsIT() + " is not present in the page ");
        CommonSteps.jsonReader(null, "tap a column", ProjectPage.getDescriptionAlarmsIT().getText(),null);

    }

    @Then("If present I delete export project page file in the downloaded folder")
    public void ifPresentIDeleteExportDataInTheDownloadedFolder() throws InterruptedException, IOException {
        Thread.sleep(20*1000);
        String pathUserHome = System.getProperty("user.home")+"\\Downloads\\";
        Set<String> listFiles = listFilesUsingDirectoryStream(pathUserHome);
        ArrayList<String> listaFileLog = new ArrayList<>();
        for(String s : listFiles){
            if(s.contains("dmc_kpi") && s.contains(".xlsx")){
                String nameFileDaAprire = "dmc_kpi.xlsx";
                String pathFileDaEliminare = pathUserHome + nameFileDaAprire;
                File fileExcelScaricato = new File(pathFileDaEliminare);
                fileExcelScaricato.delete();
            }
        }

    }

    @Then("I check if values of {string} in devices section are correct")
    public void iCheckIfNumberOfTotalsAreCorrect(String section) {
        String response = ApiUtilSteps.getResponse().asString();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(response);
        String numberDevices;
        String scorePercentage;
        String numberOnline;
        String deviceType;
        String []score;
        String scorePercDMC;
        PageElement pe;

        switch (section) {
            case "totals":
                numberDevices = tree.getAsJsonObject().get("hits").getAsJsonObject().get("total").getAsString();
                scorePercentage = tree.getAsJsonObject().get("hits").getAsJsonObject().get("max_score").getAsString();
                scorePercDMC = returnLeftNumber(ProjectPage.getTotalDevicesPercentage().getText());
                scorePercentage = returnLeftNumber(scorePercentage);
                pe = ProjectPage.getTotalDevicesPercentage();
                pe.scrollTo();
                numberOnline = tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_state_connected").getAsJsonObject().get("doc_count").getAsString();
                Assert.assertEquals(ProjectPage.getTotalDevicesNumber().getText(),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
                Assert.assertEquals(scorePercDMC,scorePercentage, "Total percentage value on dmc is different from value retrieved from test case URL 1");
                Assert.assertEquals(ProjectPage.getTotalDevicesOnlineNumber().getAttribute("innerHTML"),numberOnline + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
                break;
            case "gateway":
                scorePercDMC = returnLeftNumber(ProjectPage.getGatewayDevicesPercentage().getText());
                JsonObject gatewayPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(1).getAsJsonObject();
                deviceType = gatewayPath.get("key").getAsString();
                numberDevices = gatewayPath.get("doc_count").getAsString();
                scorePercentage = gatewayPath.get("by_state_connected_percentage").getAsJsonObject().get("value").getAsString();
                scorePercentage =returnLeftNumber(scorePercentage);
                pe = ProjectPage.getGatewayDevicesPercentage();
                pe.scrollTo();
                //FrontEnd parsing of 0.0 in 0 -----> have to adapt the check because dmc value is not exaclty the same as json response aggragation data
                //scorePercentage = (scorePercentage == "0.0") ? "0" : scorePercentage;
                numberOnline = gatewayPath.get("by_state_connected").getAsJsonObject().get("doc_count").getAsString();
                Assert.assertEquals(deviceType, "gateway", "In json response the gateway key is not found");
                Assert.assertEquals(ProjectPage.getGatewayDevicesNumber().getAttribute("innerHTML"),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
                System.out.println(scorePercDMC +" | "+scorePercentage);
                //Assert.assertEquals(scorePercDMC,scorePercentage, "Total percentage value on dmc is different from value retrieved from test case URL 2");
                Assert.assertEquals(ProjectPage.getGatewayDevicesOnlineNumber().getAttribute("innerHTML"),numberOnline + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
                break;
            case "direct thing":
                scorePercDMC = returnLeftNumber(ProjectPage.getDirectThingDevicesPercentage().getText());
                JsonObject directThingPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(2).getAsJsonObject();
                deviceType = directThingPath.get("key").getAsString();
                numberDevices = directThingPath.get("doc_count").getAsString();
                scorePercentage = directThingPath.get("by_state_connected_percentage").getAsJsonObject().get("value").getAsString();
                scorePercentage = returnLeftNumber(scorePercentage);
                //FrontEnd parsing of 0.0 in 0 -----> have to change the check because dmc value is not exaclty the same as json response aggragation data
                //scorePercentage = (scorePercentage == "0.0") ? "0" : scorePercentage;
                pe = ProjectPage.getDirectThingDevicesPercentage();
                pe.scrollTo();
                numberOnline = directThingPath.get("by_state_connected").getAsJsonObject().get("doc_count").getAsString();
                Assert.assertEquals(deviceType, "direct_thing", "In json response the direct_thing key is not found");
                Assert.assertEquals(ProjectPage.getDirectThingDevicesNumber().getText(), numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
                Assert.assertEquals(scorePercDMC.replace("%", "").trim(),scorePercentage.replace("%", "").trim(), "Total percentage value on dmc is different from value retrieved from test case URL 3. Expeted: "+scorePercDMC+" But found "+scorePercentage);
                Assert.assertEquals(ProjectPage.getDirectThingDevicesOnlineNumber().getAttribute("innerHTML"),numberOnline + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
                break;
            case "thing":
                scorePercDMC = returnLeftNumber(ProjectPage.getThingDevicesPercentage().getText());
                JsonObject thingPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(0).getAsJsonObject();
                deviceType = thingPath.get("key").getAsString();
                numberDevices = thingPath.get("doc_count").getAsString();
                scorePercentage = thingPath.get("by_state_activated_percentage").getAsJsonObject().get("value").getAsString();
                scorePercentage = returnLeftNumber(scorePercentage);
                System.out.println("scorePercentage:"+scorePercentage);
                //FrontEnd parsing of 0.0 in 0 -----> have to change the check because dmc value is not exaclty the same as json response aggragation data
                //scorePercentage = (scorePercentage == "0.0") ? "0" : scorePercentage;
                pe = ProjectPage.getThingDevicesPercentage();
                pe.scrollTo();
                numberOnline = thingPath.get("by_state_connected").getAsJsonObject().get("doc_count").getAsString();
                Assert.assertEquals(deviceType, "thing", "In json response the thing key is not found");
                //Assert.assertEquals(ProjectPage.getThingDevicesNumber().getAttribute("innerHTML"),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
                Assert.assertEquals(ProjectPage.getThingDevicesNumber().getText(), numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
                //Assert.assertEquals(scorePercDMC,scorePercentage, "Total percentage value on dmc is different from value retrieved from test case URL");
                Assert.assertEquals(scorePercDMC.replace("%", "").trim(),scorePercentage.replace("%", "").trim(), "Total percentage value on dmc is different from value retrieved from test case URL4. Expeted: "+scorePercDMC+" But found "+scorePercentage);
                //Assert.assertEquals(ProjectPage.getThingDevicesOnlineNumber().getText(),numberOnline + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
                Assert.assertEquals(ProjectPage.getThingDevicesOnlineNumber().getAttribute("innerHTML"),numberOnline + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
                break;
            default:

        }

    }

    @Then("^I verify the response from kibana and check the info about the devices: total, connected, disconnected and percentage$")
    public static void checkDeviceInfoKibana() throws InterruptedException, IOException, UnsupportedFlavorException {
        Thread.sleep(2000);
        List<String> timestamps = new ArrayList<>();
        String myText = LogSteps.retrieveResponseFromKibana();
        JsonObject job_notification = new JsonParser().parse(myText).getAsJsonObject();
        Assert.assertTrue(job_notification.isJsonObject(), "conversion failed!");
        String disconnected = "";
        String connected = "";
        String percentageConnected = "";
        String total = job_notification.get("hits").getAsJsonObject().get("total").getAsString();
        JsonArray devicesState  = job_notification.get("aggregations").getAsJsonObject().get("by_state").getAsJsonObject().get("buckets").getAsJsonArray();
        for(int i = 0; i<devicesState.size(); i++){
            if(devicesState.get(i).getAsJsonObject().get("key").getAsString().equalsIgnoreCase("disconnected")){
               disconnected = devicesState.get(i).getAsJsonObject().get("by_environment_prefix").getAsJsonObject().get("buckets").getAsJsonArray().get(0).getAsJsonObject().get("doc_count").getAsString();
            }else{
               connected  = devicesState.get(i).getAsJsonObject().get("by_environment_prefix").getAsJsonObject().get("buckets").getAsJsonArray().get(0).getAsJsonObject().get("doc_count").getAsString();
            }
        }

//        float percentage = (float) Integer.parseInt(connected) / Integer.parseInt(disconnected);
//        System.out.println(new BigDecimal(percentage));
//        percentageConnected = new BigDecimal(percentage).toString();

        ArrayList<String> tabs = new ArrayList<String>(CommonPage.getDriver().getWindowHandles());
        CommonPage.getDriver().switchTo().window(tabs.get(0)); //switches to new tab
        Thread.sleep(2500);
        Assert.assertEquals(ProjectPage.getTotalDevicesNumber().getText(),total, "Total device value on dmc is different from value retrieved from test case URL");
//        Assert.assertTrue(percentageConnected.contains(ProjectPage.getTotalDevicesPercentage().getText()), "Total percentage value on dmc is different from value retrieved from test case URL");
        Assert.assertEquals(ProjectPage.getTotalDevicesOnlineNumber().getText(),connected + " Online", "Total devices online value on dmc is different from value retrieved from test case URL");
    }

    @Then("I check if the graph for the \"(.+)\" section show \"(.+)\" months as expected")
    public static void checkNumberOfMonthShowed(String section, String num) throws InterruptedException {
        Thread.sleep(2000);
        PageElement pe;
        //String locatorMonths = "//header[contains(.,'%s')]/following-sibling::section[2]//*[name()='g' and contains(@class, 'highcharts-xaxis-labels')]/*[name()='text']";
        //String locatorMonths = "//header[contains(.,'%s')]";
        String locatorButton = "//header[contains(.,'%s')]/following-sibling::section[1]//button[contains(., '%s')]";
        locatorButton = String.format(locatorButton, section, num);
        pe = UtilFunctions.createNewPageElement("button "+num+ "of section "+section, locatorButton);
        Assert.assertTrue(pe.tryClick(), "Unable to click on the button: "+num);
        //CommonSteps.waitProgressBar();
        Thread.sleep(5000);
        String graphPath = "";
        switch (section){
            case "Devices & Activations":
                graphPath = "//header[contains(.,' Devices & Activations ')]/following-sibling::*//*[text()='Activations' and @class='highcharts-axis-title']/parent::*/parent::*//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/child::*";
                //graphPath = "//div[@class = 'dmc-chart-panel']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']/*[name()='rect'][@class = 'highcharts-point']";
                break;
            case "Alarms":
                graphPath = "//header[contains(.,' Alarms ')]/following-sibling::*//*[text()='Alarms' and @class='highcharts-axis-title']/parent::*/parent::*//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/child::*";
                //graphPath = "//div[@class = 'dmc-chart-panel pr-5']//*[name()='g'][@class='highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker']/*[name()='rect'][@class = 'highcharts-point']";
                break;
            default:
                Assert.fail("The value of section is not valid");
        }
        //locatorMonths = String.format(locatorMonths, section);
        List<WebElement> months = CommonPage.getDriver().findElements(By.xpath(graphPath));
        Assert.assertEquals(months.size(), Integer.parseInt(num), "The number of the month showed are different.");
    }
    @Then("I check if values devices numbers are correct")
    public void iCheckDevicesNumbers() {
        String response = ApiUtilSteps.getResponse().asString();
        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(response);
        String numberDevices;
        String deviceType;
        //totals check
        numberDevices = tree.getAsJsonObject().get("hits").getAsJsonObject().get("total").getAsString();
        //Assert.assertEquals(ProjectPage.getTotalDevicesNumber().getText(),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        Assert.assertEquals(ProjectPage.getTotalDevicesNumber().getAttribute("innerHTML"),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        //gateway check
        JsonObject gatewayPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(1).getAsJsonObject();
        deviceType = gatewayPath.get("key").getAsString();
        numberDevices = gatewayPath.get("doc_count").getAsString();
        Assert.assertEquals(deviceType, "gateway", "In json response the gateway key is not found");
        //Assert.assertEquals(ProjectPage.getGatewayDevicesNumber().getText(),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        Assert.assertEquals(ProjectPage.getGatewayDevicesNumber().getAttribute("innerHTML"),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        //direct thing check
        JsonObject directThingPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(2).getAsJsonObject();
        deviceType = directThingPath.get("key").getAsString();
        numberDevices = directThingPath.get("doc_count").getAsString();
        Assert.assertEquals(deviceType, "direct_thing", "In json response the direct_thing key is not found");
        //Assert.assertEquals(ProjectPage.getDirectThingDevicesNumber().getText(), numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        Assert.assertEquals(ProjectPage.getDirectThingDevicesNumber().getAttribute("innerHTML"), numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        //thing check
        JsonObject thingPath =tree.getAsJsonObject().get("aggregations").getAsJsonObject().get("by_thing_type").getAsJsonObject().get("buckets").getAsJsonArray().get(0).getAsJsonObject();
        deviceType = thingPath.get("key").getAsString();
        numberDevices = thingPath.get("doc_count").getAsString();
        Assert.assertEquals(deviceType, "thing", "In json response the thing key is not found");
        //Assert.assertEquals(ProjectPage.getThingDevicesNumber().getText(),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
        Assert.assertEquals(ProjectPage.getThingDevicesNumber().getAttribute("innerHTML"),numberDevices, "Total device value on dmc is different from value retrieved from test case URL");
    }

        public static String returnLeftNumber(String text){
        String textToReturn = "";
        String [] pos;
            if(text.contains(".")){
                pos = text.split(Pattern.quote("."));
                textToReturn = pos[0];
            }else{
                textToReturn = text;
            }
            return textToReturn;
        }

    @Then("I check if the data for the projects QA and PERF are correctly aggregated")
    public static void checkAggregationIsCorrect() throws InterruptedException {
        Thread.sleep(2000);

        //obtaining data of PERF project
        ProjectPage.getProjectPerfTab().click();
        Util.UtilFunctions.addScreenshot("PERF project");
        int gatewayDevicesNumberPerf = Integer.parseInt(ProjectPage.getGatewayDevicesNumber().getText());
        int directThingDevicesNumberPerf = Integer.parseInt(ProjectPage.getDirectThingDevicesNumber().getText());
        int thingDevicesNumberPerf = Integer.parseInt(ProjectPage.getThingDevicesNumber().getText());
        int totalDevicesNumberPerf = Integer.parseInt(ProjectPage.getTotalDevicesNumber().getText());

        //obtaining data of QA project
        ProjectPage.getProjectQaTab().click();
        Util.UtilFunctions.addScreenshot("QA project");
        int gatewayDevicesNumberQa = Integer.parseInt(ProjectPage.getGatewayDevicesNumber().getText());
        int directThingDevicesNumberQa = Integer.parseInt(ProjectPage.getDirectThingDevicesNumber().getText());
        int thingDevicesNumberQa = Integer.parseInt(ProjectPage.getThingDevicesNumber().getText());
        int totalDevicesNumberQa = Integer.parseInt(ProjectPage.getTotalDevicesNumber().getText());

        //obtaining aggregated data
        ProjectPage.getAggregatedProjectTab().click();
        Util.UtilFunctions.addScreenshot("Aggregated projects");
        int gatewayDevicesNumberAgg = Integer.parseInt(ProjectPage.getGatewayDevicesNumber().getText());
        int directThingDevicesNumberAgg = Integer.parseInt(ProjectPage.getDirectThingDevicesNumber().getText());
        int thingDevicesNumberAgg = Integer.parseInt(ProjectPage.getThingDevicesNumber().getText());
        int totalDevicesNumberAgg = Integer.parseInt(ProjectPage.getTotalDevicesNumber().getText());


        Assert.assertEquals(gatewayDevicesNumberAgg,gatewayDevicesNumberPerf+gatewayDevicesNumberQa);
        Assert.assertEquals(directThingDevicesNumberAgg,directThingDevicesNumberQa+directThingDevicesNumberPerf);
        Assert.assertEquals(thingDevicesNumberAgg,thingDevicesNumberPerf+thingDevicesNumberQa);
        Assert.assertEquals(totalDevicesNumberAgg,totalDevicesNumberPerf+totalDevicesNumberQa);

  }

}

