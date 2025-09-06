package com.utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page getPage() {
        if (page == null) {
            playwright = Playwright.create();
            boolean headless = ConfigManager.isHeadless();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(headless)
            );

            context = browser.newContext();

            // Close default blank pages if any
            for (Page p : context.pages()) {
                if (p.url().equals("about:blank")) {
                    p.close();
                }
            }

            page = context.newPage();
        }
        return page;
    }

    public static void closePlaywright() {
        if (playwright != null) {
            if (page != null && !page.isClosed()) page.close();
            if (context != null) context.close();
            if (browser != null) browser.close();
            playwright.close();

            page = null;
            context = null;
            browser = null;
            playwright = null;
        }
    }
}
