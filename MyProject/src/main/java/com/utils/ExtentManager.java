package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/target/extent-reports/extent-report.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("BDD Cucumber Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "BDD Cucumber TestNG");
            extent.setSystemInfo("Author", "Aravind Belman");
        }
        return extent;
    }
}
