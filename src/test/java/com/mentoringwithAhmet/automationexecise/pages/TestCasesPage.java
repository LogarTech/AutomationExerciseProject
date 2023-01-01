package com.mentoringwithAhmet.automationexecise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverHelper.driver;

public class TestCasesPage {
    public TestCasesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#google_esf")
    WebElement mainFrame;

    @FindBy(xpath = "//iframe[@id= 'ad_iframe']")
    WebElement innerFrame;

    @FindBy(xpath = "//span[contains(text(), 'Close')]")
    WebElement closeAdButton;

    @FindBy(xpath = "//div[@id='aswift_1_host']//iframe")
    WebElement adXIframe;

    @FindBy(css = "#dismiss-button")
    WebElement closeXAd;

    public void validateTestCasesUrl() {
        driver.getCurrentUrl().contains("test_cases");
    }

    public void clickCloseAd(){
        if(closeXAd.isDisplayed()){
            driver.switchTo().frame(adXIframe);
            closeXAd.click();
        } else if (closeAdButton.isDisplayed()) {
            driver.switchTo().frame(mainFrame);
            driver.switchTo().frame(innerFrame);
            closeAdButton.click();
        }
    }
}
