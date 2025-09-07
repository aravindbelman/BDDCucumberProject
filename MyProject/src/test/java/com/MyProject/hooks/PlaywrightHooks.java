package com.MyProject.hooks;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.utils.ExtentTestManager;
import com.utils.PlaywrightFactory;
import com.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
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

    @AfterStep
    public void afterStep(Scenario scenario) {
        String screenshotBase64 = ScreenshotUtils.captureScreenshot(page);
        if (screenshotBase64 != null) {
            ExtentTestManager.getTest()
                    .info("Step executed")
                    .addScreenCaptureFromBase64String(screenshotBase64, "Step Screenshot");
        }
    }

    @After("@playwright")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario failed: " + scenario.getName());
            String screenshotBase64 = ScreenshotUtils.captureScreenshot(page);
            if (screenshotBase64 != null) {
                ExtentTestManager.getTest()
                        .fail("Scenario failed: " + scenario.getName())
                        .addScreenCaptureFromBase64String(screenshotBase64, "Failure Screenshot");
            }
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
