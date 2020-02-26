package pageObjects;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Step;

public class Product {

    @Step("Открываем ветку админа")
    public void openAdminApp() {
        Selenide.open("https://dev16.arcdev.ru",
                "",
                "fw.develop",
                "tP(oi*EYMH3pTK");
    }

    @Step("Открываем ветку менеджера")
    public void openManagerApp() {
        Selenide.open("https://dev17.arcdev.ru",
                "",
                "fw.develop",
                "tP(oi*EYMH3pTK");
    }
}
