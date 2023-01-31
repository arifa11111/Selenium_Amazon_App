package com.selenium.amazonAssignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TodaysDeal {

    WebDriver driver;
    public TodaysDeal(WebDriver driver){
        this.driver=driver;
    }

    public WebElement goToTodaysDeal(){
        return driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]"));
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
