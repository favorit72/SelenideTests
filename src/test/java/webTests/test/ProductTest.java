package webTests.test;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import utils.BaseTest;

public class ProductTest extends BaseTest {

    @Test
    public void authorization() {
        new HomePage()
                .openAdminProfile()
                .openMembers();

    }
}
