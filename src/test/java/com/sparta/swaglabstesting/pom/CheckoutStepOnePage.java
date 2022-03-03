package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;


public class CheckoutStepOnePage extends Page {

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
        getWebDriver().findElement(By.id("first-name")).sendKeys(firstName);
        return this;
    }

    public CheckoutStepOnePage enterLastName(String lastName){
        getWebDriver().findElement(By.id("last-name")).sendKeys(lastName);
        return this;
    }

    public CheckoutStepOnePage enterPostCode(String postCode){
        getWebDriver().findElement(By.id("postal-code")).sendKeys(postCode);
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
}
