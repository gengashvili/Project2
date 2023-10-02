package steps;

import io.qameta.allure.Step;
import pages.Header;

public class HeaderSteps {
    Header header = new Header();

    @Step
    public HeaderSteps goToRentCategory() {
        header.rentLink.click();
        return this;
    }

    @Step
    public HeaderSteps clickOnCategory() {
        header.categoryLink.click();
        return this;
    }

    @Step
    public HeaderSteps hoverOnKvebaElement() {
        header.kvebaElement.hover();
        return this;
    }

    @Step
    public HeaderSteps clickOnSushiElement() {
        header.sushiElement.click();
        return this;
    }

    @Step
    public HeaderSteps clickOnSignIn() {
        header.signInLink.click();
        return this;
    }
}
