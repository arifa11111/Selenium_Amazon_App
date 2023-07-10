package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdowm = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        //if select is there in dropdown then its static one.only applicable to select tag.
        Select dropdown = new Select(staticDropdowm);
        dropdown.selectByVisibleText("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        int i=0;
        while(i<3){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("divpaxinfo")).getText();

        //dynamic Basic.dropdowns
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
        driver.findElement(By.xpath("//option[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_destinationStation1'] //option[@value='MAA']")).click();

        //auto suggestive Basic.dropdowns
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);

        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/child::a"));

        options.forEach((option)->{
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
            }
        });

        driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());


        //assertions
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());


        //date calender
        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
        Thread.sleep(1000);
        if(driver.findElement(By.xpath("//input[@class='custom_date_pic required home-date-pick']")).getAttribute("style").contains("0.5")){
            Assert.assertFalse(false);
        }
    }
}
