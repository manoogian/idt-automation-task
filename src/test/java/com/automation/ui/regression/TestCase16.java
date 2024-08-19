package com.automation.ui.regression;

import com.automation.ui.pages.*;
import com.automation.ui.service.Preconditions;
import com.automation.ui.service.UserLoginDetails;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static com.automation.ui.data.TestData.CardData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase16 extends BaseTest {

    private static final String EXPECTED_USERNAME = "TestName";
    private static final String EXPECTED_SHOPPING_CART_HEADER = "Shopping Cart";
    private static final String EXPECTED_TEST_COMPANY_NAME = "TestCompany";
    private static final String EXPECTED_TEST_USER_FIRST_NAME = "TestFirstName";
    private static final String EXPECTED_TEST_USER_LAST_NAME = "TestLastName";
    private static final String EXPECTED_ORDER_PLACED_MESSAGE = "ORDER PLACED!";
    private static final String EXPECTED_ACCOUNT_DELETED_MESSAGE = "ACCOUNT DELETED!";
    private static final String COMMENT_MESSAGE = "Test comment message";

    @Inject
    private HomePage homePage;

    /**
     * <p>Test Case 16: Place Order: Login before Checkout</p>
     * <ul>
     *     <li>1. Launch browser</li>
     *     <li>2. Navigate to url '<a href="http://automationexercise.com">http://automationexercise.com</a>'</li>
     *     <li>3. Verify that home page is visible successfully</li>
     *     <li>4. Click 'Signup / Login' button</li>
     *     <li>5. Fill email, password and click 'Login' button</li>
     *     <li>6. Verify 'Logged in as username' at top</li>
     *     <li>7. Add products to cart</li>
     *     <li>8. Click 'Cart' button</li>
     *     <li>9. Verify that cart page is displayed</li>
     *     <li>10. Click 'Proceed To Checkout' button</li>
     *     <li>11. Verify Address Details and Review Your Order</li>
     *     <li>12. Enter description in comment text area and click 'Place Order' button</li>
     *     <li>13. Enter payment details: Name on Card, Card Number, CVC, Expiration date</li>
     *     <li>14. Click 'Pay and Confirm Order' button</li>
     *     <li>15. Verify success message 'Your order has been placed successfully!'</li>
     *     <li>16. Click 'Delete Account' button</li>
     *     <li>17. Verify 'ACCOUNT DELETED!' and click 'Continue' button</li>
     * </ul>
     */
    @Test
    public void placeOrderLoginBeforeCheckoutTest() {

        // Create User via API call
        UserLoginDetails createdUser = Preconditions.createDefaultUser();

        navigateToBaseUrl();
        assertTrue(homePage.isCarouselVisible());

        LoginPage loginPage = homePage.clickOnLoginNavigationButton();
        loginPage.setLoginEmail(createdUser.getEmail());
        loginPage.setLoginPassword(createdUser.getPassword());
        homePage = loginPage.clickLoginButton();

        assertEquals(homePage.getLoggedInUserName(), EXPECTED_USERNAME);

        ProductsPage productsPage = homePage.clickOnProductsNavigationButton();
        String selectedProductName = productsPage.getProductName(1).replace("  ", " ");
        productsPage.addProductToCart(1);

        CartPage cartPage = productsPage.clockOnCartNavigationButton();
        assertEquals(cartPage.getShoppingCartHeaderText(), EXPECTED_SHOPPING_CART_HEADER);

        CheckoutPage checkoutPage = cartPage.clickProceedToCheckoutButton();
        assertEquals(checkoutPage.getCompanyName(), EXPECTED_TEST_COMPANY_NAME);
        assertEquals(checkoutPage.getOrderDescription(), selectedProductName);

        checkoutPage.setCommentMessage(COMMENT_MESSAGE);

        PaymentPage paymentPage = checkoutPage.clickPlaceOrderButton();
        paymentPage.setNameOnCard(EXPECTED_TEST_USER_FIRST_NAME + " " + EXPECTED_TEST_USER_LAST_NAME);
        paymentPage.setCardNumber(CARD_NUMBER);
        paymentPage.setCvc(CARD_CVC);
        paymentPage.setExpirationMonth(CARD_EXPIRATION_MONTH);
        paymentPage.setExpirationYear(CARD_EXPIRATION_YEAR);

        OrderPlacedPage orderPlacedPage = paymentPage.clickPayAndConfirmOrderButton();
        assertEquals(orderPlacedPage.getOrderPlacedMessageText(), EXPECTED_ORDER_PLACED_MESSAGE);

        AccountDeletedPage accountDeletedPage = orderPlacedPage.clickOnDeleteAccountNavigationButton();
        assertEquals(accountDeletedPage.getAccountDeletedText(), EXPECTED_ACCOUNT_DELETED_MESSAGE);
        homePage = accountDeletedPage.clickContinueButton();
        assertTrue(homePage.isCarouselVisible());

    }
}