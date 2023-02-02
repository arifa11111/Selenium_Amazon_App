package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Orders {

    WebDriver driver;

    By firstOrder = By.xpath("//div[@id='ordersContainer']//div[contains(@class,'order')]");

    By orderLink = By.xpath("//a[contains(@href,'product')]");

    By yearDropDownLocator = By.cssSelector("select[name*='orderFilter']");

    By orderLocator = By.id("nav-orders");

    By buyNowBtn = By.id("buy-now-button");



    public Orders(WebDriver driver) {
        this.driver = driver;
    }



    public WebElement goToOrders(){
       return driver.findElement(orderLocator);
    }


    public WebElement yearDropDownInOrders(){ return driver.findElement(yearDropDownLocator); }


    public WebElement firstOrder(){
        return driver.findElement(firstOrder);
    }

    public WebElement firstOrderLink(){
        return driver.findElements(orderLink).get(0);
    }


    public WebElement buyNowBtn(){
        return driver.findElement(buyNowBtn);
    }

}
