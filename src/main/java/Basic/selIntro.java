package Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selIntro {
    public static void main(String[] args){
        //crome browser for communication
//        System.setProperty("webdriver.chrome.driver","/home/shaiA/Desktop/selinium/chromedriver_linux64/chromedriver");

        //invoke browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
