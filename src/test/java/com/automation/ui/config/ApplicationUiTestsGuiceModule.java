package com.automation.ui.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationUiTestsGuiceModule extends AbstractModule {
    @Singleton
    @Provides
    public WebDriver webDriver() {
        return new ChromeDriver();
    }
}
