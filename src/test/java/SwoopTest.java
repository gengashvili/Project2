import data.UserDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.*;
import steps.*;


@Epic("final project 2")
public class SwoopTest extends TestConfig {
    HeaderSteps headerSteps = new HeaderSteps();
    RentSteps rentSteps = new RentSteps();
    SushiOffersSteps sushiOffersSteps = new SushiOffersSteps();
    SushiSteps sushiSteps = new SushiSteps();

    DbSteps dbSteps = new DbSteps();
    SignUpSteps signUpSteps = new SignUpSteps();


    @Test(priority = 1)
    @Description(
            "Go to „დასვენება“ \n" +
            "In &#39;ფასი&#39; element put range from 200 to 230 \n" +
            "Check that all returned elements on the first page are in selected range"
    )
    @Story("first test story")
    @Feature("price range validation")
    @Severity(SeverityLevel.NORMAL)
    public void firstTest() {

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
    @Description(
            "Go to &quot;კატეგორიები&quot; \n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Try to add first returned item to favorites list and verify that Login Window has appeared\n"+
            "Check that the vouchers are not sold out"
    )
    @Story("second test story")
    @Feature("login window appearance and vouchers validation")
    @Severity(SeverityLevel.NORMAL)
    public void secondTest() {

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
    @Description(
            "Go to &quot;კატეგორიები&quot;\n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Sort elements with &quot;ფასით კლებადი&quot;\n"+
            "Check that the price of the first item is higher than the price of the second item"
    )
    @Story("third test story")
    @Feature("price sorting validation")
    @Severity(SeverityLevel.NORMAL)
    public void thirdTest() {

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
    @Description(
            "Go to &quot;კატეგორიები&quot;\n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Click on ‘გაზიარება’\n"+
            "Validate that window with Facebook login page has appeared"
    )
    @Story("fourth test story")
    @Feature("share and facebook login appearance validation")
    @Severity(SeverityLevel.NORMAL)
    public void fourthTest() {

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
    @Description(
            "Generate data for new user and insert it into the database\n"+
            "Register for new account &#39;ფიზიკური პირი&#39;\n"+
            "Fill all mandatory fields, except Gender\n"+
            "Check that error message ‘გთხოვთ აირჩიოთ სქესი!’ is appear"
    )
    @Story("fifth test story")
    @Feature("user registration validation")
    @Severity(SeverityLevel.NORMAL)
    public void fifthTest(
            String firstName,
            String lastName,
            String email,
            String phone,
            String dateOfBirth,
            String password
    ) {

        dbSteps.insertNewUser();

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
