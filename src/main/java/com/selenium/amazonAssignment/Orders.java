package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class Orders {

    WebDriver driver;

    String year;

    public Orders(WebDriver driver, String year) {
        this.driver = driver;
        this.year = year;
    }

    public WebElement goToOrders(){
       return driver.findElement(By.id("nav-orders"));
    }

    public WebElement pastYearOrderedItems() throws IOException {

        WebElement yearDropDown =  driver.findElement(By.cssSelector("select[name*='orderFilter']"));

        Select select = new Select(yearDropDown);

        select.selectByVisibleText(year);

        WebElement orderItem = driver.findElement(By.xpath("//div[@id='ordersContainer']//div[contains(@class,'order')]"));

        List<WebElement> items= orderItem.findElements(By.xpath("//a[contains(@href,'product')]"));

        items.get(0).click();

        return driver.findElement(By.id("buy-now-button"));

    }

}
