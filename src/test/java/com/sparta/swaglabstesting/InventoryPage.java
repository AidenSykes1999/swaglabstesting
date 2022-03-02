package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebDriver webDriver;

    By inventoryList = new By.ByClassName("inventory_list");
    By sortContainer = new By.ByClassName("product_sort_container");
    By navbarButton = new By.ById("react-burger-menu-btn");

    By shoppingCart = new By.ById("shopping_cart_container");
    By socialMedia = new By.ByClassName("social");

    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // valid options = 'az', 'za', 'lohi', 'hilo'
    public InventoryPage sortBy(String option) {

        WebElement container = webDriver.findElement(sortContainer);
        WebElement containerOption = container.findElement(By.xpath("//option[@value='" + option + "']"));

        container.click();
        containerOption.click();

        return this;
    }

    public String getProductName(int index) {
        return getProduct(index)
                .findElement(By.className("inventory_item_name"))
                .getText();
    }

    public String getProductDescription(int index) {
        return getProduct(index)
                .findElement(By.className("inventory_item_desc"))
                .getText();
    }

    public double getProductPrice(int index) {

        String priceString = getProduct(index)
                .findElement(By.className("inventory_item_price")).getText();

        System.out.println(priceString);

        return 0;
    }

    public InventoryPage addOrRemoveProductFromCart(int index) {
        getProduct(index).findElement(By.className("btn_inventory")).click();
        return this;
    }

    public Boolean isProductInCart(int index) {

        String status = getProduct(index).findElement(By.className("btn_btn_inventory")).getText();

        if (status.equals("Remove")) {
            return true;
        }
        else if (status.equals("Add to cart")) {
            return false;
        }

        return null;

    }

    public WebElement getProduct(int index) {
        WebElement product = webDriver.findElement(inventoryList)
                .findElements(By.className("inventory_item"))
                .get(index);

        return product;
    }

    // public CartPage openCart() {
    //     webDriver.findElement(shoppingCart).click();
    //     return new CartPage(webDriver);
    // }
    //
    // public Navbar openNavbar() {
    //     webDriver.findElement(navbarButton).click();
    //     return new Navbar(webDriver);
    // }
    //
    // public InventoryProductPage goToProductPage(int index) {
    //     getProduct(index).click();
    //     return new InventoryProductPage(webDriver);
    // }

    public String goToTwitter() {
        webDriver.findElement(socialMedia).findElement(By.linkText("Twitter")).click();
        return getCurrentUrl();
    }

    public String goToFacebook() {
        webDriver.findElement(socialMedia).findElement(By.linkText("Facebook")).click();
        return getCurrentUrl();
    }

    public String goToLinkedIn() {
        webDriver.findElement(socialMedia).findElement(By.linkText("LinkedIn")).click();
        return getCurrentUrl();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}
