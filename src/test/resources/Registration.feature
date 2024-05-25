Feature: Registration Functionality

  Background: 
    Given navigate to home page

  Scenario: Register account with valid details
    When click on register option from aside menu
    When enter the following details
      | first_Name | last_Name | email        | telephone  | password  | confirm_password |
      | priya      | prasad    | dynamicvalue | 1234567890 | Test@1234 | Test@1234        |
    And click on Subscribe option
    And click on accept privacy button
    When click on continue button
    Then user should be able to successfully create account

  Scenario: Register account with empty email and all other fields are valid
    When click on register option from aside menu
    When enter the following details
      | first_Name       | priya      |
      | last_Name        | prasad     |
      | telephone        | 1234567890 |
      | email            | empty      |
      | password         | Test@1234  |
      | confirm_password | Test@1234  |
    And click on Subscribe option
    And click on accept privacy button
    Then User should not be able to create account


  Scenario: Register account with all empty fields
    When click on register option from aside menu
    When click on continue button
    Then first name error label should be displayed
    Then last name error label should be displayed
    Then email error label should be displayed
    Then telephone error label should be displayed
    Then password error label should be displayed

 
  Scenario: Registration page should contain below labels
    When click on register option from aside menu
    Then 'Your Personal Details' text should be present
    Then 'Register Account' title should be present
    Then 'Your Password' text should be present
    Then 'Newsletter' text should be present
    Then 'I have read and agree to the Privacy Policy ' text should be present

  @registration
  Scenario: login and privacy link should navigate to respective pages
    When click on register option from aside menu
    Then login link should be displayed with following colour code '#23a1d'
    When click on login link from header
    Then login page should display with page title as Account Login
    When click on register option from aside menu
    When click on privacy policy link above to submit button
    Then privacy policy alert window should get displayed
    And click on close from alert window
    
    
