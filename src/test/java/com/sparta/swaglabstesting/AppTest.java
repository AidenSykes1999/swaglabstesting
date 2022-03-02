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
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        loginPage = new LoginPage(webDriver);
    }

    @BeforeEach
    public void setUp() {
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(loginPage.getCurrentUrl());
        assertTrue( true );
    }
}
