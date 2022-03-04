package com.sparta.swaglabstesting.stepdefs;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.webdrivers.WebDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManagerFactory;
import com.sparta.swaglabstesting.webdrivers.WebDriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    private WebDriver webDriver;
    private LoginPage login;
    private WebDriverManager driverManager;

    @Before("@login")
    public void setup(){
        driverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
    }

    @After("@login")
    public void tearDown() {
        webDriver.quit();
    }

    @Given("I have opened the browser")
    public void openBrowser(){
        webDriver = driverManager.getDriver();
    }

    @When("I open Swaglabs website")
    public void goToSwaglabs(){
        login = new LoginPage(webDriver);
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

    @And("I enter the username standard_user")
    public void iEnterTheStandardUdrea() {
        login.enterUsername("standard_user");
    }

    @And("I enter the username problem_user")
    public void iEnterTheProblemUser() {
        login.enterUsername("problem_user");
    }

    @And("I enter the username performance_glitch_user")
    public void iEnterTheGlitchUser() {
        login.enterUsername("performance_glitch_user");
    }

    @And("I enter the username locked_out_user")
    public void iEnterTheLockedOutUser() {
        login.enterUsername("locked_out_user");
    }

    @And("I enter the username ")
    public void iEnterTheEmptyUser() {
        login.enterUsername("");
    }

    @And("I enter the username test")
    public void iEnterTheTestUser() {
        login.enterUsername("test");
    }

    @And("I enter the password secret_sauce")
    public void iEnterThePasswordSecretSauce(){
        login.enterPassword("secret_sauce");
    }

    @And("I enter the password ")
    public void iEnterThePasswordEmpty(){
        login.enterPassword("");
    }

    @And("I enter the password test")
    public void iEnterThePasswordTest(){
        login.enterPassword("test");
    }

    @And("I click login button")
    public void iClickLoginButton() {
        login.clickLoginButton();
    }

    @Then("the inventory page should be displayed")
    public boolean theInventoryPageShouldBeDisplayed() {
        return login.getCurrentUrl().contains("inventory.html");
    }

    @Then("the error Epic sadface: Sorry, this user has been locked out. is displayed")
    public boolean the_error_epic_sadface_sorry_this_user_has_been_locked_out_is_displayed() {
        return login.getErrorMessage().contains("Sorry, this user has been locked out.");
    }

    @Then("the error Epic sadface: Username is required is displayed")
    public boolean the_error_epic_sadface_username_is_required_is_displayed() {
        return login.getErrorMessage().contains("Username is required");
    }

    @Then("the error Epic sadface: Password is required is displayed")
    public boolean the_error_epic_sadface_password_is_required_is_displayed() {
        return login.getErrorMessage().contains("Password is required");
    }

    @Then("the error Epic sadface: Username and password do not match any user in this service is displayed")
    public boolean the_error_epic_sadface_username_and_password_do_not_match_any_user_in_this_service_is_displayed() {
        return login.getErrorMessage().contains("Username and password do not match any user in this service");
    }

}
