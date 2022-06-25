package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage() {
        driver.navigate().to(baseUrl + "/login");

        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();

        navPage.getLoginButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page Url should contains '/login' ");
        }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Email input field should be 'email' by type");

        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Password input should be 'password' by type");
    }
    @Test (priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);

        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getMessageTextFromPopUp().getText().contains("User does not exists"),
                "The Pop-up message does not contain 'User does not exists' text");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page Url should contains '/login' route.");
    }

    @Test (priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getMessageTextFromPopUp().getText(),
                "Wrong password",
                "The Pop-up message does is not 'Wrong password' as expected");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page Url should contains '/login' route.");
    }

    @Test (priority = 50)
    public void logIn () {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[ERROR] Page Url should contains '/home' route.");
    }


    @Test (priority = 60)
    public void logOut () {
      Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
              "[ERROR] Log out button is not visible.");

      navPage.getLogoutButton().click();
    }




}
