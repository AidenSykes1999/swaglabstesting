package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        webDriver.get("https://www.saucedemo.com/");
        this.webDriver = webDriver;
    }

    public InventoryPage goToInventoryPage() {

        return new InventoryPage(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


}
