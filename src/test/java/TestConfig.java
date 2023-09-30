import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;

public class TestConfig {

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout = 5000;
        holdBrowserOpen = true;
        fastSetValue = true;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
