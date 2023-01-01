package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverHelper.driver;

public class MainPageLoggedIn {
    public MainPageLoggedIn(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a)[11]")
    WebElement loggedInConfirmation;

    @FindBy(xpath = "(//a)[6]")
    WebElement deleteButton;

    @FindBy(xpath = "(//a)[5]" )
    WebElement logOutButton;

    public void loginIsVisible(){
        Assert.assertTrue(loggedInConfirmation.isDisplayed());
    }
    public void deleteButton(){
        deleteButton.click();
        driver.navigate().refresh();
        deleteButton.click();
    }

    public void logOutButton(){
        logOutButton.click();
    }

}
