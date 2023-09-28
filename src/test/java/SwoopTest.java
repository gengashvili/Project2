import org.testng.annotations.*;
import steps.HomeSteps;
import steps.RentSteps;

import static com.codeborne.selenide.Selenide.*;

public class SwoopTest extends TestConfig {
    HomeSteps homeSteps = new HomeSteps();
    RentSteps rentSteps = new RentSteps();


    @Test(priority = 1)
    public void firstTest() {
        open("https://www.swoop.ge/");

        homeSteps.goToRentCategory();
        rentSteps
                .setMinPrice("200")
                .setMaxPrice("230")
                .clickOnSearchButton();

    }

}
