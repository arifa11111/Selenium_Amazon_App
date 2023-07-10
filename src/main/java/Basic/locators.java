package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class locators {
    public static void main(String[] args) throws InterruptedException {
        //crome browser for communication

        //invoke browser
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Arifa Shaik");
        driver.findElement(By.name("inputPassword")).sendKeys("Arifa@786");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Arifa");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Arifa@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        System.out.println(driver.findElement(By.xpath("//form/h2")).getText());
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Arifa@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7330979910");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Arifa");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);

       // Advanced Basic.locators
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();


//        driver.close();
    }
}
