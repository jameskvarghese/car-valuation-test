package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class BasePage extends Driver {

    private final WebDriverWait wait;

    public BasePage() {
        initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void getUrl(final String url) {
        driver.get(url);
    }

    public void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void searchElement(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text + Keys.RETURN);
    }

    public void waitForElement(By locator, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        waitUntilVisible(locator);
        return driver.findElement(locator).getText();
    }

}
