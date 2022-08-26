Feature: Create Opportunity in Salesforce Application

Background: Positive Login
Given Type Username as 'radha1sahu2@gmail.com'
And Type Password as 'Shastik@june19'
When click on Login
Then Display salesforce homepage

Scenario Outline: Create New Opportunity with different sets of Data
Given click on toggle menu from left corner
And click on view all link
And click sales link from the app launcher 
And click on opportunities tab 
And click on New button
When Type the opportunity name as <name>
And select close date as today
And select the stage as need analysis 
When click on save for the new opportunity
Then verify opportunity created successfully with <name>

Examples:
|name|
|Salesforce Automation by Divya|
|Salesforce Automation by Radha|


Scenario: Create Opportunity without Mandatory Fields 
Given click on toggle menu from left corner
And click on view all link
And click sales link from the app launcher 
And click on opportunities tab 
And click on New button
And select close date as today
When click on save for the new opportunity
But Verify the error message is genearted 



