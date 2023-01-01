package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

import static utils.DriverHelper.driver;

public class ViewCartPage {
    public ViewCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    WebElement bottomTextFooter;

    @FindBy(css = "#susbscribe_email")
    WebElement bottomSearchBox;

    @FindBy(css = "#subscribe")
    WebElement arrowButton;

    @FindBy(xpath = "//div[contains(text(), 'You have been successfully subscribed!')]")
    WebElement successfulSubscriptionMessage;

    @FindBy(xpath = "//tr[contains(@id, 'product')]")
    List<WebElement> itemsAddedToCart;

    @FindBy(xpath = "//td[@class= 'cart_price']")
    List<WebElement> itemsInCartPrices;

    @FindBy(xpath = "//td[@class= 'cart_quantity']")
    List<WebElement> itemsInCartQuantities;


    public void validateBottomFooter(String expectedText) {
        BrowserUtils.scrollIntoView(driver, bottomTextFooter);
        Assert.assertEquals(expectedText, BrowserUtils.getText(bottomTextFooter));
        Assert.assertTrue(bottomTextFooter.isDisplayed());
    }

    public void subscribeTo(String expectedEmail) {
        bottomSearchBox.sendKeys(expectedEmail);

    }

    public void clickArrowButton() {
        arrowButton.click();
    }

    public void validateSuccessfulSubscriptionMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(successfulSubscriptionMessage));
        Assert.assertTrue(successfulSubscriptionMessage.isDisplayed());
    }

    public int checkQuantityInCart() {
        return itemsAddedToCart.size();
    }

    public void checkPricesInCart(){
        Assert.assertTrue(itemsInCartPrices.get(0).getText().contains("500"));
        Assert.assertTrue(itemsInCartPrices.get(1).getText().contains("400"));
    }

    public void checkQuantityInEach(){
        Assert.assertTrue(itemsInCartQuantities.get(0).getText().contains("1"));
        Assert.assertTrue(itemsInCartQuantities.get(1).getText().contains("1"));
    }

    public double totalPriceItemsInCart(){
        double totalPrice = 0;
        for (int i = 0; i < itemsInCartPrices.size(); i++) {
          double price= Double.parseDouble( itemsInCartPrices.get(i).getText().substring(3));
          totalPrice += price;
        }
        System.out.println(totalPrice);
        return totalPrice;
    }

}
