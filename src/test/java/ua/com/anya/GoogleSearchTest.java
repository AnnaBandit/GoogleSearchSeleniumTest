package ua.com.anya;

import org.junit.Test;
import ua.com.anya.configs.AtGoogleSearchPageWithCreatedPageObjectAndDriver;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;

public class GoogleSearchTest extends AtGoogleSearchPageWithCreatedPageObjectAndDriver {

    @Test
    public void testGoogleSearch(){
        googleSearchPage.find("Selenium automates browsers");
        wait.until(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"));
        assertTrue(googleSearchPage.results.size() == 10);

        googleSearchPage.openLink(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }
}
