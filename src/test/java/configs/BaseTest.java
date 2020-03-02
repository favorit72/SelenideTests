package configs;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.BeforeClass;

import pages.HomePage;
import pages.Product;
import widgets.ActionWithMembers;
import widgets.Table;

public class BaseTest {
    protected Product product = new Product();
    protected HomePage homePage = new HomePage();
    protected ActionWithMembers members = new ActionWithMembers();
    protected Table table = new Table();

    @BeforeClass
    private void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.reportsFolder = "target/allure-results/screenshots";
    }
}
