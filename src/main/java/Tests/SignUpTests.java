package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {

    @Test (priority = 10)
    public void visitsTheSignupPage () {
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] Page Url should contains 'signup' route.");
    }

    @Test (priority = 20)
    public void checksInputTypes () {
        navPage.getSignUpButton().click();
        Assert.assertEquals(signUpPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Email input should be 'email' by type");
        Assert.assertEquals(signUpPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Password input should be 'password' by type");
        Assert.assertEquals(signUpPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Confirmation password input should be 'password' by type");

    }
    @Test (priority = 30)
    public void displaysErrorsWhenUserAlreadyExists () {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] Page Url should contains '/signup' route.");

        signUpPage.getNameInput().sendKeys(name);
        signUpPage.getEmailInput().sendKeys(email);
        signUpPage.getPasswordInput().sendKeys(password);
        signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);

        signUpPage.getSignUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getMessageTextFromPopUp().getText().contains("E-mail already exists"),
                "[ERROR] The message from pop-up does not match with expected message");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] Page Url should contains '/signup' route.");
    }
    @Test(priority = 40)
    public void signup() {
        String name = "Lidija Milivojevic";
        String email = "lidija@gmail.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();

        signUpPage.getNameInput().sendKeys(name);
        signUpPage.getEmailInput().sendKeys(email);
        signUpPage.getPasswordInput().sendKeys(password);
        signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signUpPage.getSignUpButton().click();


        messagePopUpPage.waitForVerifyAcountPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getMessageTextFromVerifyAcountPopUp().getText(),
                "IMPORTANT: Verify your account",
                "The message from pop-up does not equals with expected result");

        messagePopUpPage.getCloseButtonFromVerifyAcountPopUp().click();

        navPage.getLogoutButton().click();
    }

}
