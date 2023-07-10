package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsAndFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        Actions action = new Actions(driver);
        WebElement move= driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(move).build().perform();

        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().sendKeys(Keys.ENTER)
                .build().perform();

    }
}
