import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class tests {

    @Test
    void successfulSearchTest() {

        open("https://www.google.com/");
        Configuration.timeout = 10000;
        $("[name=q]").setValue("selenide").pressEnter();
        $("iframe[title='reCAPTCHA']").shouldBe(visible);
        switchTo().frame($("iframe[title='reCAPTCHA']"));
        $x("//span[@role='checkbox']").shouldBe(visible).click();
        switchTo().defaultContent();
        $("[id=search]").shouldBe(visible, Duration.ofSeconds(60));
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }
}
