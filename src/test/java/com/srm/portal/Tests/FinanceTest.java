package com.srm.portal.Tests;

import com.srm.portal.CommonMethods;
import com.srm.portal.Pages.FinancePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class FinanceTest extends CommonMethods {
    private static Logger logger = Logger.getLogger("Finance page test");

    @BeforeTest
    public void initialize() throws Exception {
        loadProperties();
    }

    @Test(priority = 1)
    public void financeTest() throws Exception {
        FinancePage finance = new FinancePage();
        implicitWait(5);

        logger.info("Clicking Finance");
        finance.clickFinance();

        logger.info("Clicking fee paid details");
        finance.feepaidDetails();

        logger.info("Scroll Page");
        //scroll();

        Thread.sleep(4000);
        finance.clickFinance();
    }
}
