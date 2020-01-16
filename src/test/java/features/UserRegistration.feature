Feature: User Registeration
        I want  to check theat the user can register in our e- commerece website
        
Scenario Outline: User Registeration
Given the user in the home page
When I click on register link
And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
Then  the registration page displayed successfully
Examples: 
 | firstname | lastname | email | password |
 | ahmed | mohamed | ahmed@test.com | 123456789 |
 | moataz| ahmed| test111@g.com| 5555555555258 | 