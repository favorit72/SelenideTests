package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement header = $("header");


    @Step("Открываем ветку админа")
    public HomePage openAdminApp() {
        Selenide.open("https://dev16.arcdev.ru",
                "",
                "fw.develop",
                "tP(oi*EYMH3pTK");
        return this;
    }

    @Step("Открываем ветку менеджера")
    public HomePage openManagerApp() {
        Selenide.open("https://dev17.arcdev.ru",
                "",
                "fw.develop",
                "tP(oi*EYMH3pTK");
        return this;
    }

    public HomePage openCompany() {
        header.$(By.linkText("Группы")).click();
        return this;
    }

    public void openMembers() {
        header.$(By.linkText("Участники")).click();
    }

    public HomePage openStatisticProgram() {
        header.$(By.linkText("Статистика программы")).click();
        return this;
    }

    public HomePage openManagerProfile() {
        header.$("").click();
        return this;
    }

    public HomePage openAdminProfile() {
        header.$(By.linkText("Администратор")).click();
        return this;
    }

    public HomePage openGlobalStatistic() {
        header.$("").click();
        return this;
    }

    public HomePage openDocuments() {
        header.$(By.linkText("Документы")).click();
        return this;
    }
}
