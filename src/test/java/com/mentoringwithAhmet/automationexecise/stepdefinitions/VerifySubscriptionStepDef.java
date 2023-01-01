package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class VerifySubscriptionStepDef {
    WebDriver driver = DriverHelper.getDriver();

    AutomationMainPage automationMainPage = new AutomationMainPage(driver);

    @When("User scrolls down to footer and verifies text {string}")
    public void user_scrolls_down_to_footer_and_verifies_text(String expectedText) {
        automationMainPage.validateBottomFooter(expectedText);
    }
    @When("User enters {string} in input and clicks arrow button")
    public void user_enters_in_input_and_clicks_arrow_button(String expectedEmail) {
        automationMainPage.subscribeTo(expectedEmail);
        automationMainPage.clickArrowButton();
    }
    @Then("User verifies the message {string} is visible")
    public void user_verifies_the_message_is_visible(String expectedMessage) {
        automationMainPage.validateSuccessfulSubscriptionMessage(expectedMessage);
    }


}
