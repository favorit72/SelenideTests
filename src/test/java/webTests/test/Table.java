package webTests.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Table {
    private SelenideElement table = $("table");

    public void selectFirstGroup(int index) {
        //table.$$(".tr").get(index).click();
        System.out.println(table.$$(".tr").get(index));
    }
}
