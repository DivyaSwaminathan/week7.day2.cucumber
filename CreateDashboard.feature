Feature: Create Dashborad in Salesforce Application

Background: Positive Login
Given Type Username as 'radha1sahu2@gmail.com'
And Type Password as 'Shastik@june19'
When click on Login
Then Display salesforce homepage

Scenario Outline: Cerate New DashBoards with differnt sets of data
Given click on toggle menu from left corner
And click on view all link
And click Dashborad link from the app launcher 
And click New Dashboard option
When Type the name as <name>
And Click on Create button
And Click on Done button
Then Verify Dashboard created with name as <name>

Examples:
|name|
|Salesforce Dashboard Automation by Divya|
|Salesforce Dashboard Automation by Priya|