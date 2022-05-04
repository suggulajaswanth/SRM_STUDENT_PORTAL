package com.srm.portal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static Properties properties = null;
    public static String config_file = "\\src\\main\\resources\\config.properties";
    public static ReadDataFromJson json = null;
    protected static WebDriver webdriver = null;
    public static void loadProperties() throws Exception {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(projectDir() + config_file);
            properties.load(input);
        } catch (Exception e) {
            throw new FileNotFoundException("Config file not found");
        }
    }
    public static String projectDir() {
        String projectDirPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        return projectDirPath;
    }
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
    }
    public String getPropertyFromConfig(String key) {
        return properties.getProperty(key);
    }
    public String getProperty(String data) throws Exception {
        json = new ReadDataFromJson();
        return json.getProperty(data);
    }

    public void waitForElement(WebElement webElement, int time) {
        WebDriverWait wait = new WebDriverWait(webdriver, time);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void implicitWait(int time) {
        webdriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public boolean checkExistence(String element) {
        try {
            implicitWait(7);
            webdriver.findElement(By.xpath(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeAsyncScript("window.scrollBy(0,250)", "");
    }
    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }
}
