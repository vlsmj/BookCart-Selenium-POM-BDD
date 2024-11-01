Feature: User Login

  Background:
    Given User is on the login page

  Scenario: Login attempt with empty fields
    When User enters a username "" on the login page
    And User enters a password "" on the login page
    And User clicks the login button
    Then Username field displays the error message "Username is required" on the login page
    And Password field displays the error message "Password is required" on the login page

  Scenario: Login attempt with valid username and invalid password
    When User enters a username "test222" on the login page
    And User enters a password "12345" on the login page
    And User clicks the login button
    Then User should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with invalid username and valid password
    When User enters a username "test999" on the login page
    And User enters a password "Password1" on the login page
    And User clicks the login button
    Then User should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with invalid username and invalid password
    When User enters a username "test999" on the login page
    And User enters a password "12345" on the login page
    And User clicks the login button
    Then User should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with valid credentials
    When User enters a username "test222" on the login page
    And User enters a password "Password1" on the login page
    And User clicks the login button
    Then Login is successful and user is redirected to home page