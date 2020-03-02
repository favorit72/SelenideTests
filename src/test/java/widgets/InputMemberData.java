package widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class InputMemberData {
    private SelenideElement addMemberForm = $("form");

    public InputMemberData setFor(String label, String value) {
        addMemberForm.$(withText(label)).$(byXpath("./following::*/input")).setValue(value);
        return this;
    }

    public void submit() {
        addMemberForm.$(byAttribute("type", "submit")).click();
    }
}
