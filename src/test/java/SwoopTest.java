import data.UserData;
import utils.*;
import io.qameta.allure.*;
import org.testng.annotations.*;
import steps.*;


@Epic("final project 2")
@Listeners({ScreenshotListener.class})
public class SwoopTest extends TestConfig {
    HeaderSteps headerSteps = new HeaderSteps();
    RentSteps rentSteps = new RentSteps();
    SushiOffersSteps sushiOffersSteps = new SushiOffersSteps();
    SushiSteps sushiSteps = new SushiSteps();
    DbSteps dbSteps = new DbSteps();
    SignUpSteps signUpSteps = new SignUpSteps();


    @Test(priority = 1, groups = "Regression1", description = "Price Filter")
    @Description(
            "Go to „დასვენება“ \n" +
            "In &#39;ფასი&#39; element put range from 200 to 230 \n" +
            "Check that all returned elements on the first page are in selected range"
    )
    @Story("Verify that products within the specified price range are displayed on the first page.")
    @Feature("Filter Products by Price Range")
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

    @Test(priority = 2, groups = "Regression1", description = "Login and Voucher Validation")
    @Description(
            "Go to &quot;კატეგორიები&quot; \n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Try to add first returned item to favorites list and verify that Login Window has appeared\n"+
            "Check that the vouchers are not sold out"
    )
    @Story("Verify the functionality of adding an item to favorites and checking voucher availability.")
    @Feature("Verify Login Window and Voucher Availability")
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

    @Test(priority = 3,groups = "Regression2", description = "Price Sorting Validation")
    @Description(
            "Go to &quot;კატეგორიები&quot;\n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Sort elements with &quot;ფასით კლებადი&quot;\n"+
            "Check that the price of the first item is higher than the price of the second item"
    )
    @Story("Verify the sorting of products by price.")
    @Feature("Sort Products by Price and Validate")
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

    @Test(priority = 4, groups = "Regression2",  description = "Facebook Share and Login Window Validation")
    @Description(
            "Go to &quot;კატეგორიები&quot;\n"+
            "Hover on „კვება“ and click on &quot;სუში&quot;\n"+
            "Click on ‘გაზიარება’\n"+
            "Validate that window with Facebook login page has appeared"
    )
    @Story("Verify the functionality of sharing on Facebook.")
    @Feature("Validate Facebook Share and Login")
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

    @Test(priority = 5, groups = "Regression2", description = "User Registration Validation")
    @Description(
            "Generate data for new user and insert it into the database\n"+
            "Register for new account &#39;ფიზიკური პირი&#39;\n"+
            "Fill all mandatory fields, except Gender\n"+
            "Check that error message ‘გთხოვთ აირჩიოთ სქესი!’ is appear"
    )
    @Story("Verify user registration and error message display.")
    @Feature("Register New User and Validate error message")
    @Severity(SeverityLevel.NORMAL)
    public void fifthTest() {

        dbSteps.insertNewUser();
        UserData userData = dbSteps.getInsertedUserFromDb();
        dbSteps.deleteInsertedUser();

        headerSteps.clickOnSignIn();

        signUpSteps
                .clickOnRegister()
                .setFirstName(userData.getFirstName())
                .setLastName(userData.getLastName())
                .setEmail(userData.getEmail())
                .setPhone(userData.getPhone())
                .setDateOfBirth(Helper.formatSqlDate(userData.getDateOfBirth(), "MM-dd-yyyy"))
                .setPassword(userData.getPassword())
                .setConfirmPassword(userData.getPassword())
                .acceptTerms()
                .clickOnRegisterSubmitButton()
                .validateErrorMessage()
        ;

    }




}
