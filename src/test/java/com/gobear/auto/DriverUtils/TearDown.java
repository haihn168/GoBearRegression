package com.gobear.auto.DriverUtils;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class TearDown {
    private WebDriver driver;

    public TearDown() {
        this.driver = Setup.driver;
    }

    @After
    public void quitDriver() {
        this.driver.quit();
    }
}
