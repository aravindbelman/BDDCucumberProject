package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    private static Map<Long, ExtentReports> extentMap = new HashMap<>();

    public static synchronized ExtentTest startTest(String testName, String desc) {
        // Create new report for this scenario
        ExtentReports extent = ExtentManager.createInstance(testName);

        // Store extent instance for this thread
        extentMap.put(Thread.currentThread().getId(), extent);

        // Create test node
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        ExtentReports extent = extentMap.get(Thread.currentThread().getId());
        if (extent != null) {
            extent.flush();
        }
    }
}
