package webTests.test;

import com.codeborne.selenide.CollectionCondition;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import configs.BaseTest;
import pages.HomePage;
import pages.Product;
import utils.Listener;
import utils.RetryAnalyzerCount;
import utils.data.Strings;
import widgets.ActionWithMembers;
import widgets.Table;

@Listeners(Listener.class)
public class MembersTests extends BaseTest {
    Product product = new Product();
    HomePage homePage = new HomePage();
    ActionWithMembers members = new ActionWithMembers();
    Table table = new Table();

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addMemberIntoSystem() {
        product.openAdminApp();
        homePage.openMembers();
        members.addIntoSystem(Strings.EMAIL);
    }

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addMemberToGroup() {
        product.openAdminApp();
        homePage.openGroups();
        table.selectRowByIndex(1);
        members.addIntoGroup(Strings.EMAIL);
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
        //В хедере таблицы есть пустые ячейки
        table.shouldHaveColumnHeaders("№", "ФИО", "Контакты", "Группа", "Размер компенсации, руб.", "Дата заключения договора", "", "");
    }
}
