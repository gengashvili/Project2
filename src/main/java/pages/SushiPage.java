package pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SushiPage {
    public ElementsCollection sushiOffers = $$(".special-offer");
    public By voucherDiagram = By.xpath(".//div[@class='voucher-diagram']/div");
}
