package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage {


    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @Inject
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountDeletedText() {
        return getText(accountDeletedText);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return homePage;
    }

}
