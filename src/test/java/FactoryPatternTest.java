import com.factory.DriverManager;
import com.factory.DriverManagerFactory;
import com.factory.DriverType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FactoryPatternTest {

    DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);

    WebDriver driver;

    @Before
    public void beforeTest() {
        driver = driverManager.getDriver();
    }


    @After
    public void afterTests() {
        driverManager.quitDriver();
    }


    @Test
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo", driver.getTitle());
    }

}