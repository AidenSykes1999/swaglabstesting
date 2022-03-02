package com.sparta.swaglabstesting;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sparta.swaglabstesting.LoginPage;
public class LoginTests {
    private WebDriver webDriver;
    LoginPage login = new LoginPage(webDriver);
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
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
        if (login.username.toString() != null) return true;
        else return false;
    }
    @And("password box should exist")
    public boolean passwordExists(){
        if (login.password.toString() != null) return true;
        else return false;
    }
    @And("login button should exist")
    public boolean loginButtonExists(){
        if (login.loginButton.toString() != null) return true;
        else return false;
    }
    @And("I enter the standard_user")
    public void iEnterTheStandardUdrea() {
        webDriver = login.enterUsername("standard_user");
    }
    @And("I enter the problem_user")
    public void iEnterTheProblemUser() {
        webDriver = login.enterUsername("problem_user");
    }
    @And("I enter the performance_glitch_user")
    public void iEnterTheGlitchUser() {
        webDriver = login.enterUsername("performance_glitch_user");
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
        return login.getURL().contains("inventory.html");
    }
}
