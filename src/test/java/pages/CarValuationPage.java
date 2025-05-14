package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.Driver;

import java.util.HashMap;
import java.util.Map;

public class CarValuationPage extends BasePage {

    private static final By searchTextBox = By.id("subForm1");
    private static final By makeField = By.xpath("//td[text()='Make']/following-sibling::td");
    private static final By modelField = By.xpath("//td[text()='Model']/following-sibling::td");
    private static final By yearField = By.xpath("//td[text()='Year of manufacture']/following-sibling::td");

    public static Map<String, Map<String, String>> fetchedCarDetails = new HashMap<>();

    public void searchCarDetails(String reg) {
        try {
            String url = ConfigReader.getProperty("url");
            getUrl(url);

            searchElement(searchTextBox,reg);

            waitForElement(makeField, 10);

            Map<String, String> carDetails = new HashMap<>();
            carDetails.put("MAKE", getText(makeField));
            carDetails.put("MODEL", getText(modelField));
            carDetails.put("YEAR", getText(yearField));

            fetchedCarDetails.put(reg, carDetails);
        } catch (Exception e) {
            System.err.println("Failed for registration: " + reg + " due to: " + e.getMessage());
        }
    }
}