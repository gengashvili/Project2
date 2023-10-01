import org.testng.annotations.*;
import steps.HomeSteps;
import steps.RentSteps;
import steps.SushiOffersSteps;
import steps.SushiSteps;

import static com.codeborne.selenide.Selenide.*;

public class SwoopTest extends TestConfig {
    HomeSteps homeSteps = new HomeSteps();
    RentSteps rentSteps = new RentSteps();
    SushiOffersSteps sushiOffersSteps = new SushiOffersSteps();
    SushiSteps sushiSteps = new SushiSteps();


    @Test(priority = 1)
    public void firstTest() {
        open("https://www.swoop.ge/");

        homeSteps.goToRentCategory();

        rentSteps
                .scrollToPriceContainer()
                .setMinPrice("200")
                .setMaxPrice("230")
                .clickOnSearchButton()
                .validateElementsPriceRange()
        ;
    }

    @Test(priority = 2, invocationCount = 10)
    public void secondTest() {
        open("https://www.swoop.ge/");

        homeSteps
                .clickOnCategory()
                .hoverOnKvebaElement()
                .clickOnSushiElement()
        ;
        sushiOffersSteps
                .addFirstItemToFavorites()
                .verifyLoginWindowAppearance()
                .checkVouchersAreNotSoldOut()
        ;
    }

    @Test(priority = 3)
    public void thirdTest() {
        open("https://www.swoop.ge/");

        homeSteps
                .clickOnCategory()
                .hoverOnKvebaElement()
                .clickOnSushiElement()
        ;

        sushiOffersSteps
                .sortElementsByPriceDecreasing()
                .verifyPrices()
        ;
    }

    @Test(priority = 4)
    public void fourthTest() {
        open("https://www.swoop.ge/");

        homeSteps
                .clickOnCategory()
                .hoverOnKvebaElement()
                .clickOnSushiElement()
        ;
        sushiOffersSteps.clickOnFirstOffer();

        sushiSteps
                .clickOnShare()
                .validateFacebookWindowAppeared()
        ;
    }


}
