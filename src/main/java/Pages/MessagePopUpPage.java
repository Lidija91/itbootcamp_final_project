package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MessagePopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public void waitForPopUpToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public void waitForSuccessPopUpToBeVisible() {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getMessageTextFromSuccesPopUp() {
        return driver.findElement(By.className("success"));
    }

    public WebElement getMessageTextFromPopUp() {
        return driver.findElement(By.xpath("//*[@class = 'v-snack__content']/ul/li"));
    }

    public void getCloseButtonFromPopUp() {
        driver.findElement(By.xpath("//*[@class='v-snack__content']/button"));
    }

    public void waitForVerifyAcountPopUpToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }

    public WebElement getMessageTextFromVerifyAcountPopUp() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-card__title')]"));
    }

    public WebElement getCloseButtonFromVerifyAcountPopUp() {
        return driver.findElement(By.className("btnClose"));
    }
}

