Feature: Login Page Feature

Scenario Outline: Validating Login and Logout functionality with Registered credential

Given User is on the login page of MobilityX application
When  User logs into the Application by entering Username "<Username>", password "<Password>"
Then  User should navigate to the dashboard page of MobilityX application with same user "<UserProfile>"
And   User should be able to logout from the application by clicking on Logout button
       	 
Examples: 
      | Username                | Password   | UserProfile  |
      | rohit.sharma@intsof.com | relonetng1 | Rohit Sharma |
      | 92265testone            | relonetng  | Test One     |
      