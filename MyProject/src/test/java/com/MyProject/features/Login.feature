Feature: Login Functionality

  Scenario: Successful login with standard_user
    Given user opens the browser
    When user navigates to "https://www.saucedemo.com/"
    And user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then user should see the products page