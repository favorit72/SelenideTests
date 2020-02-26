package webTests.test;

import org.testng.annotations.Test;

import pageObjects.ActionWithMembers;
import pageObjects.HomePage;
import pageObjects.Product;
import utils.BaseTest;

public class ProductTest extends BaseTest {
    Product product = new Product();
    HomePage homePage = new HomePage();
    ActionWithMembers members = new ActionWithMembers();

    @Test
    public void testAddMember() {
        product.openAdminApp();
        homePage.openMembers();
        members.addMember("member");
    }
}
