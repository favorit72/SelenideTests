package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class ActionWithMembers {
    private SelenideElement actionsContainer = $(".flex.align-items-center.justify-content-space-between.mt-5");

    @Step("добавляем участника")
    public void addMember(String email, String PersonnelNumber) {
        SimpleDateFormat formatForDate = new SimpleDateFormat("hhmmss");
        PersonnelNumber = formatForDate.format(new Date());

        actionsContainer.$$("button").findBy(Condition.text("Добавить")).click();
        new InputUserData()
                .setFor("Корпоративный E-mail", email)
                .setFor("Табельный номер", PersonnelNumber)
                .submit();
    }
}
