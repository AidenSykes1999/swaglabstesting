package com.sparta.swaglabstesting;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        webDriver.get("https://www.saucedemo.com/");
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


}
