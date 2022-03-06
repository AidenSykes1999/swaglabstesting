package com.sparta.swaglabstesting.stepdefs;

import com.sparta.swaglabstesting.pom.*;
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

import java.time.Duration;
import java.util.Random;

public class NavigationStepDefs {
    private WebDriver webDriver;
    private CartPage cartPage;
    private InventoryPage inventoryPage;
    private WebDriverManager webDriverManager;
    private LoginPage login;
    private ProductViewPage productViewPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutComplete checkoutComplete;
    private NavbarPage navbarPage;

    @Before("@navigation")
    public void beforeScenario(){
        webDriverManager = WebDriverManagerFactory.getDriverManager(WebDriverType.CHROME);
        webDriver = webDriverManager.getDriver();
        login = new LoginPage(webDriver);inventoryPage = login.loginGoToInventoryPage("standard_user", "secret_sauce");

    }

    @After("@navigation")
    public void afterScenario(){
        webDriver.quit();
    }

    @Given("I navigate to the products page")
    public void iNavigateToTheProductsPage(){
        inventoryPage = inventoryPage;
    }

    @Given("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        cartPage = inventoryPage
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
        checkoutStepOnePage = cartPage.goToCheckoutStepOne();
        
    }

    @Then("I am on the checkout your information page")
    public void iAmOnTheCheckoutYourInformationPage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkoutStepOnePage.getCurrentUrl());
    }

    @Given("I navigate to the checkout your information page")
    public void iNavigateToTheCheckoutYourInformationPage() {
        checkoutStepOnePage = inventoryPage.goToCart().goToCheckoutStepOne();
    }

    @When("I click cancel from your information")
    public void iClickCancel() {
        cartPage = checkoutStepOnePage.cancelBackToCart();
    }

    @Then("I am on the cart page")
    public void iAmOnTheCartPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPage.getCurrentUrl());
    }

    @Given("I have entered my information")
    public void iHaveEnteredMyInformation() {
        checkoutStepOnePage = checkoutStepOnePage.enterFirstName("admin");
        checkoutStepOnePage = checkoutStepOnePage.enterLastName("guy");
        checkoutStepOnePage = checkoutStepOnePage.enterPostCode("root");
    }

    @When("I click continue")
    public void iClickContinue() {
        checkoutStepTwoPage = checkoutStepOnePage.clickContinueSuccessful();
    }

    @Then("I am on the checkout overview page")
    public void iAmOnTheCheckoutOverviewPage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getCurrentUrl());

    }

    @Given("I navigate to the checkout overview page")
    public void iNavigateToTheCheckoutOverviewPage() {
        checkoutStepTwoPage = inventoryPage.goToCart().goToCheckoutStepOne()
                .enterFirstName("admin")
                .enterLastName("guy")
                .enterPostCode("root")
                .clickContinueSuccessful();
    }

    @When("I click on cancel from overview")
    public void iClickOnCancelFromOverview() {
        inventoryPage = checkoutStepTwoPage.cancelBackToInventory();
    }


    @Then("I go back to the inventory page")
    public void iGoBackToTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentUrl());
    }


    @When("I click on finish checkout")
    public void iClickOnFinishCheckout() {
        checkoutComplete = checkoutStepTwoPage.finishToCheckoutComplete();
    }


    @Then("I go to the checkout complete page")
    public void iGoToTheCheckoutCompletePage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutComplete.getCurrentUrl());
    }

    @Given("I navigate to the checkout finish page")
    public void iNavigateToTheCheckoutFinishPage() {
        checkoutComplete = inventoryPage.goToCart().goToCheckoutStepOne()
                .enterFirstName("admin")
                .enterLastName("guy")
                .enterPostCode("root")
                .clickContinueSuccessful()
                .finishToCheckoutComplete();
    }

    @When("I click on Back Home")
    public void iClickOnBackHome() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        inventoryPage = checkoutComplete.clickBackHome();
    }

    @When("I click the cart page burger icon")
    public void iClickTheCartPageBurgerIcon() {
        navbarPage = cartPage.goToNavbar();
    }

    @When("I click the products page burger icon")
    public void iClickTheInventoryPageBurgerIcon() {
        navbarPage = inventoryPage.goToNavbar();
    }

    @When("I click the checkout finish page burger icon")
    public void iClickTheCheckoutFinishPageBurgerIcon() {
        navbarPage = checkoutComplete.goToNavbar();
    }

    @When("I click the checkout overview page burger icon")
    public void iClickTheCheckoutOverviewPageBurgerIcon() {
        navbarPage = checkoutStepTwoPage.goToNavbar();
    }

    @When("I click the checkout your information page burger icon")
    public void iClickTheCheckoutYourInformationPageBurgerIcon() {
        navbarPage = checkoutStepOnePage.goToNavbar();
    }

    @When("I click the random product page burger icon")
    public void iClickTheRandomProductPageBurgerIcon() {
        navbarPage = productViewPage.goToNavbar();
    }

    @And("I click logout")
    public void iClickLogout() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        login = navbarPage.logOut();
    }

    @Then("I go back to the login page")
    public void iGoBackToTheLoginPage() {
        Assertions.assertEquals("https://www.saucedemo.com/", login.getCurrentUrl());
    }

    @And("I click about")
    public void iClickAbout() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        navbarPage.about();
    }

    @Then("I go to the sauce labs website")
    public void iGoToTheSauceLabsWebsite() {
        Assertions.assertEquals("https://saucelabs.com/", navbarPage.getCurrentUrl());
    }

    @And("I click all items")
    public void iClickAllItems() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        navbarPage.allItems();
    }

    @When("I click the cart page facebook icon")
    public void iClickTheCartPageFacebookIcon() {
        cartPage.goToFacebook();
    }
    @When("I click the checkout finish page facebook icon")
    public void iClickTheCheckoutFinishPageFacebookIcon() {
        checkoutComplete.goToFacebook();
    }
    @When("I click the products page facebook icon")
    public void iClickTheProductsPageFacebookIcon() {
        inventoryPage.goToFacebook();
    }
    @When("I click the checkout overview page facebook icon")
    public void iClickTheCheckoutOverviewPageFacebookIcon() {
        checkoutStepTwoPage.goToFacebook();
    }
    @When("I click the checkout your information page facebook icon")
    public void iClickTheCheckoutYourInformationPageFacebookIcon() {
        checkoutStepOnePage.goToFacebook();
    }
    @When("I click the random product page facebook icon")
    public void iClickOnTheRandomProductPageFacebookIcon() {
        productViewPage.goToFacebook();
    }

    @Then("I go to the sauce labs facebook")
    public void iGoToTheSauceLabsFacebook() {
        // Switch to new window opened
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertEquals("https://www.facebook.com/saucelabs", webDriver.getCurrentUrl());
    }

    @When("I click the cart page twitter icon")
    public void iClickTheCartPageTwitterIcon() {
        cartPage.goToTwitter();
    }
    @When("I click the checkout finish page twitter icon")
    public void iClickTheCheckoutFinishPageTwitterIcon() {
        checkoutComplete.goToTwitter();
    }
    @When("I click the products page twitter icon")
    public void iClickTheProductsPageTwitterIcon() {
        inventoryPage.goToTwitter();
    }
    @When("I click the checkout overview page twitter icon")
    public void iClickTheCheckoutOverviewPageTwitterIcon() {
        checkoutStepTwoPage.goToTwitter();
    }
    @When("I click the checkout your information page twitter icon")
    public void iClickTheCheckoutYourInformationPageTwitterIcon() {
        checkoutStepOnePage.goToTwitter();
    }
    @When("I click the random product page twitter icon")
    public void iClickOnTheRandomProductPageTwitterIcon() {
        productViewPage.goToTwitter();
    }

    @Then("I go to the sauce labs twitter")
    public void iGoToTheSauceLabsTwitter() {
        // Switch to new window opened
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertEquals("https://twitter.com/saucelabs", webDriver.getCurrentUrl());
    }

    @When("I click the cart page linkedin icon")
    public void iClickTheCartPageLinkedinIcon() {
        cartPage.goToLinkedin();
    }
    @When("I click the checkout finish page linkedin icon")
    public void iClickTheCheckoutFinishPageLinkedinIcon() {
        checkoutComplete.goToLinkedin();
    }
    @When("I click the products page linkedin icon")
    public void iClickTheProductsPageLinkedinIcon() {
        inventoryPage.goToLinkedin();
    }
    @When("I click the checkout overview page linkedin icon")
    public void iClickTheCheckoutOverviewPageLinkedinIcon() {
        checkoutStepTwoPage.goToLinkedin();
    }
    @When("I click the checkout your information page linkedin icon")
    public void iClickTheCheckoutYourInformationPageLinkedinIcon() {
        checkoutStepOnePage.goToLinkedin();
    }

    @When("I click the random product page linkedin icon")
    public void iClickOnTheRandomProductPageLinkedinIcon() {
       productViewPage.goToLinkedin();
    }

    @Then("I go to the sauce labs linkedin")
    public void iGoToTheSauceLabsLinkedin() {
        // Switch to new window opened
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        // After the first few visits, linkedin takes you to an authwall page and the link changes every time
        // This commented out code will work until the authwall kicks in
//        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", webDriver.getCurrentUrl());

    }

    @When("I click on the products page cart icon")
    public void iClickOnTheProductsPageCartIcon() {
        cartPage = inventoryPage.goToCart();
    }
    @When("I click on the cart page cart icon")
    public void iClickOnTheCartPageCartIcon() {
        cartPage = cartPage.goToCart();
    }
    @When("I click on the checkout finish page cart icon")
    public void iClickOnTheCheckoutFinishPageCartIcon() {
        cartPage = checkoutComplete.goToCart();
    }
    @When("I click on the checkout overview page cart icon")
    public void iClickOnTheCheckoutOverviewPageCartIcon() {
        cartPage = checkoutStepTwoPage.goToCart();
    }
    @When("I click on the checkout your information page cart icon")
    public void iClickOnTheCheckoutYourInformationPageCartIcon() {
        cartPage = checkoutStepOnePage.goToCart();
    }

    @When("I click on the random product page cart icon")
    public void iClickOnTheRandomProductPageCartIcon() {
        cartPage = productViewPage.goToCartPage();
    }

    @Given("I navigate to the random product page")
    public void iNavigateToARandomProductPage() {
        Random r = new Random();
        productViewPage = inventoryPage.goToProductPageViaName(r.nextInt(6));
    }

    @When("I click back to products")
    public void iClickBackToProducts() {
        inventoryPage = productViewPage.goBackToInventory();
    }
}
