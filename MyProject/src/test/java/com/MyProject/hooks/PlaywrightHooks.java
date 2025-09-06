package com.MyProject.hooks;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.utils.ExtentTestManager;
import com.utils.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class PlaywrightHooks {
    private static Page page;

    @Before("@playwright")
    public void setUp(Scenario scenario) {
        page = PlaywrightFactory.getPage();
        ExtentTestManager.startTest(scenario.getName(), "Executing Playwright Scenario");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started: " + scenario.getName());
    }

    @After("@playwright")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario failed: " + scenario.getName());
            PlaywrightFactory.closePlaywright();
        } else {
            ExtentTestManager.getTest().pass("Scenario passed: " + scenario.getName());
            PlaywrightFactory.closePlaywright();
        }
        ExtentTestManager.endTest();
    }

    public static Page getPage() {
        return page;
    }
}
