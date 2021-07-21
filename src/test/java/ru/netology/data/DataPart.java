package ru.netology.data;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DataPart {
    private static ElementsCollection itemBox = $$(".input__inner .input__control");
    private static ElementsCollection itemButton = $$(".button__content");
    public static SelenideElement cardNumber = itemBox.get(0);
    public static SelenideElement cardMonth = itemBox.get(1);
    public static SelenideElement cardYear = itemBox.get(2);
    public static SelenideElement cardName = itemBox.get(3);
    public static SelenideElement cardCVV = itemBox.get(4);
    public static SelenideElement buttonContinue = itemButton.get(2);
    public static ElementsCollection itemSubBox = $$(".input__inner .input__sub");
    public static SelenideElement cardNumberSubBox = itemSubBox.get(0);
    public static SelenideElement cardMonthSubBox = itemSubBox.get(1);
    public static SelenideElement cardYearSubBox = itemSubBox.get(2);
    public static SelenideElement cardNameSubBox = itemSubBox.get(3);
    public static SelenideElement cardCVVSubBox = itemSubBox.get(4);

    public static DataPart insertData(DataHelper.CardData data) {
        cardNumber.setValue(data.getNumberCard());
        cardMonth.setValue(data.getMonth());
        cardYear.setValue(data.getYear());
        cardName.setValue(data.getName());
        cardCVV.setValue(data.getCVV());
        buttonContinue.click();
        return new DataPart();
    }
}
