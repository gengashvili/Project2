package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.*;

public class ScreenshotListener extends TestConfig implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        takeScreenshot(driver);
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String saveLogs(String message) {
        return message;
    }


}