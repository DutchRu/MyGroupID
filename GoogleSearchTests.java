package MyLab;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTests extends TestBase {

    @Parameters({"queryForSearch"})
    @Test
    public void test001Param(String param1) {
        mainPage.navigateTo();
        mainPage.typeQuery(param1);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                {"Portnov Computer School"},
                {"Portnov School"},
        };
    }

    @Test(dataProvider = "test1")
    public void test001(String queryText) {
        mainPage.navigateTo();
        mainPage.typeQuery(queryText);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }

    @Test
    public void test002() {
        String param1 = "portnov school";

        mainPage.navigateTo();
        mainPage.typeQuery(param1);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }
}
