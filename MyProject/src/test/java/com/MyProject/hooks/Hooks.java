package com.MyProject.hooks;

import com.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

