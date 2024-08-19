package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//ul[@class='address item box']//li[@class='address_firstname address_lastname']")
    private WebElement firstAndLastNameText;

    @FindBy(xpath = "(//ul[@class='address item box']//li[@class='address_address1 address_address2'])[1]")
    private WebElement companyNameText;

    @FindBy(xpath = "//ul[@class='address item box']//li[@class='address_country_name']")
    private WebElement countryText;

    @FindBy(xpath = "//ul[@class='address item box']//li[@class='address_phone']")
    private WebElement phoneNumberText;

    @FindBy(xpath = "//td[@class='cart_description']//a")
    private WebElement orderDescription;

    @FindBy(xpath = "//div[@id='ordermsg']//textarea[@name='message']")
    private WebElement commentMessageTextBox;

    @FindBy(xpath = "//a[contains(@class, 'btn') and text()='Place Order']")
    private WebElement placeOrderButton;

    @Inject
    private PaymentPage paymentPage;

    @Inject
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstAndLastName() {
        return getText(firstAndLastNameText);
    }

    public String getCompanyName() {
        return getText(companyNameText);
    }

    public String getCountry() {
        return getText(countryText);
    }

    public String getPhoneNumber() {
        return getText(phoneNumberText);
    }

    public String getOrderDescription() {
        return getText(orderDescription);
    }

    public void setCommentMessage(String message) {
        clear(commentMessageTextBox);
        sendKeys(commentMessageTextBox, message);
    }

    public PaymentPage clickPlaceOrderButton() {
        actions.scrollToElement(placeOrderButton).perform();
        click(placeOrderButton);
        return paymentPage;
    }
}
