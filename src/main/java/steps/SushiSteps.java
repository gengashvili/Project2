package steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pages.SushiPage;

public class SushiSteps {
    SushiPage sushiPage = new SushiPage();
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SushiSteps checkVouchersAreNotSoldOut() {
        ElementsCollection sushiOffers = sushiPage.sushiOffers;
        By voucherDiagram = sushiPage.voucherDiagram;

        sushiOffers.stream().forEach(sushiCard -> {
            String dataWidth = sushiCard.$(voucherDiagram).getAttribute("data-width");
            softAssert.assertNotEquals(dataWidth, "100");
        });

        softAssert.assertAll();

        return this;
    }
}
