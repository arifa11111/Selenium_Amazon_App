package calender;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class calendar {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        //to perform Scroll on application using Selenium
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form-field-travel_comp_date']")));
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();

        System.out.println(driver.findElement(By.cssSelector("div.flatpickr-calendar")).isDisplayed());

        //April 19
        while(!driver.findElement(By.cssSelector("div.flatpickr-current-month")).getText().equalsIgnoreCase("april")){
            System.out.println("**********"+driver.findElement(By.cssSelector("div.flatpickr-current-month")).getText());
            driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
        }

//        List<WebElement> dates = driver.findElements(By.cssSelector("span.flatpickr-day"));
//
//        System.out.println("out");
//        System.out.println(dates.size());
//
//
//        for(int i=1; i<=dates.size();i++){
//            System.out.println("hiiiiii");
//            WebElement date = dates.get(i);
//            System.out.println(date.getText());
//            if(date.getText().contains("19")){
//                System.out.println(date.getText());
//                date.click();
//                break;
//            }
//        }

    }

}