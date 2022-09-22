package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.netology.page.CreditPage;
import ru.netology.page.PaymentPage;
import ru.netology.page.StartingPage;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentUITest {
    private WebDriver driver;

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
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
        // тестируем кнопку оплаты тура картой
    void paymentTest() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        $$("h3").get(1).should(ownText("Оплата по карте"));

    }

    @Test // пользователь не ввел номер карты - оплата картой
    public void emptyCard() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputData("");
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел месяц - оплата картой
    public void emptyMonth() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputEmptyMonth();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел год - оплата картой
    public void emptyYear() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputEmptyYear();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел Владелец - оплата картой
    public void emptyName() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputEmptyName();
        $(".input__sub").should(ownText("Поле обязательно для заполнения"));
    }

    @Test // пользователь не ввел CVV - оплата картой
    public void emptyCVV() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputEmptyCVV();
        $(".input__sub").should(ownText("Поле обязательно для заполнения"));
    }

    @Test // пользователь ввел неверный номер карты - оплата картой
    public void invalidCard() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputData("4444 4444 4444 444");
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь ввел неверный номер месяца -  оплата картой
    public void invalidMonth() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputInvalidMonth();
        $(".input__sub").should(ownText("Неверно указан срок действия карты"));
    }

    @Test // пользователь ввел неверный номер года - оплата картой
    public void invalidYear() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputInvalidYear();
        $(".input__sub").should(ownText("Истёк срок действия карты"));
    }

    @Test // пользователь ввел неверный номер года (свыше 5 лет) - оплата картой
    public void aboveFiveYear() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputYearAboveFive();
        $(".input__sub").should(ownText("Неверно указан срок действия карты"));
    }
    @Test // пользователь ввел имя владельца карты кирилицей - оплата картой
    public void invalidName() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputInvalidName();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь ввел неверный CVV - оплата картой
    public void invalidCVV() {
        StartingPage startingPage = new StartingPage();
        PaymentPage paymentPage = startingPage.goToPaymentPage();
        PaymentPage cardPage = PaymentPage.inputInvalidCVV();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test
        // тестируем кнопку оплаты тура в кредит
    void creditTest() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        $$("h3").get(1).should(ownText("Кредит по данным карты"));

    }

    @Test // пользователь не ввел номер карты - покупка в кредит
    public void emptyCreditCard() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputData("");
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел месяц  -  покупка в кредит
    public void emptyCreditMonth() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputEmptyMonth();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел год - покупка в кредит
    public void emptyCreditYear() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputEmptyYear();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь не ввел Владелец - покуака в кредит
    public void emptyCreditName() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputEmptyName();
        $(".input__sub").should(ownText("Поле обязательно для заполнения"));
    }

    @Test // пользователь не ввел CVV - покуака в кредит
    public void emptyCreditCVV() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputEmptyCVV();
        $(".input__sub").should(ownText("Поле обязательно для заполнения"));
    }

    @Test // пользователь ввел неверный номер карты
    public void invalidCreditCard() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputData("4444 4444 4444 444");
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь ввел неверный номер месяца - покупка в кредит
    public void invalidCreditMonth() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputInvalidMonth();
        $(".input__sub").should(ownText("Неверно указан срок действия карты"));
    }

    @Test // пользователь ввел неверный номер года - покупка в кредит
    public void invalidCreditYear() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputInvalidYear();
        $(".input__sub").should(ownText("Истёк срок действия карты"));
    }

    @Test // пользователь ввел неверный номер года (свыше 5 лет) - покупка в кредит
    public void invalidCreditYearAboveFiveYear() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputYearAboveFive();
        $(".input__sub").should(ownText("Неверно указан срок действия карты"));
    }
    @Test // пользователь ввел имя владельца карты кирилицей - покупка в кредит
    public void invalidCreditName() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputInvalidName();
        $(".input__sub").should(ownText("Неверный формат"));
    }

    @Test // пользователь ввел неверный CVV - покупка в кредит
    public void invalidCreditCVV() {
        StartingPage startingPage = new StartingPage();
        CreditPage creditPage = startingPage.goToCreditPage();
        CreditPage cardPage = CreditPage.inputInvalidCVV();
        $(".input__sub").should(ownText("Неверный формат"));
    }
}