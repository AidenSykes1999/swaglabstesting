package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends Page {

    private String numberRegex;

    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
        this.numberRegex = "[^0-9]";
    }

    public CartPage goToCart(){
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
        return new CartPage(getWebDriver());
    }

    public InventoryPage cancelBackToInventory(){
        getWebDriver().findElement(By.id("cancel")).click();
        return new InventoryPage(getWebDriver());
    }

    public int getTaxCents(){
        String taxText = getWebDriver().findElement(By.className("summary_tax_label")).getText();
        return Integer.parseInt(taxText.replace(this.numberRegex,""));
    }

    public int getTotalCents(){
        String totalText = getWebDriver().findElement(By.className("summary_total_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public int getItemTotalCents(){
        String totalText = getWebDriver().findElement(By.className("summary_subtotal_label")).getText();
        return Integer.parseInt(totalText.replace(this.numberRegex, ""));
    }

    public void finishToCheckoutComplete(){
        getWebDriver().findElement(By.id("finish")).click();
    }
}