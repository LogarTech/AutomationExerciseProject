package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginIncorrectStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("User provides wrong email address {string}, password {string} and clicks login button")
    public void user_provides_wrong_email_address_password_and_clicks_login_button(String email, String password ) {
        loginPage.logIn(email,password);
    }
    @Then("User verifies error message {string} is visible")
    public void user_verifies_error_message_is_visible(String expectedMessage) {
        loginPage.validateErrorIncorrectSignIn(expectedMessage);
    }
}
