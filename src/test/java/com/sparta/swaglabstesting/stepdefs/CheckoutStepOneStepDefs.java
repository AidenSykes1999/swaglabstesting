package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.CheckoutStepOnePage;
import com.sparta.swaglabstesting.pom.CheckoutStepTwoPage;
import com.sparta.swaglabstesting.pom.LoginPage;
import com.sparta.swaglabstesting.pom.POMUtils;
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
        POMUtils.setDriverLocation();
        webDriver = POMUtils.setUpWebDriver();
        checkoutStepOnePage = new LoginPage(webDriver)
                .loginGoToInventoryPage("standard_user", "secret_sauce")
                .goToCart()
                .goToCheckoutStepOne();
    }

    @Given("I Enter a valid first name")
    public void iEnterAValidFirstName() {
        checkoutStepOnePage = checkoutStepOnePage.enterFirstName("Tom");
    }

    @And("I enter a valid last name")
    public void iEnterAValidLastName() {

        checkoutStepOnePage = checkoutStepOnePage.enterLastName("Orange");
    }

    @And("I enter a valid postal code")
    public void iEnterAValidPostalCode() {
        checkoutStepOnePage = checkoutStepOnePage.enterPostCode("B14 N956");
    }

    @And("I click continue expecting success")
    public void iClickContinueExpectingSuccess() {
        checkoutStepTwoPage = checkoutStepOnePage.clickContinueSuccessful();
    }

    @Then("I should be on checkout step two")
    public void iShouldBeOnCheckoutStepTwo() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getCurrentUrl());
    }

    @And("I click continue expecting failure")
    public void iClickContinueExpectingFailure() {
        checkoutStepOnePage.clickContinueFailed();
    }

    @Then("I should see an error message in the Checkout Step One Page")
    public void iShouldSeeAnErrorMessageInTheCheckoutStepOnePage() {

    }


    @And("I enter a first name {string} on the page")
    public void iEnterAFirstNameOnThePage(String arg0) {
        checkoutStepOnePage.enterFirstName(arg0);
    }

    @And("I enter a last name of {string} on the page")
    public void iEnterALastNameOfOnThePage(String arg0) {
        checkoutStepOnePage.enterLastName(arg0);
    }

    @And("I enter a post code of {string} on the page")
    public void iEnterAPostCodeOfOnThePage(String arg0) {
        checkoutStepOnePage.enterPostCode(arg0);

    }

    @Then("I should be on the same page")
    public void iShouldBeOnTheSamePage() {
        Assertions.assertEquals( "https://www.saucedemo.com/checkout-step-one.html", checkoutStepOnePage.getCurrentUrl());
    }
}
