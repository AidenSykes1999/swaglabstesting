package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.*;
import com.sparta.swaglabstesting.webdrivers.WebDriverManager;
import com.sparta.swaglabstesting.webdrivers.WebDriverManagerFactory;
import com.sparta.swaglabstesting.webdrivers.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepDefs {
    private WebDriver webDriver;
    private InventoryPage inventoryPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CartPage cartPage;
    private CheckoutComplete checkoutComplete;
    private WebDriverManager webDriverManager;

    @Given("I am on the checkout step one page")
    public void iAmOnTheCheckoutStepOnePage() {
        webDriverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
        webDriver = webDriverManager.getDriver();
        checkoutStepOnePage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .goToCart()
                .goToCheckoutStepOne();
    }

    @And("I enter a first name, last name and postal code")
    public void iEnterAFirstNameLastNameAndPostalCode() {
        checkoutStepOnePage = checkoutStepOnePage.enterFirstName("Tom");
        checkoutStepOnePage = checkoutStepOnePage.enterLastName("Orange");
        checkoutStepOnePage = checkoutStepOnePage.enterPostCode("B14 N956");
    }

    @When("I click on continue")
    public void iClickOnContinue() {
        checkoutStepTwoPage = checkoutStepOnePage.clickContinueSuccessful();
    }

    @Then("I should be on checkout step two")
    public void iShouldBeOnCheckoutStepTwo() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getCurrentUrl());
    }

    @And("I enter a first name of{string} last name of {string} and a postal code of {string}")
    public void iEnterAFirstNameOfLastNameOfAndAPostalCodeOf(String arg0, String arg1, String arg2) {
        checkoutStepOnePage.enterFirstName(arg0);
        checkoutStepOnePage.enterLastName(arg1);
        checkoutStepOnePage.enterPostCode(arg2);
    }

    @Then("I should be on the same page")
    public void iShouldBeOnTheSamePage() {
        Assertions.assertEquals( "https://www.saucedemo.com/checkout-step-one.html", checkoutStepOnePage.getCurrentUrl());
    }

    @When("I click on cancel")
    public void iClickOnCancel() {
        cartPage = checkoutStepOnePage.cancelBackToCart();
    }

    @Then("I should go back to the cart page")
    public void iShouldGoBackToTheCartPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html",cartPage.getCurrentUrl());
    }

    @Given("I am on the checkout step two page")
    public void iAmOnTheCheckoutStepTwoPage() {
        checkoutStepTwoPage = inventoryPage.goToCart()
                .goToCheckoutStepOne()
                .enterFirstName("Foo")
                .enterLastName("Bar")
                .enterPostCode("CCSS DDSS")
                .clickContinueSuccessful();
    }

    @Then("I should go back to the inventory page")
    public void iShouldGoBackToTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentUrl());
    }

    @Given("I have a Backpack and a Bike light in the cart")
    public void iHaveABackpackAndABikeLightInTheCart() {
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        this.webDriver = new ChromeDriver();
        this.inventoryPage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .addOrRemoveProductFromCart(0)
                .addOrRemoveProductFromCart(1);
    }

    @When("I have navigated to the Checkout Step Two Page")
    public void iHaveNavigatedToTheCheckoutStepTwoPage() {
        checkoutStepTwoPage = inventoryPage.goToCart()
                .goToCheckoutStepOne()
                .enterLastName("Bar")
                .enterPostCode("CCSS DDSS")
                .clickContinueSuccessful();
    }

    @Then("I should have an item total of thirty nine ninety eight")
    public void iShouldHaveAnItemTotalOfThirtyNineNinetyEight() {
        Assertions.assertEquals(3998, this.checkoutStepTwoPage.getItemTotalCents());
    }

    @When("I click on finish")
    public void iClickOnFinish() {
        checkoutComplete = checkoutStepTwoPage.finishToCheckoutComplete();
    }

    @Then("I should go to the checkout complete page")
    public void iShouldGoToTheCheckoutCompletePage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutComplete.getCurrentUrl());
    }

    @When("I click on cancel on the overview")
    public void iClickOnCancelOnTheOverview() {
        inventoryPage = checkoutStepTwoPage.cancelBackToInventory();
    }
}
