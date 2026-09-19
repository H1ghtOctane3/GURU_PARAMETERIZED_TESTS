import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.timeout = 10_000;
//        Configuration.pageLoadTimeout = 60_000;
        Configuration.pageLoadStrategy = "eager";
        open("https://www.aviasales.ru/");
    }
}
