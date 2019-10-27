package com.gobear.auto.PageObjects;

import com.gobear.auto.DriverUtils.Setup;
import com.gobear.auto.DriverUtils.WaitUtils;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new WaitUtils(this.driver);
    }
}
