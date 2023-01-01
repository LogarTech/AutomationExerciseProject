package com.mentoringwithAhmet.automationexecise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import static utils.DriverHelper.driver;

public class AutomationSignUpPage {
    public AutomationSignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2/b[contains(text(),'Enter')]")
    WebElement enterAccountInformationText;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement titleButton;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement day;

    @FindBy(xpath = "//select[@id='months']")
    WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    WebElement year;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletterSignUp;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement recieveSpecialOffers;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(xpath = "//select[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;



    public void enterAccountInformationTextIsVisible(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(enterAccountInformationText));
        Assert.assertTrue(enterAccountInformationText.isDisplayed());
    }

    public void fillInfoTitleToDateToBirth(String name, String password){
        titleButton.click();
        this.name.clear();
        this.name.sendKeys(name);
        this.password.sendKeys(password);
        BrowserUtils.selectBy(day, "8", "text");
        BrowserUtils.selectBy(month, "May", "text");
        BrowserUtils.selectBy(year, "1989", "text");

    }

    public void clickCheckMarks(){
        BrowserUtils.scrollIntoView(driver, newsletterSignUp);
        newsletterSignUp.click();
        recieveSpecialOffers.click();
    }

    public void fillInfoFirstNameToMobileNumber(String firstName, String lastName, String company,
                                                String address, String address2, String state, String city, String zipcode, String mobileNumber){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address.sendKeys(address);
        this.address2.sendKeys(address2);
        BrowserUtils.selectBy(country, "New Zeeland", "Text");
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
        this.mobileNumber.sendKeys(mobileNumber);
    }

    public void clickCreateAccount(){
        createAccountButton.click();

    }

}
