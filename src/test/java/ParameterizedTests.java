import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ParameterizedTests extends TestBase {

    static Stream<Arguments> checkCities(){
        return Stream.of(
                Arguments.of(CityEnum.MOSCOW),
                Arguments.of(CityEnum.SAINTPETERSBURG),
                Arguments.of(CityEnum.SOCHI),
                Arguments.of(CityEnum.KALININGRAD)
        );
    }
    @Order(1)
    @ParameterizedTest(name = "Услуга «{0}» содержит описание: «{1}»")
    @CsvSource(value =  {
            "Избранное   | Жмите на сердечко",
            "Впечатления | Впечатления",
            "Авиабилеты  | Тут покупают дешёвые авиабилеты",
            "Отели       | Здесь бронируют балдёжные отели",
    }, delimiter = '|')
    void service(String service, String expectedText) {
        $$("a").findBy(text(service)).click();
        $("body").shouldHave(text(expectedText));
    }
    @Order(3)
    @ParameterizedTest(name = "Город: {0}")
    @MethodSource("checkCities")
    void checkCity(CityEnum city) {
        SelenideElement cityLink = $$("a, button, h2, h3, span")
                .findBy(text(city.getTitle()));
        cityLink.scrollTo();
        cityLink.shouldBe(visible);
    }
    @Order(2)
    @ParameterizedTest(name = "Отоображаются кнопки: {0}")
    @ValueSource(strings = {"Профиль", "Журнал", "Поддержка", "rub"})
    void visionOfServices(String services) {
        $(byText(services)).shouldBe(visible);
    }
}