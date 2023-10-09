package utils;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;


public class TestConfig {

    @BeforeMethod(groups = {"Regression1", "Regression2"})
    public void setUpMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout = 20000;
        fastSetValue = true;
        pageLoadTimeout = 200000;
        screenshots = true;
        baseUrl = "https://www.swoop.ge/";
        holdBrowserOpen = true;

        open(baseUrl);
    }

    @AfterMethod(groups = {"Regression1", "Regression2"})
    public void tearDown() {
        closeWindow();
    }
}
