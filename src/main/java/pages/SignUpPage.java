package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    public SelenideElement
            registerLink = $("p.register"),
            firstNameInput = $("#pFirstName"),
            lastNameInput = $("#pLastName"),
            emailInput =     $("#pEmail"),
            phoneInput = $("#pPhone"),
            dateOFBirthInput = $("#pDateBirth"),
            passwordInput = $("#pPassword"),
            confirmPasswordInput =  $("#pConfirmPassword"),
            termsAgreeElement = $("#pIsAgreeTerns"),
            registerButton = $("input[type='button'][value='რეგისტრაცია']"),
            errorElement = $("#physicalInfoMassage")
    ;
}
