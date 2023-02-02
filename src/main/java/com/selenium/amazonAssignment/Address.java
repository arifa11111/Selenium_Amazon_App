package com.selenium.amazonAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Address {

    WebDriver driver;

    By addressFormLocator = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']//input");


    By newDeliveryAddressBtn = By.id("add-new-address-popover-link");

    By submitBtn = By.id("address-ui-widgets-form-submit-button");

    By addedAddressDetails = By.cssSelector("div.displayAddressDiv ul li:first-child");


    public Address(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addNewAddressBtn(){
        return  driver.findElement(newDeliveryAddressBtn);
    }


    public List<WebElement> deliveryAddressForm(){
        return driver.findElements(addressFormLocator);
    }


    public WebElement submitDeliveryAddressForm(){
        return driver.findElement(submitBtn);
    }

    public WebElement addedNameInAddressForm(){
        return driver.findElement(addedAddressDetails);
    }

}
