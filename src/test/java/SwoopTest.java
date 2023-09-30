import org.testng.annotations.*;
import steps.HomeSteps;
import steps.RentSteps;
import steps.SushiSteps;

import static com.codeborne.selenide.Selenide.*;

public class SwoopTest extends TestConfig {
    HomeSteps homeSteps = new HomeSteps();
    RentSteps rentSteps = new RentSteps();
    SushiSteps sushiSteps = new SushiSteps();


    @Test(priority = 1)
    public void firstTest() {
        open("https://www.swoop.ge/");

        homeSteps.goToRentCategory();

        rentSteps
                .setMinPrice("200")
                .setMaxPrice("230")
                .clickOnSearchButton();

    }

    @Test(priority = 2)
    public void secondTest() {
        open("https://www.swoop.ge/category/235/restornebi-da-barebi/sushi");

 /*       homeSteps
                .clickOnCategory()
                .hoverOnKvebaElement()
                .clickOnSushiElement()
        ;
*/
        sushiSteps.checkVouchersAreNotSoldOut();

    }

}
