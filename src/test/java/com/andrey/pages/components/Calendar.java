package com.andrey.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Calendar {

    private SelenideElement
    dateOfBirthInput = $("#dateOfBirthInput"),
    monthSelect = $(".react-datepicker__month-select"),
    yearSelect = $(".react-datepicker__year-select");

    public void fillDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM,u", Locale.ENGLISH);
        LocalDate parsedDate = LocalDate.parse(date, dateFormatter);
        dateOfBirthInput.click();
        monthSelect.selectOptionByValue(String.valueOf(parsedDate.getMonthValue()-1));
        yearSelect.selectOptionByValue(String.valueOf(parsedDate.getYear()));
        $$(".react-datepicker__day").find(text(String.valueOf(parsedDate.getDayOfMonth()))).click();
    }
}
