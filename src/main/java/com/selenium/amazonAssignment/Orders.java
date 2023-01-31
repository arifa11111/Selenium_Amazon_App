package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class Orders {

    WebDriver driver;

    public Orders(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToOrders(){
       return driver.findElement(By.id("nav-orders"));
    }

    public WebElement pastYearOrderedItems(int year) throws IOException {

        WebElement yearDropDown =  driver.findElement(By.cssSelector("select[name*='orderFilter']"));

        Assert.assertTrue(yearDropDown.isDisplayed());

        Select select = new Select(yearDropDown);

        select.selectByVisibleText(String.valueOf(year));

        WebElement orderItem = driver.findElement(By.xpath("//div[@id='ordersContainer']//div[contains(@class,'order')]"));

        Assert.assertTrue(orderItem.isDisplayed());

        List<WebElement> items= orderItem.findElements(By.xpath("//a[contains(@href,'product')]"));

        items.get(0).click();

        return driver.findElement(By.id("buy-now-button"));

    }

}
