package pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.ByText;
import static com.codeborne.selenide.Selenide.$;

public class ActionWithMembers {
    private SelenideElement actionsContainer = $(".mt-5");
    private SelenideElement actionsContainerForGroup = $(".mt-8");


    @Step("добавляем участника в систему")
    public void addIntoSystem(String email, String personnelNumber) {
        actionsContainer.$$("button").findBy(text("Добавить")).click();

        SimpleDateFormat formatForDate = new SimpleDateFormat("hhmmss");
        personnelNumber = formatForDate.format(new Date());

        new InputMemberData()
                .setFor("Корпоративный E-mail", email)
                .setFor("Табельный номер", personnelNumber)
                .submit();
    }

    @Step("добавляем участника в группу")
    public void addIntoGroup(String email, String personnelNumber) {
        actionsContainerForGroup.$("button").click();

        SimpleDateFormat formatForDate = new SimpleDateFormat("hhmmss");
        personnelNumber = formatForDate.format(new Date());

        new InputMemberData()
                .setFor("Корпоративный E-mail", email)
                .setFor("Табельный номер", personnelNumber)
                .submit();
    }

    @Step("фильтруем участников по типу {type}")
    public void filter(String type) {
        actionsContainer.$(new ByText("Фильтр")).click();
        new ChooseFilter().byType(type);
    }
}
