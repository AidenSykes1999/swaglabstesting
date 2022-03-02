package com.sparta.swaglabstesting;

import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavbarTests {

    private WebDriver webDriver;
    private LoginPage login;

    @Before
    public void setup(){
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        login = new LoginPage(webDriver);
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Given("I have opened the web browser")
    public void openBrowser(){
        webDriver = new ChromeDriver();
    }

}
