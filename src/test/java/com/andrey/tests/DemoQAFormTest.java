package com.andrey.tests;

import com.andrey.pages.DemoQAFormPage;
import org.junit.jupiter.api.Test;

public class DemoQAFormTest extends BaseTest {

    DemoQAFormPage demoQAFormPage = new DemoQAFormPage();

    @Test
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
}
