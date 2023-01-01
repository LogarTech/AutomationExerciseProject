package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.ViewCartPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class VerifySubscriptionInCartStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    ViewCartPage viewCartPage = new ViewCartPage(driver);


    @When("User clicks Cart button")
    public void user_clicks_cart_button() {
        automationMainPage.clickCartButton();
    }
    @When("User scrolls down to footer, verifies text {string}")
    public void user_scrolls_down_to_footer_verifies_text(String expectedText) {
        viewCartPage.validateBottomFooter(expectedText);
    }
    @Then("User enters email {string} in input and click arrow button")
    public void user_enters_email_in_input_and_click_arrow_button(String expectedEmail) {
        viewCartPage.subscribeTo(expectedEmail);
        viewCartPage.clickArrowButton();
    }
    @Then("User verify the message {string} is visible")
    public void user_verify_the_message_is_visible(String expectedMessage) {
        viewCartPage.validateSuccessfulSubscriptionMessage(expectedMessage);
    }

}
