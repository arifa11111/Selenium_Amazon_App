package com.selenium.amazonAssignment;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;

public class TodaysDeal {

    WebDriver driver;
    public TodaysDeal(WebDriver driver){
        this.driver=driver;
    }

    public WebElement goToTodaysDeal(){
        WebElement dealBtn = driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]"));

        Assert.assertTrue(dealBtn.isDisplayed());

        return dealBtn;
    }

    public WebElement clickOnThirdItem(){
        return driver.findElement(By.xpath("//div[@aria-label='Deals grid']//div[position()=3]"));
    }

    public void clickOnAnyItem() throws InterruptedException, IOException {
        Thread.sleep(3000);

        try{
            driver.findElement(By.xpath("(//div[@class='a-section octopus-dlp-asin-section'])[1]")).click();
        }
        catch (Exception ignored){}
        try{
            WebElement ele =  driver.findElement(By.xpath("//div[@data-testid='product-showcase-container']"));
            ele.click();
        }
        catch (Exception ignored){}

        try{
            driver.findElement(By.xpath("(//div[contains(@class,'s-product-image-container')])[1]")).click();
        }
        catch (Exception ignored){}

    }
}
