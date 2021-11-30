package com.andrey.tests;

import com.andrey.pages.DemoQAFormPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DemoQAFormTests extends BaseTest {

    DemoQAFormPage demoQAFormPage = new DemoQAFormPage();

    @Test
    @Tag("Passed")
    @DisplayName("Заполнение тестовой формы DemoQA и проверка соответствия данных")
    void selenideSearchTest() {
        demoQAFormPage.openPage()
                .typeFirstName(TestData.firstName)
                .typeLastName(TestData.lastName)
                .typeUserEmail(TestData.userEmail)
                .chooseGender(TestData.gender)
                .typeUserNumber(TestData.userNumber)
                .setDate(TestData.date)
                .chooseSubject(TestData.firstLetter, TestData.subject)
                .chooseHobby(TestData.hobby)
                .uploadPicture(TestData.picturePath)
                .typeAddress(TestData.currentAddress)
                .chooseState(TestData.state)
                .chooseCity(TestData.city)
                .clickSubmit()
                .checkFields(TestData.expectedValues);
    }

    @Test
    @Tag("Failed")
    @DisplayName("Заполнение тестовой формы DemoQA и проверка соответствия некорректных данных")
    void selenideSearchTest2() {
        demoQAFormPage.openPage()
                .typeFirstName(TestData.firstName)
                .typeLastName(TestData.lastName)
                .typeUserEmail(TestData.userEmail)
                .chooseGender(TestData.gender)
                .typeUserNumber(TestData.userNumber)
                .setDate(TestData.date)
                .chooseSubject(TestData.firstLetter, TestData.subject)
                .chooseHobby(TestData.hobby)
                .uploadPicture(TestData.picturePath)
                .typeAddress("Failed Information")
                .chooseState(TestData.state)
                .chooseCity(TestData.city)
                .clickSubmit()
                .checkFields(TestData.expectedValues);
    }

    @Disabled
    @Test
    @Tag("Skipped")
    @DisplayName("Пропуск - Заполнение тестовой формы DemoQA и проверка соответствия данных")
    void selenideSearchTest3() {
        demoQAFormPage.openPage()
                .typeFirstName(TestData.firstName)
                .typeLastName(TestData.lastName)
                .typeUserEmail(TestData.userEmail)
                .chooseGender(TestData.gender)
                .typeUserNumber(TestData.userNumber)
                .setDate(TestData.date)
                .chooseSubject(TestData.firstLetter, TestData.subject)
                .chooseHobby(TestData.hobby)
                .uploadPicture(TestData.picturePath)
                .typeAddress(TestData.currentAddress)
                .chooseState(TestData.state)
                .chooseCity(TestData.city)
                .clickSubmit()
                .checkFields(TestData.expectedValues);
    }
}
