package steps;

import io.qameta.allure.Step;
import pages.Header;

public class HeaderSteps {
    Header header = new Header();

    @Step("got to rent category")
    public HeaderSteps goToRentCategory() {
        header.rentLink.click();
        return this;
    }

    @Step("click on category link")
    public HeaderSteps clickOnCategory() {
        header.categoryLink.click();
        return this;
    }

    @Step("hover on kveba element")
    public HeaderSteps hoverOnKvebaElement() {
        header.kvebaElement.hover();
        return this;
    }

    @Step("click on sushi element")
    public HeaderSteps clickOnSushiElement() {
        header.sushiElement.click();
        return this;
    }

    @Step("click on sign in link")
    public HeaderSteps clickOnSignIn() {
        header.signInLink.click();
        return this;
    }
}
