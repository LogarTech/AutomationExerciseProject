package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.TestCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;



public class VerifyTestCasePage {

    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @When("User clicks on Test Cases button")
    public void user_clicks_on_test_cases_button() {
        automationMainPage.clickTestCaseButton();
    }
    @Then("User verifies is navigated to test cases page successfully")
    public void user_verifies_is_navigated_to_test_cases_page_successfully() {
        testCasesPage.validateTestCasesUrl();
       driver.navigate().refresh();
       automationMainPage.clickTestCaseButton();
        // testCasesPage.clickCloseAd();

    }


}
