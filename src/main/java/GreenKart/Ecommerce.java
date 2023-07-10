package GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> cards =driver.findElements(By.xpath("//h4[@class='product-name']"));
        addItemsToCart(driver, cards);
        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://rahulshettyacademy.com/seleniumPractise/#/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        driver.findElement(By.cssSelector("span.promoInfo")).click();


    }



    public static void addItemsToCart(WebDriver driver, List<WebElement> cards){
        String[] veggis = {"cucumber","beetroot"};
        int i = 1;
        for (WebElement card : cards) {
            //convert array into arrayList
            List<String> veggisList = Arrays.asList(veggis);

            if (veggisList.contains(card.getText().toLowerCase().split(" ")[0])) {
                driver.findElement(By.xpath("(//button/parent::div[@class='product-action'])["+i+"]")).click();
            }
            i += 1;
        }
    }

}
