package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Address {

    WebDriver driver;

    Properties prop = new Properties();
    FileInputStream fis;

    public Address(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addNewDeliveryAddress() throws IOException {

        try {
            fis = new FileInputStream("/home/shaiA/Desktop/Amazon_Assigment_Selenium/src/main/resources/data.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("add-new-address-popover-link")).click();

        By addressFormLocator = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']//input");

        List<WebElement> formFields = driver.findElements(addressFormLocator);

        for(int i=0;i<formFields.size()-1;i++){
            formFields.get(i).sendKeys(prop.getProperty("field."+i));
            Screenshots ss = new Screenshots(driver,"address"+i);
            ss.fullScreenCapture();
        }

        return driver.findElement(By.id("address-ui-widgets-form-submit-button"));
    }

    public void isAddressCorrect(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));

        By addressLocator = By.cssSelector("div.displayAddressDiv ul");

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLocator));

        driver.findElement(addressLocator).isDisplayed();

        String name = driver.findElement(By.cssSelector("div.displayAddressDiv ul li:first-child")).getText();

        Assert.assertEquals(name,prop.getProperty("field.0"));

    }

}
