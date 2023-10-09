package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SignUpPage;

public class SignUpSteps {
    SignUpPage signUpPage = new SignUpPage();

    @Step("click on register")
    public SignUpSteps clickOnRegister() {
        signUpPage.registerLink.click();
        return this;
    }

    @Step("set first name: {firstName}")
    public SignUpSteps setFirstName(String firstName) {
        signUpPage.firstNameInput.setValue(firstName);
        return this;
    }

    @Step("set last name: {lastName}")
    public SignUpSteps setLastName(String lastName) {
        signUpPage.lastNameInput.setValue(lastName);
        return this;
    }

    @Step("set email: {email}")
    public SignUpSteps setEmail(String email) {
        signUpPage.emailInput.setValue(email);
        return this;
    }

    @Step("set phone number: {phone}")
    public SignUpSteps setPhone(String phone) {
        signUpPage.phoneInput.setValue(phone);
        return this;
    }

    @Step("set date of birth: {dateOfBirth}")
    public SignUpSteps setDateOfBirth(String dateOfBirth) {
        signUpPage.dateOFBirthInput.sendKeys(dateOfBirth);
        return this;
    }

    @Step("set password: {password}")
    public SignUpSteps setPassword(String password) {
        signUpPage.passwordInput.setValue(password);
        return this;
    }

    @Step("set confirm password: {confirmPassword}")
    public SignUpSteps setConfirmPassword(String confirmPassword) {
        signUpPage.confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    @Step("accept terms and conditions")
    public SignUpSteps acceptTerms() {
        signUpPage.termsAgreeElement.click();
        return this;
    }

    @Step("click on register submit button")
    public SignUpSteps clickOnRegisterSubmitButton() {
        signUpPage.registerButton.click();
        return this;
    }

    @Step("validate error message")
    public SignUpSteps validateErrorMessage() {
        String actualErrorMessage = signUpPage.errorElement.getText();
        String expectedErrorMessage = "გთხოვთ აირჩიოთ სქესი!";

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        return this;
    }

}
