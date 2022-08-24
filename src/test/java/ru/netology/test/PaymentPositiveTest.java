package ru.netology.test;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPayment;
import ru.netology.page.StartingPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPositiveTest {

    @BeforeAll
    static void setUp(){
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void positiveTest() {

    /*$x("//span[text()=\"Купить\"]").click();
    $$("h3").get(1).should(ownText("Оплата по карте")); //   shouldHave(Condition.text("Оплата по карте"));


        $("input[placeholder = '0000 0000 0000 0000']").setValue("4444 4444 4444 4441");
        $("input[placeholder = '08']").setValue(DataGenerator.getMonth());
        $("input[placeholder = '22']").setValue(DataGenerator.getYear());
        $$(".input__control").get(3).setValue(DataGenerator.getName());
        $("input[placeholder = '999']").setValue(DataGenerator.getCVV());
        $x("//span[text()=\"Продолжить\"]").click();
        $(".notification__content").should(ownText("Операция одобрена Банком."), Duration.ofSeconds(30));*/

        String actual = DataHelper.getPaymentStatus();
        String expected = DataHelper.getApprovedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }

    @Test // пользователь ввел валидные данные во все поля - операция д. б. одобрена банком
    public void shouldGetBankAcceptance() {
        var CardPayment = new CardPayment();
        /*String actual = DataHelper.getPaymentStatus();
        String expected = DataHelper.getApprovedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);*/
    }
}