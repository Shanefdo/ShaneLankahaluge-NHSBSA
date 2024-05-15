package org.nhsjobs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SearchPage {

    private WebDriver driver;
    String validateJobTitle = "";

    //Locators from the page
    private By searchButtonLocator = By.id("search");
    private By whatInputLocator = By.id("keyword");
    private By whereInputLocator = By.id("location");
    private By distanceDropdownLocator = By.cssSelector("#distance option[value=\"20\"]");
    private By jobRefInputLocator = By.id("jobReference");
    private By employerInputLocator = By.id("employer");
    private By payRangeDropdownLocator = By.cssSelector("#payRange option[value=\"40-50\"]");
    private By sortResultsDropDown = By.cssSelector("#sort option[value=\"publicationDateDesc\"]");
    private By jobsResultsCountLocator = By.cssSelector("[data-test=\"search-result-query\"]");
    private By jobClosingDateLocator = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/ul/li[1]/div[3]/div[1]/ul/li[2]/strong\n");
    private By jobClosingDateLocatorSecond = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/ul/li[2]/div[3]/div[1]/ul/li[2]/strong\n");

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputJobTitle(String whatJobTitle) {
        WebElement inputWhat = driver.findElement(whatInputLocator);
        inputWhat.sendKeys(whatJobTitle);
        validateJobTitle = whatJobTitle;
    }

    public void inputLocation(String whereJobLocation) {
        WebElement inputWhere = driver.findElement(whereInputLocator);
        inputWhere.sendKeys(whereJobLocation);
    }

    public void selectDistanceWithinTwenty() {
        WebElement selectDistance = driver.findElement(distanceDropdownLocator);
        selectDistance.click();
    }

    public void inputJobReference(String jobRef) {
        WebElement inputJobRef = driver.findElement(jobRefInputLocator);
        inputJobRef.sendKeys(jobRef);
    }

    public void inputEmployerDetails(String employerDetails) {
        WebElement inputEmployer = driver.findElement(employerInputLocator);
        inputEmployer.sendKeys(employerDetails);
    }

    public void selectPayRangeFortyToFifty() {
        WebElement selectPayRange = driver.findElement(payRangeDropdownLocator);
        selectPayRange.click();
    }

    public void clickSearchButton() {
        WebElement searchClick = driver.findElement(searchButtonLocator);
        searchClick.click();
    }

    public void clickSortResultsButton() {
        WebElement sortResultsClick = driver.findElement(sortResultsDropDown);
        sortResultsClick.click();
    }

    public boolean checkJobsResultsVisible() {
        WebElement validateJobResults = driver.findElement(jobsResultsCountLocator);

        //Validating jobTitle with JobResults
        return Arrays.stream(validateJobResults.getText().split(" ")).filter(m->m.equalsIgnoreCase(validateJobTitle)).collect(Collectors.toList()).isEmpty();
    }

    public boolean validateReturnResultsOnDescOrder() {

        // Assuming two objects on the closing date
        WebElement jobClosingDateDateOne = driver.findElement(jobClosingDateLocator);
        WebElement jobClosingDateDateTwo = driver.findElement(jobClosingDateLocatorSecond);

        String date1 = String.valueOf(jobClosingDateDateOne.getText());
        String date2 = String.valueOf(jobClosingDateDateTwo.getText());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        LocalDate dateCon1 = LocalDate.parse(date1, formatter);
        LocalDate dateCon2 = LocalDate.parse(date2, formatter);

//        List<LocalDate> dateList = new ArrayList();
//        dateList.add(dateCon1);
//        dateList.add(dateCon2);

        if (dateCon1.isBefore(dateCon2) || dateCon1.equals(dateCon2)) {
            return true;
        } else {
            return false;
        }

//        LocalDate today = LocalDate.now();
//        LocalDate latestDate = null;
//
//        for (LocalDate date : dateList) {
//            if (latestDate == null || date.isAfter(latestDate)) {
//                latestDate = date;
//            }
//        }
//
//        LocalDate finalLatestDate = (latestDate != null && latestDate.isAfter(today)) ? latestDate : today;
    }
}
