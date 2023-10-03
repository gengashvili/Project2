package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SushiPage;

import static com.codeborne.selenide.Selenide.*;

public class SushiSteps {
    SushiPage sushiPage = new SushiPage();

    @Step("click on share")
    public SushiSteps clickOnShare() {
        sushiPage.shareIcon.click();
        return this;
    }

    @Step("validate facebook window appeared")
    public SushiSteps validateFacebookWindowAppeared() {
        switchTo().window(1);

        String newTabTitle = Selenide.title();
        closeWindow();

        Assert.assertEquals(newTabTitle, "Facebook");
        return this;
    }
}
