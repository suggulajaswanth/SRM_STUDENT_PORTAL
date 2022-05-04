package com.srm.portal.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestListener implements ITestListener {
    private static Logger logger = Logger.getLogger("Listeners");

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Executing " + result.getName() + " Test");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Something went wrong in method " + result.getMethod());
        System.exit(0);
    }
}
