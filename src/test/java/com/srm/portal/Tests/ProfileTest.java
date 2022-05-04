package com.srm.portal.Tests;

import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.ProfilePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

@Listeners(com.srm.portal.Listeners.TestListener.class)
public class ProfileTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("Profile page test");
    private static String profile_page_xpath = "//h2[contains(text(),\"PROFILE\")]";

    /**
     * CHECK DATA IS CORRECT OR NOT ON PROFILE PAGE
     */

    @BeforeTest
    private void initialize() throws Exception {
        loadProperties();
    }

    @Test(priority = 1)
    public void profilePagetTest() throws Exception {
        ProfilePage profile = new ProfilePage();
        implicitWait(5);

        while (!checkExistence(profile_page_xpath)) ;
        logger.info("CHECK STUDENT NAME IS CORRECT OR NOT");
        String std_name = getProperty("STUDENT_NAME");
        String profile_name = profile.getText("student");
        try {
            Assert.assertEquals(std_name, profile_name);
        } catch (Exception e) {
            logger.info("Student Name Is Incorrect");
        }

        logger.info("CHECK REGISTRATION NUMBER IS CORRECT OR NOT");
        String reg_no = getProperty("REGISTRATION_NUMBER");
        String profile_reg = profile.getText("registration");
        try {
            Assert.assertEquals(reg_no, profile_reg);
        } catch (Exception e) {
            logger.info("Registration Number Is Incorrect");
        }

        logger.info("CHECK SEMESTER IS CORRECT OR NOT");
        String semester = getProperty("SEMESTER");
        String profile_sem = profile.getText("semester");
        try {
            Assert.assertEquals(semester, profile_sem);
        } catch (Exception e) {
            logger.info("Semester Is Incorrect");
        }
    }
}
