@addBook
Feature: Only librarians should be able to add books
  Description: The purpose of this feature is to test the add book functionality
Background:
  Given the user is on the login page
  @addBookWithLibrarian
  Scenario: Librarian users should be able to add books
    When the user enters the librarian information
    And the user navigate to Books module
    And the user click on Add Book button
    And fill the necessary input boxes with valid inputs "A Book Name" "2020" "1234567890"
    And the user click on Save Changes
    Then "The book has been created." message should be displayed

  @addBookWithStudent
  Scenario: Student users should NOT be able to add books
    When the user enters the student information
    And the user navigate to Books module
    Then Add Book button should NOT be seen on the page

  @verifyBookParameters @wip
  Scenario: Verify the book parameters in the Add Book Page
    When the user enters the librarian information
    And the user navigate to Books module
    And the user click on Add Book button
    Then following book parameters should be displayed on the table
      | Book Name     |
      | ISBN          |
      | Year          |
      | Author        |
      | Book Category |
      | Description   |

  @verifyBookCategories
  Scenario: Verify the book categories in the Add Book Page
    When the user enters the librarian information
    And the user navigate to Books module
    And the user click on Add Book button
    Then following book categories should be able to selected on the dropdown menu
      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |

    @verifyISBNRestrictions
    Scenario Outline: ISBN numbers should be 10 or 13 digits in length and consists of digits (0-9) and dashes (-)
      When the user enters the librarian information
      And the user navigate to Books module
      And the user click on Add Book button
      And fill the necessary input boxes with valid inputs "A Book Name" "2020" "<ISBN>"
      Then "<Expected Message>" message should be displayed
      Examples:
        | ISBN           | Expected Message           |
        | 123456789      | None                       |
        | 12345678901234 | None                       |
        | abcdefghij     | None                       |
        | 123456789/     | None                       |
        | 1234567890     | The book has been created. |
        | 1234567890123  | The book has been created. |
        | 123456789012-  | The book has been created. |

#      for merge practice