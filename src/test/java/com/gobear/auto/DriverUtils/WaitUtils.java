package com.gobear.auto.DriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private WebDriver driver;
    private static final int elementTimout = 5;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntil(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void waitForElementVisible(WebElement element, String elementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        String timeoutMessage = elementName + " isn't displayed after " + elementTimout + " seconds.";
        waitUntil(condition,timeoutMessage, elementTimout);
    }

    public void waitForElementNotVisible(WebElement element, String elementName) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOf(element);
        String timeoutMessage = elementName + " is still displayed after " + elementName + " seconds";
        waitUntil(condition,timeoutMessage, elementTimout);
    }

    public void waitForElementClickable(WebElement element, String elementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(element);
        String timeoutMessage = elementName + " isn't clickable after " + elementTimout + " seconds.";
        waitUntil(condition,timeoutMessage,elementTimout);
    }
}
