package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPlacedPage extends BasePage {

    @FindBy(xpath = "//h2[@data-qa='order-placed']/b")
    private WebElement orderPlacedMessageText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @Inject
    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderPlacedMessageText() {
        return getText(orderPlacedMessageText);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return homePage;
    }
}
