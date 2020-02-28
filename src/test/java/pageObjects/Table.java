package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Table {
    private SelenideElement table = $("table");
    private SelenideElement tableContent = table.$("tbody");

    @Step("Выбираем строку таблицы по номеру {index}")
    public void selectLineByIndex(int index) {
        tableContent.$("tr", index).click();
    }

    @Step("Выбираем строку таблицы по имени {name}")
    public void selectLineByName(String name) {
        tableContent.$$("tr").findBy(Condition.text(name)).click();
    }

    public ElementsCollection size() {
        return table.$$("tr");
    }
}
