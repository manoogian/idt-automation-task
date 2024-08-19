package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    @FindBy(xpath = "//li/a[@href='/']")
    protected WebElement homePageButton;

    @FindBy(xpath = "//li/a[@href='/products']")
    protected WebElement productsPageButton;

    @FindBy(xpath = "//li/a[@href='/view_cart']")
    protected WebElement cartPageButton;

    @FindBy(xpath = "//li/a[@href='/login']")
    protected WebElement loginPageButton;

    @FindBy(xpath = "//li/a[@href='/logout']")
    protected WebElement logoutButton;

    @FindBy(xpath = "//li/a[@href='/delete_account']")
    protected WebElement deleteAccountButton;

    @FindBy(xpath = "//*[text()=' Logged in as ']/b")
    private WebElement loggedInUserNameText;

    @FindBy(xpath = "//div[@class='single-widget']//h2[text()='Subscription']")
    protected WebElement subscriptionText;

    @FindBy(xpath = "//a[@id='scrollUp']")
    protected WebElement scrollUpButton;

    @FindBy(xpath = "//div[@class='grippy-host']//ins/span/svg")
    protected WebElement adBannerCollapseButton;

    protected final WebDriver driver;
    private final WebDriverWait wait;
    protected Actions actions;

    @Inject
    protected HomePage homePage;
    @Inject
    protected ProductsPage productsPage;
    @Inject
    protected CartPage cartPage;
    @Inject
    protected LoginPage loginPage;
    @Inject
    protected AccountDeletedPage accountDeletedPage;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.actions = new Actions(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage clickOnHomeNavigationButton() {
        click(homePageButton);
        return homePage;
    }

    public ProductsPage clickOnProductsNavigationButton() {
        click(productsPageButton);
        return productsPage;
    }

    public CartPage clockOnCartNavigationButton() {
        click(cartPageButton);
        return cartPage;
    }

    public LoginPage clickOnLoginNavigationButton() {
        click(loginPageButton);
        return loginPage;
    }

    public void scrollToTop() {
        click(scrollUpButton);
    }

    public String getSubscriptionText() {
        return getText(subscriptionText);
    }

    public String getLoggedInUserName() {
        return getText(loggedInUserNameText);
    }

    public AccountDeletedPage clickOnDeleteAccountNavigationButton() {
        click(deleteAccountButton);
        return accountDeletedPage;
    }

    public LoginPage clickOnLogoutNavigationButton() {
        click(logoutButton);
        return loginPage;
    }

    public void scrollToSubscriptionText() {
        actions.scrollToElement(subscriptionText).perform();
    }

    public void triggerAdBannerExpandOrCollapseButton() {
        // TODO
    }

    protected String getText(WebElement source) {
        return waitForElementToBeVisible(source).getText();
    }

    protected void click(WebElement target) {
        waitForElementToBeClickable(target).click();
    }

    protected void sendKeys(WebElement target, String text) {
        waitForElementToBeClickable(target).sendKeys(text);
    }

    protected void clear(WebElement target) {
        waitForElementToBeVisible(target).clear();
    }

    protected WebElement waitForElementToBeVisible(WebElement targetElement) {
        return wait.until(ExpectedConditions.visibilityOf(targetElement));
    }

    protected WebElement waitForElementToBeClickable(WebElement targetElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(targetElement));
    }
}
