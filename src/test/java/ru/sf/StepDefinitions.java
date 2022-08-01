package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    static final WebDriver webDriver;
    static final ChooseCityPage chooseCityPage;
    static final CityMenuPage cityMenuPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\izmachka\\Desktop\\cc-scenario\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);

    }


    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        chooseCityPage.go(url);
    }
    @Then("choose city {string}")
    public void choose_city(String city) {
        chooseCityPage.searchCity(city);
    }
    @Then("assert that choosen city is {string}")
    public void assert_that_choosen_city_is(String expectedCity) {
        final var currentActiveCity = cityMenuPage.getCurrentActiveCity();
        assertEquals(expectedCity, currentActiveCity);
    }
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var cityNotFoundMessage = chooseCityPage.getCityNotFoundMessage();
        assertEquals(errorMessage, cityNotFoundMessage);
    }
    @Then("choose button {string}")
    public void choose_button(String sign_in) {
        final var searchInput = webDriver.findElement(By.xpath("/html/body/div[3]/header/div[2]/button"));
        searchInput.sendKeys(sign_in, Keys.ENTER);
    }
    @Then("user enters login {string}")
    public void user_enters_login(String login) {
        final var searchInput = webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/label/div/input"));
        searchInput.sendKeys(login, Keys.ENTER);
    }
    @Then("assert the button is orange and push {string}")
    public void assert_the_button_is_orange_and_push(String button) {
        final var searchInput = webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/button"));
        searchInput.sendKeys(button, Keys.ENTER);
    }
    @Then("user got message {string}")
    public void user_got_message(String confirmMessage) {
        final var actualMessage = webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/h1")).getText();
        assertEquals(confirmMessage, actualMessage);
    }
    @Then("assert the button is grey and do not push {string}")
    public void assert_the_button_is_grey_and_do_not_push(String errorButton) {
        final var actualMessage = webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/button"));
    }
}



