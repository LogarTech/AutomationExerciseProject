package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverHelper.driver;

public class ProductDetailsPage {
    public ProductDetailsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class= 'product-information']//h2")
    WebElement productName;

    @FindBy(xpath = "//div[@class= 'product-information']//p")
    WebElement productCategory;

    @FindBy(xpath = "//div[@class= 'product-information']//span//span")
    WebElement productPrice;

    @FindBy(xpath = "//div[@class= 'product-information']//p//b[contains(text(), 'Availability:')]")
    WebElement productAvailability;

    @FindBy(xpath = "//div[@class= 'product-information']//p//b[contains(text(), 'Condition:')]")
    WebElement productCondition;

    @FindBy(xpath = "//div[@class= 'product-information']//p//b[contains(text(), 'Brand:')]")
    WebElement productBrand;



    public void validateProductDetailsUrl(){
        driver.getCurrentUrl().contains("product_details");
    }
    public void validateProductInfoIsVisible(){
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productCategory.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
        Assert.assertTrue(productAvailability.isDisplayed());
        Assert.assertTrue(productCondition.isDisplayed());
        Assert.assertTrue(productBrand.isDisplayed());
    }
}
