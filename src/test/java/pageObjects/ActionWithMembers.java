package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ActionWithMembers {
    private SelenideElement actionsContainer = $(".flex.align-items-center.justify-content-space-between.mt-5");

    public void addMember(String name) {
        actionsContainer.$$("button").findBy(Condition.text("Добавить")).click();
        new InputUserData().setFor("eMail:", name);
    }
}
