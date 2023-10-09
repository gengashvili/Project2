package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SushiOffersPage {
    public ElementsCollection sushiOffers = $$(".special-offer");
    public By
            voucherDiagram = By.xpath(".//div[@class='voucher-diagram']/div"),
            favoriteIcon = By.className("deal-box-wishlist"),
            sushiPrice = By.cssSelector(".discounted-prices .deal-voucher-price");
    public SelenideElement
            sortDropDown = $("#sort"),
            loginWindow = $("#toogletabs .login"),
            windowCloseButton = loginWindow.$(".close-button");
}
