package com.MyProject.hooks;

import com.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class SeleniumHooks {

    private static WebDriver driver;

    @Before("@selenium")
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After("@selenium")
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

