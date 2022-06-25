package Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[1]"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[2]"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[3]"));
    }
    public WebElement getAdminLink(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesLink(){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.linkText("Users"));
    }

    public WebElement getSignUpButton(){
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[4]"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[3]"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton(){
        return driver.findElement(By.className("f-gb"));
    }

    public WebElement getSpanishLanguageButton(){
        return driver.findElement(By.className("f-es"));
    }

    public WebElement getFrenchLanguageButton(){
        return driver.findElement(By.className("f-fr"));
    }

    public WebElement getChineseLanguageButton(){
        return driver.findElement(By.className("f-cn"));
    }
}
