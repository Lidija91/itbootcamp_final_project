package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsPage {

    public void controlABackSpace(WebDriver driver){
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }
}
