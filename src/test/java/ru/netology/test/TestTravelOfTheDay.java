package ru.netology.test;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DataPart;
import ru.netology.functionalForm.CheckForm;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTravelOfTheDay {
    public SelenideElement form = $("[class='App_appContainer__3jRx1']");
    public int firstCountOrderEntity = DataHelper.getOrderEntity();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void loadPage() {
        open("http://localhost:8080");
    }


    @Test
    void checkingButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        $("[class='heading heading_size_m heading_theme_alfa-on-white']")
                .shouldHave(exactText("Оплата по карте")).shouldBe(visible);
    }

    @Test
    void checkingButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        $("[class='heading heading_size_m heading_theme_alfa-on-white']")
                .shouldHave(exactText("Кредит по данным карты")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertInvalidCardDataTextAndNumberButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInvalidCardDataTextAndNumber();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataTextAndNumberButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInvalidCardDataTextAndNumber();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataEmptyButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInvalidCardDataEmpty();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataEmptyButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInvalidCardDataEmpty();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataPartialDataButtonBuy() {
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
        CheckForm.Color();
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertInvalidCardDataPartialDataButtonBuyInCredit() {
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
        CheckForm.Color();
        assertEquals("", DataPart.cardYear.getValue());
        assertEquals("", DataPart.cardName.getValue());
        assertEquals("", DataPart.cardCVV.getValue());
    }

    @Test
    void insertValidCardDataBigNameButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataBigName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataBigNameButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataBigName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataSmallNameButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataSmallName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataSmallNameButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataSmallName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataHyphenNameButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataHyphenName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertValidCardDataHyphenNameButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataHyphenName();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
    }

    @Test
    void insertInvalidCardDataSpecialSymbolsButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataSpecialSymbols();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataSpecialSymbolsButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataSpecialSymbols();
        DataPart.insertData(cardData);
        CheckForm.InvalidData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataMaxLengthButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataMaxLength();
        DataPart.insertData(cardData);
        CheckForm.InvalidLongData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertInvalidCardDataMaxLengthsButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataMaxLength();
        DataPart.insertData(cardData);
        CheckForm.InvalidLongData();
        CheckForm.Color();
        CheckForm.AssertEmptyData();
    }

    @Test
    void insertValidCardDataWithInformApprovedButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationSuccess();
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("APPROVED", DataHelper.getStatusAddedPaymentEntity());
    }

    @Test
    void insertValidCardDataWithInformApprovedButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardData();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationSuccess();
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("APPROVED", DataHelper.getStatusAddedCreditRequestEntity());
    }

    @Test
    void insertValidCardDataWithInformDeclinedButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataDeclined();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationUnSuccess();
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("DECLINED", DataHelper.getStatusAddedPaymentEntity());
    }

    @Test
    void insertValidCardDataWithInformDeclinedButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataDeclined();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationUnSuccess();
        assertEquals(firstCountOrderEntity + 1, DataHelper.getOrderEntity());
        assertEquals("DECLINED", DataHelper.getStatusAddedCreditRequestEntity());
    }

    @Test
    void insertValidCardDataNotFromListButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getValidCardDataNotFromList();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationUnSuccess();
        assertEquals(firstCountOrderEntity, DataHelper.getOrderEntity());
    }

    @Test
    void insertValidCardDataNotFromListButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getValidCardDataNotFromList();
        DataPart.insertData(cardData);
        DataPart.buttonContinue.shouldHave(exactText("Отправляем запрос в Банк...")).shouldBe(visible);
        CheckForm.NotificationUnSuccess();
        assertEquals(firstCountOrderEntity, DataHelper.getOrderEntity());
    }

    @Test
    void insertInvalidCardDataPreviousMonthButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataPreviousMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @Test
    void insertInvalidCardDataPreviousMonthButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataPreviousMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @Test
    void insertInvalidCardDataIncorrectYearButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectYear();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Истёк срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @Test
    void insertInvalidCardDataIncorrectYearButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectYear();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Истёк срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @Test
    void insertInvalidCardDataIncorrectMonthButtonBuy() {
        form.$$("button").find(exactText("Купить")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @Test
    void insertInvalidCardDataIncorrectMonthButtonBuyInCredit() {
        form.$$("button").find(exactText("Купить в кредит")).click();
        val cardData = DataHelper.getInValidCardDataIncorrectMonth();
        DataPart.insertData(cardData);
        $(".input__inner .input__sub").shouldHave(exactText("Неверно указан срок действия карты"))
                .shouldBe(visible);
        CheckForm.Color();
    }

    @AfterAll
    static void clearDataBase() {
        DataHelper.clearAllInAuthCodes();
    }

}
