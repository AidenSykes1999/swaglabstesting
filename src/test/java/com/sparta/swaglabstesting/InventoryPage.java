package com.sparta.swaglabstesting;

import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver webDriver;

    public InventoryPage(WebDriver webDriver) {
        webDriver.get("https://news.ycombinator.com/");
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}
