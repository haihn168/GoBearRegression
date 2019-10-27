package com.gobear.auto;

import com.gobear.auto.PageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

public class HomepageSteps {
    private HomePage homePage;
    private TravelResultPage travelResultPage;
    private FilterComponent filterComponent;
    private SortComponent sortComponent;
    private DetailComponent detailComponent;

    public HomepageSteps() {
        this.homePage = new HomePage();
        this.travelResultPage = new TravelResultPage();
        this.filterComponent = new FilterComponent();
        this.sortComponent = new SortComponent();
        this.detailComponent = new DetailComponent();
    }

    @Given("^I am on Travel Insurance tab at Homepage$")
    public void i_am_on_Travel_Insurance_Homepage() {
        homePage.goToHomePage()
                .switchToTab("Insurance", "Travel");
    }

    @When("^I navigate to Travel Result Page$")
    public void i_navigate_to_Travel_ResultPage() {
        homePage.clickShowResultBtn();
        travelResultPage.isPageLoad();
    }

    @Then("^I should see at least \"([^\"]*)\" cards displayed$")
    public void i_should_see_at_least_3_cards(int numsCard) {
        travelResultPage.verifyNumberOfResultCards(numsCard);
    }

    @Then("^I should be able to select a \"([^\"]*)\" insurer$")
    public void i_should_be_able_to_select_Insurer(String insurer) {
        filterComponent.clickSeeMoreBtn()
                .selectInsurer(insurer);
    }

    @And("^I should be able to select \"([^\"]*)\" value$")
    public void i_should_be_able_to_select_personal_accident_value(String personalAccidentValue) {
        filterComponent.moveSlider(personalAccidentValue);
        //TODO Verify steps
    }

    @And("^I should be able to sort By Price Low to high$")
    public void i_should_be_able_to_sort_price_lowToHigh() {
        sortComponent.checkSortPriceLowToHigh()
                     .verifyPriceLowToHighIsSelected();
    }

    @And("^I should be able to select \"([^\"]*)\" destination$")
    public void i_should_be_able_to_select_destination(String destination) {
        detailComponent.selectDestination(destination)
                        .verifyDestination(destination);
    }

    @And("^I should be able to select Start date and End Date$")
    public void i_should_be_able_to_select_startDate_endDate() throws Exception {
        detailComponent.selectStartDate("2019", "Dec", "11")
                        .selectEndDate("2019", "Dec", "31");
        detailComponent.verifyStartDate("2019", "Dec", "11");
    }
}
