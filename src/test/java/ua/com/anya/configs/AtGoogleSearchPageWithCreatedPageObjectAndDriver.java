package ua.com.anya.configs;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.pages.GoogleSearchPage;

public class AtGoogleSearchPageWithCreatedPageObjectAndDriver {

    public static WebDriver driver;
    public GoogleSearchPage googleSearchPage;
    public WebDriverWait wait = new WebDriverWait(driver, 1000);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @Before
    public void createAndLoadGooglePage(){
        googleSearchPage = GoogleSearchPage.ensureLoaded(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
