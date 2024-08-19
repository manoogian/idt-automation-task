package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement allProductsTitle;

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchProductTextBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private List<WebElement> productNameTexts;

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[text()='Add to cart']")
    private List<WebElement> addProductToCartButtons;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//h2[@class='title text-center'] ")
    private WebElement searchedProductsSectionHeaderText;

    @Inject
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllFoundProductsTitles() {
        List<String> titles = new ArrayList<>();

        for (WebElement productNameText : productNameTexts) {
            titles.add(getText(productNameText));
        }
        return titles;
    }

    public String getProductName(int productIndex) {
        return getText(productNameTexts.get(productIndex));
    }

    public void addProductToCart(int productIndex) {
        click(addProductToCartButtons.get(productIndex));
        click(continueShoppingButton);
    }

    public String getPageTitle() {
        return getText(allProductsTitle);
    }

    public void searchProduct(String productName) {
        sendKeys(searchProductTextBox, productName);
        click(submitSearchButton);
    }

    public String getSearchedProductsHeader() {
        return getText(searchedProductsSectionHeaderText);
    }


}
