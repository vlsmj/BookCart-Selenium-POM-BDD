Feature: Product Price and Product Details

  Background:
    Given user is on the Home page

  Scenario: Viewing the list of books
    Then there is a list of books displayed

  Scenario: Navigating to a book category
    Given there is a list of categories in the sidebar
    When user clicks the "Mystery" category in the sidebar
    Then there is a list of books displayed

  Scenario: Using the price filter
    When user sets the maximum price to 611
    Then there is a list of books displayed
    And the lowest priced book is 111
    And the maximum priced book is less than or equal to 611