package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductViewPage extends Page {

    private By inventoryLink = new By.ByClassName("inventory_details_back_button");
    private By shoppingCart = new By.ById("shopping_cart_container");
    private By productAddRemoveButton = new By.ByClassName("btn_inventory");

    private String productName;

    public ProductViewPage(WebDriver webDriver, String productName){
        super(webDriver);
        productName = productName;
    }

    public String getProductName(){
        return getWebDriver()
                .findElement(By.className("inventory_details_name"))
                .getText();
    }

    public String getPrice(){
        return getWebDriver().findElement(By.className("inventory_details_price")).getText();
    }

    public boolean isProductInCart(){
        boolean isInCart = false;
        if(getWebDriver().findElement(By.className("btn_inventory")).getText().equals("Add to cart")){
            return isInCart;
        }
        else if(getWebDriver().findElement(By.className("btn_inventory")).getText().equals("Remove")){
            return isInCart = true;
        }
        return isInCart;
    }

    public ProductViewPage addRemoveProductFromCart() {
        getWebDriver().findElement(productAddRemoveButton).click();
        return this;
    }

    //products have different URLs depending on the product id (anything over 6 shows a dog)
    //should NOT be url dependent for checking the url
    public InventoryPage goToInventoryPage(){
        getWebDriver().findElement(inventoryLink).click();
        return new InventoryPage(getWebDriver());
    }

    public CartPage goToCartPage() {
        getWebDriver().findElement(shoppingCart).click();
        return new CartPage(getWebDriver());
    }

}
