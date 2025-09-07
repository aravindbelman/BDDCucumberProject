package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    public static ExtentReports createInstance(String scenarioName) {
        // reports/scenarioName/extent-report.html
        String reportPath = System.getProperty("user.dir")
                + "/reports/" + scenarioName + "/extent-report.html";

        // Create folder if not exists
        new File(System.getProperty("user.dir") + "/reports/" + scenarioName).mkdirs();

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("BDD Cucumber Test Execution - " + scenarioName);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Framework", "BDD Cucumber TestNG");
        extent.setSystemInfo("Author", "Aravind Belman");

        return extent;
    }
}
