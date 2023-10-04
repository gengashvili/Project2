package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.bouncycastle.oer.Switch;
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
        switchTo().window(0);

        Assert.assertEquals(newTabTitle, "Facebook");
        return this;
    }
}
