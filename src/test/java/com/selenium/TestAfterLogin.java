package com.selenium;

import com.selenium.amazonAssignment.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Year;
import java.util.List;
import java.util.Properties;

public class TestAfterLogin{
    public WebDriver driver;

    Properties prop;



    @BeforeTest
    @Parameters({"URL","username","password"})
    public void loginAmazon(String url,String username,String password){
        driver = new ChromeDriver();

        Base base = new Base(driver);
        prop = base.init_properties();
        base.visitUrl(url);

        Login singIn = new Login(driver);
        singIn.userAccount().click();
        singIn.emailInputBox().sendKeys(username);
        singIn.continueBtn().click();
        singIn.passwordInputBox().sendKeys(password);
        singIn.submitBtn().click();
    }

    @Test(priority = 1)
    public void enablePrimeCheckBox() throws IOException, InterruptedException {
        TodaysDeal todaysDeal = new TodaysDeal(driver);

        todaysDeal.todaysDealBtn().click();

        PrimeCheckBox prime = new PrimeCheckBox(driver);

        WebElement primeCheckBox = prime.primeCheckBox();

        Assert.assertTrue(primeCheckBox.isDisplayed());

        primeCheckBox.click();

        Thread.sleep(2000);

        prime.getFirstItem().click();

        //list of related items shown
        todaysDeal.firstItemInLisOfItems();

        System.out.println(prime.deliveryDateOfFirstItem().getText());
    }

    @Test(priority = 2)
    public void goToOrdersTab() {
        Orders orders = new Orders(driver);

        orders.goToOrders().click();

        WebElement yearDropDown = orders.yearDropDownInOrders();

        Assert.assertTrue(yearDropDown.isDisplayed());

        Select select = new Select(yearDropDown);

        select.selectByVisibleText(String.valueOf(Year.now().getValue()-2));

        Assert.assertTrue(orders.firstOrder().isDisplayed());

        orders.firstOrderLink().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        orders.buyNowBtn().click();

    }

    @Test(priority = 3)
    public void addingDeliveryAddress(){

        Address address = new Address(driver);

        address.addNewAddressBtn().click();

        List<WebElement> InputformFields = address.deliveryAddressForm();

        for(int i=0;i<InputformFields.size()-1;i++){
            InputformFields.get(i).sendKeys(prop.getProperty("field."+i));
        }

        address.submitDeliveryAddressForm().click();

        Assert.assertEquals(address.addedNameInAddressForm().getText(),prop.getProperty("field.0"));
    }

    @Test(priority = 4)
    @Parameters({"bank"})
    public void paymentOptionsForOrderingItem(String bank){

        Payment payment = new Payment(driver);

        WebElement netBankingDropdown = payment.netBanking();

        Select select = new Select(netBankingDropdown);

        select.selectByVisibleText(bank);

        payment.paymentSubmitBtn().click();

        String addedBank = payment.isAddedBankCorrect().getText();

        Assert.assertTrue(addedBank.contains(bank));
    }

}

