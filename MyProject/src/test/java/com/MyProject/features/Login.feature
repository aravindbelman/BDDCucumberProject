Feature: Login Functionality


  @SingleUser
  Scenario: Successful login with standard_user
    Given user opens the browser
    When user navigates to "https://www.saucedemo.com/"
    And user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then user should see the products page

  @MultiUser
 Scenario Outline: Successful login with standard_user
    Given user opens the browser
    When user navigates to "https://www.saucedemo.com/"
    And user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then user should see the products page
    Examples:
      | username                  | password      |
      | standard_user             | secret_sauce  |
      | problem_user              | secret_sauce  |
      | performance_glitch_user   | secret_sauce  |