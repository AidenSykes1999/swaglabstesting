package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.CartPage;
import com.sparta.swaglabstesting.pom.InventoryPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class NavigationStepDefs {
    WebDriver webDriver;
    CartPage cartPage;
    InventoryPage inventoryPage;


    @Given("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        cartPage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .goToCart();
    }

    @When("I click continue shopping")
    public void iClickContinueShopping() {
        this.inventoryPage =  cartPage.goToInventory();
    }

    @Then("I arrive at the products page")
    public void iArriveAtTheProductsPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", this.inventoryPage.getCurrentUrl());

    }



    @When("I click checkout")
    public void iClickCheckout() {
        
        
    }

    @Then("I am on the checkout your information page")
    public void iAmOnTheCheckoutYourInformationPage() {
        
    }

    @Given("I navigate to the checkout your information page")
    public void iNavigateToTheCheckoutYourInformationPage() {
    }

    @When("I click cancel")
    public void iClickCancel() {
    }

    @Then("I am on the cart page")
    public void iAmOnTheCartPage() {
    }
}