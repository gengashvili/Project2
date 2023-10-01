package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RentPage {
    public SelenideElement
            priceContainer = $(".category-filter-desk .price-inputs"),
            minPriceInput = priceContainer.find("input[name='minprice']"),
            maxPriceInput = priceContainer.find("input[name='maxprice']"),
            searchButton = $(".submit-form .submit-button");

    public ElementsCollection rentOffers = $$(".special-offer");
    public By priceLocator = By.cssSelector(".deal-voucher-price");
}
