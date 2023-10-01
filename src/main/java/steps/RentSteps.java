package steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.RentPage;

import static com.codeborne.selenide.Selenide.*;

public class RentSteps {
    RentPage rentPage = new RentPage();


    @Step
    public RentSteps scrollToPriceContainer() {
        rentPage.priceContainer.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        return this;
    }
    @Step
    public RentSteps setMinPrice(String price) {
        rentPage.minPriceInput.setValue(price);
        return this;
    }


    @Step
    public RentSteps setMaxPrice(String price) {
        rentPage.maxPriceInput.setValue(price);
        return this;
    }

    @Step
    public RentSteps clickOnSearchButton() {
        $(".category-filter-desk .submit-form .submit-button").click();
        return this;
    }

    @Step
    public RentSteps validateElementsPriceRange() {
        ElementsCollection rentOffers = rentPage.rentOffers;
        By priceLocator = rentPage.priceLocator;

        rentOffers.stream().forEach(offer -> {
            String priceText = offer.$(priceLocator).getText();
            System.out.println(priceText + "---------");
        });
        return this;
    }

}
