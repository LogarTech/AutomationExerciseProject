package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

import static utils.DriverHelper.driver;

public class ProductsInSearchPage {
    public ProductsInSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[contains(text(), 'Searched Products')]")
    WebElement searchProductsText;

    @FindBy(xpath = "//div[@class= 'productinfo text-center']//p")
    List<WebElement> allSearchedProducts;

    @FindBy(xpath = "//div[@class= 'productinfo text-center']//h2")
    List<WebElement> allPrices;

    public void validateSearchProductsText(){
        Assert.assertTrue(searchProductsText.isDisplayed());
    }

    public void validateAllSearchedProducts() throws InterruptedException {
        for(int i = 0; i < allSearchedProducts.size(); i++){
            Thread.sleep(1000);
            BrowserUtils.scrollIntoView(driver,allPrices.get(i));
            Assert.assertTrue(allSearchedProducts.get(i).isDisplayed());
        }
    }
}
