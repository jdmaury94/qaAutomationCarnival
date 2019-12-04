package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {

    @Given("Using {string} as main page")
    public void using_as_main_page(String url) {

    }

    @When("User search cruises to {string}")
    public void user_search_cruises_to(String string) {

    }

    @When("Sets duration from {int} to {int} days")
    public void sets_duration_from_to_days(Integer from, Integer to) {

    }

    @Then("Results should be displayed on a grid")
    public void results_should_be_displayed_on_a_grid() {

    }

    @Then("User will filter by price from {int} to {int} using slider Bar")
    public void user_will_filter_by_price_from_to_using_slider_Bar(int int1, int int2) {

    }

    @Then("User will sort by price")
    public void user_will_sort_by_price() {

    }

    @Given("User is in the results page {string}")
    public void user_is_in_the_results_page(String url) {

    }

    @When("User selects a cruise")
    public void user_selects_a_cruise() {

    }

    @Then("Itinerary page should load")
    public void itinerary_page_should_load() {

    }

    @Then("User should be able to read about each day")
    public void user_should_be_able_to_read_about_each_day() {

    }

    @Then("A book now button should be placed")
    public void a_book_now_button_should_be_placed() {

    }

    @After
    public void tearDown(){

    }

}
