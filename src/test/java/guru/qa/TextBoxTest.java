package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Zhanna");
        $("#lastName").setValue("Senchenko");
        $("#userEmail").setValue("zhanna_senchenko@gmail.com");

        $("#genterWrapper").$(byText("Female")).click();

        $("#userNumber").setValue("9856712322");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(byText("15")).click();

        $("#subjectsInput").setValue("History").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("cat.jpg");

        $("#currentAddress-wrapper").setValue("Starovatutinskij proezd 15");



    }
}
