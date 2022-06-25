package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class WaitersPage {

        private WebDriverWait wait;

        public WaitersPage(WebDriverWait wait) {
            this.wait = wait;
        }

        public void waitForURLToContain(String urlFraction){
            wait.until(ExpectedConditions.urlContains(urlFraction));
        }

        public void waitForInputAttributeToBe(String idLocator, String attribute, String value){
            wait.until(ExpectedConditions.attributeToBe(By.id(idLocator), attribute, value));
        }
    }
