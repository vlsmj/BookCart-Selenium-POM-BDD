Feature: User Registration

  Background:
    Given the user navigated to the "registration" page

  Rule: Unsuccessful registration
    Scenario Outline: Registration attempt with empty fields and no selected gender
      When the user leaves empty inputs and no selected gender
      And the user clicks the register button
      Then input field "<input_field>" displays the error message "<error_message>" on the registration page
      Examples:
        | input_field      | error_message          |
        | First Name       | First Name is required |
        | Last Name        | Last Name is required  |
        | Username         | User Name is required  |
        | Password         | Password is required   |
        | Confirm Password | Password is required   |

    Scenario: Registration attempt with an existing username
      When the user enter valid inputs and selected a gender
      And the user enters a username "test222" on the registration page
      And the user clicks the register button
      Then input field "Username" displays the error message "User Name is not available" on the registration page

    Scenario: Registration attempt with a password with less than 8 characters
      When the user enter valid inputs and selected a gender
      And the user enters a password "1234567" on the registration page
      And the user enters a confirm password "1234567" on the registration page
      And the user clicks the register button
      Then input field "Password" displays the error message "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number" on the registration page

    Scenario: Registration attempt with a password without uppercase letter
      When the user enter valid inputs and selected a gender
      And the user enters a password "password1" on the registration page
      And the user enters a confirm password "password1" on the registration page
      And the user clicks the register button
      Then input field "Password" displays the error message "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number" on the registration page

    Scenario: Registration attempt with a password without lowercase letter
      When the user enter valid inputs and selected a gender
      And the user enters a password "PASSWORD1" on the registration page
      And the user enters a confirm password "PASSWORD1" on the registration page
      And the user clicks the register button
      Then input field "Password" displays the error message "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number" on the registration page

    Scenario: Registration attempt with a password without lowercase letter
      When the user enter valid inputs and selected a gender
      And the user enters a password "Password" on the registration page
      And the user enters a confirm password "Password" on the registration page
      And the user clicks the register button
      Then input field "Password" displays the error message "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number" on the registration page

    Scenario: Registration attempt with non-matching password and confirm password
      When the user enter valid inputs and selected a gender
      And the user enters a password "Password1" on the registration page
      And the user enters a confirm password "Password2" on the registration page
      And the user clicks the register button
      Then input field "Confirm Password" displays the error message "Password do not match" on the registration page

  Rule: Successful registration
    Scenario: Registration attempt with valid inputs and a selected gender
      When the user enter valid inputs and selected a gender
      And the user clicks the register button
      Then registration is successful and user is redirected to login page

