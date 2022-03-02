package com.sparta.swaglabstesting;

import static org.junit.Assert.assertTrue;


import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
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


    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(loginPage.getCurrentUrl());
        assertTrue( true );
    }

}
