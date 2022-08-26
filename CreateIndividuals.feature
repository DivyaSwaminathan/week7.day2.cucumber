Feature: Create Individuals in Salesforce Application

Background: Positive Login
Given Type Username as 'radha1sahu2@gmail.com'
And Type Password as 'Shastik@june19'
When click on Login
Then Display salesforce homepage

Scenario Outline: Cerate New Individual
Given click on toggle menu from left corner
And click on view all link
And click Individuals link from the app launcher 
And click dropdown from Individuals tab
And click on New Individual
And Enter the name as <name>
When click on save
Then Verify the Individual is created successfully 

Examples:
|name|
|Divya|
|Amala|