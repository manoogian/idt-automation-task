package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    private WebElement shoppingCartHeader;

    @FindBy(xpath = "//a[contains(@class,'check_out')]")
    private WebElement proceedToCheckoutButton;

    @Inject
    private CheckoutPage checkoutPage;

    @Inject
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCartHeaderText() {
        return getText(shoppingCartHeader);
    }

    public CheckoutPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return checkoutPage;
    }
}
