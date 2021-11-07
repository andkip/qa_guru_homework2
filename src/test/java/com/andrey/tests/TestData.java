package com.andrey.tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

    static Faker faker = new Faker(new Locale("ru"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.numerify("##########"),
            date = "25 December,2021",
            gender = "Male",
            firstLetter = "a",
            subject = "Arts",
            hobby = "Music",
            picturePath = "pict.jpg",
            currentAddress = faker.address().streetAddress(),
            state = "NCR",
            city = "Noida";

    public static Map<String, String> expectedValues = new HashMap<String, String>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", userEmail);
        put("Gender", gender);
        put("Mobile", userNumber);
        put("Date of Birth", date);
        put("Subjects", subject);
        put("Hobbies", hobby);
        put("Picture", picturePath);
        put("Address", currentAddress);
        put("State and City", state + " " + city);
    }};
}
