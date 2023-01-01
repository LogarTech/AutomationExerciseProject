package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RegisterWithExistingEmail {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Then("Verify error {string} is visible")
    public void verify_error_is_visible(String expectedMessage) {
        loginPage.validateExistingEmailMessage(expectedMessage);
    }


}
