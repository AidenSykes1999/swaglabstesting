package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwo {
    WebDriver webDriver;
    public CheckoutStepTwo(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Cart goToCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new Cart(webDriver);
    }

    public CheckoutStepOnePage cancelBackToCheckoutStepOne(){
        webDriver.findElement(By.id("cancel")).click();
        return new CheckoutStepOnePage(webDriver);
    }
}
