package webTests.test;

import org.testng.annotations.Test;

import configs.BaseTest;


public class CompanyTests extends BaseTest {

    @Test
    public void addCompany() {
        product.openManagerApp();
        homePage.openCompanies();

    }
}
