package com.sparta.swaglabstesting;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

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

    @Given("I have opened the browser")
    public void openBroser(){
        webDriver = new ChromeDriver();
    }

    @When("I open Swaglabs website")
    public void goToSwaglabs(){
        webDriver.navigate().to("https://www.saucedemo.com/");
    }

    @Then("username box should exist")
    public boolean usernameExists(){
        if (login.getUserName() != null) return true;
        else return false;
    }

    @And("password box should exist")
    public boolean passwordExists(){
        if (login.getPassword() != null) return true;
        else return false;
    }

    @And("login button should exist")
    public boolean loginButtonExists(){
        if (login.getLoginButton() != null) return true;
        else return false;
    }

    @And("I enter the standard_user")
    public void iEnterTheStandardUdrea() {
        login.enterUsername("standard_user");
    }

    @And("I enter the problem_user")
    public void iEnterTheProblemUser() {
        login.enterUsername("problem_user");
    }

    @And("I enter the performance_glitch_user")
    public void iEnterTheGlitchUser() {
        login.enterUsername("performance_glitch_user");
    }

    @And("I enter the password secret_sauce")
    public void iEnterThePasswordSecretSauce(){
        login.enterPassword("secret_sauce");
    }

    @And("I click login button")
    public void iClickLoginButton() {
        login.clickLoginButton();
    }

    @Then("the inventory page should be displayed")
    public boolean theInventoryPageShouldBeDisplayed() {
        return login.getCurrentUrl().contains("inventory.html");
    }
}
