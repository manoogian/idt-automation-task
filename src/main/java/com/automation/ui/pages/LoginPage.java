package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='signup-form']//h2")
    private WebElement signUpFormHeader;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='name']")
    private WebElement signUpFormNameTextBox;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='email']")
    private WebElement signUpFormEmailTextBox;

    @FindBy(xpath = "//div[@class='signup-form']//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='login-form']//input[@name='email']")
    private WebElement loginFormEmailTextBox;

    @FindBy(xpath = "//div[@class='login-form']//input[@name='password']")
    private WebElement loginFormPasswordTextBox;

    @FindBy(xpath = "//div[@class='login-form']//button[@data-qa='login-button']")
    private WebElement loginButton;

    @Inject
    private SignUpPage signUpPage;

    @Inject
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getSignupSectionHeader() {
        return getText(signUpFormHeader);
    }

    public void setSignupName(String name) {
        sendKeys(signUpFormNameTextBox, name);
    }

    public void setSignupEmail(String email) {
        sendKeys(signUpFormEmailTextBox, email);
    }

    public SignUpPage clickSignUpButton() {
        click(signUpButton);
        return signUpPage;
    }

    public void setLoginEmail(String email) {
        sendKeys(loginFormEmailTextBox, email);
    }

    public void setLoginPassword(String password) {
        sendKeys(loginFormPasswordTextBox, password);
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return homePage;
    }
}
