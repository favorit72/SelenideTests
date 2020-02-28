package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ChooseFilter {
    private SelenideElement filterContainer = $(".mt-7");

    public void byType(String type) {
        filterContainer.$(withText(type)).click();
    }

//    public ChooseFilter chooseSubType() {
//        input.$(byXpath("./following::*/input")).setValue(value);
//        return this;
//    }
}
