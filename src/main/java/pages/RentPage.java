package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RentPage {
    public SelenideElement
            priceContainer = $(".price-filter"),
            minPriceInput = $("#minprice"),
            maxPriceInput =$("#maxprice"),
            searchButton = $x("//div[@class='submit-button' and text()='ძებნა']");
}
