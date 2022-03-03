package com.sparta.swaglabstesting;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutStepTwoPage {
    private WebDriver webDriver;
    private String numberRegex;
    public CheckoutStepTwoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.numberRegex = "[^0-9]";
    }

    public void showNavBar(){
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public Cart goToCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new Cart(webDriver);
    }





    public List<Integer> getInventoryItemPrices(){
        return webDriver.findElements(By.className("inventory_item_price"))
                .stream()
                .map(we-> Integer.parseInt(we.getText().replace(this.numberRegex,"")))
                .toList();

    }

    public int getItemTotalCents(){
        String totalText = webDriver.findElement(By.className("summary_subtotal_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public int getTaxCents(){
        String taxText = webDriver.findElement(By.className("summary_tax_label")).getText();
        return Integer.parseInt(taxText.replace(this.numberRegex,""));
    }

    public int getTotalCents(){
        String totalText = webDriver.findElement(By.className("summary_total_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public CheckoutStepOnePage cancelBackToCheckoutStepOne(){
        webDriver.findElement(By.id("cancel")).click();
        return new CheckoutStepOnePage(webDriver);
    }

    public CheckoutComplete finishToCheckoutComplete(){

        webDriver.findElement(By.id("finish")).click();
        return new CheckoutComplete(webDriver);
    }
}
