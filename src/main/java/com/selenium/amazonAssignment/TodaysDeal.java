package com.selenium.amazonAssignment;

import org.openqa.selenium.*;

import java.io.IOException;

public class TodaysDeal {

    WebDriver driver;

    By todayDealsLocator = By.xpath("//a[text()=\"Today's Deals\"]");

    By thirdItemGrid = By.xpath("//div[@aria-label='Deals grid']//div[position()=3]");


    public TodaysDeal(WebDriver driver){
        this.driver=driver;
    }


    public WebElement todaysDealBtn(){
        return driver.findElement(todayDealsLocator);
    }

    public WebElement thirdItemInDeals(){
        return driver.findElement(thirdItemGrid);
    }


    public void firstItemInLisOfItems() throws InterruptedException, IOException {

        Thread.sleep(3000);

        try{
             driver.findElement(By.xpath("(//div[@class='a-section octopus-dlp-asin-section'])[1]")).click();
        }
        catch (Exception ignored){}
        try{
             driver.findElement(By.xpath("//div[@data-testid='product-showcase-container']")).click();
        }
        catch (Exception ignored){}

        try{
            driver.findElement(By.xpath("(//div[contains(@class,'s-product-image-container')])[1]")).click();
        }
        catch (Exception ignored){}

    }
}
