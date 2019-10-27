package com.gobear.auto.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class DetailComponent extends BasePage {
    public DetailComponent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-gb-name='destinations'] button")
    private WebElement btnOpenDestinationDropdown;
    @FindBy(css = "[name = 'travel-form-country']")
    private WebElement listCountryDropdown;
    @FindBy(css = "div[data-gb-destination]")
    private WebElement displayedDestination;
    @FindBy(className = "add-field")
    private WebElement traveDateDiv;
    @FindBy(css = ".datepicker-days .datepicker-switch")
    private WebElement switchDatePicker;
    @FindBy(css = ".datepicker-months .datepicker-switch")
    private WebElement switchMonthPicker;
    @FindBy(css = ".datepicker-years .datepicker-switch")
    private WebElement switchYearPicker;
    @FindBy(name = "dates-startdate")
    private WebElement startDateField;
    @FindBy(name = "dates-enddate")
    private WebElement endDateField;

    public DetailComponent selectDestination(String destination) {
        WebElement countryOption = driver.findElement(By.xpath(String.format("//div[@data-gb-name='destinations']//ul/li[contains(.,'%s')]",destination)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listCountryDropdown);
        Actions action = new Actions(driver);
        action.moveToElement(endDateField)
                .sendKeys(Keys.ARROW_DOWN)
                .click(btnOpenDestinationDropdown)
                .sendKeys(destination)
                .click(countryOption)
                .build()
                .perform();

        return this;
    }

    public DetailComponent verifyDestination(String destination) {
        String actualDestination = displayedDestination.getAttribute("data-gb-destination");
        Assert.assertEquals(destination, actualDestination);
        return this;
    }

    public void verifyStartDate(String year, String month, String date) throws ParseException {
        String inputDate = String.format("%s-%s-%s",date,month,year);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date expectedDate = formatter.parse(inputDate);
        String strDate = startDateField.getAttribute("value");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
        Date actualDate = formatter2.parse(strDate);
        Assert.assertTrue(expectedDate.equals(actualDate));;
    }

    public void verifyEndDate(String year, String month, String date) throws ParseException {
        String inputDate = String.format("%s-%s-%s",date,month,year); //TODO Create convert method
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date expectedDate = formatter.parse(inputDate);
        String strDate = endDateField.getAttribute("value");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
        Date actualDate = formatter2.parse(strDate);
        Assert.assertTrue(expectedDate.equals(actualDate));;
    }

    public DetailComponent selectStartDate(String year, String month, String date) {
        Actions action = new Actions(driver);
        action.moveToElement(endDateField).perform();

        startDateField.click();
        selectFullDate(year, month, date);
        return this;
    }

    public DetailComponent selectEndDate(String year, String month, String date) {
        Actions action = new Actions(driver);
        action.moveToElement(endDateField).perform();

        endDateField.click();
        selectFullDate(year, month,date);
        return this;
    }

    private void selectFullDate(String year, String month, String date) {
        wait.waitForElementClickable(switchDatePicker,"Day Switcher");
        switchDatePicker.click();
        wait.waitForElementClickable(switchMonthPicker,"Month Switcher");
        switchMonthPicker.click();

        selectYear(year);
        selectMonth(month);
        selectDate(date);
    }

    private void selectDate(String date) {
        List<WebElement> currentMonthDay = driver.findElements(By.xpath("//div[@class = 'datepicker-days']//td[not(contains(@class,'old')) and not(contains(@class,'new'))] "));
        for (WebElement ele : currentMonthDay) {
            if (ele.getText().equals(date)) {
                wait.waitForElementClickable(ele,"Date");
                ele.click();
                break;
            }
        }
    }

    private void selectMonth(String month) {
        List<WebElement> listMonths = driver.findElements(By.cssSelector(".datepicker-months td span"));
        for (WebElement ele : listMonths) {
            if (ele.getText().equals(month)) {
                wait.waitForElementClickable(ele,"Month");
                ele.click();
                break;
            }
        }
    }

    private void selectYear(String year) {
        List<WebElement> listYears = driver.findElements(By.cssSelector(".datepicker-years td span"));
        for (WebElement ele : listYears) {
            if (ele.getText().equals(year)) {
                wait.waitForElementClickable(ele,"Year");
                ele.click();
                break;
            }
        }
    }
}

