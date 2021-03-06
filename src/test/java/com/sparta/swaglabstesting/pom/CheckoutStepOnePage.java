package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends Page {
    private By navbarButton = new By.ById("react-burger-menu-btn");
    private By facebook = new By.ByClassName("social_facebook");
    private By linkedin = new By.ByClassName("social_linkedin");
    private By twitter = new By.ByClassName("social_twitter");

    public CheckoutStepOnePage(WebDriver webDriver){
        super(webDriver);
    }

    public void showNavBar(){
        getWebDriver().findElement(By.id("react-burger-menu-btn")).click();
    }

    public CartPage goToCart(){
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
        return new CartPage(getWebDriver());
    }

    public CartPage cancelBackToCart(){
        getWebDriver().findElement(By.id("cancel")).click();
        return new CartPage(getWebDriver());
    }

    public CheckoutStepTwoPage continueToCheckoutStepTwo(){
        getWebDriver().findElement(By.id("continue")).click();
        return new CheckoutStepTwoPage(getWebDriver());

    }

    public CheckoutStepOnePage enterFirstName(String firstName){

        if(firstName != null) getWebDriver().findElement(By.id("first-name")).sendKeys(firstName);
        return this;
    }

    public CheckoutStepOnePage enterLastName(String lastName){
        if(lastName != null) getWebDriver().findElement(By.id("last-name")).sendKeys(lastName);
        return this;
    }

    public CheckoutStepOnePage enterPostCode(String postCode){
        if (postCode != null) getWebDriver().findElement(By.id("postal-code")).sendKeys(postCode);
        return this;
    }

    public CheckoutStepTwoPage clickContinueSuccessful(){
        getWebDriver().findElement(By.id("continue")).click();
        return new CheckoutStepTwoPage(getWebDriver());
    }

    public CheckoutStepOnePage clickContinueFailed(){
        getWebDriver().findElement(By.id("continue")).click();
        return new CheckoutStepOnePage(getWebDriver());
    }

    public String getErrorText(){
        return getWebDriver().findElement(By.className("error-message-container")).getText();
    }

    public CheckoutStepOnePage clickErrorButton(){
        getWebDriver().findElement(By.className("error-button")).click();
        return this;
    }

    public CheckoutStepOnePage enterZipCode(String zipCode){
        getWebDriver().findElement(By.id("postal-code")).sendKeys(zipCode);
        return this;
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

}
