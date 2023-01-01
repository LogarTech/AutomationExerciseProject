package com.mentoringwithAhmet.automationexecise.stepdefinitions;

import com.mentoringwithAhmet.automationexecise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexecise.pages.ContactUsPage;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ContactUsFormStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AutomationMainPage automationMainPage = new AutomationMainPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);




    @Given("User navigates to the AutomationExercise and validates title {string} is visible")
    public void user_navigates_to_the_automation_exercise_and_validates_title_is_visible(String expectedTitle) {
        driver.get(ConfigReader.readProperty("automationpracticeurl"));
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }
    @When("User clicks on Contact Us button and verifies {string} is visible")
    public void user_clicks_on_contact_us_button_and_verifies_is_visible(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
        automationMainPage.clickContactUsButton();
        contactUsPage.validateGetInTouchText(expectedMessage);
    }
    @Then("User enters name {string}, email {string}, subject {string}, and message {string}")
    public void user_enters_name_email_subject_and_message(String name, String email, String subject, String message) throws InterruptedException {
        contactUsPage.formInformation(name,email, subject, message);
    }
    @Then("User uploads {string} file and user clicks Submit button")
    public void user_uploads_file_and_user_clicks_submit_button(String fileDirectory) {
        contactUsPage.chooseFile(fileDirectory);
    }
    @Then("User click OK button")
    public void user_click_ok_button() {
        contactUsPage.clickOkAlert(driver);
    }
    @Then("User verifies success message {string} is visible")
    public void user_verifies_success_message_is_visible(String expectedMessage) throws InterruptedException {
//        contactUsPage.closeAd();
        contactUsPage.validateSuccessMessage(expectedMessage);
    }
    @Then("User clicks Home button and verify that landed to home page successfully")
    public void user_clicks_home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsPage.clickHomeButton();
        contactUsPage.closeAd();
    }




}
