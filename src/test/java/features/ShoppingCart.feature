Feature: Shopping Cart Functionalities

  Scenario: Adding a book to the shopping cart from the list of books
    Given the user navigated to the "home" page
    And there is a list of books displayed
    And the shopping cart icon displays a count of 0
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    Then the shopping cart icon displays a count of 0
    When the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart with quantity 1

  Scenario: Increasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart with quantity 1
    When the user increases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 2
    And the price for the book "Slayer" is updated to reflect the new quantity

  Scenario: Decreasing the quantity of a book in the shopping cart
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart with quantity 1
    When the user increases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 2
    When the user increases the quantity of the book "Slayer" by 1
    Then the quantity of the book "Slayer" updates to 2
    And the price for the book "Slayer" is updated to reflect the new quantity

  Scenario: Verifying if the cart total displays the correct price
    When the user clicks add to cart button for the book titled "Slayer" in the list of books
    And the user clicks add to cart button for the book titled "Roomies" in the list of books
    And the user clicks the shopping cart icon
    Then the user is redirected to the shopping cart page
    And the book "Slayer" is listed in the shopping cart with quantity 1
    And the book "Roomies" is listed in the shopping cart with quantity 1
    When the user increases the quantity of the book "Roomies" by 1
    Then the quantity of the book "Roomies" updates to 2
    And the cart total displays the correct price