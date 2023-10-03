import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class TestConfig {

    @BeforeClass
    public void setUpClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout = 20000;
        holdBrowserOpen = true;
        fastSetValue = true;
        pageLoadTimeout = 60000;
    }

    @BeforeMethod
    public void setUpMethod() {
        open("https://www.swoop.ge/");
    }

    @AfterMethod
    public void tearDown() {
        //Selenide.closeWebDriver();
    }
}
