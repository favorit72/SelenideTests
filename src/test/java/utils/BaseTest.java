package utils;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.reportsFolder = "target/allure-results/screenshots";
    }
}
