package ua.com.anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchPage {

    WebDriver driver;

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(css = ".srg>.g")
    public List<WebElement> results;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void ensureGooglePageIsOpened(){
        if (!"Google".equals(driver.getTitle())) {
            driver.get("https://www.google.com/ncr");
        }
    }

    public void search(String text){
        searchField.sendKeys(text + Keys.ENTER);
    }

    public void openNthLink(int number){
        results.get(number).findElement(By.cssSelector(".r>a")).click();
    }

}

