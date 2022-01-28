Feature: BookShelf Tests

  Scenario: Find books by author should return one suitable book
    Given the bookshelf contains 2 books
    When the user searches the bookshelf by author "Test"
    Then the bookshelf should return a list of 1 book with the corresponding author

  Scenario: Find books by author should return no book if not suitable
    Given the bookshelf contains 2 books
    When the user searches the bookshelf by author "J.R.R Tolkien"
    Then the bookshelf should return a list of 0 book with the corresponding author