package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftNavToMainMenu {

    WebDriver driver;

    public LeftNavToMainMenu(WebDriver driver){
        this.driver=driver;
    }

    By leftNav = By.id("hmenu-canvas");

    By mobilesText = By.xpath("//a[.='Mobiles, Computers']");

    By closeBtnLocator = By.xpath("//div[@class='nav-sprite hmenu-close-icon']");



    public WebElement clickToGetSideNav(){
         return driver.findElement(By.cssSelector("#nav-main .nav-left"));
}
    public WebElement leftNav(){
        return driver.findElement(leftNav);
    }

    public WebElement MobilesTextInLeftNav(){
        return driver.findElement(mobilesText);
    }

    public WebElement closeBtnInLeftNav(){
        return driver.findElement(closeBtnLocator);
    }
}
