package com.gobear.auto.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterComponent extends BasePage {

    public FilterComponent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "collapseSeemoreBtn")
    private WebElement btnSeeMore;
    @FindBy(id = "#gb-slider-1")
    private WebElement inputSliderNumber;
    @FindBy(css = "#gb-slider-1 ~ [class='value']")
    private WebElement txtDisplayedMinValue;
    @FindBy(css = "[#gb-slider-1 ~ [class='pull-right value']]")
    private WebElement txtDisplayedMaxValue;

    public WebElement getInsurerCheckBox(String insurerName) {
        String selector = String.format("div[data-filter-by='insurerId'] div[data-filter-name='%s']", insurerName);
        return driver.findElement(By.cssSelector(selector));
    }

    public FilterComponent selectInsurer(String insurerName) {
        getInsurerCheckBox(insurerName).click();
        return this;
    }

    public FilterComponent clickSeeMoreBtn() {
        wait.waitForElementClickable(btnSeeMore, "See more button");
        btnSeeMore.click();
        return this;
    }

    public WebElement getMinSlider(String sliderName) {
        String selector = String.format("//div[@id='collapseSeemore']//label[contains(text(),'%s')]/following-sibling::div//div[contains(@class,'min-slider-handle')]", sliderName);
        return driver.findElement(By.xpath(selector));
    }

    public WebElement getMaxSlider(String sliderName) {
        String selector = String.format("//div[@id='collapseSeemore']//label[contains(text(),'%s')]/following-sibling::div//div[contains(@class,'max-slider-handle')]", sliderName);
        return driver.findElement(By.xpath(selector));
    }

    public FilterComponent moveSlider(String sliderName) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(getMinSlider(sliderName),30,0).perform();
        action.dragAndDropBy(getMaxSlider(sliderName), -30, 0).perform();
        return this;
    }
}
