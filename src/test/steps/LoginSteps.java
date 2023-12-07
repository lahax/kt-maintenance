package test.steps;

import Util.UtilFunctions;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ta.common.CommonPage;
import ta.entities.elements.PageElement;
import ta.entities.elements.PageElementHelper;
import ta.utilities.Configuration;
import test.pages.HomePage;
import test.pages.LoginPage;



public class LoginSteps {

    @Then("I perform login as {string} user")
    public static void performLogin(String type) throws Exception {
//        PageElement.getPageElementHelper().enableHighlight(false);
        if(HomePageSteps.isLogout()){
            /*Inserito perché se viene fatto un logout, bisogna passare di nuovo dal form microsoft per cambiare account*/
            PageElement pe =  UtilFunctions.createNewPageElement("USe new account Button", "//div[@id='otherTileText']");
            Assert.assertTrue(pe.tryClick(false,false), "Unable to click on \"Use another account\" in order to login with another user account");
        }
        String user = null;
        String psw = null;
        switch (type){
            case "admin":
                user = Configuration.get("dmc.username");
                psw = Configuration.get("dmc.password");
                break;
            case "basic":
                user = Configuration.get("dmc.username.basic");
                psw = Configuration.get("dmc.password.basic");
                break;
            case "basic_CompacF_false":
                user = Configuration.get("dmc.username.basic.compacFlagFalse");
                psw = Configuration.get("dmc.password.basic.compacFlagFalse");
                break;
            default:
                Assert.fail("No valid option. User are: basic, basic_CompacF_false, admin");

        }

        PageElement microsoftLoginInputBox = UtilFunctions.createNewPageElement("Microsoft Input Box", "//*[@id='lightbox']");
        Assert.assertTrue(microsoftLoginInputBox.isPresent(), "Unable to find The Microsoft Box");

        if(LoginPage.userNameInputFormMicrosoft.isPresent(20)){
            Assert.assertTrue(LoginPage.userNameInputFormMicrosoft.fillText(user, false, 500, true), "Unable to fill text into "+ LoginPage.userNameInputFormMicrosoft.getBy());;
            UtilFunctions.addScreenshot("Insert the credential into the Microsoft form");
            Assert.assertTrue(LoginPage.userNameInputFormMicrosoft.fillText("", true, 500));;
        }

        Assert.assertTrue(microsoftLoginInputBox.isInvisible(20), "The Microsoft Box still remain after 20 sec");
        if(CommonPage.getDriver().getCurrentUrl().contains("sts.enel.com/")){
            String username = user.trim().replace("@", "%40");
            //String password = psw.trim();
            String urlRedirect = CommonPage.getDriver().getCurrentUrl().replace("https://", "https://"+username+":"+psw.trim()+"@");
            CommonPage.getDriver().navigate().to(urlRedirect);
        }

        if(LoginPage.emailInputFirstLogin.isPresent()){
            WebElement we = CommonPage.getDriver().findElement(LoginPage.emailInputFirstLogin.getBy());
            we.sendKeys(Keys.CONTROL+"a");
            we.sendKeys(Keys.BACK_SPACE);

            Assert.assertTrue(LoginPage.emailInputFirstLogin.fillText(user, false, 0, true), "Unable to fill text into "+ LoginPage.emailInputFirstLogin.getBy());;
            Assert.assertTrue(LoginPage.passwordInput.fillText(psw, false, 0, true), "Unable to fill text into "+ LoginPage.passwordInput.getBy());;
            UtilFunctions.addScreenshot("Insert the credentials into the input boxes");
            Assert.assertTrue(LoginPage.submitLoginBtn.tryClick(true, false), "Unable to click the button "+ LoginPage.submitLoginBtn.getBy());
            if(LoginPage.buttonNOFormMicrosoft.isPresent(20)){
                UtilFunctions.addScreenshot("Click on No in order to not save the session ");
                Assert.assertTrue(LoginPage.buttonNOFormMicrosoft.tryClick(true, false), "Unable to click the button "+ LoginPage.buttonNOFormMicrosoft.getBy());
            }
        }else if (HomePage.getUserLoggedIn().isPresent(20)){
            if(!user.contains(HomePage.getUserLoggedIn().getText().replace("ENELINT\\", " ").trim())){
                HomePageSteps.logOut();
                CommonPage.restartDriver();
                CommonPage.getDriver().close();
                CommonPage.restartDriver();
                HomePageSteps.setLogout(false);
                Thread.sleep(5000);
                CommonPage.goToPage(Configuration.get("dmc.url"));
                LoginPage.getLoginBtn().tryClick();
                performLogin(type);

            }
        }
        ta.entities.Util.Wait(10000);
        if(LoginPage.getLoginBtn().isPresent()) {
            LoginPage.getLoginBtn().tryClick();
            UtilFunctions.addScreenshot("After 10s the Login page is still visible even if the credentials were typed without problems. I try to click it.");

        }
        //I use a boolean for the condition because the assert doesnt give timeout and goes fail
        boolean isLogged = HomePage.getInfoUserLoggedIn().isPresent(30);
        Assert.assertTrue(isLogged,"Unable to log in. After 30 sec the HomePage is still not visible");
    }
}
