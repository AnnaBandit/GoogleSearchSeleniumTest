package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CustomConditions{

    public static WebDriver driver;

    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return elements.get(index).getText().contains(expectedText);
                } catch (IndexOutOfBoundsException ex) {
                    return false;
                }
            }
        };
    }
}
