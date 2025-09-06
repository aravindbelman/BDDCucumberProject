package com.MyProject.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

    @CucumberOptions(
            features = "src/test/java/com/MyProject/features",
            glue = {"com.MyProject.stepDefinitions", "com.MyProject.hooks"},
            plugin = {"pretty", "html:target/cucumber-report.html"},
            tags = "@MultiUser and @selenium",
            monochrome = true
    )
    public class SeleniumTestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }

