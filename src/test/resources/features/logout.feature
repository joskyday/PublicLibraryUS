@logout
Feature: As a User, I should be able to log out

  Background:
    Given that im logged in as a user
  @logout
  Scenario: Verify that the user can log out
    When the user clicks the username on top right corner of main page
    And the user clicks on Logout button on dropdown list
    Then the user should land on the login page
