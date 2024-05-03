Feature: Login Functionality
  
  Background: 
     Given user is on Login Page
	
	@login
	Scenario Outline: Valid Login
		When user entered username "<Email>"
		When user entered password "<Password>"
		Then user moves to puzzle solve page
		Examples:
		|Email|Password|
		|user@test.com|accjnscn|
		|user2@test.com|dsdffafs|
		
		
		
	Scenario Outline: Invalid Login
	    When user entered username "<Username>"
		Then user gets invalid credential error
		Examples:
		|Username|
		|testtest.com|
		|test2@test|
		
		
	