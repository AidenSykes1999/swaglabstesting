package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavbarPage extends Page {

    // Locator for navbar icon button

    private By navIcon = new By.ById("react-burger-menu-btn");

    // Locator for inventory navbar option

    private By inventory = new By.ById("inventory_sidebar_link");

    // Locator for  about option

    private By about = new By.ById("about_sidebar_link");

    // Locator for  logout option

    private By logout = new By.ById("logout_sidebar_link");

    // Locator for  reset option

    private By reset = new By.ById("reset_sidebar_link");


    public NavbarPage(WebDriver webDriver) {
        super(webDriver);
        getWebDriver().get("https://www.saucedemo.com/inventory.html");
    }

    //method to open navbar

    public NavbarPage navOpen(){

        getWebDriver().findElement(navIcon).click();

        return this;
    }

    //method to open inventory

    public NavbarPage inventoryOption(){

        getWebDriver().findElement(navIcon).click();
        getWebDriver().findElement(inventory).click();

        return this;
    }

    //method to open swaglabs about page

    public NavbarPage aboutOption(){

        getWebDriver().findElement(navIcon).click();
        getWebDriver().findElement(about).click();

        return this;
    }

    //method to logout

    public NavbarPage logoutOption(){

        getWebDriver().findElement(navIcon).click();
        getWebDriver().findElement(logout).click();

        return this;
    }

    //method to reset page

    public NavbarPage resetOption(){

        getWebDriver().findElement(navIcon).click();
        getWebDriver().findElement(reset).click();

        return this;
    }

    public By getNavIcon() {
        return navIcon;
    }
}