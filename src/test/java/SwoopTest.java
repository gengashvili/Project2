import data.UserData;
import data.UserDataProvider;
import org.testng.annotations.*;
import steps.*;
import utils.Helper;

import java.sql.Date;

import static com.codeborne.selenide.Selenide.*;

public class SwoopTest extends TestConfig {
    HeaderSteps headerSteps = new HeaderSteps();
    RentSteps rentSteps = new RentSteps();
    SushiOffersSteps sushiOffersSteps = new SushiOffersSteps();
    SushiSteps sushiSteps = new SushiSteps();
    DbSteps dbSteps = new DbSteps();
    SignUpSteps signUpSteps = new SignUpSteps();


    @Test(priority = 1)
    public void firstTest() {
        open("https://www.swoop.ge/");

        headerSteps.goToRentCategory();

        rentSteps
                .scrollToPriceContainer()
                .setMinPrice("200")
                .setMaxPrice("230")
                .clickOnSearchButton()
                .validateElementsPriceRange()
        ;
    }

    @Test(priority = 2)
    public void secondTest() {
        open("https://www.swoop.ge/");

        headerSteps
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

        headerSteps
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

        headerSteps
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

    @Test(priority = 5, dataProvider = "userDataProvider", dataProviderClass = UserDataProvider.class)
    public void fifthTest
            (
            String firstName,
            String lastName,
            String email,
            String phone,
            String dateOfBirth,
            String password
            )
    {
        dbSteps.insertNewUser();

        open("https://www.swoop.ge/");

        headerSteps.clickOnSignIn();

        signUpSteps
                .clickOnRegister()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setDateOfBirth(dateOfBirth)
                .setPassword(password)
                .setConfirmPassword(password)
                .acceptTerms()
                .clickOnRegisterSubmitButton()
                .validateErrorMessage()
        ;


    }

}
