package com.selenium.amazonAssignment;

import org.openqa.selenium.*;


public class Mobiles {

    WebDriver driver;

    By searchBoxLoxator = By.id("twotabsearchtextbox");

    By lastMobileLink = By.xpath("(//div[@data-component-type='s-search-result'][last()]//a)[4]");


    public Mobiles(WebDriver driver){
        this.driver=driver;
    }


    public WebElement searchBox(){
        return driver.findElement(searchBoxLoxator);
    }

    public WebElement getLastMobilesDetails(){
        return driver.findElement(lastMobileLink);
    }


}
