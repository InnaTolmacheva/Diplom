package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.PaymentPage;
import ru.netology.page.StartingPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PaymentDBTest {
    private WebDriver driver;

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterAll
    static void cleanUp() {
        DataHelper.cleanDataBases();
    }

    @BeforeEach
    void setUp2() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void setUp3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void close() {
        driver.quit();      //закрывает все окна браузера
        driver = null;      // обнуляем драйвер
    }

    @Test
        // пользователь ввел валидные данные во все поля - операция одобрена банком (оплата картой)
    void positivePaymentTest() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputData("4444 4444 4444 4441");
        $(".notification__content").should(ownText("Операция одобрена Банком."), Duration.ofSeconds(30));

        String actual = DataHelper.getPaymentStatus();
        String expected = DataHelper.getApprovedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }

    @Test
        // пользователь ввел валидные данные во все поля - банк отклонил операцию (оплата картой)
    void negativePaymentTest() { //throws InterruptedException {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputData("4444 4444 4444 4442");
        $(".notification__content").should(ownText("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(30));

        String actual = DataHelper.getPaymentStatus();
        String expected = DataHelper.getDeclinedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }

    @Test
        // пользователь ввел валидные данные во все поля - операция одобрена банком (покупка в кредит)
    void positiveCreditTest() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputData("4444 4444 4444 4441");
        $(".notification__content").should(ownText("Операция одобрена Банком."), Duration.ofSeconds(30));

        String actual = DataHelper.getCreditStatus();
        String expected = DataHelper.getApprovedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }

    @Test
        // пользователь ввел валидные данные для несуществующей карты во все поля - банк отклонил операцию (оплата картой)
    void negativePaymentTestWithInvalidCard() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputData("4444 4444 4444 4440");
        $(".notification__content").should(ownText("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(30));

        String actual = DataHelper.getPaymentStatus();
        String expected = DataHelper.getDeclinedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }
    @Test
        // пользователь ввел валидные данные для несуществующей карты во все поля - банк отклонил операцию (покупка в кредит)
    void negativeCreditTestWithInvalidCard() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputData("4444 4444 4444 4443");
        $(".notification__content").should(ownText("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(30));

        String actual = DataHelper.getCreditStatus();
        String expected = DataHelper.getDeclinedCardInfo().getStatus();
        Assertions.assertEquals(expected, actual);

    }
}
