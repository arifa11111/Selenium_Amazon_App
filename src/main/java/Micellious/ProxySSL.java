package Micellious;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProxySSL {

    public static void main(String[] args) throws InterruptedException, IOException {

        //addition table amounts
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum= amounts.stream().mapToInt(amount -> Integer.parseInt((amount.getText()))).sum();
        Assert.assertEquals(sum,Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]));


//        security dissable SSL
        ChromeOptions opions = new ChromeOptions();
        opions.setAcceptInsecureCerts(true);

        //proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        opions.setCapability("proxy",proxy);
        WebDriver driver1 = new ChromeDriver(opions);
        driver1.get("https://expired.badssl.com/");

        //ignore pop-up's like allow micro phone...
        ChromeOptions options1= new ChromeOptions();
        opions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        WebDriver driver2 = new ChromeDriver(options1);
        driver2.get("https://zoom.us/j/98042435136#success");


        //by using prefs(preferences) we can able to give address hwere the downlad file should store

//        https://chromedriver.chromium.org/capabilities



    }
}
