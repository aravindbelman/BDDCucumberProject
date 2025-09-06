Feature: Login Functionality


  @SingleUser @selenium
  Scenario: Successful login with standard_user
    Given user opens the browser
    When user navigates to "https://www.saucedemo.com/"
    And user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then user should see the products page

  @MultiUser @selenium
  Scenario Outline: Successful login with standard_user
    Given user opens the browser
    When user navigates to "https://www.saucedemo.com/"
    And user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then user should see the products page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @SingleUser @playwright
  Scenario: Successful login with standard_user
    Given playwright user opens the browser
    When playwright user navigates to "https://www.saucedemo.com/"
    And playwright user enters username "standard_user" and password "secret_sauce"
    And playwright user clicks on login button
    Then playwright user should see the products page

  @MultiUser @playwright
  Scenario Outline: Successful login with standard_user
    Given playwright user opens the browser
    When playwright user navigates to "https://www.saucedemo.com/"
    And playwright user enters username "<username>" and password "<password>"
    And playwright user clicks on login button
    Then playwright user should see the products page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |