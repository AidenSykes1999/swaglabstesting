package com.sparta.swaglabstesting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static WebDriver webDriver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUpAll() {
        POMUtils.setDriverLocation("src/test/resources/drivers/chromedriver.exe");
        webDriver = POMUtils.setUpWebDriver();
        loginPage = new LoginPage(webDriver);
    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        POMUtils.setDriverLocation("src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = POMUtils.setUpWebDriver();
        LoginPage loginTest = new LoginPage(driver);
        System.out.println(loginTest.getCurrentUrl());
        assertTrue( true );
    }
}
