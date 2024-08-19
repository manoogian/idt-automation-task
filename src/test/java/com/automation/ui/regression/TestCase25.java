package com.automation.ui.regression;

import com.automation.ui.pages.HomePage;
import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase25 extends BaseTest {

    private static final String EXPECTED_TITLE = "Full-Fledged practice website for Automation Engineers";
    private static final String EXPECTED_SUBSCRIPTION_TEXT = "SUBSCRIPTION";

    @Inject
    private HomePage homePage;


    /**
     * <p>Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality</p>
     * <ul>
     *     <li>1. Launch browser</li>
     *     <li>2. Navigate to url '<a href="http://automationexercise.com">http://automationexercise.com</a>'</li>
     *     <li>3. Verify that home page is visible successfully</li>
     *     <li>4. Scroll down page to bottom</li>
     *     <li>5. Verify 'SUBSCRIPTION' is visible</li>
     *     <li>6. Click on arrow at bottom right side to move upward</li>
     *     <li>7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen</li>
     * </ul>
     */
    @Test
    public void scrollUpWithoutArrowButtonAndScrollDownTest() {

        navigateToBaseUrl();
        homePage.isCarouselVisible();

        homePage.scrollToSubscriptionText();
        Assert.assertEquals(homePage.getSubscriptionText(), EXPECTED_SUBSCRIPTION_TEXT);

        homePage.scrollToTop();
        homePage.isCarouselVisible();
        Assert.assertEquals(homePage.getCarouselTitle(), EXPECTED_TITLE);

    }
}
