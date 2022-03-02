package com.sparta.swaglabstesting;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {
    private WebDriver webDriver;
    private String numberRegex;
    public CheckoutStepTwoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.numberRegex = "[^0-9]";
    }

    public Cart goToCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new Cart(webDriver);
    }

    public CheckoutStepOnePage cancelBackToCheckoutStepOne(){
        webDriver.findElement(By.id("cancel")).click();
        return new CheckoutStepOnePage(webDriver);
    }

    public int getTaxCents(){
        String taxText = webDriver.findElement(By.className("summary_tax_label")).getText();
        return Integer.parseInt(taxText.replace(this.numberRegex,""));
    }

    public int getTotalCents(){
        String totalText = webDriver.findElement(By.className("summary_total_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public int getItemTotalCents(){
        String totalText = webDriver.findElement(By.className("summary_subtotal_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public void finishToCheckoutComplete(){
        webDriver.findElement(By.id("finish")).click();
    }
}
