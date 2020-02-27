package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Table {
    private SelenideElement table = $("table");

    @Step("Выбираем строку таблицы по номеру {index}")
    public void selectLineByIndex(int index) {
        table.$$("tr").get(index).click();
    }

    @Step("Выбираем строку таблицы по имени {name}")
    public void selectLineByName(String name) {
        table.$$("tr").findBy(Condition.text(name)).click();
    }
}
