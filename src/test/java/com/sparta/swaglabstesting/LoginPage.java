package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //locator for username
    By username = By.id("user-name");
    //locator for password
    By password = By.id("password");
    //locator for login button
    By loginButton = By.id("login-button");
    //locator for error message
    By errorMessage = By.className("error");
    //method to enter username
    public WebDriver enterUsername(String userName){
        webDriver.findElement(username).sendKeys(userName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
    //method to enter password
    public WebDriver enterPassword(String pass){
        webDriver.findElement(password).sendKeys(pass);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
    //method to click login button
    public void clickLoginButton(){
        webDriver.findElement(loginButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  
    //method to see if login page is opened
    public boolean isLoginPageOpen(){
        return webDriver.getCurrentUrl().contains("https://www.saucedemo.com/");
    }
    
    public InventoryPage goToInventoryPage() {

        return new InventoryPage(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
