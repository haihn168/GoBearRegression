package com.gobear.auto.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "https://www.gobear.com/ph?x_session_type=UAT";

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='#Insurance']")
    private WebElement tabInsurance;

    @FindBy(css = "a[href='#Travel']")
    private WebElement tabTravel;

    @FindBy(css = "button[name='product-form-submit']")
    private WebElement btnShowResult;


    public boolean isPageLoad() {
        wait.waitForElementVisible(btnShowResult, "Show Result button");
        return btnShowResult.isDisplayed();
    }

    public HomePage goToHomePage(){
        driver.get(HOME_PAGE_URL);
        Assert.assertTrue("Homepage is not loaded", isPageLoad());
        return this;
    }


    public HomePage switchToTab(String tabName, String childTab) {
        if (tabName.equals("Insurance")) {
            wait.waitForElementClickable(tabInsurance, "Insurance tab");
            tabInsurance.click();
            switch (childTab) {
                case "Travel":
                    wait.waitForElementClickable(tabTravel, "Travel Tab");
                    tabTravel.click();
                    break;
                case "Car":
                    //TODO
                    break;
            }
        }
        //TODO: Credit Cards and Loans
        return this;
    }

    public void clickShowResultBtn() {
        wait.waitForElementClickable(btnShowResult, "Show Result button");
        btnShowResult.click();
    }
}
