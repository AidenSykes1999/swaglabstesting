package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Page {

    public CartPage(WebDriver webDriver){
        super(webDriver);
    }

    public CheckoutStepOnePage goToCheckout(){
        getWebDriver().findElement(By.linkText("CHECKOUT")).click();
        return new CheckoutStepOnePage(getWebDriver());
    }

    public void continueShopping(){
        getWebDriver().findElement(By.linkText("CONTINUE SHOPPING")).click();
    }

    public void clickSauceLabsBikeLight(){
        getWebDriver().findElement(By.linkText("Sauce Labs Bike Light")).click();
    }

    public void removeSauceLabsBikeLight(){
        getWebDriver().findElement(By.name("remove-sauce-labs-bike-light"));
    }

    public void clickSauceLabsBackpack(){
        getWebDriver().findElement(By.linkText("Sauce Labs Backpack")).click();
    }

    public void removeSauceLabsBackpack(){
        getWebDriver().findElement(By.name("remove-sauce-labs-backpack"));
    }

    public void clickSauceLabsBoltTShirt(){
        getWebDriver().findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
    }

    public void removeSauceLabsBoltTShirt(){
        getWebDriver().findElement(By.name("remove-sauce-labs-bolt-t-shirt"));
    }

    public void clickSauceLabsFleeceJacket(){
        getWebDriver().findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
    }

    public void removeSauceLabsFleeceJacket(){
        getWebDriver().findElement(By.name("remove-sauce-labs-fleece-jacket"));
    }

    public void clickSauceLabsOnesie(){
        getWebDriver().findElement(By.linkText("Sauce Labs Onesie")).click();
    }

    public void removeSauceLabsOnesie(){
        getWebDriver().findElement(By.name("remove-sauce-labs-onesie"));
    }

    public void clickTestAllTheThingsTShirt(){
        getWebDriver().findElement(By.linkText("Sauce Labs Test.allTheThings() T-Shirt (Red)")).click();
    }
    public void removeTestAllTheThingsTShirt(){
        getWebDriver().findElement(By.name("remove-test.allthethings()-t-shirt-(red)"));
    }
    public void clickNavBar(){
        getWebDriver().findElement(By.className("bm-burger-button"));
    }

    public void checkYourCartTitleAppears(){
        getWebDriver().findElement(By.className("title")).getText();
    }

    public void checkCartQuantityLabelAppears(){
        getWebDriver().findElement(By.className("cart_quantity_label")).getText();
    }
    public void checkCartDescriptionLabelAppears(){
        getWebDriver().findElement(By.className("cart_desc_label")).getText();
    }




/*
    elements:
    item name
    item price value
    item price currency
     */

}
