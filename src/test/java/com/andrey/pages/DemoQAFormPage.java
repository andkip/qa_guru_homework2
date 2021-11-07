package com.andrey.pages;

import com.andrey.pages.components.Calendar;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQAFormPage {

    // locators & elements
    private final String TITLE = "Student Registration Form";
    private SelenideElement
            title = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");
    public Calendar calendar = new Calendar();

    // actions
    public DemoQAFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        title.shouldHave(text(TITLE));
        return this;
    }

    public DemoQAFormPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public DemoQAFormPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public DemoQAFormPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public DemoQAFormPage chooseGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public DemoQAFormPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public DemoQAFormPage setDate(String date) {
        calendar.fillDate(date);
        return this;
    }

    public DemoQAFormPage chooseSubject(String firstLetter, String subject) {
        subjectsInput.setValue(firstLetter);
        $(byText(subject)).click();
        return this;
    }

    public DemoQAFormPage chooseHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    public DemoQAFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public DemoQAFormPage typeAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public DemoQAFormPage chooseState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public DemoQAFormPage chooseCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public DemoQAFormPage clickSubmit() {
        submit.click();
        return this;
    }

    public DemoQAFormPage checkFields(Map<String, String> expectedValues) {
        ElementsCollection rows = $$("tbody tr");
        for (SelenideElement row : rows) {
            String key = row.$("td").text();
            String expectedValue = expectedValues.get(key);
            String actualValue = row.$("td", 1).text();
            assertEquals(expectedValue, actualValue, "Actual value is not equal to expected");
        }
        return this;
    }
}