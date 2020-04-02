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


public class MyCodeBingSearchTests {

    WebDriver driver;

    @DataProvider(name = "testsData")
    public Object[][] createData() {
        return new Object[][] {
                { "automation testing", "automation", "https://www.bing.com", "#sb_form_q", "#b_tween > span.sb_count" },
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
    public void test001(String param1, String param2, String urlPage, String locatorCSS, String resultLocator) {
/*        String param1 = "automation testing";
        String urlPage = "https://www.bing.com";
        String locatorCSS = "#sb_form_q";
        String resultLocator = "#b_tween > span.sb_count"; */
        openBrowser();
        navigateToMainPage(urlPage);
        typeQuery(param1, locatorCSS);
        submitSearch(locatorCSS);
        verifyResultsPage(resultLocator);
    }

    @Test(dataProvider = "testsData")
    public void test002(String param1, String param2, String urlPage, String locatorCSS, String resultLocator) {
/*        String param2 = "automation";
        String urlPage = "https://www.bing.com";
        String locatorCSS = "#sb_form_q";
        String resultLocator = "#b_tween > span.sb_count"; */
        openBrowser();
        navigateToMainPage(urlPage);
        typeQuery(param2, locatorCSS);
        submitSearch(locatorCSS);
        verifyResultsPage(resultLocator);
    }

    private void verifyResultsPage(String resultLocator) {
        WebElement element = waitForElement(By.cssSelector(resultLocator), 10);
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

    private void submitSearch(String locatorCSS) {
        driver.findElement(By.cssSelector(locatorCSS)).submit();
    }

    private void typeQuery(String param1, String locatorCSS) {

        WebElement element = driver.findElement(By.cssSelector(locatorCSS));
        element.sendKeys(param1);
    }

    private void navigateToMainPage(String urlPage) {
        driver.get(urlPage);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }
}