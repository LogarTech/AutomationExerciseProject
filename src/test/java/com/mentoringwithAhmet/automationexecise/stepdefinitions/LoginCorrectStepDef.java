package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.LoginPage;
import com.mentoringwithAhmet.automationexecise.pages.MainPageDeletedAccount;
import com.mentoringwithAhmet.automationexecise.pages.MainPageLoggedIn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginCorrectStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    MainPageLoggedIn mainPageLoggedIn = new MainPageLoggedIn(driver);
    MainPageDeletedAccount mainPageDeletedAccount = new MainPageDeletedAccount(driver);


    @Given("User navigates to the AutomationExercise and validates the title {string} is visible")
    public void user_navigates_to_the_automation_exercise_and_validates_the_title_is_visible(String expectedTitle) {
        driver.get(ConfigReader.readProperty("automationpracticeurl"));
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    @When("User clicks signUp Login button and validates the {string} is visible")
    public void user_clicks_sign_up_login_button_and_validates_the_is_visible(String expectedText) {
        automationMainPage.clickSignUpButton();
        loginPage.validateLogInToYourAccount(expectedText);
    }

    @And("User provides email address {string}, password {string} and clicks login button")
    public void user_provides_email_address_password_and_clicks_login_button(String email, String password) {
        loginPage.logIn(email, password);
    }
    @And("User verify that Logged in as username is visible")
    public void user_verify_that_is_visible() {
        mainPageLoggedIn.loginIsVisible();
    }
    @Then("User clicks Delete Account button")
    public void user_clicks_button() {
    }
    @And("User verifies that {string} is visible")
    public void user_verifies_that_is_visible(String expectedMessage) {
    }
}
