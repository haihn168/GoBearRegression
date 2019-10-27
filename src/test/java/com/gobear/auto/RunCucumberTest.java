package com.gobear.auto;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/gobear/auto/",
        plugin = {"pretty"},
        glue = {"com.gobear.auto"}
        )
public class RunCucumberTest {

}
