package webTests.test;

import com.codeborne.selenide.CollectionCondition;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.ActionWithMembers;
import pageObjects.HomePage;
import pageObjects.Product;
import pageObjects.Table;
import utils.BaseTest;
import utils.Listener;
import utils.RetryAnalyzerCount;
import utils.data.Strings;

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
        members.addIntoSystem(Strings.EMAIL, "");
        table.size().shouldHave(CollectionCondition.sizeLessThanOrEqual(5));
    }

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addMemberToGroup() {
        product.openAdminApp();
        homePage.openGroups();
        table.selectLineByIndex(1);
        members.addIntoGroup(Strings.EMAIL, "");
        table.size().shouldHave(CollectionCondition.sizeLessThanOrEqual(5));
    }

    @Test
    public void filterMembersByGroup() {
        product.openAdminApp();
        homePage.openMembers();
        members.filter("Группа");
    }
}
