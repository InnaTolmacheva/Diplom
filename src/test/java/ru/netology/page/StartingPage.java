package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class StartingPage {
  //  private SelenideElement header = $("");
    private SelenideElement buttom = $x("//span[text()=\"Купить\"]");
    private SelenideElement number = $("input[placeholder = '0000 0000 0000 0000']");
    private SelenideElement payCard = $$("h3").get(1).should(ownText("Оплата по карте"));

  public StartingPage StartingPage() {
    buttom.click();
    payCard.should(Condition.visible);
    return new StartingPage();
  }

}
