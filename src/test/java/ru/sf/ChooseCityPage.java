package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChooseCityPage {

    private static final String SEARCH_FIELD_CLASS = "locality-selector-popup__search-input";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "locality-selector-popup__table-empty-text";
    private static final String ERROR_BUTTON_XPATH = "/html/body/div[4]/div/div[2]/div/div[3]/button";

    private final WebDriver webDriver;

    public ChooseCityPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.get(url);

    }

    public void searchCity(String city) {
        final var serchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        serchInput.sendKeys(city, Keys.ENTER);
    }
    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
}


