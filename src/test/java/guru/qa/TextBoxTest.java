package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        $("[id=firstName]").setValue("Zhanna");
        $("[id=lastName]").setValue("Senchenko");
        $("[id=userEmail]").setValue("zhanna_senchenko@gmail.com");
    }
}
