package com.automation.ui.regression;

import com.automation.ui.pages.*;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.automation.ui.data.TestData.UserSignUpData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase1 extends BaseTest {

    public static final String TEST_SIGNUP_NAME = SIGNUP_NAME + UUID.randomUUID();
    public static final String TEST_SIGNUP_EMAIL = UUID.randomUUID() + SIGNUP_EMAIL;
    public static final String EXPECTED_SIGNUP_SECTION_HEADER = "New User Signup!";
    public static final String EXPECTED_ACCOUNT_INFORMATION_SECTION_TITLE = "ENTER ACCOUNT INFORMATION";
    public static final String EXPECTED_ACCOUNT_CREATED_TEXT = "ACCOUNT CREATED!";
    public static final String EXPECTED_ACCOUNT_DELETED_TEXT = "ACCOUNT DELETED!";

    @Inject
    private HomePage homePage;

    /**
     * <p>Test Case 1: Register User</p>
     * <ul>
     *     <li>1. Launch browser</li>
     *     <li>2. Navigate to url '<a href="http://automationexercise.com">http://automationexercise.com</a>'</li>
     *     <li>3. Verify that home page is visible successfully</li>
     *     <li>4. Click on 'Signup / Login' button</li>
     *     <li>5. Verify 'New User Signup!' is visible</li>
     *     <li>6. Enter name and email address</li>
     *     <li>7. Click 'Signup' button</li>
     *     <li>8. Verify that 'ENTER ACCOUNT INFORMATION' is visible</li>
     *     <li>9. Fill details: Title, Name, Email, Password, Date of birth</li>
     *     <li>10. Select checkbox 'Sign up for our newsletter!'</li>
     *     <li>11. Select checkbox 'Receive special offers from our partners!'</li>
     *     <li>12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number</li>
     *     <li>13. Click 'Create Account' button</li>
     *     <li>14. Verify that 'ACCOUNT CREATED!' is visible</li>
     *     <li>15. Click 'Continue' button</li>
     *     <li>16. Verify that 'Logged in as username' is visible</li>
     *     <li>17. Click 'Delete Account' button</li>
     *     <li>18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button</li>
     * </ul>
     */
    @Test
    public void registerUserTest() throws Exception {
        navigateToBaseUrl();
        assertTrue(homePage.isCarouselVisible());

        LoginPage loginPage = homePage.clickOnLoginNavigationButton();
        assertEquals(loginPage.getSignupSectionHeader(), EXPECTED_SIGNUP_SECTION_HEADER);

        loginPage.setSignupName(TEST_SIGNUP_NAME);
        loginPage.setSignupEmail(TEST_SIGNUP_EMAIL);
        SignUpPage signUpPage = loginPage.clickSignUpButton();

        assertEquals(signUpPage.getAccountInformationSectionTitle(), EXPECTED_ACCOUNT_INFORMATION_SECTION_TITLE);

        signUpPage.setPersonTitle(USER_TITLE);
        signUpPage.setPassword(SIGNUP_PASSWORD);
        signUpPage.setDateOfBirth(USER_BIRTH_DATE);
        signUpPage.toggleSighUpForNewsletterCheckbox();
        signUpPage.toggleReceiveSpecialOffersCheckBox();
        signUpPage.setFirstName(USER_FIRSTNAME);
        signUpPage.setLastName(USER_LASTNAME);
        signUpPage.setCompanyName(COMPANY);
        signUpPage.setAddress1(ADDRESS_1);
        signUpPage.setAddress2(ADDRESS_2);
        signUpPage.setCountry(COUNTRY);
        signUpPage.setState(STATE);
        signUpPage.setCity(CITY);
        signUpPage.setZipcode(ZIP);
        signUpPage.setMobileNumber(MOBILE_NUMBER);
        AccountCreatedPage accountCreatedPage = signUpPage.clickCreateAccountButton();

        assertEquals(accountCreatedPage.getAccountCreatedText(), EXPECTED_ACCOUNT_CREATED_TEXT);
        homePage = accountCreatedPage.clickContinueButton();

        assertEquals(homePage.getLoggedInUserName(), TEST_SIGNUP_NAME);
        AccountDeletedPage accountDeletedPage = homePage.clickOnDeleteAccountNavigationButton();
        assertEquals(accountDeletedPage.getAccountDeletedText(), EXPECTED_ACCOUNT_DELETED_TEXT);
    }

}
