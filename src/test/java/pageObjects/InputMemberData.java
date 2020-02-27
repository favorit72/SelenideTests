package pageObjects;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class InputMemberData {
    private SelenideElement addMemberForm = $("form");

    @Step("Вводим данные участника")
    public InputMemberData setFor(String label, String value) {
        addMemberForm.$(withText(label)).find(byXpath("./following::*/input")).setValue(value);
        return this;
    }

    @Step()
    public void submit() {
        addMemberForm.$(byAttribute("type", "submit")).click();
    }
}
