package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private SelenideElement header = $$("h3").find(text("Кредит по данным карты"));
    private static SelenideElement cardNumber = $(byText("Номер карты")).parent().$(".input__control");
    private static SelenideElement month = $(byText("Месяц")).parent().$(".input__control");
    private static SelenideElement year = $(byText("Год")).parent().$(".input__control");
    private static SelenideElement owner = $(byText("Владелец")).parent().$(".input__control");
    private static SelenideElement code = $(byText("CVC/CVV")).parent().$(".input__control");
    private static SelenideElement continued = $$("button").find(exactText("Продолжить"));

    public CreditPage() {
        header.shouldBe(visible);
    }

    public static CreditPage inputData(String number) {
        cardNumber.setValue(number);
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputInvalidMonth() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getInvalidMonth());
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputInvalidYear() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getInvalidYear());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputYearAboveFive() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYearAboveFive());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputInvalidName() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getInvalidName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputInvalidCVV() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getInvalidCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputEmptyMonth() {
        cardNumber.setValue("4444 4444 4444 4441");
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputEmptyYear() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        owner.setValue(DataGenerator.getName());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputEmptyName() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        code.setValue(DataGenerator.getCVV());
        continued.click();
        return null;
    }

    public static CreditPage inputEmptyCVV() {
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        owner.setValue(DataGenerator.getName());
        continued.click();
        return null;
    }

}
