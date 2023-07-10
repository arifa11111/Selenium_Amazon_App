package Micellious;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class brokenLinks {

    public static void main(String[] args) throws InterruptedException, IOException {

        //addition table amounts
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

        //screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/shaiA/Desktop/selinium/selinium_practise/src/main/java/ss/screenshot.png"));

        //broken links
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']//a[not(@href='#')]"));


        //soft assertion
        SoftAssert a = new SoftAssert();

        links.forEach((link)->{
           String url = link.getAttribute("href");

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                a.assertTrue(connection.getResponseCode()<400,link.getText()+" link is broken");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        a.assertAll();
    }
}
