@ApiTesting
Feature: Just a practice
@AccountCreation 
Scenario: User creating an account in IEB application 
Given User creating a new account in IEB app
Then Account should be created
And Validating the created account

@LoginAccount 
Scenario: User log in an account
Given User login a verified account
Then Account should be logged in successfully

@ViewAccount
Scenario: User view the created account
Given User submits the userID in the api
Then Account should be viewed

@ChangePassword
Scenario: User change the account password
Given User changes the password
Then Password should be updated

@CreatePost 
Scenario: User creates a new post
Given User creates a new post
Then Post should be created

@DeletePost 
Scenario: User deletes a post
Given User deletes a post
Then Post should be deleted

