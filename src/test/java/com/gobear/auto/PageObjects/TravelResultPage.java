package com.gobear.auto.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TravelResultPage extends BasePage {
    public TravelResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-gb-name='loading-status']")
    private WebElement icoLoadingStattus;
    @FindBy(css = "#travel-quote-list [data-gb-name='travel-plan']")
    private List<WebElement> listCards;

    public TravelResultPage isPageLoad() {
        wait.waitForElementNotVisible(icoLoadingStattus, "Loading Icon");
        Assert.assertFalse("Travel result page is not loaded completely",icoLoadingStattus.isDisplayed());
        return this;
    }

    public void verifyNumberOfResultCards(int expectedNumberOfcards) {
        Boolean result = false;
        if (listCards.size() > expectedNumberOfcards) {
            result = true;
        }
        Assert.assertTrue(String.format("Number of cards is less than %d",expectedNumberOfcards),result);
    }
}
