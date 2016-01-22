package ua.com.anya;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.pages.GoogleSearchPage;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GoogleSearchTest {

    public static WebDriver driver;
    public GoogleSearchPage googleSearchPage = GoogleSearchPage.ensureLoaded(driver);
    WebDriverWait wait = new WebDriverWait(driver, 1000);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){
        googleSearchPage.find("Selenium automates browsers");
        wait.until(textToBePresentInElementLocated(googleSearchPage.getNthResult(1), "Selenium automates browsers"));
        assertTrue(googleSearchPage.results.size() == 10);

        googleSearchPage.openLink(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }
}
