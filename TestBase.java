package MyLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;
    GoogleMainPage mainPage;
    GoogleResultsPage resultsPage;

    @BeforeClass
    public void testSetup() {
        System.out.println("test setup");
// macOS or Windows to run right version of gecko driver:
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
        }
    }

    @BeforeMethod
    public void setupTest() {
        openBrowser();
        mainPage = new GoogleMainPage(driver);
        resultsPage = new GoogleResultsPage(driver);
    }

    @AfterMethod
    public void suitEnd() {
        driver.quit();
    }

    public void openBrowser() {
        driver = new FirefoxDriver();
    }

    public static WebElement waitForElement(WebDriver driver, By locator, int numberOfSeconds) {
        WebElement element = new WebDriverWait(driver, numberOfSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}
