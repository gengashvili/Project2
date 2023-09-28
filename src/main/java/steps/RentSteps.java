package steps;

import io.qameta.allure.Step;
import pages.RentPage;

public class RentSteps {
    RentPage rentPage = new RentPage();


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
        rentPage.searchButton.scrollTo().click();
        return this;
    }
}
