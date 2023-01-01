package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.ProductsInSearchPage;
import com.mentoringwithAhmet.automationexecise.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchProductStepDef {
    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);
    ProductsInSearchPage productsInSearchPage = new ProductsInSearchPage(driver);

    @When("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        productsPage.validateProductsUrl();
    }
    @Then("User enters product name in search input and click search button")
    public void user_enters_product_name_in_search_input_and_click_search_button() {
        productsPage.clickSearchProduct();
        productsPage.clickSearchButton();
    }
    @Then("User verifies SEARCHED PRODUCTS is visible, user verifies all the products related to search are visible")
    public void user_verifies_searched_products_is_visible_user_verifies_all_the_products_related_to_search_are_visible() throws InterruptedException {
        productsInSearchPage.validateSearchProductsText();
        productsInSearchPage.validateAllSearchedProducts();
    }
}
