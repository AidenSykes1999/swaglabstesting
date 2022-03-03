package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.WebDriver;

public class CheckoutComplete {

    private WebDriver webDriver;

    public CheckoutComplete(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public InventoryPage clickBackHome(){
        return new InventoryPage(webDriver);
    }
}