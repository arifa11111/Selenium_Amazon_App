package AdvancedSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class frames {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
        driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeResult")));

        Actions action = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("drag1"));
        WebElement droppable = driver.findElement(By.id("div1"));

        System.out.println(draggable.getRect().getHeight());
        System.out.println(draggable.getRect().getDimension().getHeight());

        action.dragAndDrop(draggable,droppable).perform();

        System.out.println("done");

    }

}
