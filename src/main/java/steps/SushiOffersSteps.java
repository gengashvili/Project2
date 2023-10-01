package steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pages.SushiOffersPage;
import utils.Helper;

public class SushiOffersSteps {
    SushiOffersPage sushiOffersPage = new SushiOffersPage();
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SushiOffersSteps addFirstItemToFavorites() {
        sushiOffersPage.sushiOffers.get(0).$(sushiOffersPage.favoriteIcon).click();
        return this;
    }

    @Step
    public SushiOffersSteps verifyLoginWindowAppearance() {
        sushiOffersPage.loginWindow.should(Condition.appear);
        sushiOffersPage.windowCloseButton.click();
        return this;
    }

    @Step
    public SushiOffersSteps checkVouchersAreNotSoldOut() {
        ElementsCollection sushiOffers = sushiOffersPage.sushiOffers;
        By voucherDiagram = sushiOffersPage.voucherDiagram;

        sushiOffers.stream().forEach(sushiCard -> {
            String dataWidth = sushiCard.$(voucherDiagram).getAttribute("data-width");
            softAssert.assertNotEquals(dataWidth, "100");
        });

        softAssert.assertAll();

        return this;
    }

    @Step
    public SushiOffersSteps sortElementsByPriceDecreasing() {
        sushiOffersPage.sortDropDown.selectOption("ფასით კლებადი");
        return this;
    }

    @Step
    public SushiOffersSteps verifyPrices() {
        String firstOfferPriceText = sushiOffersPage.sushiOffers.get(0).$(sushiOffersPage.sushiPrice).getText();
        String secondOfferPriceText = sushiOffersPage.sushiOffers.get(1).$(sushiOffersPage.sushiPrice).getText();

        int firstOfferPrice = Helper.parseStringToInt(firstOfferPriceText);
        int secondOfferPrice = Helper.parseStringToInt(secondOfferPriceText);

        softAssert.assertTrue(
                firstOfferPrice > secondOfferPrice,
                "first item's price is not higher than second's one as expected"
        );

        softAssert.assertAll();
        return this;
    }

    @Step
    public SushiOffersSteps clickOnFirstOffer() {
        sushiOffersPage.sushiOffers.first().click();
        return this;
    }

}
