package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicPage extends CommonMethods {
    public AcademicPage(){
        PageFactory.initElements(webdriver,this);
    }
    @FindBy(xpath = "//li[1]/a[1]/i[@class='fa fa-book']")
    private WebElement academic_btn;
    @FindBy(xpath = "//li[3]/a[1]/i[@class='fa fa-hourglass']")
    private WebElement attendance_details;
    @FindBy(xpath = "//tr[2]/td[3]")
    private WebElement total_hrs;

    @FindBy(xpath = "//tr[2]/td[4]")
    private WebElement present_hrs;

    @FindBy(xpath = "//tr[2]/td[5]")
    private WebElement absent_hrs;

    @FindBy(xpath = "//tr[2]/td[6]")
    private WebElement attendance_percent;
    public void clickAcademic(){
        academic_btn.click();
    }
    public void attendanceDetails(){
        attendance_details.click();
    }

    public String getText(String text){
        if(text.equalsIgnoreCase("total")){
            return total_hrs.getText().toString();
        }
        else if(text.equalsIgnoreCase("present")){
            return present_hrs.getText().toString();
        }
        else if(text.equalsIgnoreCase("absent")){
            return absent_hrs.getText().toString();
        }
        else if(text.equalsIgnoreCase("percentage")){
            return attendance_percent.getText().toString();
        }
        return "";
    }
}
