package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InputUserData {
    private SelenideElement addMemberForm = $("form");

    public void setFor(String label, String value) {
        addMemberForm.$(".input-component__input").setValue(value);
    }
}
