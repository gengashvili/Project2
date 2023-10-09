package steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.RentPage;
import utils.Helper;

import static com.codeborne.selenide.Selenide.*;

public class RentSteps {
    RentPage rentPage = new RentPage();


    @Step("scroll to price container")
    public RentSteps scrollToPriceContainer() {
        rentPage.pricesContainer.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        return this;
    }

    @Step("set min price: {price}")
    public RentSteps setMinPrice(String price) {
        rentPage.minPriceInput.setValue(price);
        return this;
    }


    @Step("set max price: {price}")
    public RentSteps setMaxPrice(String price) {
        rentPage.maxPriceInput.setValue(price);
        return this;
    }

    @Step("click on search button")
    public RentSteps clickOnSearchButton() {
        rentPage.searchButton.click();
        return this;
    }

    @Step("validate elements price range")
    public RentSteps validateElementsPriceRange() {
       rentPage.offersPrices.stream().forEach(offer -> {
           int price = Helper.parseStringToInt(offer.getText());

           Assert.assertTrue(price >= 200 && price <=230, "Price must be between 200 and 230, but it is: " + price);
       });

        return this;
    }

}
