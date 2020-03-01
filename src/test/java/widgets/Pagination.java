package widgets;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Pagination {
    SelenideElement paginationContainer = $(".pagination-container");

    public void selectBack() {
        paginationContainer.$(new Selectors.ByText("Назад")).click();
    }

    public void selectPage(String byTextIndex) {
        paginationContainer.$(new Selectors.ByText(byTextIndex)).click();
    }
}
