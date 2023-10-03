package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class RentPage {
    public SelenideElement
            categoryDesk = $(".category-filter-desk"),
            pricesContainer = categoryDesk.$(".price-inputs"),
            minPriceInput = pricesContainer.find("#minprice"),
            maxPriceInput = pricesContainer.find("#maxprice"),
            searchButton = categoryDesk.$(".submit-button");

    public ElementsCollection offersPrices = $$(".discounted-prices .deal-voucher-price:not([style*='text-decoration: line-through;'])");
}
