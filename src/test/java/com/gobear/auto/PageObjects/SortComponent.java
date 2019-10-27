package com.gobear.auto.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class SortComponent extends BasePage {
    public SortComponent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[value=premium-Asc] ~ label")
    private WebElement rdBtnPriceLowToHigh;
    @FindBy(css = "input[value=premium-Desc]")
    private WebElement rdBtnPriceHighToLow;
    @FindBy(id = "detailsHeading")
    private WebElement detailHeading;
    @FindBy(css = "[class~=sort-detail]")
    private WebElement sortDetailDiv;

    public SortComponent checkSortPriceLowToHigh() {
        Actions actions = new Actions(driver);
        actions.moveToElement(detailHeading)
                .perform();
        wait.waitForElementVisible(rdBtnPriceLowToHigh, "Sort Price low to high button");
        rdBtnPriceLowToHigh.click();
        return this;
    }

    public SortComponent checkSortPriceHighToLow() {
        Actions actions = new Actions(driver);
        actions.moveToElement(rdBtnPriceHighToLow)
                .sendKeys(Keys.ARROW_DOWN)
                .build()
                .perform();

        wait.waitForElementClickable(rdBtnPriceHighToLow, "Sort Price low to high button");
        rdBtnPriceHighToLow.click();
        return this;
    }

    public void verifyPriceLowToHighIsSelected() {
       String selectedOption = sortDetailDiv.getAttribute("value");
       Assert.assertEquals("premium-Asc",selectedOption);
    }
}
