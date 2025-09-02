package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;

public class DriverFactory {

        private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            // Headless mode for CI/CD (GitHub Actions Linux)
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            try {
                // Create a unique temporary directory for user data
                Path tempDir = Files.createTempDirectory("chrome-user-data");
                options.addArguments("--user-data-dir=" + tempDir.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            driver = new ChromeDriver(options);
        }
        return driver;
    }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

