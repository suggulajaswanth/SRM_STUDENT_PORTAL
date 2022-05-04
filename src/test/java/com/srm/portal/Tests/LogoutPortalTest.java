package com.srm.portal.Tests;

import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.LogoutPortalPage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LogoutPortalTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("LogoutTest");

    @Test
    public void logoutPortal() {
        LogoutPortalPage logout = new LogoutPortalPage();
        implicitWait(5);
        logger.info("Logout from portal");
        logout.logoutPortal();
    }

    @Test(priority = 2)
    public void tearDown() {
        logger.info("Close Driver");
        webdriver.quit();
    }
}
