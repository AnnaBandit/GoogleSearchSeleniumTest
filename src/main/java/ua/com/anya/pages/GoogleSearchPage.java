package ua.com.anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GoogleSearchPage {

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public By getNthResult(int resultNumber){
        return By.cssSelector(".srg .g:nth-child(" + resultNumber + ")");
    }

    public static GoogleSearchPage ensureLoaded(WebDriver driver){
        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
        return googleSearchPage;
    }

    public void find(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public void openLink(int number){
        results.get(number).findElement(By.cssSelector(".r>a")).click();
    }
}

