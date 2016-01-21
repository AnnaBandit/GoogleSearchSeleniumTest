package ua.com.anya;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.anya.pages.GoogleSearchPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.sizeOf;

public class GoogleSearchTest {

    public static WebDriver driver;
    public GoogleSearchPage googleSearchPage;
    WebDriverWait wait = new WebDriverWait(driver, 1000);

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @Before
    public void createGooglePage(){
        googleSearchPage = GoogleSearchPage.load(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){
        googleSearchPage.find("Selenium automates browsers");
        wait.until(sizeOf(googleSearchPage.results, 10));
        wait.until(textToBePresentInElement(googleSearchPage.results.get(0), "Selenium automates browsers"));

        googleSearchPage.openLink(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }

}
