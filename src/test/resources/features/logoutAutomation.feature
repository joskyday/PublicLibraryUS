Feature: 

	#QA3
	@PUB-74 @smoke
	Scenario: Verfy that the user can log out Automation
		Given that im logged in as a user
		When the user clicks the username on top right corner of main page
		And the user clicks on Logout button on dropdown list
		Then the user should land on the login page