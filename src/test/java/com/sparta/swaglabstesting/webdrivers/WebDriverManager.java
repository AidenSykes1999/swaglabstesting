package com.sparta.swaglabstesting.webdrivers;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
    protected WebDriver webDriver;

    // Create a web driver
    public abstract void createDriver();

    // Quit a web driver
    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    // Return a web driver
    public WebDriver getDriver() {
        if (webDriver == null) {
            createDriver();
        }
        return webDriver;
    }
}
