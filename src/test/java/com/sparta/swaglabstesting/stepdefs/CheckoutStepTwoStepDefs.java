package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.CheckoutStepTwoPage;
import com.sparta.swaglabstesting.pom.InventoryPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepTwoStepDefs {
    private WebDriver webDriver;
    private InventoryPage inventoryPage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    @And("I have brought the ${double} Bike Light")
    public void iHaveBroughtThe$BikeLight(int arg0, int arg1) {
    }

    @And("I have navigated to the Checkout Step Two Page")
    public void iHaveNavigatedToTheCheckoutStepTwoPage() {
        this.checkoutStepTwoPage = this.inventoryPage.goToCart()
                .goToCheckoutStepOne()
                .enterFirstName("Foo")
                .enterLastName("Bar")
                .enterPostCode("CCSS DDSS")
                .clickContinueSuccessful();
    }

    @Then("I should have an item total of thirty nine ninety eight")
    public void iShouldHaveAnItemTotalOfThirtyNineNinetyEight() {
        System.out.println(this.checkoutStepTwoPage.getItemTotalCents());
        Assertions.assertEquals(3998, this.checkoutStepTwoPage.getItemTotalCents());

    }

    @Given("I have brought the Backpack")
    public void iHaveBroughtTheBackpack() {
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        this.webDriver = new ChromeDriver();
        this.inventoryPage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .addOrRemoveProductFromCart(0);
    }

    @And("I have brought the Bike Light")
    public void iHaveBroughtTheBikeLight() {
        this.inventoryPage = this.inventoryPage.addOrRemoveProductFromCart(1);
    }
}
