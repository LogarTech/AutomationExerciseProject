package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class MainPageDeletedAccount {
    public MainPageDeletedAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[contains(text(), 'Account Deleted!')]")
    WebElement deletedText ;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public void deletedAccountConfirmation(String expectedMessage) {
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(deletedText).trim());
        Assert.assertTrue(deletedText.isDisplayed());
    }

    public void continueButtonClick(){
        continueButton.click();
    }
}
