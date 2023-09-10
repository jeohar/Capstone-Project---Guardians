Feature: Sign in Feature
Background: 
Given User is on retail website
When User click on Sign in option

@SignIn @Smoke
Scenario: Verify user can signin into Retail Application
	And User enter email 'johar@tekschool.us' and password 'Adieb@2016'
	And User click on login button
	Then User should be logged in into Account 

@CreateAccount @Smoke
Scenario: Verify user can create an account into Retail website
	And User click on Create New Account button
	And User fill the signUp information with below data
|name|email|password|confirmPassword|
|johnson|johsonla@outlook.com|Book@2023|Book@2023|
	And User click on SignUp button
	Then User should be logged into account page
	