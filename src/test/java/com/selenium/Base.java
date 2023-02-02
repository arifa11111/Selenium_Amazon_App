package com.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    WebDriver driver;

    Properties prop;


    public Base(WebDriver driver){
        this.driver=driver;
    }


    public void visitUrl(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }


    public Properties init_properties()  {
        prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("/home/shaiA/Desktop/Amazon_Assigment_Selenium/src/main/resources/data.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }


    public void fullScreenCapture(String itemName) throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/shaiA/Desktop/Amazon_Assigment_Selenium/src/main/java/screenshots/"+itemName+".png"));

    }
}
