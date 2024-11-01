#Feature: User Registration
#
#  Background:
#    Given User is on the registration page
#
#  Scenario: Registration attempt with empty fields and no selected gender
#    When User enters a first name ""
#    And User enters a last name ""
#    And User enters a username ""
#    And User enters a password ""
#    And User enters a confirm password ""
#    And User clicks the registration button
#    Then User should see an error message "Registration not successful."

#  Scenario: Empty input fields and no selected gender
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User clicks register button
#    Then First name field displays an error message indicating "First Name is required"
#    And Last name field displays an error message indicating "Last Name is required"
#    And Username field displays an error message indicating "User Name is required"
#    And Password field displays an error message indicating "Password is required"
#    And Confirm password field displays an error message indicating "Password is required"

#  Scenario: Username already exists
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters a first name "John"
#    And User enters a last name "Doe"
#    And User enters a username "test222"
#    And User enters a password "Password1"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password with less than 8 characters
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "1234567"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password without uppercase letter
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "password123"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password without lowercase letter
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "PASSWORD123"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password without number
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "Password"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password and confirm password do not match
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "Password123"
#    And User enters a confirm password "Password"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: Password and confirm password do not match
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User enters a password "Password123"
#    And User enters a confirm password "Password"
#    And User clicks register button
#    Then Username field displays an error message indicating "User Name is not available"
#
#  Scenario: User registers with valid inputs and selected gender
#    Given User navigates to "https://bookcart.azurewebsites.net/register"
#    When User enters valid details in all fields
#    And User clicks register button
#    Then User is navigated to the Login page

