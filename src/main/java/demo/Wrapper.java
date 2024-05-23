package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import java.time.Duration;

public class Wrapper {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(Wrapper.class);

    public Wrapper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void openUrl(String url) {

        try {
            driver.get(url);
            logger.info("URL:" + url);
        } catch (Exception e) {
            logger.error("Failed to open the url" + url, e);
        }
    }

    public WebElement findElement(By locator) {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Found element:" + locator);
            return element;
        } catch (Exception e) {
            logger.error("Failed to find element" + locator, e);
            return null;
        }
    }

    public void clickElement(By locator) {
        try {

            findElement(locator).click();
            logger.info("Clicked element:" + locator);

        } catch (Exception e) {
            logger.error("Failed to click element" + locator, e);
        }

    }

    public void sendkeys(By input, String text) {
        try {
            WebElement element = findElement(input);
            if (element != null) {
                element.sendKeys(text);
                logger.info("Entered text ' " + text + " ' into the element:" + input);
            }
        } catch (Exception e) {

        }
    }
}