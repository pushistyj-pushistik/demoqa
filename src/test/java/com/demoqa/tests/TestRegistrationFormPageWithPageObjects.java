package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestRegistrationFormPageWithPageObjects {
    RegistrationFormPage RegistrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String  firstname = faker.name().firstName(),
            lastname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            address = faker.address().streetAddress(),
            gender = "Female",
            number = "9852123344",
            picture = "cat.jpeg",
            day = "15",
            month = "July",
            year = "1990",
            subject = "History",
            hobby = "Reading",
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
        RegistrationFormPage.openPage();
        RegistrationFormPage.setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .setUploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        RegistrationFormPage.checkResult(firstname)
                .checkResult(lastname)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(number)
                .checkResult(day)
                .checkResult(month)
                .checkResult(year)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(picture)
                .checkResult(address)
                .checkResult(state)
                .checkResult(city);
    }

}
