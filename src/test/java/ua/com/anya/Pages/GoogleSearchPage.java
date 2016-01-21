package ua.com.anya.Pages;

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

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }

    public void find(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public SeleniumPage openLink(int number){
        results.get(number).findElement(By.cssSelector(".r>a")).click();
        return new SeleniumPage(driver);
    }
}