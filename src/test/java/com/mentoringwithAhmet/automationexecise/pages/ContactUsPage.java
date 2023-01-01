package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import static utils.DriverHelper.driver;

public class ContactUsPage {
    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Get In Touch')]")
    WebElement getInTouchHeader;

    @FindBy(xpath = "//input[@name= 'name']")
    WebElement nameBox;

    @FindBy(xpath = "//input[@name= 'email']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@name= 'subject']")
    WebElement subjectBox;

    @FindBy(css = "#message")
    WebElement textAreaBox;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement chooseFileButton;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;

    @FindBy(xpath = "(//div[contains(text(), 'Succes')])[1]")
    WebElement successMessage;

    @FindBy(xpath = "//div[@id='aswift_1_host']//iframe")
    WebElement adIframe;

    @FindBy(xpath = "//div[@id='dismiss-button']")
    WebElement closeButton;

    @FindBy(xpath = "//a[contains(text(), ' Home')]")
    WebElement homeButton;

    public void validateGetInTouchText(String expectedMessage) {
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(getInTouchHeader));
        Assert.assertTrue(getInTouchHeader.isDisplayed());
    }

    public void formInformation(String name, String email, String subject, String message) throws InterruptedException {
        Thread.sleep(5000);
        nameBox.sendKeys(name);
        emailBox.sendKeys(email);
        subjectBox.sendKeys(subject);
        textAreaBox.sendKeys(message);

    }

    public void chooseFile(String fileDirectory) {
        chooseFileButton.sendKeys(fileDirectory);
        BrowserUtils.scrollIntoView(driver, submitButton);
        submitButton.click();
    }

    public void clickOkAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void validateSuccessMessage(String expectedMessage) throws InterruptedException {
        BrowserUtils.scrollIntoView(driver, homeButton);
        Thread.sleep(3000);
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void clickHomeButton() {
        homeButton.click();
    }
    public void closeAd(){
        driver.switchTo().frame(adIframe);
        closeButton.click();
    }
}
