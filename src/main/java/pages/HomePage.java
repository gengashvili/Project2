package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public SelenideElement
            rentLink = $(By.linkText("დასვენება")),
            categoryLink = $(".NewCategories.newcat"),
            kvebaElement = $x("//a[contains(@class, 'mainCategories') and contains(text(), 'კვება')]"),
            sushiElement = $x("//div[contains(@class, 'mobileSubCategories') and contains(@class, 'subCategory-3')]//a[text()='სუში']");

}
