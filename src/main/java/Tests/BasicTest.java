package Tests;


import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected MessagePopUpPage messagePopUpPage;
    protected NavPage navPage;
    protected SignUpPage signUpPage;
    protected CitiesPage citiesPage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        citiesPage = new CitiesPage(driver);
        signUpPage = new SignUpPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @Test

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
