package com.MyProject.hooks;

import com.microsoft.playwright.Page;
import com.utils.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class PlaywrightHooks {
    private static Page page;

    @Before("@playwright")
    public void setUp() {
        page = PlaywrightFactory.getPage();
    }

    @After("@playwright")
    public void tearDown() {
        PlaywrightFactory.closePlaywright();
    }

    public static Page getPage() {
        return page;
    }
}
