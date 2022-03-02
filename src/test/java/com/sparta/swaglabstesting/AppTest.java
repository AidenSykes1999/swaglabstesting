package com.sparta.swaglabstesting;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class AppTest 
{

    private static WebDriver webDriver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUpAll() {
        POMUtils.setDriverLocation("src/test/resources/drivers/chromedriver.exe");
        webDriver = POMUtils.setUpWebDriver();
    }

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage(webDriver);
    }


}
