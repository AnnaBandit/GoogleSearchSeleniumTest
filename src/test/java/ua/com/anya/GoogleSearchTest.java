package ua.com.anya;

import org.junit.Test;
import ua.com.anya.configs.AtGoogleSearchPageWithCreatedPageObjectAndDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.sizeOf;

public class GoogleSearchTest extends AtGoogleSearchPageWithCreatedPageObjectAndDriver {

    @Test
    public void testGoogleSearch(){
        googleSearchPage.find("Selenium automates browsers");
        wait.until(listNthElementHasText(googleSearchPage.results, 0, "Selenium automates browsers"));
        wait.until(sizeOf(googleSearchPage.results, 10));

        googleSearchPage.openLink(0);
        wait.until(titleIs("Selenium - Web Browser Automation"));
    }
}
