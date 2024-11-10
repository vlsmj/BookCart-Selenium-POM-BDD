Feature: Order Summary and Placing an Order
  Rule: User is not logged in
    Scenario: Checkout attempt when user is not logged in
      Given the user navigated to the "home" page
      When the user clicks add to cart button for the book titled "Slayer" on the home page
      And the user navigated to the "cart" page
      And the user clicks the check out button
      Then the user is redirected to the login page

  Rule: User is logged in
    Background:
      Given the user navigated to the "login" page
      And user is logged in with username "test222" and password "Password1"
      And the user navigated to the "cart" page
      And the shopping cart is empty empty
      And the user navigated to the "home" page
      And the user clicks add to cart button for the book titled "Slayer" on the home page
      And the user clicks add to cart button for the book titled "Roomies" on the home page
      And the user navigated to the "cart" page

    Scenario: Checkout attempt when user is logged in
      When the user clicks the check out button
      Then the user is redirected to the checkout page
      And the order summary displays the book "Slayer" with quantity 1, price of "₹1,234.00", and total of "₹1,234.00"
      And the order summary displays the book "Roomies" with quantity 1, price of "₹334.00", and total of "₹334.00"
      And the order summary displays the grand total amount of "₹1,568.00"

    Scenario: Placing an order with empty fields
      And the user navigated to the "checkout" page
      When the user leaves empty inputs on the checkout page
      And the user clicks the place order button
      Then input field "Name" displays the error message "Name is required" on the checkout page
      And input field "Address Line 1" displays the error message "Address is required" on the checkout page
      And input field "Address Line 2" displays the error message "Address is required" on the checkout page
      And input field "Pin Code" displays the error message "Pincode is required" on the checkout page
      And input field "State" displays the error message "State is required" on the checkout page

    Scenario: Placing an order with a pin code of less than 6 digits
      And the user navigated to the "checkout" page
      When the user enter valid inputs on the checkout page
      And the user enters a pin code "12345" on the checkout page
      And the user clicks the place order button
      Then input field "Pin Code" displays the error message "Pincode must have 6 digits only and cannot start with 0" on the checkout page

    Scenario: Placing an order with a pin code of more than 6 digits
      And the user navigated to the "checkout" page
      When the user enter valid inputs on the checkout page
      And the user enters a pin code "1234567" on the checkout page
      And the user clicks the place order button
      Then input field "Pin Code" displays the error message "Pincode must have 6 digits only and cannot start with 0" on the checkout page

    Scenario: Placing an order with a pin code that starts with 0
      And the user navigated to the "checkout" page
      When the user enter valid inputs on the checkout page
      And the user enters a pin code "012345" on the checkout page
      And the user clicks the place order button
      Then input field "Pin Code" displays the error message "Pincode must have 6 digits only and cannot start with 0" on the checkout page

    Scenario: Successful order placement
      And the user navigated to the "checkout" page
      When the user enter valid inputs on the checkout page
      And the user clicks the place order button
      Then a message box is shown with a message "Order placed successfully!!!"
      And the user is redirected to the orders page
