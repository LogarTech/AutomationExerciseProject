package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.ProductsPage;
import com.mentoringwithAhmet.automationexecise.pages.ViewCartPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverHelper;

public class AddProductsStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ViewCartPage viewCartPage = new ViewCartPage(driver);


    @When("User clicks Products button and user hovers over first product and click Add to cart")
    public void user_clicks_products_button_and_user_hovers_over_first_product_and_click_add_to_cart() throws InterruptedException {
        automationMainPage.clickProductsButton();
        productsPage.hoverOver1();
        productsPage.AddingToCartItems1();
    }
    @When("User click Continue Shopping button, user hovers over second product and clicks Add to cart")
    public void user_click_continue_shopping_button_user_hovers_over_second_product_and_clicks_add_to_cart() throws InterruptedException {
        productsPage.clickContinueShoppingButton();
        productsPage.hoverOver2();
        productsPage.AddingToCartItems2();
    }
    @Then("User clicks View Cart button and verifies both products are added to Cart")
    public void user_clicks_view_cart_button_and_verifies_both_products_are_added_to_cart() throws InterruptedException {
       productsPage.clickViewCartButton();
       viewCartPage.checkQuantityInCart();
        Assert.assertEquals(2, viewCartPage.checkQuantityInCart());
    }
    @Then("User verifies their prices, quantity and total price")
    public void user_verifies_their_prices_quantity_and_total_price() {
        viewCartPage.checkPricesInCart();
        viewCartPage.checkQuantityInEach();
        viewCartPage.totalPriceItemsInCart();

    }

}
