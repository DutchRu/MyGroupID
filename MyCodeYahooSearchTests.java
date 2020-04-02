package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyCodeYahooSearchTests {

    WebDriver driver;

    @DataProvider(name = "testsData")
    public Object[][] createData() {
        return new Object[][] {
                { "automation testing", "automation", "https://www.yahoo.com", "//input[@id='header-search-input']", "//span[contains(text(),' results')]" },
        };
    }

    @BeforeClass
    public void testSetup() {
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
    }

    @AfterMethod
    public void testEnd() {
        driver.close();
    }

    @Test(dataProvider = "testsData")
    public void test001(String param1, String param2, String urlPage, String inputXPath, String resultXPath) {
        openBrowser();
        navigateToMainPage(urlPage);
        typeQuery(param1, inputXPath);
        submitSearch(inputXPath);
        verifyResultsPage(resultXPath);
    }

    @Test(dataProvider = "testsData")
    public void test002(String param1, String param2, String urlPage, String inputXPath, String resultXPath) {
        openBrowser();
        navigateToMainPage(urlPage);
        typeQuery(param2, inputXPath);
        submitSearch(inputXPath);
        verifyResultsPage(resultXPath);
    }

    private void verifyResultsPage(String resultXPath) {
        WebElement element = waitForElement(By.xpath(resultXPath), 10);
        String elementText = element.getText();
        String[] splittedText = elementText.split(" ");
        String numberOfResults = splittedText[0].replace(",", "");
        int numberOfResINT = Integer.parseInt(numberOfResults);
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
        Assert.assertTrue(numberOfResINT > 100);
    }

    public WebElement waitForElement(By locator, int numberOfSeconds) {
        WebElement element = new WebDriverWait(driver, numberOfSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    private void submitSearch(String inputXPath) {
        driver.findElement(By.xpath(inputXPath)).submit();
    }

    private void typeQuery(String param1, String inputXPath) {

        WebElement element = driver.findElement(By.xpath(inputXPath));
        element.sendKeys(param1);
    }

    private void navigateToMainPage(String urlPage) {
        driver.get(urlPage);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }
}
