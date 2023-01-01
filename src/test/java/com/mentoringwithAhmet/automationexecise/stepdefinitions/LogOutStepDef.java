package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.LoginPage;
import com.mentoringwithAhmet.automationexecise.pages.MainPageLoggedIn;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LogOutStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainPageLoggedIn mainPageLoggedIn = new MainPageLoggedIn(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Then("User clicks Logout button")
    public void user_clicks_logout_button() {
        mainPageLoggedIn.logOutButton();
    }
    @Then("User verifies that is navigated to login page")
    public void user_verifies_that_is_navigated_to_login_page() {
        loginPage.validateUrlLoginContains(driver);
    }
}
