package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FinancePage extends CommonMethods {
    public FinancePage() {
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//li[3]/a[contains(text(),'Finance')][1]/i[@class='fa fa-dollar']")
    private WebElement finance;

    @FindBy(xpath = "//a[contains(text(),\"Fee Paid\")]")
    private WebElement feepaidDetails;

    public void clickFinance() {
        finance.click();
    }

    public void feepaidDetails() {
        feepaidDetails.click();
    }
}
