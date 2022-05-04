package com.srm.portal.Pages;

import com.srm.portal.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends CommonMethods {
    public ProfilePage() {
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//tr[1]/td[3]/b")
    private WebElement std_name;

    @FindBy(xpath = "//tr[2]/td[3]/b")
    private WebElement std_reg_no;

    @FindBy(xpath = "//tr[5]/td[3]/b")
    private WebElement semester;

    public String getText(String text) {
        if (text.equalsIgnoreCase("student")) {
            return std_name.getText().toString();
        } else if (text.equalsIgnoreCase("registration")) {
            return std_reg_no.getText().toString();
        } else if (text.equalsIgnoreCase("semester")) {
            return semester.getText().toString();
        }
        return "";
    }
}
