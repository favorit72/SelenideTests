package webTests.test;

import com.codeborne.selenide.CollectionCondition;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import configs.BaseTest;
import utils.Listener;
import utils.RetryAnalyzerCount;
import utils.data.Strings;

@Listeners(Listener.class)
public class MembersTests extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addMemberIntoSystem() {
        product.openAdminApp();
        homePage.openMembers();
        members.addIntoSystem(Strings.EMAIL);
        //в таблице есть чекбокс и пустые дивы
        table.shouldHaveColumnHeaders("", "№", "ФИО", "Контакты", "Группа", "Размер компенсации, руб.", "Дата заключения договора", "", "");

    }

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addMemberToGroup() {
        product.openAdminApp();
        homePage.openGroups();
        table.shouldHaveColumnHeaders("Название группы", "Размер компенсации, руб.", "Кол-во участников", "");
        table.selectRowByName("Топ менеджеры");
        members.addIntoGroup(Strings.EMAIL);
        table.shouldHaveColumnHeaders("", "№", "ФИО", "Контакты", "Табельный номер");
    }

    @Test
    public void filterMembersByGroup() {
        product.openAdminApp();
        homePage.openMembers();
        members.filter("Группа");
    }

    @Test
    public void findMemberInSystem() {
        product.openAdminApp();
        homePage.openMembers();
        members.search("человек");
    }

    @Test
    public void listMembers() {
        product.openAdminApp();
        homePage.openMembers();
        table.size().shouldHave(CollectionCondition.sizeLessThanOrEqual(5));
        table.shouldHaveColumnHeaders("", "№", "ФИО", "Контакты", "Группа", "Размер компенсации, руб.", "Дата заключения договора", "", "");
    }
}
