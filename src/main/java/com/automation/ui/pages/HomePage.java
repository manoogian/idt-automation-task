package com.automation.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='slider-carousel']//div[@class='item active']//div[@class='col-sm-6']//h2")
    private WebElement carouselActiveItemTitle;

    @Inject
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCarouselVisible() {
        return carouselActiveItemTitle.isDisplayed();
    }

    public String getCarouselTitle() {
        return getText(carouselActiveItemTitle);
    }

}
