package webTests.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ActionWithMembers;
import pageObjects.HomePage;
import pageObjects.Product;
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
    public void addMemberTest() throws InterruptedException {
        product.openAdminApp();
        homePage.openMembers();
        members.addMember(Strings.EMAIL, "");
    }

//    @Test
//    public void addMemberToGroup() {
//        product.openAdminApp();
//        homePage.openGroups();
//        table.selectFirstGroup(1);
//        members.addMember(Strings.EMAIL, "");
//    }
}
