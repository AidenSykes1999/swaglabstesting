package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    private WebDriver webDriver;

    public Page (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
