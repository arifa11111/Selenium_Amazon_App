package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class SendItemToCart {

    WebDriver driver;

    By qtyLocator = By.xpath("//select[@id='quantity']");

    By cartPopUp = By.id("attach-view-cart-button-form");

    By directAddedToCart = By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']");

    By installationPopUp= By.cssSelector("button[data-action='a-popover-close']");

    By cartBtn = By.xpath("//input[@id='add-to-cart-button']");



    public SendItemToCart(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement qtyDropdown(){
        return driver.findElement(qtyLocator);
    }


    public WebElement addToCartBtn(){

        if(driver.getWindowHandles().size()>1) {
            Set<String> handles=driver.getWindowHandles();
            Iterator<String> it=handles.iterator();
            String parentWindowId = it.next();
            String childWindow =it.next();
            driver.switchTo().window(childWindow);
        }

        return driver.findElement(cartBtn);
    }


    public WebElement goToCart() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopUp));
            Assert.assertTrue(driver.findElement(cartPopUp).isDisplayed());
            return driver.findElement(cartPopUp);
        }
        catch (Exception ignored){}

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(installationPopUp));
            Assert.assertTrue(driver.findElement(installationPopUp).isDisplayed());
            return driver.findElement(installationPopUp);
        }
        catch (Exception ignored){}

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(directAddedToCart));
            return driver.findElement(directAddedToCart);
        }
        catch (Exception ignored){}

        System.out.println(".............................null......................");
        return null;
    }

}
