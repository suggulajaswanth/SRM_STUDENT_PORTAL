package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    public LoginPage() {
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement user_name;

    @FindBy(xpath = "//input[@id='AuthKey']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='ccode']")
    private WebElement captcha;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    public void loadApplicationUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public void enterUserName(String uname) {
        setText(user_name, uname);
    }

    public void enterPassword(String pass) {
        setText(password, pass);
    }

    public void imageCaptcha() throws Exception {
        /*Actions actions = new Actions(webdriver);
        actions.contextClick(captcha).perform();*/
        captcha.click();
    }

    public void submitButton() throws Exception {
        Thread.sleep(7000);
        submitBtn.click();
    }
}
