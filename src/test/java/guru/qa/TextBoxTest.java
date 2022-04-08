package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        open("https://demoqa.com");

    }

    String firstname = "Zhanna";
    String lastname = "Senchenko";
    String email = "zhanna_senchenko@gmail.com";
    String number = "9856712322";
    String address = "Dybenko St, 6";
    String gender = "Female";

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
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(byText("15")).click();

        $("#subjectsInput").setValue("History").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("cat.jpeg");

        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("[id=submit]").click();

        // check
        $(".modal-body").shouldHave(text(firstname),
                text(lastname),
                text(email),
                text(gender),
                text(number),
                text("15"),
                text("July"),
                text("1990"),
                text("History"),
                text("Reading"),
                text("cat.jpeg"),
                text(address),
                text("Haryana"),
                text("Karnal"));
    }
}
