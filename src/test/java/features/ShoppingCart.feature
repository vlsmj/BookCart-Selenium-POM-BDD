Feature: Shopping Cart Functionalities

  Scenario: Adding a book to the shopping cart from the list of books
    Given the user navigated to the "home" page
    And there is a list of books displayed
    And the shopping cart icon displays a count of 0
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    Then the shopping cart icon displays a count of 1
    When the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart

  Scenario: Increasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When the user increases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 2

  Scenario: Decreasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When the user increases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 2
    When the user decreases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 1

  Scenario: Verifying if the cart total displays the correct price
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks add to cart button for the book titled "Roomies" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    And the book "Roomies" is listed in the shopping cart
    When the user increases the quantity of the book "Roomies" by 1
    Then the quantity of the book "Roomies" updates to 2
    And the price for the book "Roomies" amounts to 668.00
    And the cart total price amounts to 1902.00

  Scenario: Removing a book from the shopping cart list
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When user clicks the delete item action for the book "Slayer"
    Then the book "Slayer" is removed from the list of books

  Scenario: Clearing all books from the shopping cart list
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks add to cart button for the book titled "Roomies" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    When the user clicks the clear cart button
    Then all books in the shopping cart are removed
