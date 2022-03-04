package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.CartPage;
import com.sparta.swaglabstesting.pom.InventoryPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import com.sparta.swaglabstesting.webdrivers.ChromeDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManagerFactory;
import com.sparta.swaglabstesting.webdrivers.WebDriverType;
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
    private WebDriverManager webDriverManager;

    @Before("@add-remove-cart")
    public void beforeScenario() {
        webDriverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
        webDriver = webDriverManager.getDriver();
        login = new LoginPage(webDriver);
    }

    @After("@add-remove-cart")
    public void afterScenario() {
        webDriver.quit();
    }

    @Given("I am on the inventory page")
    public void iAmOnTheInventoryPage() {
        inventoryPage = login.loginGoToInventoryPage("standard_user", "secret_sauce");
    }

    @Given("I add a {string} to the basket")
    public void iAddAToTheBasket(String productName) {
        int index = inventoryPage.getProductIndexFromName(productName);
        inventoryPage.addOrRemoveProductFromCart(index);
    }

    @When("I click the cart button")
    public void iClickTheCartButton() {
        cartPage = inventoryPage.goToCart();
    }

    @Then("I should be able to see {string}")
    public void iShouldBeAbleToSeeThe(String expectedName) {
        int index = cartPage.getCartItemIndexFromName(expectedName);
        Assertions.assertNotEquals(-1, index);
    }

    @And("A quantity of <{int}>")
    public void aQuantityOf(int expectedQuantity) {
        Assertions.assertEquals(expectedQuantity, cartPage.getCartItemQuantity(0));
    }

}
