package com.selenium;

import com.selenium.amazonAssignment.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;


public class TestBeforeLogin {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"URL"})
    public void installation(String url){
        driver = new ChromeDriver();
        Base base = new Base(driver);
        base.visitUrl(url);
    }

    @Test(priority = 1)
    public void goToTodaysDeal(){
        TodaysDeal todaysDeal = new TodaysDeal(driver);

        WebElement deal = todaysDeal.todaysDealBtn();

        Assert.assertTrue(deal.isDisplayed());

        todaysDeal.todaysDealBtn().click();
    }

    @Test(priority = 2)
    public void thirdItemInDeals() throws IOException, InterruptedException {
        TodaysDeal todaysDeal = new TodaysDeal(driver);
        todaysDeal.thirdItemInDeals().click();
        //list of related items shown
        todaysDeal.firstItemInLisOfItems();
    }

    @Test(priority = 3)
    public void SendItemToCartWithMinQty() throws Exception{

        SendItemToCart addToCart = new SendItemToCart(driver);

        WebElement cartBtn = addToCart.addToCartBtn();

        Assert.assertTrue(cartBtn.isDisplayed());

        cartBtn.click();

        addToCart.goToCart().click();

        WebElement qty = addToCart.qtyDropdown();

        Assert.assertEquals(qty.getAttribute("value"), "1");

    }

    @Parameters({"searchText"})
    @Test(priority = 4)
    public void Mobiles(String searchText) {

        Mobiles mobile = new Mobiles(driver);

        mobile.searchBox().sendKeys(searchText, Keys.ENTER);

        mobile.getLastMobilesDetails().click();
    }

    @Test(priority = 5)
    public void navigateLeftNavToMainMenu() throws IOException {
        Base ss = new Base(driver);

        LeftNavToMainMenu leftNav = new LeftNavToMainMenu(driver);

        leftNav.clickToGetSideNav().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

        ss.fullScreenCapture("nav");

        Assert.assertTrue(leftNav.leftNav().isDisplayed());

        WebElement mobileText = leftNav.MobilesTextInLeftNav();

        Assert.assertTrue(mobileText.isDisplayed());

        mobileText.click();

        WebElement closeIcon = leftNav.closeBtnInLeftNav();

        Assert.assertTrue(closeIcon.isDisplayed());

        closeIcon.click();
    }
}
