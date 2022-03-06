package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends Page{
    private By navbarButton = new By.ById("react-burger-menu-btn");
    private By facebook = new By.ByClassName("social_facebook");
    private By linkedin = new By.ByClassName("social_linkedin");
    private By twitter = new By.ByClassName("social_twitter");
    private By shoppingCart = new By.ById("shopping_cart_container");
    private WebDriver webDriver;

    public CheckoutComplete(WebDriver webDriver) {
        super(webDriver);
    }

    public InventoryPage clickBackHome(){
        getWebDriver().findElement(By.id("back-to-products")).click();
        return new InventoryPage(getWebDriver());
    }

    public NavbarPage goToNavbar() {
        getWebDriver().findElement(navbarButton).click();
        return new NavbarPage(getWebDriver());
    }

    public void goToFacebook(){
        getWebDriver().findElement(facebook).click();
    }

    public void goToLinkedin(){
        getWebDriver().findElement(linkedin).click();
    }

    public void goToTwitter(){
        getWebDriver().findElement(twitter).click();
    }

    public CartPage goToCart() {
        getWebDriver().findElement(shoppingCart).click();
        return new CartPage(getWebDriver());
    }
}
