package com.andrey.pages;

import com.andrey.config.WebConfig;
import com.andrey.pages.components.Calendar;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQAFormPage {

    WebConfig web = ConfigFactory.create(WebConfig.class);

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
    @Step("Открыть страницу demoqa.com")
    public DemoQAFormPage openPage() {
        open(web.getBaseUrl());
        title.shouldHave(text(TITLE));
        return this;
    }

    @Step("Заполнить поле First Name данными: \"{0}\"")
    public DemoQAFormPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("Заполнить поле Last Name данными: \"{0}\"")
    public DemoQAFormPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Заполнить поле User Email данными: \"{0}\"")
    public DemoQAFormPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Заполнить поле Gender данными: \"{0}\"")
    public DemoQAFormPage chooseGender(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Заполнить поле User Number данными: \"{0}\"")
    public DemoQAFormPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    @Step("Выбрать в календаре дату: \"{0}\"")
    public DemoQAFormPage setDate(String date) {
        calendar.fillDate(date);
        return this;
    }

    @Step("Ввести первую букву \"{0}\" и выбрать предмет: \"{1}\"")
    public DemoQAFormPage chooseSubject(String firstLetter, String subject) {
        subjectsInput.setValue(firstLetter);
        $(byText(subject)).click();
        return this;
    }

    @Step("Выбрать хобби: \"{0}\"")
    public DemoQAFormPage chooseHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Выполнить загрузку картинки \"{0}\" на сайт")
    public DemoQAFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Заполнить поле Address данными: \"{0}\"")
    public DemoQAFormPage typeAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбрать штат: \"{0}\"")
    public DemoQAFormPage chooseState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать город: \"{0}\"")
    public DemoQAFormPage chooseCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Нажать Submit")
    public DemoQAFormPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверить соответствие данных в полях: \"{0}\"")
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
