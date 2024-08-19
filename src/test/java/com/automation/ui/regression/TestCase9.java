package com.automation.ui.regression;

import com.automation.ui.pages.HomePage;
import com.automation.ui.pages.ProductsPage;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase9 extends BaseTest {

    private static final String EXPECTED_PRODUCTS_PAGE_TITLE = "ALL PRODUCTS";
    private static final String EXPECTED_SEARCHED_PRODUCTS_HEADER = "SEARCHED PRODUCTS";
    private static final String TEST_PRODUCT = "blue";

    @Inject
    private HomePage homePage;

    /**
     * <p>Test Case 9: Search Product</p>
     * <ul>
     *     <li>1. Launch browser</li>
     *     <li>2. Navigate to url '<a href="http://automationexercise.com">http://automationexercise.com</a>'</li>
     *     <li>3. Verify that home page is visible successfully</li>
     *     <li>4. Click on 'Products' button</li>
     *     <li>5. Verify user is navigated to ALL PRODUCTS page successfully</li>
     *     <li>6. Enter product name in search input and click search button</li>
     *     <li>7. Verify 'SEARCHED PRODUCTS' is visible</li>
     *     <li>8. Verify all the products related to search are visible</li>
     * </ul>
     */
    @Test
    public void searchProductTest() {
        navigateToBaseUrl();
        assertTrue(homePage.isCarouselVisible());

        ProductsPage productsPage = homePage.clickOnProductsNavigationButton();
        assertEquals(productsPage.getPageTitle(), EXPECTED_PRODUCTS_PAGE_TITLE);

        productsPage.searchProduct(TEST_PRODUCT);
        assertEquals(productsPage.getSearchedProductsHeader(), EXPECTED_SEARCHED_PRODUCTS_HEADER);

        List<String> allFoundProductsTitles = productsPage.getAllFoundProductsTitles();
        for (String foundProductTitle : allFoundProductsTitles) {
            assertTrue(foundProductTitle.toLowerCase().contains(TEST_PRODUCT), foundProductTitle);
        }
    }
}