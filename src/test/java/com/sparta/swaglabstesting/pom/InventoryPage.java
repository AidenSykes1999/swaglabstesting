package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends Page {

    private By inventoryList = new By.ByClassName("inventory_list");
    private By sortContainer = new By.ByClassName("product_sort_container");
    private By navbarButton = new By.ById("react-burger-menu-btn");
    private By shoppingCart = new By.ById("shopping_cart_container");
    private By socialMedia = new By.ByClassName("social");

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    // valid options = 'az', 'za', 'lohi', 'hilo'
    public InventoryPage sortBy(String option) {

        WebElement container = getWebDriver().findElement(sortContainer);
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
        priceString = priceString.replaceAll("[$]", "");

        double price = Double.parseDouble(priceString);

        System.out.println(price);

        return price;
    }

    public InventoryPage addOrRemoveProductFromCart(int index) {
        getProduct(index).findElement(By.className("btn_inventory")).click();
        return this;
    }

    // public Boolean isProductInCart(int index) {
    //
    //     String status = getProduct(index).findElement(By.className("btn_btn_inventory")).getText();
    //
    //     if (status.equals("Remove")) {
    //         return true;
    //     }
    //     else if (status.equals("Add to cart")) {
    //         return false;
    //     }
    //
    //     return null;
    //
    // }

    public WebElement getProduct(int index) {
        WebElement product = getWebDriver().findElement(inventoryList)
                .findElements(By.className("inventory_item"))
                .get(index);

        return product;
    }

    public int getProductIndexFromName(String name) {

        for (int i = 0; i < getProductCount(); i++) {
            if (getProductName(i).equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public int getProductCount() {
        List<WebElement> products = getWebDriver().findElement(inventoryList)
                .findElements(By.className("inventory_item"));

        return products.size();
    }

    public boolean isProductsSortedLowestToHighest() {

        boolean ordered = true;

        double previous = 0;

        for (int i = 0; i < getProductCount() ; i++) {

            double price = getProductPrice(i);

            if (price < previous) {
                ordered = false;
            }

            previous = price;
        }

        return ordered;
    }

    public boolean isProductsSortedHighestToLowest() {

        boolean ordered = true;

        double previous = getProductPrice(0);

        for (int i = 0; i < getProductCount() ; i++) {

            double price = getProductPrice(i);

            if (!(price <= previous)) {
                ordered = false;
            }

            previous = price;
        }

        return ordered;
    }

    public boolean isProductsSortedAlphabetically() {

        boolean ordered = true;

        String previous = "";

        for (int i = 0; i < getProductCount() ; i++) {

            String name = getProductName(i);

            if (name.compareTo(previous) < 0) {
                ordered = false;
            }

            previous = name;
        }

        return ordered;
    }

    public boolean isProductsSortedReverseAlphabetically() {

        boolean ordered = true;

        String previous = getProductName(0);

        for (int i = 0; i < getProductCount(); i++) {

            String name = getProductName(i);

            if ((name.compareTo(previous) > 0)) {
                ordered = false;
            }

            previous = name;
        }

        return ordered;
    }

    public CartPage goToCart() {
        getWebDriver().findElement(shoppingCart).click();
        return new CartPage(getWebDriver());
    }

    public ProductViewPage goToProductPageViaName(int index) {
        String productName = getProductName(index);
        getProduct(index)
                .findElement(By.className("inventory_item_name")).click();
        return new ProductViewPage(getWebDriver(), productName);
    }

    public ProductViewPage goToProductPageViaImage(int index) {
        String productName = getProductName(index);
        getProduct(index).findElement(By.className("inventory_item_name")).click();
        return new ProductViewPage(getWebDriver(), productName);
    }

    //
    // public Navbar openNavbar() {
    //     webDriver.findElement(navbarButton).click();
    //     return new Navbar(webDriver);
    // }
    //

    public String goToTwitter() {
        getWebDriver().findElement(socialMedia).findElement(By.linkText("Twitter")).click();
        return getCurrentUrl();
    }

    public String goToFacebook() {
        getWebDriver().findElement(socialMedia).findElement(By.linkText("Facebook")).click();
        return getCurrentUrl();
    }

    public String goToLinkedIn() {
        getWebDriver().findElement(socialMedia).findElement(By.linkText("LinkedIn")).click();
        return getCurrentUrl();
    }

}
