package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutStepTwoPage extends Page {

    private String numberRegex;
    private By navbarButton = new By.ById("react-burger-menu-btn");
    private By facebook = new By.ByClassName("social_facebook");
    private By linkedin = new By.ByClassName("social_linkedin");
    private By twitter = new By.ByClassName("social_twitter");
    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
        this.numberRegex = "[^\\d]";
    }

    public CartPage goToCart(){
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
        return new CartPage(getWebDriver());
    }

    public InventoryPage cancelBackToInventory(){
        getWebDriver().findElement(By.id("cancel")).click();
        return new InventoryPage(getWebDriver());
    }

    public int getTaxCents(){
        String taxText = getWebDriver().findElement(By.className("summary_tax_label")).getText();
        return Integer.parseInt(taxText.replaceAll(this.numberRegex,""));
    }

    public int getTotalCents(){
        String totalText = getWebDriver().findElement(By.className("summary_total_label")).getText();
        return Integer.parseInt(totalText.replaceAll(this.numberRegex, ""));
    }

    public int getItemTotalCents(){
        String totalText = getWebDriver().findElement(By.className("summary_subtotal_label")).getText();

        return Integer.parseInt(totalText.replaceAll(this.numberRegex, ""));
    }

    public CheckoutComplete finishToCheckoutComplete(){
        getWebDriver().findElement(By.id("finish")).click();
        return new CheckoutComplete(getWebDriver());
    }

    public List<Integer> getInventoryItemPrices(){
    return getWebDriver().findElements(By.className("inventory_item_price"))
            .stream()
            .map(we-> Integer.parseInt(we.getText().replace(this.numberRegex,"")))
            .toList();
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


}

