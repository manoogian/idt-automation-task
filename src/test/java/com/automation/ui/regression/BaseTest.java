package com.automation.ui.regression;

import com.automation.ui.config.ApplicationUiTestsGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {
    @Inject
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Injector injector = Guice.createInjector(new ApplicationUiTestsGuiceModule());
        injector.injectMembers(this);
        setupDriver();
    }

    private void setupDriver() {
        driver.manage().window().maximize();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void navigateToBaseUrl() {
        navigateTo("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
