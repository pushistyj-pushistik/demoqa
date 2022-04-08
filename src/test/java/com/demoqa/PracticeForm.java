package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        open("https://demoqa.com");
    }

    String firstname = "Zhanna";
    String lastname = "Senchenko";
    String email = "me@gmail.com";
    String number = "9852222222";
    String address = "Dybenko St, 6";
    String gender = "Female";
    String picture = "cat.jpeg";
    String day = "15";
    String month = "July";
    String year = "1990";
    String subject = "History";
    String hobby = "Reading";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        Selenide.zoom(0.75);
        Selenide.executeJavaScript(
                "document.querySelector(\"footer\").hidden = 'true';" +
                        "document.querySelector(\"#fixedban\").hidden = 'true'");

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);

        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byText(day)).click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();


        $(".modal-body").shouldHave
                (text(firstname),
                text(lastname),
                text(email),
                text(gender),
                text(number),
                text(day),
                text(month),
                text(year),
                text(subject),
                text(hobby),
                text(picture),
                text(address),
                text(state),
                text(city));
    }
}
