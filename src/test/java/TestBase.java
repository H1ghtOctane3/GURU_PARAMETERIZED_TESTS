import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        open("https://www.aviasales.ru/");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 60_000;
        Configuration.pageLoadStrategy = "eager";
    }
}
