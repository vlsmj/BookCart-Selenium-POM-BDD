Feature: Search Functionalities

  Background:
    Given the user navigated to the "home" page

  @firefox
  Scenario: Using the search bar to search for books based on the title
    When the user enters "Harry" in the search bar
    And the user pressed enter in the search bar
    Then there is a list of books displayed that contains "Harry" in the title

  @firefox
  Scenario: Using the search bar to search for books based on the author's name
    When the user enters "George R.R. Martin" in the search bar
    And the user pressed enter in the search bar
    Then there is a list of books displayed
    When the user clicks the first book in the list
    Then the user is redirected to the book details page
    And the author of the book displayed is "George R.R. Martin"