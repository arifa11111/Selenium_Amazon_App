package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Payment {

    WebDriver driver;

    public Payment(WebDriver driver) {
        this.driver = driver;
    }

    public void addPaymentOptions(){
        WebElement netBankingLocator = driver.findElement(By.cssSelector("select[name$='ppw-bankSelection_dropdown']"));

        Select select = new Select(netBankingLocator);

        select.selectByVisibleText("ICICI Bank");

        driver.findElement(By.cssSelector("input[name*='SetPaymentPlan'][type*='submit']")).click();

        By addedBankLocator = By.cssSelector("#payment-information #spc_netbanking");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));

        wait.until(ExpectedConditions.visibilityOfElementLocated(addedBankLocator));

        String checkBank = driver.findElement(addedBankLocator).getText();

        Assert.assertTrue(checkBank.contains("ICICI Bank"));

    }
}
