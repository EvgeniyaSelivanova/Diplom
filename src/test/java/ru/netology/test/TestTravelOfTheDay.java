package ru.netology.test;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DataPart;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTravelOfTheDay {

    @BeforeEach
    void loadPage() {
        open("http://localhost:8080");
    }

    @Test
    void checkingButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        $("[class='heading heading_size_m heading_theme_alfa-on-white']")
                .shouldHave(exactText("Оплата по карте")).shouldBe(visible);
    }

    @Test
    void checkingButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        $("[class='heading heading_size_m heading_theme_alfa-on-white']")
                .shouldHave(exactText("Кредит по данным карты")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertInvalidCardDataTextAndNumberButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInvalidCardDataTextAndNumber();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataTextAndNumberButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInvalidCardDataTextAndNumber();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataEmptyButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInvalidCardDataEmpty();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataEmptyButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInvalidCardDataEmpty();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataPartialDataButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInvalidCardDataPartialData();
        DataPart.insertData(cardData);
        SelenideElement cardMonthSubBox = form.$$(".input__inner .input__top").find(exactText("Год")).shouldBe(visible);
        cardMonthSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Неверный формат")).shouldBe(visible);
        SelenideElement cardNameSubBox = form.$$(".input__inner .input__top").find(exactText("Владелец")).shouldBe(visible);
        cardNameSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        SelenideElement cardCVVSubBox = form.$$(".input__inner .input__top").find(exactText("CVC/CVV")).shouldBe(visible);
        cardCVVSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataPartialDataButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInvalidCardDataPartialData();
        DataPart.insertData(cardData);
        SelenideElement cardMonthSubBox = form.$$(".input__inner .input__top").find(exactText("Год")).shouldBe(visible);
        cardMonthSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Неверный формат")).shouldBe(visible);
        SelenideElement cardNameSubBox = form.$$(".input__inner .input__top").find(exactText("Владелец")).shouldBe(visible);
        cardNameSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        SelenideElement cardCVVSubBox = form.$$(".input__inner .input__top").find(exactText("CVC/CVV")).shouldBe(visible);
        cardCVVSubBox.parent().$(".input__inner .input__sub").shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertValidCardDataBigNameButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataBigName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataBigNameButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataBigName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataSmallNameButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataSmallName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataSmallNameButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataSmallName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataHyphenNameButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataHyphenName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataHyphenNameButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataHyphenName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertInvalidCardDataSpecialSymbolsButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataSpecialSymbols();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataSpecialSymbolsButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataSpecialSymbols();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Поле обязательно для заполнения")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataMaxLengthButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataMaxLength();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Значение поля не может быть длиннее 64 символов")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataMaxLengthsButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataMaxLength();
        DataPart.insertData(cardData);
        DataPart.cardNumberSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardMonthSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardYearSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.cardNameSubBox.shouldHave(exactText("Значение поля не может быть длиннее 64 символов")).shouldBe(visible);
        DataPart.cardCVVSubBox.shouldHave(exactText("Неверный формат")).shouldBe(visible);
        DataPart.buttonContinue.shouldHave(exactText("Продолжить")).shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__box")
                .shouldHave(cssValue("border-bottom-color", "rgba(255, 92, 92, 0.85)"));
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        assertEquals("", DataPart.cardNumber.getValue());
        assertEquals("", DataPart.cardMonth.getValue());
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertValidCardDataWithInformApprovedButtonBuy() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Успешно"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Операция одобрена Банком."))
                .shouldBe(visible, Duration.ofSeconds(20));
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("APPROVED", DataHelper.getStatusAddedPaymentEntity());
    }

    @Test
    void insertValidCardDataWithInformApprovedButtonBuyInCredit() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Успешно"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Операция одобрена Банком."))
                .shouldBe(visible, Duration.ofSeconds(20));
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("APPROVED", DataHelper.getStatusAddedCreditRequestEntity());
    }

    @Test
    void insertValidCardDataWithInformDeclinedButtonBuy() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataDeclined();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Успешно"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Операция одобрена Банком."))
                .shouldBe(visible, Duration.ofSeconds(20));
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("DECLINED", DataHelper.getStatusAddedPaymentEntity());
    }

    @Test
    void insertValidCardDataWithInformDeclinedButtonBuyInCredit() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataDeclined();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Успешно"))
                .shouldBe(visible, Duration.ofSeconds(20));
        form.$(".notification__content").shouldHave(exactText("Операция одобрена Банком."))
                .shouldBe(visible, Duration.ofSeconds(20));
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("DECLINED", DataHelper.getStatusAddedCreditRequestEntity());
    }

    @Test
    void insertValidCardDataNotFromListButtonBuy() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataNotFromList();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Ошибка"))
                .shouldBe(visible, Duration.ofSeconds(15));
        form.$(".notification__content").shouldHave(exactText("Ошибка! Банк отказал в проведении операции."))
                .shouldBe(visible, Duration.ofSeconds(15));
        assertEquals(firstCountOrderEntity, DataHelper.getOrderEntity());
    }

    @Test
    void insertValidCardDataNotFromListButtonBuyInCredit() {
        int firstCountOrderEntity = DataHelper.getOrderEntity();
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataNotFromList();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        form.$(".notification__title").shouldHave(exactText("Ошибка"))
                .shouldBe(visible, Duration.ofSeconds(15));
        form.$(".notification__content").shouldHave(exactText("Ошибка! Банк отказал в проведении операции."))
                .shouldBe(visible, Duration.ofSeconds(15));
        assertEquals(firstCountOrderEntity, DataHelper.getOrderEntity());
    }

    @Test
    void insertInvalidCardDataPreviousMonthButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataPreviousMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @Test
    void insertInvalidCardDataPreviousMonthButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataPreviousMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @Test
    void insertInvalidCardDataIncorrectYearButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectYear();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Истёк срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @Test
    void insertInvalidCardDataIncorrectYearButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectYear();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Истёк срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @Test
    void insertInvalidCardDataIncorrectMonthButtonBuy() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @Test
    void insertInvalidCardDataIncorrectMonthButtonBuyInCredit() {
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        $(".input_theme_alfa-on-white.input_invalid .input__sub")
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    @AfterAll
    static void clearDataBase() {
        DataHelper.clearAllInAuthCodes();
    }

}
