Feature: Validate the Values and Total Balance

Scenario: To verify the right count of values appear on the screen
	Given User navigates to test Url
	Then Ensure correct count of values appears on the screen
	Then Check the values on the screen are greater than Zero
	Then Verify Total balance is correct based on the values listed on the screen
	|1000000.00|
	Then Ensure values are formatted as currencies
	Then Verify Total balance matches the sum of the values