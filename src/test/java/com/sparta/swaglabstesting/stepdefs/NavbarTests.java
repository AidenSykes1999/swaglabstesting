package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.NavbarPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavbarTests {

    private WebDriver webDriver;
    //private LoginPage login;
    private NavbarPage navbar;

    // Begin Selenium
    @Before("@navbar")
    public void setup(){
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        //login = new LoginPage(webDriver);
        navbar = new NavbarPage(webDriver);
    }

    @After("@navbar")
    public void tearDown() {
        webDriver.quit();
    }

    // Begin BDD
    @Given("I have opened the web browser")
    public void openBrowser(){
        webDriver = new ChromeDriver();
    }

    @When("I go to the inventory page")
    public void iGoToTheInventoryPage() {

        // TODO
        // Requires login to work correctly


    }

    @And("The navigation sidebar should exist")
    public boolean theNavigationSidebarShouldExist() {
        if (navbar.getNavIcon() != null ) {
            return true;
        } else return false;

    }

    @Then("I click on the navbar icon")
    public void iClickOnTheNavbarIcon() {
        navbar.navOpen();
    }

    @And("I click on {string}")
    public void iClickOn(String option) {
        switch (option) {
            case "All Items": navbar.inventoryOption();
            case "About": navbar.aboutOption();
            case "Logout": navbar.logoutOption();
            case "Reset App State": navbar.resetOption();
        }
    }

    @Then("I should be taken to {string}")
    public String iShouldBeTakenTo(String result) {
        return navbar.getCurrentUrl();
    }


}
