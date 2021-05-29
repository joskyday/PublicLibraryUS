Feature: 

	
	@PUB-73 @smoke
	Scenario: verify Librarian can  login
		Given the user is on the login page
		When the user enters the librarian information
		Then the user should be able to login