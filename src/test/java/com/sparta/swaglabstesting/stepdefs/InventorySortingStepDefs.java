package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.InventoryPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
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

    @Before("@inventory")
    public void beforeScenario() {
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        login = new LoginPage(webDriver);
    }

    @After("@inventory")
    public void afterScenario() {
        webDriver.quit();
    }

    @Given("I navigated to the inventory page")
    public void iAmOnTheInventoryPage(){
        inventoryPage = login.loginGoToInventoryPage("standard_user", "secret_sauce");
    }

    @Given("If I change the products to be sorted from {string}")
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

        int productNumber = inventoryPage.getProductCount();
        boolean ordered = true;

        double previous = 0;

        for (int i = 0; i < productNumber ; i++) {

            double price = inventoryPage.getProductPrice(i);

            if (price < previous) {
                ordered = false;
            }

            previous = price;
        }

        Assertions.assertTrue(ordered);

    }

    @Then("I should see the products sorted highest to lowest price")
    public void iShouldSeeTheProductsSortedHighestToLowestPrice() {

        int productNumber = inventoryPage.getProductCount();
        boolean ordered = true;

        double previous = inventoryPage.getProductPrice(0);

        for (int i = 0; i < productNumber ; i++) {

            double price = inventoryPage.getProductPrice(i);

            if (previous >= price) {
                ordered = false;
            }

            previous = price;
        }

        Assertions.assertTrue(ordered);

    }
}
