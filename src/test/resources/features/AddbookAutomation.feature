Feature: 

	#Verify that Librarian can add book
	@PUB-67 @smoke
	Scenario: Verify that Librarian can add book
		
		    Given the user is on the login page
		    When the user enters the librarian information
		    And the user navigate to Books module
		    And the user click on Add Book button
		    And fill the necessary input boxes with valid inputs "A Book Name" "2020" "1234567890"
		    And the user click on Save Changes
		    Then "The book has been created." message should be displayed