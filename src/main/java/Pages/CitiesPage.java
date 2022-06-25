package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class CitiesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }

    public void waitForEditPopUpToAppear(){
        this.wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
    public void waitForEditPopUpToDisappear(){
        this.wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public WebElement getNewItemInput(){
        return driver.findElement(By.id("name"));
    }

    public void waitForDeletePopUpToAppear(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//*[text() = 'Do you really want to delete this item?']")));
    }

    public WebElement getSaveButtonInEditPopUp(){
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getDeleteButtonInDeletePopUp(){
        return driver.findElement(By.xpath("//span[contains(text(), ' Delete')]"));
    }

    public void waitForNumOfRowsToBe(int numOfRows) {
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.tagName("tr"), numOfRows + 1));
    }

    public WebElement getCellFromRow (int row, int cell){
        return driver.findElement(By
                .xpath("//tbody/tr[" + row + "]/td[" + (cell + 1) + "]"));
    }

    public WebElement getEditButtonFromRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'edit']"));
    }

    public WebElement getDeleteButtonFromRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'delete']"));
    }
}
