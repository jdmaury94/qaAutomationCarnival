package steps;

import helpers.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.ResultsPage;

public class StepsDefinition extends Base {

    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;

    @Before
    public void setUp(){
        driver = getDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Given("Using {string} as main page")
    public void using_as_main_page(String url) {
        driver.get(url);
    }

    @When("User search cruises to {string}")
    public void user_search_cruises_to(String string) {
        homePage.selectSail(string);
    }

    @When("Sets duration from {int} to {int} days")
    public void sets_duration_from_to_days(Integer from, Integer to) {
        homePage.setDuration(from,to);
    }

    @Then("Results should be displayed on a grid")
    public void results_should_be_displayed_on_a_grid() {
        Assert.assertEquals(true,homePage.checkResultsOnGrid());
    }

    @Then("User will filter by price from {int} to {int} using slider Bar")
    public void user_will_filter_by_price_from_to_using_slider_Bar(int int1, int int2) {
        homePage.priceFilterClick();
        homePage.filterByPrice(int1,int2);
    }

    @Then("User will sort by price")
    public void user_will_sort_by_price() {
        Assert.assertEquals(true,homePage.checkOrderedPrices());
    }

    @Given("User is in the results page {string}")
    public void user_is_in_the_results_page(String url) {
        driver.get(url);
    }

    @When("User selects a cruise")
    public void user_selects_a_cruise() {
        resultsPage.selectRandomCruise();
    }

    @Then("Itinerary page should load")
    public void itinerary_page_should_load() {
        Assert.assertEquals(true,resultsPage.itineraryIsOpened());
    }

    @Then("User should be able to read about each day")
    public void user_should_be_able_to_read_about_each_day() {
        resultsPage.clickLearnMoreBtns();
    }

    @Then("A book now button should be placed")
    public void a_book_now_button_should_be_placed() {
        Assert.assertEquals(true,resultsPage.checkBookNowBtn());
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
