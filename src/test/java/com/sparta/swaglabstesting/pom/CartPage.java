package com.sparta.swaglabstesting.pom;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends Page {
    private By continueShoppingButton = new By.ById("continue-shopping");
    private By checkoutButton = new By.ById("checkout");
    private By cartList = new By.ByClassName("cart_list");
    private By navbarButton = new By.ById("react-burger-menu-btn");
    private By facebook = new By.ByClassName("social_facebook");
    private By linkedin = new By.ByClassName("social_linkedin");
    private By twitter = new By.ByClassName("social_twitter");
    private By shoppingCart = new By.ById("shopping_cart_container");

    public CartPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getCartItem(int index) {
        List<WebElement> cartItems = getWebDriver().findElements(By.className("cart_item"));
        return cartItems.get(index);
    }

    public int getCartItemQuantity(int index) {

        String stringQuantity = getCartItem(index).findElement(By.className("cart_quantity")).getText();
        int quantity = Integer.parseInt(stringQuantity);

        return quantity;
    }

    public String getCartItemName(int index) {
        return getCartItem(index).findElement(By.className("inventory_item_name")).getText();
    }

    public String getCartItemDescription(int index) {
        return getCartItem(index).findElement(By.className("inventory_item_desc")).getText();
    }

    public double getCartItemPrice(int index) {

        String priceString = getCartItem(index)
                .findElement(By.className("inventory_item_price")).getText();
        priceString = priceString.replaceAll("[$]", "");

        double price = Double.parseDouble(priceString);

        return price;

    }

    public CartPage removeItemFromCart(int index) {
        getCartItem(index).findElement(By.className("cart_button")).click();
        return this;
    }

    public int getCartItemIndexFromName(String name) {

        for (int i = 0; i < getCartSize(); i++) {
             if (getCartItemName(i).equals(name)) {
                 return i;
             }
        }

        return -1;
    }

    public int getCartSize() {
        List<WebElement> cartItems = getWebDriver().findElements(By.className("cart_item"));
        return cartItems.size();
    }

    public InventoryPage goToInventory(){
        getWebDriver().findElement(continueShoppingButton).click();
        return new InventoryPage(getWebDriver());
    }

    public CheckoutStepOnePage goToCheckoutStepOne(){
        getWebDriver().findElement(checkoutButton).click();
        return new CheckoutStepOnePage(getWebDriver());
    }

    public NavbarPage goToNavbar() {
        getWebDriver().findElement(navbarButton).click();
        return new NavbarPage(getWebDriver());
    }

    public void goToFacebook(){
        getWebDriver().findElement(facebook).click();
    }

    public void goToLinkedin(){
        getWebDriver().findElement(linkedin).click();
    }

    public void goToTwitter(){
        getWebDriver().findElement(twitter).click();
    }

    public CartPage goToCart() {
        getWebDriver().findElement(shoppingCart).click();
        return new CartPage(getWebDriver());
    }

}
