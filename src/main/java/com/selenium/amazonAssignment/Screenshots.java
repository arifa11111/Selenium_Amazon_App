package com.selenium.amazonAssignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    WebDriver driver;
    String itemName;
    public Screenshots(WebDriver driver,String itemName){
        this.driver=driver;
        this.itemName=itemName;
    }

    public void PartialScreenshots(){

    }

//    public boolean checkConditions(WebElement webElement){
//        try{
//            return webElement.isDisplayed();
//        }
//        catch (Exception e){
//            return false;
//        }
//    }

    public void fullScreenCapture() throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/shaiA/Desktop/Amazon_Assigment_Selenium/src/main/java/screenshots/"+itemName+".png"));

    }
}
