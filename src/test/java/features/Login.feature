Feature: User Login

  Background:
    Given user navigated to the "login" page

  Scenario: Login attempt with empty fields
    When user enters a username "" on the login page
    And user enters a password "" on the login page
    And user clicks the login button
    Then username field displays the error message "Username is required" on the login page
    And password field displays the error message "Password is required" on the login page

  Scenario: Login attempt with valid username and invalid password
    When user enters a username "test222" on the login page
    And user enters a password "12345" on the login page
    And user clicks the login button
    Then user should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with invalid username and valid password
    When user enters a username "test999" on the login page
    And user enters a password "Password1" on the login page
    And user clicks the login button
    Then user should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with invalid username and invalid password
    When user enters a username "test999" on the login page
    And user enters a password "12345" on the login page
    And user clicks the login button
    Then user should see an error message "Username or Password is incorrect." on the login page

  Scenario: Login attempt with valid credentials
    When user enters a username "test222" on the login page
    And user enters a password "Password1" on the login page
    And user clicks the login button
    Then login is successful and user is redirected to home page