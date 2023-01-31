package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class SendItemToCart {

    WebDriver driver;

    public SendItemToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMinQtyForItem(){
        try {
            WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='quantity']"));
            Assert.assertTrue(dropdownElement.isDisplayed());
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("1");
        }
        catch (Exception ignored){}
    }

    public WebElement clickOnAddToCartBtn() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));

        if(driver.getWindowHandles().size()>1) {
            Set<String> handles=driver.getWindowHandles();
            Iterator<String> it=handles.iterator();
            String parentWindowId = it.next();
            String childWindow =it.next();
            driver.switchTo().window(childWindow);
        }

        By cartBtn = By.xpath("//input[@id='add-to-cart-button']");

        Assert.assertTrue(driver.findElement(cartBtn).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBtn));

        return driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
    }


    public WebElement goToCart() {

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));

        By cartPopUp = By.id("attach-view-cart-button-form");

        By directAddedToCart = By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']");

        By installationPopUp= By.cssSelector("button[data-action='a-popover-close']");

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

    public void checkQuantity() {
        try {
            WebElement qty = driver.findElement(By.xpath("//input[@name='quantityBox']"));

            Assert.assertEquals(qty.getAttribute("value"), "1");
        }
        catch (Exception ignored){}
    }
}
