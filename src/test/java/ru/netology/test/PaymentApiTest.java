package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.Card;
import ru.netology.data.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PaymentApiTest {
    //Card invalidHolderCard = DataGenerator.getInvalidHolderCard();
    Card ValidApprovedCard = DataGenerator.getValidApprovedCard();
    Card ValidDeclinedCard = DataGenerator.getValidDeclinedCard();
    Card InvalidCard = DataGenerator.getInvalidCard();

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
        // должен отправляться запрос на оплату корректной картой
    void shouldSendPaymentRequestWithApprovedCard() {
        int statusCode = DataGenerator.getRequestStatusCode(ValidApprovedCard, "/api/v1/pay");
        assertEquals(200, statusCode);
    }

    @Test
        // должен отправляться запрос на покупку в кредит с корректной картой
    void shouldSendCreditRequestWithApprovedCard() {
        int statusCode = DataGenerator.getCreditStatusCode(ValidApprovedCard, "/api/v1/credit");
        assertEquals(200, statusCode);
    }

    @Test
        // должен отправляться запрос на оплату корректной картой
    void shouldSendPaymentRequestWithDeclinedCard() {
        int statusCode = DataGenerator.getRequestStatusCode(ValidDeclinedCard, "/api/v1/pay");
        assertEquals(200, statusCode);
    }

    @Test
        // должен отправляться запрос на покупку в кредит с корректной картой"
    void shouldSendCreditRequestWithDeclinedCard() {
        int statusCode = DataGenerator.getCreditStatusCode(ValidDeclinedCard, "/api/v1/credit");
        assertEquals(200, statusCode);
    }

    @Test
        // Не должен отправляться запрос на покупку в кредит с корректной картой"
    void shouldNotSendCreditRequestWithInvalidCard() {
        int statusCode = DataGenerator.getInvalidCode(InvalidCard, "/api/v1/credit");
        assertNotEquals(200, statusCode);
    }
}
