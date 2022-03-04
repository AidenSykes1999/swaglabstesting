package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddRemoveCartStepDefs {

    private WebDriver webDriver;
    private LoginPage login;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private ProductViewPage productViewPage;

    private double price;

    @Before("@add-remove-cart")
    public void beforeScenario() {
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        login = new LoginPage(webDriver);
    }

    @After("@add-remove-cart")
    public void afterScenario() {
        webDriver.quit();
    }

    @Given("I am on the products page")
    public void iAmOnTheInventoryPage() {
        inventoryPage = login.loginGoToInventoryPage("standard_user", "secret_sauce");
    }

    @Given("I click to add or remove {string} button to the basket from the products page")
    public void iClickToAddRemoveButtonToTheBasketFromTheProductsPage(String productName) {
        int index = inventoryPage.getProductIndexFromName(productName);
        price = inventoryPage.getProductPrice(index);
        inventoryPage.addOrRemoveProductFromCart(index);
    }

    @When("I click the cart button on the products page")
    public void iClickTheCartButton() {
        cartPage = inventoryPage.goToCart();
    }

    @Then("I should be able to see the {string}")
    public void iShouldBeAbleToSeeThe(String productName) {
        int index = cartPage.getCartItemIndexFromName(productName);
        Assertions.assertNotEquals(-1, index);
    }

    @And("I should see quantity of <{int}>")
    public void aQuantityOf(int expectedQuantity) {
        Assertions.assertEquals(expectedQuantity, cartPage.getCartItemQuantity(0));
    }

    @And("I should see quantity of <{int}> for {string}")
    public void iShouldSeeQuantityOfFor(int expectedQuantity, String productName) {
        int index = cartPage.getCartItemIndexFromName(productName);
        Assertions.assertEquals(expectedQuantity, cartPage.getCartItemQuantity(index));
    }

    @And("I should see the correct price for {string}")
    public void iShouldSeeTheCorrectPriceFor(String productName) {
        int index = cartPage.getCartItemIndexFromName(productName);
        Assertions.assertEquals(price, cartPage.getCartItemPrice(index));
    }

    @And("I click remove the {string}")
    public void iClickRemoveThe(String productName) {
        int index = cartPage.getCartItemIndexFromName(productName);
        cartPage.removeItemFromCart(index);
    }

    @Then("I shouldn't see the {string} in the cart")
    public void iShouldNoLongerSeeThe(String productName) {
        Assertions.assertEquals(-1, cartPage.getCartItemIndexFromName(productName));
    }

    @And("I should see <{int}> products on the cart page")
    public void iShouldSeeProducts(int productNumber) {
        Assertions.assertEquals(2, cartPage.getCartSize());
    }

    @Given("I add a {string} to the basket from the products details page")
    public void iAddAToTheBasketFromTheProductsDetailsPage(String productName) {
        int index = inventoryPage.getProductIndexFromName(productName);
        productViewPage = inventoryPage.goToProductPageViaName(index);
        productViewPage.addRemoveProductFromCart();
    }

    @When("I click the cart button on the product details page")
    public void iClickTheCartButtonOnTheProductDetailsPage() {
        cartPage = productViewPage.goToCartPage();
    }

    @Given("I click the to a see {string} product details")
    public void iClickTheToASeeProductDetails(String productName) {
        int index = inventoryPage.getProductIndexFromName(productName);
        productViewPage = inventoryPage.goToProductPageViaName(index);
    }

    @Given("I click the add or remove button on products details page")
    public void iClickTheAddRemoveButtonOnProductsDetailsPage() {
        productViewPage.addRemoveProductFromCart();
    }

    @Then("I should see <{int}> as the cart number in the top right")
    public void iShouldSeeAsTheCartNumberInTheTopRight(int expectedCartNumber) {
        int cartNumber = inventoryPage.getTopRightCartNumber();
        Assertions.assertEquals(expectedCartNumber, cartNumber);
    }
}
