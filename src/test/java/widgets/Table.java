package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static java.util.Arrays.asList;

public class Table {
    private SelenideElement table = $("table");
    private SelenideElement tableContent = table.$("tbody");

    private SelenideElement head() {
        return this.table.$("thead");
    }

    private ElementsCollection headers() {
        return head().$$("th");
    }

    @Step("Выбираем строку таблицы по номеру {index}")
    public void selectRowByIndex(int index) {
        tableContent.$("tr", index).click();
    }

    @Step("Выбираем строку таблицы по имени {name}")
    public void selectRowByName(String name) {
        tableContent.$$("tr").findBy(Condition.text(name)).click();
    }

    public ElementsCollection size() {
        return table.$$("tr");
    }

    @Step("Проверяем заголовки таблицы")
    public void shouldHaveColumnHeaders(String... texts) {
        List<String> headerTexts = new ArrayList<String>();
        headerTexts.add("");
        headerTexts.addAll(asList(texts));
        headers().shouldHave(exactTexts(headerTexts.toArray(new String[0])));
    }
}
