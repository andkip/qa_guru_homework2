package com.andrey.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:config/${environment}.properties")

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("96.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/automation-practice-form")
    String getBaseUrl();

    @Key("remoteDriver")
    URL getRemoteDriver();
}