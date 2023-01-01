package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.ProductDetailsPage;
import com.mentoringwithAhmet.automationexecise.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductsInfoStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);


    @When("click on Products button")
    public void click_on_products_button() {
        automationMainPage.clickProductsButton();
        driver.navigate().refresh();
        automationMainPage.clickProductsButton();
    }

    @When("Verify user is navigated to ALL PRODUCTS page successfully and The products list is visible, click on View Product of first product")
    public void verify_user_is_navigated_to_all_products_page_successfully_and_the_products_list_is_visible_click_on_view_product_of_first_product() {
        productsPage.validateProductsUrl();
        productsPage.validateAllProducts();
        productsPage.clickViewProductButton();
    }

    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        productDetailsPage.validateProductDetailsUrl();
    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        productDetailsPage.validateProductInfoIsVisible();
    }




}
