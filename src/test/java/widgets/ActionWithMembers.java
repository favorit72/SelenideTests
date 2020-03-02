package widgets;

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

    String personnelNumber1 = randomNumber();
    String personnelNumber2 = randomNumber();

    private String randomNumber() {
        SimpleDateFormat formatForDate = new SimpleDateFormat("hhmmss");
        String personnelNumber = formatForDate.format(new Date());
        return personnelNumber;
    }

    public String getPersonnelNumber1() {
        return personnelNumber1;
    }

    public String getPersonnelNumber2() {
        return personnelNumber2;
    }

    @Step("добавляем нового участника в систему")
    public void addIntoSystem(String email) {
        actionsContainer.$$("button").findBy(text("Добавить")).click();
        this.personnelNumber1 = randomNumber();

        new InputMemberData()
                .setFor("Корпоративный E-mail", email)
                .setFor("Табельный номер", personnelNumber1)
                .submit();
    }

    @Step("добавляем нового участника в группу")
    public void addIntoGroup(String email) {
        actionsContainerForGroup.$("button").click();
        this.personnelNumber2 = randomNumber();

        new InputMemberData()
                .setFor("Корпоративный E-mail", email)
                .setFor("Табельный номер", personnelNumber2)
                .submit();
    }

    @Step("фильтруем участников по типу {type}")
    public void filter(String type) {
        actionsContainer.$(new ByText("Фильтр")).click();
        new ChooseFilter().byType(type);
    }

    @Step("Поиск участника")
    public void search(String searchParam) {
        $(".input-component").$("input").setValue(searchParam).pressEnter();
    }
}
