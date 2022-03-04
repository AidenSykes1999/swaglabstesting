package com.sparta.swaglabstesting;

import com.sparta.swaglabstesting.pom.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class NavigationLinkTest {

    private static WebDriver webDriver;

    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;
    private static ProductViewPage productViewPage;
    private static CartPage cartPage;

    @BeforeAll
    public static void setUpAll() {
        POMUtils.setDriverLocation("src/test/resources/drivers/chromedriver.exe");
        webDriver = POMUtils.setUpWebDriver();
        loginPage = new LoginPage(webDriver);
    }

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage(webDriver);
    }

    @AfterAll
    public static void tearDownAll() {
        webDriver.quit();
    }

    @Test
    public void navigateToInventoryTest() {
        inventoryPage = loginPage.loginGoToInventoryPage("standard_user", "secret_sauce");
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentUrl());
    }

    @Test
    public void navigateToCartTest() {
        inventoryPage = loginPage.loginGoToInventoryPage("standard_user", "secret_sauce");
        cartPage = inventoryPage.goToCart();
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPage.getCurrentUrl());
    }

    @Test
    public void navigateToProductViewPageViaTitleTest() {
        inventoryPage = loginPage.loginGoToInventoryPage("standard_user", "secret_sauce");
        productViewPage = inventoryPage.goToProductPageViaName(3);
        Assertions.assertTrue(productViewPage.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item.html?id="));
    }

    @Test
    public void navigateToProductViewPageViaImageTest() {
        inventoryPage = loginPage.loginGoToInventoryPage("standard_user", "secret_sauce");
        productViewPage = inventoryPage.goToProductPageViaImage(3);
        Assertions.assertTrue(productViewPage.getCurrentUrl().contains("https://www.saucedemo.com/inventory-item.html?id="));
    }

    @Test
    public void navigateToProductViewPageThenBack() {
        inventoryPage = loginPage.loginGoToInventoryPage("standard_user", "secret_sauce");
        productViewPage = inventoryPage.goToProductPageViaName(3);
        inventoryPage = productViewPage.goToInventoryPage();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentUrl());
    }

}
