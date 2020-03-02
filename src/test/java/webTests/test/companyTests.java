package webTests.test;

import org.testng.annotations.Test;

import configs.BaseTest;


public class companyTests extends BaseTest {

    @Test
    public void addCompany() {
        product.openManagerApp();
        homePage.openCompanies();

    }
}
