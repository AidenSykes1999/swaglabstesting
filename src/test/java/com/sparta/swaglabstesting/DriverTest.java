package com.sparta.swaglabstesting;

import com.sparta.swaglabstesting.webdrivers.WebDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManagerFactory;
import com.sparta.swaglabstesting.webdrivers.WebDriverType;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class DriverTest {
    private static WebDriverManager driverManager;
    private static WebDriver driver;


    @AfterEach
    public void tearDown() {
        driverManager.quitDriver();
    }

    @Test
    public void testURL() {
        driverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }
}
