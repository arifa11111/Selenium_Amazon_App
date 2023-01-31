package com.selenium;

import com.selenium.amazonAssignment.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Year;

public class TestAfterLogin {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"URL","username","password"})
    public void installation(String url,String username,String password) throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Login singIn = new Login(driver);
        singIn.loginAmazonAccount(username,password);
    }

    @Test(priority = 1)
    public void enablePrimeCheckBox() throws IOException, InterruptedException {
        TodaysDeal todaysDeal = new TodaysDeal(driver);
        todaysDeal.goToTodaysDeal().click();
        PrimeCheckBox prime = new PrimeCheckBox(driver);
        prime.checkPrimeBox().click();
        prime.getFirstItem();
        //list of related items shown
        todaysDeal.clickOnAnyItem();
        prime.displayDeliveryDateOfItem();
    }

    @Test(priority = 2)
    public void goToOrdersTab() throws IOException {
        Orders orders = new Orders(driver);
        orders.goToOrders().click();
        orders.pastYearOrderedItems(Year.now().getValue()-2).click();
    }

    @Test(priority = 3)
    public void addingDeliveryAddress() throws IOException {
        Address address = new Address(driver);
        address.addNewDeliveryAddress().click();
        address.isAddressCorrect();
    }

    @Test(priority = 4)
    public void paymentOptions(){
        Payment payment = new Payment(driver);
        payment.addPaymentOptions();

    }

}

