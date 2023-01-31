package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LeftNavToMainMenu {

    WebDriver driver;

    public LeftNavToMainMenu(WebDriver driver){
        this.driver=driver;
    }

    public void clickToGetSideNav(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("#nav-main .nav-left")).click();

        By leftNav = By.id("hmenu-canvas");

        wait.until(ExpectedConditions.visibilityOfElementLocated(leftNav));

        WebElement menuPopUp = driver.findElement(leftNav);

        Assert.assertTrue(menuPopUp.isDisplayed());
    }

    public void navToMainMenu(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));

        By mobilesText = By.xpath("//a[.='Mobiles, Computers']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilesText));

        driver.findElement(mobilesText).click();

        By mainMenu = By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[@aria-label='Back to main menu']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainMenu));

        driver.findElement(mainMenu).click();

        WebElement closeBtn = driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']"));

        Assert.assertTrue(closeBtn.isDisplayed());

        closeBtn.click();
    }
}
