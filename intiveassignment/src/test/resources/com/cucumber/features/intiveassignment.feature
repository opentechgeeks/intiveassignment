@run
Feature: 

	Scenario Outline: Zoo Adoption
		Given The user navigates to Website "<URL>"		
		When the user enters "<Name>" in the text field
		Then The "<Name>" should be displayed below the text field.
		When the user clicks on Continue button
		Then the Select Animal page should be displayed
		When the user selects "<Animal>" from the dropdown
		When the user clicks on Continue button
		Then the Thank you confirmation page should be displayed
		And the "<successmessage>" should be displayed
		
		
		Examples:
			| Name | URL | Animal|successmessage|
		    | Ravikanth  | http://www.thetestroom.com/jswebapp/ |3|Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal.|
		    | Ravikanth  | http://www.thetestroom.com/jswebapp/ |2|Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal.|
		    

		    	