package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement header = $("header");

    @Step("Открываем вкладку группы")
    public void openGroups() {
        header.$(By.linkText("Группы")).click();
    }

    @Step("Открываем вкладку участники")
    public void openMembers() {
        header.$(By.linkText("Участники")).click();
    }

    @Step("Открываем вкладку статистика программы")
    public void openStatisticProgram() {
        header.$(By.linkText("Статистика программы")).click();
    }

    @Step("Открываем вкладку профиля менеджера")
    public void openManagerProfile() {
        header.$("Менеджер").click();
    }

    @Step("Открываем вкладку профиля Администратора")
    public void openAdminProfile() {
        header.$(By.linkText("Администратор")).click();
    }

    @Step("Открываем вкладку общая статистика")
    public void openGlobalStatistic() {
        header.$("").click();
    }

    @Step("Открываем вкладку документы")
    public void openDocuments() {
        header.$(By.linkText("Документы")).click();
    }
}
