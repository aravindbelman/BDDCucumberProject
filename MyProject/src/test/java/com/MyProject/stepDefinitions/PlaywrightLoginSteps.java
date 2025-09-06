package com.MyProject.stepDefinitions;

import com.MyProject.hooks.PlaywrightHooks;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import saucedemowithplaywright.PageMethods;

import static org.testng.Assert.assertTrue;

public class PlaywrightLoginSteps {
    Page page = PlaywrightHooks.getPage();
    PageMethods pg = new PageMethods(page);

    @Given("playwright user opens the browser")
    public void user_opens_browser() {
        // Browser opened in PlaywrightHooks
    }

    @When("playwright user navigates to {string}")
    public void user_navigates_to(String url) {
        page.navigate(url);
    }

    @When("playwright user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        pg.enterUsername(username);
        pg.enterPassword(password);
    }

    @When("playwright user clicks on login button")
    public void user_clicks_login() {
        pg.clicklogin();
    }

    @Then("playwright user should see the products page")
    public void user_should_see_products_page() {
        assertTrue(page.title().contains("Swag Labs"), "Products page is not displayed");
    }
}