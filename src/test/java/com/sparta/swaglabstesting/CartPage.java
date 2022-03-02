package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver){
        webDriver.get("https://www.saucedemo.com/cart.html");
        this.webDriver = webDriver;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void goToCheckout(){
        webDriver.findElement(By.linkText("CHECKOUT")).click();
    }

    public void continueShopping(){
        webDriver.findElement(By.linkText("CONTINUE SHOPPING")).click();
    }

    public void clickSauceLabsBikeLight(){
        webDriver.findElement(By.linkText("Sauce Labs Bike Light")).click();
    }
    public void removeSauceLabsBikeLight(){
        webDriver.findElement(By.name("remove-sauce-labs-bike-light"));
    }
    public void clickSauceLabsBackpack(){
        webDriver.findElement(By.linkText("Sauce Labs Backpack")).click();
    }
    public void removeSauceLabsBackpack(){
        webDriver.findElement(By.name("remove-sauce-labs-backpack"));
    }
    public void clickSauceLabsBoltTShirt(){
        webDriver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
    }
    public void removeSauceLabsBoltTShirt(){
        webDriver.findElement(By.name("remove-sauce-labs-bolt-t-shirt"));
    }
    public void clickSauceLabsFleeceJacket(){
        webDriver.findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
    }
    public void removeSauceLabsFleeceJacket(){
        webDriver.findElement(By.name("remove-sauce-labs-fleece-jacket"));
    }
    public void clickSauceLabsOnesie(){
        webDriver.findElement(By.linkText("Sauce Labs Onesie")).click();
    }
    public void removeSauceLabsOnesie(){
        webDriver.findElement(By.name("remove-sauce-labs-onesie"));
    }
    public void clickTestAllTheThingsTShirt(){
        webDriver.findElement(By.linkText("Sauce Labs Test.allTheThings() T-Shirt (Red)")).click();
    }
    public void removeTestAllTheThingsTShirt(){
        webDriver.findElement(By.name("remove-test.allthethings()-t-shirt-(red)"));
    }
    public void clickNavBar(){
        webDriver.findElement(By.className("bm-burger-button"));
    }

    public void checkYourCartTitleAppears(){
        webDriver.findElement(By.className("title")).getText();
    }

    public void checkCartQuantityLabelAppears(){
        webDriver.findElement(By.className("cart_quantity_label")).getText();
    }
    public void checkCartDescriptionLabelAppears(){
        webDriver.findElement(By.className("cart_desc_label")).getText();
    }




/*
    elements:
    item name
    item price value
    item price currency
     */

}
