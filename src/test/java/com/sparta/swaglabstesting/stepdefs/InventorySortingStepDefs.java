package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.InventoryPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import com.sparta.swaglabstesting.webdrivers.WebDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManagerFactory;
import com.sparta.swaglabstesting.webdrivers.WebDriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class InventorySortingStepDefs {

    private WebDriver webDriver;
    private LoginPage login;
    private InventoryPage inventoryPage;
    private WebDriverManager webDriverManager;

    @Before("@inventory-sorting")
    public void beforeScenario() {
        webDriverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
        webDriver = webDriverManager.getDriver();
        login = new LoginPage(webDriver);
    }

    @After("@inventory-sorting")
    public void afterScenario() {
        webDriver.quit();
    }

    @Given("I navigated to the inventory page")
    public void iAmOnTheInventoryPage(){
        inventoryPage = login.loginGoToInventoryPage("standard_user", "secret_sauce");
    }

    @Given("I change the products to be sorted from {string}")
    public void iChangeTheProductsToBeSortedFrom(String option) {
        String choice = switch (option) {
            case "a to z" -> "az";
            case "z to a" -> "za";
            case "low to high" -> "lohi";
            case "high to low" -> "hilo";
            default -> null;
        };

        inventoryPage.sortBy(choice);

    }

    @Then("I should see the products sorted lowest to highest price")
    public void theProductsShouldBeSortedLowestToHighestPrice() {
        Assertions.assertTrue(inventoryPage.isProductsSortedLowestToHighest());
    }

    @Then("I should see the products sorted highest to lowest price")
    public void iShouldSeeTheProductsSortedHighestToLowestPrice() {
        Assertions.assertTrue(inventoryPage.isProductsSortedHighestToLowest());
    }

    @Then("I should see the products sorted alphabetically")
    public void iShouldSeeTheProductsSortedAlphabetically() {
        Assertions.assertTrue(inventoryPage.isProductsSortedAlphabetically());
    }

    @Then("I should see the products sorted reverse alphabetically")
    public void iShouldSeeTheProductsSortedReverseAlphabetically() {
        Assertions.assertTrue(inventoryPage.isProductsSortedReverseAlphabetically());
    }

}
