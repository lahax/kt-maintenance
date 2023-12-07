package Util;

import org.openqa.selenium.By;
import ta.common.CommonPage;
import ta.entities.AutomixArgs;
import ta.entities.Util;
import ta.entities.elements.PageElement;
import ta.formatters.ReportFormatter;

public class UtilFunctions {
    public static void addScreenshot(String message) {
        try {
            String path = Util.screenshot(AutomixArgs.getFeatureName(), CommonPage.getDriver(), null);
            ReportFormatter.logInfo(message, path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static PageElement createNewPageElement(String description, String locator){
        By by = new By.ByXPath(locator);
        return new PageElement(description, by);
    }
}
