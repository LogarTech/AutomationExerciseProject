package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import static utils.DriverHelper.driver;

public class AutomationMainPage {
    public AutomationMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href= '/login']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[contains(text(), ' Contact us')]")
    WebElement contactUsButton;

    @FindBy(xpath = "//a[contains(text(), ' Test Cases')]")
    WebElement testCaseButton;
    @FindBy(xpath = "//a[contains(text(), ' Products')]")
    WebElement productsButton;

    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    WebElement bottomTextFooter;

    @FindBy(css = "#susbscribe_email")
    WebElement bottomSearchBox;

    @FindBy(css = "#subscribe")
    WebElement arrowButton;

    @FindBy(xpath = "//div[contains(text(), 'You have been successfully subscribed!')]")
    WebElement successfulSubscriptionMessage;

    @FindBy(xpath = "//a[contains(text(), ' Cart')]")
    WebElement cartButton;

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public void clickContactUsButton(){
        contactUsButton.click();
    }

    public void clickTestCaseButton(){
        testCaseButton.click();
    }

    public void clickProductsButton(){
        productsButton.click();
        driver.navigate().refresh();
        productsButton.click();
    }

    public void validateBottomFooter(String expectedText){
        BrowserUtils.scrollIntoView(driver, bottomTextFooter );
        Assert.assertEquals(expectedText, BrowserUtils.getText(bottomTextFooter));
        Assert.assertTrue(bottomTextFooter.isDisplayed());
    }

    public void subscribeTo(String expectedEmail){
        bottomSearchBox.sendKeys(expectedEmail);

    }
    public void clickArrowButton(){
        arrowButton.click();
    }

    public void validateSuccessfulSubscriptionMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(successfulSubscriptionMessage));
        Assert.assertTrue(successfulSubscriptionMessage.isDisplayed());
    }
    public  void clickCartButton(){
        cartButton.click();
    }


}
