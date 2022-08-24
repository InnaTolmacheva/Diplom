package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class CardPayment {
    private SelenideElement buttom = $x("//span[text()=\"Купить\"]");
    private SelenideElement payCard = $$("h3").get(1).should(ownText("Оплата по карте"));
    private SelenideElement cardNumber = $("input[placeholder = '0000 0000 0000 0000']");
    private SelenideElement month = $("input[placeholder = '08']");
    private SelenideElement year = $("input[placeholder = '22']");
    private SelenideElement name = (SelenideElement) $$(".input__control").get(3);
    private SelenideElement CVV = $("input[placeholder = '999']");
    private SelenideElement cont = $x("//span[text()=\"Продолжить\"]");
    private SelenideElement ok = $(".notification__content");

    public CardPayment() {
        buttom.click();
     //   payCard.should(Condition.visible);
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(DataGenerator.getMonth());
        year.setValue(DataGenerator.getYear());
        name.setValue(DataGenerator.getName());
        CVV.setValue(DataGenerator.getCVV());
        cont.click();
        ok.should(ownText("Операция одобрена Банком."), Duration.ofSeconds(30));


    }

}
