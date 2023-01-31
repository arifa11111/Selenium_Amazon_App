package com.selenium;

import com.selenium.amazonAssignment.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;


public class TestBeforeLogin {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"URL"})
    public void installation(String url){
        System.out.println("************ landing page *************8");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get(url);
    }

    @Test(priority = 1)
    public void goToTodaysDeal(){
        TodaysDeal todaysDeal = new TodaysDeal(driver);
        todaysDeal.goToTodaysDeal().click();
    }

    @Test(priority = 2)
    public void thirdItemInDeals() throws IOException, InterruptedException {
        TodaysDeal todaysDeal = new TodaysDeal(driver);
        todaysDeal.clickOnThirdItem().click();
        //list of related items shown
        todaysDeal.clickOnAnyItem();
    }

    @Test(priority = 3)
    public void SendItemToCartWithMinQty() throws IOException, InterruptedException {
        SendItemToCart addToCart = new SendItemToCart(driver);
        addToCart.selectMinQtyForItem();
        addToCart.clickOnAddToCartBtn().click();
        addToCart.goToCart().click();
        addToCart.checkQuantity();
    }

    @Test(priority = 4)
    public void Mobiles() throws IOException, InterruptedException {
        Mobiles mobile = new Mobiles(driver);
        mobile.searchMobiles();
        mobile.getLastMobilesDetails();
    }

    @Test(priority = 5)
    public void navigateLeftNavToMainMenu() throws IOException {
        LeftNavToMainMenu leftNav = new LeftNavToMainMenu(driver);
        leftNav.clickToGetSideNav();
        leftNav.navToMainMenu();
    }
}
