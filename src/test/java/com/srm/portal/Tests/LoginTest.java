package com.srm.portal.Tests;

import com.srm.portal.Assertions;
import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

@Listeners(com.srm.portal.Listeners.TestListener.class)
public class LoginTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("Login Page Test");
    public Assertions assertions = null;

    @Test(priority = 0)
    public void initialize() throws Exception {
        initDriver();
        loadProperties();
    }

    @Test(priority = 1)
    public void loginTest() throws Exception {
        LoginPage login = new LoginPage();
        assertions = new Assertions();
        implicitWait(4);

        logger.info("Load Application Url");
        login.loadApplicationUrl(webdriver, getPropertyFromConfig("SRM_PORTAL_URL"));

        logger.info("Entering username");
        logger.info("CHECK WHETHER USERNAME IS VALID BEFORE LOGIN");
        String uname = getProperty("USER_NAME").trim().toString();
        assertions.assertUsername(uname);
        login.enterUserName(uname);

        logger.info("Entering password");
        String pass = getProperty("PASSWORD").trim().toString();
        login.enterPassword(pass);

        logger.info("Get text from captcha");
        // API CALL FOR CAPTCHA NOT WORKING - ENTER MANUALLY
        login.imageCaptcha();

        logger.info("Submit button");
        login.submitButton();
    }
}
