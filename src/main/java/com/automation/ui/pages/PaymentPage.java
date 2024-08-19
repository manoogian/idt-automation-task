package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    private WebElement nameOnCardTextBox;

    @FindBy(xpath = "//input[@data-qa='card-number']")
    private WebElement cardNumberTextBox;

    @FindBy(xpath = "//input[@data-qa='cvc']")
    private WebElement cvcTextBox;

    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    private WebElement expirationMonthTextBox;

    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    private WebElement expirationYearTextBox;

    @FindBy(xpath = "//button[@data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @Inject
    private OrderPlacedPage orderPlacedPage;

    @Inject
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void setNameOnCard(String name) {
        sendKeys(nameOnCardTextBox, name);
    }

    public void setCardNumber(String cardNumber) {
        sendKeys(cardNumberTextBox, cardNumber);
    }

    public void setCvc(String cvc) {
        sendKeys(cvcTextBox, cvc);
    }

    public void setExpirationMonth(String expirationMonth) {
        sendKeys(expirationMonthTextBox, expirationMonth);
    }

    public void setExpirationYear(String expirationYear) {
        sendKeys(expirationYearTextBox, expirationYear);
    }

    public OrderPlacedPage clickPayAndConfirmOrderButton() {
        click(payAndConfirmOrderButton);
        return orderPlacedPage;
    }
}
