package com.srm.portal.Tests;

import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.AcademicPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.Math;

import java.util.logging.Logger;

public class AcademicTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("Academic Test");

    @Test(priority = 0)
    public void initialize() throws Exception {
        loadProperties();
    }

    @Test(priority = 1)
    public void academicTest() {
        AcademicPage academic = new AcademicPage();
        implicitWait(5);
        logger.info("Click Academic");
        academic.clickAcademic();

        logger.info("Click attendance");
        academic.attendanceDetails();
    }

    @Test(priority = 2)
    public void validateAttendance() throws Exception {
        AcademicPage academic = new AcademicPage();
        implicitWait(5);

        logger.info("Get total class hours");
        int total_hrs = Integer.parseInt(academic.getText("total"));
        int present_hrs = Integer.parseInt(academic.getText("present"));
        int absent_hrs = Integer.parseInt(academic.getText("absent"));
        String percent[] = academic.getText("percentage").split(" ");
        double percentage = Math.ceil(Double.parseDouble(percent[0]));

        try {
            Assert.assertEquals(absent_hrs, (total_hrs - present_hrs));
            logger.info("ABSENT DETAILS ARE CORRECT");
        } catch (Exception e) {
            logger.info("ABSENT HOURS NOT MATCH WITH TOTAL AND PRESENT HOURS DETAILS");
        }

        double value = (double) present_hrs / total_hrs;
        double getPercentage = Math.ceil(value * 100);
        try {
            Assert.assertEquals(percentage, getPercentage);
            logger.info("PERCENTAGE IS CORRECT");
        } catch (Exception e) {
            logger.info("Wrong with percentage in portal");
        }

        Thread.sleep(2000);
        academic.clickAcademic();
    }
}
