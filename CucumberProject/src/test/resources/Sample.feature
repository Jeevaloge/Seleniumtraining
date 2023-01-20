Feature: To validate the login functionality of myntra application

Scenario: To login with valid username and valid password
Given To launch the chrome browser and maximize window
And To launch the url of the myntra application
And To pass valid username in email field
And To pass invalid password in password field
And To click the login button
And To click on search label
And To search T-shirt product
And To select the 1st product
And To add product to bag
And To close the current tab
When To click on bag icon
Then To take the screenshot