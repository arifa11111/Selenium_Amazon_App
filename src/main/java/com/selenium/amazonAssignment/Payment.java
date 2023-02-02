package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Payment {

    WebDriver driver;

    By netBankingDropDown = By.cssSelector("select[name$='ppw-bankSelection_dropdown']");

    By addedBankLocator = By.cssSelector("#payment-information #spc_netbanking");

    By paymentSubmitBtn = By.cssSelector("input[name*='SetPaymentPlan'][type*='submit']");



    public Payment(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement netBanking(){
        return driver.findElement(netBankingDropDown);
    }


    public WebElement paymentSubmitBtn(){
        return driver.findElement(paymentSubmitBtn);
    }


    public WebElement isAddedBankCorrect(){
        return driver.findElement(addedBankLocator);
    }
}
