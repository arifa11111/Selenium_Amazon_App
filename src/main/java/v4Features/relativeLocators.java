package v4Features;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativeLocators {

    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameInput = driver.findElement(By.name("name"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameInput)).getText());

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();


        WebElement rdb = driver.findElement(By.id("inlineRadio1"));

        //partial screenshot
        File src=rdb.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/shaiA/Desktop/selinium/selinium_practise/src/main/java/ss/rdb.png"));

        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());




    }

}
