package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @Inject
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedText() {
        return getText(accountCreatedText);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return homePage;
    }


}
