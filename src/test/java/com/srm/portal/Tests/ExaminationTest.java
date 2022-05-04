package com.srm.portal.Tests;

import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.ExaminationPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class ExaminationTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("Examination Test");

    @BeforeTest
    public void initialize() throws Exception {
        loadProperties();
    }

    @Test(priority = 1)
    public void examinationTest() throws Exception {
        ExaminationPage exam = new ExaminationPage();

        implicitWait(6);
        logger.info("Click examination");
        exam.clickExamination();

        logger.info("Click internal details");
        exam.clickInternals();

        logger.info("Choose which semester");
        exam.semesterClick();
        Thread.sleep(5000);
        exam.clickExamination();
    }
}
