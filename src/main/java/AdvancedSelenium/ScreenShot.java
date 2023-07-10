package AdvancedSelenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    WebDriver driver;

    @Test
    public void visit() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

//        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
//        Assert.assertFalse(true);
        driver.findElement(By.id("menuButton")).click();
        WebElement popup = driver.findElement(By.id("navbarDropMenu"));

        //partial screenshot
        File src=popup.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/main/java/AdvancedSelenium/popup.png"));

    }

    @AfterTest
    public void ss() throws IOException {
        System.out.println("---------------");
        //screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/main/java/AdvancedSelenium/screenshot.png"));
    }

}
