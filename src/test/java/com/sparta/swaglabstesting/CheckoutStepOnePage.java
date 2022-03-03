package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

public class CheckoutStepOnePage {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://www.saucedemo.com");
//        //login
//
//        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
//        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
//        webDriver.findElement(By.id("login-button")).click();
//        webDriver.get("https://www.saucedemo.com/checkout-step-one.html");
//        CheckoutStepOnePage checkoutPageOne = new CheckoutStepOnePage(webDriver);
//        checkoutPageOne.goToCart();

    }

    WebDriver webDriver;
    public CheckoutStepOnePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void showNavBar(){
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public Cart goToCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new Cart(webDriver);
    }

    public void enterFirstName(String firstName){
        webDriver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        webDriver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    public void enterPostCode(String postCode){
        webDriver.findElement(By.id("postal-code")).sendKeys(postCode);
    }

    public void clickCancel(){
        webDriver.findElement(By.id("cancel")).click();
    }

    public CheckoutStepTwoPage clickContinueSuccessful(){
        webDriver.findElement(By.id("continue")).click();
        return new CheckoutStepTwoPage(webDriver);
    }

    public CheckoutStepOnePage clickContinueFailed(){
        webDriver.findElement(By.id("continue")).click();
        return new CheckoutStepOnePage(webDriver);
    }

    public String getErrorText(){
        return webDriver.findElement(By.className("error-message-container")).getText();
    }

    public void clickErrorButton(){
        webDriver.findElement(By.className("error-button")).click();
    }

    public CheckoutStepTwoPage continueToCheckoutStepTwo(){
        webDriver.findElement(By.id("continue")).click();
        return new CheckoutStepTwoPage(webDriver);

    }






}
