package ru.netology.functionalForm;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataPart;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckForm {
    public static SelenideElement form = $("[class='App_appContainer__3jRx1']");

    public static void Color() {
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public static void InvalidData() {
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
    }

    public static void InvalidLongData() {
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Значение поля не может быть длиннее 64 символов")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
    }

    public static void AssertEmptyData() {
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    public static void NotificationSuccess() {
        form.$(".notification__title").shouldHave(exactText("Успешно"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Операция одобрена Банком."))
                .shouldBe(visible, Duration.ofSeconds(20));
    }

    public static void NotificationUnSuccess() {
        form.$(".notification__title").shouldHave(exactText("Ошибка"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Ошибка! Банк отказал в проведении операции."))
                .shouldBe(visible, Duration.ofSeconds(20));
    }

}
