package MyLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {
    WebDriver driver;
    String locatorCSS = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
    String url = "https://www.google.com/";

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void typeQuery(String param1) {
        WebElement element = driver.findElement(By.cssSelector(locatorCSS));
        element.sendKeys(param1);
    }

    public void submitSearch() {
        driver.findElement(By.cssSelector(locatorCSS)).submit();
    }
}
