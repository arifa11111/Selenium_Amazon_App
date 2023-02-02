package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Login {

    WebDriver driver;

    By accountLocator = By.id("nav-link-accountList");

    By emailBox = By.id("ap_email");

    By continueBtn = By.cssSelector("input#continue");

    By passwordInputBox = By.id("ap_password");

    By submitBtn = By.cssSelector("input#signInSubmit");



    public Login(WebDriver driver) {
        this.driver = driver;
    }



    public WebElement userAccount(){
       return driver.findElement(accountLocator);
    }

    public WebElement emailInputBox(){
        return driver.findElement(emailBox);
    }

    public WebElement continueBtn(){
        return driver.findElement(continueBtn);
    }

    public WebElement passwordInputBox(){
        return driver.findElement(passwordInputBox);
    }
    public WebElement submitBtn() {
        return driver.findElement(submitBtn);
    }
}
