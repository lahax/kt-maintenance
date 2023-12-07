package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class LoginPage {
    public static PageElement getLoginBtn() {
        return loginBtn;
    }

    @Element(xpath ="//button[contains(text(),'Login')]", desc ="login button")
    public static PageElement loginBtn;
    @Element(xpath ="//input[@id= 'userNameInput' and @type = 'email']", desc ="Email input first login")
        public static PageElement emailInputFirstLogin;
    @Element(xpath ="//input[@type = 'submit']", desc ="Email input first login submit button")
    public static PageElement emailInputFirstLoginSubmitBtn;
    @Element(xpath ="//input[@id = 'passwordInput']", desc ="Password Input ")
        public static PageElement passwordInput;
    @Element(xpath ="//span[@id = 'submitButton']", desc ="Password Input ")
        public static PageElement submitLoginBtn;
    @Element(xpath ="//input[@id = 'userNameInput']", desc ="Username Input ")
    public static PageElement usernameInput;
    @Element(xpath ="//input[@id = 'idSIButton9']", desc ="keep sign in YES ")
    public static PageElement keepSignInYES;


    @Element(xpath = "//input[@type='email' and @name='loginfmt']", desc = "inputbox username form")
    public static PageElement userNameInputFormMicrosoft;
    @Element(xpath = "//input[@type='button' and @value='No']", desc = "button No - form microsoft - keep me signed in")
    public static PageElement buttonNOFormMicrosoft;
}
