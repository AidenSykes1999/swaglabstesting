package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.CheckoutStepOnePage;
import com.sparta.swaglabstesting.pom.CheckoutStepTwoPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOneStepDefs {

    private WebDriver webDriver;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;

    @Given("I have Access to Checkout Step One Page")

    public void iHaveAccessToCheckoutStepOnePage() {
        //webDriver = new ChromeDriver();
        System.out.println("Got web driver");
        checkoutStepOnePage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .goToCart()
                .goToCheckout();
    }

    @Given("I Enter a valid first name")
    public void iEnterAValidFirstName() {
        checkoutStepOnePage.enterFirstName("Tom");
    }

    @And("I enter a valid last name")
    public void iEnterAValidLastName() {
        checkoutStepOnePage.enterLastName("Orange");
    }

    @And("I enter a valid postal code")
    public void iEnterAValidPostalCode() {
        checkoutStepOnePage.enterFirstName("B14 N956");
    }

    @And("I click continue expecting success")
    public void iClickContinueExpectingSuccess() {
        checkoutStepTwoPage = checkoutStepOnePage.clickContinueSuccessful();
    }

    @Then("I should be on checkout step two")
    public void iShouldBeOnCheckoutStepTwo() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", webDriver.getCurrentUrl());
    }

    @Given("I enter a <first name>")
    public void iEnterAFirstName() {
    }

    @And("I click continue expecting failure")
    public void iClickContinueExpectingFailure() {
    }

    @Then("I should see an error message in the Checkout Step One Page")
    public void iShouldSeeAnErrorMessageInTheCheckoutStepOnePage() {
    }

    @And("I enter a  <postal code>")
    public void iEnterAPostalCode() {
    }

    @And("I enter a <last name>")
    public void iEnterALastName() {
    }
}
