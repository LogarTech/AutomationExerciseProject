package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.security.Key;
import java.util.List;

import static utils.DriverHelper.driver;

public class ProductsPage {
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[contains(text(), 'View Product')])[1]")
    WebElement viewProductButton;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> allProducts;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchProductBox;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//u[contains(text(), 'View Cart')]")
    WebElement viewCartButton;

    @FindBy(xpath = "//button[contains(text(), 'Continue Shopping')]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "(//a[contains(text(), 'Add to cart')])[1]")
    WebElement addToCart1;

    @FindBy(xpath = "(//a[contains(text(), 'Add to cart')])[3]")
    WebElement addToCart2;
    public void validateProductsUrl() {
        driver.getCurrentUrl().contains("products");
    }

    public void validateAllProducts() {
        for (WebElement product : allProducts) {
            BrowserUtils.scrollIntoView(driver, product);
            Assert.assertTrue(product.isDisplayed());
        }
    }

    public void clickViewProductButton() {
        viewProductButton.click();
    }

    public void clickSearchProduct() {
        this.searchProductBox.sendKeys("top");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickContinueShoppingButton() throws InterruptedException {
        Thread.sleep(1000);
        continueShoppingButton.click();
    }

    public void clickViewCartButton() throws InterruptedException {
        Thread.sleep(1000);
        viewCartButton.click();
    }

    public void AddingToCartItems1(){
        addToCart1.click();
    }

    public void AddingToCartItems2(){
        addToCart2.click();
    }

    public void hoverOver1() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        BrowserUtils.scrollIntoView(driver, addToCart1);
        actions.moveToElement(addToCart1).perform();
    }

    public void hoverOver2() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        //BrowserUtils.scrollIntoView(driver, addToCart2);
        actions.moveToElement(addToCart2).perform();
    }


}
