Feature: Create Dashborad in Salesforce Application

Background: Positive Login
Given Type Username as 'radha1sahu2@gmail.com'
And Type Password as 'Shastik@june19'
When click on Login
Then Display salesforce homepage

Scenario Outline: Cerate New DashBoards with differnt sets of data
Given click on toggle menu from left corner
And click on view all link
And click sales link from the app launcher 
And click on Accounts tab
Given click on New
And type your name as <name>
And select ownership as public
When click on save for account
Then verify the account cerated successfully with <name>

Examples:
|name|
|Sunitha|
|Sidu|