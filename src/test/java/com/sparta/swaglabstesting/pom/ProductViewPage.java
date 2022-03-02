package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductViewPage extends Page {

    private By inventoryLink = new By.ByClassName("inventory_details_back_button");

    public ProductViewPage(WebDriver webDriver, String productName){
        super(webDriver);
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

    //products have different URLs depending on the product id (anything over 6 shows a dog)
    //should NOT be url dependent for checking the url
    public InventoryPage goToInventoryPage(){
        getWebDriver().findElement(inventoryLink).click();
        return new InventoryPage(getWebDriver());
    }

}
