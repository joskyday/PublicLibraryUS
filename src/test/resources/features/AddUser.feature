Feature: The purpose of this feature is to test the add user functionality

  Background:
    Given the user is on login page


  @addUserasaLibrarian @wip
  Scenario: Librarian should be able to add a new user
    When the user enters librarian credentials
    And the user navigates to the Users module
    And the user clicks on Add User button
    And fills the information needed on "Test User 23" "student123" "testuser123@gmail.com"
    And the user clicks on Save Changes
    Then the new user should show on the top of the list


  @addUserasaStudent
  Scenario: the user enters student credentials
    When the user enters the student credentials
    Then the Users module should not show on the Modules tab

  @verifythedatafornewuser @wip
  Scenario: Verify the data on the Add User Page
    When the user enters librarian credentials
    And the user navigates to Users module
    And the user clicks on Add User button
    Then the following data should be displayed
      |Full Name|
      |Password |
      |Email    |
      |User Group|
      |Status    |
      |Start Date|
      |End Date  |
      |Address   |