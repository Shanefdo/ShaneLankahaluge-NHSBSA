package org.nhsjobs.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.nhsjobs.faramework.core.BrowserManager;
import org.nhsjobs.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchPageStepsDefinition {

    private WebDriver driver;
    private SearchPage searchPage;


    /**
     * Initiating the browsers
     */
    @Before
    public void setup() {
        //Declaring browser list
        List<String> browserList = new ArrayList<>();
        browserList.add("chrome");
        browserList.add("firefox");

        for (String browserName : browserList) {
            driver = BrowserManager.startBrowser(browserName);
        }
    }


    @Given("I am a jobseeker on NHS Jobs website")
    public void i_am_a_jobseeker_on_nhs_jobs_website() {
        driver.get("https://www.jobs.nhs.uk/candidate/search");
        searchPage = new SearchPage(driver);
    }

    @When("I put my preferences into the Search functionality")
    public void i_put_my_preferences_into_the_search_functionality() {
        searchPage.inputJobTitle("dr");
        searchPage.inputLocation("London");
        searchPage.clickSearchButton();
    }

    @Then("I should get a list of jobs which matches my preferences")
    public void i_should_get_a_list_of_jobs_which_matches_my_preferences() {
        Assert.assertEquals(searchPage.checkJobsResultsVisible(), false);
    }

    @Then("sort my search results with the newest Date Posted")
    public void sort_my_search_results_with_the_newest_date_posted() {
        searchPage.clickSortResultsButton();
        //searchPage.validateReturnResultsOnDescOrder();
        Assert.assertEquals(searchPage.validateReturnResultsOnDescOrder(),true);
    }

    /**
     * Closing the browsers
     */
    @After
    public void tearDown() {
        if (driver != null) {
            BrowserManager.quitBrowser();
        }
    }
}
