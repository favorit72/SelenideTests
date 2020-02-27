package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ActionWithMembers {
    private SelenideElement actionsContainer = $(".flex.align-items-center.justify-content-space-between.mt-5");
    private SelenideElement actionsContainerForGroup = $(".flex.justify-content-flex-start.align-items-center.mt-8");


    @Step("добавляем участника в систему")
    public void addIntoSystem(String email, String personnelNumber) {
        actionsContainer.$$("button").findBy(Condition.text("Добавить")).click();

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
}
