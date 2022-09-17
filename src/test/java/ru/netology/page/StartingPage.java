package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StartingPage {
    private SelenideElement header = $$("h2").find(text("Путешествие дня"));
    private SelenideElement payButton = $$("button").find(exactText("Купить"));
    private SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));

  public StartingPage() {
    header.shouldBe(visible);

  }

  public PaymentPage goToPaymentPage() {
    payButton.click();
    return new PaymentPage();
  }

  public CreditPage goToCreditPage() {
      creditButton.click();
      return new CreditPage();

  }
}
