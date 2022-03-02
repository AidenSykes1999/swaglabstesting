package com.sparta.swaglabstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductViewPage {
    private WebDriver webDriver;
    private By inventoryLink = new By.ByClassName("btn btn_secondary back btn_large inventory_detrails_back_button");


    public ProductViewPage(WebDriver webDriver, String productName){
        this.webDriver = webDriver;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }
    public String getProductName(){
        return webDriver
                .findElement(By.className("inventory_details_name large_size"))
                .getText();
    }
    public String getPrice(){
        return webDriver.findElement(By.className("inventory_details_price")).getText();
    }

    public boolean isProductInCart(){
        boolean isInCart = false;
        if(webDriver.findElement(By.className("btn btn_primary btn_small btn_inventory")).getText().equals("Add to cart")){
            return isInCart;
        }
        else if(webDriver.findElement(By.className("btn btn_secondary btn_small btn_inventory")).getText().equals("Remove")){
            return isInCart = true;
        }
        return isInCart;
    }
    //products have different URLs depending on the product id (anything over 6 shows a dog)
    //should NOT be url dependent for checking the url
    public InventoryPage goToInventoryPage(){
        webDriver.findElement(inventoryLink).click();
        return new InventoryPage(webDriver);
    }
}
