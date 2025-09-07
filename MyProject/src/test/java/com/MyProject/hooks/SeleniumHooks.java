package com.MyProject.hooks;

import com.aventstack.extentreports.Status;
import com.utils.DriverFactory;
import com.utils.ExtentTestManager;
import com.utils.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class SeleniumHooks {

    private static WebDriver driver;

    @Before("@selenium")
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();
        ExtentTestManager.startTest(scenario.getName(), "Executing Playwright Scenario");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started: " + scenario.getName());;
    }

    @After("@selenium")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario failed: " + scenario.getName());
            DriverFactory.quitDriver();
        } else {
            ExtentTestManager.getTest().pass("Scenario passed: " + scenario.getName());
            DriverFactory.quitDriver();
        }
        ExtentTestManager.endTest();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

