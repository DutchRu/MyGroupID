package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTests {

    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void test0001() {
        openBrowser();
        driver.get("https://the-internet.herokuapp.com/login");
//  1. Single Slash (Absolute XPath):
        String absXPath = "/html/body/div[2]/div/div/form/div[1]/div/input";
//  2. Double Slash (Relative XPath):
        String relXPath = "//form/div[1]/div/input";
/*  Dynamic XPath
    3. Single Attribute:
    //<HTML tag>[@attribute_name='attribute_value']
    or
    //*[@attribute_name='attribute_value'] */
        String xPath01 = "//input[@name='username']";
/*  4. Multiple Attribute:
    //<HTML tag>[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2’]
    or
    //*[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2’] */
        String xPath02 = "//input[@name='username'][@type='text']";
/*  5. Using AND:
    //<HTML tag>[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2’]
    or
    //*[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2’] */
        String xPath03 = "//input[@name='username' and @type='text']";
/*  6. Using OR:
    //<HTML tag>[@attribute_name1='attribute_value1' or @attribute_name2='attribute_value2]
    or
    //*[@attribute_name1='attribute_value1' or @attribute_name2='attribute_value2] */
        String xPath04 = "//input[@name='username' or @type='text']";
/*  7. contains():
    //<HTML tag>[contains(@attribute_name,'attribute_value')]
    or
    //*[contains(@attribute_name,'attribute_value') */
        String xPath05 = "//input[contains(@type,'word')]";
/*  8. starts-with():
    //<HTML tag>[starts-with(@attribute_name,'attribute_value')]
    or
    //*[starts-with(@attribute_name,'attribute_value') */
        String xPath06 = "//input[starts-with(@name,'user')]";
/*  9. text():
    //*[text()='Log In'] */
        String xPath07 = "//*[text()=' Login']";
/*  10. last():
    (//input[@type='text'])[last()] */
        String xPath08 = "(//input[@type='text'])[last()]";
/*  11. position():
    (//input[@type='text'])[position()=2]
    or
    (//input[@type='text'])[2] */
/*  12. Finding elements using index
    //label[2] */
        String xPath09 = "(//*[contains(@id,'yui')])[20]";
/*  13. following:
    By using this we could select everything on the web page after the closing tag of the current node
    //*[@id='FirstName']/following::input[@type='text'] */
        String xPath10 = "//*[@id='FirstName']/following::input[@type='text']";
/*  14. preceding:
    Selects all nodes that appear before the current node in the document,
    except ancestors, attribute nodes and namespace nodes
    //*[@id='LastName']//preceding::input[@type='text' */
        String xPath11 = "//*[@id='LastName']//preceding::input[@type='text']";
    }
}