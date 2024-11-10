Feature: Wishlist Functionalities

  Rule: User is not logged in
    Scenario: Heart icons are not visible to the user
      Given the user navigated to the "home" page
      Then there is a list of books displayed
      And heart icons are not displayed for each book in the list

  Rule: User is logged in
    Background:
      Given the user navigated to the "login" page
      And user is logged in with username "test222" and password "Password1"
      And the user navigated to the "wishlist" page
      And the wishlist is empty
      And the user navigated to the "home" page

    Scenario: Heart icons are visible to the user
      Then there is a list of books displayed
      And heart icons are displayed for each book in the list

    Scenario: Adding a book to wishlist from the list of books
      And the wishlist icon displays a count of 0
      When the user clicks the heart icon for the book titled "Harry Potter and the Order of the Phoenix" in the list of books
      Then a message box is shown with a message "Item added to your Wishlist"
      And the heart icon for the book "Harry Potter and the Order of the Phoenix" turns to "selected" state
      And the wishlist icon displays a count of 1
      When the user clicks the heart icon in the header
      Then the user is redirected to the wishlist page
      And the book "Harry Potter and the Order of the Phoenix" is listed in the wishlist

    Scenario: Removing a book from wishlist from the list of books
      And the wishlist icon displays a count of 0
      When the user clicks the heart icon for the book titled "Harry Potter and the Order of the Phoenix" in the list of books
      Then a message box is shown with a message "Item added to your Wishlist"
      And the heart icon for the book "Harry Potter and the Order of the Phoenix" turns to "selected" state
      And the wishlist icon displays a count of 1
      When the user clicks the heart icon for the book titled "Harry Potter and the Order of the Phoenix" in the list of books
      Then a message box is shown with a message "Item removed from your Wishlist"
      And the heart icon for the book "Harry Potter and the Order of the Phoenix" turns to "unselected" state
      And the wishlist icon displays a count of 0
      When the user clicks the heart icon in the header
      Then the user is redirected to the wishlist page
      And the book "Harry Potter and the Order of the Phoenix" is removed from the wishlist

    Scenario: Removing a book from the wishlist page
      When the user clicks the heart icon for the book titled "Harry Potter and the Order of the Phoenix" in the list of books
      Then a message box is shown with a message "Item added to your Wishlist"
      When the user clicks the heart icon in the header
      Then the user is redirected to the wishlist page
      And the book "Harry Potter and the Order of the Phoenix" is listed in the wishlist
      When user clicks the remove from wishlist button for the book "Harry Potter and the Order of the Phoenix"
      Then a message box is shown with a message "Item removed from your Wishlist"
      And the book "Harry Potter and the Order of the Phoenix" is removed from the wishlist

    Scenario: Clearing all books from the wishlist page
      When the user clicks the heart icon for the book titled "Harry Potter and the Order of the Phoenix" in the list of books
      Then a message box is shown with a message "Item added to your Wishlist"
      When the user clicks the heart icon for the book titled "Red Rising" in the list of books
      Then a message box is shown with a message "Item added to your Wishlist"
      When the user clicks the heart icon in the header
      Then the user is redirected to the wishlist page
      When the user clicks the clear wishlist button
      Then a message box is shown with a message "Wishlist cleared!!!"
      And all books in the wishlist are removed
      And the wishlist icon displays a count of 0