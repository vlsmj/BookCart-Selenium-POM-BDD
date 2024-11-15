Feature: Shopping Cart Functionalities

  Background:
    Given the user navigated to the "home" page
    And there is a list of books displayed

  Scenario: Adding a book to the shopping cart from the list of books
    And the shopping cart icon displays a count of 0
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the shopping cart icon displays a count of 1
    When the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart

  Scenario: Increasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When the user increases the quantity of the book "Slayer" by 1
    Then a message box is shown with a message "One Item added to cart"
    Then the quantity of the book "Slayer" updates to 2

  Scenario: Decreasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When the user increases the quantity of the book "Slayer" by 1
    Then a message box is shown with a message "One Item added to cart"
    And the quantity of the book "Slayer" updates to 2
    When the user decreases the quantity of the book "Slayer" by 1
    Then a message box is shown with a message "One Item removed from cart"
    And the quantity of the book "Slayer" updates to 1

  Scenario: Removing a book from the shopping cart list
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    When user clicks the delete item action for the book "Slayer"
    Then a message box is shown with a message "Product removed from cart"
    And the book "Slayer" is removed from the shopping cart list

  Scenario: Clearing all books from the shopping cart list
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    When the user clicks add to cart button for the book titled "Roomies" on the home page
    Then a message box is shown with a message "One Item added to cart"
    When the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    When the user clicks the clear cart button
    Then a message box is shown with a message "Cart cleared!!!"
    And all books in the shopping cart are removed
    And the shopping cart icon displays a count of 0

  Scenario: Verifying if the cart total displays the correct price
    When the user clicks add to cart button for the book titled "Slayer" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the user clicks add to cart button for the book titled "Roomies" on the home page
    Then a message box is shown with a message "One Item added to cart"
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart
    And the book "Roomies" is listed in the shopping cart
    When the user increases the quantity of the book "Roomies" by 1
    Then a message box is shown with a message "One Item added to cart"
    And the quantity of the book "Roomies" updates to 2
    And the price for the book "Roomies" amounts to "₹668.00"
    And the cart total price amounts to "₹1,902.00"
