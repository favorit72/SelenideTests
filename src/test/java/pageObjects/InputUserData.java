package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class InputUserData {
    private SelenideElement addMemberForm = $("form");

    @Step("Вводим данные участника")
    public InputUserData setFor(String label, String value) {
        addMemberForm.$(withText(label)).find(byXpath("./following::*/input")).setValue(value);
        return this;
    }

    @Step()
    public void submit() {
        addMemberForm.$(byAttribute("type", "submit")).click();
    }
}
