Feature: Login feature for salesforce application

Scenario: Positive Login
Given Type Username as 'radha1sahu2@gmail.com'
And Type Password as 'Shastik@june19'
When click on Login
Then Display salesforce homepage

Scenario: Negative Login
Given Type Username as 'testusr'
And Type Password as 'rest'
When click on Login
But Display error message 