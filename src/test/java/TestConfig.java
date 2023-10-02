import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;

public class TestConfig {

    @BeforeMethod
    public void setUpMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout = 20000;
        holdBrowserOpen = true;
        fastSetValue = true;
        pageLoadTimeout = 20000;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
