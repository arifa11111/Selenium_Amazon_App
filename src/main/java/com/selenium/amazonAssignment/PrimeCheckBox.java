package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PrimeCheckBox {
    WebDriver driver;

    public PrimeCheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkPrimeBox(){

        By primeCheckBox = By.xpath("//i[@aria-label='Prime eligible']/ancestor::label/child::input");

        Assert.assertTrue(driver.findElement(primeCheckBox).isDisplayed());

        return driver.findElement(primeCheckBox);
    }

    public void getFirstItem(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        By elementLocator = (By.xpath("(//div[@aria-label='Deals grid']//div[contains(@class,'DealGridItem-module')])[1]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        driver.findElement(elementLocator).click();
    }

    public void displayDeliveryDateOfItem(){
        By deliveryDateLocator = By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']/child::span");

        String DeliveryDate = driver.findElement(deliveryDateLocator).getText();

        System.out.println("********* Delivery Date of product : "+DeliveryDate+"*********");
    }

}
