package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    //locator for username
    private By username = new By.ById("user-name");
    //locator for password
    private By password = new By.ById("password");
    //locator for login button
    private By loginButton = new By.ById("login-button");
    //locator for error message
    private By errorMessage = new By.ByClassName("error");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        getWebDriver().get("https://www.saucedemo.com/");
    }
    //method to enter username
    public LoginPage enterUsername(String userName){

        getWebDriver().findElement(username).sendKeys(userName);

        return this;
    }

    //method to enter password
    public LoginPage enterPassword(String pass){

        getWebDriver().findElement(password).sendKeys(pass);

        return this;
    }

    //method to click login button
    public void clickLoginButton(){

        getWebDriver().findElement(loginButton).click();

    }

    public InventoryPage loginGoToInventoryPage(String userName, String password) {

        enterUsername(userName).enterPassword(password);
        getWebDriver().findElement(loginButton).click();

        return new InventoryPage(getWebDriver());
    }
    public InventoryPage loginGoToInventoryPage() {
        return new InventoryPage(getWebDriver());
    }

    //method to see if login page is opened
    public boolean isLoginPageOpen(){
        return getWebDriver().getCurrentUrl().contains("https://www.saucedemo.com/");
    }

    public String getUserName()
    {
        return username.toString();
    }

    public String getPassword() {
        return password.toString();
    }

    public By getLoginButton() {
        return loginButton;
    }
    //method to return the error message
    public String getErrorMessage(){
        return getWebDriver().findElement(By.className("error")).getText();
    }
}
