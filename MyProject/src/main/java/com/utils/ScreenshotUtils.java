package com.utils;

import com.microsoft.playwright.Page;
import java.util.Base64;

public class ScreenshotUtils {
    public static String captureScreenshot(Page page) {
        try {
            byte[] screenshotBytes = page.screenshot(
                    new Page.ScreenshotOptions().setFullPage(true)
            );
            return Base64.getEncoder().encodeToString(screenshotBytes);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}
