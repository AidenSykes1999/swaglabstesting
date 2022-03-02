package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepOnePage extends Page {

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

    public CheckoutStepOnePage(WebDriver webDriver){
        super(webDriver);
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

    public void enterFirstName(String firstName){
        getWebDriver().findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getWebDriver().findElement(By.id("last-name")).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        getWebDriver().findElement(By.id("postal-code")).sendKeys(zipCode);
    }
}
