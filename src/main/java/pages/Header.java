package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Header {
    public SelenideElement
            header = $("header.NewHeader"),
            rentLink = header.$(By.linkText("დასვენება")),
            categoryLink = header.$(".NewCategories"),
            kvebaElement = header.$x(".//a[contains(@class, 'mainCategories') and contains(text(), 'კვება')]"),
            sushiElement = header.$x(".//div[contains(@class, 'mobileSubCategories') and contains(@class, 'subCategory-3')]//a[text()='სუში']"),
            signInLink = header.$(".HeaderTools.swoop-login")
    ;
}
