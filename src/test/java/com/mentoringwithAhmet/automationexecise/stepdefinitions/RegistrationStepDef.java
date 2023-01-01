package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class RegistrationStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AutomationSignUpPage automationSignUpPage = new AutomationSignUpPage(driver);
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
    MainPageLoggedIn mainPageLoggedIn = new MainPageLoggedIn(driver);
    MainPageDeletedAccount mainPageDeletedAccount = new MainPageDeletedAccount(driver);


    @Given("User navigates to the AutomationExercise and validates the title {string}")
    public void user_navigates_to_the_automation_exercise_and_validates_the_title(String expectedTitle) {
        driver.get(ConfigReader.readProperty("automationpracticeurl"));
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    @When("User clicks signUp Login button and validates the {string} visible")
    public void user_clicks_sign_up_login_button_and_validates_the_visible(String expectedText) {
        automationMainPage.clickSignUpButton();
        loginPage.validateNewUserSignUp(expectedText);


    }

    @When("User provides username {string} and email address {string} and click sign up button")
    public void user_provides_username_and_email_address_and_click_sign_up_button(String username, String email) {
        loginPage.signUp(username, email);
    }

    @When("User verify {string} message is visible")
    public void user_verify_message_is_visible(String expectedMessage) {
        automationSignUpPage.enterAccountInformationTextIsVisible(expectedMessage);
    }

    @When("User provides TITLE, Name {string}, Email , Password {string}, Date of Birth")
    public void user_provides_title_name_email_password_date_of_birth(String name, String password) {
        automationSignUpPage.fillInfoTitleToDateToBirth(name, password);
    }

    @When("User selects Sign Up for our newsletter! and receives special offers from our partners!")
    public void user_selects_sign_up_for_our_newsletter_and_receives_special_offers_from_our_partners() {
        automationSignUpPage.clickCheckMarks();
    }

    @When("User provides {string}, {string}, {string}, {string}, {string}, Country, {string}, {string},{string}, {string}")
    public void user_provides_country(String firstName, String lastName, String company, String address, String address2, String state, String city, String zipcode, String mobileNumber) {
        automationSignUpPage.fillInfoFirstNameToMobileNumber(firstName, lastName, company, address, address2, state, city, zipcode, mobileNumber);
    }

    @Then("User clicks Create Account button and validates {string}")
    public void user_clicks_create_account_button_and_validates(String expectedMessage) {
        automationSignUpPage.clickCreateAccount();
        accountCreatedPage.accountCreatedMessageIsVisible(expectedMessage);
    }

    @Then("User clicks Continue Button and validate Logged in as username")
    public void user_clicks_continue_button_and_validate_logged_in_as_username() throws InterruptedException {
        accountCreatedPage.clickContinue();

        mainPageLoggedIn.loginIsVisible();
    }

    @Then("User clicks Delete Account button and validates {string} is visible")
    public void user_clicks_delete_account_button_and_validates_is_visible(String expectedMessage) {
        mainPageLoggedIn.deleteButton();
        mainPageDeletedAccount.deletedAccountConfirmation(expectedMessage);
    }
    @Then("User clicks continue button")
    public void user_clicks_continue_button() {
        mainPageDeletedAccount.continueButtonClick();
    }


}
