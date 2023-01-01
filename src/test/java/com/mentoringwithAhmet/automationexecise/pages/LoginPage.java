package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Login to your account')]")
    WebElement loginToYourAccountHeader;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    WebElement emailLoginBox;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement loginButton;

    @FindBy(xpath = "(//h2)[3]")
    WebElement newSignUpHeader;
    @FindBy(xpath = "//input[@ placeholder='Name']")
    WebElement nameBox;

    @FindBy(xpath = "(//input[@ placeholder='Email Address'])[2]")
    WebElement emailBox;

    @FindBy(xpath = "//button[contains(text(), 'Signup')]")
    WebElement signUpButton;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    WebElement errorMessage;

    @FindBy(xpath = "//p[contains(text(), 'Email Address already exist!')]")
    WebElement existingEmailMessage;

    public void validateLogInToYourAccount(String expectedHeader){
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(loginToYourAccountHeader));
        Assert.assertTrue(loginToYourAccountHeader.isDisplayed());
    }

    public void logIn(String email, String password){
        emailLoginBox.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void validateNewUserSignUp(String expectedHeader){
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(newSignUpHeader));
        Assert.assertTrue(newSignUpHeader.isDisplayed());
    }

    public void signUp(String username, String email){
        nameBox.sendKeys(username);
        emailBox.sendKeys(email);
        signUpButton.click();
    }

    public void validateErrorIncorrectSignIn(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void validateUrlLoginContains(WebDriver driver){
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    public void validateExistingEmailMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(existingEmailMessage));
        Assert.assertTrue(existingEmailMessage.isDisplayed());
    }

}
