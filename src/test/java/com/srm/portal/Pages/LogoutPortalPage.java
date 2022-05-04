package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPortalPage extends CommonMethods {
    public LogoutPortalPage() {
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//a[@data-original-title='Logout']")
    private WebElement logout;

    public void logoutPortal() {
        logout.click();
    }
}
