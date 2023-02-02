package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PrimeCheckBox {
    WebDriver driver;

    By primeCheckBox = By.xpath("//i[@aria-label='Prime eligible']/ancestor::label/child::input");

    By elementLocator = (By.xpath("(//div[@aria-label='Deals grid']//div[contains(@class,'DealGridItem-module')])[1]"));

    By deliveryDateLocator = By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']/child::span");


    public PrimeCheckBox(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement primeCheckBox(){
        return driver.findElement(primeCheckBox);
    }


    public WebElement getFirstItem(){
       return driver.findElement(elementLocator);
    }


    public WebElement deliveryDateOfFirstItem(){
        return driver.findElement(deliveryDateLocator);
    }

}
