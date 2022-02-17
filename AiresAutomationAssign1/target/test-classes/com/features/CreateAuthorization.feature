Feature: Create Authorization Feature
Description: The purpose of this feature is to test the transferee creation

Background:  Logging into MobilityX application with Client access
	Given User is already logged into MobilityX application with following credentials
       | rohit.sharma@intsof.com | relonetng1 | Rohit Sharma |


Scenario: Validating Transferee registration using Create an Authorization Link

Given User is on Authorization HomePage after clicking on Create Authorization button.
And   User create new transfer or assignment authorization by entering mandatory information on initiation form for authorization creation.
When  User click on Submit to Aires button
Then  User should navigate to the dashboard page of MobilityX application displaying submission success message

