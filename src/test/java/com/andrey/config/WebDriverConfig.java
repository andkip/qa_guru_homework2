package com.andrey.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

public class WebDriverConfig {
    private WebConfig config;

    public WebDriverConfig() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(config.getRemoteDriver())) {
            if (config.getBrowser().equals(Browser.FIREFOX)) {
                return new FirefoxDriver();
            }
            if (config.getBrowser().equals(Browser.CHROME)) {
                return new ChromeDriver();
            }
        } else {
            return new RemoteWebDriver(config.getRemoteDriver(), DesiredCapabilities.chrome());
        }
        throw new NullPointerException();
    }
}