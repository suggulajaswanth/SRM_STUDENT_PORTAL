package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExaminationPage extends CommonMethods {
    public ExaminationPage() {
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//li[4]/a[1]/i[@class='fa fa-edit']")
    private WebElement examination;
    @FindBy(xpath = "//a[contains(text(),'Earlier Internal Marks')]/i")
    private WebElement internal_marks;

    public void clickExamination() {
        examination.click();
    }

    public void clickInternals() {
        internal_marks.click();
    }

    public void semesterClick() throws Exception {
        String semester = "//button[contains(text(),\"Semester 7\")]".replace("7", getProperty("INTERNAL_MARKS_SEMESTER"));
        WebElement element = webdriver.findElement(By.xpath(semester));
        element.click();
    }
}
