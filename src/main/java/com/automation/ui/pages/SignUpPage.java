package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;


public class SignUpPage extends BasePage {

    @FindBy(xpath = "(//h2[@class=\"title text-center\"]/b)[1]")
    private WebElement accountInformationHeader;

    @FindBy(xpath = "//div[@class='radio' and @id='uniform-id_gender1']")
    private WebElement maleTittleRadioButton;

    @FindBy(xpath = "//div[@class='radio' and @id='uniform-id_gender2']")
    private WebElement femaleTittleRadioButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement birthDayDropDown;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement birthMonthDropDown;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement birthYearDropDown;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement sighUpForNewsletterCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement receiveSpecialOffersCheckBox;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyNameTextBox;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address1TextBox;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2TextBox;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityTextBox;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateTextBox;

    @FindBy(xpath = " //input[@id='zipcode']")
    private WebElement zipcodeTextBox;

    @FindBy(xpath = " //input[@id='mobile_number']")
    private WebElement mobileNumberTextBox;

    @FindBy(xpath = " //button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @Inject
    private AccountCreatedPage accountCreatedPage;

    @Inject
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountInformationSectionTitle() {
        return getText(accountInformationHeader);
    }

    public void setPersonTitle(Title userTitle) {
        switch (userTitle) {
            case Mr: {
                click(maleTittleRadioButton);
                return;
            }
            case Mrs: {
                click(femaleTittleRadioButton);
                return;
            }
        }
        throw new RuntimeException("Unknown Title: " + userTitle);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void setDateOfBirth(LocalDate birthdate) {
        click(birthDayDropDown);
        Select bDayDropdown = new Select(birthDayDropDown);
        bDayDropdown.selectByVisibleText(String.valueOf(birthdate.getDayOfMonth()));

        click(birthMonthDropDown);
        Select bMonthDropdown = new Select(birthMonthDropDown);
        bMonthDropdown.selectByVisibleText(capitalizedMonthName(birthdate));

        click(birthYearDropDown);
        Select bYearDropdown = new Select(birthYearDropDown);
        bYearDropdown.selectByVisibleText(String.valueOf(birthdate.getYear()));
    }

    private static String capitalizedMonthName(LocalDate birthdate) {
        String uppercaseName = birthdate.getMonth().name();
        return uppercaseName.substring(0, 1).toUpperCase() + uppercaseName.substring(1).toLowerCase();
    }

    public void toggleSighUpForNewsletterCheckbox() {
        click(sighUpForNewsletterCheckBox);
    }

    public void toggleReceiveSpecialOffersCheckBox() {
        click(receiveSpecialOffersCheckBox);
    }

    public void setFirstName(String firstName) {
        sendKeys(firstNameTextBox, firstName);
    }

    public void setLastName(String lastName) {
        sendKeys(lastNameTextBox, lastName);
    }

    public void setCompanyName(String companyName) {
        sendKeys(companyNameTextBox, companyName);
    }

    public void setAddress1(String address1) {
        sendKeys(address1TextBox, address1);
    }

    public void setAddress2(String address2) {
        sendKeys(address2TextBox, address2);
    }

    public void setCountry(String country) {
        Select countryDropdown = new Select(this.countryDropdown);
        countryDropdown.selectByVisibleText(country);
    }

    public void setCity(String city) {
        sendKeys(cityTextBox, city);
    }

    public void setState(String state) {
        sendKeys(stateTextBox, state);
    }

    public void setZipcode(String zipcode) {
        sendKeys(zipcodeTextBox, zipcode);
    }

    public void setMobileNumber(String mobileNumber) {
        sendKeys(mobileNumberTextBox, mobileNumber);
    }

    public AccountCreatedPage clickCreateAccountButton() {
        click(createAccountButton);
        return accountCreatedPage;
    }

    public enum Title {
        Mr,
        Mrs
    }
}
