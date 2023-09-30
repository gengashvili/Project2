package steps;

import io.qameta.allure.Step;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Step
    public HomeSteps goToRentCategory() {
        homePage.rentLink.click();
        return this;
    }

    @Step
    public HomeSteps clickOnCategory() {
        homePage.categoryLink.click();
        return this;
    }

    @Step
    public HomeSteps hoverOnKvebaElement() {
        homePage.kvebaElement.hover();
        return this;
    }

    @Step
    public HomeSteps clickOnSushiElement() {
        homePage.sushiElement.click();
        return this;
    }
}
