package com.selenium.amazonAssignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Mobiles {

    WebDriver driver;

    public Mobiles(WebDriver driver){
        this.driver=driver;
    }

    public void searchMobiles(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles", Keys.ENTER);
    }

    public void getLastMobilesDetails() throws IOException, InterruptedException {

        By lastMobileLink = By.xpath("(//div[@data-component-type='s-search-result'][last()]//a)[4]");

        WebElement phn = driver.findElement(lastMobileLink);

        FileUtils.copyFile(phn.getScreenshotAs(OutputType.FILE), new File("/home/shaiA/Desktop/Amazon_Assigment_Selenium/src/main/java/screenshots/phn.png"));

        phn.click();

        Thread.sleep(3000);

        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowId = it.next();

        driver.switchTo().window(parentWindowId);

    }


}
