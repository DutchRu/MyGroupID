package day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDataProviderTest {
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "automation testing", "https://www.bing.com", "#sb_form_q", "#b_tween > span.sb_count" },
        };
    }

    @Test(dataProvider = "test1")
    public void verifyData1(String param1, String urlPage, String locatorCSS, String resultLocator) {
        System.out.println("param1        - " + param1);
        System.out.println("urlPage       - " + urlPage);
        System.out.println("locatorCSS    - " + locatorCSS);
        System.out.println("resultLocator - " + resultLocator);
    }
}
