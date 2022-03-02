package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepOnePage {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");
        //login

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        webDriver.get("https://www.saucedemo.com/checkout-step-one.html");
        CheckoutStepOnePage checkoutPageOne = new CheckoutStepOnePage(webDriver);
        checkoutPageOne.goToCart();

    }
    WebDriver webDriver;
    public CheckoutStepOnePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Cart goToCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new Cart(webDriver);
    }

    public Cart cancelBackToCart(){
        webDriver.findElement(By.id("cancel")).click();
        return new Cart(webDriver);
    }

    public CheckoutStepTwoPage continueToCheckoutStepTwo(){
        webDriver.findElement(By.id("continue")).click();
        return new CheckoutStepTwoPage(webDriver);

    }

    public void enterFirstName(String firstName){
        webDriver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        webDriver.findElement(By.id("last-name")).sendKeys(lastName);

    }

    public void enterZipCode(String zipCode){
        webDriver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }
}
