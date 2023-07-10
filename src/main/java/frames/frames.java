package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println("...........");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        Actions action = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        System.out.println(draggable.getRect().getHeight());
        System.out.println(draggable.getRect().getDimension().getHeight());


        action.dragAndDrop(draggable,droppable).build().perform();

        System.out.println("done");

    }
}
