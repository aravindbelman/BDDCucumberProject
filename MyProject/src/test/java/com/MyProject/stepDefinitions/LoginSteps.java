package com.MyProject.stepDefinitions;

import com.MyProject.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import saucedemo.PageMethods;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver = Hooks.getDriver();
    PageMethods pg= new PageMethods(driver);

    @Given("user opens the browser")
    public void user_opens_browser() {
        // Browser already opened in Hooks
    }

    @When("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    /*@When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @When("user clicks on login button")
    public void user_clicks_login() {
        driver.findElement(By.id("login-button")).click();
    }*/


    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        pg.enterUsername(username);
        pg.enterPassword(password);
    }
    @When("user clicks on login button")
    public void user_clicks_login() {
        pg.clicklogin();
    }
    @Then("user should see the products page")
    public void user_should_see_products_page() {
        assertTrue(driver.getTitle().contains("Swag Labs"), "Products page is not displayed");
    }
}

