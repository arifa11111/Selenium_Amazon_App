package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAmazonAccount(String username,String password) throws IOException {

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys(username);
        driver.findElement(By.cssSelector("input#continue")).click();

        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#signInSubmit")).click();




    }
}
