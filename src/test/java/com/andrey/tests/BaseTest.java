package com.andrey.tests;

import com.andrey.pages.DemoQAFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    DemoQAFormPage demoQAFormPage = new DemoQAFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }
}
