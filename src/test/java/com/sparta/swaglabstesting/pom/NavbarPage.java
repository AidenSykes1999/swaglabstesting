package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavbarPage extends Page {

    // Locator for inventory navbar option

    private By inventory = new By.ById("inventory_sidebar_link");

    // Locator for  about option

    private By about = new By.ById("about_sidebar_link");

    // Locator for  logout option

    private By logout = new By.ById("logout_sidebar_link");



    public NavbarPage(WebDriver webDriver) {
        super(webDriver);
    }



    public NavbarPage allItems(){
        getWebDriver().findElement(inventory).click();
        return this;
    }

    public NavbarPage about(){
        getWebDriver().findElement(about).click();
        return new NavbarPage(getWebDriver());
    }

    public LoginPage logOut(){
        getWebDriver().findElement(logout).click();
        return new LoginPage(getWebDriver());
    }
}
