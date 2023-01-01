package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import static utils.DriverHelper.driver;

public class AccountCreatedPage {
    public AccountCreatedPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2/b")
    WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    WebElement continueButton;

    public void accountCreatedMessageIsVisible(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(accountCreatedMessage).trim());
        Assert.assertTrue(accountCreatedMessage.isDisplayed());
    }

    public void clickContinue() throws InterruptedException {
        continueButton.click();
//        try{
//            Alert alert = driver.switchTo().alert();
//            alert.dismiss();
//        }catch (NoAlertPresentException ne){
//            System.out.println("Alert not present");
//            ne.printStackTrace();
//        }
        driver.navigate().refresh();
        Thread.sleep(3000);
        continueButton.click();
    }

}
